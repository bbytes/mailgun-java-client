package com.bbytes.mailgun;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import com.bbytes.mailgun.api.DomainOperations;
import com.bbytes.mailgun.api.impl.MailgunClientException;
import com.bbytes.mailgun.client.MailgunClient;
import com.bbytes.mailgun.model.MailgunDomainResponse;
import com.bbytes.mailgun.model.MailgunDomainListResponse;

public class DomainOperationTest extends MailgunJavaClientApplicationTests {

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
	public void getAllDomains() {
		DomainOperations domainOperations = client.domainOperations();
		MailgunDomainListResponse response = domainOperations.getAllDomains(3, 0);
		Assert.isTrue(response.getTotalCount() > 0);
	}

	@Test
	public void getDomain() {
		DomainOperations domainOperations = client.domainOperations();
		MailgunDomainListResponse response = domainOperations.getAllDomains(3, 0);
		MailgunDomainResponse mailgunDomainResponse = domainOperations
				.getDomain(response.getDomains().get(0).getName());
		Assert.isTrue(!mailgunDomainResponse.getDomain().getName().isEmpty());

	}

	@Test
	public void createDomain() throws MailgunClientException {
		DomainOperations domainOperations = client.domainOperations();
		MailgunDomainResponse response = domainOperations.createDomain("test.sample2.com", "testtest123",
				"disabled", true);
		Assert.isTrue(!response.getDomain().getName().isEmpty());
	}

	@Test
	public void deleteDomain() throws MailgunClientException {
		DomainOperations domainOperations = client.domainOperations();
		domainOperations.deletDomain("test.sample2.com");
	}

}
