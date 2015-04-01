package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetIncentiveRequest;
import com.genability.client.api.request.GetIncentivesRequest;
import com.genability.client.types.Incentive;
import com.genability.client.types.Response;

public class IncentiveService extends BaseService {
	private static final TypeReference<Response<Incentive>> INCENTIVE_RESPONSE_TYPEREF = new TypeReference<Response<Incentive>>() {};
	
	public Response<Incentive> getIncentives(GetIncentivesRequest request) {
		if(log.isDebugEnabled()) {
			log.debug("getIncentives called");
		}
		
		String url = String.format("v1/incentives");
		Response<Incentive> response = this.callGet(url,
				request.getQueryParams(),
				INCENTIVE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()){
			log.debug("getIncentives completed");
		}
		
		return response;
	}
	
	public Response<Incentive> getIncentive(GetIncentiveRequest request) {
		if(log.isDebugEnabled()) {
			log.debug("getIncentive called");
		}
		
		String url = String.format("v1/incentives/%s", request.getMasterTariffId());
		Response<Incentive> response = this.callGet(url,
				request.getQueryParams(),
				INCENTIVE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()){
			log.debug("getIncentive completed");
		}
		
		return response;
	}
	
	public Response<Incentive> getInstantIncentives (GetIncentivesRequest request) {
		if(log.isDebugEnabled()) {
			log.debug("getInstantIncentives called");
		}
		
		String url = String.format("v1/incentives/instant");
		Response<Incentive> response = this.callGet(url,
				request.getQueryParams(),
				INCENTIVE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()){
			log.debug("getInstantIncentives completed");
		}
		
		return response;
	}
}
