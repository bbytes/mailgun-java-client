package com.bbytes.mailgun.api.impl;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class MailgunClientException extends HttpStatusCodeException {

	private static final long serialVersionUID = -4084444984163796577L;

	public MailgunClientException(Throwable ex) {
		super(HttpStatus.BAD_REQUEST, ex.getMessage());
	}
	
	public MailgunClientException(HttpStatusCodeException ex) {
		super(ex.getStatusCode(), ex.getStatusText(), ex.getResponseHeaders(), ex.getResponseBodyAsByteArray(),null);
	}
	
	/**
	 * Construct a new instance of {@code HttpClientErrorException} based on an
	 * {@link HttpStatus}.
	 * 
	 * @param statusCode
	 *            the status code
	 */
	public MailgunClientException(HttpStatus statusCode) {
		super(statusCode);
	}

	/**
	 * Construct a new instance of {@code HttpClientErrorException} based on an
	 * {@link HttpStatus} and status text.
	 * 
	 * @param statusCode
	 *            the status code
	 * @param statusText
	 *            the status text
	 */
	public MailgunClientException(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
	}

	/**
	 * Construct a new instance of {@code HttpClientErrorException} based on an
	 * {@link HttpStatus}, status text, and response body content.
	 * 
	 * @param statusCode
	 *            the status code
	 * @param statusText
	 *            the status text
	 * @param responseBody
	 *            the response body content, may be {@code null}
	 * @param responseCharset
	 *            the response body charset, may be {@code null}
	 */
	public MailgunClientException(HttpStatus statusCode, String statusText, byte[] responseBody,
			Charset responseCharset) {
		super(statusCode, statusText, responseBody, responseCharset);
	}

	/**
	 * Construct a new instance of {@code HttpClientErrorException} based on an
	 * {@link HttpStatus}, status text, and response body content.
	 * 
	 * @param statusCode
	 *            the status code
	 * @param statusText
	 *            the status text
	 * @param responseHeaders
	 *            the response headers, may be {@code null}
	 * @param responseBody
	 *            the response body content, may be {@code null}
	 * @param responseCharset
	 *            the response body charset, may be {@code null}
	 * @since 3.1.2
	 */
	public MailgunClientException(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders,
			byte[] responseBody, Charset responseCharset) {
		super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
	}

}
