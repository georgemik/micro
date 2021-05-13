package com.jmik.restapi.exceptionhandlers;

import com.jmik.restapi.ApiException;
import com.jmik.restapi.ErrorRecordDto;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

/**
 * Common handler for REST API exceptions.
 * @author jmik
 */
@Singleton
@Requires(classes = {ApiException.class, ExceptionHandler.class})
public class ApiExceptionHandler implements ExceptionHandler<ApiException, HttpResponse<ErrorRecordDto>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

	@Override
	public HttpResponse<ErrorRecordDto> handle(HttpRequest request, ApiException exception) {
		String message = exception.getMessage();
		String cause = exception.getStatus().toString();
		ErrorRecordDto errorCode = new ErrorRecordDto(message, cause);

		LOGGER.info("'{}' at {}. Status code {}", message, request.getPath(), exception.getStatus());
		LOGGER.trace("Api error '{}'", message, exception.getCause());

		return HttpResponse.status(exception.getStatus()).body(errorCode);
	}
}
