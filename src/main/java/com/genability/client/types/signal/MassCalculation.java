package com.genability.client.types.signal;


import org.joda.time.DateTime;

import java.util.Map;


public class MassCalculation {

    public static final String REST_TYPE = "MassCalculation";

    private DateTime fromDateTime;
    private DateTime toDateTime;
    private Map<String, CalculatedCost> scenarios;


    public DateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(DateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public DateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(DateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public Map<String, CalculatedCost> getScenarios() {
        return scenarios;
    }

    public void setScenarios(Map<String, CalculatedCost> scenarios) {
        this.scenarios = scenarios;
    }
}
