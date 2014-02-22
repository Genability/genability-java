package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.types.Account;
import com.genability.client.types.Response;
import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.api.request.GetAccountsRequest;
import com.genability.client.api.request.GetAccountRequest;

public class AccountService extends BaseService {

    private static final TypeReference<Response<Account>> ACCOUNT_RESPONSE_TYPEREF = new TypeReference<Response<Account>>() {};
	
	public Response<Account> getAccounts(GetAccountsRequest request)
	{
		if(log.isDebugEnabled()) log.debug("getAccounts called");
		
		Response<Account> response = this.callGet(
				"beta/accounts", 
				request.getQueryParams(),
				ACCOUNT_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getAccounts completed");
		
		return response;
	}

	
	public Response<Account> getAccount(GetAccountRequest request)
	{

		if(log.isDebugEnabled()) log.debug("getAccount called");

		String uri = "beta/accounts";
		if (request.getAccountId() != null && request.getAccountId().length() !=0) {
			uri += "/" + request.getAccountId();
		}

		Response<Account> response = this.callGet(
				uri,
				request.getQueryParams(),
				ACCOUNT_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getAccount completed");
		
		return response;
		
	}
	
	
	public Response<Account> addAccount(Account account) {
		

		if(log.isDebugEnabled()) log.debug("addAccount called");
	
		Response<Account> response = this.callPost(
				"beta/accounts", 
				account,
				ACCOUNT_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("addAccount completed");
		
		return response;
		
	}

	public Response<Account> deleteAccount(DeleteAccountRequest request) {
		

		if(log.isDebugEnabled()) log.debug("deleteAccount called");
	
		String uri = "beta/accounts";
		if (request.getAccountId() != null && request.getAccountId().length() !=0) {
			uri += "/" + request.getAccountId();
		}		
		
		Response<Account> response = this.callDelete(
				uri,
				request.getQueryParams(),
				ACCOUNT_RESPONSE_TYPEREF);
		if(log.isDebugEnabled()) log.debug("deleteAccount completed");
		
		return response;
		
	}
	
	
}
