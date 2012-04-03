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
	private Long masterTariffId_;

	/**
	 * private member variable for FromDate
	 */
	private DateTime fromDateTime_;

	/**
	 * private member variable for ToDate
	 */
	private DateTime toDateTime_;

	/**
	 * private member variable for TerritoryId
	 */
	private Long territoryId_;

	/**
	 * private member variable for AccountId
	 */
	private String accountId_;

	/**
	 * private member variable for providerAccountId
	 */
	private String providerAccountId_;

	/**
	 * Private member variable estimate_
	 */
	private String estimate_;

	/**
	 * @return the masterTariffId
	 */
	public Long getMasterTariffId() {
		return masterTariffId_;
	}

	/**
	 * @param masterTariffId
	 *            the masterTariffId to set
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId_ = masterTariffId;
	}

	/**
	 * @param date
	 *            the fromDate to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime_ = fromDateTime;
	}

	/**
	 * @return the fromDate
	 */
	public DateTime getFromDateTime() {
		return fromDateTime_;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime_ = toDateTime;
	}

	/**
	 * @return the toDate
	 */
	public DateTime getToDateTime() {
		return toDateTime_;
	}

	/**
	 * @param territoryId
	 *            the territoryId to set
	 */
	public void setTerritoryId(Long territoryId) {
		this.territoryId_ = territoryId;
	}

	/**
	 * @return the territoryId
	 */
	public Long getTerritoryId() {
		return territoryId_;

	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId_;
	}

	/**
	 * @param accountId
	 *            the territoryId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId_ = accountId;
	}

	public String getProviderAccountId_() {
    	return providerAccountId_;
    }

	public void setProviderAccountId_(String providerAccountId_) {
    	this.providerAccountId_ = providerAccountId_;
    }


	/**
	 * @return the estimate
	 */
	public String getEstimate() {
		return estimate_;
	}

	/**
	 * @param estimate
	 *            the estimate to set
	 */
	public void setEstimate(String estimate) {
		estimate_ = estimate;
	}
	
	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		
		addParam(qparams,"fromDateTime", fromDateTime_);
		addParam(qparams,"toDateTime",toDateTime_);
		if (accountId_ != null) {
			addParam(qparams, "accountId", accountId_);
		}
		
		if (masterTariffId_ != null) {
			addParam(qparams, "tariffId", masterTariffId_);			
		}

		if (estimate_ != null) {
			addParam(qparams, "estimate", estimate_);	
		}
		
		if (territoryId_ != null) {
			addParam(qparams, "territoryId", territoryId_);
		}
		
		return qparams;
		
	}	
	
}
