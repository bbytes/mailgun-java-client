package com.bbytes.mailgun.api;

import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.RestOperations;

public interface MailgunAPI {

	public static final String MAILGUN_API_BASE_URL = "https://api.mailgun.net/v3";

	MailOperations mailOperations(String domain);

	DomainOperations domainOperations();

	EventOperations eventOperations();

	StatsOperations statsOperations();

	RouteOperations roueOperations();

	MailingListOperations mailingListOperations();

	WebhookOperations webhookOperations(String domain);

	EmailValidationOperations emailValidationOperations();

	SuppressionOperations suppressionOperations();

	TagOperations tagOperations();

	RestOperations restClient();

	AsyncRestOperations restAsyncClient();

}
