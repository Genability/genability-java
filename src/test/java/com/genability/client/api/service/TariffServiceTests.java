package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Test;

import com.genability.client.api.request.GetTariffRequest;
import com.genability.client.api.request.GetTariffsRequest;
import com.genability.client.types.CustomerClass;
import com.genability.client.types.Response;
import com.genability.client.types.SortOrder;
import com.genability.client.types.Tariff;
import com.genability.client.types.TariffRate;
import com.genability.client.types.TariffRateBand;
import com.genability.client.types.TariffType;

public class TariffServiceTests extends BaseServiceTests {

	private static TariffService tariffService = genabilityClient.getTariffService();

	
	@Test
	public void testGetTariff() {

		String testCase = "Case 1 - call to get SCE's D Domestic tariff";
		GetTariffRequest request = new GetTariffRequest();
		request.setMasterTariffId(447L);
		callGetTariff(testCase, request);

	}

	@Test
	public void testGetTariffWithVariableRates () {

		String testCase = "Check that variable rates are returned";
		String variableRateKey = "peakShavingVASchedule1";
		GetTariffRequest request = new GetTariffRequest();
		request.setPopulateRates(true);
		request.setLookupVariableRates(true);
		request.setFromDateTime(new DateTime("2014-12-10"));
		request.setToDateTime(new DateTime("2014-12-15"));
		request.setMasterTariffId(122L);

		Tariff tariff = callGetTariff(testCase, request);

		// Check that the variable rate component has its rateAmount set to a non-zero value
		// (this happens only when we set lookupVariableRates to true)
		Boolean foundDesiredVariableRateBand = false;
		for (TariffRate rate : tariff.getRates()) {
			if (variableRateKey.equals(rate.getVariableRateKey())) {
				assertTrue("no rateBands for " + variableRateKey + " component!",
					rate.getRateBands() != null && rate.getRateBands().size() > 0);
				TariffRateBand rb = rate.getRateBands().get(0);
				assertTrue("rateAmount not filled in despite lookupVariableRates=true",
					BigDecimal.ZERO.compareTo(rb.getRateAmount()) != 0);
				foundDesiredVariableRateBand = true;
				break;
			}
		}
		assertTrue("didn't get a variable rate band we were looking for to test!", foundDesiredVariableRateBand);
	}

	@Test
	public void testGetTariffs() {
		
		GetTariffsRequest request = new GetTariffsRequest();
		
		String testCase = "Case 1 - simple unparameterized call";
		callGetTariffs(testCase, request);
		
		testCase = "Case 2 - find by zipcode";
		request.setZipCode("94105");
		callGetTariffs(testCase, request);
		
		testCase = "Case 3 - include the properties populated";
		request.setPopulateProperties(Boolean.TRUE);
		callGetTariffs(testCase, request);
		
		testCase = "Case 4 - explicit effective on";
		request.setEffectiveOn(new DateTime(DateTime.now().getYear()-1,11,11,1,0,0,0));
		callGetTariffs(testCase, request);
		
		testCase = "Case 5 - common scenario, active residential tariffs for a zipcode";
		request = new GetTariffsRequest();
		request.setCustomerClasses(CustomerClass.RESIDENTIAL);
		request.setTariffTypes(TariffType.DEFAULT, TariffType.ALTERNATIVE);
		request.setEffectiveOn(DateTime.now());
		request.setZipCode("94105");
		request.setSortOn("tariffType");
		request.setSortOrder(SortOrder.DESCENDING); // so default tariffs come before alternative
		request.setPopulateProperties(true);// so you know what properties it will take to run a calc
		callGetTariffs(testCase, request);
		
	}
	


	public void callGetTariffs(String testCase, GetTariffsRequest request) {
		
		Response<Tariff> restResponse = tariffService.getTariffs(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", Response.STATUS_SUCCESS, restResponse.getStatus());
		assertEquals("bad type", Tariff.REST_TYPE, restResponse.getType());
		assertTrue("bad count", restResponse.getCount() > 0);
		
		for(Tariff tariff : restResponse.getResults()) {
			
			assertNotNull("tariffId null",tariff.getTariffId());
			assertNotNull("effectiveDate", tariff.getEffectiveDate());
			assertNotNull("currency", tariff.getCurrency());
			
		}
		
	}
	
	public Tariff callGetTariff(String testCase, GetTariffRequest request) {

		Response<Tariff> restResponse = tariffService.getTariff(request);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", Response.STATUS_SUCCESS, restResponse.getStatus());
		assertEquals("bad type", Tariff.REST_TYPE, restResponse.getType());
		assertEquals("bad count", new Integer(1), restResponse.getCount());

		Tariff tariff = restResponse.getResults().get(0);

		assertNotNull("tariffId null", tariff.getTariffId());
		assertNotNull("effectiveDate", tariff.getEffectiveDate());
		assertNotNull("currency", tariff.getCurrency());

		return tariff;
	}

}
