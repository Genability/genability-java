package com.genability.client.api.request;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.http.NameValuePair;
import org.junit.Test;

public class GetTariffRequestTests {

	@Test
	public void testTerritoryIdParameter() {
		Long tid = Long.valueOf(125);
		GetTariffRequest request = new GetTariffRequest();
		request.setTerritoryId(tid);
		List<NameValuePair> parameters = request.getQueryParams();
		
		boolean foundTerritoryId = false;
		for(NameValuePair p : parameters) {
			if (p.getName().equals("territoryId")) {
				foundTerritoryId = tid.toString().equals(p.getValue());
			}
		}
		
		assertTrue("Got no/incorrect territoryId", foundTerritoryId);
	}
}
