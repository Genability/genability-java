package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {
	
	/**
	 * Source for creating a new profile using PVWatts version 4.
	 */
	public static final Source PVWATTS_V4 = Source.newBuilder()
			.setSourceId("PVWatts")
			.setSourceVersion("4")
			.build();
			
	/**
	 * Source for creating a new profile using PVWatts version 5.
	 */
	public static final Source PVWATTS_V5 = Source.newBuilder()
			.setSourceId("PVWatts")
			.setSourceVersion("5")
			.build();
	
	/**
	 * Source indicating that this data is read from a meter
	 */
	public static final Source READING_DATA = Source.newBuilder()
			.setSourceId("ReadingEntry")
			.build();
	
	/**
	 * Source signifying that the data is from a third-party solar PV model (e.g. PVSyst)
	 */
	public static final Source SOLAR_PV_MODEL = Source.newBuilder()
			.setSourceId("SolarPvModel")
			.build();
	
	private String sourceId;
	private String name;
	private String type;
	private String sourceVersion;
	
	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder {
		
		private String sourceId;
		private String name;
		private String type;
		private String sourceVersion;
		
		public Builder setSourceId(String sourceId) {
			this.sourceId = sourceId;
			return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setType(String type) {
			this.type = type;
			return this;
		}
		
		public Builder setSourceVersion(String sourceVersion) {
			this.sourceVersion = sourceVersion;
			return this;
		}
		
		public Source build() {
			Source s = new Source();
			
			s.setName(name);
			s.setSourceId(sourceId);
			s.setType(type);
			s.setSourceVersion(sourceVersion);
			
			return s;
		}
	}
	
	public String getSourceId() {
		return sourceId;
	}
	
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSourceVersion() {
		return sourceVersion;
	}
	
	public void setSourceVersion(String sourceVersion) {
		this.sourceVersion = sourceVersion;
	}
}
