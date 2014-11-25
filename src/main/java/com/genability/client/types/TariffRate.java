package com.genability.client.types;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genability.client.util.EnumUtil;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TariffRate {

  private Long tariffRateId;
  private Long tariffId;
  private Long riderId;
  private Long masterTariffRateId;
  private Integer tariffSequenceNumber;
  private Integer tariffBookSequenceNumber;
  private String rateGroupName;
  private String tariffBookRateGroupName;
  private String rateName;
  private String tariffBookRateName;
  private DateTime fromDateTime;
  private DateTime toDateTime;
  private Territory territory;
  private Season season;
  private TimeOfUse timeOfUse;
  private ChargeType chargeType;
  private ChargeClass[] chargeClass;
  private Period chargePeriod;
  private TransactionType transactionType;
  private String quantityKey;
  private String applicabilityKey;
  private String variableLimitKey;
  private String variableRateKey;
  private String variableFactorKey;
  private String variableRateSubKey;
  private List<TariffRateBand> rateBands;
  private String scenarios;

  public static final String REST_TYPE = "TariffRate";

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
  
  public Long getMasterTariffRateId() {
    return masterTariffRateId;
  }
  
  public void setMasterTariffRateId(Long masterTariffRateId) {
    this.masterTariffRateId = masterTariffRateId;
  }
  
  public Integer getTariffSequenceNumber() {
    return tariffSequenceNumber;
  }
  
  public void setTariffSequenceNumber(Integer tariffSequenceNumber) {
    this.tariffSequenceNumber = tariffSequenceNumber;
  }
  
  public Integer getTariffBookSequenceNumber() {
    return tariffBookSequenceNumber;
  }
  
  public void setTariffBookSequenceNumber(Integer tariffBookSequenceNumber) {
    this.tariffBookSequenceNumber = tariffBookSequenceNumber;
  }
  
  public String getRateGroupName() {
    return rateGroupName;
  }
  
  public void setRateGroupName(String rateGroupName) {
    this.rateGroupName = rateGroupName;
  }
  
  public String getTariffBookRateGroupName() {
    return tariffBookRateGroupName;
  }
  
  public void setTariffBookRateGroupName(String tariffBookRateGroupName) {
    this.tariffBookRateGroupName = tariffBookRateGroupName;
  }
  
  public String getRateName() {
    return rateName;
  }
  
  public void setRateName(String rateName) {
    this.rateName = rateName;
  }

  public String getTariffBookRateName() {
    return tariffBookRateName;
  }
  
  public void setTariffBookRateName(String tariffBookRateName) {
    this.tariffBookRateName = tariffBookRateName;
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
  
  public Season getSeason() {
    return season;
  }
  
  public void setSeason(Season season) {
    this.season = season;
  }
  
  public TimeOfUse getTimeOfUse() {
    return timeOfUse;
  }
  
  public void setTimeOfUse(TimeOfUse timeOfUse) {
    this.timeOfUse = timeOfUse;
  }
  
  public ChargeType getChargeType() {
    return chargeType;
  }
  
  public void setChargeType(ChargeType chargeType) {
    this.chargeType = chargeType;
  }
  
  @JsonIgnore
  public ChargeClass[] getChargeClass() {
    return chargeClass;
  }
  
  public void setChargeClass(ChargeClass... chargeClass) {
    this.chargeClass = chargeClass;
  }
  
  @JsonProperty("chargeClass")
  public String getChargeClassAsString() {
    return EnumUtil.enumListString(chargeClass);
  }
  
  public void setChargeClassAsString(String chargeClassStr) {
    this.chargeClass = EnumUtil.parseEnumList(chargeClassStr, ChargeClass.class);
  }
  
  public Period getChargePeriod() {
    return chargePeriod;
  }
  
  public void setChargePeriod(Period chargePeriod) {
    this.chargePeriod = chargePeriod;
  }
  
  public TransactionType getTransactionType() {
    return transactionType;
  }
  
  public void setTransactionType(TransactionType transactionType) {
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
  
  public String getVariableRateSubKey() {
	return variableRateSubKey;
}

public void setVariableRateSubKey(String variableRateSubKey) {
	this.variableRateSubKey = variableRateSubKey;
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
  
  public void addRateBand(TariffRateBand rateBand) {
    if (this.rateBands == null) {
      this.rateBands = new ArrayList<TariffRateBand>();
    }
    this.rateBands.add(rateBand);
  }

  public String getScenarios() {
    return scenarios;
  }

  public void setScenarios(final String scenarios) {
    this.scenarios = scenarios;
  }


}
