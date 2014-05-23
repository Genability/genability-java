package com.genability.client.api.service;

public class GenabilityException extends RuntimeException {

	private static final long serialVersionUID = 5391011505607028691L;

	private final String response;

	public GenabilityException(String message) {
		super(message);
		this.response = null;
	}

	public GenabilityException(Throwable cause) {
		super(cause);
		this.response = null;
	}

	public GenabilityException(String message, Throwable cause) {
		super(message, cause);
		this.response = null;
	}

	public GenabilityException(String message, String response) {
		super(message);
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

}
