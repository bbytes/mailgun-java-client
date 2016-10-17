package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailgunWebhook {

	private WebhookType type;
	
	@JsonProperty("url")
	private String url;

	/**
	 * @return the type
	 */
	public WebhookType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(WebhookType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
