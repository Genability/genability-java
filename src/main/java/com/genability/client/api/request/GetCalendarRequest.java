package com.genability.client.api.request;

public class GetCalendarRequest extends AbstractRequest{

	
	/**
	 * Private member variable for CalendarId.
	 */
	private Long calendarId;

	/**
	 * Private member variable for PopulateEvents.
	 */
	private Boolean populateEvents_;

	public Long getCalendarId_() {
		return calendarId;
	}

	public void setCalendarId_(Long calendarId_) {
		this.calendarId = calendarId_;
	}

	public Boolean getPopulateEvents_() {
		return populateEvents_;
	}

	public void setPopulateEvents_(Boolean populateEvents_) {
		this.populateEvents_ = populateEvents_;
	}

	/**
	 * This is the default constructor.
	 */

}
