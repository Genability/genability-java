package com.genability.client.api.request.signal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genability.client.api.request.AbstractRequest;
import com.genability.client.types.Address;
import com.genability.client.types.DetailLevel;
import com.genability.client.types.GroupBy;
import com.genability.client.types.signal.Scenario;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMassCalculatedCostRequest extends AbstractRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private DateTime fromDateTime;
    private DateTime toDateTime;
    private DetailLevel detailLevel;
    private GroupBy groupBy;
    private Boolean billingPeriod;
    private List<Scenario> scenarios;
    private Scenario sharedScenario;
    private Boolean applyUtilityTax;
    private Address address;
    private Boolean minimums;
    private String excludeChargeClass;
    private Boolean calcNetExcessGeneration;
    private DateTime tariffEffectiveOn;


    public DateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(DateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public DateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(DateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    @JsonInclude(Include.NON_NULL)
    public DetailLevel getDetailLevel() {
        return detailLevel;
    }

    public void setDetailLevel(DetailLevel detailLevel) {
        this.detailLevel = detailLevel;
    }

    @JsonInclude(Include.NON_NULL)
    public GroupBy getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(GroupBy groupBy) {
        this.groupBy = groupBy;
    }

    @JsonInclude(Include.NON_NULL)
    public Boolean getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(Boolean billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public void addScenario(Scenario scenario) {
        if (scenarios == null) {
            scenarios = new ArrayList<Scenario>();
        }

        scenarios.add(scenario);
    }

    public void addScenarios(Collection<Scenario> scenarios) {
        if (this.scenarios == null) {
            this.scenarios = new ArrayList<Scenario>();
        }

        this.scenarios.addAll(scenarios);
    }

    public Scenario getSharedScenario() {
        return sharedScenario;
    }

    public void setSharedScenario(Scenario sharedScenario) {
        this.sharedScenario = sharedScenario;
    }

    @JsonInclude(Include.NON_NULL)
    public Boolean getApplyUtilityTax() {
        return applyUtilityTax;
    }

    public void setApplyUtilityTax(Boolean applyUtilityTax) {
        this.applyUtilityTax = applyUtilityTax;
    }

    @JsonInclude(Include.NON_NULL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonInclude(Include.NON_NULL)
    public Boolean getMinimums() {
        return minimums;
    }

    public void setMinimums(Boolean minimums) {
        this.minimums = minimums;
    }

    @JsonInclude(Include.NON_NULL)
    public String getExcludeChargeClass() {
        return excludeChargeClass;
    }

    public void setExcludeChargeClass(String excludeChargeClass) {
        this.excludeChargeClass = excludeChargeClass;
    }

    @JsonInclude(Include.NON_NULL)
    public Boolean getCalcNetExcessGeneration() {
        return calcNetExcessGeneration;
    }

    public void setCalcNetExcessGeneration(Boolean calcNetExcessGeneration) {
        this.calcNetExcessGeneration = calcNetExcessGeneration;
    }

    @JsonInclude(Include.NON_NULL)
    public DateTime getTariffEffectiveOn() {
        return tariffEffectiveOn;
    }

    public void setTariffEffectiveOn(DateTime tariffEffectiveOn) {
        this.tariffEffectiveOn = tariffEffectiveOn;
    }
}
