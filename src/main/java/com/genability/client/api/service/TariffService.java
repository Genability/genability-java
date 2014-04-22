package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.DeleteTariffRequest;
import com.genability.client.api.request.GetTariffRequest;
import com.genability.client.api.request.GetTariffsRequest;
import com.genability.client.types.Fields;
import com.genability.client.types.Response;
import com.genability.client.types.Tariff;

public class TariffService extends BaseService {

    private static final TypeReference<Response<Tariff>> TARIFF_RESPONSE_TYPEREF = new TypeReference<Response<Tariff>>() {};
	
	/**
	 * Calls the REST service to get a list of tariffs based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Tariff> getTariffs(GetTariffsRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getTariffs called");
		
		//betaStandardCurrency into Query parameters
		request.setFields(Fields.EXT);
		
		Response<Tariff> response = this.callGet(
				"public/tariffs", 
				request.getQueryParams(),
				TARIFF_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getTariffs completed");
		
		return response;

		
	}
	

	/**
	 * Calls the REST service to get one tariff based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Tariff> getTariff(GetTariffRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getTariff called");
		
		Response<Tariff> response = this.callGet(
				"public/tariffs", 
				request.getQueryParams(),
				TARIFF_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getTariff completed");
		
		return response;
		
	}
	
	/**
	 * Calls the REST service to get one tariff based on the arguments passed
	 * in.
	 * 
	 * @return
	 */
	public Response<Tariff> getTariffProperties(GetTariffRequest request) {

		if (log.isDebugEnabled())
			log.debug("getTariffProperties called");

		Response<Tariff> response = this.callGet("public/tariffs/properties",
				request.getQueryParams(), TARIFF_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getTariffProperties completed");

		return response;

	}
	
	public Response<Tariff> addTariff(Tariff tariff) {

		if(log.isDebugEnabled()) log.debug("addTariff called");

		Response<Tariff> response = this.callPost(
				"beta/tariffs",
				tariff,
				TARIFF_RESPONSE_TYPEREF);

		if(log.isDebugEnabled()) log.debug("addTariff completed");

		return response;

	}

	public Response<Tariff> updateTariff(Tariff tariff) {

		if(log.isDebugEnabled()) log.debug("updateTariff called");

		String uri = "beta/tariffs";
		if (tariff.getTariffId() != null) {
			uri += "/" + tariff.getTariffId();
		}

		Response<Tariff> response = this.callPut(
				uri,
				tariff,
				TARIFF_RESPONSE_TYPEREF);

		if(log.isDebugEnabled()) log.debug("updateTariff completed");

		return response;

	}


	public Response<Tariff> deleteTariff(DeleteTariffRequest request) {

		if(log.isDebugEnabled()) log.debug("deleteTariff called");

		String uri = "beta/tariffs";
		if (request.getTariffId() != null) {
			uri += "/" + request.getTariffId();
		}

		Response<Tariff> response = this.callDelete(
				uri,
				request.getQueryParams(),
				TARIFF_RESPONSE_TYPEREF);

		if(log.isDebugEnabled()) log.debug("deleteTariff completed");

		return response;

	}

	/******************************************************************************************
	 * BELOW HERE ARE THE HELPER METHODS
	 ******************************************************************************************/


	
	
}
