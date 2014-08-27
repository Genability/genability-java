package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;

/*
 * The BaselineMeasure class holds simple value data over time.
 *
 * "i" is a 1-indexed integer sequence (think of this as time, on the x-axis), and "v" is the data
 * (y-axis). The most common use case is for 8760s (hourly baseline data for a full year) used in
 * solar profiles, typical baseline (usage) profiles, and annualized meter data.
 *
 * Sometimes this is used for presenting data of a different granularity. For example, monthly
 * data for a year will have values of i from 1 to 12, inclusive.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaselineMeasure {

	private int i;
	private BigDecimal v;

	public int getI() {
		return i;
	}

	public void setI(final int i) {
		this.i = i;
	}

	public BigDecimal getV() {
		return v;
	}

	public void setV(final BigDecimal v) {
		this.v = v;
	}
}

