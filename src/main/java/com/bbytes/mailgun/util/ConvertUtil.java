package com.bbytes.mailgun.util;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.bbytes.mailgun.model.MailMessage;

public class ConvertUtil {

	private static final String ATTACHMENT = "attachment";

	private static final String INLINE = "inline";


	public static MultiValueMap<String, Object> convertMessageToMultiMap(MailMessage message)
			throws FileNotFoundException {

	
		MultiValueMap<String, Object> messageData = new LinkedMultiValueMap<>();

		messageData.add("to", StringUtils.collectionToCommaDelimitedString(message.getToList()));
		messageData.add("from", message.getFrom());

		if (message.getCcList().size() > 0) {
			messageData.add("cc", StringUtils.collectionToCommaDelimitedString(message.getCcList()));
		}

		if (message.getBccList().size() > 0) {
			messageData.add("bcc", StringUtils.collectionToCommaDelimitedString(message.getBccList()));
		}

		if (!StringUtils.isEmpty(message.getSubject()))
			messageData.add("subject", message.getSubject());

		if (!StringUtils.isEmpty(message.getText()))
			messageData.add("text", message.getText());

		if (!StringUtils.isEmpty(message.getHtml()))
			messageData.add("html", message.getHtml());

		for (String tag : message.getTagList()) {
			messageData.add("o:tag", tag);
		}
		

		for (File file : message.getAttachments()) {
			messageData.add(ATTACHMENT, new FileSystemResource(file));
		}

		for (File file : message.getInline()) {
			messageData.add(INLINE, new FileSystemResource(file));
		}

		return messageData;
	}

}
