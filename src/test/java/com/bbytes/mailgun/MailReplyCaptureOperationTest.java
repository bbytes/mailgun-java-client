package com.bbytes.mailgun;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.bbytes.mailgun.api.MailOperations;
import com.bbytes.mailgun.api.RouteOperations;
import com.bbytes.mailgun.api.impl.MailgunClientException;
import com.bbytes.mailgun.client.MailgunClient;
import com.bbytes.mailgun.model.MailMessage;
import com.bbytes.mailgun.model.MailgunRouteResponse;
import com.bbytes.mailgun.util.MailMessageBuilder;

public class MailReplyCaptureOperationTest extends MailgunJavaClientApplicationTests {

	@Autowired
	Environment environment;

	MailgunClient client;

	String domain;

	@Before
	public void setup() {
		client = MailgunClient.create(environment.getProperty("mailgun.apiKey"));
		domain = environment.getProperty("mailgun.domain");
	}

	@Test
	public void createRouteForReplyTest() throws MailgunClientException {
		RouteOperations routeOperations = client.roueOperations();
		MailgunRouteResponse response = routeOperations.createRoute(0, "reply route",
				"match_recipient('reply123@recruizmail.com')", "forward('http://requestb.in/1n9z7381')");
		Assert.assertTrue(!response.getRoute().getId().isEmpty());
		MailOperations mailOperations = client.mailOperations(domain);
		MailMessage message = MailMessageBuilder.create().replyTo("reply123@recruizmail.com").from("reply123@recruizmail.com").to("tm@beyondbytes.co.in").subject("test 123")
				.text("simple text").build();
		System.out.println(mailOperations.sendMail(message).getId());
	}
	
	

}
