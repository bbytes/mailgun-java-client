package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailgunDomain {

	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("require_tls")
	private Boolean requireTls;
	
	@JsonProperty("skip_verification")
	private Boolean skipVerification;
	
	@JsonProperty("smtp_login")
	private String smtpLogin;
	
	@JsonProperty("smtp_password")
	private String smtpPassword;
	
	@JsonProperty("spam_action")
	private String spamAction;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("wildcard")
	private Boolean wildcard;

	/**
	 * 
	 * @return The createdAt
	 */
	@JsonProperty("created_at")
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * 
	 * @param createdAt
	 *            The created_at
	 */
	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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
	 * @return The requireTls
	 */
	@JsonProperty("require_tls")
	public Boolean getRequireTls() {
		return requireTls;
	}

	/**
	 * 
	 * @param requireTls
	 *            The require_tls
	 */
	@JsonProperty("require_tls")
	public void setRequireTls(Boolean requireTls) {
		this.requireTls = requireTls;
	}

	/**
	 * 
	 * @return The skipVerification
	 */
	@JsonProperty("skip_verification")
	public Boolean getSkipVerification() {
		return skipVerification;
	}

	/**
	 * 
	 * @param skipVerification
	 *            The skip_verification
	 */
	@JsonProperty("skip_verification")
	public void setSkipVerification(Boolean skipVerification) {
		this.skipVerification = skipVerification;
	}

	/**
	 * 
	 * @return The smtpLogin
	 */
	@JsonProperty("smtp_login")
	public String getSmtpLogin() {
		return smtpLogin;
	}

	/**
	 * 
	 * @param smtpLogin
	 *            The smtp_login
	 */
	@JsonProperty("smtp_login")
	public void setSmtpLogin(String smtpLogin) {
		this.smtpLogin = smtpLogin;
	}

	/**
	 * 
	 * @return The smtpPassword
	 */
	@JsonProperty("smtp_password")
	public String getSmtpPassword() {
		return smtpPassword;
	}

	/**
	 * 
	 * @param smtpPassword
	 *            The smtp_password
	 */
	@JsonProperty("smtp_password")
	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	/**
	 * 
	 * @return The spamAction
	 */
	@JsonProperty("spam_action")
	public String getSpamAction() {
		return spamAction;
	}

	/**
	 * 
	 * @param spamAction
	 *            The spam_action
	 */
	@JsonProperty("spam_action")
	public void setSpamAction(String spamAction) {
		this.spamAction = spamAction;
	}

	/**
	 * 
	 * @return The state
	 */
	@JsonProperty("state")
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 *            The state
	 */
	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return The type
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The wildcard
	 */
	@JsonProperty("wildcard")
	public Boolean getWildcard() {
		return wildcard;
	}

	/**
	 * 
	 * @param wildcard
	 *            The wildcard
	 */
	@JsonProperty("wildcard")
	public void setWildcard(Boolean wildcard) {
		this.wildcard = wildcard;
	}

}