/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

/**
 * 
 */
public class GetLsesRequest extends AbstractGetNRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private field accountId
	 */
	private String accountId;

	/**
	 * private field zipCode
	 */
	private String zipCode;

	/**
	 * private field serviceTypes
	 */
	private String[] serviceTypes;

	/**
	 * private field residentialServiceTypes
	 */
	private String[] residentialServiceTypes;

	/**
	 * private field commercialServiceTypes
	 */
	private String[] commercialServiceTypes;

	/**
	 * private field industrialServiceTypes
	 */
	private String[] industrialServiceTypes;

	/**
	 * private field transportationServiceTypes
	 */
	private String[] transportationServiceTypes;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
      return zipCode;
    }

	/**
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
    }

	/**
	 * @return serviceTypes
	 */
	public String[] getServiceTypes() {
      return serviceTypes;
    }

	/**
	 * @param serviceTypes
	 */
	public void setServiceTypes(String[] serviceTypes) {
      this.serviceTypes = serviceTypes;
    }

	/**
	 * @return residentialServiceTypes
	 */
	public String[] getResidentialServiceTypes() {
      return residentialServiceTypes;
    }

	/**
	 * @param residentialServiceTypes
	 */
	public void setResidentialServiceTypes(String[] residentialServiceTypes) {
      this.residentialServiceTypes = residentialServiceTypes;
    }

	/**
	 * @return commercialServiceTypes
	 */
	public String[] getCommercialServiceTypes() {
      return commercialServiceTypes;
    }

	/**
	 * @param commercialServiceTypes
	 */
	public void setCommercialServiceTypes(String[] commercialServiceTypes) {
      this.commercialServiceTypes = commercialServiceTypes;
    }
	
	/**
	 * @return industrialServiceTypes
	 */
	public String[] getIndustrialServiceTypes() {
      return industrialServiceTypes;
    }

	/**
	 * @param industrialServiceTypes
	 */
	public void setIndustrialServiceTypes(String[] industrialServiceTypes) {
      this.industrialServiceTypes = industrialServiceTypes;
    }

	/**
	 * @return transportationServiceTypes
	 */
	public String[] getTransportationServiceTypes() {
      return transportationServiceTypes;
    }

	/**
	 * @param transportationServiceTypes
	 */
	public void setTransportationServiceTypes(String[] transportationServiceTypes) {
      this.transportationServiceTypes = transportationServiceTypes;
    }

	@Override
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
