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
	 * private field hardDelete
	 * -- unpublished functionality --
	 */
	private Boolean hardDelete;

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

	public Boolean getHardDelete() {
	    return hardDelete;
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
	 * @param hardDelete
	 * 
	 * If true, fully delete the account,
	 * otherwise the account just has its
	 * status changed to DELETED.
	 */
	public void setHardDelete(Boolean hardDelete) {
	    this.hardDelete = hardDelete;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams,"providerAccountId", providerAccountId);
		addParam(qparams,"hardDelete",hardDelete);
		
		return qparams;
		
	}	
	
}
