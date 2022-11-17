package com.genability.client.api.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.genability.client.api.request.GetTimeOfUseGroupsRequest;
import com.genability.client.api.request.GetTimeOfUseIntervalsRequest;
import com.genability.client.types.MockHttpClient;
import com.genability.client.types.Response;
import com.genability.client.types.TimeOfUse;
import com.genability.client.types.TimeOfUseGroup;
import com.genability.client.types.TimeOfUseInterval;
import com.genability.client.types.TimeOfUsePeriod;
import com.genability.client.types.TimeOfUseType;

public class TimeOfUseServiceTests extends BaseServiceTests {
	
	private TimeOfUseService localService;
	private String publicBaseUrl = touService.getRestApiServer() + "public/timeofuses";
	private String privateBaseUrl = touService.getRestApiServer() + "timeofuses";
	
	@Before
	public void setUp() {
		localService = new TimeOfUseService();
		localService.setRestApiServer(touService.getRestApiServer());
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
			assertNotNull("Time of Use Type mapped incorrectly", i.getTouType());
		}
	}
	
	@Test
	public void addPrivateTouGroupUsesTheCorrectURL() {
		// Arrange
		MockHttpClient client = new MockHttpClient(privateBaseUrl);
		
		// Expect
		localService.setHttpClient(client);
		
		// Act
		localService.addPrivateTimeOfUseGroup(null);
		client.validate();
	}
	
	@Test
	public void addPrivateTouGroupWorksCorrectly() {
		TimeOfUseGroup grp = getValidTouGroup();
		
		Response<TimeOfUseGroup> response = touService.addPrivateTimeOfUseGroup(grp);
		assertEquals("Didn't successfully add the private TOU", Response.STATUS_SUCCESS, response.getStatus());
		
		cleanUpPrivateTou(response.getResults().get(0));
	}
	
	
	@Test
	public void updatePrivateTouGroupUsesTheCorrectUrl() {
		MockHttpClient client = new MockHttpClient(privateBaseUrl);
		localService.setHttpClient(client);
		localService.updatePrivateTimeOfUseGroup(null);
		
		client.validate();
	}
	
	@Test
	public void updatePrivateTouGroupWorksCorrectly() {
		TimeOfUseGroup grp = getValidTouGroup();
		
		Response<TimeOfUseGroup> addResponse = touService.addPrivateTimeOfUseGroup(grp);
		TimeOfUseGroup addedGrp = addResponse.getResults().get(0);
		addedGrp.getTimeOfUses().get(0).setTouName("JAVA CLIENT LIB UPDATE");
		Response<TimeOfUseGroup> updateResponse = touService.updatePrivateTimeOfUseGroup(addedGrp);
		assertEquals("Didn't successfully add the private TOU", Response.STATUS_SUCCESS, updateResponse.getStatus());
		
		cleanUpPrivateTou(updateResponse.getResults().get(0));
	}
	
	@Test
	public void deletePrivateTouGroupUsesTheCorrectUrl() {
		long lseId = 734L;
		long touGroupId = 1L;
		
		String url = String.format("%s/%d/%d", privateBaseUrl, lseId, touGroupId);
		MockHttpClient client = new MockHttpClient(url);
		localService.setHttpClient(client);
		localService.deletePrivateTimeOfUseGroup(lseId, touGroupId);
		
		client.validate();
	}
	
	@Test
	public void deletePrivateTouGroupWorksCorrectly() {
		// Arrange
		TimeOfUseGroup grp = getValidTouGroup();
		
		// Act
		Response<TimeOfUseGroup> response = touService.addPrivateTimeOfUseGroup(grp);
		TimeOfUseGroup added = response.getResults().get(0);
		cleanUpPrivateTou(added);
		
		// Assert
		try {
			touService.getTimeOfUseGroup(added.getLseId(), added.getTouGroupId());
		} catch (GenabilityException e) {
			String message = "Trying to get a deleted TOU group should result in a 404";
			assertEquals(message, "Failed GET " + publicBaseUrl + "/" + added.getLseId() + "/" + added.getTouGroupId() + "?fields=ext: HTTP error code : 404", e.getMessage());
		}
	}

	private void cleanUpPrivateTou(TimeOfUseGroup grp) {
		touService.deletePrivateTimeOfUseGroup(grp.getLseId(), grp.getTouGroupId());
	}
	
	/**		
	 * Returns a valid TOU group (one that covers every hour in the week and every		
	 * day of the year		
	 */		
	private TimeOfUseGroup getValidTouGroup() {		
		TimeOfUseGroup group = new TimeOfUseGroup();		
		group.setTimeOfUses(new ArrayList<TimeOfUse>());		
		group.setLseId(734L);		

		TimeOfUse tou = new TimeOfUse();
		tou.setTouName("JAVA CLIENT LIB TOU");
		tou.setTouPeriods(new ArrayList<TimeOfUsePeriod>());		
		tou.setTouType(String.valueOf(TimeOfUseType.OFF_PEAK));		
		group.getTimeOfUses().add(tou);		

		TimeOfUsePeriod period = new TimeOfUsePeriod();		
		period.setFromDayOfWeek(0);		
		period.setToDayOfWeek(6);		
		period.setFromHour(0);		
		period.setToHour(0);		
		period.setFromMinute(0);		
		period.setToMinute(0);		
		tou.getTouPeriods().add(period);		

		return group;		
	}
}
