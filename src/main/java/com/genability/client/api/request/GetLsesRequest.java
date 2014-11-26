package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetLsesRequest extends AbstractGetNRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accountId;

	private String zipCode;

	private String[] serviceTypes;

	private String[] residentialServiceTypes;

	private String[] commercialServiceTypes;

	private String[] industrialServiceTypes;

	private String[] transportationServiceTypes;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getZipCode() {
      return zipCode;
    }

	public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
    }

	public String[] getServiceTypes() {
      return serviceTypes;
    }

	public void setServiceTypes(String[] serviceTypes) {
      this.serviceTypes = serviceTypes;
    }

	public String[] getResidentialServiceTypes() {
      return residentialServiceTypes;
    }

	public void setResidentialServiceTypes(String[] residentialServiceTypes) {
      this.residentialServiceTypes = residentialServiceTypes;
    }

	public String[] getCommercialServiceTypes() {
      return commercialServiceTypes;
    }

	public void setCommercialServiceTypes(String[] commercialServiceTypes) {
      this.commercialServiceTypes = commercialServiceTypes;
    }

	public String[] getIndustrialServiceTypes() {
      return industrialServiceTypes;
    }

	public void setIndustrialServiceTypes(String[] industrialServiceTypes) {
      this.industrialServiceTypes = industrialServiceTypes;
    }

	public String[] getTransportationServiceTypes() {
      return transportationServiceTypes;
    }

	public void setTransportationServiceTypes(String[] transportationServiceTypes) {
      this.transportationServiceTypes = transportationServiceTypes;
    }

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"accountId",accountId);
		addParam(qparams,"zipCode",zipCode);
		addParam(qparams,"serviceTypes",serviceTypes);
		addParam(qparams,"residentialServiceTypes",residentialServiceTypes);
		addParam(qparams,"commercialServiceTypes",commercialServiceTypes);
		addParam(qparams,"industrialServiceTypes",industrialServiceTypes);
		addParam(qparams,"transportationServiceTypes",transportationServiceTypes);
		
		return qparams;
		
	}	
	
}
