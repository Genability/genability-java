package com.genability.client.api.service;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

import com.genability.client.api.request.GetIncentiveRequest;
import com.genability.client.api.request.GetIncentivesRequest;
import com.genability.client.types.Incentive;
import com.genability.client.types.Response;

public class IncentiveServiceTests extends BaseServiceTests {

	@Test
	public void testGetIncentive() {
		Long mtid = new Long(3158838L);
		GetIncentiveRequest request = new GetIncentiveRequest();
		request.setMasterTariffId(mtid);
		Response<Incentive> response = incentiveService.getIncentive(request);
		List<Incentive> results = response.getResults();
		Incentive incentive = results.get(0);
		
		assertEquals("Request failed.", Response.STATUS_SUCCESS, response.getStatus());
		assertEquals("Didn't get the right number of results.", response.getCount(), new Integer(1));
		assertEquals("Wrong result type", response.getType(), "Incentive");
		
		assertEquals("Wrong mtid", mtid, incentive.getMasterTariffId());
	}
	
	@Test
	public void testGetIncentives() {
		GetIncentivesRequest request = new GetIncentivesRequest();
		request.setEffectiveOn(DateTime.now());
		Response<Incentive> response = incentiveService.getIncentives(request);
		List<Incentive> results = response.getResults();
		
		assertEquals("Request failed.", Response.STATUS_SUCCESS, response.getStatus());
		assertTrue("Should have lots of results.", response.getCount() > new Integer(0));
		assertEquals("Wrong result type", response.getType(), "Incentive");
		
		for (Incentive result : results) {
			assertNull("Only incentives that haven't ended should be returned", result.getEndDate());
			if (result.getEndDate() != null) {
				assertTrue("Only incentives that haven't ended should be returned", result.getEndDate().compareTo(DateTime.now()) > 0 );
			}
			
			assertFalse("Only non-exhausted incentives should be returned", result.getExhausted());
		}
	}
	
	@Test
	public void testGetInstantIncentives() {
		GetIncentivesRequest request = new GetIncentivesRequest();
		Response<Incentive> response = incentiveService.getInstantIncentives(request);
		List<Incentive> results = response.getResults();
		
		assertEquals("Request failed.", Response.STATUS_SUCCESS, response.getStatus());
		assertTrue("Should have lots of results.", response.getCount() > new Integer(0));
		assertEquals("Wrong result type", response.getType(), "Incentive");
		
		for (Incentive result : results) {
			if (result.getEndDate() != null) {
				assertTrue("Only incentives that haven't ended should be returned", result.getEndDate().compareTo(DateTime.now()) > 0 );
			}
			
			assertFalse("Only non-exhausted incentives should be returned", result.getExhausted());
		}
	}

}
