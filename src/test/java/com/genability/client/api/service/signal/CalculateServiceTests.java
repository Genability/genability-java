package com.genability.client.api.service.signal;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.hamcrest.core.Is.is;

import com.genability.client.api.request.signal.GetCalculatedCostRequest;
import com.genability.client.api.request.signal.GetMassCalculatedCostRequest;
import com.genability.client.api.request.signal.util.CondensedInput;
import com.genability.client.api.service.BaseServiceTests;
import com.genability.client.types.DetailLevel;
import com.genability.client.types.GroupBy;
import com.genability.client.types.PropertyData;
import com.genability.client.types.Response;
import com.genability.client.types.signal.CalculatedCost;
import com.genability.client.types.signal.MassCalculation;
import com.genability.client.types.signal.Scenario;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class CalculateServiceTests extends BaseServiceTests {

    private static CalculateService calculateService = genabilityClient.getSignalCalculateService();

    private static final BigDecimal CURRENCY_EPSILON = BigDecimal.valueOf(0.001);
    private static final BigDecimal USAGE_EPSILON = BigDecimal.valueOf(0.01);

    @Test
    public void testResultsMatchCondensedNonCondensed() {
        // Based on Genability internal regression test 22.17
        DateTime fromDateTime = new DateTime("2016-04-01T00:00:00.000-00:00");
        DateTime toDateTime = new DateTime("2016-04-02T00:00:00.000-00:00");
        DateTime usageFromTime = new DateTime("2016-04-01T00:00:00-04:00");

        List<BigDecimal> usage = asBigDecimal(Arrays.asList(
                63.0, 63.0, 63.0, 63.0, 63.4, 63.8, 64.3, 64.9, 65.1, 65.2,
                65.4, 65.4, 66.2, 67.2, 68.1, 69.2, 69.9, 70.5, 71.2, 71.8,
                72.0, 72.3, 72.3, 72.5, 73.5, 75.0, 76.5, 78.0, 78.8, 79.3,
                79.9, 80.3, 80.8, 81.1, 81.5, 81.9, 82.3, 82.6, 83.0, 83.4,
                83.8, 84.4, 84.8, 85.3, 85.1, 84.5, 83.8, 83.2, 82.6, 82.0,
                81.3, 80.7, 80.4, 80.4, 80.4, 80.4, 80.7, 80.9, 81.2, 81.4,
                80.7, 79.4, 78.2, 76.9, 76.1, 75.7, 75.2, 74.6, 74.1, 73.2,
                72.6, 71.7, 70.7, 69.4, 68.2, 66.9, 66.0, 65.3, 64.5, 63.8,
                63.0, 62.1, 61.2, 60.3, 60.2, 60.4, 60.7, 60.9, 61.5, 62.3,
                63.0, 63.8, 63.9, 63.6, 63.3, 63.1, 63.2, 63.4, 63.7, 63.9,
                64.5, 65.3, 66.0, 66.8, 66.9, 66.9, 66.9, 66.9, 67.7, 68.7,
                69.6
        ));

        GetCalculatedCostRequest requestCondensed = new GetCalculatedCostRequest();
        requestCondensed.setFromDateTime(fromDateTime);
        requestCondensed.setToDateTime(toDateTime);
        requestCondensed.setMasterTariffId(522L);
        requestCondensed.addPropertyInput(CondensedInput.create(usageFromTime, usage, 900000L));

        Response<CalculatedCost> response = calculateService.getCalculatedCost(requestCondensed);

        assertThat(response.getStatus(), equalTo("success"));
        assertThat(response.getCount(), equalTo(1));
        assertThat(response.getType(), equalTo("CalculatedCost"));
        assertThat(response.getRequestId(), notNullValue());
        assertThat(response.getResults().size(), equalTo(1));
        assertThat(response.getResults().get(0).getMasterTariffId(), equalTo(522L));
        assertThat(response.getResults().get(0).getTotalCost(),
                is(closeTo(BigDecimal.valueOf(2169.62), CURRENCY_EPSILON)));
        assertThat(BigDecimal.valueOf((Double)response.getResults().get(0).getSummary().get("kWh")),
                is(closeTo(BigDecimal.valueOf(5981.1), USAGE_EPSILON)));

        GetCalculatedCostRequest requestNonCondensed = new GetCalculatedCostRequest();
        requestNonCondensed.setFromDateTime(fromDateTime);
        requestNonCondensed.setToDateTime(toDateTime);
        requestNonCondensed.setMasterTariffId(522L);

        DateTime nextFromTime = usageFromTime;
        for (BigDecimal d : usage) {
            DateTime nextToTime = nextFromTime.plusMinutes(15);

            PropertyData pd = new PropertyData();
            pd.setFromDateTime(nextFromTime);
            pd.setToDateTime(nextToTime);
            pd.setKeyName("consumption");
            pd.setDataValue(d.toPlainString());

            requestNonCondensed.addPropertyInput(pd);

            nextFromTime = nextToTime;
        }

        response = calculateService.getCalculatedCost(requestNonCondensed);

        assertThat(response.getStatus(), equalTo("success"));
        assertThat(response.getCount(), equalTo(1));
        assertThat(response.getType(), equalTo("CalculatedCost"));
        assertThat(response.getRequestId(), notNullValue());
        assertThat(response.getResults().size(), equalTo(1));
        assertThat(response.getResults().get(0).getMasterTariffId(), equalTo(522L));
        assertThat(response.getResults().get(0).getTotalCost(),
                is(closeTo(BigDecimal.valueOf(2169.62), CURRENCY_EPSILON)));
        assertThat(BigDecimal.valueOf((Double)response.getResults().get(0).getSummary().get("kWh")),
                is(closeTo(BigDecimal.valueOf(5981.1), USAGE_EPSILON)));
    }

    @Test
    public void testMassCalculation() {
        // Based on Genability internal regression test for Signal APIs
        GetMassCalculatedCostRequest request = new GetMassCalculatedCostRequest();
        request.setFromDateTime(new DateTime("2016-07-13T00:00:00-07:00"));
        request.setToDateTime(new DateTime("2016-08-11T00:00:00-07:00"));
        request.setGroupBy(GroupBy.MONTH);
        request.setDetailLevel(DetailLevel.CHARGE_TYPE);
        request.setBillingPeriod(true);

        Scenario scenario = new Scenario();
        scenario.setScenarioName("E-1");
        scenario.setMasterTariffId(522L);
        request.addScenario(scenario);

        scenario = new Scenario();
        scenario.setScenarioName("E-6-TOU");
        scenario.setMasterTariffId(525L);
        request.addScenario(scenario);

        scenario = new Scenario();
        scenario.setScenarioName("E-6-TOU-SmartRate");
        scenario.setMasterTariffId(525L);
        PropertyData propertyData = new PropertyData();
        propertyData.setKeyName("isSmartRateCustomer");
        propertyData.setDataValue(true);
        scenario.addPropertyInput(propertyData);
        request.addScenario(scenario);

        scenario = new Scenario();
        propertyData = new PropertyData();
        propertyData.setKeyName("consumption");
        propertyData.setDataValue(1000.0);
        scenario.addPropertyInput(propertyData);
        request.setSharedScenario(scenario);

        Response<MassCalculation> response = calculateService.getMassCalculatedCost(request);

        assertThat(response.getStatus(), equalTo("success"));
        assertThat(response.getCount(), equalTo(1));
        assertThat(response.getType(), equalTo("MassCalculation"));
        MassCalculation result = response.getResults().get(0);
        Map<String, CalculatedCost> scenarios = result.getScenarios();
        assertThat(scenarios.size(), equalTo(3));
        assertThat(scenarios.containsKey("E-1"), is(true));
        assertThat(scenarios.containsKey("E-6-TOU"), is(true));
        assertThat(scenarios.containsKey("E-6-TOU-SmartRate"), is(true));
    }

    private static List<BigDecimal> asBigDecimal(List<Double> values) {
        List<BigDecimal> valuesBigDecimal = new ArrayList<BigDecimal>();

        for (double v : values) {
            valuesBigDecimal.add(BigDecimal.valueOf(v));
        }

        return valuesBigDecimal;

    }

}
