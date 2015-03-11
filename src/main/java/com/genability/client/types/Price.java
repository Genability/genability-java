package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	
	public static final String REST_TYPE = "TariffRateSummary";

	private String name;
	private Long tariffId;
	private ChargeType chargeType;
	private String quantityKey;
	private DateTime fromDateTime;	
	private DateTime toDateTime;	
	private BigDecimal rateAmount;
	private BigDecimal relativePriceIndex;	
	private String currency;
	private List<PriceChange> priceChanges;
	private List<TariffRateChangePeriod> rateChangePeriods;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTariffId() {
		return tariffId;
	}

	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	public ChargeType getChargeType() {
        return chargeType;
    }

	public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

	/**
	 * When not null, the Property that defines
	 * the type of quantity this rate applies to.
	 * @return
	 */
	public String getQuantityKey() {
        return quantityKey;
    }

	public void setQuantityKey(String quantityKey) {
        this.quantityKey = quantityKey;
    }

	/**
	 * The starting date and time for this Price summary.
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * The ending date and time for this Price summary.
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	
	/**
	 * Currently all prices are returned in USD.
	 */
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * The charge amount in dollars for
	 * this Tariff at the time passed in.
	 */
	public BigDecimal getRateAmount() {
        return rateAmount;
    }

	public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
    }

	/**
	 * The relative price of this rateAmount compared to other rate
	 * amounts in this summary. This is useful for change in price
	 * notifications. The highest price will have an RPI of 1.0.
	 */
	public BigDecimal getRelativePriceIndex() {
        return relativePriceIndex;
    }

	public void setRelativePriceIndex(BigDecimal relativePriceIndex) {
        this.relativePriceIndex = relativePriceIndex;
    }

	/**
	 * List of all the price changes within the specified time period
	 */
	public List<PriceChange> getPriceChanges() {
		return priceChanges;
	}

	public void setPriceChanges(List<PriceChange> priceChanges) {
		this.priceChanges = priceChanges;
	}

	public List<TariffRateChangePeriod> getRateChangePeriods() {
		return rateChangePeriods;
	}

	public void setRateChangePeriods(List<TariffRateChangePeriod> rateChangePeriods) {
		this.rateChangePeriods = rateChangePeriods;
	}
	
}
