package com.genability.client.api.request;

import org.joda.time.DateTime;

public class GetCalendarDatesRequest extends AbstractRequest{
private DateTime fromDateTime;
	
	private DateTime toDateTime;

	/**
	 * Private member variable for Locale.
	 */
	private String locale;
	
	/**
	 * Private member variable for CalendarEventTypeFlags.
	 */
	private String[] calendarEventTypes;
	
	/**
	 * Private member variable for DateDefinitionTypeFlags.
	 */
	private String[] dateDefinitionTypes;

	/**
	 * Private member variable for calendarId.
	 */
	private Long calendarId;
	
	/**
	 * Private member variable for LseId.
	 */
	private Long lseId;

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String[] getCalendarEventTypes() {
		return calendarEventTypes;
	}

	public void setCalendarEventTypes(String[] calendarEventTypes) {
		this.calendarEventTypes = calendarEventTypes;
	}

	public String[] getDateDefinitionTypes() {
		return dateDefinitionTypes;
	}

	public void setDateDefinitionTypes(String[] dateDefinitionTypes) {
		this.dateDefinitionTypes = dateDefinitionTypes;
	}

	public Long getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}
	

}
