package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.genability.client.api.request.GetPropertyKeyRequest;
import com.genability.client.api.request.GetPropertyLookupRequest;
import com.genability.client.api.request.GetPropertyStatsRequest;
import com.genability.client.types.Account;
import com.genability.client.types.PropertyKey;
import com.genability.client.types.PropertyLookup;
import com.genability.client.types.PropertyLookupStats;
import com.genability.client.types.Response;

public class PropertyServiceTests extends BaseServiceTests{
	private static PropertyService propertyService = genabilityClient.getPropertyService();
	
	@Test
	public void testGetPropertyKey() {
		
		GetPropertyKeyRequest request = new GetPropertyKeyRequest();
		request.setKeyName_("hourlyPricingOntario");
	
		// set key name 
		//to date
		//from date

		Response<PropertyKey> restResponse = propertyService.getPropertyKey(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);

	}
	
	
	@Test
	public void testGetPropertyKeys() {
		
		GetPropertyKeyRequest request = new GetPropertyKeyRequest();

		//get all keys and its choices (subkeys)
		//to date
		//from date

		Response<PropertyKey> restResponse = propertyService.getPropertyKeys(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);

	}
	
	@Test
	public void testGetPropertyLookups() {
		
		GetPropertyLookupRequest request = new GetPropertyLookupRequest();

		//lookups
		//to date
		//from date

		Response<PropertyLookup> restResponse = propertyService.getPropertyLookups(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);

	}
	
	
	@Test
	public void testGetPropertyStats() {
		
		GetPropertyKeyRequest request = new GetPropertyKeyRequest();

		//check if request.key != null
		Response<PropertyLookupStats> restResponse = propertyService.getPropertyStats(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);

	}
	
	
}
