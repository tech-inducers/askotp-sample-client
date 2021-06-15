package com.techinducers.kuhak.kuhakAppeMailHandler.vo;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

public class ReceivedEmail {
	private String subject;
	private String senderAddress;
	private String senderName;
	private String recipientAddress;
	private String recipientName;
	private String cc;
	private String bcc;
	private String contentType;
	private String body;
	private List<DataSource> attachments = new ArrayList<>();

	public ReceivedEmail() {
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<DataSource> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<DataSource> attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "ReceivedEmail [subject=" + subject + ", senderAddress=" + senderAddress + ", recipientAddress="
				+ recipientAddress + ", contentType=" + contentType + ", body=" + body + "]";
	}


}
