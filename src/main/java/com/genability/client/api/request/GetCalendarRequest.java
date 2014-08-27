package com.genability.client.api.request;

public class GetCalendarRequest extends AbstractRequest{


	/**
	 * Private member variable for CalendarId.
	 */
	private Long calendarId;

	public Long getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}

}
