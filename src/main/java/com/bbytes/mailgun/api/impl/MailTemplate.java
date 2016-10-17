package com.bbytes.mailgun.api.impl;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.bbytes.mailgun.api.MailOperations;
import com.bbytes.mailgun.model.MailMessage;
import com.bbytes.mailgun.model.MailgunSendResponse;
import com.bbytes.mailgun.util.ConvertUtil;
import com.bbytes.mailgun.util.MailBuilder;

public class MailTemplate extends AbstractTemplate implements MailOperations {

	
	public MailTemplate(String domain, RestOperations restOperations) {
		super(restOperations);
		setBaseURL(getBaseURL() + "/" + domain);
	}

	@Override
	public MailgunSendResponse sendHtmlMail(String from, String subject, String htmlBody, String... to) {
		MailMessage message = MailBuilder.create().from(from).to(to).subject(subject).html(htmlBody).build();
		return sendMail(message);
	}

	@Override
	public MailgunSendResponse sendTextMail(String from, String subject, String txtBody, String... to) {
		MailMessage message = MailBuilder.create().from(from).to(to).subject(subject).text(txtBody).build();
		return sendMail(message);
	}

	@Override
	public MailgunSendResponse sendMail(MailMessage message) {
	
		try {
			MultiValueMap<String, Object> messageData = ConvertUtil.convertMessageToMultiMap(message);

			if (message.hasAttachments()) {
				return postMultipart("/messages", messageData, MailgunSendResponse.class);
			} else {
				return post("/messages", messageData, MailgunSendResponse.class);
			}

		} catch (Exception e) {
			throw new MailgunClientException(e);
		}

	}

}
