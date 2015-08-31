package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.api.request.GetAccountRatesRequest;
import com.genability.client.api.request.GetAccountRequest;
import com.genability.client.api.request.GetAccountsRequest;
import com.genability.client.types.Account;
import com.genability.client.types.Address;
import com.genability.client.types.PropertyData;
import com.genability.client.types.Response;
import com.genability.client.types.Tariff;
import com.genability.client.types.TariffRate;

public class AccountServiceTests  extends BaseServiceTests {

	@Test
	public void testAddAccount() {
		//test
		Account newAccount = new Account();
		newAccount.setAccountName("Java Client Lib Test Add Account - CAN DELETE");
		
		// call add account helper method
		newAccount = addAccount(newAccount);
		
		// delete account so we keep things clean
		deleteAccount(newAccount.getAccountId());

	}
	
	@Test
	public void testUpdateAccount() {
		String owner = "Test User";

		Account unsavedAccount = new Account();
		unsavedAccount.setAccountName("Java Client Lib Test Add Account - CAN DELETE");
		
		// call add account helper method
		Account savedAccount = addAccount(unsavedAccount);
		try {
			savedAccount.setOwner(owner);
	
			Response<Account> restResponse = accountService.updateAccount(savedAccount);
			assertNotNull("restResponse null", restResponse);
			assertEquals("bad status", restResponse.getStatus(), Response.STATUS_SUCCESS);
			assertEquals("bad type", restResponse.getType(), Account.REST_TYPE);
			assertTrue("bad count", restResponse.getCount() == 1);

			Account updatedAccount = restResponse.getResults().get(0);
			assertEquals("Didn't update owner",	updatedAccount.getOwner(), owner);
		} finally {
			// delete account so we keep things clean
			deleteAccount(savedAccount.getAccountId());
		}
	}
	
