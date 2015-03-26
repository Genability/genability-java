package com.genability.client.api.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetPriceRequest extends AbstractRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long masterTariffId;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private BigDecimal consumptionAmount;
	private BigDecimal demandAmount;

	public Long getMasterTariffId() {
		return masterTariffId;
	}
	
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
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

	public BigDecimal getConsumptionAmount() {
		return consumptionAmount;
	}

	public void setConsumptionAmount(BigDecimal consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

	public BigDecimal getDemandAmount() {
		return demandAmount;
	}

	public void setDemandAmount(BigDecimal demandAmount) {
		this.demandAmount = demandAmount;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams,"fromDateTime", fromDateTime,ISO_8601_SHORT_DATE_FORMATTER);
		addParam(qparams,"toDateTime",toDateTime,ISO_8601_SHORT_DATE_FORMATTER);
		addParam(qparams,"consumptionAmount",consumptionAmount);
		addParam(qparams,"demandAmount",demandAmount);
		return qparams;
	}
}
