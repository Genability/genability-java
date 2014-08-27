package com.genability.client.api.service;

import com.genability.client.api.request.BaselineRequest;
import com.genability.client.types.CustomerClass;
import com.genability.client.types.Response;
import com.genability.client.types.ServiceType;
import com.genability.client.types.Baseline;

import java.math.BigDecimal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TypicalServiceTests extends BaseServiceTests {

	private static TypicalService typicalService = genabilityClient.getTypicalService();

	@Test
	public void testGetBestBaselineByAddress() {
		final String addressString = "438 Juniper Ct, Sunnyvale, CA 94086";
		final Long buildingArea = 2000L;
		BigDecimal expectedBuildingArea = new BigDecimal(buildingArea);

		final BaselineRequest baselineRequest = new BaselineRequest();
		baselineRequest.setAddressString(addressString);
		baselineRequest.setBuildingArea(buildingArea);
		baselineRequest.setCustomerClass(CustomerClass.RESIDENTIAL);
		baselineRequest.setBuildingType("RESIDENTIAL");
		baselineRequest.setGroupBy("MONTH");

		final Baseline answer = callGetBestBaseline(baselineRequest);
		assertTrue("buildingArea not respected",
			answer.getFactors().get("buildingArea").compareTo(expectedBuildingArea) == 0);
	}

	@Test
	public void testGetBestBaselineByZipCode() {
		final String zipCode = "94086";
		final Long buildingArea = 2000L;
		BigDecimal expectedBuildingArea = new BigDecimal(buildingArea);

		final BaselineRequest baselineRequest = new BaselineRequest();
		baselineRequest.setZipCode(zipCode);
		baselineRequest.setBuildingArea(buildingArea);
		baselineRequest.setCustomerClass(CustomerClass.RESIDENTIAL);
		baselineRequest.setBuildingType("RESIDENTIAL");
		baselineRequest.setGroupBy("MONTH");

		final Baseline answer = callGetBestBaseline(baselineRequest);
		assertTrue("buildingArea not respected",
			answer.getFactors().get("buildingArea").compareTo(expectedBuildingArea) == 0);
	}

	public final Baseline callGetBestBaseline(final BaselineRequest baselineRequest) {
		final Response<Baseline> restResponse = typicalService.getBestBaseline(baselineRequest);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", restResponse.getStatus(), Response.STATUS_SUCCESS);
		assertEquals("bad type", restResponse.getType(), Baseline.REST_TYPE);
		assertTrue("bad count", restResponse.getCount() > 0);

		final Baseline typicalBaseline = restResponse.getResults().get(0);

		assertNotNull("baselineId null", typicalBaseline.getBaselineId());
		assertNotNull("buildingType null", typicalBaseline.getBuildingType());
		assertNotNull("climateZone null", typicalBaseline.getClimateZone());
		assertNotNull("factors null", typicalBaseline.getFactors());
		assertNotNull("meanBuildingArea null", typicalBaseline.getFactors().get("meanBuildingArea"));
		assertNotNull("measureUnit null", typicalBaseline.getMeasureUnit());
		assertNotNull("measureValue null", typicalBaseline.getMeasureValue());
		assertNotNull("measures null", typicalBaseline.getMeasures());
		assertNotNull("properties null", typicalBaseline.getProperties());

		assertEquals("serviceType not ELECTRICITY", ServiceType.ELECTRICITY, typicalBaseline.getServiceType());
		assertEquals("customerClass not RESIDENTIAL", CustomerClass.RESIDENTIAL, typicalBaseline.getBuildingType().getCustomerClass());

		return typicalBaseline;
	}
}
