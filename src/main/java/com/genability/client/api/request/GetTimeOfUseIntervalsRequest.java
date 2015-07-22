package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetTimeOfUseIntervalsRequest extends AbstractGetNRequest {

	private DateTime toDateTime;
	private DateTime fromDateTime;
	
	public DateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public DateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams, "fromDateTime", fromDateTime);
		addParam(qparams, "toDateTime", toDateTime);

		return qparams;
	}
	
}
