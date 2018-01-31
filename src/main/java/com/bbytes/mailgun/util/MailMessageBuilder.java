package com.bbytes.mailgun.util;

import java.io.File;
import java.util.Collection;

import com.bbytes.mailgun.model.MailMessage;

/**
 * A mutable builder for a {@code Mail}. This allows the creation of a
 * {@code Mail} by adding the desired parts in any order.
 * <p>
 * Can be instantiated using the constructor or a static factory method. In any
 * case the builder needs a configuration.
 */

public class MailMessageBuilder {
 
	private MailMessage mailMessage = new MailMessage();

	public static MailMessageBuilder create() {
		return new MailMessageBuilder();
	}
	
	public MailMessage build() {
		return mailMessage;
	}

	/**
	 * Sets the address of the sender.
	 * <p>
	 * The address can be a simple email address ({@code doc@delorean.com}) or a
	 * full address with a name ({@code Emmet Brown <doc@delorean.com>}). The
	 * latter form can also be achieved using the {@link #from(String, String)}
	 * method.
	 * <p>
	 * You don't need to specify the sender address in every mail as it is
	 * usually the same. You can specify a default {@code From} address in the
	 * Configuration object.
	 *
	 * @param from
	 *            the sender address
	 * @return this builder
	 */
	public MailMessageBuilder from(String from) {
		mailMessage.setFrom(from);
		return this;
	}

	/**
	 * Sets the address of the sender.
	 *
	 * @param name
	 *            the name of the sender
	 * @param email
	 *            the address of the sender
	 * @return this builder
	 */
	public MailMessageBuilder from(String name, String email) {
		mailMessage.setFrom(name + " <" + email + ">");
		return this;
	}

	/**
	 * Adds a destination recipient's address.
	 * <p>
	 * The address can be a simple email address ({@code doc@delorean.com}) or a
	 * full address with a name ({@code Emmet Brown <doc@delorean.com>}). The
	 * latter form can also be achieved using the {@link #to(String, String)}
	 * method.
	 *
	 * @param to
	 *            an address
	 * @return this builder
	 */
	public MailMessageBuilder to(String to) {
		mailMessage.addTo(to);
		return this;
	}
	
	public MailMessageBuilder to(String... to) {
		mailMessage.addTo(to);
		return this;
	}
	
	public MailMessageBuilder to(Collection<String> to) {
		mailMessage.addTo(to);
		return this;
	}

	/**
	 * Adds a destination recipient's address.
	 *
	 * @param name
	 *            the name of the destination recipient
	 * @param email
	 *            the address of the destination recipient
	 * @return this builder
	 */
	public MailMessageBuilder to(String name, String email) {
		mailMessage.addTo(name + "<" + email + ">");
		return this;
	}

	/**
	 * Adds a CC recipient's address.
	 * <p>
	 * The address can be a simple email address ({@code doc@delorean.com}) or a
	 * full address with a name ({@code Emmet Brown <doc@delorean.com>}). The
	 * latter form can also be achieved using the {@link #cc(String, String)}
	 * method.
	 *
	 * @param cc
	 *            an address
	 * @return this builder
	 */
	public MailMessageBuilder cc(String cc) {
		mailMessage.addCc(cc);
		return this;
	}
	
	public MailMessageBuilder cc(String... cc) {
		mailMessage.addCc(cc);
		return this;
	}
	
	public MailMessageBuilder cc(Collection<String> cc) {
		mailMessage.addCc(cc);
		return this;
	}

	/**
	 * Adds a CC recipient's address.
	 *
	 * @param name
	 *            the name of the CC recipient
	 * @param email
	 *            the address of the CC recipient
	 * @return this builder
	 */
	public MailMessageBuilder cc(String name, String email) {
		mailMessage.addCc(name + " <" + email + ">");
		return this;
	}

	/**
	 * Adds a BCC recipient's address.
	 * <p>
	 * The address can be a simple email address ({@code doc@delorean.com}) or a
	 * full address with a name ({@code Emmet Brown <doc@delorean.com>}). The
	 * latter form can also be achieved using the {@link #bcc(String, String)}
	 * method.
	 *
	 * @param bcc
	 *            an address
	 * @return this builder
	 */
	public MailMessageBuilder bcc(String bcc) {
		mailMessage.addBcc(bcc);
		return this;
	}
	
	public MailMessageBuilder bcc(String... bcc) {
		mailMessage.addBcc(bcc);
		return this;
	}
	
	public MailMessageBuilder bcc(Collection<String> bcc) {
		mailMessage.addBcc(bcc);
		return this;
	}

	/**
	 * Adds a BCC recipient's address.
	 *
	 * @param name
	 *            the name of the BCC recipient
	 * @param email
	 *            the address of the BCC recipient
	 * @return this builder
	 */
	public MailMessageBuilder bcc(String name, String email) {
		mailMessage.addBcc(name + " <" + email + ">");
		return this;
	}

	/**
	 * Sets the {@code reply-to} field.
	 * <p>
	 * This method adds the param {@code h:Reply-To} to the Mailgun request.
	 *
	 * @param email
	 *            an email address
	 * @return this builder
	 */
	public MailMessageBuilder replyTo(String email) {
		mailMessage.addParam("h:Reply-To", email);
		return this;
	}

	/**
	 * Sets the subject of the message.
	 *
	 * @param subject
	 *            the subject
	 * @return this builder
	 */
	public MailMessageBuilder subject(String subject) {
		mailMessage.setSubject(subject);
		return this;
	}

	/**
	 * Sets the plain-text version of the message body.
	 *
	 * @param text
	 *            the body of the message in plain text
	 * @return this builder
	 */
	public MailMessageBuilder text(String text) {
		mailMessage.setText(text);
		return this;
	}

	/**
	 * Sets the HTML version of the message body.
	 *
	 * @param html
	 *            the body of the message in HTML
	 * @return this builder
	 */
	public MailMessageBuilder html(String html) {
		mailMessage.setHtml(html);
		return this;
	}
	
	/**
	 * Add attachment to email , add multiple files 
	 * @param files
	 * @return
	 */
	public MailMessageBuilder addAttachments(File... files) {
		mailMessage.addAttachment(files);
		return this;
	}
	
	/**
	 * Add attachment to email
	 * @param files
	 * @return
	 */
	public MailMessageBuilder addAttachment(File file) {
		mailMessage.addAttachment(file);
		return this;
	}
	
	/**
	 * Add inline images to mail
	 * @param files
	 * @return
	 */
	public MailMessageBuilder addInlines(File... files) {
		mailMessage.addInline(files);
		return this;
	}
	
	/**
	 * Add inline image to mail
	 * @param file
	 * @return
	 */
	public MailMessageBuilder addInline(File file) {
		mailMessage.addInline(file);
		return this;
	}
	
	/**
	 * Add tags
	 * @param tag
	 * @return
	 */
	public MailMessageBuilder addTag(String... tag) {
		mailMessage.addTag(tag);
		return this;
	}

	/**
	 * Adds a custom parameter.
	 *
	 * @param name
	 *            the name of the parameter
	 * @param value
	 *            the value of the parameter
	 * @return this builder
	 */
	public MailMessageBuilder parameter(String name, String value) {
		mailMessage.addParam(name, value);
		return this;
	}

}