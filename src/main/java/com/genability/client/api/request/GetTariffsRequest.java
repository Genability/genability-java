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

	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder extends AbstractGetNRequest.Builder<Builder> {

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
		
		public Builder setLseId(Long lseId) {
			this.lseId = lseId;
			return getThis();
		}

		public Builder setMasterTariffId(Long masterTariffId) {
			this.masterTariffId = masterTariffId;
			return getThis();
		}

		public Builder setEffectiveOn(DateTime effectiveOn) {
			this.effectiveOn = effectiveOn;
			return getThis();
		}

		public Builder setOpenOn(LocalDate openOn) {
			this.openOn = openOn;
			return getThis();
		}

		public Builder setFromDateTime(DateTime fromDateTime) {
			this.fromDateTime = fromDateTime;
			return getThis();
		}

		public Builder setToDateTime(DateTime toDateTime) {
			this.toDateTime = toDateTime;
			return getThis();
		}

		public Builder setIsActive(Boolean isActive) {
			this.isActive = isActive;
			return getThis();
		}

		public Builder setCustomerClasses(CustomerClass[] customerClasses) {
			this.customerClasses = customerClasses;
			return getThis();
		}

		public Builder setTariffTypes(TariffType[] tariffTypes) {
			this.tariffTypes = tariffTypes;
			return getThis();
		}

		public Builder setServiceTypes(ServiceType[] serviceTypes) {
			this.serviceTypes = serviceTypes;
			return getThis();
		}

		public Builder setChargeTypes(ChargeType[] chargeTypes) {
			this.chargeTypes = chargeTypes;
			return getThis();
		}

		public Builder setZipCode(String zipCode) {
			this.zipCode = zipCode;
			return getThis();
		}

		public Builder setPopulateRates(Boolean populateRates) {
			this.populateRates = populateRates;
			return getThis();
		}

		public Builder setPopulateProperties(Boolean populateProperties) {
			this.populateProperties = populateProperties;
			return getThis();
		}

		public Builder setAccountId(String accountId) {
			this.accountId = accountId;
			return getThis();
		}

		public Builder setConsumption(BigDecimal consumption) {
			this.consumption = consumption;
			return getThis();
		}

		public Builder setDemand(BigDecimal demand) {
			this.demand = demand;
			return getThis();
		}

		public Builder setHasNetMetering(Boolean hasNetMetering) {
			this.hasNetMetering = hasNetMetering;
			return getThis();
		}

		public Builder setHasTieredRates(Boolean hasTieredRates) {
			this.hasTieredRates = hasTieredRates;
			return getThis();
		}

		public Builder setHasContractedRates(Boolean hasContractedRates) {
			this.hasContractedRates = hasContractedRates;
			return getThis();
		}

		public Builder setHasTimeOfUseRates(Boolean hasTimeOfUseRates) {
			this.hasTimeOfUseRates = hasTimeOfUseRates;
			return getThis();
		}

		public GetTariffsRequest build() {
			GetTariffsRequest request = new GetTariffsRequest();
			
			setRequestFields(request);
			request.setLseId(lseId);
			request.setMasterTariffId(masterTariffId);
			request.setEffectiveOn(effectiveOn);
			request.setOpenOn(openOn);
			request.setFromDateTime(fromDateTime);
			request.setToDateTime(toDateTime);
			request.setIsActive(isActive);
			request.setCustomerClasses(customerClasses);
			request.setTariffTypes(tariffTypes);
			request.setServiceTypes(serviceTypes);
			request.setChargeTypes(chargeTypes);
			request.setZipCode(zipCode);
			request.setPopulateRates(populateRates);
			request.setPopulateProperties(populateProperties);
			request.setAccountId(accountId);
			request.setConsumption(consumption);
			request.setDemand(demand);
			request.setHasNetMetering(hasNetMetering);
			request.setHasTieredRates(hasTieredRates);
			request.setHasContractedRates(hasContractedRates);
			request.setHasTimeOfUseRates(hasTimeOfUseRates);
			
			return request;
		}
		
		@Override
		protected Builder getThis() {
			return this;
		}
	}
	
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
