package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		request.setEntityId(734L);
		request.setEntityType("LSE");
		Response<PropertyKey> restResponse = propertyService.getPropertyKeys(request);
		
		int totalPropertyKeys = restResponse.getCount();
		int propertyKeysVisited = 0;
		
		while(propertyKeysVisited < totalPropertyKeys) {
			assertEquals("Didn't page through the account list correctly.", propertyKeysVisited, restResponse.getPageStart().intValue());

			for(PropertyKey p : restResponse.getResults()) {
				propertyKeysVisited++;
			}
			
			request.setPageStart(restResponse.getPageStart() + restResponse.getPageCount());
			restResponse = propertyService.getPropertyKeys(request);
		}
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
		request.setPropertyKey("qosVariableRateKeyHourly");
		request.setFromDateTime(new DateTime("2014-01-01T00:00:00.000-05:00"));
		request.setToDateTime(new DateTime("2014-01-02T00:00:00.000-05:00"));
		
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

	}
	
	@Test
	public void testGetPropertyLookupsWithSubkey() {
		
		//
		// Assign
		//
		GetPropertyLookupsRequest request = new GetPropertyLookupsRequest();
		request.setPropertyKey("qosVariableRateKeyHourlyWithSubkey");
		request.setSubPropertyKey("51291");
		request.setFromDateTime(new DateTime("2014-01-01T00:00:00.000-05:00"));
		request.setToDateTime(new DateTime("2014-01-02T00:00:00.000-05:00"));
		
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
