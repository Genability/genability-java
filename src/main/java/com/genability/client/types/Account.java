package com.genability.client.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder {

		private String accountId;
		private String providerAccountId;
		private String accountName;

		private String customerOrgId;
		private String customerOrgName;	
		private CustomerClass customerClass;	

		private AccountStatus status;
		private AccountType type;
		private Address address;

		private List<Tariff> tariffs;	
		private Map<String, PropertyData> properties;
		
		public Builder setAccountId(String accountId) {
			this.accountId = accountId;
			return this;
		}
		
		public Builder setProviderAccountId(String providerAccountId) {
			this.providerAccountId = providerAccountId;
			return this;
		}
		
		public Builder setAccountName(String accountName) {
			this.accountName = accountName;
			return this;
		}
		
		public Builder setCustomerOrgId(String customerOrgId) {
			this.customerOrgId = customerOrgId;
			return this;
		}
		
		public Builder setCustomerOrgName(String customerOrgName) {
			this.customerOrgName = customerOrgName;
			return this;
		}
		
		public Builder setCustomerClass(CustomerClass customerClass) {
			this.customerClass = customerClass;
			return this;
		}
		
		public Builder setStatus(AccountStatus status) {
			this.status = status;
			return this;
		}
		
		public Builder setType(AccountType type) {
			this.type = type;
			return this;
		}
		
		public Builder setAddress(Address address) {
			this.address = address;
			return this;
		}
		
		public Builder setTariffs(List<Tariff> tariffs) {
			this.tariffs = tariffs;
			return this;
		}
		
		public Builder setProperties(Map<String, PropertyData> properties) {
			this.properties = properties;
			return this;
		}
		
		public Builder addProperty(String keyName, PropertyData data) {
			if (properties == null) {
				properties = new HashMap<String, PropertyData>();
			}
			
			properties.put(keyName, data);
			return this;
		}
		
		/**
		 * Add a new property to the account. This property will be of the form:
		 * <pre>
		 * "properties": {
		 *   "keyName": {
		 *     "keyName": "keyName",
		 *     "dataValue": "dataValue"
		 *   }
		 * }
		 * </pre>
		 */
		public Builder addProperty(String keyName, String dataValue) {
			if (properties == null) {
				properties = new HashMap<String, PropertyData>();
			}
			
			properties.put(keyName, PropertyData.newBuilder()
					.setKeyName(keyName)
					.setDataValue(dataValue)
					.build());
			
			return this;
		}
		
		public Account build() {
			Account a = new Account();
			
			a.setAccountId(accountId);
			a.setProviderAccountId(providerAccountId);
			a.setAccountName(accountName);
			a.setCustomerOrgId(customerOrgId);
			a.setCustomerOrgName(customerOrgName);
			a.setCustomerClass(customerClass);
			a.setStatus(status);
			a.setType(type);
			a.setAddress(address);
			a.setTariffs(tariffs);
			a.setProperties(properties);
			
			return a;
		}
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getProviderAccountId() {
		return providerAccountId;
	}

	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCustomerOrgId() {
		return customerOrgId;
	}

	public void setCustomerOrgId(String customerOrgId) {
		this.customerOrgId = customerOrgId;
	}

	public String getCustomerOrgName() {
		return customerOrgName;
	}

	public void setCustomerOrgName(String customerOrgName) {
		this.customerOrgName = customerOrgName;
	}

	@Deprecated
	public String getOwner() {
      return owner;
    }
	
	@Deprecated
	public void setOwner(String owner) {
      this.owner = owner;
    }
	
	public AccountStatus getStatus() {
		return status;
	}

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

	public List<Tariff> getTariffs() {
		return tariffs;
	}

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
