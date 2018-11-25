package com.autogeneral.api.exception;

/**
 * This is the exception response when resource is not found.
 *
 * @author Simon Tian
 */
public class NotFoundExceptionResponse extends ExceptionResponse {
	
	private NotFoundErrorDetails details;

	@Override
	public void setDetails(Object details) {
		this.details = (NotFoundErrorDetails) details;
	}
	
	@Override
	public Object getDetails() {
		return details;
	}

}
