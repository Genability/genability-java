package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.junit.Test;

import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.types.Account;
import com.genability.client.types.Address;
import com.genability.client.types.ChargeType;
import com.genability.client.types.Profile;
import com.genability.client.types.PropertyData;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;
import com.genability.client.types.AccountsAnalysis;
import com.genability.client.types.TariffRate;
import com.genability.client.types.TariffRateBand;

/**
 * Created by nsingh on 11/20/14.
 */
public class AccountsAnalysisTests extends BaseServiceTests {

    @Test
    public void testSavingsAnalysis() {

        Account account = new Account();
        account.setAccountName("test-api");
        account.setProviderAccountId("test-api"+UUID.randomUUID());
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
        assertNotNull("new account response is null",restResponse);
        assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
        assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);
        assertTrue("bad count",restResponse.getCount() > 0);

        Account newAccount = null;
        for(Account result : restResponse.getResults()) {
            newAccount = result;
            assertNotNull("accountId null",result.getAccountId());
        }

        Profile usageProfile = new Profile();
        usageProfile.setAccountId(newAccount.getAccountId());
        List<ReadingData> readingDataList = new ArrayList<ReadingData>();
        for(int i=0;i<12;i++) {
            ReadingData readingData = new ReadingData();
            readingData.setFromDateTime(new DateTime("2014-01-01"));
            readingData.setToDateTime(new DateTime("2014-02-01"));
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
        for(int i=0;i<12;i++) {
            ReadingData readingData = new ReadingData();
            readingData.setFromDateTime(new DateTime("2014-01-01"));
            readingData.setToDateTime(new DateTime("2014-02-01"));
            readingData.setQuantityUnit("kWh");
            readingData.setQuantityValue(new BigDecimal(250));
            production.add(readingData);
        }
        productionProfile.setReadingData(production);
        productionProfile.setProviderProfileId("PRODUCTION_RESIDENTIAL_CA_V5" + UUID.randomUUID());
        profileService.addProfile(productionProfile);

        AccountsAnalysis accountsAnalysis = createSavingsAnalysis(usageProfile, productionProfile);
        accountsAnalysis.setProviderAccountId(newAccount.getProviderAccountId());

        try {
            accountsAnalysisService.calculateAccountsAnalysis(accountsAnalysis);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            // delete account so we keep things clean
            deleteAccount(account.getAccountId());
        }
    }

    private AccountsAnalysis createSavingsAnalysis(Profile usageProfile, Profile productionProfile) {
        AccountsAnalysis accountsAnalysis = new AccountsAnalysis();
        accountsAnalysis.setFromDateTime(new DateTime(2014-10-10));

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

        accountsAnalysis.setPropertyInputs(properties);

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

        accountsAnalysis.setRateInputs(tariffRates);

        return accountsAnalysis;
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
