package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Address {

	private String addressString;
	private String addressName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private Double latitude;
	private Double longitude;
	
	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder {
		
		private String addressString;
		private String addressName;
		private String address1;
		private String address2;
		private String city;
		private String state;
		private String zipCode;
		private String country;
		private Double latitude;
		private Double longitude;
		
		public Builder setAddressString(String addressString) {
			this.addressString = addressString;
			return this;
		}
		
		public Builder setAddressName(String addressName) {
			this.addressName = addressName;
			return this;
		}
		
		public Builder setAddress1(String address1) {
			this.address1 = address1;
			return this;
		}
		
		public Builder setAddress2(String address2) {
			this.address2 = address2;
			return this;
		}
		
		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public Builder setState(String state) {
			this.state = state;
			return this;
		}
		
		public Builder setZipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}
		
		public Builder setCountry(String country) {
			this.country = country;
			return this;
		}
		
		public Builder setLatitude(Double latitude) {
			this.latitude = latitude;
			return this;
		}
		
		public Builder setLongitude(Double longitude) {
			this.longitude = longitude;
			return this;
		}
		
		public Address build() {
			Address a = new Address();
			
			a.setAddressString(addressString);
			a.setAddressName(addressName);
			a.setAddress1(address1);
			a.setAddress2(address2);
			a.setCity(city);
			a.setState(state);
			a.setZipCode(zipCode);
			a.setCountry(country);
			a.setLatitude(latitude);
			a.setLongitude(longitude);
			
			return a;
		}
	}
	
	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("zip")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("lat")
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("lon")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
