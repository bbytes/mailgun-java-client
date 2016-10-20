package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailingList {

	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("address")
	private String address;
	@JsonProperty("members_count")
	private Integer membersCount;
	@JsonProperty("access_level")
	private AccessLevel accessLevel;
	@JsonProperty("description")
	private String description;
	@JsonProperty("name")
	private String name;

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

	/**
	 * 
	 * @return The membersCount
	 */
	@JsonProperty("members_count")
	public Integer getMembersCount() {
		return membersCount;
	}

	/**
	 * 
	 * @param membersCount
	 *            The members_count
	 */
	@JsonProperty("members_count")
	public void setMembersCount(Integer membersCount) {
		this.membersCount = membersCount;
	}

	/**
	 * 
	 * @return The description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
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

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

}
