package com.genability.client.api.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.AccountAnalysisRequest;
import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.types.Account;
import com.genability.client.types.AccountAnalysis;
import com.genability.client.types.Address;
import com.genability.client.types.CalculatedCost;
import com.genability.client.types.CalculatedCostItem;
import com.genability.client.types.ChargeType;
import com.genability.client.types.Profile;
import com.genability.client.types.PropertyData;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;
import com.genability.client.types.Series;
import com.genability.client.types.SeriesMeasure;
import com.genability.client.types.TariffRate;
import com.genability.client.types.TariffRateBand;

/**
 * Created by nsingh on 11/20/14.
 */
public class AccountAnalysisServiceTests extends BaseServiceTests {
	
	private AccountAnalysis testAnalysisWithCosts;
	private AccountAnalysis testAnalysisNoCosts;
	private static final TypeReference<Response<AccountAnalysis>> ACCOUNT_ANALYSIS_RESPONSE_TYPEREF =
            new TypeReference<Response<AccountAnalysis>>() {};
	
	@Before
	public void setUp() {
		Response<AccountAnalysis> responseWithCosts = loadJsonFixture("account_analysis_withcosts.json",
				ACCOUNT_ANALYSIS_RESPONSE_TYPEREF);
		
		Response<AccountAnalysis> responseNoCosts = loadJsonFixture("account_analysis_nocosts.json",
				ACCOUNT_ANALYSIS_RESPONSE_TYPEREF);
		
		testAnalysisWithCosts = responseWithCosts.getResults().get(0);
		testAnalysisNoCosts = responseNoCosts.getResults().get(0);
	}
	
    @Test
    public void testSavingsAnalysis() {

        Account account = new Account();
        account.setAccountName("test-api");
        account.setProviderAccountId("test-api" + UUID.randomUUID());
        Address address = new Address();
        address.setAddressString("221 Main Street, San Francisco, CA 94105");
        account.setAddress(address);
        Map<String, PropertyData> propertyDataMap = new HashMap<String, PropertyData>();
        PropertyData propertyData = new PropertyData();
        propertyData.setKeyName("customerClass");
        propertyData.setDataValue("1");
        propertyDataMap.put(propertyData.getKeyName(), propertyData);
        account.setProperties(propertyDataMap);
        Response<Account> restResponse = accountService.addAccount(account);
        assertNotNull("new account response is null", restResponse);
        assertEquals("bad status", restResponse.getStatus(), Response.STATUS_SUCCESS);
        assertEquals("bad type", restResponse.getType(), Account.REST_TYPE);
        assertTrue("bad count", restResponse.getCount() == 1);

        Account newAccount = restResponse.getResults().get(0);
        String accountId = newAccount.getAccountId();
        assertNotNull("accountId null", accountId);


        DateTime baseFromDateTime = new DateTime("2013-01-01");

        Profile usageProfile = new Profile();
        usageProfile.setAccountId(newAccount.getAccountId());
        List<ReadingData> readingDataList = new ArrayList<ReadingData>();
        for(int i = 0; i < 8760; i++) {
            ReadingData readingData = new ReadingData();
            readingData.setFromDateTime(baseFromDateTime.plusHours(i));
            readingData.setToDateTime(baseFromDateTime.plusHours(i + 1));
            readingData.setQuantityUnit("kWh");
            readingData.setQuantityValue(new BigDecimal(250));
            readingDataList.add(readingData);
        }
        usageProfile.setReadingData(readingDataList);
        usageProfile.setProviderProfileId("USAGE_RESIDENTIAL_CA_V5" + UUID.randomUUID());
        profileService.addProfile(usageProfile);

        Profile productionProfile = new Profile();
        productionProfile.setAccountId(newAccount.getAccountId());
        List<ReadingData> production = new ArrayList<ReadingData>();
        for(int i = 0; i < 8760; i++) {
            ReadingData readingData = new ReadingData();
            readingData.setFromDateTime(baseFromDateTime.plusHours(i));
            readingData.setToDateTime(baseFromDateTime.plusHours(i + 1));
            readingData.setQuantityUnit("kWh");
            readingData.setQuantityValue(new BigDecimal(200));
            production.add(readingData);
        }
        productionProfile.setReadingData(production);
        productionProfile.setProviderProfileId("PRODUCTION_RESIDENTIAL_CA_V5" + UUID.randomUUID());
        profileService.addProfile(productionProfile);

        AccountAnalysisRequest request = createSavingsAnalysis(usageProfile, productionProfile);
        request.setProviderAccountId(newAccount.getProviderAccountId());

        try {
            Response<AccountAnalysis> aaResponse = accountAnalysisService.calculateSavingsAnalysis(request);

            assertNotNull("restResponse null", aaResponse);
            assertEquals("bad status", Response.STATUS_SUCCESS, aaResponse.getStatus());
            assertEquals("bad type", AccountAnalysis.REST_TYPE, aaResponse.getType());
            assertNotNull("results null", aaResponse.getResults());
            assertEquals("results should be length one", 1, aaResponse.getResults().size());

            AccountAnalysis result = aaResponse.getResults().get(0);
            Map<String, BigDecimal> summary = result.getSummary();

            assertNotNull("summary null", summary);

            BigDecimal netAvoidedCost = summary.get("netAvoidedCost");
            assertFalse("netAvoidedCost should not be zero", BigDecimal.ZERO.compareTo(netAvoidedCost) == 0);

            BigDecimal preTotalCost = summary.get("preTotalCost");
            assertFalse("preTotalCost should not be zero", BigDecimal.ZERO.compareTo(preTotalCost) == 0);

            BigDecimal postTotalCost = summary.get("postTotalCost");
            assertFalse("postTotalCost should not be zero", BigDecimal.ZERO.compareTo(postTotalCost) == 0);

            Series monthlyPreSolarUtilitySeries = result.getSeriesByParameters("before", "MONTH", null);
            assertNotNull("no pre-solar monthly series found", monthlyPreSolarUtilitySeries);

            Integer seriesId = monthlyPreSolarUtilitySeries.getSeriesId();
            List<SeriesMeasure> monthlyPreSolarUtilitySeriesData = result.getSeriesDataBySeriesId(seriesId);
            assertNotNull("no pre-solar monthly seriesData (seriesId " + seriesId + ")", monthlyPreSolarUtilitySeriesData);

	    // Because it starts at 2014-10-10 (and therefore ends at 2015-10-10), we should see 13 months of data:
	    // Oct 2014 through Nov 2015
	    assertEquals("for a mid-month fromDateTime, didn't get 13 buckets", 13, monthlyPreSolarUtilitySeriesData.size());
        } finally {
            // delete account so we keep things clean
            deleteAccount(accountId);
        }
    }

