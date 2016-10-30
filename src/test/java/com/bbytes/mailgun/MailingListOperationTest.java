package com.bbytes.mailgun;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import com.bbytes.mailgun.api.MailingListOperations;
import com.bbytes.mailgun.client.MailgunClient;
import com.bbytes.mailgun.model.MailingListPageResponse;

public class MailingListOperationTest extends MailgunJavaClientApplicationTests {

	@Autowired
	Environment environment;

	MailgunClient client;

	String domain;

	@Before
	public void setup() {
		client = MailgunClient.create(environment.getProperty("mailgun.api.key"));
		domain = environment.getProperty("mailgun.domain");
	}

	@Test
	public void testGetMailList() {
		MailingListOperations mailingListOperations = client.mailingListOperations();
		MailingListPageResponse response = mailingListOperations.getAllList(10);
		
		Assert.isTrue(!response.getItems().isEmpty());
		System.out.println(response);
	}

	
}
