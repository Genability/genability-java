package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.genability.client.types.ClipBy;
import com.genability.client.types.GroupBy;

public class GetProfileRequest extends AbstractRequest implements Serializable{

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;
	

	private String profileId;

	/**
	 * private member variable for FromDate
	 */
	private DateTime fromDateTime;

	/**
	 * private member variable for ToDate
	 */
	private DateTime toDateTime;

	/**
	 * private member variable for PopulateReadingdata
	 */
	private Boolean populateReadings;

	/**
	 * private member variable for deriveDemand
	 */
	private Boolean deriveDemand;

	/**
	 * private member variable for deriveConsumption
	 */
	private Boolean deriveConsumption;

	/**
	 * private member variable for demandInterval
	 */
	private Long demandInterval;

	/**
	 * Private member holding optional group-by argument.
	 */
	private GroupBy groupBy;

	/**
	 * Private member holding optional clip-by argument.
	 */
	private ClipBy clipBy;


	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	/**
	 * @param date
	 *            the fromDate to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the fromDate
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the toDate
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * @return the populateReadingData
	 */
	public Boolean getPopulateReadings() {
		return populateReadings;
	}

	/**
	 * @param populateReadingData
	 *            the populateReadingData to set
	 */
	public void setPopulateReadings(Boolean populateReadings) {
		this.populateReadings = populateReadings;
	}
	
	/**
	 * @return the populateReadingData
	 */
	public Boolean getDeriveDemand() {
		return deriveDemand;
	}

	public void setDeriveDemand(Boolean deriveDemand) {
		this.deriveDemand = deriveDemand;
	}

	public Boolean getDeriveConsumption() {
		return deriveConsumption;
	}

	public void setDeriveConsumption(Boolean deriveConsumption) {
		this.deriveConsumption = deriveConsumption;
	}

	public Long getDemandInterval() {
		return demandInterval;
	}

	public void setDemandInterval(Long demandInterval) {
		this.demandInterval = demandInterval;
	}

	public GroupBy getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(GroupBy groupBy) {
		this.groupBy = groupBy;
	}

	public ClipBy getClipBy() {
		return clipBy;
	}

	public void setClipBy(ClipBy clipBy) {
		this.clipBy = clipBy;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams,"fromDateTime", fromDateTime);
		addParam(qparams,"toDateTime",toDateTime);
		addParam(qparams,"populateReadings",populateReadings);
		addParam(qparams,"groupBy",groupBy);
		addParam(qparams,"clipBy",clipBy);
		return qparams;
		
	}
	
} // end of class GetProfileRestRequest
