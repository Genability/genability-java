package com.genability.client.types;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	
	public static final String REST_TYPE = "Account";
	
	private String accountId;

	private String providerAccountId;

	private String providerOrgId;

	private String accountName;

	private String customerOrgId;

	private String customerOrgName;

	private String status;

	private DateTime createdDate;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the providerAccountId
	 */
	public String getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * @param providerAccountId the providerAccountId to set
	 */
	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

	/**
	 * @return the providerOrgId
	 */
	public String getProviderOrgId() {
		return providerOrgId;
	}

	/**
	 * @param providerOrgId the providerOrgId to set
	 */
	public void setProviderOrgId(String providerOrgId) {
		this.providerOrgId = providerOrgId;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the customerOrgId
	 */
	public String getCustomerOrgId() {
		return customerOrgId;
	}

	/**
	 * @param customerOrgId the customerOrgId to set
	 */
	public void setCustomerOrgId(String customerOrgId) {
		this.customerOrgId = customerOrgId;
	}

	/**
	 * @return the customerOrgName
	 */
	public String getCustomerOrgName() {
		return customerOrgName;
	}

	/**
	 * @param customerOrgName the customerOrgName to set
	 */
	public void setCustomerOrgName(String customerOrgName) {
		this.customerOrgName = customerOrgName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createdDate
	 */
	public DateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
}
