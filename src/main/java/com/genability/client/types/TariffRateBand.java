package com.genability.client.types;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TariffRateBand {

  private Long tariffRateBandId;
  private Long tariffRateId;
  private Integer rateSequenceNumber;
  private Boolean hasConsumptionLimit;
  private BigDecimal consumptionUpperLimit;
  private Boolean hasDemandLimit;
  private BigDecimal demandUpperLimit;
  private Boolean hasPropertyLimit;
  private BigDecimal propertyUpperLimit;
  private String applicabilityValue;
  private BigDecimal calculationFactor;
  private BigDecimal rateAmount;
  private RateUnit rateUnit;
  private Boolean isCredit;
  private String prevUpperLimit;
  
  public Long getTariffRateBandId() {
    return tariffRateBandId;
  }
  
  public void setTariffRateBandId(Long tariffRateBandId) {
    this.tariffRateBandId = tariffRateBandId;
  }
  
  public Long getTariffRateId() {
    return tariffRateId;
  }
  
  public void setTariffRateId(Long tariffRateId) {
    this.tariffRateId = tariffRateId;
  }
  
  public Integer getRateSequenceNumber() {
    return rateSequenceNumber;
  }
  
  public void setRateSequenceNumber(Integer rateSequenceNumber) {
    this.rateSequenceNumber = rateSequenceNumber;
  }
  
  public Boolean getHasConsumptionLimit() {
    return hasConsumptionLimit;
  }
  
  public void setHasConsumptionLimit(Boolean hasConsumptionLimit) {
    this.hasConsumptionLimit = hasConsumptionLimit;
  }
  
  public BigDecimal getConsumptionUpperLimit() {
    return consumptionUpperLimit;
  }
  
  public void setConsumptionUpperLimit(BigDecimal consumptionUpperLimit) {
    this.consumptionUpperLimit = consumptionUpperLimit;
  }
  
  public Boolean getHasDemandLimit() {
    return hasDemandLimit;
  }
  
  public void setHasDemandLimit(Boolean hasDemandLimit) {
    this.hasDemandLimit = hasDemandLimit;
  }
  
  public BigDecimal getDemandUpperLimit() {
    return demandUpperLimit;
  }
  
  public void setDemandUpperLimit(BigDecimal demandUpperLimit) {
    this.demandUpperLimit = demandUpperLimit;
  }
  
  public Boolean getHasPropertyLimit() {
    return hasPropertyLimit;
  }
  
  public void setHasPropertyLimit(Boolean hasPropertyLimit) {
    this.hasPropertyLimit = hasPropertyLimit;
  }
  
  public BigDecimal getPropertyUpperLimit() {
    return propertyUpperLimit;
  }
  
  public void setPropertyUpperLimit(BigDecimal propertyUpperLimit) {
    this.propertyUpperLimit = propertyUpperLimit;
  }
  
  public String getApplicabilityValue() {
    return applicabilityValue;
  }
  
  public void setApplicabilityValue(String applicabilityValue) {
    this.applicabilityValue = applicabilityValue;
  }
  
  public BigDecimal getCalculationFactor() {
    return calculationFactor;
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
  
  public RateUnit getRateUnit() {
    return rateUnit;
  }
  
  public void setRateUnit(RateUnit rateUnit) {
    this.rateUnit = rateUnit;
  }
  
  public Boolean getIsCredit() {
    return isCredit;
  }
  
  public void setIsCredit(Boolean isCredit) {
    this.isCredit = isCredit;
  }
  
  public String getPrevUpperLimit() {
    return prevUpperLimit;
  }
  
  public void setPrevUpperLimit(String prevUpperLimit) {
    this.prevUpperLimit = prevUpperLimit;
  }
}
