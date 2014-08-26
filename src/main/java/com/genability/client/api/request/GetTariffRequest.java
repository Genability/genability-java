package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetTariffRequest extends AbstractRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long masterTariffId;
	
	/**
	 * Private member variable for accountId
	 */
	private String accountId;
	
	/**
	 * Private member variable for PopulateProperties.
	 */
	private Boolean populateProperties;
	
	/**
	 * Private member variable for PopulateRates.
	 */
	private Boolean populateRates;

	/**
	 * Private member variable for PopulateDocuments.
	 */
	private Boolean populateDocuments;

	/**
	 * Private member variable for EffectiveOn.
	 */
	private DateTime effectiveOn;

	/**
	 * Private member variable for applicableRatesOnly.
	 */
	private Boolean applicableRatesOnly;

	/**
	 * Private member variable for applyContractedRates.
	 */
	private Boolean applyContractedRates;
	
	/**
	 * Private member variable for lookupVariableRates.
	 */
	private Boolean lookupVariableRates;
	
	/**
	 * Private member variable for bundleRates.
	 */
	private Boolean bundleRates;
	

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


	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams,"accountId",accountId);
		addParam(qparams,"populateProperties",populateProperties);
		addParam(qparams,"populateRates",populateRates);
		addParam(qparams,"populateDocuments",populateDocuments);
		addParam(qparams,"effectiveOn",effectiveOn);
		addParam(qparams,"applicableRatesOnly",applicableRatesOnly);
		addParam(qparams,"applyContractedRates",applyContractedRates);
		addParam(qparams,"lookupVariableRates",lookupVariableRates);
		addParam(qparams,"bundleRates",bundleRates);
		
		return qparams;
		
	}
	
	

}
