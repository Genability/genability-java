package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatedCostItem {

	
	private Long tariffRateId;
    
    private Long tariffRateBandId;
    
    private String rateGroupName;
    
    private String rateName;
    
    private DateTime fromDateTime;
    
    private DateTime toDateTime;
    
    private RateUnit rateType;
    
    private String quantityKey;
    
    private Double itemQuantity;
    
    private BigDecimal itemCount;
    
    private BigDecimal cost;
    
    private BigDecimal rateAmount;
    
    private BigDecimal rateProration;
    
    private int rateSequenceNumber;
    
	private String family;

	private String formula;

	private DateTime demandInterval;

	private Integer duration;

	private ChargeType chargeType;

	private String period;
	private String chargeClass;

	/**
	 * @return the tariffRateId
	 */
	public Long getTariffRateId() {
		return tariffRateId;
	}

	/**
	 * @param tariffRateId the tariffRateId to set
	 */
	public void setTariffRateId(Long tariffRateId) {
		this.tariffRateId = tariffRateId;
	}

	/**
	 * @return the tariffRateBandId
	 */
	public Long getTariffRateBandId() {
		return tariffRateBandId;
	}

	/**
	 * @param tariffRateBandId the tariffRateBandId to set
	 */
	public void setTariffRateBandId(Long tariffRateBandId) {
		this.tariffRateBandId = tariffRateBandId;
	}

	/**
	 * @return the rateGroupName
	 */
	public String getRateGroupName() {
		return rateGroupName;
	}

	/**
	 * @param rateGroupName the rateGroupName to set
	 */
	public void setRateGroupName(String rateGroupName) {
		this.rateGroupName = rateGroupName;
	}

	/**
	 * @return the rateName
	 */
	public String getRateName() {
		return rateName;
	}

	/**
	 * @param rateName the rateName to set
	 */
	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	/**
	 * @return the fromDateTime
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param fromDateTime the fromDateTime to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the toDateTime
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * @param toDateTime the toDateTime to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the rateType
	 */
	public RateUnit getRateType() {
		return rateType;
	}

	/**
	 * @param rateType the rateType to set
	 */
	public void setRateType(RateUnit rateType) {
		this.rateType = rateType;
	}

	/**
	 * 
	 * @return chargeType
	 */
	public ChargeType getChargeType() {
		return chargeType;
	}

	/**
	 * @param chargeType
	 */
	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * @param family
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	/**
	 * @return the quantityKey
	 */
	public String getQuantityKey() {
		return quantityKey;
	}

	/**
	 * @param quantityKey the quantityKey to set
	 */
	public void setQuantityKey(String quantityKey) {
		this.quantityKey = quantityKey;
	}

	/**
	 * @return the itemQuantity
	 */
	public Double getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(Double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	/**
	 * @return the itemCount
	 */
	public BigDecimal getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(BigDecimal itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	public String getChargeClass() {
		return chargeClass;
	}

	public void setChargeClass(final String chargeClass) {
		this.chargeClass = chargeClass;
	}

	/**
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/**
	 * @return the rateAmount
	 */
	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	/**
	 * @param rateAmount the rateAmount to set
	 */
	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}
	
	/**
	 * @return the rateProration
	 */
	public BigDecimal getRateProration() {
		return rateProration;
	}

	/**
	 * @param rateProration the rateProration to set
	 */
	public void setRateProration(BigDecimal rateProration) {
		this.rateProration = rateProration;
	}
    
	public int getRateSequenceNumber() {
		return this.rateSequenceNumber;
	}
	
	public void setRateSequenceNumber(final int rateSequenceNumber) {
		this.rateSequenceNumber = rateSequenceNumber;
	}
	
	/**
	 * @return formula
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * @param formula
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	/**
	 * @return demandInterval
	 */
	public DateTime getDemandInterval() {
		return demandInterval;
	}

	/**
	 * @param demandInterval
	 */
	public void setDemandInterval(DateTime demandInterval) {
		this.demandInterval = demandInterval;
	}

	/**
	 * @return duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
