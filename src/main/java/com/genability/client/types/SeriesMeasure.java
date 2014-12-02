package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class SeriesMeasure {

    private Integer seriesId;
    private DateTime fromDateTime;
    private DateTime toDateTime;
    private BigDecimal rate;
    private BigDecimal qty;
    private BigDecimal cost;

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(final Integer seriesId) {
        this.seriesId = seriesId;
    }

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
}
