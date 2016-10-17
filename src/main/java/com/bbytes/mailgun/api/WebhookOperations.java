package com.bbytes.mailgun.api;

import com.bbytes.mailgun.model.MailgunWebhookListResponse;
import com.bbytes.mailgun.model.MailgunWebhookResponse;
import com.bbytes.mailgun.model.WebhookType;

public interface WebhookOperations {

	MailgunWebhookListResponse getAllWebhooks();
	
	MailgunWebhookResponse getWebhook(WebhookType type);
	
	/**
	 * 
	 * @param id Name of the webhook. (See above for supported webhookss
	 * @param url URL for the webhook event.
	 * @return
	 */
	MailgunWebhookResponse createWebhook(WebhookType type, String url);
	
	MailgunWebhookResponse updateWebhook(WebhookType type, String url);
	
	void deleteWebhook(WebhookType type);
}
