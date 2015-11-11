package com.genability.client.types;

import java.math.BigDecimal;

public final class PropertyChoice {
	
	private String displayValue;
	private String dataValue;
	private BigDecimal likelihood;
	
	public String getDisplayValue() {
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDataValue() {
		return dataValue;
	}
	
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public BigDecimal getLikelihood() {
		return likelihood;
	}

	public void setLikelihood(BigDecimal likelihood) {
		this.likelihood = likelihood;
	}
}