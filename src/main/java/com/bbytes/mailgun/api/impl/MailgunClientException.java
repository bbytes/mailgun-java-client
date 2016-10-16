package com.bbytes.mailgun.api.impl;

public class MailgunClientException extends Exception {

	private static final long serialVersionUID = -4084444984163796577L;

	public MailgunClientException(String msg) {
		super(msg);
	}

	public MailgunClientException(Throwable ex) {
		super(ex);
	}

	public MailgunClientException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
