package com.genability.client.types;

import java.io.Serializable;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadingDataSummary implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String quantityUnit;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private Integer numberOfReadings;

	public ReadingDataSummary() {

	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	@JsonIgnore
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	@JsonIgnore
	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public Integer getNumberOfReadings() {
		return numberOfReadings;
	}

	public void setNumberOfReadings(Integer numberOfReadings) {
		this.numberOfReadings = numberOfReadings;
	}
}
