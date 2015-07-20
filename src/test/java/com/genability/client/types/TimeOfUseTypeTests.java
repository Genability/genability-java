package com.genability.client.types;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TimeOfUseTypeTests {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testTouTypeSerialize() throws JsonProcessingException {
		TimeOfUseType np = TimeOfUseType.ON_PEAK;
		assertEquals("Serialized TimeOfUseType to the wrong format", "\"ON_PEAK\"", mapper.writeValueAsString(np));
	}
	
	@Test
	public void testValidJsonDeserialize() throws JsonProcessingException, IOException {
		String input = "\"ON_PEAK\"";
		assertEquals("Deserialized TimeOfUseType to the wrong format", TimeOfUseType.ON_PEAK, mapper.readValue(input, TimeOfUseType.class));
	}
	
	@Test(expected=JsonProcessingException.class)
	public void testInvalidJsonDeserialize() throws IOException {
		mapper.readValue("Invalid", TimeOfUseType.class);	
	}
}
