package com.genability.client.types;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountsAnalysisOutput {

    public static final String REST_TYPE = "AccountAnalysis";

    private String designId;

    private Integer dataStatus;

    private List<Scenario> scenarios;

    private List<Series> series;

    private List<SeriesData> seriesData;

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(final String designId) {
        this.designId = designId;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(final Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(final List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(final List<Series> series) {
        this.series = series;
    }

    public List<SeriesData> getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(final List<SeriesData> seriesData) {
        this.seriesData = seriesData;
    }
}
