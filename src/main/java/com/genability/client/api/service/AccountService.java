package com.genability.client.api.service;

import java.text.MessageFormat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.DeleteAccountRequest;
import com.genability.client.api.request.GetAccountRatesRequest;
import com.genability.client.api.request.GetAccountRequest;
import com.genability.client.api.request.GetAccountTariffsRequest;
import com.genability.client.api.request.GetAccountsRequest;
import com.genability.client.api.request.signal.GetAccountCalculatedCostRequest;
import com.genability.client.api.request.signal.GetCalculatedCostRequest;
import com.genability.client.types.Account;
import com.genability.client.types.PropertyData;
import com.genability.client.types.Response;
import com.genability.client.types.Tariff;
import com.genability.client.types.TariffRate;
import com.genability.client.types.signal.CalculatedCost;

public class AccountService extends BaseService {

    private static final TypeReference<Response<Account>> ACCOUNT_RESPONSE_TYPEREF = new TypeReference<Response<Account>>() {};

	private static final TypeReference<Response<PropertyData>> PROPERTY_DATA_RESPONSE_TYPEREF = new TypeReference<Response<PropertyData>>() {
	};
	
	private static final TypeReference<Response<TariffRate>> TARIFF_RATE_RESPONSE_TYPEREF = new TypeReference<Response<TariffRate>>() {
	};

	private static final TypeReference<Response<Tariff>> TARIFF_RESPONSE_TYPEREF = new TypeReference<Response<Tariff>>() {
	};

	private static final TypeReference<Response<CalculatedCost>> CALCULATEDCOST_RESPONSE_TYPEREF =
			new TypeReference<Response<CalculatedCost>>() { };


	public Response<Account> getAccounts(GetAccountsRequest request)
	{
		if(log.isDebugEnabled()) log.debug("getAccounts called");
		
		Response<Account> response = this.callGet(
"v1/accounts",
				request.getQueryParams(),
				ACCOUNT_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getAccounts completed");
		
		return response;
	}

	
	public Response<Account> getAccount(GetAccountRequest request)
	{

		if(log.isDebugEnabled()) log.debug("getAccount called");

		String uri = "v1/accounts";
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
	
	
	public Response<Account> deleteAccount(DeleteAccountRequest request) {

		if (log.isDebugEnabled())
			log.debug("deleteAccount called");

		String uri = "v1/accounts";
		if (request.getAccountId() != null
				&& request.getAccountId().length() != 0) {
			uri += "/" + request.getAccountId();
		}

		Response<Account> response = this.callDelete(uri,
				request.getQueryParams(), ACCOUNT_RESPONSE_TYPEREF);
		if (log.isDebugEnabled())
			log.debug("deleteAccount completed");

		return response;

	}

	public Response<PropertyData> getAccountProperties(GetAccountRequest request) {

		if (log.isDebugEnabled())
			log.debug("getAccountProperties called");

		String uri = "v1/accounts";
		if (request.getAccountId() != null
				&& request.getAccountId().length() != 0) {
			uri += "/" + request.getAccountId();
			uri += "/properties";
		}

		Response<PropertyData> response = this.callGet(uri,
				request.getQueryParams(), PROPERTY_DATA_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getAccountProperties completed");

		return response;

	}

	public Response<Account> addAccount(Account account) {
		

		if(log.isDebugEnabled()) log.debug("addAccount called");
	
		Response<Account> response = this.callPost("v1/accounts",
				account,
				ACCOUNT_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("addAccount completed");
		
		return response;
		
	}

	public Response<Account> updateAccount(Account account) {

		if (log.isDebugEnabled())
			log.debug("updateAccount called");

		String uri = "v1/accounts";

		if (account.getAccountId() != null
				&& account.getAccountId().length() != 0) {
			uri += "/" + account.getAccountId();
		}

		Response<Account> response = this.callPut(uri, account,
				ACCOUNT_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("updateAccount completed");

		return response;

	}
	
	public Response<PropertyData> interviewAccount(String accountId,
			PropertyData interviewAnswer) {

		if (log.isDebugEnabled())
			log.debug("interviewAccount called");

		String uri = "v1/accounts/{0}/interview";

		if (accountId != null && accountId.length() != 0) {
			uri = MessageFormat.format(uri, accountId);
		}

		// Workaround so the route catches. A null request payload will hit the
		// wrong route.
		if (interviewAnswer == null) {
			interviewAnswer = new PropertyData();
		}

		Response<PropertyData> response = this.callPut(uri, interviewAnswer,
				PROPERTY_DATA_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("interviewAccount completed");

		return response;

	}

	public Response<TariffRate> getAccountRates(GetAccountRatesRequest request) {

		if (log.isDebugEnabled())
			log.debug("getAccountRates called");

		String uri = "v1/accounts/{0}/rates";

		if (request.getAccountId() != null
				&& request.getAccountId().length() != 0) {
			uri = MessageFormat.format(uri, request.getAccountId());
		}

		Response<TariffRate> response = this.callGet(uri,
				request.getQueryParams(), TARIFF_RATE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getAccountRates completed");

		return response;

	}

	public Response<Tariff> getAccountTariffs(GetAccountTariffsRequest request) {

		if (log.isDebugEnabled())
			log.debug("getAccountTariffs called");

		String uri = "v1/accounts/{0}/tariffs";

		if (request.getAccountId() != null
				&& request.getAccountId().length() != 0) {
			uri = MessageFormat.format(uri, request.getAccountId());
		}

		Response<Tariff> response = this.callGet(uri, request.getQueryParams(),
				TARIFF_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getAccountTariffs completed");

		return response;

	}

	public Response<CalculatedCost> getCalculatedCost(GetAccountCalculatedCostRequest request)
	{
		if (log.isDebugEnabled()) {
			log.debug("getCalculatedCost called");
		}

		String uri = "v1/accounts/";

		if (request.getAccountId() != null && request.getAccountId().length() != 0) {
			uri += "{0}/calculate";
			uri = MessageFormat.format(uri, request.getAccountId());
		} else if (request.getProviderAccountId() != null && request.getProviderAccountId().length() != 0) {
			uri += "pid/{0}/calculate";
			uri = MessageFormat.format(uri, request.getProviderAccountId());
		} else {
			throw new GenabilityException("Either accountId or providerAccountId must be set");
		}

		Response<CalculatedCost> response = this.callPost(
				uri,
				request,
				CALCULATEDCOST_RESPONSE_TYPEREF
		);

		return response;
	}


}
