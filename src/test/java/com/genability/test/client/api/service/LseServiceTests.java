package com.genability.test.client.api.service;

import static org.junit.Assert.*;

import com.genability.client.types.Response;
import com.genability.client.types.Territory;
import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.api.service.LseService;

import org.junit.Test;

public class LseServiceTests extends BaseServiceTests {
	
	@Test
	public void testGetTerritories() {
		
		LseService lseService = new LseService();
		
		GetTerritoriesRequest request = new GetTerritoriesRequest();
		
		Response<Territory> restResponse = lseService.getTerritories(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Territory.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
		
		for(Territory territory : restResponse.getResults()) {
			
			assertNotNull("territoryId null",territory.getTerritoryId());
			assertNotNull("lseId null",territory.getLseId());
			assertNotNull("lseName null",territory.getLseName());
			
		}
		
	}

}
