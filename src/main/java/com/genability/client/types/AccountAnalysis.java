package com.genability.client.types;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountAnalysis {
    public static final String REST_TYPE = "AccountAnalysis";

    private String designId;
    private Integer dataStatus;
    private List<Scenario> scenarios;
    private List<Series> series;
    private List<SeriesMeasure> seriesData;
    private Map<String, BigDecimal> summary;
    private Map<Integer, CalculatedCost> seriesCosts;


    /**
     * This allows you access to the Series that you're interested in. E.g.
     *
     *    Series monthlyPreSolarUtilitySeries = accountAnalysis.getSeriesByParameters("before", "MONTH", null);
     *    // check that monthlyPreSolarUtilitySeries != null, then proceed
     * 
     * Note that the key parameter is not used at this time.
     * 
     * @param scenario The scenario.
     * @param period The period.
     * @param key The key.
     * @return The return value.
     */
    @JsonIgnore
    public Series getSeriesByParameters(String scenario, String period, String key) {

        if (this.series == null) return null;

        if (scenario == null || period == null) return null;

        if (key != null && key.isEmpty()) key = null;

        for (Series s : this.series) {
            if (s.getScenario().equalsIgnoreCase(scenario)
                && s.getSeriesPeriod().equalsIgnoreCase(period)
                    && ((key == null && s.getKey() == null) || (key != null && key.equalsIgnoreCase(s.getKey()))))
                        return s;
        }

        return null;
    }

    /**
     * This allows you access to the SeriesData that you're interested in. E.g.
     *
     *    Series monthlyPreSolarUtilitySeries = accountAnalysis.getSeriesByParameters("before", "MONTH", null);
     *    if (monthlyPreSolarUtilitySeries == null) throw SomeException();
     *
     *    Integer seriesId = monthlyPreSolarUtilitySeries.getSeriesId();
     *    List&lt;SeriesMeasure&gt; monthlyPreSolarUtilitySeriesData = accountAnalysis.getSeriesDataBySeriesId(seriesId);
     *    // check that monthlyPreSolarUtilitySeriesData != null, then proceed
     *    
     * @param seriesId The seriesId.
     * @return The return value.
     */
    @JsonIgnore
    public List<SeriesMeasure> getSeriesDataBySeriesId(Integer seriesId) {

        if (this.seriesData == null) return null;

        List<SeriesMeasure> filteredSeriesData = new ArrayList<SeriesMeasure>();

        for (SeriesMeasure sm : this.seriesData) {
            if (seriesId.equals(sm.getSeriesId())) {
                filteredSeriesData.add(sm);
            }
        }

        return filteredSeriesData;
    }
    
    @JsonIgnore
    public CalculatedCost getSeriesCostsByParameters(String scenario, String period, String key) {
    	if (seriesCosts == null) {
    		return null;
    	}
    	
    	Series s = getSeriesByParameters(scenario, period, key);
    	
    	if (s == null) {
    		return null;
    	}
    	
    	return seriesCosts.get(s.getSeriesId());
    }
    
    @JsonIgnore
    public CalculatedCost getSeriesCostsBySeriesId(int seriesId) {
    	if (seriesCosts == null) {
    		// if the populateCosts parameter wasn't populated
    		return null;
    	} else {
    		return seriesCosts.get(seriesId);
    	}
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    public List<SeriesMeasure> getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(List<SeriesMeasure> seriesData) {
        this.seriesData = seriesData;
    }

    public Map<String, BigDecimal> getSummary() {
        return summary;
    }

    public void setSummary(Map<String, BigDecimal> summary) {
        this.summary = summary;
    }

	public Map<Integer, CalculatedCost> getSeriesCosts() {
		return seriesCosts;
	}

	public void setSeriesCosts(Map<Integer, CalculatedCost> seriesCosts) {
		this.seriesCosts = seriesCosts;
	}
}
