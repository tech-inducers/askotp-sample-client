package com.techinducers.kuhak.kuhakAppeMailHandler.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMTPProps {
	
	@Value("${spring.mail.username}")
	private String CREDENTIALS_LOGIN = "";
	@Value("${spring.mail.password}")
	private String CREDENTIALS_PASSWORD = "";
	@Value("${smtpserver.OTP_DOMAIN}")
	private String OTP_DOMAIN = "";
	@Value("${smtpserver.FROM_OTP_DOMAIN}")
	private String FROM_OTP_DOMAIN = "";
	public String getCREDENTIALS_LOGIN() {
		return CREDENTIALS_LOGIN;
	}
	public void setCREDENTIALS_LOGIN(String cREDENTIALS_LOGIN) {
		CREDENTIALS_LOGIN = cREDENTIALS_LOGIN;
	}
	public String getCREDENTIALS_PASSWORD() {
		return CREDENTIALS_PASSWORD;
	}
	public void setCREDENTIALS_PASSWORD(String cREDENTIALS_PASSWORD) {
		CREDENTIALS_PASSWORD = cREDENTIALS_PASSWORD;
	}
	public String getOTP_DOMAIN() {
		return OTP_DOMAIN;
	}
	public void setOTP_DOMAIN(String oTP_DOMAIN) {
		OTP_DOMAIN = oTP_DOMAIN;
	}
	public String getFROM_OTP_DOMAIN() {
		return FROM_OTP_DOMAIN;
	}
	public void setFROM_OTP_DOMAIN(String fROM_OTP_DOMAIN) {
		FROM_OTP_DOMAIN = fROM_OTP_DOMAIN;
	}
	@Override
	public String toString() {
		return "SMTPProps [CREDENTIALS_LOGIN=" + CREDENTIALS_LOGIN + ", CREDENTIALS_PASSWORD=" + CREDENTIALS_PASSWORD
				+ ", OTP_DOMAIN=" + OTP_DOMAIN + ", FROM_OTP_DOMAIN=" + FROM_OTP_DOMAIN + "]";
	}
	
	
}
