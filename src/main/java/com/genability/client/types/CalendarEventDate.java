package com.genability.client.types;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CalendarEventDate {

	public static final String REST_TYPE = "CalendarDate";


	/**
	 * private member variable for calendarEventId.
	 */
	private Long eventDateId;

	/**
	 * private member variable for subKey.
	 */
	private String subKey;

	/**
	 * private member variable for calendarEventName.
	 */
	private String eventName;

	/**
	 * private member variable for startDateTime.
	 */
	private DateTime startDateTime;

	/**
	 * private member variable for endDateTime.
	 */
	private DateTime endDateTime;

	/**
	 * private member variable for calendarEventId.
	 */
	private Long calendarEventId;
	
	/**
	 * private member variable for lseId.
	 */
	private Long lseId;

	

	public Long getEventDateId() {
		return eventDateId;
	}

	public void setEventDateId(Long eventDateId) {
		this.eventDateId = eventDateId;
	}

	public String getSubKey() {
		return subKey;
	}

	public void setSubKey(String subKey) {
		this.subKey = subKey;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public DateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(DateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public DateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(DateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public Long getCalendarEventId() {
		return calendarEventId;
	}

	public void setCalendarEventId(Long calendarEventId) {
		this.calendarEventId = calendarEventId;
	}

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}
	

}
