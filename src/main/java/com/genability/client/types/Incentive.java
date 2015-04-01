package com.genability.client.types;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Incentive {

	private Long tariffId;
	private Long masterTariffId;
	private String tariffCode;
	private String tariffName;
	private Long lseId;
	private String lseName;
	private String lseCode;
	private String serviceType;
	private String customerClass;
	private DateTime effectiveDate;
	private DateTime endDate;
	private Boolean exhausted;
	private String timezone;
	private String isoCurrency;
	
	private String projectType;
	private String incentiveType;
	private String endUse;
	private String summary;
	private String requirements;
	
	private List<TariffProperty> properties;
	private List<IncentiveRate> rates;

	private DateTime createdDate;
	private DateTime lastUpdatedDate;

	public Incentive() {

	}
	
	public String toString() {
		try {
			return String.format("<%s %s %s; mtid %s id; lse %s $s>",
					getClass().getSimpleName(), tariffCode, tariffName, masterTariffId, tariffId, lseId, lseCode);
		} catch (Exception e) {
			return super.toString();
		}
	}

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	public Long getTariffId() {
		return tariffId;
	}

	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	public String getTariffCode() {
		return tariffCode;
	}

	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	public String getLseCode() {
		return lseCode;
	}

	public void setLseCode(String lseCode) {
		this.lseCode = lseCode;
	}
	
	public String getLseName() {
		return lseName;
	}

	public void setLseName(String lseName) {
		this.lseName = lseName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}

	public DateTime getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(DateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public Boolean getExhausted() {
		return exhausted;
	}

	public void setExhausted(Boolean exhausted) {
		this.exhausted = exhausted;
	}

	public String getTimeZone() {
		return timezone;
	}

	public void setTimeZone(String timezone) {
		this.timezone = timezone;
	}

	public String getCurrency() {
		return isoCurrency;
	}

	public void setCurrency(String currency) {
		this.isoCurrency = currency;
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

	public String getEndUse() {
		return endUse;
	}

	public void setEndUse(String endUse) {
		this.endUse = endUse;
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
	public List<TariffProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<TariffProperty> properties) {
		this.properties = properties;
	}

	public List<IncentiveRate> getRates() {
		return rates;
	}

	public void setRates(List<IncentiveRate> rates) {
		this.rates = rates;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}


	public DateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(DateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
}