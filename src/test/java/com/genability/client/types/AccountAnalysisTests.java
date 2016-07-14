package com.genability.client.types;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.genability.client.api.service.GenabilityException;

public class AccountAnalysisTests {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private AccountAnalysis testAnalysisWithCosts;
	private AccountAnalysis testAnalysisNoCosts;
	private static final TypeReference<Response<AccountAnalysis>> ACCOUNT_ANALYSIS_RESPONSE_TYPEREF =
            new TypeReference<Response<AccountAnalysis>>() {};

    private ObjectMapper mapper; 
	    
	@Before
	public void openExampleAnalyses() {
		createMapper();
		Response<AccountAnalysis> responseWithCosts = loadJsonFixture("account_analysis_withcosts.json",
				ACCOUNT_ANALYSIS_RESPONSE_TYPEREF);
		
		Response<AccountAnalysis> responseNoCosts = loadJsonFixture("account_analysis_nocosts.json",
				ACCOUNT_ANALYSIS_RESPONSE_TYPEREF);
		
		testAnalysisWithCosts = responseWithCosts.getResults().get(0);
		testAnalysisNoCosts = responseNoCosts.getResults().get(0);
	}
	
	private void createMapper() {
		mapper = new ObjectMapper();
	    mapper.registerModule(new JodaModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    mapper.setSerializationInclusion(Include.NON_NULL);
	}
	
	@Test
    public void testGetValidSeriesByParameters() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters("before", "MONTH", null);
    	
    	assertEquals("Got the wrong series scenario", "before", series.getScenario());
    	assertEquals("Got the wrong series period", "MONTH", series.getSeriesPeriod());
    }
    
    @Test
    public void testGetSeriesByInvalidParameters() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters("before", "100", null);
    	
    	assertNull(series);
    }
    
    @Test
    public void testGetSeriesByOneNullParameter() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters("before", null, null);
    	
    	assertNull(series);
    }
    
    @Test
    public void testGetSeriesByTwoNullParameters() {
    	Series series = testAnalysisWithCosts.getSeriesByParameters(null, null, null);
    	
    	assertNull(series);
    }
    
    @Test
    public void testGetSeriesDataByGoodId() {
    	Integer seriesId = new Integer(1);
    	List<SeriesMeasure> measures = testAnalysisWithCosts.getSeriesDataBySeriesId(seriesId);
    	
    	for (SeriesMeasure measure : measures) {
    		assertEquals("Got data for the wrong series", seriesId, measure.getSeriesId());
    	}
    }
    
    @Test
    public void testGetSeriesDataByBadId() {
    	Integer seriesId = new Integer(150);
    	List<SeriesMeasure> measures = testAnalysisWithCosts.getSeriesDataBySeriesId(seriesId);
    	
    	assertEquals("Got measures for an invalid seriesId", 0, measures.size());
    }
    
    @Test
    public void testGetCostsByGoodSeriesName() {
    	Long beforeMtid = new Long(525);
    	Long afterMtid = new Long(522);
    	CalculatedCost before = testAnalysisWithCosts.getSeriesCostsByParameters("before", "MONTH", null);
    	CalculatedCost after = testAnalysisWithCosts.getSeriesCostsByParameters("after", "MONTH", null);
    	
    	assertEquals("Got the wrong scenario for before", beforeMtid, before.getMasterTariffId());
    	assertEquals("Got the wrong scenario for after", afterMtid, after.getMasterTariffId());
    }
    
    @Test
    public void testGetCostsByNonExistentSeriesName() {
    	CalculatedCost costs = testAnalysisWithCosts.getSeriesCostsByParameters("invalid", "MONTH", null);
    	
    	assertNull(costs);
    }
    
    @Test
    public void testGetCostsForBeforeAnnual() {
    	CalculatedCost costs = testAnalysisWithCosts.getSeriesCostsByParameters("before", "YEAR", null);
    	
    	assertNull(costs);
    }
    
    @Test
    public void testGetCostsByNameWithNoCosts() {
    	CalculatedCost costs = testAnalysisWithCosts.getSeriesCostsByParameters("solar", "MONTH", null);
    	
    	assertNull(costs);
    }
    
    @Test
    public void testGetCostsWhenNoCosts() {
    	CalculatedCost before = testAnalysisNoCosts.getSeriesCostsByParameters("before", "MONTH", null);
    	
    	assertNull(before);
    }
	
	protected <T> T loadJsonFixture(String fileName, TypeReference<T> resultTypeReference) {
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
			return mapper.readValue(is, resultTypeReference);
		} catch (JsonParseException e) {
			log.error("JsonParseException in fixture " + fileName);
			throw new GenabilityException(e);
		} catch (JsonMappingException e) {
			log.error("JsonMappingException in fixture " + fileName);
			throw new GenabilityException(e);
		} catch (IOException e) {
			log.error("Couldn't open fixture " + fileName);
			throw new GenabilityException(e);
		}
	}
}