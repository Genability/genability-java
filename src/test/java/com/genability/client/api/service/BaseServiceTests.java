package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.api.service.AccountService;
import com.genability.client.api.service.ProfileService;
import com.genability.client.types.Account;
import com.genability.client.types.Profile;
import com.genability.client.types.PropertyData;
import com.genability.client.types.Response;
import com.genability.client.types.Tariff;

public class BaseServiceTests {

	protected Logger log = Logger.getLogger(this.getClass());
	
	protected static String appId = null;
	
	protected static String appKey = null;
	
	protected static String restApiServer = null;
	
	protected static AccountService accountService = null;
	
	protected static ProfileService profileService = null;
	
	static {
		//
		// Very simple configuration of logging to console.
		//
		BasicConfigurator.configure();
		Logger logger = Logger.getLogger(BaseServiceTests.class);
		
		//
		// Very simple configuration of API keys etc.
		//
		Properties prop = new Properties();
		 
    	try {
    		
    		//
    		//load the properties file from in the classpath
    		//
    		InputStream inputStream = BaseServiceTests.class.getClassLoader().getResourceAsStream("genability.properties");
    		prop.load(inputStream);
 
    		//
            // get the properties and print them out
    		//
    		appId = prop.getProperty("appId");
    		appKey = prop.getProperty("appKey");
    		logger.info("appId:" + appId);
    		logger.info("appKey:" + appKey);
    		
    		if(prop.containsKey("restApiServer")) {
    			
    			restApiServer = prop.getProperty("restApiServer");
    			logger.info("restApiServer:" + restApiServer);
    		}
 
    	} catch (IOException ex) {
    		logger.error("Unable to process genability.properties", ex);
        }
    	
		accountService = new AccountService();
		accountService.setAppId(appId);
		accountService.setAppKey(appKey);
		if(restApiServer != null) accountService.setRestApiServer(restApiServer);
		
		profileService = new ProfileService();
		profileService.setAppId(appId);
		profileService.setAppKey(appKey);
		if(restApiServer != null) profileService.setRestApiServer(restApiServer);
	}
	
	// Helper method:  We create an account and specify a tariff as well as values
	// for the tariff's properties.  We use masterTariffId 521 (PGE E-1) which for
	// calculations has one required property which is the territoryId.  
	// We also set the zipCode as an additional example.
	protected Account createAccount() {
		
		Account addAccount = new Account();
		addAccount.setAccountName("Java Client Lib Test Account - CAN DELETE");
		
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

	// Delete the accounts we create to keep things clean; this also cleans up profiles
	// on the account
	protected void cleanup(String accountId) {
		DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest();
		deleteAccountRequest.setAccountId(accountId);
		Response<Account> deleteResponse = accountService.deleteAccount(deleteAccountRequest);
		assertEquals("bad status",deleteResponse.getStatus(),Response.STATUS_SUCCESS);
	}
}