package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.genability.client.types.CustomerClass;

public class GetIncentiveApplicabilitiesRequest extends AbstractRequest {

	private CustomerClass customerClass;
	private String projectType;
	private String incentiveType;

	private Long lseId;
	private String addressString;
	private String zipCode;
	private String state;
	
	private DateTime effectiveOn;
	private DateTime fromDate;
	private DateTime toDate;
	private Boolean isExhausted;

	public CustomerClass getCustomerClass() {
		return customerClass;
	}
	
	public void setCustomerClass(CustomerClass customerClass) {
		this.customerClass = customerClass;
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
	
	public Long getLseId() {
		return lseId;
	}
	
	public void setLseId(Long lseId) {
		this.lseId = lseId;
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
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public DateTime getEffectiveOn() {
		return effectiveOn;
	}
	
	public void setEffectiveOn(DateTime effectiveOn) {
		this.effectiveOn = effectiveOn;
	}
	
	public DateTime getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(DateTime fromDate) {
		this.fromDate = fromDate;
	}
	
	public DateTime getToDate() {
		return toDate;
	}
	
	public void setToDate(DateTime toDate) {
		this.toDate = toDate;
	}
	
	public Boolean getIsExhausted() {
		return isExhausted;
	}
	
	public void setIsExhausted(Boolean isExhausted) {
		this.isExhausted = isExhausted;
	}
	
	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams, "customerClasses", customerClass);
		addParam(qparams, "fromDate", fromDate);
		addParam(qparams, "toDate", toDate);
		addParam(qparams, "state", state);
		addParam(qparams, "isExhausted", isExhausted);
		addParam(qparams, "lseId", lseId);
		addParam(qparams, "projectType", projectType);
		addParam(qparams, "incentiveType", incentiveType);
		addParam(qparams, "addressString", addressString);
		addParam(qparams, "zipCode", zipCode);
		addParam(qparams, "effectiveOn", effectiveOn);

		return qparams;
	}	
}
