package com.genability.client.api.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetPriceRequest extends AbstractRequest implements Serializable {

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
	 * private member variable for consumptionAmount
	 */
	private BigDecimal consumptionAmount;

	/**
	 * private member variable for demandAmount
	 */
	private BigDecimal demandAmount;


	/**
	 * @return the masterTariffId
	 */
	public Long getMasterTariffId() {
		return masterTariffId;
	}
	
	/**
	 * @param date
	 *            the masterTariffId to set
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}
	
	/**
	 * @return the fromDate
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}
	
	/**
	 * @param date
	 *            the fromDate to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the toDate
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}
	
	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the consumptionAmount
	 */
	public BigDecimal getConsumptionAmount() {
		return consumptionAmount;
	}

	/**
	 * @param consumptionAmount
	 *            the consumptionAmount to set
	 */
	public void setConsumptionAmount(BigDecimal consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

	/**
	 * @return the demandAmount
	 */
	public BigDecimal getDemandAmount() {
		return demandAmount;
	}

	/**
	 * @param demandAmount
	 *            the demandAmount to set
	 */
	public void setDemandAmount(BigDecimal demandAmount) {
		this.demandAmount = demandAmount;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		
		addParam(qparams,"fromDateTime", fromDateTime,ISO_8601_SHORT_DATE_FORMATTER);
		addParam(qparams,"toDateTime",toDateTime,ISO_8601_SHORT_DATE_FORMATTER);
		addParam(qparams,"consumptionAmount",consumptionAmount);
		addParam(qparams,"demandAmount",demandAmount);
		return qparams;
		
	}

}
