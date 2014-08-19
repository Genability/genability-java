package com.genability.client.types;

public class Baseline {

    public static final String REST_TYPE = "Baseline";

    private String baselineId;
    private BuildingType buildingType;
    private ClimateZone climateZone;
    private Factors factors;
    private int measureDuration;
    private String measureUnit;
    private String measureValue;
    private Measure[] measures;
    private String name;
    private Property[] properties;
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

    public static class ClimateZone {

        private int territoryId;
        private String territoryName;

        public int getTerritoryId() {
            return territoryId;
        }

        public void setTerritoryId(final int territoryId) {
            this.territoryId = territoryId;
        }

        public String getTerritoryName() {
            return territoryName;
        }

        public void setTerritoryName(final String territoryName) {
            this.territoryName = territoryName;
        }

    }

    public static class Factors {

        private double annualConsumption;
        private int buildingArea;
        private double meanAnnualConsumption;
        private double meanBuildingArea;
        private double meanIntensity;
        private double monthlyConsumption;
        private double peakDemand;
        private double uberAnnualConsumption;

        public double getAnnualConsumption() {
            return annualConsumption;
        }

        public void setAnnualConsumption(final double annualConsumption) {
            this.annualConsumption = annualConsumption;
        }

        public int getBuildingArea() {
            return buildingArea;
        }

        public void setBuildingArea(final int buildingArea) {
            this.buildingArea = buildingArea;
        }

        public double getMeanAnnualConsumption() {
            return meanAnnualConsumption;
        }

        public void setMeanAnnualConsumption(final double meanAnnualConsumption) {
            this.meanAnnualConsumption = meanAnnualConsumption;
        }

        public double getMeanBuildingArea() {
            return meanBuildingArea;
        }

        public void setMeanBuildingArea(final double meanBuildingArea) {
            this.meanBuildingArea = meanBuildingArea;
        }

        public double getMeanIntensity() {
            return meanIntensity;
        }

        public void setMeanIntensity(final double meanIntensity) {
            this.meanIntensity = meanIntensity;
        }

        public double getMonthlyConsumption() {
            return monthlyConsumption;
        }

        public void setMonthlyConsumption(final double monthlyConsumption) {
            this.monthlyConsumption = monthlyConsumption;
        }

        public double getPeakDemand() {
            return peakDemand;
        }

        public void setPeakDemand(final double peakDemand) {
            this.peakDemand = peakDemand;
        }

        public double getUberAnnualConsumption() {
            return uberAnnualConsumption;
        }

        public void setUberAnnualConsumption(final double uberAnnualConsumption) {
            this.uberAnnualConsumption = uberAnnualConsumption;
        }

    }

    public static class Measure {

        private int i;
        private double v;

        public int getI() {
            return i;
        }

        public void setI(final int i) {
            this.i = i;
        }

        public double getV() {
            return v;
        }

        public void setV(final double v) {
            this.v = v;
        }

    }

    public static class Property {

        private String dataType;
        private String dataValue;
        private String keyName;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(final String dataType) {
            this.dataType = dataType;
        }

        public String getDataValue() {
            return dataValue;
        }

        public void setDataValue(final String dataValue) {
            this.dataValue = dataValue;
        }

        public String getKeyName() {
            return keyName;
        }

        public void setKeyName(final String keyName) {
            this.keyName = keyName;
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

    public ClimateZone getClimateZone() {
        return climateZone;
    }

    public void setClimateZone(final ClimateZone climateZone) {
        this.climateZone = climateZone;
    }

    public Factors getFactors() {
        return factors;
    }

    public void setFactors(final Factors factors) {
        this.factors = factors;
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

    public Measure[] getMeasures() {
        return measures;
    }

    public void setMeasures(final Measure[] measures) {
        this.measures = measures;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(final Property[] properties) {
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
