package com.genability.client.api.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genability.client.types.ChargeType;
import com.genability.client.types.CustomerClass;
import com.genability.client.types.ServiceType;
import com.genability.client.types.TariffType;

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
	private TariffType[] tariffTypes;
	private ServiceType[] serviceTypes;
	private ChargeType[] chargeTypes;
	private String zipCode;
	private Boolean populateRates;
	private Boolean populateProperties;
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

	public Boolean getIsActive() {
      return isActive;
    }

	public void setIsActive(Boolean isActive) {
      this.isActive = isActive;
    }

	public String getAccountId() {
		return accountId;
	}

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

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"lseId",lseId);
		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams,"effectiveOn",effectiveOn);
		addParam(qparams,"fromDateTime",fromDateTime);
		addParam(qparams,"toDateTime",toDateTime);
		addParam(qparams,"isActive",isActive);
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
		addParam(qparams,"hasTimeOfUseRates",hasTimeOfUseRates);
		addParam(qparams,"openOn", openOn);

		return qparams;
	}
}
