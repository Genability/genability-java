package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;

import com.genability.client.api.request.AccountAnalysisRequest;
import com.genability.client.types.AccountAnalysis;
import com.genability.client.types.Response;

public class AccountAnalysisService extends BaseService {
    private static final TypeReference<Response<AccountAnalysis>> ACCOUNT_ANALYSIS_RESPONSE_TYPEREF =
            new TypeReference<Response<AccountAnalysis>>() {};

    public Response<AccountAnalysis> calculateSavingsAnalysis(AccountAnalysisRequest request) {
        if (log.isDebugEnabled()) log.debug("savings analysis called");

        Response<AccountAnalysis> response = this.callPost("v1/accounts/analysis", request, ACCOUNT_ANALYSIS_RESPONSE_TYPEREF);

        if (log.isDebugEnabled()) log.debug("savings analysis completed");

        return response;

    }

}