    @Test
    public void testPopulateCosts() {
        Account account = new Account();
        account.setAccountName("test-api");
        account.setProviderAccountId("test-api" + UUID.randomUUID());
        Address address = new Address();
        address.setAddressString("221 Main Street, San Francisco, CA 94105");
        account.setAddress(address);
        Map<String, PropertyData> propertyDataMap = new HashMap<String, PropertyData>();
        PropertyData propertyData = new PropertyData();
        propertyData.setKeyName("customerClass");
        propertyData.setDataValue("1");
        propertyDataMap.put(propertyData.getKeyName(), propertyData);
        account.setProperties(propertyDataMap);
        Response<Account> restResponse = accountService.addAccount(account);
        assertNotNull("new account response is null", restResponse);
        assertEquals("bad status", restResponse.getStatus(), Response.STATUS_SUCCESS);
        assertEquals("bad type", restResponse.getType(), Account.REST_TYPE);
        assertTrue("bad count", restResponse.getCount() == 1);

        Account newAccount = restResponse.getResults().get(0);
        String accountId = newAccount.getAccountId();
        assertNotNull("accountId null", accountId);

        try {
	        DateTime baseFromDateTime = new DateTime("2013-01-01");
	
	        Profile usageProfile = new Profile();
	        usageProfile.setAccountId(newAccount.getAccountId());
	        List<ReadingData> readingDataList = new ArrayList<ReadingData>();
	        for(int i = 0; i < 8760; i++) {
	            ReadingData readingData = new ReadingData();
	            readingData.setFromDateTime(baseFromDateTime.plusHours(i));
	            readingData.setToDateTime(baseFromDateTime.plusHours(i + 1));
	            readingData.setQuantityUnit("kWh");
	            readingData.setQuantityValue(new BigDecimal(250));
	            readingDataList.add(readingData);
	        }
	        usageProfile.setReadingData(readingDataList);
	        usageProfile.setProviderProfileId("USAGE_RESIDENTIAL_CA_V5_" + UUID.randomUUID());
	        profileService.addProfile(usageProfile);
	
	        Profile productionProfile = new Profile();
	        productionProfile.setAccountId(newAccount.getAccountId());
	        List<ReadingData> production = new ArrayList<ReadingData>();
	        for(int i = 0; i < 8760; i++) {
	            ReadingData readingData = new ReadingData();
	            readingData.setFromDateTime(baseFromDateTime.plusHours(i));
	            readingData.setToDateTime(baseFromDateTime.plusHours(i + 1));
	            readingData.setQuantityUnit("kWh");
	            readingData.setQuantityValue(new BigDecimal(200));
	            production.add(readingData);
	        }
	        productionProfile.setReadingData(production);
	        productionProfile.setProviderProfileId("PRODUCTION_RESIDENTIAL_CA_V5_" + UUID.randomUUID());
	        profileService.addProfile(productionProfile);
	
	        AccountAnalysisRequest request = createSavingsAnalysis(usageProfile, productionProfile);
	        request.setProviderAccountId(newAccount.getProviderAccountId());
	        request.setPopulateCosts(true);

            Response<AccountAnalysis> aaResponse = accountAnalysisService.calculateSavingsAnalysis(request);

            assertNotNull("restResponse null", aaResponse);
            assertEquals("bad status", Response.STATUS_SUCCESS, aaResponse.getStatus());
            assertEquals("bad type", AccountAnalysis.REST_TYPE, aaResponse.getType());
            assertNotNull("results null", aaResponse.getResults());
            assertEquals("results should be length one", 1, aaResponse.getResults().size());

            AccountAnalysis result = aaResponse.getResults().get(0);
            Map<String, BigDecimal> summary = result.getSummary();

            assertNotNull("summary null", summary);

            BigDecimal netAvoidedCost = summary.get("netAvoidedCost");
            assertFalse("netAvoidedCost should not be zero", BigDecimal.ZERO.compareTo(netAvoidedCost) == 0);

            BigDecimal preTotalCost = summary.get("preTotalCost");
            assertFalse("preTotalCost should not be zero", BigDecimal.ZERO.compareTo(preTotalCost) == 0);

            BigDecimal postTotalCost = summary.get("postTotalCost");
            assertFalse("postTotalCost should not be zero", BigDecimal.ZERO.compareTo(postTotalCost) == 0);

            Series monthlyPreSolarUtilitySeries = result.getSeriesByParameters("before", "MONTH", null);
            assertNotNull("no pre-solar monthly series found", monthlyPreSolarUtilitySeries);

            Integer seriesId = monthlyPreSolarUtilitySeries.getSeriesId();
            List<SeriesMeasure> monthlyPreSolarUtilitySeriesData = result.getSeriesDataBySeriesId(seriesId);
            assertNotNull("no pre-solar monthly seriesData (seriesId " + seriesId + ")", monthlyPreSolarUtilitySeriesData);

            //populateCosts tests
            Map<Integer, CalculatedCost> seriesCosts = result.getSeriesCosts();
            assertNotNull("SeriesCosts was null", seriesCosts);
            assertEquals("Did not have the correct number of seriesCosts", 2, seriesCosts.size());
            
            boolean foundTierLimit = false;
            CalculatedCost firstScenCosts = seriesCosts.get(1);
            
            for(CalculatedCostItem c : firstScenCosts.getItems()) {
            	if (c.getTierUpperLimit() != null || c.getTierLowerLimit() != null) {
            		foundTierLimit = true;
            	}
            }
            
            assertTrue("Didn't find a tierUpperLimit or tierLowerLimit", foundTierLimit);
            
	    // Because it starts at 2014-10-10 (and therefore ends at 2015-10-10), we should see 13 months of data:
	    // Oct 2014 through Nov 2015
	    assertEquals("for a mid-month fromDateTime, didn't get 13 buckets", 13, monthlyPreSolarUtilitySeriesData.size());
        } finally {
            // delete account so we keep things clean
            deleteAccount(accountId);
        }
    }
    
