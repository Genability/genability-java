package com.genability.client.api.service;

import java.text.MessageFormat;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetCalculatedCostRequest;
import com.genability.client.api.request.GetCalculationInputsRequest;
import com.genability.client.types.CalculatedCost;
import com.genability.client.types.DetailLevel;
import com.genability.client.types.GroupBy;
import com.genability.client.types.PropertyData;
import com.genability.client.types.Response;

public class CalculateService extends BaseService {
	
    private static final TypeReference<Response<CalculatedCost>> CALCULATEDCOST_RESPONSE_TYPEREF = new TypeReference<Response<CalculatedCost>>() {};
    private static final TypeReference<Response<PropertyData>> PROPERTYDATA_RESPONSE_TYPEREF = new TypeReference<Response<PropertyData>>() {};
	
	/**
	 * Calls the REST service to run a calculation
	 * @param request
	 * @return
	 */
	public Response<CalculatedCost> getCalculatedCost(GetCalculatedCostRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getCalculatedCost called");
		
		String uri = "public/calculate";
		if (request.getAccountId() !=null) {
			uri += "/account/" + request.getAccountId();
			request.setAccountId(null);
		} else if (request.getMasterTariffId() != null) {
			uri += "/" + request.getMasterTariffId();
			request.setMasterTariffId(null);
		} else {
			//This will use only query string parameters to run the calc.
			//Not currently doing this anywhere in the test suite.
		}

		Response<CalculatedCost> response = this.callPost(
				uri,
				request,
				CALCULATEDCOST_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getCalculatedCost completed");
		
		return response;
		
	}
	
	/**
	 * Calls the REST service to get the required inputs to run a Calculation
	 * for a given tariffId.  The tariffId can be explicitly stated within the
	 * GetCalculationInputsRequest object, or if it is null, the service will 
	 * expect it to be in the Account that is passed in. 
	 * @param request
	 * @return
	 */
	public Response<PropertyData> getCalculationInputs(GetCalculationInputsRequest request) {
	
		 if(log.isDebugEnabled()) log.debug("getCalculationInputs called");
			
			String uri = "public/calculate";
			if (request.getMasterTariffId() != null) {
				uri += "/" + request.getMasterTariffId();
			} else {
				//This means we will be getting the tariffId from within the Account.
				//Do nothing.
			}
			
			Response<PropertyData> response = this.callGet(
					uri,
					request.getQueryParams(),
					PROPERTYDATA_RESPONSE_TYPEREF);
			
			if(log.isDebugEnabled()) log.debug("getCalculationInputs completed");
			
			return response;
	 }

	/**
	 * Runs calculation on Account using a simplified method with passed in
	 * parameters.
	 * @param accountId
	 * @param masterTariffId
	 * @param fromDateTime
	 * @param toDateTime
	 * @param detailLevel
	 * @param groupBy
	 * @return
	 */
	public Response<CalculatedCost> runCalculationOnAccount(String accountId,
			Long masterTariffId, DateTime fromDateTime, DateTime toDateTime,
			DetailLevel detailLevel, GroupBy groupBy) {

		if (log.isDebugEnabled())
			log.debug("runCalculationOnAccount called");

		String uri = "public/calculate/account/{accountId}";

		if (accountId != null) {
			uri = MessageFormat.format(uri, accountId);
		}

		GetCalculatedCostRequest request = new GetCalculatedCostRequest();
		request.setMasterTariffId(masterTariffId);
		request.setAccountId(accountId);
		request.setFromDateTime(fromDateTime);
		request.setToDateTime(toDateTime);
		request.setDetailLevel(detailLevel);
		request.setGroupBy(groupBy);

		Response<CalculatedCost> response = this.callGet(uri,
				request.getQueryParams(),
				CALCULATEDCOST_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("runCalculationOnAccount completed");

		return response;
	}

}
