package com.genability.client.api.request;

public class GetCalendarRequest extends AbstractRequest{


	/**
	 * Private member variable for CalendarId.
	 */
	private Long calendarId;

	/**
	 * Private member variable for PopulateEvents.
	 */
	private Boolean populateEvents;

	public Long getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}

	public Boolean getPopulateEvents() {
		return populateEvents;
	}

	public void setPopulateEvents(Boolean populateEvents) {
		this.populateEvents = populateEvents;
	}

	/**
	 * This is the default constructor.
	 */

}
