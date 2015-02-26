package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TariffProperty {

	private String keyName;
	private String displayName;
	private String family;
	private String keyspace;
	private String description;
	private String dataType;
	private TariffPropertyType propertyTypes;
	private String operator;
	private String propertyValue;
	private String quantityUnit;
	private String quantityKey;
	private String minValue;
	private String maxValue;
	private List<PropertyChoice> choices;
	private String period;
	private String formulaDetail;
	private Boolean isDefault;

	private List<PropertyLookup> lookups;
	private Long lookbackintervalQuantity;
	private String lookbackPeriod;
	private Long lookbackQuantity;
	private Long lookbackTimeOfUseId;
	private Long lookbackSeasonId;

	private String resourceType;
	private Long entityId;
	private String entityType;
	private String entityName;
	
	private Privacy privacy;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(final String keyName) {
		this.keyName = keyName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(final String family) {
		this.family = family;
	}

	public String getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(final String keyspace) {
		this.keyspace = keyspace;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(final String dataType) {
		this.dataType = dataType;
	}

	public TariffPropertyType getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(final TariffPropertyType propertyTypes) {
		this.propertyTypes = propertyTypes;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(final String operator) {
		this.operator = operator;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(final String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(final String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(final String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(final String maxValue) {
		this.maxValue = maxValue;
	}

	public List<PropertyChoice> getChoices() {
		return choices;
	}

	public void setChoices(final List<PropertyChoice> choices) {
		this.choices = choices;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(final String period) {
		this.period = period;
	}

	public String getFormulaDetail() {
		return formulaDetail;
	}

	public void setFormulaDetail(final String formulaDetail) {
		this.formulaDetail = formulaDetail;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(final Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Long getLookbackIntervalQuantity() {
		return lookbackintervalQuantity;
	}

	public void setLookbackIntervalQuantity(final Long lookbackItemQuantity) {
		this.lookbackintervalQuantity = lookbackItemQuantity;
	}

	public String getLookbackPeriod() {
		return lookbackPeriod;
	}

	public void setLookbackPeriod(final String lookbackPeriod) {
		this.lookbackPeriod = lookbackPeriod;
	}

	public Long getLookbackQuantity() {
		return lookbackQuantity;
	}

	public void setLookbackQuantity(final Long lookbackQuantity) {
		this.lookbackQuantity = lookbackQuantity;
	}

	public Long getLookbackTimeOfUseId() {
		return lookbackTimeOfUseId;
	}

	public void setLookbackTimeOfUseId(final Long lookbackTimeOfUseId) {
		this.lookbackTimeOfUseId = lookbackTimeOfUseId;
	}

	public Long getLookbackSeasonId() {
		return lookbackSeasonId;
	}

	public void setLookbackSeasonId(final Long lookbackSeasonId) {
		this.lookbackSeasonId = lookbackSeasonId;
	}

	public String getQuantityKey() {
		return quantityKey;
	}

	public void setQuantityKey(final String quantityKey) {
		this.quantityKey = quantityKey;
	}

	public List<PropertyLookup> getLookups() {
		return lookups;
	}

	public void setLookups(final List<PropertyLookup> lookups) {
		this.lookups = lookups;
	}

	public Long getLookbackintervalQuantity() {
		return lookbackintervalQuantity;
	}

	public void setLookbackintervalQuantity(final Long lookbackintervalQuantity) {
		this.lookbackintervalQuantity = lookbackintervalQuantity;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(final String resourceType) {
		this.resourceType = resourceType;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(final Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(final String entityType) {
		this.entityType = entityType;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(final String entityName) {
		this.entityName = entityName;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(final Privacy privacy) {
		this.privacy = privacy;
	}

}
