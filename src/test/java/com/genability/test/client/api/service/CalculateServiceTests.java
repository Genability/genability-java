package com.genability.test.client.api.service;

import static org.junit.Assert.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.genability.client.types.CalculatedCostItem;
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
		
		DateTime fromDateTime = new DateTime("2011-12-01T00:00:00.000-05:00");
		DateTime toDateTime = new DateTime("2012-01-01T00:00:00.000-05:00");
		
		GetCalculatedCostRequest request = new GetCalculatedCostRequest();

		request.setFromDateTime(fromDateTime);
		request.setToDateTime(toDateTime);
		request.setMasterTariffId(512l);

		// Set the consumption property
		PropertyData newProp3 = new PropertyData();
		newProp3.setFromDateTime(fromDateTime);
		newProp3.setToDateTime(toDateTime);
		newProp3.setDataValue("220");
		newProp3.setKeyName("consumption");
		
		// Set the cityLimits property
		PropertyData newProp = new PropertyData();
		newProp.setFromDateTime(fromDateTime);
		newProp.setToDateTime(toDateTime);
		newProp.setDataValue("Inside");
		newProp.setKeyName("cityLimits");
		
		// Set the connectionType property
		PropertyData newProp2 = new PropertyData();
		newProp2.setFromDateTime(fromDateTime);
		newProp2.setToDateTime(toDateTime);
		newProp2.setDataValue("Primary");
		newProp2.setKeyName("connectionType");
		
		request.addInput(newProp);
		request.addInput(newProp2);
		request.addInput(newProp3);
		
		callRunCalc("Test for master tariff 512",request);
		
	}
	
	
	@Test
	public void testCalculateTariff522() {
		
		// Where the tariff has a time zone (most do) you can use it to make sure your dates are the same
		DateTime fromDateTime = new DateTime(2012, 1, 1, 1, 0, 0, 0,DateTimeZone.forID("US/Pacific"));
		DateTime toDateTime = new DateTime(2013, 1, 1, 1, 0, 0, 0,DateTimeZone.forID("US/Pacific"));
		
		GetCalculatedCostRequest request = new GetCalculatedCostRequest();

		request.setFromDateTime(fromDateTime);
		request.setToDateTime(toDateTime);
		request.setMasterTariffId(522l); // PGE E1 - residential tariff

		// Set the consumption property
		PropertyData newProp = new PropertyData();
		newProp.setFromDateTime(fromDateTime);
		newProp.setToDateTime(toDateTime);
		newProp.setDataValue("36500");
		newProp.setKeyName("consumption");
		
		// Set the territoryId property
		PropertyData newProp2 = new PropertyData();
		newProp2.setFromDateTime(fromDateTime);
		newProp2.setToDateTime(toDateTime);
		newProp2.setDataValue("3534"); //Baseline Region P - 3534
		newProp2.setKeyName("territoryId");

		
		request.addInput(newProp);
		request.addInput(newProp2);
		
		callRunCalc("Test for master tariff 522",request);
		
	}
	

	public void callRunCalc(String testCase, GetCalculatedCostRequest request) {
		
		Response<CalculatedCost> restResponse = calculateService.getCalculatedCost(request);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),CalculatedCost.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
		assertNotNull("results null",restResponse.getResults());
		assertEquals("results count",restResponse.getResults().size(),1);
		
		CalculatedCost calculatedCost = restResponse.getResults().get(0);
		
		for(CalculatedCostItem costItem : calculatedCost.getItems()) {
			
			assertNotNull("cost null",costItem.getCost());
			
		}
		
	}
}
