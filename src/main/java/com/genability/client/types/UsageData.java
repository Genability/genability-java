package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;


public interface UsageData {


	String getUsageProfileId();
	void setUsageProfileId(String usageProfileId);
	
	Long getStartTime();
	void setStartTime(Long startTime);

	String getQuantityUnit();
	void setQuantityUnit(String quantityUnit);
	
	Long getEndTime();
	void setEndTime(Long endTime);

	DateTime getFromDateTime();
	
	DateTime getToDateTime();
	
	Long getDuration();
	void setDuration(Long duration);

	Integer getTimeAccuracy();
	void setTimeAccuracy(Integer timeAccuracy);
	
	String getKeyName();
	
	BigDecimal getQuantityValue();
	void setQuantityValue(BigDecimal quantityValue);
	
	BigDecimal getQuantityAccuracy();
	void setQuantityAccuracy(BigDecimal quantityAccuracy);

}
