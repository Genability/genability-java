package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
	
	private Map<String, Object> summary;

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

	/**
	 * The summary property of a calculated cost contains a summary of the calculation. This object can have
	 * up to three parts:
	 * 
	 * <ol>
	 * 	<li>Top level values: <code>totalCost</code>, <code>kWh</code>, and <code>kW</code>, all of which are of
	 * 	type BigDecimal.</li>
	 * 	<li>A map of values relating to the <code>ELECTRICITY</code> service type: <code>kWh</code>,
	 *  	and <code>kW</code></li>
	 * 	<li>A map of values relating to the <code>SOLAR_PV</code> service type: <code>kWh</code>, <code>kW</code>,
	 * 		and <code>systemSize</code></li>
	 * </ol>
	 * 
	 * Each value must be cast from type {@link java.lang.Object} to its appropriate type. An example of the summary
	 * is:
	 * 
	 * <pre>
	 * "summary": {
     *  "ELECTRICITY": {
     *    "kWh": 16189,
     *    "kW": 3.74
     *  },
     *  "SOLAR_PV": {
     *    "kWh": 3966.46,
     *    "kW": 0,
     *    "systemSize": 2.65
     *  },
     *  "totalCost": 3534.24,
     *  "kWh": 12222.54,
     *  "kW": 1.92
     * }
     * </pre>
	 */
	public Map<String, Object> getSummary() {
		return summary;
	}

	public void setSummary(Map<String, Object> summary) {
		this.summary = summary;
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