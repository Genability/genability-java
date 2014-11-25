package com.genability.client.types;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountsAnalysis {

    public static final String REST_TYPE = "AccountAnalysis";

    private String providerAccountId;

    private String accountId;

    private DateTime fromDateTime;

    private List<PropertyData> propertyInputs;

    private List<TariffRate> rateInputs;

    public String getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(final String providerAccountId) {
        this.providerAccountId = providerAccountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public DateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(final DateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public List<TariffRate> getRateInputs() {
        return rateInputs;
    }

    public void setRateInputs(final List<TariffRate> rateInputs) {
        this.rateInputs = rateInputs;
    }

    public List<PropertyData> getPropertyInputs() {
        return propertyInputs;
    }

    public void setPropertyInputs(final List<PropertyData> propertyInputs) {
        this.propertyInputs = propertyInputs;
    }

}
