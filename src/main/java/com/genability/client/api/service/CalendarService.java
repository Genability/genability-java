package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetCalendarDatesRequest;
import com.genability.client.api.request.GetCalendarRequest;
import com.genability.client.api.request.GetCalendarsRequest;
import com.genability.client.types.Calendar;
import com.genability.client.types.CalendarEventDate;
import com.genability.client.types.Response;

public class CalendarService extends BaseService {

	private static final TypeReference<Response<Calendar>> CALENDAR_RESPONSE_TYPEREF = new TypeReference<Response<Calendar>>() {
	};
	private static final TypeReference<Response<CalendarEventDate>> CALENDAR_DATES_RESPONSE_TYPEREF = new TypeReference<Response<CalendarEventDate>>() {
	};

	private static final String CALENDAR_URI = "/public/calendars";

	public Response<Calendar> getCalendar(GetCalendarRequest request) {
		if (log.isDebugEnabled())
			log.debug("getCalendar called");

		String uri = CALENDAR_URI;
		if (request.getCalendarId() != null) {
			uri += "/" + request.getCalendarId();
		}
		Response<Calendar> response = this.callGet(uri, request.getQueryParams(), CALENDAR_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendar completed");

		return response;
	}

	public Response<Calendar> getCalendars(GetCalendarsRequest request) {
		if (log.isDebugEnabled())
			log.debug("getCalendars called");

		Response<Calendar> response = this.callGet(CALENDAR_URI, request.getQueryParams(), CALENDAR_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendars completed");

		return response;
	}

	public Response<CalendarEventDate> getCalendarEventDates(GetCalendarDatesRequest request) {
		
		if (log.isDebugEnabled())
			log.debug("getCalendarEventDates called");
	
		Response<CalendarEventDate> response = this.callGet(CALENDAR_URI + "/dates", request.getQueryParams(), CALENDAR_DATES_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendarEventDates completed");

		return response;
	}

}
