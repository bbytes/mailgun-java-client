package com.bbytes.mailgun.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paging {

	@JsonProperty("first")
	private String first;
	@JsonProperty("last")
	private String last;
	@JsonProperty("next")
	private String next;
	@JsonProperty("previous")
	private String previous;

	/**
	 * 
	 * @return The first
	 */
	@JsonProperty("first")
	public String getFirst() {
		return first;
	}

	/**
	 * 
	 * @param first
	 *            The first
	 */
	@JsonProperty("first")
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * 
	 * @return The last
	 */
	@JsonProperty("last")
	public String getLast() {
		return last;
	}

	/**
	 * 
	 * @param last
	 *            The last
	 */
	@JsonProperty("last")
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * 
	 * @return The next
	 */
	@JsonProperty("next")
	public String getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 *            The next
	 */
	@JsonProperty("next")
	public void setNext(String next) {
		this.next = next;
	}

	/**
	 * 
	 * @return The previous
	 */
	@JsonProperty("previous")
	public String getPrevious() {
		return previous;
	}

	/**
	 * 
	 * @param previous
	 *            The previous
	 */
	@JsonProperty("previous")
	public void setPrevious(String previous) {
		this.previous = previous;
	}

}