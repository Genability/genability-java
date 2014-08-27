package com.genability.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.genability.client.api.request.GetCalendarDatesRequest;
import com.genability.client.api.request.GetCalendarRequest;
import com.genability.client.api.request.GetCalendarsRequest;
import com.genability.client.types.Calendar;
import com.genability.client.types.CalendarEventDate;
import com.genability.client.types.Response;

public class CalendarServiceTests extends BaseServiceTests {
	
	
	private static CalendarService calendarService = genabilityClient.getCalendarService();
	
	
	@Test
	public void testGetCalendar() {
		
		//
		// Assign
		//
		GetCalendarRequest request = new GetCalendarRequest();
		request.setCalendarId((long) 2);

		//
		// Act
		//
		Response<Calendar> restResponse = calendarService.getCalendar(request);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Calendar.REST_TYPE);

	}
	
	@Test
	public void testGetCalendars() {
		
		//
		// Assign
		//
		GetCalendarsRequest request = new GetCalendarsRequest();
		request.setLseId(new Long(734));//Pacific Gas & Electric
		
		//
		// Act
		//
		Response<Calendar> restResponse = calendarService.getCalendars(request);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),Calendar.REST_TYPE);

	}

	@Test
	public void testGetCalendarDates() {
		
		//
		// Assign
		//
		GetCalendarDatesRequest request = new GetCalendarDatesRequest();
		request.setLseId(new Long(734));//Pacific Gas & Electric

		//
		// Act
		//
		Response<CalendarEventDate> restResponse = calendarService.getCalendarEventDates(request);
		
		//
		// Assert
		//
		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status",restResponse.getStatus(),Response.STATUS_SUCCESS);
		assertEquals("bad type",restResponse.getType(),CalendarEventDate.REST_TYPE);

	}
}
