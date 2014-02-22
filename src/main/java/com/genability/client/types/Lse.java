package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lse {
	
	public static final String REST_TYPE = "LoadServingEntity";

	
	private Long lseId;

	private String name;

	private String code;
	
	private String websiteHome ;

	
	public Long getLseId() {
      return lseId;
    }

	public void setLseId(Long lseId) {
      this.lseId = lseId;
    }

	public String getName() {
      return name;
    }

	public void setName(String name) {
      this.name = name;
    }

	public String getCode() {
      return code;
    }

	public void setCode(String code) {
      this.code = code;
    }

	public String getWebsiteHome() {
      return websiteHome;
    }

	public void setWebsiteHome(String websiteHome) {
      this.websiteHome = websiteHome;
	}

}
