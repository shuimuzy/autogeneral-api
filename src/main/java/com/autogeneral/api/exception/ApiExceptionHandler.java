package com.autogeneral.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is a global exception handler to handle all exceptions.
 *
 * @author Simon Tian
 */

@ControllerAdvice
public class ApiExceptionHandler {

	
	/**
	 * This is to handle the exception when resource is not found.
	 * @param ex ResourceNotFoundException
	 * @return json format message
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(Exception ex) {
		ExceptionResponse error = new NotFoundExceptionResponse();
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setName(ex.getMessage());

		String itemId = ((ResourceNotFoundException) ex).getItemId();

		NotFoundErrorDetails details = new NotFoundErrorDetails();
		details.setMessage(String.format("Item with %s not found", itemId));
		error.setDetails(details);

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * This is a to handle the exception when the input resource is not valid.
	 * @param ex ValidationException
	 * @return json format message
	 */
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ExceptionResponse> validationExceptionHandler(Exception ex) {
		ExceptionResponse error = new ValidationiExceptionResponse();
		error.setCode(HttpStatus.BAD_REQUEST.value());
		error.setName(ex.getMessage());

		ValidationErrorDetails details = new ValidationErrorDetails();
		details.setLocation("params");
		details.setMsg("Must be between 1 and 50 chars long");
		details.setValue("");
		details.setParam("text");
		error.setDetails(details);

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * This is a to handle the generic exception.
	 * @param ex Exception
	 * @return json format message
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex) {
		ExceptionResponse error = new ExceptionResponse();
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setName(ex.getMessage());

		ValidationErrorDetails details = new ValidationErrorDetails();
		details.setLocation("params");
		details.setMsg("The server has not found anything matching the request URI.");
		details.setValue("");
		details.setParam("text");
		error.setDetails(details);

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND);
	}

}