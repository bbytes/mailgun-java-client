package com.bbytes.mailgun.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.bbytes.mailgun.api.WebhookOperations;
import com.bbytes.mailgun.model.MailgunWebhookListResponse;
import com.bbytes.mailgun.model.MailgunWebhookResponse;
import com.bbytes.mailgun.model.WebhookType;

public class WebhookTemplate extends AbstractTemplate implements WebhookOperations {

	public WebhookTemplate(String domain, RestOperations restOperations) {
		super(restOperations);
		setBaseURL(getBaseURL() + "/domains/" + domain);
	}

	@Override
	public MailgunWebhookListResponse getAllWebhooks() {
		return get("/webhooks", MailgunWebhookListResponse.class);
	}


	@Override
	public MailgunWebhookResponse getWebhook(WebhookType type) {
		return get("/webhooks/"+ type.toString(), MailgunWebhookResponse.class);
	}

	@Override
	public MailgunWebhookResponse createWebhook(WebhookType type, String url) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("id", type.toString());
		paramMap.add("url", url);
		return post("/webhooks", paramMap, MailgunWebhookResponse.class);
	}

	@Override
	public MailgunWebhookResponse updateWebhook(WebhookType type, String url) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("url", url);
		return post("/webhooks/"+type.toString(), paramMap, MailgunWebhookResponse.class);
	}

	@Override
	public void deleteWebhook(WebhookType type) {
		delete("/webhooks/" + type.toString());
	}

}
