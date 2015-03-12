package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import com.genability.client.api.request.DeleteProfileRequest;
import com.genability.client.api.request.GetProfileRequest;
import com.genability.client.api.request.GetProfilesRequest;
import com.genability.client.api.request.ReadingDataRequest;
import com.genability.client.types.Account;
import com.genability.client.types.Baseline;
import com.genability.client.types.ClipBy;
import com.genability.client.types.GroupBy;
import com.genability.client.types.Profile;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;
import com.genability.client.types.Source;

public class ProfileServiceTests extends BaseServiceTests {

	private static ProfileService profileService = genabilityClient.getProfileService();
	
	@Test
	public void testGetProfile() {
		
		Profile newProfile = createProfile();
		GetProfileRequest request = new GetProfileRequest();
		
		// set a valid usageProfileId
		request.setProfileId(newProfile.getProfileId());
		request.setGroupBy(GroupBy.MONTH);
		request.setClipBy(ClipBy.OUTER);
		request.setPopulateReadings(true);
		callGetProfile("Test get one profile",request);
		
		cleanup(newProfile.getAccountId());
	}
	
	@Test
	public void testGetProfiles() {
		
		Profile newProfile = createProfile();
		GetProfilesRequest request = new GetProfilesRequest();
		request.setAccountId(newProfile.getAccountId());
		callGetProfiles("Test get all profiles",request);
		
		cleanup(newProfile.getAccountId());
	}
	
	@Test
	public void testAddProfileWithBaseline() {
		Account account = createAccount();
		try {
			Baseline solarBaseline = getSolarBaselineFor92704();
			Profile theProfile = new Profile();
			
			theProfile.setAccountId(account.getAccountId());
			theProfile.setBaselineMeasures(solarBaseline.getMeasuresList());
			theProfile.setServiceTypes("SOLAR_PV");
			theProfile.setSourceString("BaselineModel");
			
			Response<Profile> response = profileService.addProfile(theProfile);
			Profile returnedProfile = response.getResults().get(0);
			
			assertEquals("Did not successfully add the Baseline Profile",
					Response.STATUS_SUCCESS, response.getStatus());
			assertEquals("Source not set correctly", "BaselineModel", returnedProfile.getSource().getSourceId());
			assertNotNull("BaselineMeasures was null", returnedProfile.getBaselineMeasures());
			assertEquals("Didn't have the correct number of measures",
					8760, returnedProfile.getBaselineMeasures().size());
			
		} finally {
			cleanup(account.getAccountId());
		}
	}
	
	@Test
	public void testPopulateBaselineParameter() {
		Account account = createAccount();
		try {
			Baseline solarBaseline = getSolarBaselineFor92704();
			Profile theProfile = new Profile();
			
			theProfile.setAccountId(account.getAccountId());
			theProfile.setBaselineMeasures(solarBaseline.getMeasuresList());
			theProfile.setSourceString("BaselineModel");
			theProfile.setServiceTypes("SOLAR_PV");

			Response<Profile> addProfileResponse = profileService.addProfile(theProfile);
			Profile addedProfile = addProfileResponse.getResults().get(0);
			
			GetProfileRequest request = new GetProfileRequest();
			request.setProfileId(addedProfile.getProfileId());
			request.setPopulateBaseline(true);
			Response<Profile> getProfileResponse = profileService.getProfile(request);
			
			Profile retrievedProfile = getProfileResponse.getResults().get(0);
			
			assertNotNull("No profile was returned", retrievedProfile);
			assertNotNull("No baseline measures were returned", retrievedProfile.getBaselineMeasures());
			assertEquals("Wrong number of baseline measures", 8760, retrievedProfile.getBaselineMeasures().size());
		} finally {
			cleanup(account.getAccountId());
		}
	}
	
