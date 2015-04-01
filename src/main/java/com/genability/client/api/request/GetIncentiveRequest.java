package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;

public class GetIncentiveRequest extends AbstractRequest {
	private Long masterTariffId;
	private Boolean populateDetails;
	private Boolean applicableRatesOnly;

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	public Boolean getPopulateDetails() {
		return populateDetails;
	}

	public void setPopulateDetails(Boolean populateDetails) {
		this.populateDetails = populateDetails;
	}

	public Boolean getApplicableRatesOnly() {
		return applicableRatesOnly;
	}

	public void setApplicableRatesOnly(Boolean applicableRatesOnly) {
		this.applicableRatesOnly = applicableRatesOnly;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams, "masterTariffId", masterTariffId);
		addParam(qparams, "populateDetails", populateDetails);
		addParam(qparams, "applicableRatesOnly", applicableRatesOnly);
		return qparams;
	}	
}
