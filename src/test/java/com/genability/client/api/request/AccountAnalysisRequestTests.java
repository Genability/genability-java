package com.genability.client.api.request;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class AccountAnalysisRequestTests {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void registerJodaModule() {
		mapper.registerModule(new JodaModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    mapper.setSerializationInclusion(Include.NON_NULL);
	}
	
	
	@Test
	public void testFromDateNoTimezone() throws JsonProcessingException {
		AccountAnalysisRequest request = new AccountAnalysisRequest();
		request.setFromDateTime(2015, 1, 1);
		String target = "{\"fields\":\"ext\",\"fromDateTime\":\"2015-01-01\"}";
		
		assertEquals("Didn't serialize fromDateTime correctly with just a date", target, mapper.writeValueAsString(request));
	}
	
	@Test
	public void testToDateNoTimezone() throws JsonProcessingException {
		AccountAnalysisRequest request = new AccountAnalysisRequest();
		request.setToDateTime(2015, 1, 1);
		String target = "{\"fields\":\"ext\",\"toDateTime\":\"2015-01-01\"}";
		
		assertEquals("Didn't serialize toDateTime correctly with just a date", target, mapper.writeValueAsString(request));
	}
	
	@Test
	public void testFromLocalDate() throws JsonProcessingException {
		AccountAnalysisRequest request = new AccountAnalysisRequest();
		request.setFromDateTime(new LocalDate(2015, 1, 1));
		String target = "{\"fields\":\"ext\",\"fromDateTime\":\"2015-01-01\"}";
		
		assertEquals("Didn't serialize fromDateTime correctly with just a date", target, mapper.writeValueAsString(request));
	}
	
	@Test
	public void testToLocalDate() throws JsonProcessingException {
		AccountAnalysisRequest request = new AccountAnalysisRequest();
		request.setToDateTime(new LocalDate(2015, 1, 1));
		String target = "{\"fields\":\"ext\",\"toDateTime\":\"2015-01-01\"}";
		
		assertEquals("Didn't serialize toDateTime correctly with just a date", target, mapper.writeValueAsString(request));
	}
	
	@Test
	public void testFromDateWithTimezone() throws JsonProcessingException {
		AccountAnalysisRequest request = new AccountAnalysisRequest();
		request.setFromDateTime(new DateTime(2015, 1, 1, 0, 0, 0, DateTimeZone.forID("US/Pacific")));
		String target = "{\"fields\":\"ext\",\"fromDateTime\":\"2015-01-01T00:00:00.000-08:00\"}";
		
		assertEquals("Didn't serialize fromDateTime correctly with a datetime", target, mapper.writeValueAsString(request));
	}
	
	@Test
	public void testToDateWithTimezone() throws JsonProcessingException {
		AccountAnalysisRequest request = new AccountAnalysisRequest();
		request.setToDateTime(new DateTime(2015, 1, 1, 0, 0, 0, DateTimeZone.forID("US/Pacific")));
		String target = "{\"fields\":\"ext\",\"toDateTime\":\"2015-01-01T00:00:00.000-08:00\"}";
		
		assertEquals("Didn't serialize toDateTime correctly with a datetime", target, mapper.writeValueAsString(request));
	}
}
