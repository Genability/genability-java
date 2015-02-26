package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genability.client.util.EnumUtil;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Territory {
	public static final String REST_TYPE = "Territory";

	private Long territoryId;
	private Long lseId;
	private String lseName;
	private Long parentTerritoryId;
	private String territoryName;
	private TerritoryType[] itemTypes;
	private String usageType;
	private List<TerritoryItem> items;
	private Boolean deregRes;
	private Boolean deregCandi;
	private Coordinates centerPoint;
	private PagedList<TerritoryLse> territoryLses;

	public Long getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	public String getLseName() {
		return lseName;
	}

	public void setLseName(String lseName) {
		this.lseName = lseName;
	}

	public Long getParentTerritoryId() {
		return parentTerritoryId;
	}

	public void setParentTerritoryId(Long parentTerritoryId) {
		this.parentTerritoryId = parentTerritoryId;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	@JsonIgnore
	public TerritoryType[] getItemTypes() {
		return itemTypes;
	}

	public void setItemTypes(TerritoryType[] itemTypes) {
		this.itemTypes = itemTypes;
	}

	@JsonProperty("itemTypes")
	public String getItemTypesAsString() {
		return EnumUtil.enumListString(itemTypes);
	}

	public void setItemTypesAsString(String itemTypes) {
		this.itemTypes = EnumUtil.parseEnumList(itemTypes, TerritoryType.class);
	}

	public String getUsageType() {
		return usageType;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public List<TerritoryItem> getItems() {
		return items;
	}

	public void setItems(List<TerritoryItem> items) {
		this.items = items;
	}

	public Boolean getDeregRes() {
		return deregRes;
	}

	public void setDeregRes(Boolean deregRes) {
		this.deregRes = deregRes;
	}

	public Boolean getDeregCandi() {
		return deregCandi;
	}

	public void setDeregCandi(Boolean deregCandi) {
		this.deregCandi = deregCandi;
	}

	public Coordinates getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Coordinates centerPoint) {
		this.centerPoint = centerPoint;
	}

	public PagedList<TerritoryLse> getTerritoryLses() {
		return territoryLses;
	}

	public void setTerritoryLses(PagedList<TerritoryLse> territoryLses) {
		this.territoryLses = territoryLses;
	}
}
