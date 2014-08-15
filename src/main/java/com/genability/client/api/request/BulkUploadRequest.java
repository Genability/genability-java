/**
 * 
 */
package com.genability.client.api.request;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

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
	 * @param usageProfileId
	 *            the usageProfileId to set
	 */
	public void setUsageProfileId(String usageProfileId) {
		this.usageProfileId = usageProfileId;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	@Override
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();
		
		return qparams;
		
	}	
}
