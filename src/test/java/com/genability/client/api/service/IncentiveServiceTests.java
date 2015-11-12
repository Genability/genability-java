package com.genability.client.api.service;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.genability.client.api.request.GetIncentiveApplicabilitiesRequest;
import com.genability.client.api.request.GetIncentivesRequest;
import com.genability.client.types.CustomerClass;
import com.genability.client.types.Incentive;
import com.genability.client.types.IncentiveApplicability;
import com.genability.client.types.MockHttpClient;
import com.genability.client.types.Response;

public class IncentiveServiceTests extends BaseServiceTests {

	private String baseUrl = incentiveService.getRestApiServer() + "v1/incentives";
	private IncentiveService localService;

	@Before
	public void initializeIncentiveService() {
		localService = new IncentiveService();
		localService.setRestApiServer(territoryService.getRestApiServer());
	}
	
	@Test
	public void testGetOneIncentiveUrl() {
		// Arrange
		long incentiveId = 1234;
		String expectedUrl = String.format("%s%d", baseUrl, incentiveId);
		
		// Expect
		MockHttpClient client = new MockHttpClient(expectedUrl); 
		localService.setHttpClient(client);
		
		// Act
		localService.getIncentive(incentiveId);
		client.validate();
	}
	
	@Test
	public void testGetIncentivesUrl() {
		// Arrange
		String expectedUrl = baseUrl;

		GetIncentivesRequest request = new GetIncentivesRequest();
		request.setLseId(1234L);
		request.setState("CA");
		request.setCustomerClass(CustomerClass.RESIDENTIAL);
		request.setIncentiveType("rebate");
		request.setProjectType("solarPv");
		request.setApplicabilityValue("systemSizeDcW", "100");
		
		// Expect
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("lseId", "1234");
		client.addExpectedParameter("state", "CA");
		client.addExpectedParameter("customerClasses", "RESIDENTIAL");
		client.addExpectedParameter("incentiveType", "rebate");
		client.addExpectedParameter("projectType", "solarPv");
		client.addExpectedParameter("systemSizeDcW", "100");
		localService.setHttpClient(client);
		
		// Act
		localService.getIncentives(request);
		client.validate();
	}
	
	@Test
	public void testGetIncentiveApplicabilitiesUrl() {
		// Arrange
		String expectedUrl = baseUrl;

		GetIncentiveApplicabilitiesRequest request = new GetIncentiveApplicabilitiesRequest();
		request.setLseId(1234L);
		request.setState("CA");
		request.setCustomerClass(CustomerClass.RESIDENTIAL);
		request.setIncentiveType("rebate");
		request.setProjectType("solarPv");

		// Expect
		MockHttpClient client = new MockHttpClient(expectedUrl);
		client.addExpectedParameter("lseId", "1234");
		client.addExpectedParameter("state", "CA");
		client.addExpectedParameter("customerClasses", "RESIDENTIAL");
		client.addExpectedParameter("incentiveType", "rebate");
		client.addExpectedParameter("projectType", "solarPv");
		localService.setHttpClient(client);
		
		// Act
		localService.getIncentiveApplicabilities(request);
		client.validate();
	}
	
	@Test
	public void testGetIncentive() {
		// Arrange
		Long mtid = new Long(3158838L);
		Response<Incentive> response = incentiveService.getIncentive(mtid);
		
		// Act
		List<Incentive> results = response.getResults();
		
		// Assert
		Incentive incentive = results.get(0);
		assertEquals("Request failed.", Response.STATUS_SUCCESS, response.getStatus());
		assertEquals("Didn't get the right number of results.", response.getCount(), new Integer(1));
		assertEquals("Wrong result type", response.getType(), "Incentive");
		assertEquals("Wrong mtid", mtid, incentive.getMasterIncentiveId());
	}
	
	@Test
	public void testGetIncentiveApplicabilities() {
		// Arrange
		GetIncentiveApplicabilitiesRequest request = new GetIncentiveApplicabilitiesRequest();
		request.setState("NY");
		request.setProjectType("solarPv");
		
		// Act
		Response<IncentiveApplicability> response = incentiveService.getIncentiveApplicabilities(request);
		
		// Assert
		assertEquals("Request failed.", Response.STATUS_SUCCESS, response.getStatus());
		assertTrue("Should have lots of results.", response.getCount() > new Integer(0));
		assertEquals("Wrong result type", response.getType(), "IncentiveApplicability");
	}
	
	
	@Test
	public void testGetIncentives() {
		// Arrange
		GetIncentivesRequest request = new GetIncentivesRequest();
		request.setEffectiveOn(DateTime.now());
		request.setState("NY");
		
		// Act
		Response<Incentive> response = incentiveService.getIncentives(request);
		
		// Assert
		List<Incentive> results = response.getResults();
		assertEquals("Request failed.", Response.STATUS_SUCCESS, response.getStatus());
		assertTrue("Should have lots of results.", response.getCount() > new Integer(0));
		assertEquals("Wrong result type", response.getType(), "Incentive");
		
		for (Incentive result : results) {
			assertNull("Only incentives that haven't ended should be returned", result.getEndDate());
			assertEquals("State should match the requested state", result.getState(), "NY");
			if (result.getEndDate() != null) {
				assertTrue("Only incentives that haven't ended should be returned", result.getEndDate().compareTo(DateTime.now()) > 0 );
			}
			
			assertFalse("Only non-exhausted incentives should be returned", result.getIsExhausted());
		}
	}
}
