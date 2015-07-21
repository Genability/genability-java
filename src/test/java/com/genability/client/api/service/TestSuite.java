package com.genability.client.api.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.genability.client.api.request.AccountAnalysisRequestTests;
import com.genability.client.api.request.GetTariffRequestTests;
import com.genability.client.types.ReadingDataTests;
import com.genability.client.types.TimeOfUseTypeTests;

@RunWith(Suite.class)
@SuiteClasses({
  AccountAnalysisServiceTests.class,
  AccountAnalysisRequestTests.class,
  AccountServiceTests.class,
  BulkUploadTests.class,
  CalculateServiceTests.class,
  CalendarServiceTests.class,
  GetTariffRequestTests.class,
  LseServiceTests.class,
  PriceServiceTests.class,
  ProfileServiceTests.class,
  PropertyServiceTests.class,
  ReadingDataTests.class,
  TariffServiceTests.class,
  TerritoryServiceTests.class,
  TimeOfUseTypeTests.class,
  TypicalServiceTests.class,
})
public class TestSuite {

}
