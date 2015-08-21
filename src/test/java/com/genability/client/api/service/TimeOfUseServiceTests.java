package com.genability.client.api.service;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.genability.client.api.request.GetTimeOfUseGroupsRequest;
import com.genability.client.api.request.GetTimeOfUseIntervalsRequest;
import com.genability.client.types.MockHttpClient;
import com.genability.client.types.Response;
import com.genability.client.types.TimeOfUseGroup;
import com.genability.client.types.TimeOfUseInterval;

public class TimeOfUseServiceTests extends BaseServiceTests {
	
	private TimeOfUseService localService;
	private String publicBaseUrl = touService.getRestApiServer() + "public/timeofuses";
	private String privateBaseUrl = touService.getRestApiServer() + "timeofuses";
	
	@Before
	public void setUp() {
		localService = new TimeOfUseService();
	}
	
	@Test
	public void testGetTouGroupUrl() {
		long lseId = 734L;
		long touGroupId = 1L;
		String expectedUrl = String.format("%s/%d/%d", publicBaseUrl, lseId, touGroupId);
		
		MockHttpClient client = new MockHttpClient(expectedUrl);
		localService.setHttpClient(client);
		localService.getTimeOfUseGroup(lseId, touGroupId);
		
		client.validate();
	}
	
	@Test
	public void testGetTouGroup() {
		long lseId = 734L;
		long touGroupId = 1L;
		
		Response<TimeOfUseGroup> response = touService.getTimeOfUseGroup(lseId, touGroupId);
		
		assertEquals("Didn't successfully get a response from getTimeOfUseGroup", Response.STATUS_SUCCESS, response.getStatus());
		assertEquals("Didn't get exactly one result", 1, response.getResults().size());
		assertEquals("Didn't get the correct touGroup", Long.valueOf(touGroupId), response.getResults().get(0).getTouGroupId());
		assertEquals("Didn't get the correct lseId", Long.valueOf(lseId), response.getResults().get(0).getLseId());
	}
	
	@Test
	public void testGetTouGroupsParameters() {
		Long lseId = Long.valueOf(734);
		String expectedUrl = publicBaseUrl;
		
		GetTimeOfUseGroupsRequest request = new GetTimeOfUseGroupsRequest();
		request.setLseId(lseId);
		
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("lseId", lseId.toString());
		localService.setHttpClient(client);
		
		localService.getTimeOfUseGroups(request);
		
		client.validate();
	}
	
	@Test
	public void testGetTouGroups() {
		Long lseId = Long.valueOf(734);
		
		GetTimeOfUseGroupsRequest request = new GetTimeOfUseGroupsRequest();
		request.setLseId(lseId);
		
		Response<TimeOfUseGroup> response = touService.getTimeOfUseGroups(request);
		
		assertEquals("Didn't successfully get a response from getTimeOfUseGroups", Response.STATUS_SUCCESS, response.getStatus());
		assertTrue("Didn't get more than one result", response.getResults().size() > 1);
		assertEquals("Didn't get the correct lseId", Long.valueOf(lseId), response.getResults().get(0).getLseId());
	}
	
	@Test
	public void testGetTouIntervalsUrl() {
		long lseId = 734L;
		long touGroupId = 1L;
		DateTime fromDateTime = new DateTime(2015, 1, 1, 0, 0);
		DateTime toDateTime = new DateTime(2015, 2, 1, 0, 0);
		String expectedUrl = String.format("%s/%d/%d/intervals", publicBaseUrl, lseId, touGroupId);
		
		GetTimeOfUseIntervalsRequest request = new GetTimeOfUseIntervalsRequest();
		request.setFromDateTime(fromDateTime);
		request.setToDateTime(toDateTime);
		
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("fromDateTime", fromDateTime.toString());
		client.addExpectedParameter("toDateTime", toDateTime.toString());
		
		localService.setHttpClient(client);
		localService.getTimeOfUseIntervals(lseId, touGroupId, request);
		
		client.validate();
	}
	
	@Test
	public void testGetTouIntervals() {
		long lseId = 734L;
		long touGroupId = 1L;
		DateTime fromDateTime = new DateTime(2015, 1, 1, 0, 0);
		DateTime toDateTime = new DateTime(2015, 1, 4, 0, 0);
		
		GetTimeOfUseIntervalsRequest request = new GetTimeOfUseIntervalsRequest();
		request.setFromDateTime(fromDateTime);
		request.setToDateTime(toDateTime);
		
		Response<TimeOfUseInterval> response = touService.getTimeOfUseIntervals(lseId, touGroupId, request);
		
		assertEquals("Didn't successfully get a response from getTimeOfUseIntervals", Response.STATUS_SUCCESS, response.getStatus());
		assertTrue("Didn't get more than one result", response.getResults().size() > 1);
		
		for (TimeOfUseInterval i : response.getResults()) {
			assertEquals("Didn't get the correct TOU group", Long.valueOf(touGroupId), i.getTouGroupId());
			assertTrue("Interval is not in the correct time period", i.getFromDateTime().compareTo(fromDateTime) >= 0);
			assertTrue("Interval is not in the correct time period", i.getToDateTime().compareTo(toDateTime) <= 0);
		}
	}
	
	@Test
	public void addPrivateTouGroupUsesTheCorrectURL() {
		MockHttpClient client = new MockHttpClient(privateBaseUrl);
		localService.setHttpClient(client);
		localService.addPrivateTimeOfUseGroup(null);
		
		client.validate();
	}
	
	
	@Test
	public void updatePrivateTouGroupUsesTheCorrectUrl() {
		MockHttpClient client = new MockHttpClient(privateBaseUrl);
		localService.setHttpClient(client);
		localService.updatePrivateTimeOfUseGroup(null);
		
		client.validate();
	}
	
		@Test
	public void deletePrivateTouGroupUsesTheCorrectUrl() {
		long lseId = 734L;
		long touGroupId = 1L;
		
		String url = String.format("%s/%d/%d", privateBaseUrl, lseId, touGroupId);
		MockHttpClient client = new MockHttpClient(privateBaseUrl);
		localService.setHttpClient(client);
		localService.addPrivateTimeOfUseGroup(null);
		
		client.validate();
	}
}
