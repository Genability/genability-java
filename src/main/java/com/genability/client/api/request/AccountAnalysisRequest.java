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

	public Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder extends AbstractGetNRequest.Builder<Builder> {
		
		private String providerAccountId;
		private String accountId;
		private Boolean populateCosts;
		private Boolean useIntelligentBaselining;

		// Only allow fromDateTime here since toDateTime is never what you want
		private DateTime fromDateTime;

		private List<PropertyData> propertyInputs;
		private List<TariffRate> rateInputs;

		private Builder() {}
		
		public Builder setProviderAccountId(String providerAccountId) {
			this.providerAccountId = providerAccountId;
			return getThis();
		}

		public Builder setAccountId(String accountId) {
			this.accountId = accountId;
			return getThis();
		}

		public Builder setPopulateCosts(Boolean populateCosts) {
			this.populateCosts = populateCosts;
			return getThis();
		}

		public Builder setUseIntelligentBaselining(Boolean useIntelligentBaselining) {
			this.useIntelligentBaselining = useIntelligentBaselining;
			return getThis();
		}

		public Builder setFromDateTime(DateTime fromDateTime) {
			this.fromDateTime = fromDateTime;
			return getThis();
		}

		public void setFromDateTime(int year, int month, int day) {
			setFromDateTime(new LocalDate(year, month, day));
		}
		
		public void setFromDateTime(LocalDate date) {
			fromDateTime = convertLocalDate(date);
		}
		
		public Builder setPropertyInputs(List<PropertyData> propertyInputs) {
			this.propertyInputs = propertyInputs;
			return getThis();
		}

		public Builder setRateInputs(List<TariffRate> rateInputs) {
			this.rateInputs = rateInputs;
			return getThis();
		}

		public AccountAnalysisRequest build() {
			AccountAnalysisRequest request = new AccountAnalysisRequest();
			
			setRequestFields(request);
			request.setAccountId(accountId);
			request.setFromDateTime(fromDateTime);
			request.setPopulateCosts(populateCosts);
			request.setPropertyInputs(propertyInputs);
			request.setProviderAccountId(providerAccountId);
			request.setRateInputs(rateInputs);
			request.setUseIntelligentBaselining(useIntelligentBaselining);
			
			return request;
		}
		
		@Override
		protected Builder getThis() {
			return this;
		}
	}
	
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

	public Boolean getUseIntelligentBaselining() {
		return useIntelligentBaselining;
	}

	public void setUseIntelligentBaselining(final boolean useIb) {
		this.useIntelligentBaselining = useIb;
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
	public void setFromDateTime(int year, int month, int day) {
		setFromDateTime(new LocalDate(year, month, day));
	}

	/**
	 * This method is used to set the fromDateTime as a date only. The resulting request will include the following:
	 * "fromDateTime":"YYYY-MM-DD"
	 * 
	 * @param date The date.
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

	/**
	 * This method is used to set the toDateTime as a date only. The resulting request will include the following:
	 * "toDateTime":"YYYY-MM-DD"
	 * 
	 * @param year The year.
	 * @param month The month.
	 * @param day The day.
	 */
	@JsonIgnore
	public void setToDateTime(int year, int month, int day) {
		setToDateTime(new LocalDate(year, month, day));
	}

	/**
	 * This method is used to set the toDateTime as a date only. The resulting request will include the following:
	 * "toDateTime":"YYYY-MM-DD"
	 * 
	 * @param date The date.
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

	private static DateTime convertLocalDate(LocalDate date) {
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
