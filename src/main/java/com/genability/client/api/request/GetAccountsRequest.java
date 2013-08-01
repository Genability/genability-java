/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

/**
 * @author ebaizel
 * 
 */
public class GetAccountsRequest extends AbstractGetNRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private field providerOrgId
	 */
	private String providerOrgId;

	/**
	 * @return the providerOrgId
	 */
	public String getProviderOrgId() {
		return providerOrgId;
	}

	/**
	 * @param providerOrgId
	 *            the providerOrgId to set
	 * The providerOrgId should be specified when you have created more
	 * than one Org.  If it is not specified, Accounts for your default
	 * (or only) Org will be returned.   
	 */
	public void setProviderOrgId(String providerOrgId) {
		this.providerOrgId = providerOrgId;
	}

	@Override
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"providerOrgId",providerOrgId);
		
		return qparams;
		
	}	
	
}
