package com.genability.client.api.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genability.client.types.DetailLevel;
import com.genability.client.types.GroupBy;
import com.genability.client.types.PropertyData;
import com.genability.client.types.TariffRate;

@JsonInclude(Include.NON_NULL)
public class GetCalculatedCostRequest extends AbstractRequest implements Serializable {


	/**
	 * Private member variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private Long masterTariffId;
	private Long tariffRateId;
	private String profileId;
	private List<PropertyData> tariffInputs;
	private String accuracy;
	private String accountId;
	private String providerAccountId;
	private Boolean billingPeriod;
	private Boolean useMostRecentUsageData;
	private Boolean includeDefaultProfile;
	private Boolean minimums;
	private BigDecimal dataFactor;

	/**
	 * Private member variable detailLevel
	 * Possible values are: ALL, TOTAL, CHARGE_TYPE, RATE
	 * Default is ALL if not specified.
	 */
	private DetailLevel detailLevel;

	/**
	 * Private member variable groupBy
	 * Possible values are: YEAR, MONTH, etc
	 * Default is no grouping if not specified.
	 */
	private GroupBy groupBy;
	

	private List<TariffRate> rateInputs;

	/**
	 * Constructor to initialize instance
	 */
	public GetCalculatedCostRequest() {


	}

	/**
	 * Access method that retrieve fromDateTime
	 * 
	 * @return fromDateTime
	 */
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * Mutator used to set the value of fromDateTime
	 * 
	 * @param fromDate
	 */
	public void setFromDateTime(DateTime fromDate) {
		fromDateTime = fromDate;
	}

	/**
	 * Access method that retrieve toDateTime
	 * 
	 * @return toDateTime
	 */
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * Mutator used to set the value of toDateTime
	 * 
	 * @param toDate
	 */
	public void setToDateTime(DateTime toDate) {
		toDateTime = toDate;
	}

	
	/**
	 * The ID of the tariff to calculate for. Only needs to be set when
	 * not running against an account, or if you want to override the
	 * accounts tariff.
	 * @return
	 */
	@JsonInclude(Include.NON_NULL)
	public Long getMasterTariffId() {
		return masterTariffId;
	}
	
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}

	@JsonInclude(Include.NON_NULL)
	public Long getTariffRateId() {
		return tariffRateId;
	}

	public void setTariffRateId(Long tariffRateId_) {
		this.tariffRateId = tariffRateId_;
	}
	
	@JsonInclude(Include.NON_NULL)
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@JsonInclude(Include.NON_NULL)
	public String getProviderAccountId() {
    	return providerAccountId;
    }

	public void setProviderAccountId(String providerAccountId) {
    	this.providerAccountId = providerAccountId;
    }

	
	/**
	 * Access method that retrieve profileId
	 * 
	 * @return profileId
	 */
	@JsonInclude(Include.NON_NULL)
	public String getProfileId() {
		return profileId;
	}

	/**
	 * Mutator used to set the value of profileId
	 * 
	 * @param profileId
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the detailLevel
	 */
	@JsonInclude(Include.NON_NULL)
	public DetailLevel getDetailLevel() {
		return detailLevel;
	}

	/**
	 * @param detailLevel
	 *            the detailLevel to set
	 */
	public void setDetailLevel(DetailLevel detailLevel) {
		this.detailLevel = detailLevel;
	}

	/**
	 * @return the groupBy
	 */
	@JsonInclude(Include.NON_NULL)
	public GroupBy getGroupBy() {
		return groupBy;
	}

	/**
	 * @param groupBy
	 *            the groupBy to set
	 */
	public void setGroupBy(GroupBy groupBy) {
		this.groupBy = groupBy;
	}

	/**
	 * @return the estimate
	 */
	@JsonInclude(Include.NON_NULL)
	public String getAccuracy() {
		return accuracy;
	}

	/**
	 * @param estimate
	 *            the estimate to set
	 */
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}


	/**
	 * Access method that retrieve tariffInputs
	 * 
	 * @return inputs
	 */
	public List<PropertyData> getTariffInputs() {
		return tariffInputs;
	}

	/**
	 * Mutator used to set the value of tariffInputs
	 * 
	 * @param tariffInputs
	 */
	public void setTariffInputs(List<PropertyData> tariffInputs) {
		this.tariffInputs = tariffInputs;
	}

	/**
	 * Helper method for adding a PropertyData entry into the collection
	 * of inputs.
	 * 
	 * @param tariffInput
	 */
	public void addTariffInput(PropertyData tariffInput) {
		if (tariffInputs == null) {
			tariffInputs = new ArrayList<PropertyData>();
		}
		tariffInputs.add(tariffInput);
	}
	
	public void addTariffInputs(Collection<PropertyData> tariffInputs) {
		if (this.tariffInputs == null) {
			this.tariffInputs = new ArrayList<PropertyData>();
		}
		this.tariffInputs.addAll(tariffInputs);
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

	@JsonInclude(Include.NON_NULL)
	public Boolean getBillingPeriod() {
      return billingPeriod;
    }

	public void setBillingPeriod(Boolean billingPeriod) {
      this.billingPeriod = billingPeriod;
    }
	
	@JsonInclude(Include.NON_NULL)
	public Boolean getIncludeDefaultProfile() {
		return includeDefaultProfile;
	}

	public void setIncludeDefaultProfile(Boolean includeDefaultProfile) {
		this.includeDefaultProfile = includeDefaultProfile;
	}

	@JsonInclude(Include.NON_NULL)
	public Boolean getUseMostRecentUsageData() {
		return useMostRecentUsageData;
	}

	public void setUseMostRecentUsageData(Boolean useMostRecentUsageData) {
		this.useMostRecentUsageData = useMostRecentUsageData;
	}

	@JsonInclude(Include.NON_NULL)
	public Boolean getMinimums() {
		return minimums;
	}

	public void setMinimums(Boolean minimums) {
		this.minimums = minimums;
	}

	@JsonInclude(Include.NON_NULL)
	public BigDecimal getDataFactor() {
		return dataFactor;
	}

	public void setDataFactor(BigDecimal dataFactor) {
		this.dataFactor = dataFactor;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams, "fromDateTime", fromDateTime);
		addParam(qparams, "toDateTime", toDateTime);
		addParam(qparams,"betaPopulateAssumptions",true);
		return qparams;
		
	}	
}
