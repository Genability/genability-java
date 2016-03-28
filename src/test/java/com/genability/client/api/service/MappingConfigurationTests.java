package com.genability.client.api.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genability.client.types.ChargeType;

public class MappingConfigurationTests extends BaseServiceTests {
	
	private static class TestClass {
		private ChargeType chargeType;
		
		@SuppressWarnings("unused")
		public void setChargeType(ChargeType ct) {
			chargeType = ct;
		}
		
		public ChargeType getChargeType() {
			return chargeType;
		}
	}
	
	@Test
	public void objectMapperIgnoresUnknownNullValues() throws Exception {
		String data = "{\"chargeType\":\"INVALID\"}";
		
		ObjectMapper om = accountService.getMapper();
		TestClass tc = om.readValue(data, TestClass.class);
		
		assertEquals(tc.getChargeType(), null);
	}
}
