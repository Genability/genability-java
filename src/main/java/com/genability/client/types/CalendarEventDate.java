package com.genability.client.types;

import java.sql.Date;
import java.sql.Timestamp;


public class CalendarEventDate {

	public static final String REST_TYPE = "CalendarEventDate";
	/**
	 * private member variable for calendarEventDateId.
	 */

	private Long calendarEventDateId;


	/**
	 * private member variable for subkey.
	 */

	private String subKey;


	/**
	 * private member variable for calendarEventDate.
	 */

	private Timestamp calendarEventDate;


	/**
	 * private member variable for calendarEventId.
	 */

	private Long eventDateId;


	/**
	 * private member variable for calendarEventName.
	 */

	private String eventName;


	/**
	 * private member variable for createdDate.
	 */

	private Timestamp startDateTime;

	private Timestamp endDateTime;


	/**
	 * private member variable for createdBy.
	 */

	private Long lseId;


	/**
	 * private member variable for createdBy.
	 */

	private Long createdBy;


	/**
	 * private member variable for createdDate.
	 */

	private Date createdDate;


	/**
	 * private member variable for lastUpdatedBy.
	 */

	private Long lastUpdatedBy;


	/**
	 * private member variable for lastUpdatedDate.
	 */

	private Date lastUpdatedDate;


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


	public Timestamp getCalendarEventDate() {
		return calendarEventDate;
	}


	public void setCalendarEventDate(Timestamp calendarEventDate) {
		this.calendarEventDate = calendarEventDate;
	}


	public Long getCalendarEventId() {
		return eventDateId;
	}


	public void setCalendarEventId(Long calendarEventId) {
		this.eventDateId = calendarEventId;
	}



	public Long getLseId() {
		return lseId;
	}


	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}


	public Long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}


	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}


	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public Timestamp getStartDateTime() {
		return startDateTime;
	}


	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}


	public Timestamp getEndDateTime() {
		return endDateTime;
	}


	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

}
