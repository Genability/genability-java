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
	
	/**
	 * Access method for MasterTariffId.
	 */
	public Long getMasterTariffId() {
		return masterTariffId;
	}

	/**
	 * Mutator for MasterTariffId.
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	/**
	 * @param tariffName_
	 *            the tariffName_ to set
	 */
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	/**
	 * @return the tariffName_
	 */
	public String getTariffName() {
		return tariffName;
	}

	/**
	 * @param fromDateTime_
	 *            the fromDateTime_ to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	
	/**
	 * @return the fromDateTime_
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param toDateTime_
	 *            the toDateTime_ to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the toDateTime_
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * Returns the total cost of this calculation.
	 * @return
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	/**
	 * Sets the total cost of the whole calculation.
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Returns the overall accuracy score of this calculation.
	 * @return
	 */
	public BigDecimal getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Set the accuracy score of the overall calculation.
	 */
	public void setAccuracy(BigDecimal accuracy) {
		this.accuracy = accuracy;
	}

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
	 * @return
	 */
	@JsonInclude(Include.NON_NULL)
	public List<PropertyData> getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(List<PropertyData> assumptions) {
		this.assumptions = assumptions;
	}	
	
	
}