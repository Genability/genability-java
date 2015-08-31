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

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadingData extends PropertyData implements Serializable {

	public static final String REST_TYPE = "ReadingData";
	public static final String KWH_UNIT = "kWh";
	public static final String KW_UNIT = "kW";
	public static final String KVA_UNIT = "kVA";

	private static final long serialVersionUID = 1L;

	private String usageProfileId;

	private Long startTime;
	private Long endTime;
	private Integer timeAccuracy;

	private String quantityUnit;
	private BigDecimal quantityValue;
	private BigDecimal quantityCost;
	private BigDecimal quantityRate;
	private TimeOfUseType touType;

	public ReadingData() {		
		this.dataType = DataType.DECIMAL;
	}

	@JsonIgnore
	public String getUsageProfileId() {
		return usageProfileId;
	}

	public void setUsageProfileId(String usageProfileId) {
		this.usageProfileId = usageProfileId;
	}

	/**
	 * Deprecated - use getFromDateTime() instead.
	 * 
	 * @return The return value.
	 */
	@Deprecated
	@JsonIgnore
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * Deprecated - use setFromDateTime() instead.
	 * 
	 * @param startTime The startTime.
	 */
	@Deprecated
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
		if (startTime != null)
			this.fromDateTime = new DateTime(startTime, DateTimeZone.UTC);
		else
			this.fromDateTime = null;
	}

	/**
	 * Deprecated - use getToDateTime() instead.
	 * 
	 * @return The return value.
	 */
	@Deprecated
	@JsonIgnore
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * Deprecated - use setToDateTime() instead.
	 * 
	 * @param endTime The endTime.
	 */
	@Deprecated
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
		this.startTime = fromDateTime.getMillis();

	}

	@Override
	public void setToDateTime(DateTime toDate) {

		// set milliseconds to corresponding UTC without offsetting
		this.toDateTime = toDate;
		this.endTime = toDateTime.getMillis();

	}

	@JsonInclude(Include.NON_NULL)
	public Integer getTimeAccuracy() {
		return timeAccuracy;
	}

	public void setTimeAccuracy(Integer timeAccuracy) {
		this.timeAccuracy = timeAccuracy;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		if (KWH_UNIT.equalsIgnoreCase(quantityUnit)) {
			this.quantityUnit = KWH_UNIT;
		} else if (KW_UNIT.equalsIgnoreCase(quantityUnit)) {
			this.quantityUnit = KW_UNIT;
		} else {
			this.quantityUnit = quantityUnit;
		}
	}

	public BigDecimal getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(BigDecimal quantityValue) {
		this.quantityValue = quantityValue;
	}

	@JsonInclude(Include.NON_NULL)
	public BigDecimal getQuantityAccuracy() {
		return accuracy;
	}

	public void setQuantityAccuracy(BigDecimal quantityAccuracy) {
		this.accuracy = quantityAccuracy;
	}

	public BigDecimal getQuantityCost() {
		return quantityCost;
	}

	public void setQuantityCost(BigDecimal quantityCost) {
		this.quantityCost = quantityCost;
	}

	public BigDecimal getQuantityRate() {
		return quantityRate;
	}

	public void setQuantityRate(BigDecimal quantityRate) {
		this.quantityRate = quantityRate;
	}

	public TimeOfUseType getTouType() {
		return touType;
	}

	public void setTouType(TimeOfUseType touType) {
		this.touType = touType;
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
	
	}
	
	
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

    @Override
    public String toString() {
        return "ReadingData [startTime=" + new DateTime(startTime) + ", endTime=" + new DateTime(endTime) + ", quantityUnit=" + quantityUnit + ", quantityValue=" + quantityValue + "]";
    }
}

