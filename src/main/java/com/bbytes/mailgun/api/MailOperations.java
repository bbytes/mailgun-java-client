package com.bbytes.mailgun.api;

import com.bbytes.mailgun.model.MailMessage;
import com.bbytes.mailgun.model.MailgunSendResponse;

public interface MailOperations {

	MailgunSendResponse sendHtmlMail(String from, String subject, String htmlBody, String... to);

	MailgunSendResponse sendTextMail(String from, String subject, String txtBody, String... to);

	MailgunSendResponse sendMail(MailMessage message);
}
