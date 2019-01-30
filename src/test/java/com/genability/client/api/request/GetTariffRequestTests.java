package com.genability.client.api.request;

import static org.junit.Assert.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.genability.client.util.JodaDateJsonSerializer;
import org.apache.http.NameValuePair;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;

public class GetTariffRequestTests {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void registerJodaModule() {
		mapper.registerModule(new JodaModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		SimpleModule module = new SimpleModule();
		module.addSerializer(DateTime.class, new JodaDateJsonSerializer());
		mapper.registerModule(module);
	}

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
	
	@Test
	public void testToDateWithTimezone() throws JsonProcessingException {
		GetTariffRequest request = new GetTariffRequest();
		request.setEffectiveOn(new DateTime(2015, 1, 1, 0, 0, 0, DateTimeZone.forID("US/Pacific")));
		String target = "{\"fields\":\"ext\",\"effectiveOn\":\"2015-01-01T00:00:00-08:00\"}";
		assertEquals("Didn't serialize toDateTime correctly with a datetime", target, mapper.writeValueAsString(request));
	}
}
