package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatedCost {

	public static final String REST_TYPE = "CalculatedCost";
	
	private Long masterTariffId;

	private String tariffName;

	private DateTime fromDateTime;

	private DateTime toDateTime;

	private BigDecimal totalCost;

	private BigDecimal accuracy;

	private List<CalculatedCostItem> items;
	
	private List<PropertyData> assumptions;

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(BigDecimal accuracy) {
		this.accuracy = accuracy;
	}

	/*
	 * Use getItems() instead.
	 */
	@Deprecated
	public List<CalculatedCostItem> getCalculatedCostItems() {
		return getItems();
	}

	public List<CalculatedCostItem> getItems() {
		return items;
	}

	public void setItems(List<CalculatedCostItem> items) {
		this.items = items;
	}
	
	/**
	 * This is not currently used but is included for mapping to work.
	 * 
	 * @return The return value.
	 */
	@JsonInclude(Include.NON_NULL)
	public List<PropertyData> getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(List<PropertyData> assumptions) {
		this.assumptions = assumptions;
	}
}