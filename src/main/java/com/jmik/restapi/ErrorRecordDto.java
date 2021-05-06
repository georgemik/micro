package com.jmik.restapi;

/**
 * Error holding DTO.
 * @author jmik
 */
public class ErrorRecordDto {
	private final String message;
	private final String code;

	ErrorRecordDto(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}
}
