package com.bbytes.mailgun.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class MailgunWebhookList {

	private List<MailgunWebhook> webhooks = new ArrayList<>();

	/**
	 * @return the webhooks
	 */
	public List<MailgunWebhook> getWebhooks() {
		return webhooks;
	}

	@JsonSetter("click")
	public void setWebhookClick(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.click);
			getWebhooks().add(webhook);
		}
	}
	
	@JsonSetter("bounce")
	public void setWebhookBounce(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.bounce);
			getWebhooks().add(webhook);
		}
	}
	
	@JsonSetter("deliver")
	public void setWebhookDeliver(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.deliver);
			getWebhooks().add(webhook);
		}
	}
	
	@JsonSetter("drop")
	public void setWebhookDrop(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.drop);
			getWebhooks().add(webhook);
		}
	}
	
	@JsonSetter("open")
	public void setWebhookOpen(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.open);
			getWebhooks().add(webhook);
		}
	}
	
	
	@JsonSetter("spam")
	public void setWebhookSpam(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.spam);
			getWebhooks().add(webhook);
		}
	}
	
	@JsonSetter("unsubscribe")
	public void setWebhookUnsubscribe(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.unsubscribe);
			getWebhooks().add(webhook);
		}
	}
	

	@JsonSetter("webhook")
	public void setWebhook(MailgunWebhook webhook) {
		if (webhook != null){
			webhook.setType(WebhookType.webhook);
			getWebhooks().add(webhook);
		}
	}
}
