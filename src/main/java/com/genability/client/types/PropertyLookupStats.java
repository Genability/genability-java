package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PropertyLookupStats {


	public static final String REST_TYPE = "PropertyLookupStats";

	private String keyName;

	private DateTime minFromDateTime;
	
	private DateTime maxToDateTime;
	
	private Integer lookupCount;
	
	private BigDecimal meanValue;

	private Long totalDuration;
	
	private Long meanDuration;
	
	private Long missingDuration;

	private DateTime lastUpdatedDate;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public DateTime getMinFromDateTime() {
		return minFromDateTime;
	}

	public void setMinFromDateTime(DateTime minFromDateTime) {
		this.minFromDateTime = minFromDateTime;
	}

	public DateTime getMaxToDateTime() {
		return maxToDateTime;
	}

	public void setMaxToDateTime(DateTime maxToDateTime) {
		this.maxToDateTime = maxToDateTime;
	}

	public Integer getLookupCount() {
		return lookupCount;
	}

	public void setLookupCount(Integer lookupCount) {
		this.lookupCount = lookupCount;
	}

	public BigDecimal getMeanValue() {
		return meanValue;
	}

	public void setMeanValue(BigDecimal meanValue) {
		this.meanValue = meanValue;
	}

	public Long getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(Long totalDuration) {
		this.totalDuration = totalDuration;
	}

	public Long getMeanDuration() {
		return meanDuration;
	}

	public void setMeanDuration(Long meanDuration) {
		this.meanDuration = meanDuration;
	}

	public Long getMissingDuration() {
		return missingDuration;
	}

	public void setMissingDuration(Long missingDuration) {
		this.missingDuration = missingDuration;
	}

	public DateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(DateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
}
