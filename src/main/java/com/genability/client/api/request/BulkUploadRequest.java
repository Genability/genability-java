/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.apache.http.NameValuePair;

public class BulkUploadRequest extends AbstractRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * private member variable for UsageProfileId
	 */
	private String usageProfileId_;
	/**
	 * private member variable for Name
	 */
	private String name_;
	
	private String fileFormat;
	
	private File fileData_;
	
	private String contentType;

	public String getName() {
		return name_;
	}

	public void setName(String name) {
		this.name_ = name;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	
	public File getFileData() {
		return fileData_;
	}

	public void setFileData(File file) {
		this.fileData_ = file;
	}

	/**
	 * @return the usageProfileId_
	 */
	public String getUsageProfileId() {
		return usageProfileId_;
	}

	/**
	 * @param usageProfileId_
	 *            the usageProfileId_ to set
	 */
	public void setUsageProfileId(String usageProfileId) {
		this.usageProfileId_ = usageProfileId;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		
		// addParam(qparams,"providerAccountId", providerAccountId_);
		// addParam(qparams,"providerOrgId",providerOrgId_);
		
		return null;
		
	}	
}
