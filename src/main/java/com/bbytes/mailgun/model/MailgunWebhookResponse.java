package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailgunWebhookResponse {

	private String message;

	private MailgunWebhook webhook;

	public String getMessage() {
		return message;
	}

	public MailgunWebhook getWebhook() {
		return webhook;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonSetter("click")
	public void setWebhookClick(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.click);
	}
	
	@JsonSetter("bounce")
	public void setWebhookBounce(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.bounce);
	}
	
	@JsonSetter("deliver")
	public void setWebhookDeliver(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.deliver);
	}
	
	@JsonSetter("drop")
	public void setWebhookDrop(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.drop);
	}
	
	@JsonSetter("open")
	public void setWebhookOpen(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.open);
	}
	
	
	@JsonSetter("spam")
	public void setWebhookSpam(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.spam);
	}
	
	@JsonSetter("unsubscribe")
	public void setWebhookUnsubscribe(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.unsubscribe);
	}
	

	@JsonSetter("webhook")
	public void setWebhook(MailgunWebhook webhook) {
		this.webhook = webhook;
		if (this.webhook != null)
			this.webhook.setType(WebhookType.webhook);
	}

}