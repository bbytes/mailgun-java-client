package com.bbytes.mailgun.client;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.AsyncClientHttpRequestExecution;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.AsyncClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {

	protected static Integer TIMEOUT_IN_SECS = 30;

	protected RestTemplate restTemplate;
	
	protected AsyncRestTemplate asyncRestTemplate;

	protected String apiKey;

	public AbstractClient(String apiKey) {
		Assert.hasLength(apiKey, "API Key cannot be null or empty.");
		this.apiKey = apiKey;
		List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
		restTemplate = new RestTemplate(clientHttpRequestFactory());
		asyncRestTemplate = new AsyncRestTemplate(asyncClientHttpRequestFactory());
		if (messageConverters != null && !messageConverters.isEmpty()) {
			restTemplate.setMessageConverters(messageConverters);
			asyncRestTemplate.setMessageConverters(messageConverters);
		}
		registerInterceptors(apiKey);

	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(getReadTimeoutInSecs() * 1000);
		factory.setConnectTimeout(getConnectionTimeoutInSecs() * 1000);
		return factory;
	}
	
	private AsyncClientHttpRequestFactory asyncClientHttpRequestFactory() {
		HttpComponentsAsyncClientHttpRequestFactory factory = new HttpComponentsAsyncClientHttpRequestFactory();
		factory.setReadTimeout(getReadTimeoutInSecs() * 1000);
		factory.setConnectTimeout(getConnectionTimeoutInSecs() * 1000);
		return factory;
	}

	protected Integer getReadTimeoutInSecs() {
		return TIMEOUT_IN_SECS;
	}

	protected Integer getConnectionTimeoutInSecs() {
		return TIMEOUT_IN_SECS;
	}

	protected void setTimeOutInSecs(Integer timeout) {
		TIMEOUT_IN_SECS = timeout;
	}

	private void registerInterceptors(String apiKey) {
		List<ClientHttpRequestInterceptor> interceptors = getRestTemplate().getInterceptors();
		interceptors.add(new HTTPBasicAuthRequestInterceptor(apiKey));
		getRestTemplate().setInterceptors(interceptors);
		
		List<AsyncClientHttpRequestInterceptor> asyncInterceptors = getAsyncRestTemplate().getInterceptors();
		asyncInterceptors.add(new HTTPBasicAuthRequestInterceptor(apiKey));
		getAsyncRestTemplate().setInterceptors(asyncInterceptors);
	}

	/**
	 * Returns a list of {@link HttpMessageConverter}s to be used by the
	 * internal {@link RestTemplate}. By default, this includes a
	 * {@link StringHttpMessageConverter}, a
	 * {@link MappingJackson2HttpMessageConverter}, a
	 * {@link ByteArrayHttpMessageConverter}, and a
	 * {@link FormHttpMessageConverter}. The {@link FormHttpMessageConverter} is
	 * set to use "UTF-8" character encoding. Override this method to add
	 * additional message converters or to replace the default list of message
	 * converters.
	 * 
	 * @return a list of message converters to be used by RestTemplate
	 */
	protected List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new ResourceHttpMessageConverter());
		messageConverters.add(getFormMessageConverter());
		messageConverters.add(getJsonMessageConverter());
		messageConverters.add(getByteArrayMessageConverter());
		return messageConverters;
	}

	/**
	 * Returns an {@link FormHttpMessageConverter} to be used by the internal
	 * {@link RestTemplate}. By default, the message converter is set to use
	 * "UTF-8" character encoding. Override to customize the message converter
	 * (for example, to set supported media types or message converters for the
	 * parts of a multipart message). To remove/replace this or any of the other
	 * message converters that are registered by default, override the
	 * getMessageConverters() method instead.
	 * 
	 * @return an {@link FormHttpMessageConverter} to be used by the internal
	 *         {@link RestTemplate}.
	 */
	protected FormHttpMessageConverter getFormMessageConverter() {
		FormHttpMessageConverter converter = new FormHttpMessageConverter();
		converter.setCharset(Charset.forName("UTF-8"));
		List<HttpMessageConverter<?>> partConverters = new ArrayList<HttpMessageConverter<?>>();
		partConverters.add(new ByteArrayHttpMessageConverter());
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
				Charset.forName("UTF-8"));
		stringHttpMessageConverter.setWriteAcceptCharset(false);
		partConverters.add(stringHttpMessageConverter);
		partConverters.add(new ResourceHttpMessageConverter());
		converter.setPartConverters(partConverters);
		return converter;
	}

	/**
	 * Returns a {@link MappingJackson2HttpMessageConverter} to be used by the
	 * internal {@link RestTemplate}. Override to customize the message
	 * converter (for example, to set a custom object mapper or supported media
	 * types). To remove/replace this or any of the other message converters
	 * that are registered by default, override the getMessageConverters()
	 * method instead.
	 * 
	 * @return a {@link MappingJackson2HttpMessageConverter} to be used by the
	 *         internal {@link RestTemplate}.
	 */
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

	/**
	 * Returns a {@link ByteArrayHttpMessageConverter} to be used by the
	 * internal {@link RestTemplate} when consuming image or other binary
	 * resources. By default, the message converter supports "image/jpeg",
	 * "image/gif", and "image/png" media types. Override to customize the
	 * message converter (for example, to set supported media types). To
	 * remove/replace this or any of the other message converters that are
	 * registered by default, override the getMessageConverters() method
	 * instead.
	 * 
	 * @return a {@link ByteArrayHttpMessageConverter} to be used by the
	 *         internal {@link RestTemplate} when consuming image or other
	 *         binary resources.
	 */
	protected ByteArrayHttpMessageConverter getByteArrayMessageConverter() {
		ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.IMAGE_JPEG, MediaType.IMAGE_GIF, MediaType.IMAGE_PNG));
		return converter;
	}

	protected RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	protected AsyncRestTemplate getAsyncRestTemplate() {
		return asyncRestTemplate;
	}

	private static final class HTTPBasicAuthRequestInterceptor implements ClientHttpRequestInterceptor , AsyncClientHttpRequestInterceptor{

		private final String password;
		private final String username = "api";

		public HTTPBasicAuthRequestInterceptor(final String apiKey) {
			this.password = apiKey;
		}

		public ClientHttpResponse intercept(final HttpRequest request, final byte[] body,
				ClientHttpRequestExecution execution) throws IOException {

			String plainCreds = username + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);

			request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Basic " + base64Creds);
			return execution.execute(request, body);
		}

		@Override
		public ListenableFuture<ClientHttpResponse> intercept(HttpRequest request, byte[] body, AsyncClientHttpRequestExecution execution)
				throws IOException {
			String plainCreds = username + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);

			request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Basic " + base64Creds);
			return execution.executeAsync(request, body);
		}

	}

}
