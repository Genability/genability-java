package com.genability.client.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genability.client.types.CustomerClass;
import com.genability.client.types.ServiceType;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

public class BaselineRequest extends AbstractRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String addressString;
	private String zipCode;
	private String country;
	private Double latitude;
	private Double longitude;
	private CustomerClass customerClass;
	private String buildingType;
	private ServiceType serviceType;
	private Long buildingArea;		// in sq ft
	private String buildingVintage;
	private Boolean excludeMeasures;

	// "intensity", "proportion", or "total" (default)
	private String measuresUnit;

	// (optional) "MONTH", "DAY", or "YEAR"
	private String groupBy;

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(final String addressString) {
		this.addressString = addressString;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	@JsonProperty("lat")
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("lng")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	public CustomerClass getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(final CustomerClass customerClass) {
		this.customerClass = customerClass;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(final String buildingType) {
		this.buildingType = buildingType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(final ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Long getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(final Long buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getBuildingVintage() {
		return buildingVintage;
	}

	public void setBuildingVintage(final String buildingVintage) {
		this.buildingVintage = buildingVintage;
	}

	public Boolean getExcludeMeasures() {
		return excludeMeasures;
	}

	public void setExcludeMeasures(final Boolean excludeMeasures) {
		this.excludeMeasures = excludeMeasures;
	}

	public String getMeasuresUnit() {
		return measuresUnit;
	}

	public void setMeasuresUnit(final String measuresUnit) {
		this.measuresUnit = measuresUnit;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(final String groupBy) {
		this.groupBy = groupBy;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		final List<NameValuePair> queryParams = super.getQueryParams();

		addParam(queryParams, "addressString", addressString);
		addParam(queryParams, "zipCode", zipCode);
		addParam(queryParams, "country", country);
		if (latitude != null) {
			addParam(queryParams, "lat", latitude);
		}
		if (longitude != null) {
			addParam(queryParams, "lng", longitude);
		}
		addParam(queryParams, "customerClass", customerClass);
		addParam(queryParams, "buildingType", customerClass);
		addParam(queryParams, "serviceType", customerClass);
		addParam(queryParams, "buildingArea", buildingArea);
		addParam(queryParams, "buildingVintage", buildingVintage);
		addParam(queryParams, "excludeMeasures", excludeMeasures);
		addParam(queryParams, "measuresUnit", measuresUnit);
		addParam(queryParams, "groupBy", groupBy);

		return queryParams;
	}
}
