package com.genability.client.types;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

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
}
