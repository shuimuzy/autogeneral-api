package com.autogeneral.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is an exception when resource is not found.
 *
 * @author Simon Tian
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	//It is the given item id which is not found in the database
	private String itemId;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String itemId, String message) {
		super(message);
		this.itemId = itemId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
