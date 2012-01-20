package com.genability.test.client.api.service;

import static org.junit.Assert.*;

import java.io.File;

import com.genability.client.types.Response;
import com.genability.client.types.ReadingData;
import com.genability.client.api.request.BulkUploadRequest;
import com.genability.client.api.service.BulkUploadService;

import org.junit.BeforeClass;
import org.junit.Test;

public class BulkUploadTests extends BaseServiceTests {

	private static BulkUploadService bulkUploadService;

	@BeforeClass
	public static void runBeforeClass() {

		bulkUploadService = new BulkUploadService();
		bulkUploadService.setAppId(appId);
		bulkUploadService.setAppKey(appKey);
	}
	
	
	@Test
	public void testUploadCSV() {
		
		BulkUploadRequest request = new BulkUploadRequest();
		request.setUsageProfileId("someProfileId");
		File file = new File("/Users/thisisme/Downloads/usageData.csv");
		request.setFileData(file);
		request.setContentType("text/csv");
		uploadCSV("Case 1",request);
		
	}
	

	public void uploadCSV(String testCase, BulkUploadRequest request) {
		
		Response<String> restResponse = bulkUploadService.uploadFile(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),ReadingData.REST_TYPE);
		
	}
}
