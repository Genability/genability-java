package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PropertyKey {

	public static final String REST_TYPE = "PropertyKey";
	
	protected String keyName;
	
	protected String displayName;

	protected String family;

	protected String keyspace;
	
	protected String description;
	
	protected DataType dataType;

	protected String resourceType;

	protected String quantityUnit;

	protected String formulaDetail;

	protected Integer lookbackIntervalQuantity;

	protected Integer lookbackQuantity;

	protected String lookbackPeriod;

	protected Long lookbackTimeOfUseId;

	protected Integer lookbackSeasonId;

	protected Long entityId;

	protected String entityName;
	
	protected Privacy privacy;
	
	protected List<PropertyChoice> choices;
	
	protected List<PropertyLookup> lookups;
	

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getFormulaDetail() {
		return formulaDetail;
	}

	public void setFormulaDetail(String formulaDetail) {
		this.formulaDetail = formulaDetail;
	}

	public Integer getLookbackIntervalQuantity() {
		return lookbackIntervalQuantity;
	}

	public void setLookbackIntervalQuantity(Integer lookbackIntervalQuantity) {
		this.lookbackIntervalQuantity = lookbackIntervalQuantity;
	}

	public Integer getLookbackQuantity() {
		return lookbackQuantity;
	}

	public void setLookbackQuantity(Integer lookbackQuantity) {
		this.lookbackQuantity = lookbackQuantity;
	}

	public String getLookbackPeriod() {
		return lookbackPeriod;
	}

	public void setLookbackPeriod(String lookbackPeriod) {
		this.lookbackPeriod = lookbackPeriod;
	}

	public Long getLookbackTimeOfUseId() {
		return lookbackTimeOfUseId;
	}

	public void setLookbackTimeOfUseId(Long lookbackTimeOfUseId) {
		this.lookbackTimeOfUseId = lookbackTimeOfUseId;
	}

	public Integer getLookbackSeasonId() {
		return lookbackSeasonId;
	}

	public void setLookbackSeasonId(Integer lookbackSeasonId) {
		this.lookbackSeasonId = lookbackSeasonId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	public List<PropertyChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<PropertyChoice> choices) {
		this.choices = choices;
	}

	public List<PropertyLookup> getLookups() {
		return lookups;
	}

	public void setLookups(List<PropertyLookup> lookups) {
		this.lookups = lookups;
	}
}
