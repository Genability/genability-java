package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetTimeOfUseGroupsRequest extends AbstractGetNRequest {

	private Long lseId;
	
	public void setLseId(final Long lseId) {
		this.lseId = lseId;
	}
	
	public Long getlseId() {
		return lseId;
	}
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams, "lseId", lseId);

		return qparams;
	}
	
}
