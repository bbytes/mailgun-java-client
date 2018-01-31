package com.bbytes.mailgun.api;

import java.util.List;

import com.bbytes.mailgun.model.MailMessage;
import com.bbytes.mailgun.model.MailgunSendResponse;

public interface MailOperations {

	MailgunSendResponse sendHtmlMail(String from, String subject, String htmlBody, String... to);

	MailgunSendResponse sendHtmlMail(String from, String subject, String htmlBody, String[] to, String[] cc, String[] bcc);

	MailgunSendResponse sendHtmlMail(String from, String subject, String htmlBody, List<String> to, List<String> cc, List<String> bcc);

	void sendHtmlMailAsync(String from, String[] to, String subject, String htmlBody, ResponseCallback<MailgunSendResponse> callback);

	void sendHtmlMailAsync(String from, String[] to, String[] cc, String[] bcc, String subject, String htmlBody,
			ResponseCallback<MailgunSendResponse> callback);

	MailgunSendResponse sendTextMail(String from, String subject, String txtBody, String... to);

	MailgunSendResponse sendTextMail(String from, String subject, String txtBody, String[] to, String[] cc, String[] bcc);

	MailgunSendResponse sendTextMail(String from, String subject, String txtBody, List<String> to, List<String> cc, List<String> bcc);

	void sendTextMailAsync(String from, String[] to, String subject, String txtBody, ResponseCallback<MailgunSendResponse> callback);
	
	void sendTextMailAsync(String from, String[] to, String[] cc, String[] bcc, String subject, String txtBody, ResponseCallback<MailgunSendResponse> callback);
	
	void sendTextMailAsync(String from, String[] to, List<String> cc, List<String> bcc,String subject, String txtBody, ResponseCallback<MailgunSendResponse> callback);

	MailgunSendResponse sendMail(MailMessage message);

	void sendMailAsync(MailMessage message, ResponseCallback<MailgunSendResponse> callback);
}