	@Test
	public void testAddProfile() {
		
		Account account = createAccount();
		Profile profile = new Profile();
		profile.setAccountId(account.getAccountId());
		Response<Profile> newProfile = profileService.addProfile(profile);
		
		assertNotNull("new Profile is null",newProfile);
		assertEquals("bad status",newProfile.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",newProfile.getType(),Profile.REST_TYPE);
		assertTrue("bad count",newProfile.getCount() > 0);
		
		cleanup(account.getAccountId());
	}

	@Test
	public void testDeleteProfileByProfileId() {
		Profile newProfile = createProfile();
		try {
			String profileId = newProfile.getProfileId();

			GetProfileRequest request = new GetProfileRequest();
			request.setProfileId(profileId);
			Profile returnedProfile = callGetProfile("testDeleteProfileByProfileId first get", request);
			assertEquals("profileId mismatch on first get", profileId, returnedProfile.getProfileId());

			callDeleteProfile(profileId);

			GetProfileRequest request2 = new GetProfileRequest();
			request2.setProfileId(profileId);
			try {
				profileService.getProfile(request2);
				fail("second get (after delete) should 404");
			} catch (GenabilityException e) {
				// XXX should handle HTTP codes cleanly in the exception
				if (! "Failed : HTTP error code : 404".equals(e.getMessage())) {
					throw e;
				}
			}
		} finally {
			cleanup(newProfile.getAccountId());
		}
	}

	@Test
	public void testAddUpdateReadings() {

		Account account = createAccount();
		Profile profile = new Profile();
		profile.setAccountId(account.getAccountId());
		Response<Profile> results = profileService.addProfile(profile);
		
		assertNotNull("new Profile is null", results);
		assertEquals("bad status", results.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", results.getType(), Profile.REST_TYPE);
		assertTrue("bad count", results.getCount() > 0);

		profile = results.getResults().get(0);
		
		List<ReadingData> readings = new ArrayList<ReadingData>();

		// add two months of readings
		ReadingData readingData1 = new ReadingData();
		readingData1.setQuantityUnit("kWh");
		DateTime fromDateTime1 = new DateTime(2014, 1, 1, 1, 0, 0, 0,
				DateTimeZone.forID("US/Pacific"));
		DateTime toDateTime1 = new DateTime(2014, 2, 1, 1, 0, 0, 0,
				DateTimeZone.forID("US/Pacific"));
		readingData1.setFromDateTime(fromDateTime1);
		readingData1.setToDateTime(toDateTime1);
		readingData1.setQuantityValue(new BigDecimal("1000"));
		readings.add(readingData1);

		ReadingData readingData2 = new ReadingData();
		readingData2.setQuantityUnit("kWh");
		DateTime fromDateTime2 = new DateTime(2014, 2, 1, 1, 0, 0, 0,
				DateTimeZone.forID("US/Pacific"));
		DateTime toDateTime2 = new DateTime(2014, 3, 1, 1, 0, 0, 0,
				DateTimeZone.forID("US/Pacific"));
		readingData2.setFromDateTime(fromDateTime2);
		readingData2.setToDateTime(toDateTime2);
		readingData2.setQuantityValue(new BigDecimal("900"));
		readings.add(readingData2);

		ReadingDataRequest request = new ReadingDataRequest();
		request.setUsageProfileId(profile.getProfileId());
		request.setReadings(readings);

		// add readings to profile
		Response<ReadingData> addReadingResults = profileService
				.addReadings(request);
		assertNotNull("new Profile is null", addReadingResults);
		assertEquals("bad status", addReadingResults.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", addReadingResults.getType(),
				ReadingData.REST_TYPE);
		assertTrue("bad count", addReadingResults.getCount() < 2);
		
		// getProfile with readings / ensure readings are there
		GetProfileRequest profileRequest = new GetProfileRequest();
		profileRequest.setProfileId(profile.getProfileId());
		profileRequest.setPopulateReadings(true);

		profile = callGetProfile("Test get one profile", profileRequest);

		assertNotNull("new Profile Readings is null", profile.getReadings());
		assertTrue("reading1 is not equal",
				profile.getReadings().getList().get(0).getQuantityValue().equals(new BigDecimal("1000.0")));
		assertTrue("reading2 is not equal",
				profile.getReadings().getList().get(1).getQuantityValue().equals(new BigDecimal("900.0")));

		cleanup(account.getAccountId());
	}

	@Test
	public void testGetProfileGroupedByHour() {

		Account account = createAccount();
		Profile profile = new Profile();
		profile.setAccountId(account.getAccountId());
		Response<Profile> results = profileService.addProfile(profile);

		assertNotNull("new Profile is null", results);
		assertEquals("bad status", results.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", results.getType(), Profile.REST_TYPE);
		assertTrue("bad count", results.getCount() > 0);

		profile = results.getResults().get(0);

		List<ReadingData> readings = new ArrayList<ReadingData>();

		// Create one year of readings
		ReadingData readingData1 = new ReadingData();
		readingData1.setQuantityUnit("kWh");
		DateTime fromDateTime1 = new DateTime(2014, 1, 1, 1, 0, 0, 0, DateTimeZone.forID("America/Los_Angeles"));
		DateTime toDateTime1 = new DateTime(2015, 1, 1, 1, 0, 0, 0, DateTimeZone.forID("America/Los_Angeles"));
		readingData1.setFromDateTime(fromDateTime1);
		readingData1.setToDateTime(toDateTime1);
		readingData1.setQuantityValue(new BigDecimal("3650"));
		readings.add(readingData1);



		ReadingDataRequest request = new ReadingDataRequest();
		request.setUsageProfileId(profile.getProfileId());
		request.setReadings(readings);

		// add readings to profile
		Response<ReadingData> addReadingResults = profileService.addReadings(request);
		assertNotNull("new Profile is null", addReadingResults);
		assertEquals("bad status", addReadingResults.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", addReadingResults.getType(), ReadingData.REST_TYPE);
		assertTrue("bad count", addReadingResults.getCount() < 2);

		// getProfile by date range
		GetProfileRequest profileRequest = new GetProfileRequest();
		profileRequest.setProfileId(profile.getProfileId());
		profileRequest.setFromDateTime(new DateTime(2014, 6, 1, 1, 0, 0, 0, DateTimeZone.forID("America/Los_Angeles")));
		profileRequest.setToDateTime(new DateTime(2014, 7, 1, 1, 0, 0, 0,  DateTimeZone.forID("America/Los_Angeles")));

		profileRequest.setPopulateReadings(Boolean.TRUE);
		profileRequest.setGroupBy(GroupBy.DAY);
		profileRequest.setPageCount(100);

		profile = callGetProfile("Test get one profile", profileRequest);

		assertNotNull("new Profile intervals is null", profile.getIntervals());
		// assertTrue("interval1 is not equal",
		// profile.getIntervals().getList().get(0).getkWh().getQuantityAmount()
		// .equals(new BigDecimal("1.34408602150537650000")));

		cleanup(account.getAccountId());
	}

	@Test
	public void testAddUpdateReadingsDST() {

		Account account = createAccount();
		Profile profile = new Profile();
		profile.setAccountId(account.getAccountId());
		Response<Profile> results = profileService.addProfile(profile);

		assertNotNull("new Profile is null", results);
		assertEquals("bad status", results.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", results.getType(), Profile.REST_TYPE);
		assertTrue("bad count", results.getCount() > 0);

		profile = results.getResults().get(0);

		List<ReadingData> readings = new ArrayList<ReadingData>();

		// add two months of readings
		ReadingData readingData1 = new ReadingData();
		readingData1.setQuantityUnit("kWh");
		DateTime fromDateTime1 = new DateTime(2014, 6, 1, 0, 0, 0, 0, DateTimeZone.forID("US/Pacific"));
		DateTime toDateTime1 = new DateTime(2014, 7, 1, 0, 0, 0, 0, DateTimeZone.forID("US/Pacific"));
		readingData1.setFromDateTime(fromDateTime1);
		readingData1.setToDateTime(toDateTime1);
		readingData1.setQuantityValue(new BigDecimal("1000"));
		readings.add(readingData1);

		ReadingDataRequest request = new ReadingDataRequest();
		request.setUsageProfileId(profile.getProfileId());
		request.setReadings(readings);

		// add readings to profile
		Response<ReadingData> addReadingResults = profileService.addReadings(request);
		assertNotNull("new Profile is null", addReadingResults);
		assertEquals("bad status", addReadingResults.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", addReadingResults.getType(), ReadingData.REST_TYPE);
		assertTrue("bad count", addReadingResults.getCount() != 1);

		//
		// TODO - add paginated readings and intervals lists to profile type
		//

		// getProfile with readings / ensure readings are there
		// GetProfileRequest profileRequest = new GetProfileRequest();
		// profileRequest.setProfileId(profile.getProfileId());
		// profileRequest.setPopulateReadings(true);
		// profile = callGetProfile("Test get one profile", profileRequest);

		// assertNotNull("new Profile Readings is null", profile.getReadings());
		// assertTrue("reading1 is not equal",
		// profile.getReadings().getList().get(0).getQuantityValue().equals(new
		// BigDecimal("1000")));

		cleanup(account.getAccountId());
	}

	@Test
	public void testAddReadingsDSTRunCalc() {

		Account account = createAccount();
		Profile profile = new Profile();
		profile.setAccountId(account.getAccountId());
		Response<Profile> results = profileService.addProfile(profile);

		assertNotNull("new Profile is null", results);
		assertEquals("bad status", results.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", results.getType(), Profile.REST_TYPE);
		assertTrue("bad count", results.getCount() > 0);

		profile = results.getResults().get(0);

		List<ReadingData> readings = new ArrayList<ReadingData>();

		// add two months of readings
		ReadingData readingData1 = new ReadingData();
		readingData1.setQuantityUnit("kWh");
		readingData1.setFromDateTime(new DateTime(2013, 5, 29, 10, 45, 0, 0, DateTimeZone.forID("America/New_York")));
		readingData1.setToDateTime(new DateTime(2013, 5, 29, 10, 50, 0, 0, DateTimeZone.forID("America/New_York")));
		readingData1.setQuantityValue(new BigDecimal("30.1"));
		readings.add(readingData1);

		ReadingData readingData2 = new ReadingData();
		readingData2.setQuantityUnit("kWh");
		readingData2.setFromDateTime(new DateTime(2013, 5, 29, 10, 50, 0, 0, DateTimeZone.forID("America/New_York")));
		readingData2.setToDateTime(new DateTime(2013, 5, 29, 10, 55, 0, 0, DateTimeZone.forID("America/New_York")));
		readingData2.setQuantityValue(new BigDecimal("30.2"));
		readings.add(readingData2);

		ReadingData readingData3 = new ReadingData();
		readingData3.setQuantityUnit("kWh");
		readingData3.setFromDateTime(new DateTime(2013, 5, 29, 10, 55, 0, 0, DateTimeZone.forID("America/New_York")));
		readingData3.setToDateTime(new DateTime(2013, 5, 29, 11, 00, 0, 0, DateTimeZone.forID("America/New_York")));
		readingData3.setQuantityValue(new BigDecimal("30.3"));
		readings.add(readingData3);

		ReadingDataRequest request = new ReadingDataRequest();
		request.setUsageProfileId(profile.getProfileId());
		request.setReadings(readings);

		// add readings to profile
		Response<ReadingData> addReadingResults = profileService.addReadings(request);
		assertNotNull("new Profile is null", addReadingResults);
		assertEquals("bad status", addReadingResults.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", addReadingResults.getType(), ReadingData.REST_TYPE);
		assertTrue("bad count", addReadingResults.getCount() != 1);

		//
		// TODO - add paginated readings and intervals lists to profile type
		//

		// getProfile with readings / ensure readings are there
		// GetProfileRequest profileRequest = new GetProfileRequest();
		// profileRequest.setProfileId(profile.getProfileId());
		// profileRequest.setPopulateReadings(true);
		// profile = callGetProfile("Test get one profile", profileRequest);

		// assertNotNull("new Profile Readings is null", profile.getReadings());
		// assertTrue("reading1 is not equal",
		// profile.getReadings().getList().get(0).getQuantityValue().equals(new
		// BigDecimal("1000")));

		cleanup(account.getAccountId());
	}

	/*
	 * Helper functions
	 */

	public void callDeleteProfile(String profileId) {
		DeleteProfileRequest request = new DeleteProfileRequest();
		request.setProfileId(profileId);
		Response<Profile> restResponse = profileService.deleteProfile(request);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), Profile.REST_TYPE);
		assertTrue("bad count", restResponse.getCount() == 0);
                assertNull("shouldn't have results", restResponse.getResults());
	}

	public Profile callGetProfile(String testCase, GetProfileRequest request) {
		
		Response<Profile> restResponse = profileService.getProfile(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Profile.REST_TYPE);
		assertTrue("bad count", restResponse.getCount() > 0);

		Profile profile = restResponse.getResults().get(0);
		return profile;
				
	}
	
	public void callGetProfiles(String testCase, GetProfilesRequest request) {
		
		Response<Profile> restResponse = profileService.getProfiles(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Profile.REST_TYPE);
				
	}



}
