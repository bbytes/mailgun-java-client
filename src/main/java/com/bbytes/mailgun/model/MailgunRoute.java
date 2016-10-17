package com.bbytes.mailgun.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailgunRoute {

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("actions")
	private List<String> actions = new ArrayList<String>();
	
	@JsonProperty("priority")
	private Integer priority;
	
	@JsonProperty("expression")
	private String expression;
	
	@JsonProperty("id")
	private String id;

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
	 * @return The actions
	 */
	@JsonProperty("actions")
	public List<String> getActions() {
		return actions;
	}

	/**
	 * 
	 * @param actions
	 *            The actions
	 */
	@JsonProperty("actions")
	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	/**
	 * 
	 * @return The priority
	 */
	@JsonProperty("priority")
	public Integer getPriority() {
		return priority;
	}

	/**
	 * 
	 * @param priority
	 *            The priority
	 */
	@JsonProperty("priority")
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * 
	 * @return The expression
	 */
	@JsonProperty("expression")
	public String getExpression() {
		return expression;
	}

	/**
	 * 
	 * @param expression
	 *            The expression
	 */
	@JsonProperty("expression")
	public void setExpression(String expression) {
		this.expression = expression;
	}

	/**
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

}