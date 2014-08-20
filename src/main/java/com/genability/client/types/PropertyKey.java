package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyKey {
	public static final String REST_TYPE = "PropertyKey";
	
	private String keyName;

	private String family;

	private String keyspace;

	private String resourceType;

	private String quantityUnit;

	private String description;

	private String displayName;

	private String keyAttribute;

	private Integer intervalQuantity;

	private Integer lookbackQuantity;

	private String lookbackPeriod;

	private Long timeOfUseId;

	private Integer seasonId;

	private Long entityId;

	private String entityName;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
}
