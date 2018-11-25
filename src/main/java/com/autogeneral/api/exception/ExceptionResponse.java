package com.autogeneral.api.exception;


/**
 * This is exception response information with code, name and detailed message.
 *
 * @author Simon Tian
 */
public class ExceptionResponse {

	private int code;
	private String name;
	protected Object details;

	public ExceptionResponse() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getDetails() {
		return details;
	}

	public void setDetails(Object details) {
		this.details = details;
	}

}