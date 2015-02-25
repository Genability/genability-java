package com.genability.client.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genability.client.types.PropertyData;
import com.genability.client.types.Tariff;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Account {

	
	public static final String REST_TYPE = "Account";
	
	private String accountId;

	private String providerAccountId;

	private String accountName;

	private String customerOrgId;

	private String customerOrgName;
	
	private CustomerClass customerClass;
	
	private String owner;

	private AccountStatus status;
	
	private AccountType type;

	private Address address;
	
	private List<Tariff> tariffs;
	
	private Map<String, PropertyData> properties;

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

	public String getOwner() {
      return owner;
    }
	
	public void setOwner(String owner) {
      this.owner = owner;
    }
	
	/**
	 * @return the status
	 */
	public AccountStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountType getType() {
      return type;
    }
	
	public void setType(AccountType type) {
      this.type = type;
    }
	
	public Address getAddress() {
      return address;
    }
	
	public void setAddress(Address address) {
      this.address = address;
    }
	
	public Map<String, PropertyData> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, PropertyData> properties) {
		this.properties = properties;
	}	
	
	public PropertyData getProperty(String key) {
	    if (this.properties == null) {
	      return null;
	    }
	    return this.properties.get(key);
	}

	public void setProperty(PropertyData value) {
	    this.setProperty(value.getKeyName(), value);
	}

	public void setProperty(String key, PropertyData value) {
	    if (this.properties == null) {
	      this.properties = new HashMap<String, PropertyData>();
	    }
	    this.properties.put(key, value);
	}

	/**
	 * @return the tariffs
	 */
	public List<Tariff> getTariffs() {
		return tariffs;
	}

	/**
	 * @param tariffs
	 *            the tariffs to set
	 */
	public void setTariffs(List<Tariff> tariffs) {
		this.tariffs = tariffs;
	}	
	
	public CustomerClass getCustomerClass() {
      return customerClass;
    }
	
	public void setCustomerClass(CustomerClass customerClass) {
      this.customerClass = customerClass;
    }
	
}
