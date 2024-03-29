package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

import com.genability.client.api.request.GetPropertyKeyRequest;
import com.genability.client.api.request.GetPropertyKeysRequest;
import com.genability.client.api.request.GetPropertyLookupsRequest;
import com.genability.client.types.DataType;
import com.genability.client.types.PropertyKey;
import com.genability.client.types.PropertyLookup;
import com.genability.client.types.PropertyLookupStats;
import com.genability.client.types.Response;

public class PropertyServiceTests extends BaseServiceTests{
	
	private static PropertyService propertyService = genabilityClient.getPropertyService();
	
	@Test
	public void testGetPropertyKey() {
		
		//
		// Assign
		//
		GetPropertyKeyRequest request = new GetPropertyKeyRequest();
		request.setKeyName("qosVariableRateKeyHourlyWithSubkey");

		//
		// Act
		//
		Response<PropertyKey> restResponse = propertyService.getPropertyKey(request);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),PropertyKey.REST_TYPE);

	}
	
	@Test
	public void testPaginatedPropertyKeysList() {
		GetPropertyKeysRequest request = new GetPropertyKeysRequest();
		// PG&E, since it has a lot of property keys
		request.setEntityId(734L);
		request.setEntityType("LSE");
		Response<PropertyKey> restResponse = propertyService.getPropertyKeys(request);
		
		int totalPropertyKeys = restResponse.getCount();
		int propertyKeysVisited = 0;
		
		while(propertyKeysVisited < totalPropertyKeys) {
			assertEquals("Didn't page through the account list correctly.", propertyKeysVisited, restResponse.getPageStart().intValue());

			propertyKeysVisited += restResponse.getResults().size();
			
			request.setPageStart(restResponse.getPageStart() + restResponse.getPageCount());
			restResponse = propertyService.getPropertyKeys(request);
		}
		
		assertEquals("Visited too many property keys", propertyKeysVisited, totalPropertyKeys);
	}

	@Test
	public void testGetPropertyKeys() {
		
		//
		// Assign
		//
		GetPropertyKeysRequest request = new GetPropertyKeysRequest();
		request.setFamily("market");
		request.setDataType(DataType.LOOKUP);

		//
		// Act
		//
		Response<PropertyKey> restResponse = propertyService.getPropertyKeys(request);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),PropertyKey.REST_TYPE);

	}
	
	@Test
	public void testGetPropertyLookups() {
		
		//
		// Assign
		//
		GetPropertyLookupsRequest request = new GetPropertyLookupsRequest();
		String targetPropertyKey = "hourlyPricingDayAheadPJM";
		request.setKeyName(targetPropertyKey);
		
		//
		// Act
		//
		Response<PropertyLookup> restResponse = propertyService.getPropertyLookups(request);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),PropertyLookup.REST_TYPE);
		assertTrue("Didn't get any results.", restResponse.getCount() > 0);
		assertEquals("Got results for the wrong propertyKey",
				targetPropertyKey, restResponse.getResults().get(0).getPropertyKey());
	}

	@Test
	public void testGetPropertyLookups_null_keyName() {
		GetPropertyLookupsRequest request = new GetPropertyLookupsRequest();
		try {
			propertyService.getPropertyLookups(request);
		} catch (GenabilityException e) {
			assertEquals("Missing required field keyName", e.getMessage());
		}
	}

	@Test
	public void testGetPropertyLookups_null_keyName_nonNull_additionalParams() {
		GetPropertyLookupsRequest request = new GetPropertyLookupsRequest();
		request.setSubKeyName("51291");
		request.setFromDateTime(new DateTime("2014-01-01"));
		request.setToDateTime(new DateTime("2014-01-02"));

		try {
			propertyService.getPropertyLookups(request);
		} catch (GenabilityException e) {
			assertEquals("Missing required field keyName", e.getMessage());
		}
	}
	
	@Test
	public void testGetPropertyLookupsWithSubkey() {
		
		//
		// Assign
		//
		GetPropertyLookupsRequest request = new GetPropertyLookupsRequest();
		String targetPropertyKey = "hourlyPricingDayAheadPJM";
		String targetSubPropertyKey = "51291";
		request.setKeyName(targetPropertyKey);
		request.setSubKeyName(targetSubPropertyKey);
		request.setFromDateTime(new DateTime("2014-01-01"));
		request.setToDateTime(new DateTime("2014-01-02"));
		
		//
		// Act
		//
		Response<PropertyLookup> restResponse = propertyService.getPropertyLookups(request);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),PropertyLookup.REST_TYPE);
		assertEquals("Didn't get the correct number of results.", new Integer(24), restResponse.getCount());
		assertEquals("Got results for the wrong propertyKey",
				targetPropertyKey, restResponse.getResults().get(0).getPropertyKey());
		assertEquals("Got results for the wrong subPropertyKey",
				targetSubPropertyKey, restResponse.getResults().get(0).getSubPropertyKey());

	}
	
	
	@Test
	public void testGetPropertyStats() {
		
		//
		// Assign
		//
		String keyName = "qosVariableRateKeyHourly";

		//
		// Act
		//
		Response<PropertyLookupStats> restResponse = propertyService.getPropertyStats(keyName);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
	}
	
	
}
