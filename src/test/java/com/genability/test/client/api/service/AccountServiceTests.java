package com.genability.test.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.genability.client.api.service.AccountService;
import com.genability.client.types.Account;
import com.genability.client.types.Response;
import com.genability.client.api.request.GetAccountsRequest;
import com.genability.client.api.request.GetAccountRequest;

public class AccountServiceTests  extends BaseServiceTests {
	
	
	private static AccountService accountService;
	
	@BeforeClass
	public static void runBeforeClass() {

		accountService = new AccountService();
		accountService.setAppId(appId);
		accountService.setAppKey(appKey);
		
	}

	
	@Test
	public void testAddAccount() {
		
		Account addAccount = new Account();
		addAccount.setAccountName("Java Client Lib Test Account - CAN DELETE");

		Response<Account> restResponse = accountService.addAccount(addAccount);
		
		assertNotNull("restResponse null",restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);
		assertTrue("bad count",restResponse.getCount() > 0);
		
		
		for(Account account : restResponse.getResults()) {
			
			assertNotNull("accountId null",account.getAccountId());
			
		}
		
	}
	
	@Test
	public void testGetAccounts() {
		
		GetAccountsRequest request = new GetAccountsRequest();
		Response<Account> restResponse = accountService.getAccounts(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Account.REST_TYPE);

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
}
