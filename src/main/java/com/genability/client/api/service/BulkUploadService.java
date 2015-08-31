package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.BulkUploadRequest;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;

public class BulkUploadService extends BaseService {
	
	private static final TypeReference<Response<ReadingData>> READING_DATA_RESPONSE_TYPEREF = new TypeReference<Response<ReadingData>>() {
	};
	
	/**
	 * Calls the REST service to upload a load profile or other usage data file
	 * 
	 * @param request The request.
	 * @return The return value.
	 */
	public Response<ReadingData> uploadFile(BulkUploadRequest request) {
		
		if(log.isDebugEnabled()) log.debug("uploadFile called");
		
		String uri = "beta/loader/bulk/up";
		Response<ReadingData> response = this.callFileUpload(uri, request,
				READING_DATA_RESPONSE_TYPEREF);

		if(log.isDebugEnabled()) log.debug("uploadFile completed");
		return response;
	}
}
