package com.jmik.restapi.utils;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.context.ServerRequestContext;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

/**
 * Unit tests for {@link ApiUtils}.
 * @author jmik
 */
class ApiUtilsTest {
	private static final String HREF_BASE = "http://localhost:8080";
	private static final String HREF_PATH = "/api/users/4";

	@Test
	public void getHref_providePath_correctHrefReturned() {
		try (MockedStatic<ServerRequestContext> mocked = mockStatic(ServerRequestContext.class)) {
			mocked.when(ServerRequestContext::currentRequest).thenReturn(Optional.of(HttpRequest.GET(HREF_BASE + "/api/test")));
			String href = new ApiUtils().getHref(HREF_PATH);

			assertEquals(href, HREF_BASE + HREF_PATH);
		}
	}
}