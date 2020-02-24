package com.narendra.exceptions;

public class FlagPickerException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	private String requestUri;
	
	public FlagPickerException(String message, String requestUri) {
		super();
		this.message = message;
		this.requestUri = requestUri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}
	
}
