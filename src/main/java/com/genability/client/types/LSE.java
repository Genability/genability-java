package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LSE {
	
	public static final String REST_TYPE = "LoadServingEntity";
	
	private Long lseId;
	private String name;
	private String code;	
	private String websiteHome;
	private String lseCode;
	private String offeringType;
	private String ownership; // TODO: implement Ownership enum?
	
	private String serviceTypes;
	private Integer totalRevenues;
	private Integer totalSales;
	private Integer totalCustomers;

	private String residentialServiceTypes;
	private Integer residentialRevenues;
	private Integer residentialSales;
	private Integer residentialCustomers;
	
	private String commercialServiceTypes;
	private Integer commercialRevenues;
	private Integer commercialSales;
	private Integer commercialCustomers;
	
	private String industrialServiceTypes;
	private Integer industrialRevenues;
	private Integer industrialSales;
	private Integer industrialCustomers;
	
	private String transportationServiceTypes;
	private Integer transportationRevenues;
	private Integer transportationSales;
	private Integer transportationCustomers;
	
	public Long getLseId() {
      return lseId;
    }

	public void setLseId(Long lseId) {
      this.lseId = lseId;
    }

	public String getName() {
      return name;
    }

	public void setName(String name) {
      this.name = name;
    }

	public String getCode() {
      return code;
    }

	public void setCode(String code) {
      this.code = code;
    }

	public String getWebsiteHome() {
      return websiteHome;
    }

	public void setWebsiteHome(final String websiteHome) {
      this.websiteHome = websiteHome;
	}

	public String getLseCode() {
		return lseCode;
	}

	public void setLseCode(final String lseCode) {
		this.lseCode = lseCode;
	}

	public String getOfferingType() {
		return offeringType;
	}

	public void setOfferingType(final String offeringType) {
		this.offeringType = offeringType;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(final String ownership) {
		this.ownership = ownership;
	}

	public String getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(final String serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public Integer getTotalRevenues() {
		return totalRevenues;
	}

	public void setTotalRevenues(final Integer totalRevenues) {
		this.totalRevenues = totalRevenues;
	}

	public Integer getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(final Integer totalSales) {
		this.totalSales = totalSales;
	}

	public Integer getTotalCustomers() {
		return totalCustomers;
	}

	public void setTotalCustomers(final Integer totalCustomers) {
		this.totalCustomers = totalCustomers;
	}

	public String getResidentialServiceTypes() {
		return residentialServiceTypes;
	}

	public void setResidentialServiceTypes(final String residentialServiceTypes) {
		this.residentialServiceTypes = residentialServiceTypes;
	}

	public Integer getResidentialRevenues() {
		return residentialRevenues;
	}

	public void setResidentialRevenues(final Integer residentialRevenues) {
		this.residentialRevenues = residentialRevenues;
	}

	public Integer getResidentialSales() {
		return residentialSales;
	}

	public void setResidentialSales(final Integer residentialSales) {
		this.residentialSales = residentialSales;
	}

	public Integer getResidentialCustomers() {
		return residentialCustomers;
	}

	public void setResidentialCustomers(final Integer residentialCustomers) {
		this.residentialCustomers = residentialCustomers;
	}

	public String getCommercialServiceTypes() {
		return commercialServiceTypes;
	}

	public void setCommercialServiceTypes(final String commercialServiceTypes) {
		this.commercialServiceTypes = commercialServiceTypes;
	}

	public Integer getCommercialRevenues() {
		return commercialRevenues;
	}

	public void setCommercialRevenues(final Integer commercialRevenues) {
		this.commercialRevenues = commercialRevenues;
	}

	public Integer getCommercialSales() {
		return commercialSales;
	}

	public void setCommercialSales(final Integer commercialSales) {
		this.commercialSales = commercialSales;
	}

	public Integer getCommercialCustomers() {
		return commercialCustomers;
	}

	public void setCommercialCustomers(final Integer commercialCustomers) {
		this.commercialCustomers = commercialCustomers;
	}

	public String getIndustrialServiceTypes() {
		return industrialServiceTypes;
	}

	public void setIndustrialServiceTypes(final String industrialServiceTypes) {
		this.industrialServiceTypes = industrialServiceTypes;
	}

	public Integer getIndustrialRevenues() {
		return industrialRevenues;
	}

	public void setIndustrialRevenues(final Integer industrialRevenues) {
		this.industrialRevenues = industrialRevenues;
	}

	public Integer getIndustrialSales() {
		return industrialSales;
	}

	public void setIndustrialSales(final Integer industrialSales) {
		this.industrialSales = industrialSales;
	}

	public Integer getIndustrialCustomers() {
		return industrialCustomers;
	}

	public void setIndustrialCustomers(final Integer industrialCustomers) {
		this.industrialCustomers = industrialCustomers;
	}

	public String getTransportationServiceTypes() {
		return transportationServiceTypes;
	}

	public void setTransportationServiceTypes(final String transportationServiceTypes) {
		this.transportationServiceTypes = transportationServiceTypes;
	}

	public Integer getTransportationRevenues() {
		return transportationRevenues;
	}

	public void setTransportationRevenues(final Integer transportationRevenues) {
		this.transportationRevenues = transportationRevenues;
	}

	public Integer getTransportationSales() {
		return transportationSales;
	}

	public void setTransportationSales(final Integer transportationSales) {
		this.transportationSales = transportationSales;
	}

	public Integer getTransportationCustomers() {
		return transportationCustomers;
	}

	public void setTransportationCustomers(final Integer transportationCustomers) {
		this.transportationCustomers = transportationCustomers;
	}

}
