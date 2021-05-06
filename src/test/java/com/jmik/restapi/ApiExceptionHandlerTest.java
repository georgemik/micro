package com.jmik.restapi;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


/**
 * Unit test for {@link ApiExceptionHandler}
 * @author jmik
 */
@ExtendWith(MockitoExtension.class)
class ApiExceptionHandlerTest {
	private static final HttpStatus BAD_REQ = HttpStatus.BAD_REQUEST;
	private ApiExceptionHandler apiExceptionHandler;

	@Mock
	HttpRequest httpRequest;

	@BeforeEach
	void setup() {
		apiExceptionHandler = new ApiExceptionHandler();
	}

	@Test
	public void handle_passRequestAndEx_expectedResponseReturned() {
		when(httpRequest.getPath()).thenReturn("path");
		ApiException testEx = new ApiException(BAD_REQ, "testMessage", new RuntimeException("subMessage"));

		HttpResponse<ErrorRecordDto> response = apiExceptionHandler.handle(httpRequest, testEx);
		Optional<ErrorRecordDto> errorRecord = response.getBody();

		assertEquals(response.getStatus(), BAD_REQ);
		assertEquals(errorRecord.get().getMessage(), "testMessage");
		assertEquals(errorRecord.get().getCode(), "BAD_REQUEST");
	}
}