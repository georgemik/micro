package com.jmik.restapi;

import io.micronaut.http.HttpStatus;

/**
 * Universal REST API exception.
 * @author jmik
 */
public class ApiException extends RuntimeException{
	private final HttpStatus status;

	public ApiException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	ApiException(HttpStatus status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
