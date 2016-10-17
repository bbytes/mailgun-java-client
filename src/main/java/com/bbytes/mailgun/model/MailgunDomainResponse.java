package com.bbytes.mailgun.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailgunDomainResponse {

	@JsonProperty("items")
	private List<MailgunDomain> domains = new ArrayList<MailgunDomain>();

	@JsonProperty("total_count")
	private Integer totalCount;

	public List<MailgunDomain> getDomains() {
		return domains;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setDomains(List<MailgunDomain> domains) {
		this.domains = domains;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}