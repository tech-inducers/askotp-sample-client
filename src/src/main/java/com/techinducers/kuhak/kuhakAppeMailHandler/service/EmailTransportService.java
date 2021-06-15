package com.techinducers.kuhak.kuhakAppeMailHandler.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailTransportService  {
	
	@Autowired
    private JavaMailSender emailSender;

	public void sendEmailzz(String from, String to, String subj, String msgText) {
		Properties props = System.getProperties();
		Session session = Session.getInstance(props);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// message.setHeader("x-local-message", "Hi there.");
			message.setSubject(subj);
			message.setText(msgText);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendEmail(String from, String to, String subj, String msgText) {
		try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subj);
            message.setText(msgText);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
	}

}
