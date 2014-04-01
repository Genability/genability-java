/**
 *
 */
package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

/**
 * @author ebaizel
 *
 */
public class DeleteTariffRequest extends AbstractRequest implements Serializable {

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private field tariffId
	 */
	private Long tariffId;

	/**
	 * private field hardDelete
	 * -- unpublished functionality --
	 */
	private Boolean hardDelete;

	/**
	 * @return the tariffId
	 */
	public Long getTariffId() {
		return tariffId;
	}

	public Boolean getHardDelete() {
	    return hardDelete;
	}

	/**
	 * @param tariffId
	 *            the tariffId to set
	 */
	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	/**
	 * @param hardDelete
	 *
	 * If true, fully delete the account,
	 * otherwise the account just has its
	 * status changed to DELETED.
	 */
	public void setHardDelete(Boolean hardDelete) {
	    this.hardDelete = hardDelete;
	}

	@Override
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();

		addParam(qparams,"hardDelete",hardDelete);

		return qparams;

	}

}
