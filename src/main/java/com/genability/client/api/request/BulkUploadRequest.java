/**
 * 
 */
package com.genability.client.api.request;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BulkUploadRequest extends AbstractRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * private member variable for UsageProfileId
	 */
	private String usageProfileId;
	/**
	 * private member variable for Name
	 */
	private String name;
	
	private String fileFormat;
	
	private File fileData;
	
	private String contentType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	
	public File getFileData() {
		return fileData;
	}

	public void setFileData(File file) {
		this.fileData = file;
	}

	/**
	 * @return the usageProfileId_
	 */
	public String getUsageProfileId() {
		return usageProfileId;
	}

	/**
	 * @param usageProfileId The usageProfileId.
	 *            the usageProfileId to set
	 */
	public void setUsageProfileId(String usageProfileId) {
		this.usageProfileId = usageProfileId;
	}
	
	public String getProfileId() {
		return usageProfileId;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public Map<String, String> getFormFields() {
		Map<String, String> fields = new HashMap<String, String>();
		
		fields.put("profileName", getName());
		fields.put("profileId", getProfileId());
		
		return fields;
	}
}
