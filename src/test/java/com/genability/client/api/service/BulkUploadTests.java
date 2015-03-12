package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.genability.client.api.request.BulkUploadRequest;
import com.genability.client.types.Profile;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;

public class BulkUploadTests extends BaseServiceTests {

	private static BulkUploadService bulkUploadService = genabilityClient.getBulkUploadService();
	
	private Profile profile;

	@Before
	public void setUp() {
		// create test profile
		profile = this.createProfile();
	}

	@After
	public void tearDown() {
		// clean up test data
		if (profile != null) {
			this.cleanup(profile.getAccountId());
		}
	}

	@Test
	public void testUploadCSV() {
		
		// bulk load readings to account
		BulkUploadRequest request = new BulkUploadRequest();

		URL resourceUrl = getClass().getResource("/interval_data.csv");
		File file = new File(resourceUrl.getFile());

		request.setFileData(file);
		request.setFileFormat("csv");
		request.setUsageProfileId(profile.getProfileId());
		upload("Case upload CSV",request);

	}
	
	// This method uploads Green Button XML data
	@Test
	@Ignore
	public void testUploadGreenButton() {
		
		BulkUploadRequest request = new BulkUploadRequest();

		URL resourceUrl = getClass().getResource("/green_button.xml");
		File file = new File(resourceUrl.getFile());

		request.setFileData(file);
		request.setFileFormat("espi");
		profile.setProfileId(profile.getProfileId());
		upload("Case upload XML",request);
		
	}

	private void upload(String testCase, BulkUploadRequest request) {
		
		Response<ReadingData> restResponse = bulkUploadService
				.uploadFile(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),ReadingData.REST_TYPE);
		
	}


}
