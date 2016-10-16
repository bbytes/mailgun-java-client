package com.bbytes.mailgun.api;

public interface MailgunAPI {

	public static final String MAILGUN_API_BASE_URL = "https://api.mailgun.net/v3";

	public MailOperations mailOperations(String domain);

	public DomainOperations domainOperations();

	public EventOperations eventOperations();

	public StatsOperations statsOperations();

	public RouteOperations roueOperations();
	
	public MailingListOperations mailingListOperations();
	
	public WebhookOperations webhookOperations();
	
	public EmailValidationOperations emailValidationOperations();
	
	public SuppressionOperations suppressionOperations();
	
	public TagOperations tagOperations();
	
	
	
	
	
	
}
