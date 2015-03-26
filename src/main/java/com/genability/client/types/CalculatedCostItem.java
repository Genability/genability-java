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
	private String family;
	private String formula;
	private DateTime demandInterval;
	private Integer duration;
	private ChargeType chargeType;
	private String period;

	public Long getTariffRateId() {
		return tariffRateId;
	}

	public void setTariffRateId(Long tariffRateId) {
		this.tariffRateId = tariffRateId;
	}

	public Long getTariffRateBandId() {
		return tariffRateBandId;
	}

	public void setTariffRateBandId(Long tariffRateBandId) {
		this.tariffRateBandId = tariffRateBandId;
	}

	public String getRateGroupName() {
		return rateGroupName;
	}

	public void setRateGroupName(String rateGroupName) {
		this.rateGroupName = rateGroupName;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public RateUnit getRateType() {
		return rateType;
	}

	public void setRateType(RateUnit rateType) {
		this.rateType = rateType;
	}

	public ChargeType getChargeType() {
		return chargeType;
	}

	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getQuantityKey() {
		return quantityKey;
	}

	public void setQuantityKey(String quantityKey) {
		this.quantityKey = quantityKey;
	}

	public Double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public BigDecimal getItemCount() {
		return itemCount;
	}

	public void setItemCount(BigDecimal itemCount) {
		this.itemCount = itemCount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}
	
	public BigDecimal getRateProration() {
		return rateProration;
	}

	public void setRateProration(BigDecimal rateProration) {
		this.rateProration = rateProration;
	}
    
	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public DateTime getDemandInterval() {
		return demandInterval;
	}

	public void setDemandInterval(DateTime demandInterval) {
		this.demandInterval = demandInterval;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
