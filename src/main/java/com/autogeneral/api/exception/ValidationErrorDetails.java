package com.autogeneral.api.exception;

/**
 * This is the detailed error message when the input resource is not valid.
 *
 * @author Simon Tian
 */
public class ValidationErrorDetails {
	
	private String location;
	
	private String param;
	
	private String msg;
	
	private String value;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}