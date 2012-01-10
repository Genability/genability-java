package com.genability.client.api.service;

import org.codehaus.jackson.type.TypeReference;

import com.genability.client.api.request.GetTariffsRequest;
import com.genability.client.types.Response;
import com.genability.client.types.Tariff;

public class TariffService extends BaseService {

	
	/**
	 * Calls the REST service to get a list of tariffs based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Tariff> getTariffs(GetTariffsRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getTariffs called");
		
		//betaStandardCurrency into Query parameters
		
		@SuppressWarnings("unchecked")
		Response<Tariff> response = (Response<Tariff>) this.callGet(
				"public/tariffs", 
				request.getQueryParams(),
				new TypeReference<Response<Tariff>>() { });
		
		if(log.isDebugEnabled()) log.debug("getTariffs completed");
		
		return response;
		
	}
	
	
	
	/******************************************************************************************
	 * BELOW HERE ARE THE HELPER METHODS
	 ******************************************************************************************/


	
	
}
