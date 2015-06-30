package com.genability.client.types;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measure {

	/**
	 * private member variable for QuantityUnit.
	 */
	private String quantityUnit;

	/**
	 * private member variable for QuantityAmount.
	 */
	private BigDecimal quantityAmount;

	/**
	 * private member variable for QuantitySum.
	 */
	private BigDecimal quantitySum;

	/**
	 * private member variable for QuantityAccuracy.
	 */
	private BigDecimal quantityAccuracy;

	/**
	 * private member variable for RateAmount.
	 */
	private BigDecimal rateAmount;

	/**
	 * private member variable for RateAccuracy.
	 */
	private BigDecimal rateAccuracy;

	/**
	 * private member variable for CostAmount.
	 */
	private BigDecimal costAmount;

	/**
	 * private member variable for CostAccuracy.
	 */
	private BigDecimal costAccuracy;

	public Measure() {

	}

	public Measure(String quantityUnit) {

		this.quantityUnit = quantityUnit;

	}

	public Measure(String quantityUnit, BigDecimal quantityAmount) {

		this.quantityUnit = quantityUnit;
		this.quantityAmount = quantityAmount;

	}

	public Measure(Measure measure) {

		this.quantityUnit = measure.getQuantityUnit();
		this.quantityAmount = measure.getQuantityAmount();
		
	}
	public String toString() {
		try {
			return String.format("<%s %s>", quantityAmount, quantityUnit);
		} catch (Exception e) {
			return super.toString();
		}
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public BigDecimal getQuantityAmount() {
		return quantityAmount;
	}

	public void setQuantityAmount(BigDecimal quantityAmount) {
		this.quantityAmount = quantityAmount;
	}

	public BigDecimal getQuantitySum() {
		return quantitySum;
	}

	public void setQuantitySum(BigDecimal quantitySum) {
		this.quantitySum = quantitySum;
	}

	public BigDecimal getQuantityAccuracy() {
		return quantityAccuracy;
	}

	public void setQuantityAccuracy(BigDecimal quantityAccuracy) {
		this.quantityAccuracy = quantityAccuracy;
	}

	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public BigDecimal getRateAccuracy() {
		return rateAccuracy;
	}

	public void setRateAccuracy(BigDecimal rateAccuracy) {
		this.rateAccuracy = rateAccuracy;
	}

	public BigDecimal getCostAmount() {
		return costAmount;
	}

	public void setCostAmount(BigDecimal costAmount) {
		this.costAmount = costAmount;
	}

	public BigDecimal getCostAccuracy() {
		return costAccuracy;
	}

	public void setCostAccuracy(BigDecimal costAccuracy) {
		this.costAccuracy = costAccuracy;
	}


}
