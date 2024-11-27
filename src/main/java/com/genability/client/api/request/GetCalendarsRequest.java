package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetCalendarsRequest extends AbstractGetNRequest {

	/**
	 * Private member variable for LseId.
	 */
	private Long lseId;

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}



	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"lseId",lseId);

		return qparams;

	}

}
