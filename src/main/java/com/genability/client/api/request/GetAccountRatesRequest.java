/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.genability.client.types.ServiceType;


/**
 * @author ebaizel
 * 
 */
public class GetAccountRatesRequest extends AbstractGetNRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private field accountId_
	 */
	private String accountId;

	private String providerAccountId;
	
	private ServiceType serviceType;
	
	private DateTime fromDateTime;
	
	private DateTime toDateTime;
	

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

	//

	@Override
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams, "providerAccountId", providerAccountId);
		

		return qparams;
		
	}	
	
}
