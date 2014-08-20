package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetPropertyLookupRequest extends AbstractRequest implements Serializable{
	
	/**
	 * Private member variable for KeyName.
	 */
	private String keyName_;
	
	/**
	 * Private member variable for subPropertyKeyName_.
	 */
	private String subPropertyKeyName_;
	
	/**
	 * Private member variable for Choices.
	 */
	private Boolean populatePropertyChoices_;
	/**
	 * Private member variable for Lookups.
	 */
	private Boolean populatePropertyLookups_;

	private DateTime fromDateTime;
	private DateTime toDateTime;

	public List<NameValuePair> getQueryParams() {

List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams,"keyName", keyName_);
		return qparams;
	}

	public String getKeyName_() {
		return keyName_;
	}

	public void setKeyName_(String keyName_) {
		this.keyName_ = keyName_;
	}

	public String getSubPropertyKeyName_() {
		return subPropertyKeyName_;
	}

	public void setSubPropertyKeyName_(String subPropertyKeyName_) {
		this.subPropertyKeyName_ = subPropertyKeyName_;
	}

	public Boolean getPopulatePropertyChoices_() {
		return populatePropertyChoices_;
	}

	public void setPopulatePropertyChoices_(Boolean populatePropertyChoices_) {
		this.populatePropertyChoices_ = populatePropertyChoices_;
	}

	public Boolean getPopulatePropertyLookups_() {
		return populatePropertyLookups_;
	}

	public void setPopulatePropertyLookups_(Boolean populatePropertyLookups_) {
		this.populatePropertyLookups_ = populatePropertyLookups_;
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
