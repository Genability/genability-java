package com.genability.client.types;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TariffRate {

  private Long tariffRateId;
  private Long tariffId;
  private Long riderId;
  private Integer tariffSequenceNumber;
  private String rateGroupName;
  private String rateName;
  private DateTime fromDateTime;
  private DateTime toDateTime;
  private Territory territory;
  //private Season season;
  //private TimeOfUse timeOfUse;
  private String chargeType;
  private String chargeClass;
  private String chargePeriod;
  private String transactionType;
  private String quantityKey;
  private String applicabilityKey;
  private String variableLimitKey;
  private String variableRateKey;
  private String variableFactorKey;
  private List<TariffRateBand> rateBands;

  public Long getTariffRateId() {
    return tariffRateId;
  }

  public void setTariffRateId(Long tariffRateId) {
    this.tariffRateId = tariffRateId;
  }

  public Long getTariffId() {
    return tariffId;
  }

  public void setTariffId(Long tariffId) {
    this.tariffId = tariffId;
  }
  
  public Long getRiderId() {
    return riderId;
  }
  
  public void setRiderId(Long riderId) {
    this.riderId = riderId;
  }
  
  public Integer getTariffSequenceNumber() {
    return tariffSequenceNumber;
  }
  
  public void setTariffSequenceNumber(Integer tariffSequenceNumber) {
    this.tariffSequenceNumber = tariffSequenceNumber;
  }
  
  public String getRateGroupName() {
    return rateGroupName;
  }
  
  public void setRateGroupName(String rateGroupName) {
    this.rateGroupName = rateGroupName;
  }
  
  public String getRateName() {
    return rateName;
  }
  
  public void setRateName(String rateName) {
    this.rateName = rateName;
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
  
  public Territory getTerritory() {
    return territory;
  }
  
  public void setTerritory(Territory territory) {
    this.territory = territory;
  }
  
//  public Season getSeason() {
//    return season;
//  }
//  
//  public void setSeason(Season season) {
//    this.season = season;
//  }
//  
//  public TimeOfUse getTimeOfUse() {
//    return timeOfUse;
//  }
//  
//  public void setTimeOfUse(TimeOfUse timeOfUse) {
//    this.timeOfUse = timeOfUse;
//  }
  
  public String getChargeType() {
    return chargeType;
  }
  
  public void setChargeType(String chargeType) {
    this.chargeType = chargeType;
  }
  
  public String getChargeClass() {
    return chargeClass;
  }
  
  public void setChargeClass(String chargeClass) {
    this.chargeClass = chargeClass;
  }
  
  public String getChargePeriod() {
    return chargePeriod;
  }
  
  public void setChargePeriod(String chargePeriod) {
    this.chargePeriod = chargePeriod;
  }
  
  public String getTransactionType() {
    return transactionType;
  }
  
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }
  
  public String getQuantityKey() {
    return quantityKey;
  }
  
  public void setQuantityKey(String quantityKey) {
    this.quantityKey = quantityKey;
  }
  
  public String getApplicabilityKey() {
    return applicabilityKey;
  }
  
  public void setApplicabilityKey(String applicabilityKey) {
    this.applicabilityKey = applicabilityKey;
  }
  
  public String getVariableLimitKey() {
    return variableLimitKey;
  }
  
  public void setVariableLimitKey(String variableLimitKey) {
    this.variableLimitKey = variableLimitKey;
  }
  
  public String getVariableRateKey() {
    return variableRateKey;
  }
  
  public void setVariableRateKey(String variableRateKey) {
    this.variableRateKey = variableRateKey;
  }
  
  public String getVariableFactorKey() {
    return variableFactorKey;
  }
  
  public void setVariableFactorKey(String variableFactorKey) {
    this.variableFactorKey = variableFactorKey;
  }
  
  public List<TariffRateBand> getRateBands() {
    return rateBands;
  }
  
  public void setRateBands(List<TariffRateBand> rateBands) {
    this.rateBands = rateBands;
  }
  
}
