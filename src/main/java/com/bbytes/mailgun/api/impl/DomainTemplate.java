package com.bbytes.mailgun.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.bbytes.mailgun.api.DomainOperations;
import com.bbytes.mailgun.model.MailgunDetailDomainResponse;
import com.bbytes.mailgun.model.MailgunDomainResponse;

public class DomainTemplate extends AbstractTemplate implements DomainOperations {

	public DomainTemplate(RestOperations restOperations) {
		super(restOperations);
	}

	@Override
	public MailgunDomainResponse getAllDomains(Integer limit, Integer skip) {
		MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
		paramMap.add("limit", limit.toString());
		paramMap.add("skip", skip.toString());
		return get("/domains", paramMap, MailgunDomainResponse.class);
	}

	@Override
	public MailgunDetailDomainResponse getDomain(String domain) throws MailgunClientException {
		return get("/domains/" + domain, MailgunDetailDomainResponse.class);
	}

	@Override
	public MailgunDetailDomainResponse createDomain(String name, String smtpPassowrd, String spamAction,
			boolean wildcard) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("name", name);
		paramMap.add("smtp_password", smtpPassowrd);
		paramMap.add("spam_action", spamAction);
		paramMap.add("wildcard", wildcard ? "true" : "false");
		return post("/domains", paramMap, MailgunDetailDomainResponse.class);
	}

	@Override
	public void deletDomain(String domain) {
		delete("/domains/" + domain);
	}

	@Override
	public String getDomainCredentials(String domain, Integer limit, Integer skip) {
		throw new UnsupportedOperationException("Yet to be implemented");
	}

	@Override
	public String createDomainCredentials(String domain, String login, String credentials) {
		throw new UnsupportedOperationException("Yet to be implemented");
	}

	@Override
	public String deleteDomainCredentials(String domain, String login) {
		throw new UnsupportedOperationException("Yet to be implemented");
	}

}
