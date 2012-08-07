package com.genability.client.api.service;

import org.codehaus.jackson.type.TypeReference;

import com.genability.client.types.Account;
import com.genability.client.types.Response;
import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.api.request.GetAccountsRequest;
import com.genability.client.api.request.GetAccountRequest;

public class AccountService extends BaseService {

	
	public Response<Account> getAccounts(GetAccountsRequest request)
	{
		if(log.isDebugEnabled()) log.debug("getAccounts called");
		
		@SuppressWarnings("unchecked")
		Response<Account> response = (Response<Account>) this.callGet(
				"beta/accounts", 
				request.getQueryParams(),
				new TypeReference<Response<Account>>() { });
		
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

		@SuppressWarnings("unchecked")
		Response<Account> response = (Response<Account>) this.callGet(
				uri,
				request.getQueryParams(),
				new TypeReference<Response<Account>>() { });
		
		if(log.isDebugEnabled()) log.debug("getAccount completed");
		
		return response;
		
	}
	
	
	public Response<Account> addAccount(Account account) {
		

		if(log.isDebugEnabled()) log.debug("addAccount called");
	
		@SuppressWarnings("unchecked")
		Response<Account> response = (Response<Account>) this.callPost(
				"beta/accounts", 
				account,
				new TypeReference<Response<Account>>() { });
		
		if(log.isDebugEnabled()) log.debug("addAccount completed");
		
		return response;
		
	}

	public Response<Account> deleteAccount(DeleteAccountRequest request) {
		

		if(log.isDebugEnabled()) log.debug("deleteAccount called");
	
		String uri = "beta/accounts";
		if (request.getAccountId() != null && request.getAccountId().length() !=0) {
			uri += "/" + request.getAccountId();
		}		
		
		@SuppressWarnings("unchecked")
		Response<Account> response = (Response<Account>) this.callDelete(
				uri,
				request.getQueryParams(),
				new TypeReference<Response<Account>>() { });
		if(log.isDebugEnabled()) log.debug("deleteAccount completed");
		
		return response;
		
	}
	
	
}
