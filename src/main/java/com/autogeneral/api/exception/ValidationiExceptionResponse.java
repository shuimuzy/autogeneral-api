package com.autogeneral.api.exception;

/**
 * This is the exception response when resource is not valid.
 *
 * @author Simon Tian
 */
public class ValidationiExceptionResponse extends ExceptionResponse {

	private ValidationErrorDetails details;

	@Override
	public Object getDetails() {
		return details;
	}

	@Override
	public void setDetails(Object details) {
		this.details = (ValidationErrorDetails) details;

	}

}
