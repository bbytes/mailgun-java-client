package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailingListMemberResponse {

	@JsonProperty("member")
	private MailingListMember member;

	@JsonProperty("message")
	private String message;

	public MailingListMember getMember() {
		return member;
	}

	public String getMessage() {
		return message;
	}

	public void setMember(MailingListMember member) {
		this.member = member;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
