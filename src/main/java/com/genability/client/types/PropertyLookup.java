package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PropertyLookup {

	public static final String REST_TYPE = "PropertyLookup";
	
	private Long lookupId;
	private String propertyKey;
	private String subPropertyKey;
	private LocalDateTime fromDateTime;
	private LocalDateTime forecastDateTime;
	private LocalDateTime toDateTime;
	private BigDecimal value;
	private BigDecimal bestValue;
	private BigDecimal bestAccuracy;
	private BigDecimal actualValue;
	private BigDecimal lseForecastValue;
	private BigDecimal lseForecastAccuracy;
	private BigDecimal forecastValue;
	private BigDecimal forecastAccuracy;

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
