package com.genability.client.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.genability.client.types.PropertyData;
import org.apache.http.NameValuePair;
import org.joda.time.DateTime;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.genability.client.util.DateTimeJsonSerializer;

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
	 * Private member variable detailLevel_
	 * Possible values are: ALL, TOTAL, CHARGE_TYPE, RATE
	 * Default is ALL if not specified.
	 */
	private String detailLevel;

	/**
	 * Private member variable estimate_
	 */
	private String accuracy;

	/**
	 * Private member variable accountId
	 */
	private String accountId;
	
	/**
	 * Constructor to initialize instance
	 */
	public GetCalculatedCostRequest() {

	}

	/**
	 * Access method that retrieve profileId_
	 * 
	 * @return profileId
	 */
	public String getProfileId() {
		return profileId;
	}

	/**
	 * Mutator used to set the value of profileId_
	 * 
	 * @param profileId
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	/**
	 * Access method that retrieve fromDateTime
	 * 
	 * @return fromDateTime
	 */
	@JsonSerialize(using=DateTimeJsonSerializer.class) 
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
	@JsonSerialize(using=DateTimeJsonSerializer.class) 
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
	 * @param detailLevel_
	 *            the detailLevel_ to set
	 */
	public void setDetailLevel(String detailLevel) {
		this.detailLevel = detailLevel;
	}

	/**
	 * @return the detailLevel
	 */
	public String getDetailLevel() {
		return detailLevel;
	}

	/**
	 * @return the estimate
	 */
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

	
	public void setMasterTariffId(Long masterTariffId) {
		this.masterTariffId = masterTariffId;
	}
	
	@JsonIgnore
	public Long getMasterTariffId() {
		return masterTariffId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountId() {
		return accountId;
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
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		addParam(qparams,"masterTariffId",masterTariffId);
		addParam(qparams,"betaPopulateAssumptions",true);
		return qparams;
		
	}	
}
