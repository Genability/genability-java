package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetPropertyLookupRequest extends AbstractRequest implements Serializable{

	/**
	 * Private member variable for KeyName.
	 */
	private String keyName;

	/**
	 * Private member variable for subPropertyKeyName.
	 */
	private String subPropertyKeyName;

	/**
	 * Private member variable for Choices.
	 */
	private Boolean populatePropertyChoices;
	/**
	 * Private member variable for Lookups.
	 */
	private Boolean populatePropertyLookups;

	private DateTime fromDateTime;
	private DateTime toDateTime;

	@Override
	public List<NameValuePair> getQueryParams() {

List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"keyName", keyName);
		return qparams;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getSubPropertyKeyName() {
		return subPropertyKeyName;
	}

	public void setSubPropertyKeyName(String subPropertyKeyName) {
		this.subPropertyKeyName = subPropertyKeyName;
	}

	public Boolean getPopulatePropertyChoices() {
		return populatePropertyChoices;
	}

	public void setPopulatePropertyChoices(Boolean populatePropertyChoices) {
		this.populatePropertyChoices = populatePropertyChoices;
	}

	public Boolean getPopulatePropertyLookups() {
		return populatePropertyLookups;
	}

	public void setPopulatePropertyLookups(Boolean populatePropertyLookups) {
		this.populatePropertyLookups = populatePropertyLookups;
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

}
