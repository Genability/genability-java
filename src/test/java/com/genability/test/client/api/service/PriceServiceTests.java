package com.genability.test.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import com.genability.client.api.request.GetPriceRequest;
import com.genability.client.api.service.PriceService;
import com.genability.client.api.service.TariffService;
import com.genability.client.types.Price;
import com.genability.client.types.PriceChange;
import com.genability.client.types.Response;

public class PriceServiceTests extends BaseServiceTests {


	private static PriceService priceService;
	
	private static TariffService tariffService;

	@BeforeClass
	public static void runBeforeClass() {

		tariffService = new TariffService();
		tariffService.setAppId(appId);
		tariffService.setAppKey(appKey);
		if(restApiServer != null) tariffService.setRestApiServer(restApiServer);
		
		priceService = new PriceService();
		priceService.setAppId(appId);
		priceService.setAppKey(appKey);
		if(restApiServer != null) priceService.setRestApiServer(restApiServer);

	}


	@Test
	public void testGetPrice() {

		GetPriceRequest request = new GetPriceRequest();

		request.setMasterTariffId(520l);//PGE residential tariff
		request.setFromDateTime(DateTime.now());
		request.setToDateTime(request.getFromDateTime().plusDays(1));

		Response<Price> restResponse = priceService.getPrice(request);

		assertNotNull("restResponse null", restResponse);
		assertEquals("bad status", Response.STATUS_SUCCESS, restResponse.getStatus());
		assertEquals("bad type",Price.REST_TYPE,restResponse.getType());
		assertNotNull("results null",restResponse.getResults());

		for(Price price : restResponse.getResults()) {

			assertNotNull("price null",price);


			if(price.getPriceChanges() != null ) {

				for(PriceChange priceChange : price.getPriceChanges()) {

					log.debug("Price Change " + priceChange.getChangeName());

					assertNotNull("priceChange null",priceChange);

				}
			}

		}

	}


}

