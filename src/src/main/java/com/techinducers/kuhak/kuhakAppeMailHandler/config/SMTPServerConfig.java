package com.techinducers.kuhak.kuhakAppeMailHandler.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.subethamail.smtp.auth.EasyAuthenticationHandlerFactory;
import org.subethamail.smtp.auth.UsernamePasswordValidator;
import org.subethamail.smtp.helper.SimpleMessageListener;
import org.subethamail.smtp.helper.SimpleMessageListenerAdapter;
import org.subethamail.smtp.server.SMTPServer;

@Configuration
public class SMTPServerConfig {

	private static final Logger logger = LoggerFactory.getLogger(SMTPServerConfig.class);

	private SMTPServer smtpServer;
	private SimpleMessageListener otpMailListener;
	@Autowired
	private UsernamePasswordValidator authValidator;
	private EasyAuthenticationHandlerFactory easyAuth;

	@Value("${smtpserver.enabled}")
	String enabled = "";
	@Value("${smtpserver.tls.enabled}")
	String enableTLS = "";
	@Value("${spring.mail.host}")
	String hostName = "";
	@Value("${spring.mail.properties.mail.smtp.port}")
	String port = "25";
	
	

	public SMTPServerConfig(SimpleMessageListener otpMailListener) {

		this.otpMailListener = otpMailListener;

	}

	@PostConstruct
	public void start() {
		// authValidator = new AuthValidatorImpl();
		easyAuth = new EasyAuthenticationHandlerFactory(authValidator);
		if (enabled.equalsIgnoreCase("true")) {
			if (enableTLS.equalsIgnoreCase("true")) {
				this.smtpServer = SMTPServer.port(Integer.valueOf(port)).hostName(this.hostName).hideTLS(true).maxConnections(100)
						.enableTLS(true).requireTLS(true).simpleMessageListener(this.otpMailListener).requireAuth(true)
						.authenticationHandlerFactory(easyAuth).build();
			} else {
				this.smtpServer = SMTPServer.port(Integer.valueOf(port)).hostName(this.hostName).maxConnections(100)
						.simpleMessageListener(this.otpMailListener).requireAuth(true)
						.authenticationHandlerFactory(easyAuth).build();
			}
			System.setProperty("mail.smtp.host", this.hostName);
			logger.info("starting the smtp with hostname " + hostName + " at " + port);
			this.smtpServer.start();
			logger.info("****** SMTP Server is running for domain " + smtpServer.getHostName() + " on port "
					+ smtpServer.getPort());
		} else {
			logger.info("****** SMTP Server NOT ENABLED by settings ");
		}
	}

	@PreDestroy
	public void stop() {
		if (enabled.equalsIgnoreCase("true")) {
			logger.info("****** Stopping SMTP Server for domain " + smtpServer.getHostName() + " on port "
					+ smtpServer.getPort());
			smtpServer.stop();
		}
	}

	public boolean isRunning() {
		return smtpServer.isRunning();
	}
}