package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	
	public static final String REST_TYPE = "Price";

	
	private String description;
	
	private Long masterTariffId;

	private DateTime fromDateTime;
	
	private DateTime toDateTime;
	
	private String detailLevel;

	private String currency;
	
	private BigDecimal rateMean;
	
	private BigDecimal rateStandardDeviation;
	


	private List<PriceChange> priceChanges;


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
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
	
	public String getDetailLevel() {
		return detailLevel;
	}

	public void setDetailLevel(String chargeType) {
		this.detailLevel = chargeType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getRateMean() {
		return rateMean;
	}

	public void setRateMean(BigDecimal rateMean) {
		this.rateMean = rateMean;
	}

	public BigDecimal getRateStandardDeviation() {
		return rateStandardDeviation;
	}

	public void setRateStandardDeviation(BigDecimal rateStandardDeviation) {
		this.rateStandardDeviation = rateStandardDeviation;
	}
	
	public List<PriceChange> getPriceChanges() {
		return priceChanges;
	}

	public void setPriceChanges(List<PriceChange> priceChanges) {
		this.priceChanges = priceChanges;
	}
	
}