	@Test
	public void testUpsertWithNewAccount() {
		String accountName = "Java Client Lib Test Add Account - CAN DELETE";
		String providerAccountId = "javaapi-test-id-01";

		Account newAccount = new Account();
		newAccount.setAccountName(accountName);
		newAccount.setProviderAccountId(providerAccountId);
		
		Response<Account> restResponse = accountService.updateAccount(newAccount);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), Account.REST_TYPE);
		assertTrue("bad count", restResponse.getCount() == 1);
		Account returnedAccount = null;

		try {
			returnedAccount = restResponse.getResults().get(0);
			assertEquals("providerAccountIds didn't match",
					newAccount.getProviderAccountId(),
					returnedAccount.getProviderAccountId());
			assertEquals("Didn't upsert accountName correctly.", returnedAccount.getAccountName(), accountName);
		} finally {
			// delete account so we keep things clean
			if (returnedAccount != null) {
				deleteAccount(returnedAccount.getAccountId());
			}
		}

	}
	
	@Test
	public void testGetAccounts() {
		
		GetAccountsRequest request = new GetAccountsRequest();
		
		// A few examples of how to search and sort
		// request.setSortOn("customerOrgName");
		// request.setSearch("acme");
		// request.setSearchOn("customerOrgName");

		Response<Account> restResponse = accountService.getAccounts(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);

	}
	
	@Test
	public void testPaginatedAccountList() {
		int numberOfAccountsToCreate = 10;
		int pageCount = 5;
		String[] createdAccountIds = new String[numberOfAccountsToCreate];
		
		for(int i = 0; i < numberOfAccountsToCreate; i++) {
			Account newAccount = new Account();
			newAccount.setAccountName(String.format("JAVA CLIENT TEST ACCOUNT #%d - CAN DELETE", i));
			
			Account addedAccount = addAccount(newAccount);
			createdAccountIds[i] = addedAccount.getAccountId();
		}
		
		try {
			GetAccountsRequest request = new GetAccountsRequest();
			request.setPageCount(pageCount);
			request.setSearch("JAVA CLIENT TEST ACCOUNT");
			request.setSearchOn("accountName");
			Response<Account> restResponse = accountService.getAccounts(request);
			
			int totalAccounts = restResponse.getCount();
			int accountsVisited = 0;
			
			while(accountsVisited < totalAccounts) {
				assertEquals("Didn't set pageCount correctly", pageCount, restResponse.getPageCount().intValue());
				assertEquals("Didn't page through the account list correctly.", accountsVisited, restResponse.getPageStart().intValue());
	
				accountsVisited += restResponse.getResults().size();
				
				request.setPageStart(restResponse.getPageStart() + restResponse.getPageCount());
				restResponse = accountService.getAccounts(request);
			}
			
			assertEquals("Visited too many accounts.", accountsVisited, totalAccounts);
		} finally {
			// make sure that these accounts get cleaned up
			for(String accountId : createdAccountIds) {
				deleteAccount(accountId);
			}
		}
	}
	
	@Test
	public void testGetAccount() {

		GetAccountRequest request = new GetAccountRequest();
		
		// Uncomment one of the below to retrieve a particular Account	

		// request.setAccountId("account_id_here");
		// request.setProviderAccountId("your_own_account_id_here");
		Response<Account> restResponse = accountService.getAccount(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);

	}

	@Test
	public void testDeleteAccount() {

		Account addAccount = new Account();
		addAccount
				.setAccountName("Java Client Lib Test Delete Account - CAN DELETE");

		// call add account helper method
		addAccount = addAccount(addAccount);

		// test delete account
		deleteAccount(addAccount.getAccountId());

	}

	@Test
	public void testGetAccountProperties() {

		// Add account with properties
		Account addAccount = new Account();
		addAccount
				.setAccountName("Java Client Lib Test Account Get Properties - CAN DELETE");

		PropertyData property1 = new PropertyData();
		property1.setKeyName("territoryId");
		property1.setDataValue("123");
		addAccount.setProperty("territoryId", property1);

		addAccount = addAccount(addAccount);

		// get account with properties
		GetAccountRequest request = new GetAccountRequest();
		request.setAccountId(addAccount.getAccountId());
		Response<PropertyData> restResponse = accountService
				.getAccountProperties(request);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), PropertyData.REST_TYPE);
		assertNotNull("Properties null", restResponse.getResults());

		// ensure territoryId property is on account
		for (PropertyData propertyData : restResponse.getResults()) {
			assertEquals("territoryId", propertyData.getKeyName());
		}

		// delete account so we keep things clean
		deleteAccount(addAccount.getAccountId());

	}
	
	@Test
	public void testInterviewAccount() {

		Account addAccount = new Account();
		addAccount
				.setAccountName("Java Client Lib Test Interview Account - CAN DELETE");

		// set address
		Address address = new Address();
		address.setAddressString("94105");
		addAccount.setAddress(address);

		// call add account helper method
		addAccount = addAccount(addAccount);

		// call interview account
		Response<PropertyData> restResponse = accountService.interviewAccount(
				addAccount.getAccountId(), null);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), PropertyData.REST_TYPE);
		assertNotNull("Properties null", restResponse.getResults());

		// ensure territoryId property is on account
		for (PropertyData propertyData : restResponse.getResults()) {
			assertEquals("customerClass", propertyData.getKeyName());
		}

	}

	@Test
	public void testGetAccountTariffs() {

		Account addAccount = new Account();
		addAccount
				.setAccountName("Java Client Lib Test Interview Account - CAN DELETE");

		// set tariff
		Tariff tariff = new Tariff();
		tariff.setMasterTariffId(512l);
		List<Tariff> tariffs = new ArrayList<Tariff>();
		tariffs.add(tariff);
		addAccount.setTariffs(tariffs);

		// call add account helper method
		addAccount = addAccount(addAccount);

		// retrieve account with tariff
		Account account = getAccount(addAccount.getAccountId());

		// ensure account with tariff on account
		assertNotNull("Tariffs null", account.getTariffs());

		for (Tariff accountTariff : account.getTariffs()) {
			assertEquals(512l, accountTariff.getMasterTariffId().longValue());
		}

		// delete account so we keep things clean
		deleteAccount(account.getAccountId());

	}

	@Test
	public void testGetAccountRates() {

		Account account = new Account();
		account
				.setAccountName("Java Client Lib Test Interview Account - CAN DELETE");

		// set tariff
		Tariff tariff = new Tariff();
		tariff.setMasterTariffId(512l);
		List<Tariff> tariffs = new ArrayList<Tariff>();
		tariffs.add(tariff);
		account.setTariffs(tariffs);

		// call add account helper method
		account = addAccount(account);

		// retrieve account rates based on added account tariff
		GetAccountRatesRequest request = new GetAccountRatesRequest();
		request.setAccountId(account.getAccountId());

		Response<TariffRate> restResponse = accountService
				.getAccountRates(request);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), TariffRate.REST_TYPE);
		assertNotNull("Rates is null", restResponse.getResults());

		for (TariffRate tariffRate : restResponse.getResults()) {
			assertNotNull("tariffRateId null", tariffRate.getTariffRateId());
		}

		// delete account so we keep things clean
		deleteAccount(account.getAccountId());

	}
	
	//
	// TODO - switch to use helper methods on baseServiceTests
	//

	/**
	 * Private helper method to call add account and test for success
	 * 
	 * @param addAccount The addAccount.
	 * @return The return value.
	 */
	private Account addAccount(Account addAccount) {

		Response<Account> restResponse = accountService.addAccount(addAccount);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), Account.REST_TYPE);
		assertTrue("bad count", restResponse.getCount() > 0);

		Account newAccount = null;
		for (Account account : restResponse.getResults()) {
			assertNotNull("accountId null", account.getAccountId());
			newAccount = account;
		}

		return newAccount;
	}

	/**
	 * Private helper method to delete account and test for success
	 * 
	 * @param accountId The accountId.
	 */
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

	private Account getAccount(String accountId) {

		GetAccountRequest request = new GetAccountRequest();
		request.setAccountId(accountId);

		Response<Account> restResponse = accountService.getAccount(request);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(),
				Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), Account.REST_TYPE);

		Account getAccount = null;
		for (Account account : restResponse.getResults()) {
			assertNotNull("accountId null", account.getAccountId());
			getAccount = account;
		}

		return getAccount;

	}

}
