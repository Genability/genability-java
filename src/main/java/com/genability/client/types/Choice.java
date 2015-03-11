package com.genability.client.types;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Choice {

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
