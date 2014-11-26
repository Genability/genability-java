/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetCalculationInputsRequest extends AbstractRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long masterTariffId;

	private DateTime fromDateTime;

	private DateTime toDateTime;

	private Long territoryId;

	private String accountId;

	private String providerAccountId;

	private String estimate;

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the toDate
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}

	public Long getTerritoryId() {
		return territoryId;

	}

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


	public String getEstimate() {
		return estimate;
	}

	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams,"fromDateTime", fromDateTime);
		addParam(qparams,"toDateTime",toDateTime);
		addParam(qparams, "accountId", accountId);
		addParam(qparams, "masterTariffId", masterTariffId);
		addParam(qparams, "estimate", estimate);	
		addParam(qparams, "territoryId", territoryId);
		
		return qparams;
		
	}	
	
}
