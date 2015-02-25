package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetPriceRequest;
import com.genability.client.types.TariffRateSummary;
import com.genability.client.types.Response;

public class PriceService extends BaseService {

    private static final TypeReference<Response<TariffRateSummary>> PRICE_RESPONSE_TYPEREF = new TypeReference<Response<TariffRateSummary>>() {};
	
	/**
	 * Calls the REST service to get a Profile based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<TariffRateSummary> getPrice(GetPriceRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getPrice called");
		
		String uri = "public/prices";
		if (request.getMasterTariffId() != null) {
			uri += "/" + request.getMasterTariffId();
		}
		
		Response<TariffRateSummary> response = this.callGet(
				uri,
				request.getQueryParams(),
				PRICE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getPrice completed");
		
		return response;
		
	}
	
}
