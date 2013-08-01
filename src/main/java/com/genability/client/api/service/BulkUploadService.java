package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.BulkUploadRequest;
import com.genability.client.types.Response;

public class BulkUploadService extends BaseService {
	
	
	/**
	 * Calls the REST service to upload a load profile or other usage data file
	 * 
	 * @return String
	 */
	public Response<String> uploadFile(BulkUploadRequest request) {
		
		if(log.isDebugEnabled()) log.debug("uploadFile called");
		
		String uri = "beta/loader/bulk/up";		
        Response<String> response = this.callFileUpload(uri, request, new TypeReference<Response<String>>() { });

		if(log.isDebugEnabled()) log.debug("uploadFile completed");
		return response;
	}
}
