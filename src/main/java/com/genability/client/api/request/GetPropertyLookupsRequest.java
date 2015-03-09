package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetPropertyLookupsRequest extends AbstractRequest {

	private String keyName;
	private String subKeyName;
	private DateTime fromDateTime;
	private DateTime toDateTime;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getSubKeyName() {
		return subKeyName;
	}

	public void setSubKeyName(String subKeyName) {
		this.subKeyName = subKeyName;
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
		addParam(qparams,"subKeyName", subKeyName);
		addParam(qparams,"fromDateTime", fromDateTime);
		addParam(qparams,"toDateTime", toDateTime);
		return qparams;
		
	}

}
