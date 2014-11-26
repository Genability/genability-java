package com.genability.client.api.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  AccountAnalysisTests.class,
  AccountServiceTests.class,
  BulkUploadTests.class,
  CalculateServiceTests.class,
  CalendarServiceTests.class,
  LseServiceTests.class,
  PriceServiceTests.class,
  ProfileServiceTests.class,
  PropertyServiceTests.class,
  TariffServiceTests.class,
  TypicalServiceTests.class,
})
public class TestSuite {

}
