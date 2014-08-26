package com.genability.client.types;

import java.math.BigDecimal;
import java.sql.Date;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PropertyLookup {

	public static final String REST_TYPE = "PropertyLookup";
	
	/**
	 * private member variable for LookupId.
	 */
	private Long lookupId;

	/**
	 * private member variable for PropertyKey.
	 */
	private String propertyKey;

	/**
	 * private member variable for SubPropertyKey.
	 */
	private String subPropertyKey;

	/**
	 * private member variable for FromDateTime.
	 */
	private LocalDateTime fromDateTime;

	/**
	 * private member variable for forecastedDateTime.
	 */
	private LocalDateTime forecastDateTime;

	/**
	 * private member variable for ToDateTime.
	 */
	private LocalDateTime toDateTime;

	/**
	 * private member variable for Value.
	 */
	private BigDecimal value;
	
	private BigDecimal bestValue;
	
	private BigDecimal bestAccuracy;
	
	private BigDecimal actualValue;

	/**
	 * private member variable for LseForecastValue.
	 */
	private BigDecimal lseForecastValue;

	/**
	 * private member variable for LseForecastAccuracy.
	 */
	private BigDecimal lseForecastAccuracy;

	/**
	 * private member variable for ForecastValue.
	 */
	private BigDecimal forecastValue;

	/**
	 * private member variable for ForecastAccuracy.
	 */
	private BigDecimal forecastAccuracy;
	

	private Boolean isChanged;

	private LocalDateTime newFromDateTime;

	/**
	 * private member variable for createdBy.
	 */
	
	private Long createdBy;

	/**
	 * private member variable for createdDate.
	 */
	
	private Date createdDate;

	/**
	 * private member variable for lastUpdatedBy.
	 */
	
	private Long lastUpdatedBy;

	/**
	 * private member variable for lastUpdatedDate.
	 */
	
	private Date lastUpdatedDate;

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}

	public String getSubPropertyKey() {
		return subPropertyKey;
	}

	public void setSubPropertyKey(String subPropertyKey) {
		this.subPropertyKey = subPropertyKey;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getForecastDateTime() {
		return forecastDateTime;
	}

	public void setForecastDateTime(LocalDateTime forecastDateTime) {
		this.forecastDateTime = forecastDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getLseForecastValue() {
		return lseForecastValue;
	}

	public void setLseForecastValue(BigDecimal lseForecastValue) {
		this.lseForecastValue = lseForecastValue;
	}

	public BigDecimal getLseForecastAccuracy() {
		return lseForecastAccuracy;
	}

	public void setLseForecastAccuracy(BigDecimal lseForecastAccuracy) {
		this.lseForecastAccuracy = lseForecastAccuracy;
	}

	public BigDecimal getForecastValue() {
		return forecastValue;
	}

	public void setForecastValue(BigDecimal forecastValue) {
		this.forecastValue = forecastValue;
	}

	public BigDecimal getForecastAccuracy() {
		return forecastAccuracy;
	}

	public void setForecastAccuracy(BigDecimal forecastAccuracy) {
		this.forecastAccuracy = forecastAccuracy;
	}

	public Boolean getIsChanged() {
		return isChanged;
	}

	public void setIsChanged(Boolean isChanged) {
		this.isChanged = isChanged;
	}

	public LocalDateTime getNewFromDateTime() {
		return newFromDateTime;
	}

	public void setNewFromDateTime(LocalDateTime newFromDateTime) {
		this.newFromDateTime = newFromDateTime;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public BigDecimal getBestValue() {
		return bestValue;
	}

	public void setBestValue(BigDecimal bestValue) {
		this.bestValue = bestValue;
	}

	public BigDecimal getBestAccuracy() {
		return bestAccuracy;
	}

	public void setBestAccuracy(BigDecimal bestAccuracy) {
		this.bestAccuracy = bestAccuracy;
	}

	public BigDecimal getActualValue() {
		return actualValue;
	}

	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
	}


}
