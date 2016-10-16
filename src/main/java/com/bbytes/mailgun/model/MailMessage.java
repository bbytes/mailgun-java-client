package com.bbytes.mailgun.model;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MailMessage {

	private Set<String> toList = new HashSet<>();
	private Set<String> ccList = new HashSet<>();
	private Set<String> bccList = new HashSet<>();
	private Set<String> tagList = new HashSet<>();

	private Map<String, String> additionalParams = new HashMap<>();
	private Set<File> attachments = new HashSet<>();
	private Set<File> inline = new HashSet<>();

	private String from;
	private String subject;
	private String text;
	private String html;

	private ZonedDateTime deliveryTime;

	public MailMessage addTo(String... to) {
		addListValueInternal(to, toList);
		return this;
	}

	public MailMessage addCc(String... cc) {
		addListValueInternal(cc, ccList);
		return this;
	}

	public MailMessage addBcc(String... bcc) {
		addListValueInternal(bcc, bccList);
		return this;
	}

	public MailMessage addParam(String key, String value) {
		additionalParams.put(key, value);
		return this;
	}

	public MailMessage addTag(String... tag) {
		addListValueInternal(tag, tagList);
		return this;
	}

	public MailMessage addAttachment(File... files) {
		addListValueInternal(files, attachments);
		return this;
	}

	public MailMessage addInline(File... files) {
		addListValueInternal(files, inline);
		return this;
	}

	public List<String> getToList() {
		return new ArrayList<>(toList);
	}

	public List<String> getCcList() {
		return new ArrayList<>(ccList);
	}

	public List<String> getBccList() {
		return new ArrayList<>(bccList);
	}

	public String getFrom() {
		return from;
	}

	public MailMessage setFrom(String from) {
		this.from = from;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public MailMessage setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public String getText() {
		return text;
	}

	public MailMessage setText(String text) {
		this.text = text;
		return this;
	}

	public String getHtml() {
		return html;
	}

	public MailMessage setHtml(String html) {
		this.html = html;
		return this;
	}

	public void setToList(Collection<String> toList) {
		this.toList.addAll(toList);
	}

	public void setCcList(Collection<String> ccList) {
		this.ccList.addAll(ccList);
	}

	public void setBccList(Collection<String> bccList) {
		this.bccList.addAll(bccList);
	}

	public List<String> getTagList() {
		return new ArrayList<>(tagList);
	}

	public void setTagList(List<String> tagList) {
		this.tagList.addAll(tagList);
	}

	public ZonedDateTime getDeliveryTime() {
		return deliveryTime;
	}

	public MailMessage setDeliveryTime(ZonedDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
	}

	public List<File> getAttachments() {
		return new ArrayList<>(attachments);
	}

	public MailMessage setAttachments(List<File> attachments) {
		this.attachments.clear();
		this.attachments.addAll(attachments);
		return this;
	}

	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public List<File> getInline() {
		return new ArrayList<>(inline);
	}

	public MailMessage setInline(List<File> inline) {
		this.inline.clear();
		this.inline.addAll(inline);
		return this;

	}

	public MailMessage setAdditionalParams(Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	private <T> void addListValueInternal(T[] provideValues, Set<T> internalList) {
		if (provideValues != null) {
			for (T value : provideValues) {
				internalList.add(value);
			}
		}
	}

	public boolean hasAttachments() {
		return (attachments != null && !attachments.isEmpty() || (inline != null && !inline.isEmpty())) ? true : false;
	}
}
