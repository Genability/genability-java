/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.ArrayList;
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
	 * private field accountId_
	 */
	private String accountId_;

	/**
	 * private field providerAccountId_
	 */
	private String providerAccountId_;

	/**
	 * private field providerOrgId_
	 */
	private String providerOrgId_;

	/**
	 * @return the accountId_
	 */
	public String getAccountId() {
		return accountId_;
	}

	/**
	 * @return the providerAccountId_
	 */
	public String getProviderAccountId() {
		return providerAccountId_;
	}

	/**
	 * @return the providerOrgId_
	 */
	public String getProviderOrgId() {
		return providerOrgId_;
	}

	/**
	 * @param accountId_
	 *            the accountId_ to set
	 */
	public void setAccountId(String accountId) {
		this.accountId_ = accountId;
	}

	/**
	 * @param providerAccountId_
	 *            the providerAccountId_ to set
	 */
	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId_ = providerAccountId;
	}

	/**
	 * @param providerOrgId_
	 *            the providerOrgId_ to set
	 * The providerOrgId should be specified when you have created more
	 * than one Org.  If it is not specified, Accounts for your default
	 * (or only) Org will be returned.   
	 */
	public void setProviderOrgId(String providerOrgId) {
		this.providerOrgId_ = providerOrgId;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		
		addParam(qparams,"providerAccountId", providerAccountId_);
		addParam(qparams,"providerOrgId",providerOrgId_);
		
		return qparams;
		
	}	
	
}
