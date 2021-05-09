package com.jmik.restapi;

/**
 * Record of single error.
 * @author jmik
 */
public class Error {
	private String reason;
	private String message;
	private String location;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
