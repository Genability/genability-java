package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetTerritoriesRequest extends AbstractGetNRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Private member variable for LseId.
	 */
	private Long lseId;

	/**
	 * private member variable for MasterTariffId.
	 */
	private Long masterTariffId;

	/**
	 * private member variable for UsageTypes
	 */
	private String[] usageTypes;
	
	/**
	 * private member variable for containsItemType.
	 */
	private String containsItemType;

	/**
	 * private member variable for containsItemValue.
	 */
	private String containsItemValue;
	
	/**
	 * Private member variable for populating Territory Items.
	 */
	private Boolean populateItems;

	/**
	 * Private member variable for populating Territory Lses.
	 */
	private Boolean populateLses;

	/**
	 * @return the lseId
	 */
	public Long getLseId() {
		return lseId;
	}

	/**
	 * @param lseId the lseId to set
	 */
	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	/**
	 * @return the masterTariffId
	 */
	public Long getMasterTariffId() {
		return masterTariffId;
	}

	/**
	 * @param masterTariffId the masterTariffId to set
	 */
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	/**
	 * @return the usageTypes
	 */
	public String[] getUsageTypes() {
		return usageTypes;
	}

	/**
	 * @param usageTypes the usageTypes to set
	 */
	public void setUsageTypes(String[] usageTypes) {
		this.usageTypes = usageTypes;
	}

	/**
	 * @return the containsItemType
	 */
	public String getContainsItemType() {
		return containsItemType;
	}

	/**
	 * @param containsItemType the containsItemType to set
	 */
	public void setContainsItemType(String containsItemType) {
		this.containsItemType = containsItemType;
	}

	/**
	 * @return the containsItemValue
	 */
	public String getContainsItemValue() {
		return containsItemValue;
	}

	/**
	 * @param containsItemValue the containsItemValue to set
	 */
	public void setContainsItemValue(String containsItemValue) {
		this.containsItemValue = containsItemValue;
	}

	/**
	 * @return the populateItems
	 */
	public Boolean getPopulateItems() {
		return populateItems;
	}

	/**
	 * @param populateItems the populateItems to set
	 */
	public void setPopulateItems(Boolean populateItems) {
		this.populateItems = populateItems;
	}

	/**
	 * @return the populateLses
	 */
	public Boolean getPopulateLses() {
		return populateLses;
	}

	/**
	 * @param populateLses the populateLses to set
	 */
	public void setPopulateLses(Boolean populateLses) {
		this.populateLses = populateLses;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"populateItems",populateItems);
		addParam(qparams,"populateLses",populateLses);
		addParam(qparams,"lseId",lseId);
		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams,"containsItemType",containsItemType);
		addParam(qparams,"containsItemValue",containsItemValue);
		addParam(qparams,"usageType",usageTypes);

		return qparams;

	}
	
}
