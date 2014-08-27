package com.genability.client.types;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Baseline {

	public static final String REST_TYPE = "Baseline";

	private String baselineId;
	private BuildingType buildingType;
	private Territory climateZone;

	// As of 2014/08/26, factors returned are:
	//   annualConsumption
	//   buildingArea
	//   meanAnnualConsumption
	//   meanBuildingArea
	//   meanIntensity
	//   monthlyConsumption
	//   peakDemand
	//   uberAnnualConsumption
	private Map<String, BigDecimal> factors = new HashMap<String, BigDecimal>();

	private int measureDuration;
	private String measureUnit;
	private String measureValue;
	private BaselineMeasure[] measures;
	private String name;
	private PropertyData[] properties;
	private ServiceType serviceType;
	private String sourceId;
	private int startDay;

	public static class BuildingType {

		private CustomerClass customerClass;
		private String description;
		private String id;
		private String name;

		public CustomerClass getCustomerClass() {
			return customerClass;
		}

		public void setCustomerClass(final CustomerClass customerClass) {
			this.customerClass = customerClass;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(final String description) {
			this.description = description;
		}

		public String getId() {
			return id;
		}

		public void setId(final String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(final String name) {
			this.name = name;
		}
	}

	public String getBaselineId() {
		return baselineId;
	}

	public void setBaselineId(final String baselineId) {
		this.baselineId = baselineId;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(final BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public Territory getClimateZone() {
		return climateZone;
	}

	public void setClimateZone(final Territory climateZone) {
		this.climateZone = climateZone;
	}

	public Map<String, BigDecimal> getFactors() {
		return factors;
	}

	public int getMeasureDuration() {
		return measureDuration;
	}

	public void setMeasureDuration(final int measureDuration) {
		this.measureDuration = measureDuration;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(final String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getMeasureValue() {
		return measureValue;
	}

	public void setMeasureValue(final String measureValue) {
		this.measureValue = measureValue;
	}

	public BaselineMeasure[] getMeasures() {
		return measures;
	}

	public void setBaselineMeasures(final BaselineMeasure[] measures) {
		this.measures = measures;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public PropertyData[] getProperties() {
		return properties;
	}

	public void setProperties(final PropertyData[] properties) {
		this.properties = properties;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(final ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(final String sourceId) {
		this.sourceId = sourceId;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(final int startDay) {
		this.startDay = startDay;
	}
}
