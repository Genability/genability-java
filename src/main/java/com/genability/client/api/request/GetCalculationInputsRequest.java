/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

/**
 * @author ebaizel
 * 
 */
public class GetCalculationInputsRequest extends AbstractRequest implements Serializable {

	
	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private member variable for masterTariffId
	 */
	private Long masterTariffId;

	/**
	 * private member variable for FromDate
	 */
	private DateTime fromDateTime;

	/**
	 * private member variable for ToDate
	 */
	private DateTime toDateTime;

	/**
	 * private member variable for TerritoryId
	 */
	private Long territoryId;

	/**
	 * private member variable for AccountId
	 */
	private String accountId;

	/**
	 * private member variable for providerAccountId
	 */
	private String providerAccountId;

	/**
	 * Private member variable estimate
	 */
	private String estimate;

	/**
	 * @return the masterTariffId
	 */
	public Long getMasterTariffId() {
		return masterTariffId;
	}

	/**
	 * @param masterTariffId
	 *            the masterTariffId to set
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	/**
	 * @param date
	 *            the fromDate to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the fromDate
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the toDate
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * @param territoryId
	 *            the territoryId to set
	 */
	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}

	/**
	 * @return the territoryId
	 */
	public Long getTerritoryId() {
		return territoryId;

	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the territoryId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getProviderAccountId() {
    	return providerAccountId;
    }

	public void setProviderAccountId(String providerAccountId) {
    	this.providerAccountId = providerAccountId;
    }


	/**
	 * @return the estimate
	 */
	public String getEstimate() {
		return estimate;
	}

	/**
	 * @param estimate
	 *            the estimate to set
	 */
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	
	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		
		addParam(qparams,"fromDateTime", fromDateTime);
		addParam(qparams,"toDateTime",toDateTime);
		if (accountId != null) {
			addParam(qparams, "accountId", accountId);
		}
		
		if (masterTariffId != null) {
			addParam(qparams, "tariffId", masterTariffId);			
		}

		if (estimate != null) {
			addParam(qparams, "estimate", estimate);	
		}
		
		if (territoryId != null) {
			addParam(qparams, "territoryId", territoryId);
		}
		
		return qparams;
		
	}	
	
}
