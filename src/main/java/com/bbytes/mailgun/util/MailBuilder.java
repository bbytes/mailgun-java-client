package com.bbytes.mailgun.util;

import java.io.File;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.bbytes.mailgun.model.MailMessage;

/**
 * A mutable builder for a {@code Mail}. This allows the creation of a
 * {@code Mail} by adding the desired parts in any order.
 * <p>
 * Can be instantiated using the constructor or a static factory method. In any
 * case the builder needs a configuration.
 */
@SuppressWarnings("unused")
public class MailBuilder {
 
	private MailMessage mailMessage = new MailMessage();

	public static MailBuilder create() {
		return new MailBuilder();
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
	 * {@link Configuration} object.
	 *
	 * @param from
	 *            the sender address
	 * @return this builder
	 */
	public MailBuilder from(String from) {
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
	public MailBuilder from(String name, String email) {
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
	public MailBuilder to(String to) {
		mailMessage.addTo(to);
		return this;
	}
	
	public MailBuilder to(String... to) {
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
	public MailBuilder to(String name, String email) {
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
	public MailBuilder cc(String cc) {
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
	public MailBuilder cc(String name, String email) {
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
	public MailBuilder bcc(String bcc) {
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
	public MailBuilder bcc(String name, String email) {
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
	public MailBuilder replyTo(String email) {
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
	public MailBuilder subject(String subject) {
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
	public MailBuilder text(String text) {
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
	public MailBuilder html(String html) {
		mailMessage.setHtml(html);
		return this;
	}
	
	/**
	 * Add attachment to email , add multiple files 
	 * @param files
	 * @return
	 */
	public MailBuilder addAttachments(File... files) {
		mailMessage.addAttachment(files);
		return this;
	}
	
	/**
	 * Add attachment to email
	 * @param files
	 * @return
	 */
	public MailBuilder addAttachment(File file) {
		mailMessage.addAttachment(file);
		return this;
	}
	
	/**
	 * Add inline images to mail
	 * @param files
	 * @return
	 */
	public MailBuilder addInlines(File... files) {
		mailMessage.addInline(files);
		return this;
	}
	
	/**
	 * Add inline image to mail
	 * @param file
	 * @return
	 */
	public MailBuilder addInline(File file) {
		mailMessage.addInline(file);
		return this;
	}
	
	/**
	 * Add tags
	 * @param tag
	 * @return
	 */
	public MailBuilder addTag(String... tag) {
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
	public MailBuilder parameter(String name, String value) {
		mailMessage.addParam(name, value);
		return this;
	}

}