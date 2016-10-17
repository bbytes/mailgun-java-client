package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailgunRouteResponse {

	@JsonProperty("message")
	private String message;

	@JsonProperty("route")
	private MailgunRoute route;

	/**
	 * 
	 * @return The message
	 */
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 *            The message
	 */
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return The route
	 */
	@JsonProperty("route")
	public MailgunRoute getRoute() {
		return route;
	}

	/**
	 * 
	 * @param route
	 *            The route
	 */
	@JsonProperty("route")
	public void setRoute(MailgunRoute route) {
		this.route = route;
	}

}