package com.jmik.restapi.utils;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.context.ServerRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Utility class for REST API.
 * @author jmik
 */
@Singleton
public class ApiUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiUtils.class);
	public String getHref() {
		HttpRequest req = ServerRequestContext.currentRequest().get();
		String href = "";
		try {
			href = new URL("http", req.getServerAddress().getHostName(), req.getServerAddress().getPort(), req.getPath()).toString();
		} catch (MalformedURLException ex) {
			LOGGER.error("Can't create href", ex);
		}
		return href;
	}
}
