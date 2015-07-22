package com.genability.client.types;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeOfUseInterval {
	
	private Long touGroupId_;
	private Long touId_;
	private TimeOfUseType touType;
	private String touName_;
	private DateTime fromDateTime_;
	private DateTime toDateTime_;
	private Long calendarId_;

	public Long getTouGroupId() {
		return touGroupId_;
	}

	public void setTouGroupId(Long touGroupId) {
		this.touGroupId_ = touGroupId;
	}

	public Long getTouId() {
		return touId_;
	}

	public void setTouId(Long touId) {
		this.touId_ = touId;
	}

	public TimeOfUseType getTouType() {
		return touType;
	}

	public void setTouType(TimeOfUseType touType) {
		this.touType = touType;
	}

	public String getTouName() {
		return touName_;
	}

	public void setTouName(String touName) {
		this.touName_ = touName;
	}

	public DateTime getFromDateTime() {
		return fromDateTime_;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime_ = fromDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime_;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime_ = toDateTime;
	}

	public void setCalendarId(Long calendarId) {
		this.calendarId_ = calendarId;
	}

	public Long getCalendarId() {
		return calendarId_;
	}
}
