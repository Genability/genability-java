package com.genability.client.types;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncentiveRateBand {

	private Long tariffRateBandId;
	private Integer rateSequenceNumber;

	private Boolean hasPropertyLimit;
	private BigDecimal propertyUpperLimit;
	private String applicabilityValue;
	
	private BigDecimal calculationFactor;
	private BigDecimal rateAmount;
	private String rateUnit;

	private Boolean isCredit;

	public IncentiveRateBand() {}

	public Long getTariffRateBandId() {
		return tariffRateBandId;
	}

	public void setTariffRateBandId(Long tariffRateBandId) {
		this.tariffRateBandId = tariffRateBandId;
	}

	public Integer getRateSequenceNumber() {
		return rateSequenceNumber;
	}

	public void setRateSequenceNumber(Integer rateSequenceNumber) {
		this.rateSequenceNumber = rateSequenceNumber;
	}

	public Boolean getHasPropertyLimit() {
		return hasPropertyLimit;
	}

	public BigDecimal getPropertyUpperLimit() {
		return propertyUpperLimit;
	}

	public String getApplicabilityValue() {
		return applicabilityValue;
	}

	public BigDecimal getCalculationFactor() {
		return calculationFactor;
	}

	public void setHasPropertyLimit(Boolean hasPropertyLimit) {
		this.hasPropertyLimit = hasPropertyLimit;
	}

	public void setPropertyUpperLimit(BigDecimal propertyUpperLimit) {
		this.propertyUpperLimit = propertyUpperLimit;
	}

	public void setApplicabilityValue(String applicabilityValue) {
		this.applicabilityValue = applicabilityValue;
	}

	public void setCalculationFactor(BigDecimal calculationFactor) {
		this.calculationFactor = calculationFactor;
	}

	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public String getRateUnit() {
		return rateUnit;
	}

	public void setRateUnit(String rateUnit) {
		this.rateUnit = rateUnit;
	}

	public Boolean getIsCredit() {
		return isCredit;
	}

	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}
}
