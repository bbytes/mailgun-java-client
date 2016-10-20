package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailingListMember {

	@JsonProperty("vars")
	private String vars;
	@JsonProperty("name")
	private String name;
	@JsonProperty("subscribed")
	private Boolean subscribed;
	@JsonProperty("address")
	private String address;

	/**
	 * 
	 * @return The vars
	 */
	@JsonProperty("vars")
	public String getVars() {
		return vars;
	}

	/**
	 * 
	 * @param vars
	 *            The vars
	 */
	@JsonProperty("vars")
	public void setVars(String vars) {
		this.vars = vars;
	}

	/**
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The subscribed
	 */
	@JsonProperty("subscribed")
	public Boolean getSubscribed() {
		return subscribed;
	}

	/**
	 * 
	 * @param subscribed
	 *            The subscribed
	 */
	@JsonProperty("subscribed")
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}

	/**
	 * 
	 * @return The address
	 */
	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 *            The address
	 */
	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

}