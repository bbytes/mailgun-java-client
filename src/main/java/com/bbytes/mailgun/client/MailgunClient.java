package com.bbytes.mailgun.client;

import org.springframework.util.Assert;

import com.bbytes.mailgun.api.DomainOperations;
import com.bbytes.mailgun.api.EmailValidationOperations;
import com.bbytes.mailgun.api.EventOperations;
import com.bbytes.mailgun.api.MailOperations;
import com.bbytes.mailgun.api.MailgunAPI;
import com.bbytes.mailgun.api.MailingListOperations;
import com.bbytes.mailgun.api.MailingListTemplate;
import com.bbytes.mailgun.api.RouteOperations;
import com.bbytes.mailgun.api.StatsOperations;
import com.bbytes.mailgun.api.SuppressionOperations;
import com.bbytes.mailgun.api.TagOperations;
import com.bbytes.mailgun.api.WebhookOperations;
import com.bbytes.mailgun.api.impl.DomainTemplate;
import com.bbytes.mailgun.api.impl.MailTemplate;
import com.bbytes.mailgun.api.impl.RouteTemplate;
import com.bbytes.mailgun.api.impl.WebhookTemplate;

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
		return new MailTemplate(domain, getRestTemplate(), getAsyncRestTemplate());
	}

	@Override
	public DomainOperations domainOperations() {
		return new DomainTemplate(getRestTemplate());
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
		return new RouteTemplate(getRestTemplate());
	}

	@Override
	public MailingListOperations mailingListOperations() {
		return new MailingListTemplate(getRestTemplate());
	}

	@Override
	public WebhookOperations webhookOperations(String domain) {
		Assert.hasLength(domain, "Domain cannot be null or empty for mail operations.");
		return new WebhookTemplate(domain, getRestTemplate());
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
