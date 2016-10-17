package com.bbytes.mailgun.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailgunDetailDomainResponse {

	@JsonProperty("domain")
	private MailgunDomain domain;

	@JsonProperty("receiving_dns_records")
	private List<ReceivingDnsRecord> receivingDnsRecords = new ArrayList<ReceivingDnsRecord>();

	@JsonProperty("sending_dns_records")
	private List<SendingDnsRecord> sendingDnsRecords = new ArrayList<SendingDnsRecord>();

	/**
	 * 
	 * @return The domain
	 */
	@JsonProperty("domain")
	public MailgunDomain getDomain() {
		return domain;
	}

	/**
	 * 
	 * @param domain
	 *            The domain
	 */
	@JsonProperty("domain")
	public void setDomain(MailgunDomain domain) {
		this.domain = domain;
	}

	/**
	 * 
	 * @return The receivingDnsRecords
	 */
	@JsonProperty("receiving_dns_records")
	public List<ReceivingDnsRecord> getReceivingDnsRecords() {
		return receivingDnsRecords;
	}

	/**
	 * 
	 * @param receivingDnsRecords
	 *            The receiving_dns_records
	 */
	@JsonProperty("receiving_dns_records")
	public void setReceivingDnsRecords(List<ReceivingDnsRecord> receivingDnsRecords) {
		this.receivingDnsRecords = receivingDnsRecords;
	}

	/**
	 * 
	 * @return The sendingDnsRecords
	 */
	@JsonProperty("sending_dns_records")
	public List<SendingDnsRecord> getSendingDnsRecords() {
		return sendingDnsRecords;
	}

	/**
	 * 
	 * @param sendingDnsRecords
	 *            The sending_dns_records
	 */
	@JsonProperty("sending_dns_records")
	public void setSendingDnsRecords(List<SendingDnsRecord> sendingDnsRecords) {
		this.sendingDnsRecords = sendingDnsRecords;
	}

}