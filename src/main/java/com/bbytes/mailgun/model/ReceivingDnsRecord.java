package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceivingDnsRecord {

	@JsonProperty("priority")
	private String priority;
	@JsonProperty("record_type")
	private String recordType;
	@JsonProperty("valid")
	private String valid;
	@JsonProperty("value")
	private String value;

	/**
	 * 
	 * @return The priority
	 */
	@JsonProperty("priority")
	public String getPriority() {
		return priority;
	}

	/**
	 * 
	 * @param priority
	 *            The priority
	 */
	@JsonProperty("priority")
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * 
	 * @return The recordType
	 */
	@JsonProperty("record_type")
	public String getRecordType() {
		return recordType;
	}

	/**
	 * 
	 * @param recordType
	 *            The record_type
	 */
	@JsonProperty("record_type")
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	/**
	 * 
	 * @return The valid
	 */
	@JsonProperty("valid")
	public String getValid() {
		return valid;
	}

	/**
	 * 
	 * @param valid
	 *            The valid
	 */
	@JsonProperty("valid")
	public void setValid(String valid) {
		this.valid = valid;
	}

	/**
	 * 
	 * @return The value
	 */
	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            The value
	 */
	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

}