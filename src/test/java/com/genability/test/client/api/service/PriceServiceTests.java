package com.genability.test.client.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import com.genability.client.api.request.GetPriceRequest;
import com.genability.client.api.service.PriceService;
import com.genability.client.types.Price;
import com.genability.client.types.PriceChange;
import com.genability.client.types.Response;

public class PriceServiceTests extends BaseServiceTests {


	private static PriceService priceService;

	@BeforeClass
	public static void runBeforeClass() {

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

			log.debug("Price " + price.getName());


			if(price.getPriceChanges() != null ) {

				for(PriceChange priceChange : price.getPriceChanges()) {

					log.debug("Price Change " + priceChange.getChangeName());

					assertNotNull("priceChange null",priceChange);

				}
			}

		}

	}

	/*
	@Test
	private void dumpToFile() {

		GetPriceRequest request = new GetPriceRequest();

		request.setMasterTariffId(520l);//PGE residential tariff
		request.setFromDateTime(DateTime.now());
		request.setToDateTime(request.getFromDateTime().plusDays(1));
		
		Response<Price> restResponse = priceService.getPrice(request);
		

		try{
			// Create file 
			FileWriter fstream = new FileWriter("price_dump.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			String headerRow = "masterTariffId" 
					+ ",\"" + "chargeType" 
					+ "\"," + "fromDateTime" 
					+ "," + "rateAmount"
					+ ",\"" + "name" + "\"";
					
			log.debug("Header " + headerRow);
			
			out.write(headerRow);
			out.newLine();
			
			for(Price price : restResponse.getResults()) {
				
				String priceRow = price.getTariffId() 
						+ ",\"" + price.getChargeType() 
						+ "\"," + price.getFromDateTime() 
						+ "," + price.getRateAmount()
						+ ",\"" + price.getName() + "\"";
						
				log.debug("Price " + priceRow);
				
				out.write(priceRow);
				out.newLine();

				if(price.getPriceChanges() != null ) {

					for(PriceChange priceChange : price.getPriceChanges()) {

						String priceChangeRow = price.getTariffId() 
								+ ",\"" + price.getChargeType() 
								+ "\"," + priceChange.getChangeDateTime() 
								+ "," + priceChange.getRateAmount()
								+ ",\"" + priceChange.getChangeName() + "\"";
						
						log.debug("Price Change " + priceChangeRow);
						
						out.write(priceChangeRow);
						out.newLine();
					}
				}

			}
			
			//Close the output stream
			out.close();
		} catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	*/


}

