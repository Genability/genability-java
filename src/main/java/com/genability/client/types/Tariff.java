package com.genability.client.types;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tariff {


	public static final String REST_TYPE = "Tariff";
	
    /**
     * Indicates a RESIDENTIAL class of customer.
     */	
	public static final String CUSTOMER_CLASS_RESIDENTIAL = "RESIDENTIAL";

    /**
     * Indicates a GENERAL class of customer.
     */
	public static final String CUSTOMER_CLASS_GENERAL = "GENERAL";
	
    /**
     * Indicates a SPECIAL_USE class of customer.
     */
	public static final String CUSTOMER_CLASS_SPECIAL_USE = "SPECIAL_USE";



    /**
     * Indicates a DEFAULT tariff (residential only).
     */
    public static final String TARIFF_TYPE_DEFAULT = "DEFAULT";
    
    /**
     * Indicates an ALTERNATIVE tariff (i.e. an opt in tariff).
     */
    public static final String TARIFF_TYPE_ALTERNATIVE = "ALTERNATIVE";
    
    /**
     * Indicates an OPTIONAL_EXTRA tariff (adds on to your tariff).
     */
    public static final String TARIFF_TYPE_OPTIONAL_EXTRA = "OPTIONAL_EXTRA";
    
    /**
     * Indicates an RIDER tariff (reusable rates).
     */
    public static final String TARIFF_TYPE_RIDER = "RIDER";

    
	/**
	 * private member variable for TariffId.
	 */
	private Long tariffId;

	/**
	 * private member variable for MasterTariffId.
	 */
	private Long masterTariffId;

	/**
	 * private member variable for PriorTariffId.
	 */
	private Long priorTariffId;

	/**
	 * private member variable for LseId.
	 */
	private Long lseId;

	/**
	 * private member variable for LseName.
	 */
	private String lseName;

	/**
	 * private member variable for DistributionLseId.
	 */
	private Long distributionLseId;
	
	/**
	 * private member variable for TariffCode.
	 */
	private String tariffCode;

	/**
	 * private member variable for TariffName.
	 */
	private String tariffName;

	/**
	 * private member variable for TariffType.
	 */
	private String tariffType;

	/**
	 * private member variable for ChargePeriod. the default value is MONTHLY
	 */
	private String billingPeriod;

	/**
	 * private member variable for CustomerClass.
	 */
	private String customerClass;

	/**
	 * private member variable for TerritoryId.
	 */
	private Long territoryId;

	/**
	 * private member variable for EffectiveDate.
	 */
	private String effectiveDate;

	/**
	 * private member variable for EndDate.
	 */
	private String endDate;

	/**
	 * private member variable for the time zone for this tariff.
	 */
	private String timeZone;
	
	/**
	 * private member variable for the isActive flag.
	 */
	private Boolean isActive;

	/**
	 * private member variable for isoCurrency
	 */
	private String currency;

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
	
	/**
	 * @return the tariffId
	 */
	public Long getTariffId() {
		return tariffId;
	}

	/**
	 * @param tariffId the tariffId to set
	 */
	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	/**
	 * @return the masterTariffId
	 */
	public Long getMasterTariffId() {
		return masterTariffId;
	}

	/**
	 * @param masterTariffId the masterTariffId to set
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	/**
	 * @return the priorTariffId
	 */
	public Long getPriorTariffId() {
		return priorTariffId;
	}

	/**
	 * @param priorTariffId the priorTariffId to set
	 */
	public void setPriorTariffId(Long priorTariffId) {
		this.priorTariffId = priorTariffId;
	}

	/**
	 * @return the lseId
	 */
	public Long getLseId() {
		return lseId;
	}

	/**
	 * @param lseId the lseId to set
	 */
	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	/**
	 * @return the lseName
	 */
	public String getLseName() {
		return lseName;
	}

	/**
	 * @param lseName the lseName to set
	 */
	public void setLseName(String lseName) {
		this.lseName = lseName;
	}

	/**
	 * @return the distributionLseId
	 */
	public Long getDistributionLseId() {
		return distributionLseId;
	}

	/**
	 * @param distributionLseId the distributionLseId to set
	 */
	public void setDistributionLseId(Long distributionLseId) {
		this.distributionLseId = distributionLseId;
	}

	/**
	 * @return the tariffCode
	 */
	public String getTariffCode() {
		return tariffCode;
	}

	/**
	 * @param tariffCode the tariffCode to set
	 */
	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}

	/**
	 * @return the tariffName
	 */
	public String getTariffName() {
		return tariffName;
	}

	/**
	 * @param tariffName the tariffName to set
	 */
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	/**
	 * @return the tariffType
	 */
	public String getTariffType() {
		return tariffType;
	}

	/**
	 * @param tariffType the tariffType to set
	 */
	public void setTariffType(String tariffType) {
		this.tariffType = tariffType;
	}

	/**
	 * @return the billingPeriod
	 */
	public String getBillingPeriod() {
		return billingPeriod;
	}

	/**
	 * @param billingPeriod the billingPeriod to set
	 */
	public void setBillingPeriod(String billingPeriod) {
		this.billingPeriod = billingPeriod;
	}

	/**
	 * @return the customerClass
	 */
	public String getCustomerClass() {
		return customerClass;
	}

	/**
	 * @param customerClass the customerClass to set
	 */
	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}

	/**
	 * @return the territoryId
	 */
	public Long getTerritoryId() {
		return territoryId;
	}

	/**
	 * @param territoryId the territoryId to set
	 */
	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}

	/**
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the timezone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isoCurrency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param isoCurrency the isoCurrency to set
	 */
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
}
