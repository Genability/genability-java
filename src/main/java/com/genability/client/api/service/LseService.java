package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetLseRequest;
import com.genability.client.api.request.GetLsesRequest;
import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.types.Lse;
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
				new TypeReference<Response<Lse>>() { });
		
		if(log.isDebugEnabled()) log.debug("getTerritories completed");
		
		return response;
		
	}

	/**
	 * Calls the REST service to get the LSE requested
	 * 
	 * @return
	 */
	public Response<Lse> getLse(GetLseRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getLse called");
		
		String uri = "public/lses";
		if (request.getLseId() != null) {
			uri += "/" + request.getLseId();
		}

		@SuppressWarnings("unchecked")
		Response<Lse> response = (Response<Lse>) this.callGet(
				uri, 
				request.getQueryParams(),
				new TypeReference<Response<Lse>>() { });
		
		if(log.isDebugEnabled()) log.debug("getLse completed");
		
		return response;
		
	}

	/**
	 * Calls the REST service to get a list of LSEs based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Lse> getLses(GetLsesRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getLses called");
		
		@SuppressWarnings("unchecked")
		Response<Lse> response = (Response<Lse>) this.callGet(
				"public/lses", 
				request.getQueryParams(),
				new TypeReference<Response<Lse>>() { });
		
		if(log.isDebugEnabled()) log.debug("getLses completed");
		
		return response;
		
	}

}
