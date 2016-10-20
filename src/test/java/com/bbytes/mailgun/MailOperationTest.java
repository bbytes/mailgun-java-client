package com.bbytes.mailgun;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.bbytes.mailgun.api.MailingListOperations;
import com.bbytes.mailgun.client.MailgunClient;
import com.bbytes.mailgun.model.MailingListPageResponse;

public class MailOperationTest extends MailgunJavaClientApplicationTests {

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
	public void testGetMailList() {
		MailingListOperations mailingListOperations = client.mailingListOperations();
		MailingListPageResponse response = mailingListOperations.getAllList(10);
		
		Assert.assertTrue(!response.getItems().isEmpty());
		System.out.println(response);
	}

	
}
