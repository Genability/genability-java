package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	
	public static final String REST_TYPE = "TariffRateSummary";

	
	private Long tariffId;

	private String chargeType;

	private String quantityKey;

	private DateTime fromDateTime;
	
	private DateTime toDateTime;
	
	private BigDecimal rateAmount;

	private BigDecimal relativePriceIndex;
	
	private String currency;
	
	private List<PriceChange> priceChanges;


	/**
	 * Unique Genability ID (primary key) for this tariff
	 */
	public Long getTariffId() {
		return tariffId;
	}

	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	/**
	 * Possible values:
     *   FIXED_PRICE - a fixed charge for the period
     *   CONSUMPTION_BASED - based on quantity used (e.g. kW/h),
     *   DEMAND_BASED - based on the peak demand (e.g. kW)
     *   QUANTITY - a rate per number of items (e.g. $5 per street light)
     *   FORMULA - a rate that has a specific or custom formula
     *   MINIMUM - a minimum amount that the LSE will charge you, regardless of the other charges
	 */
	public String getChargeType() {
        return chargeType;
    }

	public void setChargeType(String chargeType) {
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
	
}
