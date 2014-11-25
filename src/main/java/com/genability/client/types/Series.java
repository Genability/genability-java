package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class Series {

    private String seriesId;
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

    public DateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(final DateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public DateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(final DateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(final String scenario) {
        this.scenario = scenario;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(final String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getSeriesPeriod() {
        return seriesPeriod;
    }

    public void setSeriesPeriod(final String seriesPeriod) {
        this.seriesPeriod = seriesPeriod;
    }

    public Integer getSeriesDuration() {
        return seriesDuration;
    }

    public void setSeriesDuration(final Integer seriesDuration) {
        this.seriesDuration = seriesDuration;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(final String designId) {
        this.designId = designId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(final BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(final BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(final BigDecimal cost) {
        this.cost = cost;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(final String seriesId) {
        this.seriesId = seriesId;
    }
}
