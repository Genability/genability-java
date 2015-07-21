package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.genability.client.types.PropertyData;
import com.genability.client.types.TariffRate;
import com.genability.client.util.DateTimeSerializer;

public class AccountAnalysisRequest extends AbstractRequest implements Serializable {
	
	/*
	 * This special timezone is used to indicate that a particular datetime should be
	 * serialized as a date only (i.e. exclude the time portion of the DateTime)
	 */
	public static final DateTimeZone DATE_ONLY_TIMEZONE = DateTimeZone.forID("Etc/UCT");

	private static final long serialVersionUID = 1L;

	private String providerAccountId;
	private String accountId;
	private Boolean populateCosts;

	private DateTime fromDateTime;
	private DateTime toDateTime;

	private List<PropertyData> propertyInputs;

	private List<TariffRate> rateInputs;

	public String getProviderAccountId() {
		return providerAccountId;
	}

	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Boolean getPopulateCosts() {
		return populateCosts;
	}

	public void setPopulateCosts(final boolean populateCosts) {
		this.populateCosts = populateCosts;
	}

	@JsonSerialize(using=DateTimeSerializer.class)
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/*
	 * This method is used to set the fromDateTime as a date only. The resulting request will include the following:
	 * "fromDateTime":"YYYY-MM-DD"
	 */
	 @JsonIgnore
	 public void setFromDateTime(int year, int month, int day) {
		setFromDateTime(new LocalDate(year, month, day));
	 }

	 /*
	  * This method is used to set the fromDateTime as a date only. The resulting request will include the following:
	  * "fromDateTime":"YYYY-MM-DD"
	  */
	 @JsonIgnore
	 public void setFromDateTime(LocalDate date) {
		 fromDateTime = convertLocalDate(date);
	 }

	 @JsonProperty
	 public void setFromDateTime(DateTime fromDateTime) {
		 this.fromDateTime = fromDateTime;
	 }

	 @JsonSerialize(using=DateTimeSerializer.class)
	 public DateTime getToDateTime() {
		 return toDateTime;
	 }

	 /*
	  * This method is used to set the toDateTime as a date only. The resulting request will include the following:
	  * "toDateTime":"YYYY-MM-DD"
	  */
	 @JsonIgnore
	 public void setToDateTime(int year, int month, int day) {
		 setToDateTime(new LocalDate(year, month, day));
	 }

	 /*
	  * This method is used to set the toDateTime as a date only. The resulting request will include the following:
	  * "toDateTime":"YYYY-MM-DD"
	  */
	 @JsonIgnore
	 public void setToDateTime(LocalDate date) {
		 toDateTime = convertLocalDate(date);
	 }

	 @JsonProperty
	 public void setToDateTime(DateTime toDateTime) {
		 this.toDateTime = toDateTime;
	 }

	 public List<TariffRate> getRateInputs() {
		 return rateInputs;
	 }

	 public void setRateInputs(List<TariffRate> rateInputs) {
		 this.rateInputs = rateInputs;
	 }

	 public List<PropertyData> getPropertyInputs() {
		 return propertyInputs;
	 }

	 public void setPropertyInputs(List<PropertyData> propertyInputs) {
		 this.propertyInputs = propertyInputs;
	 }

	 private DateTime convertLocalDate(LocalDate date) {
		 DateTime dt = new DateTime(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), 0, 0, DATE_ONLY_TIMEZONE);
		 return dt;
	 }
}
