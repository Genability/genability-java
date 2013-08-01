package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

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
	
	@Override
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"accountId",accountId);		
		return qparams;
		
	}
	
}