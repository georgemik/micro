package com.jmik.restapi.utils;

import com.jmik.restapi.ApiException;
import io.micronaut.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static com.jmik.restapi.utils.ThrowErrorFixture.notFound;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test of {@link ThrowErrorFixture}
 * @author jmik
 */
class ThrowErrorFixtureTest {
	private static final String MSG = "testMessage";

	@Test
	public void notFound_properExceptionReturned() {
		ApiException expectedEx = notFound(MSG);

		assertEquals(expectedEx.getStatus(), HttpStatus.NOT_FOUND);
		assertEquals(expectedEx.getMessage(), MSG);
	}
}
