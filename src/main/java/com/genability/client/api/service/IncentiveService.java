package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetIncentiveApplicabilitiesRequest;
import com.genability.client.api.request.GetIncentivesRequest;
import com.genability.client.types.Incentive;
import com.genability.client.types.IncentiveApplicability;
import com.genability.client.types.Response;

public class IncentiveService extends BaseService {
	private static final TypeReference<Response<Incentive>> INCENTIVE_RESPONSE_TYPEREF = 
			new TypeReference<Response<Incentive>>() {};
	private static final TypeReference<Response<IncentiveApplicability>> INCENTIVE_APPLICABILITY_RESPONSE_TYPEREF = 
			new TypeReference<Response<IncentiveApplicability>>() {};
	private static final String baseUrl = "beta/incentives";
	
	public Response<Incentive> getIncentives(GetIncentivesRequest request) {
		if(log.isDebugEnabled()) {
			log.debug("getIncentives called");
		}
		
		Response<Incentive> response = this.callGet(baseUrl,
				request.getQueryParams(),
				INCENTIVE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()){
			log.debug("getIncentives completed");
		}
		
		return response;
	}
	
	public Response<Incentive> getIncentive(long masterIncentiveId) {
		if(log.isDebugEnabled()) {
			log.debug("getIncentive called");
		}
		
		String url = String.format("%s/%s", baseUrl, masterIncentiveId);
		Response<Incentive> response = this.callGet(url, null,
				INCENTIVE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()){
			log.debug("getIncentive completed");
		}
		
		return response;
	}

	public Response<IncentiveApplicability> getIncentiveApplicabilities(GetIncentiveApplicabilitiesRequest request) {
		if(log.isDebugEnabled()) {
			log.debug("getIncentiveApplicabilities called");
		}
		
		String url = String.format("%s/applicabilities", baseUrl);
		Response<IncentiveApplicability> response = this.callGet(url,
				request.getQueryParams(),
				INCENTIVE_APPLICABILITY_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()){
			log.debug("getIncentiveApplicabilities completed");
		}
		
		return response;
	}
}
