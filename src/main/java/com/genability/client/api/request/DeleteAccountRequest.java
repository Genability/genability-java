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
public class DeleteAccountRequest extends AbstractRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private field accountId
	 */
	private String accountId;

	/**
	 * private field providerAccountId
	 */
	private String providerAccountId;

	/**
	 * private field providerOrgId
	 */
	private String providerOrgId;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @return the providerAccountId
	 */
	public String getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * @return the providerOrgId
	 */
	public String getProviderOrgId() {
		return providerOrgId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @param providerAccountId
	 *            the providerAccountId to set
	 */
	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
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
		
		addParam(qparams,"providerAccountId", providerAccountId);
		addParam(qparams,"providerOrgId",providerOrgId);
		
		return qparams;
		
	}	
	
}
