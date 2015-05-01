package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetTariffRequest extends AbstractRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long masterTariffId;

	private String accountId;

	private Boolean populateProperties;

	private Boolean populateRates;

	private Boolean populateDocuments;

	private DateTime effectiveOn;

	private Boolean applicableRatesOnly;

	private Boolean applyContractedRates;

	private Boolean lookupVariableRates;
	
	private Boolean bundleRates;

	private DateTime fromDateTime;
	private DateTime toDateTime;
	
	private Long territoryId;

	public Long getTerritoryId() {
		return territoryId;
	}


	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}


	public Long getMasterTariffId() {
		return masterTariffId;
	}


	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public Boolean getPopulateProperties() {
		return populateProperties;
	}


	public void setPopulateProperties(Boolean populateProperties) {
		this.populateProperties = populateProperties;
	}


	public Boolean getPopulateRates() {
		return populateRates;
	}


	public void setPopulateRates(Boolean populateRates) {
		this.populateRates = populateRates;
	}


	public Boolean getPopulateDocuments() {
		return populateDocuments;
	}


	public void setPopulateDocuments(Boolean populateDocuments) {
		this.populateDocuments = populateDocuments;
	}


	public DateTime getEffectiveOn() {
		return effectiveOn;
	}


	public void setEffectiveOn(DateTime effectiveOn) {
		this.effectiveOn = effectiveOn;
	}


	public Boolean getApplicableRatesOnly() {
		return applicableRatesOnly;
	}


	public void setApplicableRatesOnly(Boolean applicableRatesOnly) {
		this.applicableRatesOnly = applicableRatesOnly;
	}


	public Boolean getApplyContractedRates() {
		return applyContractedRates;
	}


	public void setApplyContractedRates(Boolean applyContractedRates) {
		this.applyContractedRates = applyContractedRates;
	}


	public Boolean getLookupVariableRates() {
		return lookupVariableRates;
	}


	public void setLookupVariableRates(Boolean lookupVariableRates) {
		this.lookupVariableRates = lookupVariableRates;
	}


	public Boolean getBundleRates() {
		return bundleRates;
	}


	public void setBundleRates(Boolean bundleRates) {
		this.bundleRates = bundleRates;
	}

        public DateTime getFromDateTime() {
                return fromDateTime;
        }

        public void setFromDateTime(DateTime fromDateTime) {
                this.fromDateTime = fromDateTime;
        }

        public DateTime getToDateTime() {
                return toDateTime;
        }

        public void setToDateTime(DateTime toDateTime) {
                this.toDateTime = toDateTime;
        }

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams, "accountId", accountId);
		addParam(qparams, "populateProperties", populateProperties);
		addParam(qparams, "populateRates", populateRates);
		addParam(qparams, "populateDocuments", populateDocuments);
		addParam(qparams, "effectiveOn", effectiveOn);
		addParam(qparams,"applicableRatesOnly", applicableRatesOnly);
		addParam(qparams, "applyContractedRates", applyContractedRates);
		addParam(qparams, "lookupVariableRates", lookupVariableRates);
		addParam(qparams, "bundleRates", bundleRates);
		addParam(qparams, "fromDateTime", fromDateTime);
		addParam(qparams, "toDateTime", toDateTime);
		addParam(qparams, "territoryId", territoryId);
		
		return qparams;
		
	}
	
	

}
