package com.bbytes.mailgun.api.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.RestOperations;

import com.bbytes.mailgun.api.MailOperations;
import com.bbytes.mailgun.api.ResponseCallback;
import com.bbytes.mailgun.model.MailMessage;
import com.bbytes.mailgun.model.MailgunSendResponse;
import com.bbytes.mailgun.util.ConvertUtil;
import com.bbytes.mailgun.util.MailMessageBuilder;

public class MailTemplate extends AbstractTemplate implements MailOperations {

	public MailTemplate(String domain, RestOperations restOperations, AsyncRestOperations asyncRestOperations) {
		super(restOperations, asyncRestOperations);
		setBaseURL(getBaseURL() + "/" + domain);
	}

	@Override
	public MailgunSendResponse sendHtmlMail(String from, String subject, String htmlBody, String... to) {
		MailMessage message = MailMessageBuilder.create().from(from).to(to).subject(subject).html(htmlBody).build();
		return sendMail(message);
	}

	@Override
	public MailgunSendResponse sendTextMail(String from, String subject, String txtBody, String... to) {
		MailMessage message = MailMessageBuilder.create().from(from).to(to).subject(subject).text(txtBody).build();
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

	@Override
	public void sendMailAsync(MailMessage message, ResponseCallback<MailgunSendResponse> callback) {
		try {
			MultiValueMap<String, Object> messageData = ConvertUtil.convertMessageToMultiMap(message);

			if (message.hasAttachments()) {
				ListenableFuture<ResponseEntity<MailgunSendResponse>> listenableFuture = postMultipartAsync("/messages", messageData,
						MailgunSendResponse.class);

				listenableFuture.addCallback(new ListenableFutureCallback<ResponseEntity<MailgunSendResponse>>() {
					public void onSuccess(ResponseEntity<MailgunSendResponse> result) {
						callback.onSuccess(result.getBody());
					}

					public void onFailure(Throwable ex) {
						callback.onFailure(ex);
					}
				});

			} else {
				ListenableFuture<ResponseEntity<MailgunSendResponse>> listenableFuture = postAsync("/messages", messageData,
						MailgunSendResponse.class);
				
				listenableFuture.addCallback(new ListenableFutureCallback<ResponseEntity<MailgunSendResponse>>() {
					public void onSuccess(ResponseEntity<MailgunSendResponse> result) {
						callback.onSuccess(result.getBody());
					}

					public void onFailure(Throwable ex) {
						callback.onFailure(ex);
					}
				});
			}

		} catch (Exception e) {
			throw new MailgunClientException(e);
		}
	}

}
