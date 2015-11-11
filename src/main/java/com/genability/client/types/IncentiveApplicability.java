package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

public final class IncentiveApplicability {
	private String applicabilityKey;
	private String displayName;
	private String description;
	
	private String requiredValue;
	private BigDecimal minValue;
	private BigDecimal maxValue;
	private List<PropertyChoice> choices;
	private String quantityUnit;
	
	private String operator;
	private String quantityKey;
	
	public String getApplicabilityKey() {
		return applicabilityKey;
	}
	
	public void setApplicabilityKey(String applicabilityKey) {
		this.applicabilityKey = applicabilityKey;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRequiredValue() {
		return requiredValue;
	}
	
	public void setRequiredValue(String requiredValue) {
		this.requiredValue = requiredValue;
	}
	
	public BigDecimal getMinValue() {
		return minValue;
	}
	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}
	
	public BigDecimal getMaxValue() {
		return maxValue;
	}
	
	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}
	
	public List<PropertyChoice> getChoices() {
		return choices;
	}
	
	public void setChoices(List<PropertyChoice> choices) {
		this.choices = choices;
	}
	
	public String getQuantityUnit() {
		return quantityUnit;
	}
	
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getQuantityKey() {
		return quantityKey;
	}
	
	public void setQuantityKey(String quantityKey) {
		this.quantityKey = quantityKey;
	}
}

