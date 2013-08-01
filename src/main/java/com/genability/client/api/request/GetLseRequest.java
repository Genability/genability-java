/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.http.NameValuePair;

/**
 * 
 */
public class GetLseRequest extends AbstractRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private field accountId
	 */
	private Long lseId;

	/**
	 * @return the lseId
	 */
	public Long getLseId() {
		return lseId;
	}

	/**
	 * @param lseId
	 */
	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

    @Override
    public List<NameValuePair> getQueryParams() {
      return Collections.emptyList();
    }

}
