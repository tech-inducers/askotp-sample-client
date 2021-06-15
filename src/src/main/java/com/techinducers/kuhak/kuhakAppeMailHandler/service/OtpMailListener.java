package com.techinducers.kuhak.kuhakAppeMailHandler.service;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.subethamail.smtp.helper.SimpleMessageListener;

import com.techinducers.kuhak.kuhakAppeMailHandler.vo.ReceivedEmail;
import com.techinducers.kuhak.kuhakAppeMailHandler.vo.SMTPProps;

@Configuration
public class OtpMailListener implements SimpleMessageListener {
	
	private static final Logger logger = LoggerFactory.getLogger(OtpMailListener.class);
	
	@Autowired
	SMTPProps sMTPProps;
	
	@Autowired
	SMSCService sMSCService;
	
	@Autowired
	OTPEmailTrimmerUtilService oTPEmailTrimmerUtilService;
	
	@Autowired
	EmailTransportService emailTransportService;
	
	@Autowired
	private EmailContentService emailContentService;

	public OtpMailListener(EmailContentService emailContentService) {
		this.emailContentService = emailContentService;
	}

	/**
	 * Check if the received email is for this listener based on business logic
	 * (recipient email address)
	 *
	 * @param from      is a the sender email address.
	 * @param recipient is a the recipient email address.
	 *
	 * @return true if the recipient is an address of MARKETING department.
	 */
	@Override
	public boolean accept(String from, String recipient) {
		logger.info("Recipient : " + recipient);
		logger.info("From : " + from);
		return recipient != null && recipient.endsWith(sMTPProps.getOTP_DOMAIN()) && from.endsWith(sMTPProps.getFROM_OTP_DOMAIN())  && oTPEmailTrimmerUtilService.validateMSISDN(recipient);
	}

	@Override
	public void deliver(String from, String recipient, InputStream data) {
		logger.info("From : " + from);
		logger.info("Recipient : " + recipient);
		
		try {
			logger.info("SMS Recipient : " + oTPEmailTrimmerUtilService.getToMSISDN(recipient));
			
			ReceivedEmail receivedEmail=emailContentService.extractReceivedEmail(data);
			
			//sMSCService.sendSms(oTPEmailTrimmerUtilService.getToMSISDN(recipient), receivedEmail.getBody());
			//emailTransportService.sendEmail(from, "in.kol.shamim@kuhaksec.com", receivedEmail.getSubject(), receivedEmail.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
