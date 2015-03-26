package com.genability.client.api.request;

import java.io.Serializable;

public class GetLseRequest extends AbstractRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long lseId;

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}
}
