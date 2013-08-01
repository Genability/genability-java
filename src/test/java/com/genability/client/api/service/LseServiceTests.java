package com.genability.client.api.service;

import static org.junit.Assert.*;

import com.genability.client.types.Response;
import com.genability.client.types.Territory;
import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.api.service.LseService;

import org.junit.BeforeClass;
import org.junit.Test;

public class LseServiceTests extends BaseServiceTests {

	private static LseService lseService;

	@BeforeClass
	public static void runBeforeClass() {

		lseService = new LseService();
		lseService.setAppId(appId);
		lseService.setAppKey(appKey);
		if(restApiServer != null) lseService.setRestApiServer(restApiServer);
	}
	
	
	@Test
	public void testGetTerritories() {
		
		GetTerritoriesRequest request = new GetTerritoriesRequest();
		request.setLseId(734l);  //This is PG&E
		callGetTerritories("Case 1",request);
		
	}

	@Test
	public void testGetTerritoryItems() {
		
		GetTerritoriesRequest request = new GetTerritoriesRequest();
		request.setLseId(734l);
		request.setPopulateItems(true);
		callGetTerritories("Case 2",request);
		
	}


	public void callGetTerritories(String testCase, GetTerritoriesRequest request) {
		
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
