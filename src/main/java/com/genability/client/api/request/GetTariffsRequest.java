package com.genability.client.api.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.genability.client.types.*;
import org.apache.http.NameValuePair;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetTariffsRequest extends AbstractGetNRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long lseId;
	private Long masterTariffId;

	private DateTime effectiveOn;
	private LocalDate openOn;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private Boolean isActive;

	private CustomerClass[] customerClasses;
	private ChargeType[] chargeTypes;
	private TariffType[] tariffTypes;
	private ServiceType[] serviceTypes;
	private Privacy[] privacyFlags;

	private String addressString;
	private String zipCode;
	private String postCode;
	private String country;

	private Boolean populateProperties;
	private Boolean populateRates;
	private Boolean populateDocuments;

	private String serviceTerms;

	private String accountId;

	private BigDecimal consumption;
	private BigDecimal demand;
	private Boolean hasNetMetering;
	private Boolean hasTieredRates;
	private Boolean hasContractedRates;
	private Boolean hasTimeOfUseRates;


	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	public CustomerClass[] getCustomerClasses() {
		return customerClasses;
	}

	public void setCustomerClasses(CustomerClass... customerClasses) {
		this.customerClasses = customerClasses;
	}

	public TariffType[] getTariffTypes() {
		return tariffTypes;
	}

	public void setTariffTypes(TariffType... tariffTypes) {
		this.tariffTypes = tariffTypes;
	}

	public ChargeType[] getChargeTypes() {
        return chargeTypes;
    }

	public void setChargeTypes(ChargeType... chargeTypes) {
        this.chargeTypes = chargeTypes;
    }

	public ServiceType[] getServiceTypes() {
        return serviceTypes;
    }

	public void setServiceTypes(ServiceType... serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public DateTime getEffectiveOn() {
		return effectiveOn;
	}

	public void setEffectiveOn(DateTime effectiveOn) {
		this.effectiveOn = effectiveOn;
	}
	
	public LocalDate getOpenOn() {
		return openOn;
	}

	public void setOpenOn(LocalDate openOn) {
		this.openOn = openOn;
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

	/**
	 * @deprecated Use
	 * <a href="http://developer.genability.com/documentation/api-reference/account-api/account-tariff/#get-an-accounts-active-tariffs">
	 * account tariffs
	 * </a>
	 * endpoint instead.
	 */
	@Deprecated
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @deprecated Use
	 * <a href="http://developer.genability.com/documentation/api-reference/account-api/account-tariff/#get-an-accounts-active-tariffs">
	 * account tariffs
	 * </a>
	 * endpoint instead.
	 */
	@Deprecated
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Boolean getPopulateProperties() {
		return populateProperties;
	}

	public void setPopulateProperties(Boolean populateProperties) {
		this.populateProperties = populateProperties;
	}

	public Boolean getPopulateRates() {
		return populateRates;
	}

	public void setPopulateRates(Boolean populateRates) {
		this.populateRates = populateRates;
	}
	
	public BigDecimal getConsumption() {
    	return consumption;
    }

	public void setConsumption(BigDecimal consumption) {
    	this.consumption = consumption;
    }

	public BigDecimal getDemand() {
    	return demand;
    }

	public void setDemand(BigDecimal demand) {
    	this.demand = demand;
    }

	public Boolean getHasNetMetering() {
    	return hasNetMetering;
    }

	public void setHasNetMetering(Boolean hasNetMetering) {
    	this.hasNetMetering = hasNetMetering;
    }

	public Boolean getHasContractedRates() {
      return hasContractedRates;
    }

	public void setHasContractedRates(Boolean hasContractedRates) {
      this.hasContractedRates = hasContractedRates;
    }

	public Boolean getHasTieredRates() {
      return hasTieredRates;
    }

	public void setHasTieredRates(Boolean hasTieredRates) {
      this.hasTieredRates = hasTieredRates;
	}

	public Boolean getHasTimeOfUseRates() {
      return hasTimeOfUseRates;
    }

	public void setHasTimeOfUseRates(Boolean hasTimeOfUseRates) {
      this.hasTimeOfUseRates = hasTimeOfUseRates;
    }

	public Privacy[] getPrivacyFlags() {
		return privacyFlags;
	}

	public void setPrivacyFlags(Privacy[] privacyFlags) {
		this.privacyFlags = privacyFlags;
	}

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getServiceTerms() {
		return serviceTerms;
	}

	public void setServiceTerms(String serviceTerms) {
		this.serviceTerms = serviceTerms;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public Boolean getPopulateDocuments() {
		return populateDocuments;
	}

	public void setPopulateDocuments(Boolean populateDocuments) {
		this.populateDocuments = populateDocuments;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"lseId",lseId);
		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams,"effectiveOn",effectiveOn);
		addParam(qparams,"openOn", openOn);
		addParam(qparams,"fromDateTime",fromDateTime);
		addParam(qparams,"toDateTime",toDateTime);
		addParam(qparams,"isActive", isActive);
		addParam(qparams,"customerClasses",customerClasses);
		addParam(qparams,"chargeTypes", chargeTypes);
		addParam(qparams,"tariffTypes",tariffTypes);
		addParam(qparams,"serviceTypes",serviceTypes);
		addParam(qparams,"privacyFlags", privacyFlags);
		addParam(qparams,"addressString", addressString);
		addParam(qparams,"zipCode",zipCode);
		addParam(qparams,"postCode", postCode);
		addParam(qparams,"country", country);
		addParam(qparams,"populateProperties",populateProperties);
		addParam(qparams,"populateRates",populateRates);
		addParam(qparams,"populateDocuments", populateDocuments);
		addParam(qparams,"serviceTerms", serviceTerms);
		addParam(qparams,"accountId",accountId);
		addParam(qparams,"consumption",consumption);
		addParam(qparams,"demand",demand);
		addParam(qparams,"hasNetMetering",hasNetMetering);
		addParam(qparams,"hasTieredRates",hasTieredRates);
		addParam(qparams,"hasContractedRates",hasContractedRates);
		addParam(qparams,"hasTimeOfUseRates",hasTimeOfUseRates);

		return qparams;
	}
}
