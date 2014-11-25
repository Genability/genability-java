package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.types.Response;
import com.genability.client.types.AccountsAnalysis;
import com.genability.client.types.AccountsAnalysisOutput;

public class AccountsAnalysisService extends BaseService {
    private static final TypeReference<Response<AccountsAnalysisOutput>> ACCOUNT_ANALYSIS_RESPONSE_TYPEREF = new TypeReference<Response<AccountsAnalysisOutput>>() {};

    public Response<AccountsAnalysisOutput> calculateAccountsAnalysis(AccountsAnalysis accountsAnalysis) {
        if(log.isDebugEnabled()) log.debug("savings analysis called");

        Response<AccountsAnalysisOutput> response = this.callPost("v1/accounts/analysis", accountsAnalysis, ACCOUNT_ANALYSIS_RESPONSE_TYPEREF);

        if(log.isDebugEnabled()) log.debug("savings analysis completed");

        return response;

    }

}
