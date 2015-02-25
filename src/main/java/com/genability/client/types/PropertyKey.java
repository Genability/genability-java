package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PropertyKey {

	public static final String REST_TYPE = "PropertyKey";
	
	private String keyName;	
	private String displayName;
	private String description;
	
	private String family;
	private String keyspace;	
	private DataType dataType;
	private String resourceType;

	private String quantityUnit;
	private String formulaDetail;

	private Integer lookbackIntervalQuantity;
	private Integer lookbackQuantity;
	private String lookbackPeriod;
	private Long lookbackTimeOfUseId;
	private Integer lookbackSeasonId;

	private Long entityId;
	private String entityName;
	private String entityType;

	private Privacy privacy;	
	private List<PropertyChoice> choices;	
	private List<PropertyLookup> lookups;

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

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(final DataType dataType) {
		this.dataType = dataType;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(final String resourceType) {
		this.resourceType = resourceType;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(final String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getFormulaDetail() {
		return formulaDetail;
	}

	public void setFormulaDetail(final String formulaDetail) {
		this.formulaDetail = formulaDetail;
	}

	public Integer getLookbackIntervalQuantity() {
		return lookbackIntervalQuantity;
	}

	public void setLookbackIntervalQuantity(final Integer lookbackIntervalQuantity) {
		this.lookbackIntervalQuantity = lookbackIntervalQuantity;
	}

	public Integer getLookbackQuantity() {
		return lookbackQuantity;
	}

	public void setLookbackQuantity(final Integer lookbackQuantity) {
		this.lookbackQuantity = lookbackQuantity;
	}

	public String getLookbackPeriod() {
		return lookbackPeriod;
	}

	public void setLookbackPeriod(final String lookbackPeriod) {
		this.lookbackPeriod = lookbackPeriod;
	}

	public Long getLookbackTimeOfUseId() {
		return lookbackTimeOfUseId;
	}

	public void setLookbackTimeOfUseId(final Long lookbackTimeOfUseId) {
		this.lookbackTimeOfUseId = lookbackTimeOfUseId;
	}

	public Integer getLookbackSeasonId() {
		return lookbackSeasonId;
	}

	public void setLookbackSeasonId(final Integer lookbackSeasonId) {
		this.lookbackSeasonId = lookbackSeasonId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(final Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(final String entityName) {
		this.entityName = entityName;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(final String entityType) {
		this.entityType = entityType;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(final Privacy privacy) {
		this.privacy = privacy;
	}

	public List<PropertyChoice> getChoices() {
		return choices;
	}

	public void setChoices(final List<PropertyChoice> choices) {
		this.choices = choices;
	}

	public List<PropertyLookup> getLookups() {
		return lookups;
	}

	public void setLookups(final List<PropertyLookup> lookups) {
		this.lookups = lookups;
	}
}
