package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceChange {
	
	
	private String changeName;
	
	private DateTime changeDateTime;
	
	private BigDecimal rateAmount;
	
	private BigDecimal relativePriceIndex;

	private BigDecimal accuracy;
	

	public String getChangeName() {
        return changeName;
    }

	public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

	public DateTime getChangeDateTime() {
      return changeDateTime;
    }

	public void setChangeDateTime(DateTime changeDateTime) {
      this.changeDateTime = changeDateTime;
    }
	
	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public BigDecimal getRelativePriceIndex() {
        return relativePriceIndex;
    }

	public void setRelativePriceIndex(BigDecimal relativePriceIndex) {
        this.relativePriceIndex = relativePriceIndex;
    }

	public BigDecimal getAccuracy() {
        return accuracy;
    }

	public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

}
