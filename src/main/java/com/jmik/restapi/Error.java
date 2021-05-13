package com.jmik.restapi;

/**
 * Record of single error.
 * @author jmik
 */
class Error {
	private String reason;
	private String message;
	private String location;

	String getReason() {
		return reason;
	}

	void setReason(String reason) {
		this.reason = reason;
	}

	String getMessage() {
		return message;
	}

	void setMessage(String message) {
		this.message = message;
	}

	String getLocation() {
		return location;
	}

	void setLocation(String location) {
		this.location = location;
	}
}
