package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.genability.client.api.request.GetCalendarDatesRequest;
import com.genability.client.api.request.GetCalendarRequest;
import com.genability.client.api.request.GetCalendarsRequest;
import com.genability.client.types.Calendar;
import com.genability.client.types.CalendarEventDate;
import com.genability.client.types.PropertyKey;
import com.genability.client.types.Response;

public class CalendarServiceTest extends BaseServiceTests{
	private static CalendarService calendarService = genabilityClient.getCalendarService();
	
	
	@Test
	public void testGetCalendar() {
		
		GetCalendarRequest request = new GetCalendarRequest();
		request.setCalendarId((long) 2);

		Response<Calendar> restResponse = calendarService.getCalendar(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Calendar.REST_TYPE);

	}
	
	
	@Test
	public void testGetCalendars() {
		
		GetCalendarsRequest request = new GetCalendarsRequest();
		Response<Calendar> restResponse = calendarService.getCalendars(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Calendar.REST_TYPE);

	}
	//"/public/calendars/dates
	@Test
	public void testGetCalendarDates() {
		
		GetCalendarDatesRequest request = new GetCalendarDatesRequest();
		//request.setCalendarId_("");

		Response<CalendarEventDate> restResponse = calendarService.getCalendarEventDates(request);
		
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
	//	assertEquals("bad type",restResponse.getType(),Calendar.REST_TYPE);

	}
}
