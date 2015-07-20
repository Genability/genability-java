package com.genability.client.types;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TimeOfUseTypeTests {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testJsonValue() {
		TimeOfUseType np = TimeOfUseType.ON_PEAK;
		assertEquals("JsonValue method didn't return the right string", "ON_PEAK", np.getName());
	}
	
	@Test
	public void testValidJsonCreator() {
		assertEquals("JsonValue method didn't return the right TimeOfUseType", TimeOfUseType.ON_PEAK, TimeOfUseType.getTouType("ON_PEAK"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidJsonCreator() {
		TimeOfUseType.getTouType("Invalid");
	}
	
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
