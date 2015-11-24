package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Incentive {

	private Long incentiveId;
	private Long masterIncentiveId;
	private Eligibility eligibility;
	private List<IncentiveApplicability> requiredData;
	
	private String tariffCode;
	private String incentiveName;
	private Long lseId;
	private String lseName;
	private ServiceType serviceType;
	private CustomerClass customerClass;
	private DateTime startDate;
	private DateTime endDate;
	private Boolean isExhausted;
	
	private String projectType;
	private String incentiveType;
	private String summary;
	private String requirements;
	
	private String jurisdiction;
	private PropertyKey quantityKey;
	private String quantityKeyCap;
	private long paymentCap;
	private PropertyKey percentCostCapKey;
	private BigDecimal percentCostCap;
	private long paymentDuration;
	private String incentivePaidTo;
	private List<IncentiveApplicability> applicabilities;
	private Boolean projectTypeExclusive;
	private String state;
	private Long territoryId;
	private BigDecimal rate;
	private RateUnit rateUnit;
	
	public static enum Eligibility {
		ELIGIBLE,
		COULD_BE_ELIGIBLE,
		INELIGIBLE;
	}
	
	public Long getIncentiveId() {
		return incentiveId;
	}
	
	public void setIncentiveId(Long incentiveId) {
		this.incentiveId = incentiveId;
	}
	
	public Long getMasterIncentiveId() {
		return masterIncentiveId;
	}
	
	public void setMasterIncentiveId(Long masterIncentiveId) {
		this.masterIncentiveId = masterIncentiveId;
	}
	
	public Eligibility getEligibility() {
		return eligibility;
	}

	public void setEligibility(Eligibility eligibility) {
		this.eligibility = eligibility;
	}

	public List<IncentiveApplicability> getRequiredData() {
		return requiredData;
	}

	public void setRequiredData(List<IncentiveApplicability> requiredData) {
		this.requiredData = requiredData;
	}

	public String getTariffCode() {
		return tariffCode;
	}
	
	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}
	
	public String getIncentiveName() {
		return incentiveName;
	}
	
	public void setIncentiveName(String incentiveName) {
		this.incentiveName = incentiveName;
	}
	
	public Long getLseId() {
		return lseId;
	}
	
	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}
	
	public String getLseName() {
		return lseName;
	}
	
	public void setLseName(String lseName) {
		this.lseName = lseName;
	}
	
	public ServiceType getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	public CustomerClass getCustomerClass() {
		return customerClass;
	}
	
	public void setCustomerClass(CustomerClass customerClass) {
		this.customerClass = customerClass;
	}
	
	public DateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	public DateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
	public Boolean getIsExhausted() {
		return isExhausted;
	}
	
	public void setIsExhausted(Boolean isExhausted) {
		this.isExhausted = isExhausted;
	}
	
	public String getProjectType() {
		return projectType;
	}
	
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	public String getIncentiveType() {
		return incentiveType;
	}
	
	public void setIncentiveType(String incentiveType) {
		this.incentiveType = incentiveType;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getRequirements() {
		return requirements;
	}
	
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	
	public String getJurisdiction() {
		return jurisdiction;
	}
	
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	
	public PropertyKey getQuantityKey() {
		return quantityKey;
	}
	
	public void setQuantityKey(PropertyKey quantityKey) {
		this.quantityKey = quantityKey;
	}
	
	public String getQuantityKeyCap() {
		return quantityKeyCap;
	}
	
	public void setQuantityKeyCap(String quantityKeyCap) {
		this.quantityKeyCap = quantityKeyCap;
	}
	
	public long getPaymentCap() {
		return paymentCap;
	}
	
	public void setPaymentCap(long paymentCap) {
		this.paymentCap = paymentCap;
	}
	
	public PropertyKey getPercentCostCapKey() {
		return percentCostCapKey;
	}
	public void setPercentCostCapKey(PropertyKey percentCostCapKey) {
		this.percentCostCapKey = percentCostCapKey;
	}
	
	public BigDecimal getPercentCostCap() {
		return percentCostCap;
	}
	
	public void setPercentCostCap(BigDecimal percentCostCap) {
		this.percentCostCap = percentCostCap;
	}
	
	public long getPaymentDuration() {
		return paymentDuration;
	}
	
	public void setPaymentDuration(long paymentDuration) {
		this.paymentDuration = paymentDuration;
	}
	
	public String getIncentivePaidTo() {
		return incentivePaidTo;
	}
	
	public void setIncentivePaidTo(String incentivePaidTo) {
		this.incentivePaidTo = incentivePaidTo;
	}
	
	public List<IncentiveApplicability> getApplicabilities() {
		return applicabilities;
	}
	
	public void setApplicabilities(List<IncentiveApplicability> applicabilities) {
		this.applicabilities = applicabilities;
	}
	
	public Boolean getProjectTypeExclusive() {
		return projectTypeExclusive;
	}
	
	public void setProjectTypeExclusive(Boolean projectTypeExclusive) {
		this.projectTypeExclusive = projectTypeExclusive;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Long getTerritoryId() {
		return territoryId;
	}
	
	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}
	
	public BigDecimal getRate() {
		return rate;
	}
	
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	public RateUnit getRateUnit() {
		return rateUnit;
	}
	
	public void setRateUnit(RateUnit rateUnit) {
		this.rateUnit = rateUnit;
	}
}