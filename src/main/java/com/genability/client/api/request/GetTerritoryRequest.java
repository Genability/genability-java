package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetTerritoryRequest extends AbstractRequest {
	private Long territoryId;
	private Boolean populateItems;
	private Boolean populateLses;
	
	public Long getTerritoryId() {
		return territoryId;
	}
	public void setTerritoryId(final Long territoryId) {
		this.territoryId = territoryId;
	}
	public Boolean getPopulateItems() {
		return populateItems;
	}
	public void setPopulateItems(final Boolean populateItems) {
		this.populateItems = populateItems;
	}
	public Boolean getPopulateLses() {
		return populateLses;
	}
	public void setPopulateLses(final Boolean populateLses) {
		this.populateLses = populateLses;
	}
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams, "populateItems", populateItems);
		addParam(qparams, "populateLses", populateLses);

		return qparams;
	}
}
