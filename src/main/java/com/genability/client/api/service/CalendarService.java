package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetCalendarDatesRequest;
import com.genability.client.api.request.GetCalendarRequest;
import com.genability.client.api.request.GetCalendarsRequest;
import com.genability.client.types.Calendar;
import com.genability.client.types.CalendarEventDate;
import com.genability.client.types.PagedList;
import com.genability.client.types.Response;

import java.util.List;

public class CalendarService extends BaseService {

	private static final TypeReference<Response<PagedList<Calendar>>> CALENDAR_RESPONSE_TYPEREF = new TypeReference<Response<PagedList<Calendar>>>() {
	};
	private static final TypeReference<Response<PagedList<CalendarEventDate>>> CALENDAR_DATES_RESPONSE_TYPEREF = new TypeReference<Response<PagedList<CalendarEventDate>>>() {
	};

	private static final String CALENDAR_URI = "/public/calendars";

	public Response<PagedList<Calendar>> getCalendar(GetCalendarRequest request) {
		if (log.isDebugEnabled())
			log.debug("getCalendar called");

		String uri = CALENDAR_URI;
		if (request.getCalendarId() != null) {
			uri += "/" + request.getCalendarId();
		}
		Response<PagedList<Calendar>> response = this.callGet(uri, request.getQueryParams(), CALENDAR_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendar completed");

		return response;
	}

	public Response<PagedList<Calendar>> getCalendars(GetCalendarsRequest request) {
		if (log.isDebugEnabled())
			log.debug("getCalendars called");

		Response<PagedList<Calendar>> response = this.callGet(CALENDAR_URI, request.getQueryParams(), CALENDAR_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendars completed");

		return response;
	}

	public Response<PagedList<CalendarEventDate>> getCalendarEventDates(GetCalendarDatesRequest request) {

		if (log.isDebugEnabled())
			log.debug("getCalendarEventDates called");

		Response<PagedList<CalendarEventDate>> response = this.callGet(CALENDAR_URI + "/dates", request.getQueryParams(), CALENDAR_DATES_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getCalendarEventDates completed");

		return response;
	}

}
