package com.genability.client.types;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Territory {
	
	
	public static final String REST_TYPE = "Territory";
	
	/**
	 * private member variable for TerritoryId.
	 */
	private Long territoryId;

	/**
	 * private member variable for LseId.
	 */
	private Long lseId;
	
	/**
	 * private member variable for the lseName
	 */
	private String lseName;

	/**
	 * private member variable for ParentTerritoryId.
	 */
	private Long parentTerritoryId;

	/**
	 * private member variable for TerritoryName.
	 */
	private String territoryName;

	/**
	 * private member variable for ItemTypes.
	 */
	private String itemTypes;

	/**
	 * private member variable for UsageTypes.
	 */
	private String usageType;

	/**
	 * private member variable for TerritoryTypes.
	 */
	private List<TerritoryItem> items;

	/**
	 * private member variable for deregRes_.
	 */
	private Boolean deregRes;

	/**
	 * private member variable for deregRes_.
	 */
	private Boolean deregCandi;

	/**
	 * @return the territoryId
	 */
	public Long getTerritoryId() {
		return territoryId;
	}

	/**
	 * @param territoryId the territoryId to set
	 */
	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}

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
	 * @return the lseName
	 */
	public String getLseName() {
		return lseName;
	}

	/**
	 * @param lseName the lseName to set
	 */
	public void setLseName(String lseName) {
		this.lseName = lseName;
	}

	/**
	 * @return the parentTerritoryId
	 */
	public Long getParentTerritoryId() {
		return parentTerritoryId;
	}

	/**
	 * @param parentTerritoryId the parentTerritoryId to set
	 */
	public void setParentTerritoryId(Long parentTerritoryId) {
		this.parentTerritoryId = parentTerritoryId;
	}

	/**
	 * @return the territoryName
	 */
	public String getTerritoryName() {
		return territoryName;
	}

	/**
	 * @param territoryName the territoryName to set
	 */
	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	/**
	 * @return the territoryTypes
	 */
	public String getItemTypes() {
		return itemTypes;
	}

	/**
	 * @param territoryTypes the territoryTypes to set
	 */
	public void setItemTypes(String itemTypes) {
		this.itemTypes = itemTypes;
	}

	/**
	 * @return the UsageType
	 */
	public String getUsageType() {
		return usageType;
	}

	/**
	 * @param territoryUsageType the UsageType to set
	 */
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	/**
	 * @return the territoryItems
	 */
	public List<TerritoryItem> getItems() {
		return items;
	}

	/**
	 * @param territoryItems the territoryItems to set
	 */
	public void setTerritoryItems(List<TerritoryItem> items) {
		this.items = items;
	}

	/**
	 * @return the deregRes
	 */
	public Boolean getDeregRes() {
		return deregRes;
	}

	/**
	 * @param deregRes the deregRes to set
	 */
	public void setDeregRes(Boolean deregRes) {
		this.deregRes = deregRes;
	}

	/**
	 * @return the deregCandi
	 */
	public Boolean getDeregCandi() {
		return deregCandi;
	}

	/**
	 * @param deregCandi the deregCandi to set
	 */
	public void setDeregCandi(Boolean deregCandi) {
		this.deregCandi = deregCandi;
	}

	/**
	 * @return the restType
	 */
	public static String getRestType() {
		return REST_TYPE;
	}

}
