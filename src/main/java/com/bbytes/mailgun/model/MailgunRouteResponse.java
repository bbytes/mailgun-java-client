package com.bbytes.mailgun.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailgunRouteResponse {

	@JsonProperty("total_count")
	private Integer totalCount;
	
	@JsonProperty("items")
	private List<MailgunRoute> routes = new ArrayList<MailgunRoute>();

	public Integer getTotalCount() {
		return totalCount;
	}

	public List<MailgunRoute> getRoutes() {
		return routes;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setRoutes(List<MailgunRoute> routes) {
		this.routes = routes;
	}

	
	

}