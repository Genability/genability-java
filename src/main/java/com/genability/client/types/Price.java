package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	
	public static final String REST_TYPE = "TariffRateSummary";
	
	/*
	"tariffId": 512,
	"chargeType": "FIXED_PRICE",
	"quantityKey": null,
	"fromDateTime": "2012-04-05T03:00:00-04:00",
	"toDateTime": "2012-04-06T03:00:00-04:00",
	"rateAmount": 9,
	"relativePriceIndex": 1,
	"currency": "USD",
	"priceChanges": [],
	"name": "FIXED_PRICE rate change"
	*/
	
	
	private Long tariffId;
	
	private String chargeType;
	
	private String quantityKey;
	
	private DateTime fromDateTime;
	
	private DateTime toDateTime;
	
	private String name;
	
	private BigDecimal rateAmount;
	
	private BigDecimal relativePriceIndex;
	
	private String currency;
	
	private List<PriceChange> priceChanges;
	

	public Long getTariffId() {
		return tariffId;
	}

	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getQuantityKey() {
		return quantityKey;
	}

	public void setQuantityKey(String quantityKey) {
		this.quantityKey = quantityKey;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public BigDecimal getRelativePriceIndex() {
		return relativePriceIndex;
	}

	public void setRelativePriceIndex(BigDecimal relativePriceIndex) {
		this.relativePriceIndex = relativePriceIndex;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public List<PriceChange> getPriceChanges() {
		return priceChanges;
	}

	public void setPriceChanges(List<PriceChange> priceChanges) {
		this.priceChanges = priceChanges;
	}
	
}
