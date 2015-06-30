package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeriesMeasure {

    private Integer seriesId;
    private DateTime fromDateTime;
    private DateTime toDateTime;
    private BigDecimal rate;
    private BigDecimal qty;
    private BigDecimal cost;
    private String period;
    private Long duration;

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

	public final String getPeriod() {
		return period;
	}

	public final void setPeriod(final String period) {
		this.period = period;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(final Long duration) {
		this.duration = duration;
	}
}
