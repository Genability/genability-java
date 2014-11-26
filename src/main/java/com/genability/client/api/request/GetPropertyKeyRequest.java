package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetPropertyKeyRequest extends AbstractRequest{

	/**
	 * Private member variable for KeyName.
	 */
	private String keyName;

	/**
	 * Private member variable for subPropertyKeyName.
	 */
	private String subPropertyKeyName;

	/**
	 * Private member variable for populatePropertyLookups.
	 */
	private Boolean populatePropertyLookups;

	/**
	 * Private member variable for fromDateTime.
	 */
	private DateTime fromDateTime;
	
	/**
	 * Private member variable for toDateTime.
	 */
	private DateTime toDateTime;
	
	
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
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"keyName", keyName);
		addParam(qparams,"subPropertyKeyName", subPropertyKeyName);
		addParam(qparams,"populatePropertyLookups", populatePropertyLookups);
		addParam(qparams,"fromDateTime", fromDateTime);
		addParam(qparams,"toDateTime", toDateTime);
		return qparams;
		
	}

}
