package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetIncentivesRequest extends AbstractGetNRequest {

	private Long lseId;
	private Long masterTariffId;
	private String customerClass;
	private String projectType;
	private String incentiveType;
	private String chargePeriod;
	private String serviceType;

	private String addressString;
	private String zipCode;
	
	private DateTime effectiveOn;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private Boolean isActive;
	private Boolean populateDetails;
	private Boolean applicableRatesOnly;
	
	public GetIncentivesRequest() {}

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

	public String getCustomerClasses() {
		return customerClass;
	}

	public void setCustomerClasses(String custClass) {
			this.customerClass = custClass;
	}
	public String getServiceTypes() {
		return serviceType;
	}

	public void setServiceTypes(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getAddressString() {
		return addressString;
	}
	
	public void setAddressString(String addressString) {
		this.addressString = addressString;
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

	public void setIsActive(Boolean setIsActive) {
		this.isActive = setIsActive;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getIncentiveType() {
		return incentiveType;
	}

	public void setIncentiveType(String incentiveType) {
		this.incentiveType = incentiveType;
	}

	public String getChargePeriod() {
		return chargePeriod;
	}

	public void setChargePeriod(String chargePeriod) {
		this.chargePeriod = chargePeriod;
	}

	public Boolean getPopulateDetails() {
		return populateDetails;
	}

	public void setPopulateDetails(Boolean populateDetails) {
		this.populateDetails = populateDetails;
	}

	public Boolean getApplicableRatesOnly() {
		return applicableRatesOnly;
	}

	public void setApplicableRatesOnly(Boolean applicableRatesOnly) {
		this.applicableRatesOnly = applicableRatesOnly;
	}
	
	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams, "masterTariffId", masterTariffId);
		addParam(qparams, "populateDetails", populateDetails);
		addParam(qparams, "applicableRatesOnly", applicableRatesOnly);
		addParam(qparams, "lseId", lseId);
		addParam(qparams, "masterTariffId", masterTariffId);
		addParam(qparams, "customerClass", customerClass);
		addParam(qparams, "projectType", projectType);
		addParam(qparams, "incentiveType", incentiveType);
		addParam(qparams, "chargePeriod", chargePeriod);
		addParam(qparams, "serviceType", serviceType);
		addParam(qparams, "addressString", addressString);
		addParam(qparams, "zipCode", zipCode);
		addParam(qparams, "effectiveOn", effectiveOn);
		addParam(qparams, "fromDateTime", fromDateTime);
		addParam(qparams, "toDateTime", toDateTime);
		addParam(qparams, "isActive", isActive);
		addParam(qparams, "populateDetails", populateDetails);
		addParam(qparams, "applicableRatesOnly", applicableRatesOnly);

		return qparams;
	}	
}
