package com.bbytes.mailgun.api;

import com.bbytes.mailgun.api.impl.MailgunClientException;
import com.bbytes.mailgun.model.MailMessage;
import com.bbytes.mailgun.model.MailgunSendResponse;

public interface MailOperations {

	MailgunSendResponse sendMail(String from, String subject, String body, String... to) throws MailgunClientException;


	MailgunSendResponse sendMail(MailMessage message) throws MailgunClientException;
}
