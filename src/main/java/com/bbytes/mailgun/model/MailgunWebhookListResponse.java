package com.bbytes.mailgun.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailgunWebhookListResponse {

	@JsonProperty("webhooks")
	private MailgunWebhookList webhooks = new MailgunWebhookList();

	public List<MailgunWebhook> getWebhooks() {
		return webhooks.getWebhooks();
	}

	public void setWebhooks(MailgunWebhookList webhooks) {
		this.webhooks = webhooks;
	}

}