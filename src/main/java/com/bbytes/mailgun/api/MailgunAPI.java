package com.bbytes.mailgun.api;

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

}
