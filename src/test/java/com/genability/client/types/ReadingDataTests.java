package com.genability.client.types;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingDataTests {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testSerializeTouType() throws JsonProcessingException {
		String target = "{\"touType\":\"ON_PEAK\"}";
		ReadingData rd = new ReadingData();
		rd.setTouType(TimeOfUseType.ON_PEAK);
		
		assertEquals("Didn't correctly serialize touType field", target, mapper.writeValueAsString(rd));
	}
}
