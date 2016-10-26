package com.genability.client.types.signal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.genability.client.types.CalculatedCostItem;
import com.genability.client.types.PropertyData;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatedCost {

    public static final String REST_TYPE = "CalculatedCost";

    private Long masterTariffId;
    private String tariffName;
    private BigDecimal totalCost;
    private DateTime fromDateTime;
    private DateTime toDateTime;
    private BigDecimal accuracy;
    private String currency;
    private Map<String, Object> summary;
    private List<CalculatedCostItem> items;
    private List<PropertyData> assumptions;
    private String calculatedCostId;

    public Long getMasterTariffId() {
        return masterTariffId;
    }

    public void setMasterTariffId(Long masterTariffId) {
        this.masterTariffId = masterTariffId;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

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

    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Map<String, Object> getSummary() {
        return summary;
    }

    public void setSummary(Map<String, Object> summary) {
        this.summary = summary;
    }

    public List<CalculatedCostItem> getItems() {
        return items;
    }

    public void setItems(List<CalculatedCostItem> items) {
        this.items = items;
    }

    public List<PropertyData> getAssumptions() {
        return assumptions;
    }

    public void setAssumptions(List<PropertyData> assumptions) {
        this.assumptions = assumptions;
    }

    public String getCalculatedCostId() {
        return calculatedCostId;
    }

    public void setCalculatedCostId(String calculatedCostId) {
        this.calculatedCostId = calculatedCostId;
    }
}
