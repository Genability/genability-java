package com.genability.client.api.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetTariffsRequest extends AbstractGetNRequest implements Serializable {


	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Private member variable for LseId.
	 */
	private Long lseId;

	/**
	 * Private member variable for effectiveOn.
	 */
	private DateTime effectiveOn;

	/**
	 * Private member variable for fromDateTime.
	 */
	private DateTime fromDateTime;

	/**
	 * Private member variable for toDateTime.
	 */
	private DateTime toDateTime;

	/**
	 * Private member variable for CustomerClasses.
	 */
	private String[] customerClasses;

	/**
	 * Private member variable for TariffTypes.
	 */
	private String[] tariffTypes;

	/**
	 * Private member variable for ServiceTypes.
	 */
	private String[] serviceTypes;

	/**
	 * Private member variable for ChargeTypes.
	 */
	private String[] chargeTypes;

	/**
	 * Private member variable for ZipCode
	 */
	private String zipCode;

	/**
	 * Private member variable for PopulateRates.
	 */
	private Boolean populateRates;
	
	/**
	 * Private member variable for PopulateProperties.
	 */
	private Boolean populateProperties;

    /**
	 * Private member variable for account
	 */
	private String accountId;
	
	/**
	 * Private member variable for searching by consumption
	 */
	private BigDecimal consumption;

	/**
	 * Private member variable for searching by demand
	 */
	private BigDecimal demand;
	
	/**
	 * Private member variable for searching by net metered tariffs
	 */
	private Boolean hasNetMetering;

	/**
	 * Private member variable for searching by tiered rates
	 */
	private Boolean hasTieredRates;

	/**
	 * Private member variable for searching by contracted rates
	 */
	private Boolean hasContractedRates;
	
	/**
	 * @return the lseId
	 */
	public Long getLseId() {
		return lseId;
	}

	/**
	 * @param lseId the lseId to set
	 */
	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	/**
	 * @return the customerClasses
	 */
	public String[] getCustomerClasses() {
		return customerClasses;
	}

	/**
	 * @param customerClasses the customerClasses to set
	 */
	public void setCustomerClasses(String[] customerClasses) {
		this.customerClasses = customerClasses;
	}

	/**
	 * @return the tariffTypes
	 */
	public String[] getTariffTypes() {
		return tariffTypes;
	}

	/**
	 * @param tariffTypes the tariffTypes to set
	 */
	public void setTariffTypes(String[] tariffTypes) {
		this.tariffTypes = tariffTypes;
	}

	/**
	 * @return the chargeTypes
	 */
	public String[] getChargeTypes() {
        return chargeTypes;
    }

	/**
	 * @param chargeTypes the chargeTypes to set
	 */
	public void setChargeTypes(String[] chargeTypes) {
        this.chargeTypes = chargeTypes;
    }

	/**
	 * @return the serviceTypes
	 */
	public String[] getServiceTypes() {
        return serviceTypes;
    }

	/**
	 * @param serviceTypes the serviceTypes to set
	 */
	public void setServiceTypes(String[] serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the effectiveOn
	 */
	public DateTime getEffectiveOn() {
		return effectiveOn;
	}

	/**
	 * @param effectiveOn the effectiveOn to set
	 */
	public void setEffectiveOn(DateTime effectiveOn) {
		this.effectiveOn = effectiveOn;
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
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the populateProperties
	 */
	public Boolean getPopulateProperties() {
		return populateProperties;
	}

	/**
	 * @param populateProperties the populateProperties to set
	 */
	public void setPopulateProperties(Boolean populateProperties) {
		this.populateProperties = populateProperties;
	}

	/**
	 * @return the populateRates
	 */
	public Boolean getPopulateRates() {
		return populateRates;
	}

	/**
	 * @param populateRates the populateRates to set
	 */
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

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"lseId",lseId);
		addParam(qparams,"effectiveOn",effectiveOn);
		addParam(qparams,"fromDateTime",fromDateTime);
		addParam(qparams,"toDateTime",toDateTime);
		addParam(qparams,"customerClasses",customerClasses);
		addParam(qparams,"tariffTypes",tariffTypes);
		addParam(qparams,"serviceTypes",serviceTypes);
		addParam(qparams,"chargeTypes",chargeTypes);
		addParam(qparams,"zipCode",zipCode);
		addParam(qparams,"populateProperties",populateProperties);
		addParam(qparams,"populateRates",populateRates);
		addParam(qparams,"accountId",accountId);
		addParam(qparams,"consumption",consumption);
		addParam(qparams,"demand",demand);
		addParam(qparams,"hasNetMetering",hasNetMetering);
		addParam(qparams,"hasTieredRates",hasTieredRates);
		addParam(qparams,"hasContractedRates",hasContractedRates);

		return qparams;
		
	}

	
}
