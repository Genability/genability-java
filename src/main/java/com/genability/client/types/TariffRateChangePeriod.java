package com.genability.client.types;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TariffRateChangePeriod {
	private Long tariffRateId;
	private Long touGroupId;
	private String quantityKey;
	private String rateName;
	private ChargeType chargeType;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private BigDecimal rateAmount;
	private RateUnit rateUnit;
	private String changeName;
	private String chargePeriod;

	public TariffRateChangePeriod() {
		// no-op
	}

	public void setTariffRateId(final Long tariffRateId_) {
		this.tariffRateId = tariffRateId_;
	}

	public Long getTariffRateId() {
		return tariffRateId;
	}

	public void setRateName(final String rateName) {
		this.rateName = rateName;
	}

	public String getRateName() {
		return rateName;
	}

	public void setChargeType(final ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public ChargeType getChargeType() {
		return chargeType;
	}

	public void setQuantityKey(final String quantityKey) {
		this.quantityKey = quantityKey;
	}

	public String getQuantityKey() {
		return quantityKey;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(final DateTime date) {
		this.fromDateTime = date;
	}

	public void setToDateTime(final DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(final BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public void setRateUnit(final RateUnit rateUnit_) {
		this.rateUnit = rateUnit_;
	}

	public RateUnit getRateUnit() {
		return rateUnit;
	}

	public void setChargePeriod(final String chargePeriod) {
		this.chargePeriod = chargePeriod;
	}

	public String getChargePeriod() {
		return chargePeriod;
	}

	public void setChangeName(final String changeName) {
		this.changeName = changeName;
	}

	public String getChangeName() {
		return changeName;
	}

	public Long getTouGroupId() {
		return touGroupId;
	}

	public void setTouGroupId(final Long touGroupId) {
		this.touGroupId = touGroupId;
	}
}