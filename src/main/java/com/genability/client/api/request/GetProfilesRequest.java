package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetProfilesRequest extends AbstractGetNRequest implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
	 * Private member variable for accountId.
	 */
	private String accountId;

	/**
	 * Private member variable for providerAccountId.
	 */
	private String providerAccountId;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return providerAccountId
	 */
	public String getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * @param providerAccountId
	 *            the providerAccountId to set
	 */
	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams, "accountId", accountId);
		addParam(qparams, "providerAccountId", providerAccountId);
		return qparams;
		
	}
	
}