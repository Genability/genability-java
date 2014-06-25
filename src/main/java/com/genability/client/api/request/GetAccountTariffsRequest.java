/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;


/**
 * @author mihle
 * 
 */
public class GetAccountTariffsRequest extends AbstractGetNRequest implements Serializable {

	/**
	 * private field accountId_
	 */
	private String accountId;

	/**
	 * Private member variable for masterTariffId.
	 */
	private Long masterTariffId;

	/**
	 * Private member variable for TariffTypes.
	 */
	private String[] tariffTypes;

	/**
	 * This is the integer flags value that the strings in tariffTypes_ are
	 * converted to.
	 */
	private Integer tariffTypeFlags;

	/**
	 * Private member variable for SerivceTypes.
	 */
	private String[] serviceTypes;

	/**
	 * This is the integer flags value that the strings in serviceTypes_ are
	 * converted to.
	 */
	private Integer serviceTypeFlags;

	/**
	 * Private member variable for Privacy.
	 */
	private String[] privacy;

	/**
	 * This is the integer flags value that the strings in privacyFlags are
	 * converted to.
	 */
	private Integer privacyFlags;
	
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
	 * Private member variable for setIsActive
	 */
	private Boolean isActive;

	/**
	 * Private member variable for includeNotApplicable
	 */
	private Boolean includeNotApplicable;
	
	/**
	 * Private member variable for PopulateRates.
	 */
	private Boolean populateRates;

	/**
	 * Private member variable for PopulateProperties.
	 */
	private Boolean populateProperties;

	/**
	 * private field providerAccountId
	 */
	private String providerAccountId;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the masterTariffId
	 */
	public Long getMasterTariffId() {
		return masterTariffId;
	}

	/**
	 * @param masterTariffId
	 *            the masterTariffId to set
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	/**
	 * @return the tariffTypes
	 */
	public String[] getTariffTypes() {
		return tariffTypes;
	}

	/**
	 * @param tariffTypes
	 *            the tariffTypes to set
	 */
	public void setTariffTypes(String[] tariffTypes) {
		this.tariffTypes = tariffTypes;
	}

	/**
	 * @return the serviceTypes
	 */
	public String[] getServiceTypes() {
		return serviceTypes;
	}

	/**
	 * @param serviceTypes
	 *            the serviceTypes to set
	 */
	public void setServiceTypes(String[] serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public String[] getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String[] privacy) {
		this.privacy = privacy;
	}

	/**
	 * @return the effectiveOn
	 */
	public DateTime getEffectiveOn() {
		return effectiveOn;
	}

	/**
	 * @param effectiveOn
	 *            the effectiveOn to set
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
	 * @param fromDateTime
	 *            the fromDateTime to set
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
	 * @param toDateTime
	 *            the toDateTime to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the includeIneligible
	 */
	public Boolean getIncludeNotApplicable() {
		return includeNotApplicable;
	}

	/**
	 * @param includeIneligible
	 *            the includeIneligible to set
	 */
	public void setIncludeNotApplicable(Boolean includeNotApplicable) {
		this.includeNotApplicable = includeNotApplicable;
	}
	

	/**
	 * @return the populateRates
	 */
	public Boolean getPopulateRates() {
		return populateRates;
	}


		/**
	 * @param populateRates
	 *            the populateRates to set
	 */
	public void setPopulateRates(Boolean populateRates) {
		this.populateRates = populateRates;
	}


		/**
	 * @return the populateProperties
	 */
	public Boolean getPopulateProperties() {
		return populateProperties;
	}


		/**
	 * @param populateProperties
	 *            the populateProperties to set
	 */
	public void setPopulateProperties(Boolean populateProperties) {
		this.populateProperties = populateProperties;
	}

	/**
	 * @return the providerAccountId
	 */
	public String getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

	//
	@Override
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams, "providerAccountId", providerAccountId);


		return qparams;
		
	}	
	
}
