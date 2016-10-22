package com.bbytes.mailgun.api.impl;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.bbytes.mailgun.api.MailgunAPI;

public abstract class AbstractTemplate {

	/** Captures URI template variable names. */
	private static final Pattern NAMES_PATTERN = Pattern.compile("\\{([^/]+?)\\}");

	protected final RestOperations restOperations;

	protected final AsyncRestOperations asyncRestOperations;

	protected String baseURL = MailgunAPI.MAILGUN_API_BASE_URL;

	public AbstractTemplate(RestOperations restOperations) {
		this.restOperations = restOperations;
		this.asyncRestOperations = null;
	}

	public AbstractTemplate(RestOperations restOperations, AsyncRestOperations asyncRestOperations) {
		this.restOperations = restOperations;
		this.asyncRestOperations = asyncRestOperations;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	protected <T> T post(String reativeURL, MultiValueMap<String, Object> paramMap, Class<T> type) throws MailgunClientException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, headers);
		try {
			return restOperations.postForObject(getBaseURL() + reativeURL, requestEntity, type);
		} catch (HttpStatusCodeException e) {
			throw new MailgunClientException(e);
		}
	}

	
	protected <T> ListenableFuture<ResponseEntity<T>> postAsync(String reativeURL, MultiValueMap<String, Object> paramMap, Class<T> type) throws MailgunClientException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, headers);
		try {
			return asyncRestOperations.postForEntity(getBaseURL() + reativeURL, requestEntity, type);
		} catch (HttpStatusCodeException e) {
			throw new MailgunClientException(e);
		}
	}
	protected <T> T put(String reativeURL, MultiValueMap<String, Object> paramMap, Class<T> type) throws MailgunClientException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, headers);
		try {
			ResponseEntity<T> response = restOperations.exchange(getBaseURL() + reativeURL, HttpMethod.PUT, requestEntity, type);
			return response.getBody();
		} catch (HttpStatusCodeException e) {
			throw new MailgunClientException(e);
		}
	}

	protected <T> T postMultipart(String reativeURL, MultiValueMap<String, Object> paramMap, Class<T> type) throws MailgunClientException {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, headers);
			return restOperations.postForObject(getBaseURL() + reativeURL, requestEntity, type);
		} catch (HttpStatusCodeException e) {
			throw new MailgunClientException(e);
		}
	}
	
	protected <T> ListenableFuture<ResponseEntity<T>> postMultipartAsync(String reativeURL, MultiValueMap<String, Object> paramMap, Class<T> type) throws MailgunClientException {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, headers);
			return asyncRestOperations.postForEntity(getBaseURL() + reativeURL, requestEntity, type);
		} catch (HttpStatusCodeException e) {
			throw new MailgunClientException(e);
		}
	}

	protected <T> T get(String reativeURL, MultiValueMap<String, String> paramMap, Class<T> type) throws MailgunClientException {
		try {
			UriComponents uriComponents = UriComponentsBuilder.fromUriString(getBaseURL() + reativeURL).queryParams(paramMap).build();
			return restOperations.getForObject(uriComponents.toUriString(), type);
		} catch (HttpStatusCodeException e) {
			throw new MailgunClientException(e);
		}
	}

	protected <T> T get(String reativeURL, Class<T> type) throws MailgunClientException {
		try {
			return restOperations.getForObject(getBaseURL() + reativeURL, type);
		} catch (HttpStatusCodeException ex) {
			throw new MailgunClientException(ex);
		}

	}

	protected void delete(String reativeURL) throws MailgunClientException {
		try {
			restOperations.delete(getBaseURL() + reativeURL);
		} catch (HttpStatusCodeException ex) {
			throw new MailgunClientException(ex);
		}

	}

	protected void delete(String reativeURL, MultiValueMap<String, String> paramMap) throws MailgunClientException {
		try {
			restOperations.delete(getBaseURL() + reativeURL, paramMap);
		} catch (HttpStatusCodeException ex) {
			throw new MailgunClientException(ex);
		}

	}

	protected URI expand(String url, Object[] variables, boolean encode) {
		Matcher matcher = NAMES_PATTERN.matcher(url);
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		String separator = "";
		while (matcher.find()) {
			Object uriVariable = variables[i++];
			String replacement = Matcher
					.quoteReplacement(uriVariable != null ? (encode ? encode(uriVariable.toString()) : uriVariable.toString()) : "");
			String key = matcher.group();
			if (key.charAt(1) == '&' && replacement != null && replacement.length() > 0) {
				key = key.substring(2, key.length() - 1);
				matcher.appendReplacement(buffer, separator + key + '=' + replacement);
				separator = "&";
			} else {
				matcher.appendReplacement(buffer, replacement);
			}
		}
		matcher.appendTail(buffer);
		try {
			return new URI(buffer.toString());
		} catch (URISyntaxException ex) {
			throw new IllegalArgumentException("Could not create URI from [" + buffer + "]: " + ex, ex);
		}
	}

	private String encode(String param) {
		byte[] source = param.getBytes();
		ByteArrayOutputStream bos = new ByteArrayOutputStream(source.length);
		for (int i = 0; i < source.length; i++) {
			int b = source[i];
			if (b < 0) {
				b += 256;
			}
			if (isAllowed(b)) {
				bos.write(b);
			} else {
				bos.write('%');

				char hex1 = Character.toUpperCase(Character.forDigit((b >> 4) & 0xF, 16));
				char hex2 = Character.toUpperCase(Character.forDigit(b & 0xF, 16));

				bos.write(hex1);
				bos.write(hex2);
			}
		}
		return bos.toString();
	}

	private boolean isAllowed(int c) {
		if ('=' == c || '+' == c || '&' == c) {
			return false;
		} else {
			return isPchar(c) || '/' == c || '?' == c;
		}
	}

	private boolean isPchar(int c) {
		return isUnreserved(c) || isSubDelimiter(c) || ':' == c || '@' == c;
	}

	private boolean isUnreserved(int c) {
		return isAlpha(c) || isDigit(c) || '-' == c || '.' == c || '_' == c || '~' == c;
	}

	private boolean isAlpha(int c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	private boolean isDigit(int c) {
		return c >= '0' && c <= '9';
	}

	private boolean isSubDelimiter(int c) {
		return '!' == c || '$' == c || '&' == c || '\'' == c || '(' == c || ')' == c || '*' == c || '+' == c || ',' == c || ';' == c
				|| '=' == c;
	}

}