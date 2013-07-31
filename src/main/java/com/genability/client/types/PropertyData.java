package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyData {
	
	public static final String REST_TYPE = "PropertyData";
	
	protected String keyName;
	
	protected DateTime fromDateTime;
	
	protected DateTime toDateTime;
	
	protected String period;
	
	protected String unit;
	
	protected String dataValue;
	
	protected BigDecimal accuracy;
	
	/*
	 * Possible values for dataType are:
	 * CHOICE
	 * STRING
	 * BOOLEAN
	 * DATE
	 * DECIMAL
	 * INTEGER
	 * FORMULA
	 * LOOKUP
	 */
	protected String dataType;
	
	public PropertyData() {
		//constructor
	}


	public void setKeyName(String keyName_) {
		keyName = keyName_;
	}
	
	public String getKeyName() {
		return keyName;
	}
	
	/**
	 * @return the fromDate
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */

	public void setFromDateTime(DateTime fromDate) {
		this.fromDateTime = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDateTime(DateTime toDate) {
		this.toDateTime = toDate;
	}

	/**
	 * @param unit
	 *            the unit_ to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return the unit_
	 */
	@JsonInclude(Include.NON_NULL)
	public String getPeriod() {
		return period;
	}
	
	/**
	 * @param unit
	 *            the unit_ to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the unit_
	 */
	@JsonInclude(Include.NON_NULL)
	public String getUnit() {
		return unit;
	}

	/**
	 * 
	 */
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	/**
	 * @return the unit_
	 */
	@JsonInclude(Include.NON_NULL)
	public String getDataValue() {
		return dataValue;
	}

	/**
	 * @param accuracy
	 *            the accuracy_ to set
	 */
	public void setAccuracy(BigDecimal accuracy) {
		this.accuracy = accuracy;
	}

	
	/**
	 * @return the accuracy_
	 */
	@JsonInclude(Include.NON_NULL)
	public BigDecimal getAccuracy() {
		return accuracy;
	}
	
	public void setDataType(String dataType_) {
		dataType = dataType_;
	}

	public String getDataType() {
		return dataType;
	}
}