package com.bbytes.mailgun.api;

import com.bbytes.mailgun.model.MailMessage;
import com.bbytes.mailgun.model.MailgunSendResponse;

public interface MailOperations {

	MailgunSendResponse sendHtmlMail(String from, String subject, String htmlBody, String... to);

	void sendHtmlMailAsync(String from, String[] to, String subject, String htmlBody, ResponseCallback<MailgunSendResponse> callback);

	MailgunSendResponse sendTextMail(String from, String subject, String txtBody, String... to);

	void sendTextMailAsync(String from, String[] to, String subject, String txtBody, ResponseCallback<MailgunSendResponse> callback);

	MailgunSendResponse sendMail(MailMessage message);

	void sendMailAsync(MailMessage message, ResponseCallback<MailgunSendResponse> callback);
}
