package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendingDnsRecord {

	@JsonProperty("name")
	private String name;
	@JsonProperty("record_type")
	private String recordType;
	@JsonProperty("valid")
	private String valid;
	@JsonProperty("value")
	private String value;

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