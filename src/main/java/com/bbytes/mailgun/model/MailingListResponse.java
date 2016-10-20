package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailingListResponse {

	@JsonProperty("message")
	private String message;
	
	@JsonProperty("list")
	private MailingList mailingListResponse;

	public String getMessage() {
		return message;
	}

	public MailingList getMailingListResponse() {
		return mailingListResponse;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMailingListResponse(MailingList mailingListResponse) {
		this.mailingListResponse = mailingListResponse;
	}


}
