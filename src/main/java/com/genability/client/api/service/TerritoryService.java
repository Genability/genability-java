package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.api.request.GetTerritoryRequest;
import com.genability.client.types.Response;
import com.genability.client.types.Territory;

public class TerritoryService extends BaseService {
	private static final TypeReference<Response<Territory>> TERRITORY_RESPONSE_TYPEREF = new TypeReference<Response<Territory>>() {};
	private static String URL_BASE = "public/territories/"; 

	public Response<Territory> getTerritory(GetTerritoryRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("getTerritories called");
		}

		String url = URL_BASE + request.getTerritoryId();
		Response<Territory> response = this.callGet(url, request.getQueryParams(), TERRITORY_RESPONSE_TYPEREF);

		if (log.isDebugEnabled()) {
			log.debug("getTerritories called");
		}

		return response;
	}

	public Response<Territory> getTerritories(GetTerritoriesRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("getTerritories called");
		}

		Response<Territory> response = this.callGet(
				URL_BASE, 
				request.getQueryParams(),
				TERRITORY_RESPONSE_TYPEREF);

		if (log.isDebugEnabled()) {
			log.debug("getTerritories called");
		}

		return response;
	}
}
