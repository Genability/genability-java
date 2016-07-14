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
	
	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder extends PropertyData.Builder {
		private Integer timeAccuracy;

		private String quantityUnit;
		private BigDecimal quantityValue;
		private BigDecimal quantityCost;
		private BigDecimal quantityRate;

		private TimeOfUseType touType;

		// These methods are overridden here so that they return the proper builder.
		@Override
		public Builder setKeyName(String keyName) {
			this.keyName = keyName;
			return this;
		}
		
		@Override
		public Builder setSource(String source) {
			this.source = source;
			return this;
		}
		
		@Override
		public Builder setFromDateTime(DateTime fromDateTime) {
			this.fromDateTime = fromDateTime;
			return this;
		}
		
		@Override
		public Builder setToDateTime(DateTime toDateTime) {
			this.toDateTime = toDateTime;
			return this;
		}
		
		@Override
		public Builder setPeriod(String period) {
			this.period = period;
			return this;
		}
		
		@Override
		public Builder setUnit(String unit) {
			this.unit = unit;
			return this;
		}
		
		@Override
		public Builder setDataValue(String dataValue) {
			this.dataValue = dataValue;
			return this;
		}
		
		@Override
		public Builder setDataFactor(BigDecimal dataFactor) {
			this.dataFactor = dataFactor;
			return this;
		}
		
		@Override
		public Builder setAccuracy(BigDecimal accuracy) {
			this.accuracy = accuracy;
			return this;
		}
		
		@Override
		public Builder setScenarios(String scenarios) {
			this.scenarios = scenarios;
			return this;
		}
		
		@Override
		public Builder setDataType(DataType dataType) {
			this.dataType = dataType;
			return this;
		}
		
		@Override
		public Builder setDuration(Long duration) {
			this.duration = duration;
			return this;
		}
		
		@Override
		public Builder setOperator(String operator) {
			this.operator = operator;
			return this;
		}
		
		public Builder setTimeAccuracy(Integer timeAccuracy) {
			this.timeAccuracy = timeAccuracy;
			return this;
		}

		public Builder setQuantityUnit(String quantityUnit) {
			this.quantityUnit = quantityUnit;
			return this;
		}

		public Builder setQuantityValue(BigDecimal quantityValue) {
			this.quantityValue = quantityValue;
			return this;
		}

		public Builder setQuantityCost(BigDecimal quantityCost) {
			this.quantityCost = quantityCost;
			return this;
		}

		public Builder setQuantityRate(BigDecimal quantityRate) {
			this.quantityRate = quantityRate;
			return this;
		}

		public Builder setTouType(TimeOfUseType touType) {
			this.touType = touType;
			return this;
		}
		
		public ReadingData build() {
			ReadingData rd = new ReadingData();
			
			// Inherited from PropretyData.Builder
			rd.setKeyName(keyName);
			rd.setSource(source);
			rd.setFromDateTime(fromDateTime);
			rd.setToDateTime(toDateTime);
			rd.setPeriod(period);
			rd.setUnit(unit);
			rd.setDataValue(dataValue);
			rd.setDataFactor(dataFactor);
			rd.setAccuracy(accuracy);
			rd.setScenarios(scenarios);
			rd.setDuration(duration);
			rd.setOperator(operator);
			
			// ReadingData.Builder
			rd.setTimeAccuracy(timeAccuracy);
			rd.setQuantityUnit(quantityUnit);
			rd.setQuantityValue(quantityValue);
			rd.setQuantityCost(quantityCost);
			rd.setQuantityRate(quantityRate);
			rd.setTouType(touType);
			
			return rd;
		}
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

	@Override
	public void setFromDateTime(DateTime fromDate) {
		this.fromDateTime = fromDate;
		this.startTime = fromDateTime.getMillis();
	}

	@Override
	public void setToDateTime(DateTime toDate) {
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
	 * Deprecated - The {@link DataType} for ReadingData is always <code>DECIMAL</code>. This method has
	 * no effect.
	 */
	@Override 
	@JsonIgnore
	@Deprecated
	public void setDataType(DataType dataType) {}

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

