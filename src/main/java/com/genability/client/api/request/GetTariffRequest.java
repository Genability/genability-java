package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

public class GetTariffRequest extends AbstractRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long masterTariffId;
	
	private String accountId;
	
	private Boolean populateProperties;
	
	private Boolean populateRates;
	

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


	@Override
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams,"accountId",accountId);
		addParam(qparams,"populateProperties",populateProperties);
		addParam(qparams,"populateRates",populateRates);
		
		return qparams;
		
	}
	
	

}
