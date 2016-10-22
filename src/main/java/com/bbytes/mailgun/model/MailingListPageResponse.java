package com.bbytes.mailgun.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailingListPageResponse {

	@JsonProperty("items")
	private List<MailgunMailingList> items = new ArrayList<MailgunMailingList>();

	@JsonProperty("paging")
	private Paging paging;

	public List<MailgunMailingList> getItems() {
		return items;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setItems(List<MailgunMailingList> items) {
		this.items = items;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}