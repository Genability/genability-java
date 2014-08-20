package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetPropertyKeyRequest;
import com.genability.client.api.request.GetPropertyLookupRequest;
import com.genability.client.api.request.GetPropertyStatsRequest;
import com.genability.client.types.Account;
import com.genability.client.types.PropertyKey;
import com.genability.client.types.PropertyLookup;
import com.genability.client.types.PropertyLookupStats;
import com.genability.client.types.Response;
import com.genability.client.types.Tariff;

public class PropertyService extends BaseService {

	private static final TypeReference<Response<PropertyKey>> PROPERTY_RESPONSE_TYPEREF = new TypeReference<Response<PropertyKey>>() {};
	private static final TypeReference<Response<PropertyLookup>> PROPERTY_LOOKUP_RESPONSE_TYPEREF = new TypeReference<Response<PropertyLookup>>() {};
	
	
	public Response<PropertyKey> getPropertyKey(GetPropertyKeyRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getAccount called");

		String uri = "/properties";
		if (request.getKeyName_() != null && request.getKeyName_().length() !=0) {
			uri += "/" + request.getKeyName_();
		}

		Response<PropertyKey> response = this.callGet(uri,request.getQueryParams(),PROPERTY_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getAccount completed");
		
		return response;
		
	}

	public Response<PropertyKey> getPropertyKeys(GetPropertyKeyRequest request) {
		if(log.isDebugEnabled()) log.debug("getAccount called");

		String uri = "/properties";

		Response<PropertyKey> response = this.callGet(uri,request.getQueryParams(),PROPERTY_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getAccount completed");
		
		return response;
	}

	public Response<PropertyLookup> getPropertyLookups(GetPropertyLookupRequest request) {
		if(log.isDebugEnabled()) log.debug("getAccount called");

		String uri = "/properties/lookups";

		Response<PropertyLookup> response = this.callGet(uri,request.getQueryParams(),PROPERTY_LOOKUP_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getAccount completed");
		
		return response;
	}

	public Response<PropertyLookupStats> getPropertyStats(GetPropertyKeyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


}
