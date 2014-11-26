package com.genability.client.types;

import java.util.List;

public class Scenario {

    private String id;

    private String name;

    private ServiceType serviceType;

    private List<PropertyData> inputs;

    private List<TariffRate> rates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<PropertyData> getInputs() {
        return inputs;
    }

    public void setInputs(List<PropertyData> inputs) {
        this.inputs = inputs;
    }

    public List<TariffRate> getRates() {
        return rates;
    }

    public void setRates(List<TariffRate> rates) {
        this.rates = rates;
    }
}
