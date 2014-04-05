package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Ignore;
import org.junit.Test;

import com.genability.client.api.request.GetProfileRequest;
import com.genability.client.api.request.GetProfilesRequest;
import com.genability.client.api.request.ReadingDataRequest;
import com.genability.client.types.Account;
import com.genability.client.types.ClipBy;
import com.genability.client.types.GroupBy;
import com.genability.client.types.Profile;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;

public class ProfileServiceTests extends BaseServiceTests {

	private static ProfileService profileService = genabilityClient.getProfileService();
	
	
	@Test
	@Ignore
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

	public Profile callGetProfile(String testCase, GetProfileRequest request) {
		
		Response<Profile> restResponse = profileService.getProfile(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Profile.REST_TYPE);
		assertTrue("bad count", restResponse.getCount() > 0);

		return restResponse.getResults().get(0);
				
	}
	
	public void callGetProfiles(String testCase, GetProfilesRequest request) {
		
		Response<Profile> restResponse = profileService.getProfiles(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Profile.REST_TYPE);
				
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
		// GetProfileRequest profileRequest = new GetProfileRequest();
		// profileRequest.setProfileId(profile.getProfileId());
		// profileRequest.setPopulateReadings(true);
		// profile = callGetProfile("Test get one profile", profileRequest);
		//
		// assertNotNull("new Profile Readings is null",
		// profile.getReadingData());
		// assertTrue("reading1 is not equal", profile.getReadingData().get(0)
		// .getQuantityValue().equals(new BigDecimal("1000")));
		// assertTrue("reading2 is not equal", profile.getReadingData().get(0)
		// .getQuantityValue().equals(new BigDecimal("900")));

		cleanup(account.getAccountId());
	}




}
