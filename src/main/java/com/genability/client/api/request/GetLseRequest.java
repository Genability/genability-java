/**
 * 
 */
package com.genability.client.api.request;

import java.io.Serializable;

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

}
