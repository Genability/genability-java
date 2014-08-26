package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
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

    /**
     * private member variable for events.
     */
    private List<CalendarEvent> events;


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

	public String getCalendarName() {
		return calendarName;
	}

	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public List<CalendarEvent> getEvents() {
		return events;
	}

	public void setEvents(List<CalendarEvent> events) {
		this.events = events;
	}

}
