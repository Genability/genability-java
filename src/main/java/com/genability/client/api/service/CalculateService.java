package com.genability.client.api.service;

import org.codehaus.jackson.type.TypeReference;

import com.genability.client.api.request.GetCalculatedCostRequest;
import com.genability.client.types.Response;
import com.genability.client.types.CalculatedCost;

public class CalculateService extends BaseService {
	
	
	/**
	 * Calls the REST service to run a calculation
	 * 
	 * @return CalculatedCost
	 */
	public Response<CalculatedCost> getCalculatedCost(GetCalculatedCostRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getCalculatedCost called");
		
		String uri = "beta/calculate";
		if (request.getMasterTariffId() != null) {
			uri += "/" + request.getMasterTariffId();
		} else {
			//This means we will be getting the tariffId from within the Account.
			//Do nothing.
		}

		
		@SuppressWarnings("unchecked")
		Response<CalculatedCost> response = (Response<CalculatedCost>) this.callPost(
				uri,
				//request.getQueryParams(),
				request,
				new TypeReference<Response<CalculatedCost>>() { });
		
		if(log.isDebugEnabled()) log.debug("getCalculatedCost completed");
		
		return response;
		
	}

}
