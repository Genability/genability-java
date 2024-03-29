package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetPropertyKeyRequest;
import com.genability.client.api.request.GetPropertyKeysRequest;
import com.genability.client.api.request.GetPropertyLookupsRequest;
import com.genability.client.types.PropertyKey;
import com.genability.client.types.PropertyLookup;
import com.genability.client.types.PropertyLookupStats;
import com.genability.client.types.Response;

public class PropertyService extends BaseService {

	private static final TypeReference<Response<PropertyKey>> PROPERTY_RESPONSE_TYPEREF = new TypeReference<Response<PropertyKey>>() {};
	
	private static final TypeReference<Response<PropertyLookup>> PROPERTY_LOOKUP_RESPONSE_TYPEREF = new TypeReference<Response<PropertyLookup>>() {};
	
	private static final TypeReference<Response<PropertyLookupStats>> PROPERTY_LOOKUP_STATS_RESPONSE_TYPEREF = new TypeReference<Response<PropertyLookupStats>>() {};

	
	public Response<PropertyKey> getPropertyKey(GetPropertyKeyRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getPropertyKey called");

		String uri = "public/properties";
		if (request.getKeyName() != null && request.getKeyName().length() !=0) {
			uri += "/" + request.getKeyName();
		}
		Response<PropertyKey> response = this.callGet(uri,request.getQueryParams(),PROPERTY_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getPropertyKey completed");
		
		return response;
		
	}

	public Response<PropertyKey> getPropertyKeys(GetPropertyKeysRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getPropertyKeys called");

		String uri = "public/properties";

		Response<PropertyKey> response = this.callGet(uri,request.getQueryParams(),PROPERTY_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getPropertyKeys completed");
		
		return response;
	}

	public Response<PropertyLookup> getPropertyLookups(GetPropertyLookupsRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getPropertyLookups called");

		if (request.getKeyName() == null || request.getKeyName().isEmpty()) {
			throw new GenabilityException("Missing required field keyName");
		}

		String uri = "public/properties/" + request.getKeyName() + "/lookups";

		Response<PropertyLookup> response = this.callGet(uri,request.getQueryParams(),PROPERTY_LOOKUP_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getPropertyLookups completed with keyName: " + request.getKeyName());
		
		return response;
	}

	public Response<PropertyLookupStats> getPropertyStats(String propertyKeyName) {
		
		if(log.isDebugEnabled()) log.debug("getPropertyStats called");

		String uri = "public/properties";
		if (propertyKeyName != null && propertyKeyName.length() !=0) {
			uri += "/" + propertyKeyName + "/stats";
		}

		Response<PropertyLookupStats> response = this.callGet(uri,null,PROPERTY_LOOKUP_STATS_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getPropertyStats completed");
		
		return response;
	}


}
