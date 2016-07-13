package com.genability.client.api.request;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.tz.DateTimeZoneBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.genability.client.types.PropertyData;
import com.genability.client.types.TariffRate;

public class AccountAnalysisRequest extends AbstractRequest implements Serializable {
	
	/*
	 * This special timezone is used to indicate that a particular datetime should be
	 * serialized as a date only (i.e. exclude the time portion of the DateTime)
	 */
	private static final DateTimeZone DATE_ONLY_TIMEZONE = new DateTimeZoneBuilder()
			.toDateTimeZone("Genability LocalDate Signal", true);
	private static final long serialVersionUID = 1L;

	private String providerAccountId;
	private String accountId;
	private Boolean populateCosts;
	private Boolean useIntelligentBaselining;

	private DateTime fromDateTime;
	private DateTime toDateTime;

	private List<PropertyData> propertyInputs;

	private List<TariffRate> rateInputs;

	public String getProviderAccountId() {
		return providerAccountId;
	}

	public AccountAnalysisRequest setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
		return this;
	}

	public String getAccountId() {
		return accountId;
	}

	public AccountAnalysisRequest setAccountId(String accountId) {
		this.accountId = accountId;
		return this;
	}

	public Boolean getPopulateCosts() {
		return populateCosts;
	}

	public AccountAnalysisRequest setPopulateCosts(final boolean populateCosts) {
		this.populateCosts = populateCosts;
		return this;
	}

	public Boolean getUseIntelligentBaselining() {
		return useIntelligentBaselining;
	}

	public AccountAnalysisRequest setUseIntelligentBaselining(final boolean useIb) {
		this.useIntelligentBaselining = useIb;
		return this;
	}

	@JsonSerialize(using=DateTimeSerializer.class)
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	 /**
	 * This method is used to set the fromDateTime as a date only. The resulting request will include the following:
	 * "fromDateTime":"YYYY-MM-DD"
	 * 
	 * @param year The year.
	 * @param month The month.
	 * @param day The day.
	 */
	@JsonIgnore
	public AccountAnalysisRequest setFromDateTime(int year, int month, int day) {
		setFromDateTime(new LocalDate(year, month, day));
		return this;
	}

	/**
	 * This method is used to set the fromDateTime as a date only. The resulting request will include the following:
	 * "fromDateTime":"YYYY-MM-DD"
	 * 
	 * @param date The date.
	 */
	@JsonIgnore
	public AccountAnalysisRequest setFromDateTime(LocalDate date) {
		fromDateTime = convertLocalDate(date);
		return this;
	}

	@JsonProperty
	public AccountAnalysisRequest setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
		return this;
	}

	@JsonSerialize(using=DateTimeSerializer.class)
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * This method is used to set the toDateTime as a date only. The resulting request will include the following:
	 * "toDateTime":"YYYY-MM-DD"
	 * 
	 * @param year The year.
	 * @param month The month.
	 * @param day The day.
	 */
	@JsonIgnore
	public AccountAnalysisRequest setToDateTime(int year, int month, int day) {
		setToDateTime(new LocalDate(year, month, day));
		return this;
	}

	/**
	 * This method is used to set the toDateTime as a date only. The resulting request will include the following:
	 * "toDateTime":"YYYY-MM-DD"
	 * 
	 * @param date The date.
	 */
	@JsonIgnore
	public AccountAnalysisRequest setToDateTime(LocalDate date) {
		toDateTime = convertLocalDate(date);
		return this;
	}

	@JsonProperty
	public AccountAnalysisRequest setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
		return this;
	}

	public List<TariffRate> getRateInputs() {
		return rateInputs;
	}

	public AccountAnalysisRequest setRateInputs(List<TariffRate> rateInputs) {
		this.rateInputs = rateInputs;
		return this;
	}

	public List<PropertyData> getPropertyInputs() {
		return propertyInputs;
	}

	public AccountAnalysisRequest setPropertyInputs(List<PropertyData> propertyInputs) {
		this.propertyInputs = propertyInputs;
		return this;
	}

	private DateTime convertLocalDate(LocalDate date) {
		DateTime dt = new DateTime(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), 0, 0, DATE_ONLY_TIMEZONE);
		return dt;
	}

	/*		
	 * This class is used to serialize DateTime objects. In the special case where the timeZone is set to		
	 * AccountAnalysisRequest.DATE_ONLY_TIMEZONE, the result will contain the date only		
	 */
	private static class DateTimeSerializer extends JsonSerializer<DateTime> {

		@Override
		public void serialize(DateTime value, JsonGenerator jgen,
				SerializerProvider provider) throws IOException,
		JsonProcessingException {

			if (DATE_ONLY_TIMEZONE.equals(value.getZone())) {
				LocalDate date = new LocalDate(value.getYear(), value.getMonthOfYear(), value.getDayOfMonth());
				jgen.writeObject(date);
			} else {
				jgen.writeObject(value);
			}

		}
	}
}
