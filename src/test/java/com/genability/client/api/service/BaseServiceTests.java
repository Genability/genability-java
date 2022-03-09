package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.genability.client.api.GenabilityClient;
import com.genability.client.api.request.BaselineRequest;
import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.types.Account;
import com.genability.client.types.Baseline;
import com.genability.client.types.Profile;
import com.genability.client.types.PropertyData;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;
import com.genability.client.types.Tariff;

public class BaseServiceTests {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected static final GenabilityClient genabilityClient;
	protected static final AccountService accountService;
	protected static final AccountAnalysisService accountAnalysisService;
	protected static final ProfileService profileService;
	protected static final PropertyService propertyService;
	protected static final CalendarService calendarService;
	protected static final IncentiveService incentiveService;
	protected static final TerritoryService territoryService;
	protected static final TimeOfUseService touService;

	private static final ObjectMapper mapper;

	static {
		
		// Mapper object for de-serializing canned tests
		mapper = new ObjectMapper();
	    mapper.registerModule(new JodaModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    mapper.setSerializationInclusion(Include.NON_NULL);
		
		//
		// Very simple configuration of logging to console.
		//
		Logger logger = LoggerFactory.getLogger(BaseServiceTests.class);
		
		//
		// Very simple configuration of API keys etc.
		//
		Properties prop = new Properties();
		 
    	try {
    		//
    		//load the properties file from in the classpath
    		//
    		InputStream inputStream = BaseServiceTests.class.getClassLoader().getResourceAsStream("genability.properties");
			if (inputStream == null) {
				logger.error("Can't find genability.properties");
				throw new RuntimeException("Can't find genability.properties");
			}

			// Also try loading the (gitignore'd) local overrides
			InputStream localProps = BaseServiceTests.class.getClassLoader().getResourceAsStream("genability.local.properties");
			if (localProps != null) {
				inputStream = new SequenceInputStream(inputStream, localProps);
			}

    		prop.load(inputStream);
    	} catch (IOException ex) {
    		logger.error("Unable to process genability.properties", ex);
    		throw new RuntimeException(ex);
        }
 
  		//
        // get the properties and print them out
  		//
  		String appId = prop.getProperty("appId");
  		String appKey = prop.getProperty("appKey");
  		String restApiServer = prop.getProperty("restApiServer");
  		logger.info("appId: " + appId);
  		logger.info("appKey: " + appKey);
  		logger.info("restApiServer: " + restApiServer);
                if (appId == null || appId.trim().isEmpty() || appKey == null || appKey.trim().isEmpty()) {
                        logger.error("appId and appKey must be set");
                        throw new RuntimeException("Found one or more unset/empty properties");
                }

  		genabilityClient = new GenabilityClient(appId, appKey);
  		if (restApiServer != null && !restApiServer.equals("")) {
		    genabilityClient.setRestApiServer(restApiServer);
  		}
  		
  		accountService = genabilityClient.getAccountService();
		accountAnalysisService = genabilityClient.getAccountAnalysisService();
  		profileService = genabilityClient.getProfileService();
  		propertyService = genabilityClient.getPropertyService();
  		calendarService = genabilityClient.getCalendarService();
  		territoryService = genabilityClient.getTerritoryService();
  		touService = genabilityClient.getTimeOfUseService();
  		incentiveService = genabilityClient.getIncentiveService();
	}
	
	// Helper method:  We create an account and specify a tariff as well as values
	// for the tariff's properties.  We use masterTariffId 521 (PGE E-1) which for
	// calculations has one required property which is the territoryId.  
	// We also set the zipCode as an additional example.
	protected Account createAccount() {
		
		Account addAccount = new Account();
		addAccount.setAccountName("Java Client Lib Test Account - CAN DELETE");
		addAccount.setProviderAccountId("TEST-" + UUID.randomUUID());
		
		Map<String, PropertyData> properties = new HashMap<String, PropertyData>();
		
		PropertyData zipCodeData = new PropertyData();
		zipCodeData.setKeyName("zipCode");
		zipCodeData.setDataValue("94115");
		properties.put(zipCodeData.getKeyName(), zipCodeData);

		PropertyData territoryData = new PropertyData();
		territoryData.setKeyName("territoryId");
		territoryData.setDataValue("3538");
		properties.put(territoryData.getKeyName(), territoryData);

		addAccount.setProperties(properties);
		
		Tariff tariff = new Tariff();
		tariff.setMasterTariffId(521l);
		DateTime effDate = new DateTime(2012, 2, 1, 1, 0, 0, 0,DateTimeZone.forID("US/Pacific"));
		tariff.setEffectiveDate(effDate.toString());
		List<Tariff> tariffs = new ArrayList<Tariff>();
		tariffs.add(tariff);
		addAccount.setTariffs(tariffs);
							
		Response<Account> restResponse = accountService.addAccount(addAccount);
		
		assertNotNull("new account response is null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
		
		Account newAccount = null;
		for(Account account : restResponse.getResults()) {
			newAccount = account;
			assertNotNull("accountId null",account.getAccountId());
		}
		
		return newAccount;
	}
	
	protected Profile createProfile() {
		
		Account account = createAccount();
		Profile addProfile = new Profile();
		addProfile.setAccountId(account.getAccountId());
		addProfile.setProviderProfileId("TEST-" + UUID.randomUUID());
		Response<Profile> restResponse = profileService.addProfile(addProfile);
		
		assertNotNull("new Profile response is null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Profile.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
		
		Profile newProfile = null;
		for(Profile profile: restResponse.getResults()) {
			newProfile = profile;
			assertNotNull("profileId null", profile.getProfileId());
		}
		return newProfile;
	}

	protected Profile createProfileWithReadings(List<ReadingData> readings) {

		Account account = createAccount();
		Profile addProfile = new Profile();
		addProfile.setAccountId(account.getAccountId());
		addProfile.setReadingData(readings);

		Response<Profile> restResponse = profileService.addProfile(addProfile);

		assertNotNull("new Profile response is null", restResponse);
		assertEquals("bad status", restResponse.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), Profile.REST_TYPE);
		assertTrue("bad count", restResponse.getCount() > 0);

		Profile newProfile = null;
		for (Profile profile : restResponse.getResults()) {
			newProfile = profile;
			assertNotNull("profileId null", profile.getProfileId());
		}
		return newProfile;
	}

	// Delete the accounts we create to keep things clean; this also cleans up profiles
	// on the account
	protected void cleanup(String accountId) {
		DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest();
		deleteAccountRequest.setHardDelete(Boolean.TRUE);
		deleteAccountRequest.setAccountId(accountId);
		Response<Account> deleteResponse = accountService.deleteAccount(deleteAccountRequest);
		assertEquals("bad status",deleteResponse.getStatus(),Response.STATUS_SUCCESS);
	}
	
	// get a baseline. will be used to upload along with a profile
	protected Baseline getSolarBaselineFor92704() {
		TypicalService service = genabilityClient.getTypicalService();
		BaselineRequest request = new BaselineRequest();
		request.setZipCode("92704");
		
		Response<Baseline> response = service.getSolarBaseline(request);
		
		if (response.getStatus().equals(Response.STATUS_SUCCESS)) {
			return response.getResults().get(0);
		} else {
			return null;
		}
	}
	
	protected <T> T loadJsonFixture(String fileName, TypeReference<T> resultTypeReference) {
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
			return mapper.readValue(is, resultTypeReference);
		} catch (JsonParseException e) {
			log.error("JsonParseException in fixture " + fileName);
			throw new GenabilityException(e);
		} catch (JsonMappingException e) {
			log.error("JsonMappingException in fixture " + fileName);
			throw new GenabilityException(e);
		} catch (IOException e) {
			log.error("Couldn't open fixture " + fileName);
			throw new GenabilityException(e);
		}
	}
}
