/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author mihle
 * 
 */
public class GetAccountTariffsRequest extends AbstractGetNRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accountId;
	private Long masterTariffId;
	private String[] tariffTypes;

	/**
	 * Private member variable for SerivceTypes.
	 */
	private String[] serviceTypes;

	/**
	 * Private member variable for Privacy.
	 */
	private String[] privacy;

	private DateTime effectiveOn;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private Boolean isActive;
	private Boolean includeNotApplicable;
	private Boolean populateRates;
	private Boolean populateProperties;
	private String providerAccountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Long getMasterTariffId() {
		return masterTariffId;
	}

	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	public String[] getTariffTypes() {
		return tariffTypes;
	}

	public void setTariffTypes(String[] tariffTypes) {
		this.tariffTypes = tariffTypes;
	}

	public String[] getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(String[] serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public String[] getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String[] privacy) {
		this.privacy = privacy;
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

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIncludeNotApplicable() {
		return includeNotApplicable;
	}

	public void setIncludeNotApplicable(Boolean includeNotApplicable) {
		this.includeNotApplicable = includeNotApplicable;
	}
	
	public Boolean getPopulateRates() {
		return populateRates;
	}

	public void setPopulateRates(Boolean populateRates) {
		this.populateRates = populateRates;
	}

	public Boolean getPopulateProperties() {
		return populateProperties;
	}

	public void setPopulateProperties(Boolean populateProperties) {
		this.populateProperties = populateProperties;
	}

	public String getProviderAccountId() {
		return providerAccountId;
	}

	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams, "providerAccountId", providerAccountId);


		return qparams;
		
	}	
	
}
