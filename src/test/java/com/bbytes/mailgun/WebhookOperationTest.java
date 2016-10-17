package com.bbytes.mailgun;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import com.bbytes.mailgun.api.WebhookOperations;
import com.bbytes.mailgun.api.impl.MailgunClientException;
import com.bbytes.mailgun.client.MailgunClient;
import com.bbytes.mailgun.model.MailgunWebhookListResponse;
import com.bbytes.mailgun.model.MailgunWebhookResponse;
import com.bbytes.mailgun.model.WebhookType;

public class WebhookOperationTest extends MailgunJavaClientApplicationTests {

	@Autowired
	Environment environment;

	MailgunClient client;

	String domain;

	@Before
	public void setup() {
		client = MailgunClient.create(environment.getProperty("mailgun.apiKey"));
		domain = environment.getProperty("mailgun.domain");
	}

	@Test
	public void getAllWebhooks() {
		WebhookOperations webhookOperations = client.webhookOperations(domain);
		MailgunWebhookListResponse response = webhookOperations.getAllWebhooks();
		Assert.isTrue(!response.getWebhooks().isEmpty());
	}

	@Test
	public void getWebnook() {
		WebhookOperations webhookOperations = client.webhookOperations(domain);
		MailgunWebhookResponse response = webhookOperations.getWebhook(WebhookType.click);
		Assert.isTrue(!response.getWebhook().getUrl().isEmpty());
	}

	@Test
	public void createWebhook() throws MailgunClientException {
		WebhookOperations webhookOperations = client.webhookOperations(domain);
		MailgunWebhookResponse response = webhookOperations.createWebhook(WebhookType.click,
				"http://sample.com/post/test");
		Assert.isTrue(!response.getWebhook().getUrl().isEmpty());
		System.out.println(response);
	}

	@Test
	public void deleteRoute() throws MailgunClientException {
		WebhookOperations webhookOperations = client.webhookOperations(domain);
		webhookOperations.deleteWebhook(WebhookType.click);
	}

}
