package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailingListResponse {

	@JsonProperty("message")
	private String message;
	
	@JsonProperty("list")
	private MailgunMailingList mailingListResponse;

	public String getMessage() {
		return message;
	}

	public MailgunMailingList getMailingListResponse() {
		return mailingListResponse;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMailingListResponse(MailgunMailingList mailingListResponse) {
		this.mailingListResponse = mailingListResponse;
	}


}
