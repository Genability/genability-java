package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.genability.client.types.*;
import org.joda.time.DateTime;
import org.junit.Test;

import com.genability.client.api.request.GetTariffRequest;
import com.genability.client.api.request.GetTariffsRequest;

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
	public void testGetTariffWithChargeTypeMaximum() {
		GetTariffRequest request = new GetTariffRequest();
		request.setMasterTariffId(3311025L);
		request.setEffectiveOn(new DateTime("2021-06-02"));

		Tariff tariff = callGetTariff("Tariff with ChargeType MAXIMUM", request);

		assertTrue("The Tariff should have ChargeType MAXIMUM", Arrays.asList(tariff.getChargeTypes()).contains(ChargeType.MAXIMUM));
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

	@Test
	public void getTariffsWithAfterTax() {
		String testCase = "Get tariffs with AFTER_TAX charge class";

		GetTariffsRequest request = new GetTariffsRequest();
		request.setPopulateRates(true);
		request.setZipCode("95818");

		callGetTariffs(testCase, request);
	}

	@Test
	public void testGetTariffsWithCountry() {
		GetTariffsRequest request = new GetTariffsRequest();
		request.setCountry("FR");
		request.setPostCode("75001");


		callGetTariffs("Get tariffs with country code", request);
	}

	@Test
	public void testGetTariffWithNonBypassableRates() {
		GetTariffRequest request = new GetTariffRequest();
		request.setPopulateRates(true);
		request.setMasterTariffId(3250148L);

		callGetTariff("Get tariff with non-bypassable rates", request);
	}

	/**
	 * Test to make sure all TransactionTypes are marked and marshalled correctly.
	 */
	@Test
	public void testRateTransactionTypes() {
		Set<TransactionType> allTransactionTypes = new HashSet<TransactionType>(
				Arrays.asList(TransactionType.values()));


		GetTariffRequest request = new GetTariffRequest();
		request.setPopulateRates(true);

		// No single tariff has all transactionTypes. Here we picked two that collectively have all types.

		// RMP - Residential: has BUY, BUY_IMPORT, SELL_IMPORT
		request.setMasterTariffId(3292088L);
		Tariff tariff1 = callGetTariff("tariff 1", request);

		// Shasta Lake - Residential: has BUY, SELL, NET
		request.setMasterTariffId(3327795L);
		Tariff tariff2 = callGetTariff("tariff2", request);

		Set<TransactionType> tariffTransactionTypes = new HashSet<TransactionType>();
		for (TariffRate rate : tariff1.getRates()) {
			assertNotNull("Rate missing transactionType or not marshalled properly", rate.getTransactionType());
			tariffTransactionTypes.add(rate.getTransactionType());
		}
		for (TariffRate rate : tariff2.getRates()) {
			assertNotNull("Rate missing transactionType or not marshalled properly", rate.getTransactionType());
			tariffTransactionTypes.add(rate.getTransactionType());
		}

		assertEquals("Tariffs missing some expected transaction types", tariffTransactionTypes, allTransactionTypes);
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
