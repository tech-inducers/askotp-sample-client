package com.techinducers.kuhak.kuhakAppeMailHandler.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SMSCProps {
	@Value("${smsc.api_key}")
	private String smscApiKey = "";
	@Value("${smsc.DLT_HEADER}")
	private String smscSender = "";

	public String getSmscApiKey() {
		return smscApiKey;
	}

	public void setSmscApiKey(String smscApiKey) {
		this.smscApiKey = smscApiKey;
	}

	public String getSmscSender() {
		return smscSender;
	}

	public void setSmscSender(String smscSender) {
		this.smscSender = smscSender;
	}

}