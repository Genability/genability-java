package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetLseRequest;
import com.genability.client.api.request.GetLsesRequest;
import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.types.LSE;
import com.genability.client.types.Response;
import com.genability.client.types.Territory;


public class LseService extends BaseService {
	
    private static final TypeReference<Response<Territory>> TERRITORY_RESPONSE_TYPEREF = new TypeReference<Response<Territory>>() {};
    private static final TypeReference<Response<LSE>> LSE_RESPONSE_TYPEREF = new TypeReference<Response<LSE>>() {};

	/**
	 * Calls the REST service to get a list of tariffs based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Territory> getTerritories(GetTerritoriesRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getTerritories called");
		
		Response<Territory> response = this.callGet(
				"public/territories", 
				request.getQueryParams(),
				TERRITORY_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getTerritories completed");
		
		return response;
		
	}

	/**
	 * Calls the REST service to get the LSE requested
	 * 
	 * @return
	 */
	public Response<LSE> getLse(GetLseRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getLse called");
		
		String uri = "public/lses";
		if (request.getLseId() != null) {
			uri += "/" + request.getLseId();
		}

		Response<LSE> response = this.callGet(
				uri, 
				request.getQueryParams(),
				LSE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getLse completed");
		
		return response;
		
	}

	/**
	 * Calls the REST service to get a list of LSEs based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<LSE> getLses(GetLsesRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getLses called");
		
		Response<LSE> response = this.callGet(
				"public/lses", 
				request.getQueryParams(),
				LSE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getLses completed");
		
		return response;
		
	}

}
