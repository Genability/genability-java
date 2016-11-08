package com.genability.client.api.request.signal;


import com.fasterxml.jackson.annotation.JsonIgnore;


public class GetAccountCalculatedCostRequest extends GetCalculatedCostRequest {

    @JsonIgnore
    private String accountId;
    @JsonIgnore
    private String providerAccountId;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(String providerAccountId) {
        this.providerAccountId = providerAccountId;
    }
}
