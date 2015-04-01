package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncentiveRate {

	private Long tariffRateId;
	private Integer tariffSequenceNumber;
	private String rateName;
	private String chargeType;
	private String chargePeriod;

	private String quantityKeyName;
	private String quantityDisplayName;
	private String quantityUnit;
	private String quantityDescription;
	
	private String applicabilityKeyName;
	private String applicabilityDisplayName;

	private List<IncentiveRateBand> rateBands;

	public IncentiveRate() {

	}

	public String toString() {
		try {
			return String.format("<%s %s; id %s>",
					getClass().getSimpleName(), rateName, tariffRateId);
		} catch (Exception e) {
			return super.toString();
		}
	}

	public Long getTariffRateId() {
		return tariffRateId;
	}

	public void setTariffRateId(Long tariffRateId) {
		this.tariffRateId = tariffRateId;
	}

	public Integer getTariffSequenceNumber() {
		return tariffSequenceNumber;
	}

	public void setTariffSequenceNumber(Integer tariffSequenceNumber) {
		this.tariffSequenceNumber = tariffSequenceNumber;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeTypes) {
		this.chargeType = chargeTypes;
	}

	public String getChargePeriod() {
		return chargePeriod;
	}

	public void setChargePeriod(String chargePeriod) {
		this.chargePeriod = chargePeriod;
	}

	public String getQuantityKeyName() {
		return quantityKeyName;
	}

	public void setQuantityKeyName(String quantityKeyName) {
		this.quantityKeyName = quantityKeyName;
	}

	public String getQuantityDisplayName() {
		return quantityDisplayName;
	}

	public void setQuantityDisplayName(String quantityDisplayName) {
		this.quantityDisplayName = quantityDisplayName;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getQuantityDescription() {
		return quantityDescription;
	}

	public void setQuantityDescription(String quantityDescription) {
		this.quantityDescription = quantityDescription;
	}

	public String getApplicabilityKeyName() {
		return applicabilityKeyName;
	}

	public void setApplicabilityKeyName(String applicabilityKeyName) {
		this.applicabilityKeyName = applicabilityKeyName;
	}

	public String getApplicabilityDisplayName() {
		return applicabilityDisplayName;
	}

	public void setApplicabilityDisplayName(String applicabilityDisplayName) {
		this.applicabilityDisplayName = applicabilityDisplayName;
	}

	public List<IncentiveRateBand> getRateBands() {
		return rateBands;
	}

	public void setRateBands(List<IncentiveRateBand> rateBands) {
		this.rateBands = rateBands;
	}
}
