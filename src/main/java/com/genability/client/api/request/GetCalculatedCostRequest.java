package com.genability.client.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.genability.client.types.DetailLevel;
import com.genability.client.types.GroupBy;
import com.genability.client.types.PropertyData;
import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetCalculatedCostRequest extends AbstractRequest implements Serializable {


	/**
	 * Private member variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Private member variable fromDate
	 */
	private DateTime fromDateTime;

	/**
	 * Private member variable toDate
	 */
	private DateTime toDateTime;

	/**
	 * Private member variable masterTariffId
	 */
	private Long masterTariffId;

	/**
	 * Private member variable profileId
	 */
	private String profileId;

	/**
	 * Private member variable Inputs
	 */
	private List<PropertyData> inputs;

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
	
	/**
	 * Private member variable estimate
	 */
	private String accuracy;

	/**
	 * Private member variable accountId
	 */
	private String accountId;
	
	/**
	 * private member variable for providerAccountId
	 */
	private String providerAccountId;
	
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
	@JsonProperty("tariffInputs")
	public List<PropertyData> getInputs() {
		return inputs;
	}

	/**
	 * Mutator used to set the value of tariffInputs
	 * 
	 * @param propertyDatas
	 */
	public void setInputs(List<PropertyData> propertyDatas) {
		inputs = propertyDatas;
	}

	/**
	 * Helper method for adding a PropertyData entry into the collection
	 * of inputs.
	 * 
	 * @param input
	 */
	public void addInput(PropertyData input) {
		if (inputs == null || inputs.size() == 0) {
			inputs = new ArrayList<PropertyData>();
		}
		inputs.add(input);
	}
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams,"betaPopulateAssumptions",true);
		return qparams;
		
	}	
}
