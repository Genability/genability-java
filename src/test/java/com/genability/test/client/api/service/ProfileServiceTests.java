package com.genability.test.client.api.service;

import static org.junit.Assert.*;

import com.genability.client.types.Response;
import com.genability.client.types.Profile;
import com.genability.client.api.request.GetProfileRequest;
import com.genability.client.api.request.GetProfilesRequest;
import com.genability.client.api.service.ProfileService;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProfileServiceTests extends BaseServiceTests {

	private static ProfileService profileService;

	@BeforeClass
	public static void runBeforeClass() {

		profileService = new ProfileService();
		profileService.setAppId(appId);
		profileService.setAppKey(appKey);
	}
	
	
	@Test
	public void testGetProfile() {
		
		GetProfileRequest request = new GetProfileRequest();

		// set a usageProfileId
		request.setUsageProfileId("abc123");
		request.setGroupBy("MONTH");
		request.setClipBy("OUTER");
		request.setPopulateUsageData(true);
		callGetProfile("Test get one profile",request);
		
	}
	
	@Test
	public void testGetProfiles() {
		
		GetProfilesRequest request = new GetProfilesRequest();
		// set an AccountId
		request.setAccountId("abc123");
		callGetProfiles("Test get all profiles",request);
		
	}

	public void callGetProfile(String testCase, GetProfileRequest request) {
		
		Response<Profile> restResponse = profileService.getProfile(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Profile.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
				
	}
	
	public void callGetProfiles(String testCase, GetProfilesRequest request) {
		
		Response<Profile> restResponse = profileService.getProfiles(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Profile.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
				
	}

}
