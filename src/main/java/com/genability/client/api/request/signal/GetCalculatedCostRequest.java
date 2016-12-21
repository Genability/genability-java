package com.genability.client.api.request.signal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genability.client.api.request.AbstractRequest;
import com.genability.client.types.*;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;


@JsonInclude(Include.NON_NULL)
public class GetCalculatedCostRequest extends AbstractRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long masterTariffId;
    private DateTime fromDateTime;
    private DateTime toDateTime;
    private List<PropertyData> propertyInputs;
    private Map<String, BigDecimal> expected;
    private Boolean billingPeriod;
    private DetailLevel detailLevel;
    private GroupBy groupBy;
    private Boolean minimums;
    private String excludeChargeClass;
    private Boolean applyUtilityTax;
    private Address address;
    private Boolean autoBaseline;
    private Boolean useIntelligentBaselining;
    private Boolean calcNetExcessGeneration;
    private DateTime tariffEffectiveOn;
    private List<TariffRate> rateInputs;


    public Long getMasterTariffId() {
        return masterTariffId;
    }

    public void setMasterTariffId(Long masterTariffId) {
        this.masterTariffId = masterTariffId;
    }

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

    public List<PropertyData> getPropertyInputs() {
        return propertyInputs;
    }

    public void setPropertyInputs(List<PropertyData> propertyInputs) {
        this.propertyInputs = propertyInputs;
    }

    public void addPropertyInput(PropertyData propertyInput) {
        if (propertyInputs == null) {
            propertyInputs = new ArrayList<PropertyData>();
        }

        propertyInputs.add(propertyInput);
    }

    public void addPropertyInputs(Collection<PropertyData> propertyInputs) {
        if (this.propertyInputs == null) {
            this.propertyInputs = new ArrayList<PropertyData>();
        }

        this.propertyInputs.addAll(propertyInputs);
    }

    public Map<String, BigDecimal> getExpected() {
        return expected;
    }

    public void setExpected(Map<String, BigDecimal> expected) {
        this.expected = expected;
    }

    public void addExpected(String key, BigDecimal value) {
        if (expected == null) {
            expected = new HashMap<String, BigDecimal>();
        }

        expected.put(key, value);
    }

    public void addExpected(Map<String, BigDecimal> expected) {
        if (this.expected == null) {
            this.expected = new HashMap<String, BigDecimal>();
        }

        this.expected.putAll(expected);
    }

    @JsonInclude(Include.NON_NULL)
    public Boolean getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(Boolean billingPeriod) {
        this.billingPeriod = billingPeriod;
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

    public Boolean getAutoBaseline() {
        return autoBaseline;
    }

    public void setAutoBaseline(Boolean useMostRecentUsageData) {
        this.autoBaseline = useMostRecentUsageData;
    }

    public Boolean getUseIntelligentBaselining() {
        return useIntelligentBaselining;
    }

    public void setUseIntelligentBaselining(Boolean useIntelligentBaselining) {
        this.useIntelligentBaselining = useIntelligentBaselining;
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

    public List<TariffRate> getRateInputs() {
        return rateInputs;
    }

    public void setRateInputs(List<TariffRate> rateInputs) {
        this.rateInputs = rateInputs;
    }

    public void addRateInput(TariffRate rateInput) {
        if (rateInputs == null) {
            rateInputs = new ArrayList<TariffRate>();
        }

        rateInputs.add(rateInput);
    }

    public void addRateInputs(Collection<TariffRate> rateInputs) {
        if (this.rateInputs == null) {
            this.rateInputs = new ArrayList<TariffRate>();
        }

        this.rateInputs.addAll(rateInputs);
    }
}
