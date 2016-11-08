package com.genability.client.types.signal;


import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genability.client.types.PropertyData;
import com.genability.client.types.TariffRate;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scenario {

    private Long masterTariffId;
    private String scenarioName;
    private List<PropertyData> propertyInputs;
    private List<TariffRate> rateInputs;
    private Boolean calcNetExcessGeneration;
    private Map<String, Object> expected;


    public Long getMasterTariffId() {
        return masterTariffId;
    }

    public void setMasterTariffId(Long masterTariffId) {
        this.masterTariffId = masterTariffId;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public List<PropertyData> getPropertyInputs() {
        return propertyInputs;
    }

    public void setPropertyInputs(List<PropertyData> propertyInputs) {
        this.propertyInputs = propertyInputs;
    }

    public void addPropertyInput(PropertyData propertyInput) {
        if (propertyInputs == null) {
            propertyInputs = new ArrayList<PropertyData>();
        }

        propertyInputs.add(propertyInput);
    }

    public void addPropertyInputs(Collection<PropertyData> propertyInputs) {
        if (this.propertyInputs == null) {
            this.propertyInputs = new ArrayList<PropertyData>();
        }

        this.propertyInputs.addAll(propertyInputs);
    }

    public List<TariffRate> getRateInputs() {
        return rateInputs;
    }

    public void setRateInputs(List<TariffRate> rateInputs) {
        this.rateInputs = rateInputs;
    }

    public void addRateInput(TariffRate rateInput) {
        if (rateInputs == null) {
            rateInputs = new ArrayList<TariffRate>();
        }

        rateInputs.add(rateInput);
    }

    public void addRateInputs(Collection<TariffRate> rateInputs) {
        if (this.rateInputs == null) {
            this.rateInputs = new ArrayList<TariffRate>();
        }

        this.rateInputs.addAll(rateInputs);
    }

    public Boolean getCalcNetExcessGeneration() {
        return calcNetExcessGeneration;
    }

    public void setCalcNetExcessGeneration(Boolean calcNetExcessGeneration) {
        this.calcNetExcessGeneration = calcNetExcessGeneration;
    }

    public Map<String, Object> getExpected() {
        return expected;
    }

    public void setExpected(Map<String, Object> expected) {
        this.expected = expected;
    }

    public void addExpected(String key, Object value) {
        if (expected == null) {
            expected = new HashMap<String, Object>();
        }

        expected.put(key, value);
    }

    public void addExpected(Map<String, Object> expected) {
        if (this.expected == null) {
            this.expected = new HashMap<String, Object>();
        }

        this.expected.putAll(expected);
    }

}
