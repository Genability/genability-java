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

	private String uri = "/public/calendars";

	public Response<Calendar> getCalendar(GetCalendarRequest request) {
		if (log.isDebugEnabled())
			log.debug("getCalendar called");

		if (request.getCalendarId_() != null) {
			uri += "/" + request.getCalendarId_();
		}
		System.out.println("uri" + uri);
		Response<Calendar> response = this.callGet(uri, request.getQueryParams(), CALENDAR_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendar completed");

		return response;
	}

	public Response<Calendar> getCalendars(GetCalendarsRequest request) {
		if (log.isDebugEnabled())
			log.debug("getCalendars called");

		if (request.getLseId() != null) {
			uri += "/" + request.getLseId();
		}
		Response<Calendar> response = this.callGet(uri, request.getQueryParams(), CALENDAR_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendars completed");

		return response;
	}

	public Response<CalendarEventDate> getCalendarEventDates(GetCalendarDatesRequest request) {
		if (log.isDebugEnabled())
			log.debug("getCalendarEventDates called");
		
			uri += "/dates";
	
		Response<CalendarEventDate> response = this.callGet(uri, request.getQueryParams(), CALENDAR_DATES_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendarEventDates completed");

		return response;
	}

}
