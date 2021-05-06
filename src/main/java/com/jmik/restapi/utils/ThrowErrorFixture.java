package com.jmik.restapi.utils;

import com.jmik.restapi.ApiException;
import io.micronaut.http.HttpStatus;

/**
 * Utility class for REST API.
 * @author jmik
 */
public class ThrowErrorFixture {

	public static ApiException notFound(String message) {
		return new ApiException(HttpStatus.NOT_FOUND, message);
	}
}
