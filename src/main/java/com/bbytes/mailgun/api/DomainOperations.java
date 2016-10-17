package com.bbytes.mailgun.api;

import com.bbytes.mailgun.api.impl.MailgunClientException;
import com.bbytes.mailgun.model.MailgunDomainResponse;
import com.bbytes.mailgun.model.MailgunDomainListResponse;

public interface DomainOperations {

	/**
	 * 
	 * @param limit
	 *            Maximum number of records to return. (100 by default)
	 * @param skip
	 *            Number of records to skip. (0 by default)
	 * @return
	 */
	MailgunDomainListResponse getAllDomains(Integer limit, Integer skip);

	/**
	 * Get specific domain
	 * 
	 * @param domain
	 * @return
	 */
	MailgunDomainResponse getDomain(String domain) throws MailgunClientException;

	/**
	 * 
	 * @param name
	 *            Name of the domain (ex. domain.com)
	 * @param smtpPassowrd
	 *            Password for SMTP authentication
	 * @param spamAction
	 *            'disabled' or 'tag' Disable, no spam filtering will occur for
	 *            inbound messages. Tag, messages will be tagged wtih a spam
	 *            header
	 * @param wildcard
	 *            true or false Determines whether the domain will accept email
	 *            for sub-domains.
	 * @return MailgunDomain
	 */
	MailgunDomainResponse createDomain(String name, String smtpPassowrd, String spamAction, boolean wildcard);

	void deletDomain(String domain);

	String getDomainCredentials(String domain, Integer limit, Integer skip);

	String createDomainCredentials(String domain, String login, String credentials);

	String deleteDomainCredentials(String domain, String login);
}
