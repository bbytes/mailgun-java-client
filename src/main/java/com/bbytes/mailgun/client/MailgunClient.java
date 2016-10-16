package com.bbytes.mailgun.client;

import org.springframework.util.Assert;

import com.bbytes.mailgun.api.DomainOperations;
import com.bbytes.mailgun.api.EmailValidationOperations;
import com.bbytes.mailgun.api.EventOperations;
import com.bbytes.mailgun.api.MailOperations;
import com.bbytes.mailgun.api.MailgunAPI;
import com.bbytes.mailgun.api.MailingListOperations;
import com.bbytes.mailgun.api.RouteOperations;
import com.bbytes.mailgun.api.StatsOperations;
import com.bbytes.mailgun.api.SuppressionOperations;
import com.bbytes.mailgun.api.TagOperations;
import com.bbytes.mailgun.api.WebhookOperations;
import com.bbytes.mailgun.api.impl.MailTemplate;

public class MailgunClient extends AbstractClient implements MailgunAPI {

	public MailgunClient(String apiKey) {
		super(apiKey);
	}
	
	public static MailgunClient create(String apiKey) {
		return new MailgunClient(apiKey);
	}

	@Override
	public MailOperations mailOperations(String domain) {
		Assert.hasLength(domain, "Domain cannot be null or empty for mail operations.");
		return new MailTemplate(domain, getRestTemplate());
	}

	@Override
	public DomainOperations domainOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventOperations eventOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatsOperations statsOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RouteOperations roueOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MailingListOperations mailingListOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebhookOperations webhookOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmailValidationOperations emailValidationOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuppressionOperations suppressionOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagOperations tagOperations() {
		// TODO Auto-generated method stub
		return null;
	}

}
