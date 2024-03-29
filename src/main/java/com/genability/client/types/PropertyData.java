package com.genability.client.types;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyData {
	
	public static final String REST_TYPE = "PropertyData";
	
	protected String keyName;
	protected String source;

	protected DateTime fromDateTime;	
	protected DateTime toDateTime;	
	protected String period;

	protected String unit;	
	protected String dataValue;

    /**
     * A multiplier. This can be used, for instance, to see the effect of a 10% increase in electricity usage
     * on costs - in that case, the propertyInput for the profileId would include a dataFactor of 1.1 (for 110%).
     */
    protected BigDecimal dataFactor;

    /**
     * How accurately known in percent this PropertyData is, from 0 (totally unknown) to 100 (totally accurate).
     * For instance, we may guess a customer's tariff and assign it an accuracy of, eg, 80, but if the customer
     * has specified their tariff or we know it from a bill, we assign it an accuracy of 100. (Optional)
     */
	protected BigDecimal accuracy;

    /**
     * For a Savings Analysis that compares two scenarios, which scenarios (cases) this PropertyData applies to.
     * Possibilities are "before", "after", and "solar". If more than one, join with commas. Eg "after,solar".
     */
	protected String scenarios;
	protected DataType dataType;

	protected Long duration;
	private String operator;

	private List<BigDecimal> dataSeries;

	private List<BigDecimal> exportDataSeries;

	public PropertyData() {}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	public String getKeyName() {
		return keyName;
	}
	
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(DateTime fromDate) {
		this.fromDateTime = fromDate;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(DateTime toDate) {
		this.toDateTime = toDate;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@JsonInclude(Include.NON_NULL)
	public String getPeriod() {
		return period;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonInclude(Include.NON_NULL)
	public String getUnit() {
		return unit;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	@JsonIgnore
	public void setDataValue(Number dataValue) {
		this.dataValue = dataValue != null ? dataValue.toString() : null;
	}

	@JsonIgnore
	public void setDataValue(Enum<?> dataValue) {
		this.dataValue = dataValue != null ? dataValue.name() : null;
	}

	@JsonIgnore
	public void setDataValue(DateTime dataValue) {
		this.dataValue = dataValue != null ? dataValue.toString() : null;
	}

	@JsonIgnore
	public void setDataValue(Boolean dataValue) {
		this.dataValue = dataValue != null ? Boolean.toString(dataValue) : null;
	}

	@JsonProperty("dataValue")
	@JsonInclude(Include.NON_NULL)
	public String getDataValue() {
		return dataValue;
	}

	@JsonInclude(Include.NON_NULL)
	public BigDecimal getDataFactor() {
		return dataFactor;
	}

	public void setDataFactor(BigDecimal dataFactor) {
		this.dataFactor = dataFactor;
	}

	public void setAccuracy(BigDecimal accuracy) {
		this.accuracy = accuracy;
	}
	
	@JsonInclude(Include.NON_NULL)
	public BigDecimal getAccuracy() {
		return accuracy;
	}

	@JsonInclude(Include.NON_NULL)
	public String getScenarios() {
		return scenarios;

	}

	public void setScenarios(String scenarios) {
                this.scenarios = scenarios;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public DataType getDataType() {
		return dataType;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<BigDecimal> getDataSeries() {
		return dataSeries;
	}

	public void setDataSeries(List<BigDecimal> dataSeries) {
		this.dataSeries = dataSeries;
	}

	public List<BigDecimal> getExportDataSeries() {
		return exportDataSeries;
	}

	public void setExportDataSeries(List<BigDecimal> exportDataSeries) {
		this.exportDataSeries = exportDataSeries;
	}

	public void addData(BigDecimal data) {
		if (dataSeries == null) {
			dataSeries = new ArrayList<BigDecimal>();
		}

		dataSeries.add(data);
	}

	public void addDataSeries(Collection<BigDecimal> dataSeries) {
		if (this.dataSeries == null) {
			this.dataSeries = new ArrayList<BigDecimal>();
		}

		this.dataSeries.addAll(dataSeries);
	}
}
