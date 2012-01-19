package com.genability.test.client.api.service;

import static org.junit.Assert.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import com.genability.client.types.Response;
import com.genability.client.types.CalculatedCost;
import com.genability.client.types.PropertyData;
import com.genability.client.api.request.GetCalculatedCostRequest;
import com.genability.client.api.service.CalculateService;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateServiceTests extends BaseServiceTests {

	private static CalculateService calculateService;

	@BeforeClass
	public static void runBeforeClass() {

		calculateService = new CalculateService();
		calculateService.setAppId(appId);
		calculateService.setAppKey(appKey);
	}
	
	
	@Test
	public void testCalculateTariff512() {
		
		GetCalculatedCostRequest request = new GetCalculatedCostRequest();

		request.setFromDateTime(new DateTime("2011-12-01T00:00:00.000-05:00"));
		request.setToDateTime(new DateTime("2012-01-01T00:00:00.000-05:00"));
		request.setMasterTariffId(512l);
		
		// Set the cityLimits property
		PropertyData newProp = new PropertyData();
		newProp.setFromDateTime(new DateTime("2011-12-01T00:00:00.000-05:00"));
		newProp.setToDateTime(new DateTime("2011-12-01T00:00:00.000-05:00"));
		newProp.setDataValue("Inside");
		newProp.setKeyName("cityLimits");
		
		// Set the connectionType property
		PropertyData newProp2 = new PropertyData();
		newProp2.setFromDateTime(new DateTime("2011-12-01T00:00:00.000-05:00"));
		newProp2.setToDateTime(new DateTime("2011-12-01T00:00:00.000-05:00"));
		newProp2.setDataValue("Primary");
		newProp2.setKeyName("connectionType");

		// Set the consumption property
		PropertyData newProp3 = new PropertyData();
		newProp3.setFromDateTime(new DateTime("2011-12-01T00:00:00.000-05:00"));
		newProp3.setToDateTime(new DateTime("2011-12-01T00:00:00.000-05:00"));
		newProp3.setDataValue("220");
		newProp3.setKeyName("consumption");

		
		request.addTariffInput(newProp);
		request.addTariffInput(newProp2);
		request.addTariffInput(newProp3);
		
		callRunCalc("Test for master tariff 512",request);
		
	}
	

	public void callRunCalc(String testCase, GetCalculatedCostRequest request) {
		
		Response<CalculatedCost> restResponse = calculateService.getCalculatedCost(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),CalculatedCost.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
		/*
		for(Territory territory : restResponse.getResults()) {
			
			assertNotNull("territoryId null",territory.getTerritoryId());
			assertNotNull("lseId null",territory.getLseId());
			assertNotNull("lseName null",territory.getLseName());
			
		}
		*/
	}
}
