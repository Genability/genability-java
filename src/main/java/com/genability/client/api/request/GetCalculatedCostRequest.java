package com.genability.client.api.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.genability.client.types.PropertyData;
import org.apache.http.NameValuePair;
import org.joda.time.DateTime;
import org.codehaus.jackson.annotate.JsonIgnore;


public class GetCalculatedCostRequest extends AbstractRequest implements Serializable {

	/**
	 * Private member variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long masterTariffId_;

	/**
	 * Private member variable territoryId
	 */
	private Long territoryId_;

	/**
	 * Private member variable profileId
	 */
	private String profileId_;

	/**
	 * Private member variable fromDate
	 */
	private DateTime fromDateTime_;

	/**
	 * Private member variable toDate
	 */
	private DateTime toDateTime_;

	/**
	 * Private member variable TariffInputs_
	 */
	private List<PropertyData> tariffInputs_;

	/**
	 * Private member variable detailLevel_
	 * Possible values are: ALL, TOTAL, CHARGE_TYPE, RATE
	 * Default is ALL if not specified.
	 */
	private String detailLevel_;

	/**
	 * Private member variable estimate_
	 */
	private String accuracy;
	
	/**
	 * Beta property to hide assumptions until we are ready to roll out.
	 */
	private Boolean betaPopulateAssumptions;

	/**
	 * Private member variable dataFactor_
	 */
	private BigDecimal dataFactor_;

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
		return profileId_;
	}

	/**
	 * Mutator used to set the value of profileId_
	 * 
	 * @param profileId
	 */
	public void setProfileId(String profileId) {
		profileId_ = profileId;
	}

	/**
	 * Access method that retrieve territoryId_
	 * 
	 * @return territoryId_
	 */
	public Long getTerritoryId() {
		return territoryId_;
	}

	/**
	 * Mutator used to set the value of territoryId_
	 * 
	 * @param territoryId
	 */
	public void setTerritoryId(Long territoryId) {
		territoryId_ = territoryId;
	}

	/**
	 * Access method that retrieve fromDateTime_
	 * 
	 * @return fromDateTime_
	 */
	public DateTime getFromDateTime() {
		return fromDateTime_;
	}

	/**
	 * Mutator used to set the value of fromDateTime_
	 * 
	 * @param fromDate
	 */
	public void setFromDateTime(DateTime fromDate) {
		fromDateTime_ = fromDate;
	}

	/**
	 * Access method that retrieve toDateTime_
	 * 
	 * @return toDateTime_
	 */
	public DateTime getToDateTime() {
		return toDateTime_;
	}

	/**
	 * Mutator used to set the value of toDateTime_
	 * 
	 * @param toDate
	 */
	public void setToDateTime(DateTime toDate) {
		toDateTime_ = toDate;
	}

	/**
	 * Access method that retrieve tariffInputs_
	 * 
	 * @return tariffInputs_
	 */
	public List<PropertyData> getTariffInputs() {
		return tariffInputs_;
	}

	/**
	 * Mutator used to set the value of tariffInputs_
	 * 
	 * @param propertyDatas
	 */
	public void setTariffInputs(List<PropertyData> propertyDatas) {
		tariffInputs_ = propertyDatas;
	}

	/**
	 * @param detailLevel_
	 *            the detailLevel_ to set
	 */
	public void setDetailLevel(String detailLevel) {
		this.detailLevel_ = detailLevel;
	}

	/**
	 * @return the detailLevel_
	 */
	public String getDetailLevel() {
		return detailLevel_;
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

	public BigDecimal getDataFactor() {
		return dataFactor_;
	}

	public void setDataFactor(BigDecimal dataFactor) {
		dataFactor_ = dataFactor;
	}
	
	public Boolean getBetaPopulateAssumptions() {
		return betaPopulateAssumptions;
	}

	public void setBetaPopulateAssumptions(Boolean betaPopulateAssumptions) {
		this.betaPopulateAssumptions = betaPopulateAssumptions;
	}
	
	public void setMasterTariffId(Long masterTariffId) {
		masterTariffId_ = masterTariffId;
	}
	
	@JsonIgnore
	public Long getMasterTariffId() {
		return masterTariffId_;
	}

	public void addTariffInput(PropertyData tariffInput) {
		if (tariffInputs_ == null || tariffInputs_.size() ==0) {
			tariffInputs_ = new ArrayList<PropertyData>();
		}
		tariffInputs_.add(tariffInput);
	}
	
	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		addParam(qparams,"masterTariffId",masterTariffId_);
		return qparams;
		
	}	
}
