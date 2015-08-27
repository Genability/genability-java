package com.genability.client.api.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.api.request.GetTerritoryRequest;
import com.genability.client.types.MockHttpClient;
import com.genability.client.types.Response;
import com.genability.client.types.Territory;

public class TerritoryServiceTests extends BaseServiceTests {
	
	private String baseUrl = territoryService.getRestApiServer() + "public/territories/";
	private TerritoryService localService;

	@Before
	public void initializeTerritoryService() {
		localService = new TerritoryService();
		localService.setRestApiServer(territoryService.getRestApiServer());
	}
	
	@Test
	public void testGetOneTerritory() {
		// Arrange
		long territoryId = 1234;
		String expectedUrl = String.format("%s%d", baseUrl, territoryId);
		
		// Expect
		MockHttpClient client = new MockHttpClient(expectedUrl); 
		localService.setHttpClient(client);
		
		// Act
		GetTerritoryRequest request = new GetTerritoryRequest();
		request.setTerritoryId(territoryId);
		
		localService.getTerritory(request);
		client.validate();
	}
	
	@Test
	public void testGetOneTerritoryWithParameters() {
		// Arrange
		long territoryId = 1234;
		String expectedUrl = String.format("%s%d", baseUrl, territoryId);
		
		// Expect
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("populateItems", "true");
		client.addExpectedParameter("populateLses", "true");
		localService.setHttpClient(client);

		// Act
		GetTerritoryRequest request = new GetTerritoryRequest();
		request.setTerritoryId(territoryId);
		request.setPopulateItems(true);
		request.setPopulateLses(true);
		
		localService.getTerritory(request);
		client.validate();
	}
	
	@Test
	public void testGetTerritories() {
		// Arrange
		String expectedUrl = baseUrl;
		
		// Expect
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("populateItems", "true");
		client.addExpectedParameter("populateLses", "true");
		client.addExpectedParameter("lseId", "1234");
		client.addExpectedParameter("masterTariffId", "5");
		client.addExpectedParameter("containsItemType", "itemType");
		client.addExpectedParameter("containsItemValue", "itemValue");
		localService.setHttpClient(client);
		
		// Act
		GetTerritoriesRequest request = new GetTerritoriesRequest();
		request.setPopulateItems(true);
		request.setPopulateLses(true);
		request.setLseId(1234L);
		request.setMasterTariffId(5L);
		request.setContainsItemType("itemType");
		request.setContainsItemValue("itemValue");
		
		localService.getTerritories(request);
		client.validate();
	}
	
	@Test
	public void testGetOneTerritoryFromServer() {
		Long territoryId = Long.valueOf(807L);
		
		GetTerritoryRequest request = new GetTerritoryRequest();
		request.setTerritoryId(territoryId);
		
		Response<Territory> result = territoryService.getTerritory(request);
		Territory t = result.getResults().get(0);
		
		assertEquals("Unsuccessful territory request", Response.STATUS_SUCCESS, result.getStatus());
		assertEquals("Got the wrong territory", territoryId, t.getTerritoryId());
	}
	
	@Test
	public void testGetOneTerritoryFromServerWithParameters() {
		Long territoryId = Long.valueOf(807L);
		
		GetTerritoryRequest request = new GetTerritoryRequest();
		request.setTerritoryId(territoryId);
		request.setPopulateItems(true);
		
		Response<Territory> result = territoryService.getTerritory(request);
		Territory t = result.getResults().get(0);
		
		assertEquals("Unsuccessful territory request", Response.STATUS_SUCCESS, result.getStatus());
		assertNotNull("Items was null even though it was specified", t.getItems());
	}
	
	@Test
	public void testGetTerritoriesFromServer() {
		Long lseId = Long.valueOf(734L);
		
		GetTerritoriesRequest request = new GetTerritoriesRequest();
		request.setLseId(lseId);
		
		Response<Territory> result = territoryService.getTerritories(request);
		
		for (Territory t : result.getResults()) {
			assertEquals("Got data for the wrong LSE", lseId, t.getLseId());
		}
	}
}
