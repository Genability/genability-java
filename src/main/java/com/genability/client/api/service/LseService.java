package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.types.Response;
import com.genability.client.types.Territory;


public class LseService extends BaseService {
	
	
	/**
	 * Calls the REST service to get a list of tariffs based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Territory> getTerritories(GetTerritoriesRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getTerritories called");
		
		@SuppressWarnings("unchecked")
		Response<Territory> response = (Response<Territory>) this.callGet(
				"public/territories", 
				request.getQueryParams(),
				new TypeReference<Response<Territory>>() { });
		
		if(log.isDebugEnabled()) log.debug("getTerritories completed");
		
		return response;
		
	}

}