    @Test
    public void testGetValidSeriesByParameters() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters("before", "MONTH", null);
    	
    	assertEquals("Got the wrong series scenario", "before", series.getScenario());
    	assertEquals("Got the wrong series period", "MONTH", series.getSeriesPeriod());
    }
    
    @Test
    public void testGetSeriesByInvalidParameters() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters("before", "100", null);
    	
    	assertNull(series);
    }
    
    @Test
    public void testGetSeriesByOneNullParameter() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters("before", null, null);
    	
    	assertNull(series);
    }
    
    @Test
    public void testGetSeriesByTwoNullParameters() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters(null, null, null);
    	
    	assertNull(series);
    }
    
    @Test
    public void testGetSeriesDataByGoodId() {
    	Integer seriesId = new Integer(1);
    	List<SeriesMeasure> measures = testAnalysisWithCosts.getSeriesDataBySeriesId(seriesId);
    	
    	for (SeriesMeasure measure : measures) {
    		assertEquals("Got data for the wrong series", seriesId, measure.getSeriesId());
    	}
    }
    
    @Test
    public void testGetSeriesDataByBadId() {
    	Integer seriesId = new Integer(150);
    	List<SeriesMeasure> measures = testAnalysisWithCosts.getSeriesDataBySeriesId(seriesId);
    	
    	assertEquals("Got measures for an invalid seriesId", 0, measures.size());
    }
    
    @Test
    public void testGetCostsByGoodSeriesName() {
    	Long beforeMtid = new Long(525);
    	Long afterMtid = new Long(522);
    	CalculatedCost before = testAnalysisWithCosts.getSeriesCostsByParameters("before", "MONTH", null);
    	CalculatedCost after = testAnalysisWithCosts.getSeriesCostsByParameters("after", "MONTH", null);
    	
    	assertEquals("Got the wrong scenario for before", beforeMtid, before.getMasterTariffId());
    	assertEquals("Got the wrong scenario for after", afterMtid, after.getMasterTariffId());
    }
    
    @Test
    public void testGetCostsByNonExistentSeriesName() {
    	CalculatedCost costs = testAnalysisWithCosts.getSeriesCostsByParameters("invalid", "MONTH", null);
    	
    	assertNull(costs);
    }
    
    @Test
    public void testGetCostsForBeforeAnnual() {
    	CalculatedCost costs = testAnalysisWithCosts.getSeriesCostsByParameters("before", "YEAR", null);
    	
    	assertNull(costs);
    }
    
    @Test
    public void testGetCostsByNameWithNoCosts() {
    	CalculatedCost costs = testAnalysisWithCosts.getSeriesCostsByParameters("solar", "MONTH", null);
    	
    	assertNull(costs);
    }
    
    @Test
    public void testGetCostsWhenNoCosts() {
    	CalculatedCost before = testAnalysisNoCosts.getSeriesCostsByParameters("before", "MONTH", null);
    	
    	assertNull(before);
    }
    
    private AccountAnalysisRequest createSavingsAnalysis(Profile usageProfile, Profile productionProfile) {
        AccountAnalysisRequest request = new AccountAnalysisRequest();
        request.setFromDateTime(new DateTime("2014-10-10"));

        List<PropertyData> properties = new ArrayList<PropertyData>();
        PropertyData propertyData = new PropertyData();
        propertyData.setScenarios("before");
        propertyData.setKeyName("masterTariffId");
        propertyData.setDataValue("522");
        properties.add(propertyData);

        propertyData = new PropertyData();
        propertyData.setScenarios("after");
        propertyData.setKeyName("masterTariffId");
        propertyData.setDataValue("522");
        properties.add(propertyData);

        propertyData = new PropertyData();
        propertyData.setScenarios("before,after");
        propertyData.setKeyName("rateInflation");
        propertyData.setDataValue("3.5");
        properties.add(propertyData);


        propertyData = new PropertyData();
        propertyData.setScenarios("solar");
        propertyData.setKeyName("rateInflation");
        propertyData.setDataValue("1.9");
        properties.add(propertyData);


        propertyData = new PropertyData();
        propertyData.setScenarios("after,solar");
        propertyData.setKeyName("solarDegradation");
        propertyData.setDataValue("1.5");
        properties.add(propertyData);

        propertyData = new PropertyData();
        propertyData.setScenarios("before");
        propertyData.setKeyName("providerProfileId");
        propertyData.setDataValue(usageProfile.getProviderProfileId());
        properties.add(propertyData);

        propertyData = new PropertyData();
        propertyData.setScenarios("after,solar");
        propertyData.setKeyName("providerProfileId");
        propertyData.setDataValue(productionProfile.getProviderProfileId());
        properties.add(propertyData);

        request.setPropertyInputs(properties);

        List<TariffRate> tariffRates = new ArrayList<TariffRate>();
        TariffRate tariffRate = new TariffRate();
        tariffRate.setChargeType(ChargeType.FIXED_PRICE);
        tariffRate.setScenarios("solar");
        TariffRateBand rateBand = new TariffRateBand();
        rateBand.setRateAmount(new BigDecimal(137.05));
        List<TariffRateBand> rateBands = new ArrayList<TariffRateBand>();
        rateBands.add(rateBand);
        tariffRate.setRateBands(rateBands);
        tariffRates.add(tariffRate);

        request.setRateInputs(tariffRates);

        return request;
    }

    private void deleteAccount(String accountId) {

        // delete account so we keep things clean
        DeleteAccountRequest request = new DeleteAccountRequest();
        request.setHardDelete(Boolean.TRUE);
        request.setAccountId(accountId);
        Response<Account> deleteResponse = accountService
                .deleteAccount(request);

        assertNotNull("restResponse null", deleteResponse);
        assertEquals("bad status", deleteResponse.getStatus(),
                Response.STATUS_SUCCESS);
        assertEquals("bad type", deleteResponse.getType(), Account.REST_TYPE);

    }

}
