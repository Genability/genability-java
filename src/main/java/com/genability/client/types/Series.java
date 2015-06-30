package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {

    private Integer seriesId;
    private DateTime fromDateTime;
    private DateTime toDateTime;
    private String scenario;
    private String displayLabel;
    private String seriesPeriod;
    private Integer seriesDuration;
    private String designId;
    private String key;
    private BigDecimal rate;
    private BigDecimal qty;
    private BigDecimal cost;

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
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

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getSeriesPeriod() {
        return seriesPeriod;
    }

    public void setSeriesPeriod(String seriesPeriod) {
        this.seriesPeriod = seriesPeriod;
    }

    public Integer getSeriesDuration() {
        return seriesDuration;
    }

    public void setSeriesDuration(Integer seriesDuration) {
        this.seriesDuration = seriesDuration;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
