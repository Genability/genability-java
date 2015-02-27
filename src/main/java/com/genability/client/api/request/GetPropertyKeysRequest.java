package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genability.client.types.DataType;
import com.genability.client.types.Privacy;


public class GetPropertyKeysRequest extends AbstractGetNRequest{


	private String keySpace;
	
	private String family;
	
	private DataType dataType;
	
	private Long entityId;
	
	private String entityType;
	
	private Boolean excludeGlobal;
	
	private Privacy[] privacy;
	
	
	
	public String getKeySpace() {
		return keySpace;
	}

	public void setKeySpace(String keySpace) {
		this.keySpace = keySpace;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public Boolean getExcludeGlobal() {
		return excludeGlobal;
	}

	public void setExcludeGlobal(Boolean excludeGlobal) {
		this.excludeGlobal = excludeGlobal;
	}

	public Privacy[] getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy[] privacy) {
		this.privacy = privacy;
	}




	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"keySpace", keySpace);
		addParam(qparams,"family", family);
		addParam(qparams,"dataType", dataType);
		addParam(qparams,"entityId", entityId);
		addParam(qparams,"entityType", entityType);
		addParam(qparams,"excludeGlobal", excludeGlobal);
		addParam(qparams,"privacy", privacy);
		return qparams;
		
	}


}
