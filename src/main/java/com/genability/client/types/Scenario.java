package com.genability.client.types;

import java.util.List;

public class Scenario {

    private String id;

    private String name;

    private List<ServiceType> serviceTypes;

    private List<PropertyData> inputs;

    private List<TariffRate> rates;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(final List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    public List<PropertyData> getInputs() {
        return inputs;
    }

    public void setInputs(final List<PropertyData> inputs) {
        this.inputs = inputs;
    }

    public List<TariffRate> getRates() {
        return rates;
    }

    public void setRates(final List<TariffRate> rates) {
        this.rates = rates;
    }
}
