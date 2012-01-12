package com.genability.client.api.service;

import org.codehaus.jackson.type.TypeReference;

import com.genability.client.types.Account;
import com.genability.client.types.Response;

public class AccountService extends BaseService {

	
	public Response<Account> getAccounts()
	{
		
		//TODO - we are adding really soon!
		return null;
	}

	
	public Response<Account> getAccount()
	{
		
		//TODO - we are adding really soon!
		return null;
	}
	
	
	public Response<Account> addAccount(Account account) {
		

		if(log.isDebugEnabled()) log.debug("addAccount called");
		
		//betaStandardCurrency into Query parameters
		
		@SuppressWarnings("unchecked")
		Response<Account> response = (Response<Account>) this.callPost(
				"beta/accounts", 
				account,
				new TypeReference<Response<Account>>() { });
		
		if(log.isDebugEnabled()) log.debug("addAccount completed");
		
		return response;
		
		
	}
	
}
