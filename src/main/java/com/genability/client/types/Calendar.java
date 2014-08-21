package com.genability.client.types;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;



public class Calendar {
	
	public static final String REST_TYPE = "Calendar";
    /**
     * private member variable for CalendarId.
     */
    private Long calendarId;

    /**
     * private member variable for LseId.
     */
    private Long lseId;

    /**
     * private member variable for CalendarName.
     */
    private String calendarName;
    
    private Timestamp startDateTime;
	
	private Timestamp endDateTime;
    
    /**
     * private member variable for events.
     */
    private List<CalendarEvent> events;

    /**
	 * private member variable for calendarEventId.
	 */
	
	private Long eventDateId;
	
	/**
	 * private member variable for subkey.
	 */

	private String subKey;
	
	/**
	 * private member variable for calendarEventName_.
	 */
	
	private String eventName;
    
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

	public Long getCalendarId() {
		return calendarId;
	}

	public void setCalendarId_(Long calendarId_) {
		this.calendarId = calendarId_;
	}

	public Long getLseId() {
		return lseId;
	}

	public void setLseId_(Long lseId_) {
		this.lseId = lseId_;
	}

	public String getCalendarName() {
		return calendarName;
	}

	public void setCalendarName(String calendarName_) {
		this.calendarName = calendarName_;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy_) {
		this.createdBy = createdBy_;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate_) {
		this.createdDate = createdDate_;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy_) {
		this.lastUpdatedBy = lastUpdatedBy_;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate_) {
		this.lastUpdatedDate = lastUpdatedDate_;
	}

	public List<CalendarEvent> getEvents() {
		return events;
	}

	public void setEvents(List<CalendarEvent> events) {
		this.events = events;
	}

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
