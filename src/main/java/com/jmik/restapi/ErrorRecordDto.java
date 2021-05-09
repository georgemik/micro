package com.jmik.restapi;

import java.util.List;

/**
 * Error holding DTO.
 * @author jmik
 */
public class ErrorRecordDto {
	private final String message;
	private final String code;
	private List<Error> errors;

	public ErrorRecordDto(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
