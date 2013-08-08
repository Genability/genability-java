package com.genability.client.types;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This class represents a reading of a measurement. It has a start time and an
 * end time, plus a value and a field that denotes what the value is measuring.
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadingData extends PropertyData implements Serializable, UsageData {

	public static final String REST_TYPE = "ReadingData";

	public static final String KWH_UNIT = "kWh";

	public static final String KW_UNIT = "kW";
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * private member variable for ProfileId.
	 */
	private String usageProfileId;

	/**
	 * private member variable for StartTime.
	 */
	private Long startTime;

	/**
	 * private member variable for EndTime.
	 */
	private Long endTime;

	/**
	 * private member variable for Duration.
	 */
	private Long duration;

	/**
	 * private member variable for TimeAccuracy.
	 */
	private Integer timeAccuracy;

	/**
	 * private member variable for QuantityUnit.
	 */
	private String quantityUnit;

	/**
	 * private member variable for QuantityValue.
	 */
	private BigDecimal quantityValue;


	/**
	 * This is the default constructor.
	 */
	public ReadingData() {
		// no-op
		
		this.dataType = DataType.DECIMAL;

	} // end of constructor

	/**
	 * Access method for ProfileId.
	 */
	@JsonIgnore
	public String getUsageProfileId() {
		return usageProfileId;
	}

	/**
	 * Mutator for ProfileId.
	 */
	public void setUsageProfileId(String usageProfileId) {
		this.usageProfileId = usageProfileId;
	}

	/**
	 * Access method for StartTime.
	 */
	@JsonIgnore
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * Mutator for StartTime. This will also set the fromDateTime member
	 * variable without going through the mutator for the fromDateTime.
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
		if (startTime != null)
			this.fromDateTime = new DateTime(startTime, DateTimeZone.UTC);
		else
			this.fromDateTime = null;
	}

	/**
	 * Access method for EndTime.
	 */
	@JsonIgnore
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * Mutator for EndTime. This will also set the toDateTime member variable
	 * without going through the mutator for the toDateTime.
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
		if (endTime != null)
			this.toDateTime = new DateTime(endTime, DateTimeZone.UTC);
		else
			this.toDateTime = null;
	}

	/**
	 * Mutator for fromDateTime
	 */
	// Overriding so we can set ReadData startTime derived from fromDateTime
	@Override
	public void setFromDateTime(DateTime fromDate) {
		this.fromDateTime = fromDate;

		// set milliseconds to corresponding UTC without offsetting
		if (fromDate == null) {
			this.startTime = null;
		} else {
			this.startTime = fromDate.withZoneRetainFields(DateTimeZone.UTC).getMillis();
		}
	}

	/**
	 * Mutator for toDateTime
	 */
	@Override
	public void setToDateTime(DateTime toDate) {
		this.toDateTime = toDate;

		if (toDate == null) {
			this.endTime = null;
		} else {
			this.endTime = toDate.withZoneRetainFields(DateTimeZone.UTC).getMillis();
		}
	}

	/**
	 * Access method for Duration.
	 */

	public Long getDuration() {
		return duration;
	}

	/**
	 * Mutator for Duration.
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	/**
	 * Access method for TimeAccuracy.
	 */
	@JsonInclude(Include.NON_NULL)
	public Integer getTimeAccuracy() {
		return timeAccuracy;
	}

	/**
	 * Mutator for TimeAccuracy.
	 */
	public void setTimeAccuracy(Integer timeAccuracy) {
		this.timeAccuracy = timeAccuracy;
	}

	/**
	 * Access method for QuantityUnit.
	 */
	public String getQuantityUnit() {
		return quantityUnit;
	}

	/**
	 * Mutator for QuantityUnit.
	 */
	public void setQuantityUnit(String quantityUnit) {
		if (KWH_UNIT.equalsIgnoreCase(quantityUnit)) {
			this.quantityUnit = KWH_UNIT;
		} else if (KW_UNIT.equalsIgnoreCase(quantityUnit)) {
			this.quantityUnit = KW_UNIT;
		} else {
			this.quantityUnit = quantityUnit;
		}
	}

	/**
	 * Access method for QuantityValue.
	 */
	public BigDecimal getQuantityValue() {
		return quantityValue;
	}

	/**
	 * Mutator for QuantityValue.
	 */
	public void setQuantityValue(BigDecimal quantityValue) {
		this.quantityValue = quantityValue;
	}

	/**
	 * Access method for QuantityAccuracy.
	 */
	@JsonInclude(Include.NON_NULL)
	public BigDecimal getQuantityAccuracy() {
		return accuracy;
	}

	/**
	 * Mutator for QuantityAccuracy.
	 */
	public void setQuantityAccuracy(BigDecimal quantityAccuracy) {
		this.accuracy = quantityAccuracy;
	}

	/**
	 * Override the default behavior for keyName so that if this has a quantity
	 * unit of kWh its set to consumption , and if its kW its set to demand, but
	 * only when its not already set (so it can be something else if necessary).
	 */
	@Override
	public String getKeyName() {
		
		if (keyName == null) {
			if(ReadingData.KWH_UNIT.equals(this.quantityUnit))
				keyName = "consumption";
			else if (ReadingData.KW_UNIT.equals(this.quantityUnit))
				keyName = "demand";
		}
		
		return keyName;
	
	} // end of getKeyName
	
	
	/**
	 * DataType for ReadingData and BillingData is always a Decimal.
	 */
	@Override 
	@JsonIgnore
	public void setDataType(DataType dataType) {
	}

	/**
	 * DataType for ReadingData and BillingData is always a Decimal.
	 */
	@Override 
	@JsonIgnore
	public DataType getDataType() {
		
		return dataType;
		
	}

} // end of class ReadingData

