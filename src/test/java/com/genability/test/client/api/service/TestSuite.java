package com.genability.test.client.api.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  AccountServiceTests.class,
  BulkUploadTests.class,
  CalculateServiceTests.class,
  LseServiceTests.class,
  PriceServiceTests.class,
  ProfileServiceTests.class,
  TariffServiceTests.class
})
public class TestSuite {

}
