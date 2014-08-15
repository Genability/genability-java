package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetPriceRequest;
import com.genability.client.types.Price;
import com.genability.client.types.Response;

public class PriceService extends BaseService {

    private static final TypeReference<Response<Price>> PRICE_RESPONSE_TYPEREF = new TypeReference<Response<Price>>() {};
	
	/**
	 * Calls the REST service to get a Profile based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Price> getPrice(GetPriceRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getPrice called");
		
		String uri = "public/prices";
		if (request.getMasterTariffId() != null) {
			uri += "/" + request.getMasterTariffId();
		}
		
		Response<Price> response = this.callGet(
				uri,
				request.getQueryParams(),
				PRICE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getPrice completed");
		
		return response;
		
	}
	
}
