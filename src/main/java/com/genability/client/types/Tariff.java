package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.genability.client.util.EnumUtil;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class Tariff {
	public static final String REST_TYPE = "Tariff";

	private Long tariffId;
	private Long masterTariffId;
	private String tariffCode;
	private String tariffName;
	private String tariffBookName;
	private Long lseId;
	private String lseName;
	private String lseCode;
	private ServiceType serviceType;
	private Long priorTariffId;
	private Long distributionLseId;
	private TariffType tariffType;
	private CustomerClass customerClass;
	private Integer customerCount;
	private BigDecimal customerLikelihood;
	private String customerCountSource;
	private Long territoryId;
	private String effectiveDate;
	private String endDate;
	private String closedDate;
	private String timeZone;
	private String effectiveOnRule;

	/**
	 * private member variable for BillingPeriod. the default value is MONTHLY
	 */
	private Period billingPeriod;

	private String currency;
	private ChargeType[] chargeTypes;

	/**
	 * private member variable for ChargePeriod. the default value is MONTHLY
	 */
	private String chargePeriod;

	/**
	 * private member variable for minimum monthly consumption
	 * required to be eligible for this tariff
	 */
	private BigDecimal minMonthlyConsumption;
	
	/**
	 * private member variable for maximum monthly consumption
	 * required to be eligible for this tariff
	 */
	private BigDecimal maxMonthlyConsumption;
	
	/**
	 * private member variable for minimum monthly demand
	 * required to be eligible for this tariff
	 */
	private BigDecimal minMonthlyDemand;
	
	/**
	 * private member variable for maximum monthly demand
	 * required to be eligible for this tariff
	 */
	private BigDecimal maxMonthlyDemand;

	private Boolean hasTimeOfUseRates;
	private Boolean hasTieredRates;
	private Boolean hasContractedRates;

	/**
	 * private member variable for whether this tariff
	 * has additional eligibility criteria, specified by tariff properties
	 */
	private Boolean hasTariffApplicability;

	/**
	 * private member variable for whether this tariff
	 * has additional eligibility criteria, specified by tariff properties
	 */
	private Boolean hasRateApplicability;

	private Boolean hasNetMetering;
	private Boolean isActive;
	private String privacy;
	private List<TariffProperty> properties;
	private List<TariffRate> rates;
	
	public Long getTariffId() {
		return tariffId;
	}

	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	public Long getPriorTariffId() {
		return priorTariffId;
	}

	public void setPriorTariffId(Long priorTariffId) {
		this.priorTariffId = priorTariffId;
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

	public String getLseCode() {
		return lseCode;
	}

	public void setLseCode(final String lseCode) {
		this.lseCode = lseCode;
	}

	public Long getDistributionLseId() {
		return distributionLseId;
	}

	public void setDistributionLseId(Long distributionLseId) {
		this.distributionLseId = distributionLseId;
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

	public String getTariffBookName() {
		return tariffBookName;
	}

	public void setTariffBookName(String tariffBookName) {
		this.tariffBookName = tariffBookName;
	}

	public TariffType getTariffType() {
		return tariffType;
	}

	public void setTariffType(TariffType tariffType) {
		this.tariffType = tariffType;
	}

	public Period getBillingPeriod() {
		return billingPeriod;
	}

	public void setBillingPeriod(Period billingPeriod) {
		this.billingPeriod = billingPeriod;
	}

	public CustomerClass getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(CustomerClass customerClass) {
		this.customerClass = customerClass;
	}

	public Long getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getMinMonthlyConsumption() {
    	return minMonthlyConsumption;
    }

	public void setMinMonthlyConsumption(BigDecimal minMonthlyConsumption) {
    	this.minMonthlyConsumption = minMonthlyConsumption;
    }

	public BigDecimal getMaxMonthlyConsumption() {
    	return maxMonthlyConsumption;
    }

	public void setMaxMonthlyConsumption(BigDecimal maxMonthlyConsumption) {
    	this.maxMonthlyConsumption = maxMonthlyConsumption;
    }

	public BigDecimal getMinMonthlyDemand() {
    	return minMonthlyDemand;
    }

	public void setMinMonthlyDemand(BigDecimal minMonthlyDemand) {
    	this.minMonthlyDemand = minMonthlyDemand;
    }

	public BigDecimal getMaxMonthlyDemand() {
    	return maxMonthlyDemand;
    }

	public void setMaxMonthlyDemand(BigDecimal maxMonthlyDemand) {
    	this.maxMonthlyDemand = maxMonthlyDemand;
	}

	public Boolean getHasNetMetering() {
    	return hasNetMetering;
    }

	public void setHasNetMetering(Boolean hasNetMetering) {
    	this.hasNetMetering = hasNetMetering;
    }

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}

	public BigDecimal getCustomerLikelihood() {
		return customerLikelihood;
	}

	public void setCustomerLikelihood(BigDecimal customerLikelihood) {
		this.customerLikelihood = customerLikelihood;
	}

	public String getCustomerCountSource() {
		return customerCountSource;
	}

	public void setCustomerCountSource(String customerCountSource) {
		this.customerCountSource = customerCountSource;
	}

	@JsonIgnore
	public ChargeType[] getChargeTypes() {
		return chargeTypes;
	}

	public void setChargeTypes(ChargeType... chargeTypes) {
		this.chargeTypes = chargeTypes;
	}

	@JsonProperty("chargeTypes")
	public String getChargeTypesAsString() {
		return EnumUtil.enumListString(chargeTypes);
	}

	public void setChargeTypesAsString(String chargeTypesStr) {
		this.chargeTypes = EnumUtil.parseEnumList(chargeTypesStr, ChargeType.class);
	}

	public String getChargePeriod() {
		return chargePeriod;
	}

	public void setChargePeriod(String chargePeriod) {
		this.chargePeriod = chargePeriod;
	}

	public Boolean getHasTimeOfUseRates() {
		return hasTimeOfUseRates;
	}

	public void setHasTimeOfUseRates(Boolean hasTimeOfUseRates) {
		this.hasTimeOfUseRates = hasTimeOfUseRates;
	}

	public Boolean getHasTieredRates() {
		return hasTieredRates;
	}

	public void setHasTieredRates(Boolean hasTieredRates) {
		this.hasTieredRates = hasTieredRates;
	}

	public Boolean getHasContractedRates() {
		return hasContractedRates;
	}

	public void setHasContractedRates(Boolean hasContractedRates) {
		this.hasContractedRates = hasContractedRates;
	}

	public Boolean getHasTariffApplicability() {
		return hasTariffApplicability;
	}

	public void setHasTariffApplicability(Boolean hasTariffApplicability) {
		this.hasTariffApplicability = hasTariffApplicability;
	}

	public Boolean getHasRateApplicability() {
		return hasRateApplicability;
	}

	public void setHasRateApplicability(Boolean hasRateApplicability) {
		this.hasRateApplicability = hasRateApplicability;
	}

	public List<TariffProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<TariffProperty> properties) {
		this.properties = properties;
	}

	public List<TariffRate> getRates() {
		return rates;
	}

	public void setRates(List<TariffRate> rates) {
		this.rates = rates;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getEffectiveOnRule() {
		return effectiveOnRule;
	}

	public void setEffectiveOnRule(String effectiveOnRule) {
		this.effectiveOnRule = effectiveOnRule;
	}
}
