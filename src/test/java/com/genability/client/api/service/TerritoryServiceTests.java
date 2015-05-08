package com.genability.client.api.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.genability.client.api.request.GetTerritoriesRequest;
import com.genability.client.api.request.GetTerritoryRequest;
import com.genability.client.types.MockHttpClient;
import com.genability.client.types.Response;
import com.genability.client.types.Territory;

public class TerritoryServiceTests extends BaseServiceTests {
	
	@Test
	public void testGetOneTerritory() {
		long territoryId = 1234;
		String expectedUrl = "https://api.genability.com/rest/public/territories/" + territoryId;
		
		GetTerritoryRequest request = new GetTerritoryRequest();
		request.setTerritoryId(territoryId);
		
		TerritoryService service = new TerritoryService();
		
		MockHttpClient client = new MockHttpClient(expectedUrl); 
		service.setHttpClient(client);
		
		service.getTerritory(request);
		client.validate();
	}
	
	@Test
	public void testGetOneTerritoryWithParameters() {
		long territoryId = 1234;
		String expectedUrl = "https://api.genability.com/rest/public/territories/" + territoryId;
		
		GetTerritoryRequest request = new GetTerritoryRequest();
		request.setTerritoryId(territoryId);
		request.setPopulateItems(true);
		request.setPopulateLses(true);
		
		TerritoryService service = new TerritoryService();
		
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("populateItems", "true");
		client.addExpectedParameter("populateLses", "true");
		service.setHttpClient(client);
		
		service.getTerritory(request);
		client.validate();
	}
	
	@Test
	public void testGetTerritories() {
		String expectedUrl = "https://api.genability.com/rest/public/territories/";
		
		GetTerritoriesRequest request = new GetTerritoriesRequest();
		request.setPopulateItems(true);
		request.setPopulateLses(true);
		request.setLseId(1234L);
		request.setMasterTariffId(5L);
		request.setContainsItemType("itemType");
		request.setContainsItemValue("itemValue");
		
		TerritoryService service = new TerritoryService();
		
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("populateItems", "true");
		client.addExpectedParameter("populateLses", "true");
		client.addExpectedParameter("lseId", "1234");
		client.addExpectedParameter("masterTariffId", "5");
		client.addExpectedParameter("containsItemType", "itemType");
		client.addExpectedParameter("containsItemValue", "itemValue");
		service.setHttpClient(client);
		
		service.getTerritories(request);
		client.validate();
	}
	
	@Test
	public void testGetOneTerritoryFromServer() {
		Long territoryId = Long.valueOf(1234L);
		
		GetTerritoryRequest request = new GetTerritoryRequest();
		request.setTerritoryId(territoryId);
		
		Response<Territory> result = territoryService.getTerritory(request);
		Territory t = result.getResults().get(0);
		
		assertEquals("Unsuccessful territory request", Response.STATUS_SUCCESS, result.getStatus());
		assertEquals("Got the wrong territory", territoryId, t.getTerritoryId());
	}
	
	@Test
	public void testGetOneTerritoryFromServerWithParameters() {
		Long territoryId = Long.valueOf(1234L);
		
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
