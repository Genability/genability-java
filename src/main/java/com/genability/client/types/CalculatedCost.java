package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatedCost {

	public static final String REST_TYPE = "CalculatedCost";
	
	private Long masterTariffId_;

	private String tariffName_;

	private DateTime fromDateTime_;

	private DateTime toDateTime_;

	private BigDecimal totalCost_;

	private BigDecimal accuracy;

	private List<Object> items_;
	
	private List<Object> assumptions;
	
	/**
	 * Access method for MasterTariffId.
	 */
	public Long getMasterTariffId() {
		return masterTariffId_;
	}

	/**
	 * Mutator for MasterTariffId.
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId_ = masterTariffId;
	}

	/**
	 * @param tariffName_
	 *            the tariffName_ to set
	 */
	public void setTariffName(String tariffName) {
		this.tariffName_ = tariffName;
	}

	/**
	 * @return the tariffName_
	 */
	public String getTariffName() {
		return tariffName_;
	}

	/**
	 * @param fromDateTime_
	 *            the fromDateTime_ to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime_ = fromDateTime;
	}
	
	/**
	 * @return the fromDateTime_
	 */
	public DateTime getFromDateTime() {
		return fromDateTime_;
	}

	/**
	 * @param toDateTime_
	 *            the toDateTime_ to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime_ = toDateTime;
	}

	/**
	 * @return the toDateTime_
	 */
	public DateTime getToDateTime() {
		return toDateTime_;
	}

	/**
	 * Returns the total cost of this calculation.
	 * @return
	 */
	public BigDecimal getTotalCost() {
		return totalCost_;
	}
	
	/**
	 * Sets the total cost of the whole calculation.
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost_ = totalCost;
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


	public List<Object> getItems() {
		return items_;
	}

	public void setItems(List<Object> items) {
		this.items_ = items;
	}
	
	/**
	 * This is not currently used but is included for mapping to work.
	 * 
	 * @return
	 */
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public List<Object> getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(List<Object> assumptions) {
		this.assumptions = assumptions;
	}	
	
	
}