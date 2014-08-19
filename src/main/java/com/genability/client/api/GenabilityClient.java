package com.genability.client.api;

import org.apache.http.impl.client.CloseableHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genability.client.api.service.AccountService;
import com.genability.client.api.service.BaseService;
import com.genability.client.api.service.BulkUploadService;
import com.genability.client.api.service.CalculateService;
import com.genability.client.api.service.LseService;
import com.genability.client.api.service.PriceService;
import com.genability.client.api.service.ProfileService;
import com.genability.client.api.service.TariffService;
import com.genability.client.api.service.TypicalService;

public class GenabilityClient {

  private String appId;
  private String appKey;
  private String restApiServer;
  private ObjectMapper mapper;
  private CloseableHttpClient httpClient;

  public GenabilityClient() {
  }

  public GenabilityClient(String appId, String appKey) {
    this.appId = appId;
    this.appKey = appKey;
  }

  public GenabilityClient(String appId, String appKey, String restApiServer) {
    this.appId = appId;
    this.appKey = appKey;
    this.restApiServer = restApiServer;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getAppKey() {
    return appKey;
  }

  public void setAppKey(String appKey) {
    this.appKey = appKey;
  }

  public String getRestApiServer() {
    return restApiServer;
  }

  public void setRestApiServer(String restApiServer) {
    this.restApiServer = restApiServer;
  }

  public ObjectMapper getMapper() {
    return mapper;
  }

  public void setMapper(ObjectMapper mapper) {
    this.mapper = mapper;
  }

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

  protected <S extends BaseService> S initializeService(S service) {
    service.setAppId(appId);
    service.setAppKey(appKey);
    if (restApiServer != null) {
      service.setRestApiServer(restApiServer);
    }
    if (mapper != null) {
      service.setMapper(mapper);
    }
    if (httpClient != null) {
      service.setHttpClient(httpClient);
    }
    return service;
  }

  public AccountService getAccountService() {
    return initializeService(new AccountService());
  }

  public BulkUploadService getBulkUploadService() {
    return initializeService(new BulkUploadService());
  }

  public CalculateService getCalculateService() {
    return initializeService(new CalculateService());
  }

  public LseService getLseService() {
    return initializeService(new LseService());
  }

  public PriceService getPriceService() {
    return initializeService(new PriceService());
  }

  public ProfileService getProfileService() {
    return initializeService(new ProfileService());
  }

  public TariffService getTariffService() {
    return initializeService(new TariffService());
  }

  public TypicalService getTypicalService() {
    return initializeService(new TypicalService());
  }

}
