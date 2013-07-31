package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceChange {
	
	
	private String name;
	
	private DateTime fromDateTime;
	
	private DateTime toDateTime;
	
	private String quantityKey;
	
	private BigDecimal rateAmount;
	
	private BigDecimal rateMeanDelta;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getQuantityKey() {
		return quantityKey;
	}

	public void setQuantityKey(String quantityKey) {
		this.quantityKey = quantityKey;
	}
	
	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public BigDecimal getRateMeanDelta() {
		return rateMeanDelta;
	}

	public void setRateMeanDelta(BigDecimal relativePriceIndex) {
		this.rateMeanDelta = relativePriceIndex;
	}
	
	
}
