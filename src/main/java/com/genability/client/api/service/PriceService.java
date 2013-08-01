package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetPriceRequest;
import com.genability.client.types.Price;
import com.genability.client.types.Response;

public class PriceService extends BaseService {

	
	/**
	 * Calls the REST service to get a Profile based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Price> getPrice(GetPriceRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getPrice called");
		
		String uri = "beta/prices";
		if (request.getMasterTariffId() != null) {
			uri += "/" + request.getMasterTariffId();
		}
		
		Response<Price> response = this.callGet(
				uri,
				request.getQueryParams(),
				new TypeReference<Response<Price>>() { });
		
		if(log.isDebugEnabled()) log.debug("getPrice completed");
		
		return response;
		
	}
	
}
