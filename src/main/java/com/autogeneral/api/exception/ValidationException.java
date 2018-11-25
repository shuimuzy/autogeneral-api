package com.autogeneral.api.exception;

/**
 * This is an exception when resource is not valid.
 *
 * @author Simon Tian
 */
@SuppressWarnings("serial")
public class ValidationException extends Exception {

	private String errorMessage;

	public ValidationException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ValidationException() {
		super();
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
}
