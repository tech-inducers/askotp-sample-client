package com.techinducers.kuhak.kuhakAppeMailHandler.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.auth.LoginFailedException;
import org.subethamail.smtp.auth.UsernamePasswordValidator;

import com.techinducers.kuhak.kuhakAppeMailHandler.vo.SMTPProps;

@Service
public class AuthValidatorImpl implements UsernamePasswordValidator {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthValidatorImpl.class);
	
	@Autowired
	private SMTPProps sMTPProps;
	
	public AuthValidatorImpl() {
		this.sMTPProps = new SMTPProps();
		
	}
	
	
	
	@Override
	public void login(String username, String password, MessageContext context) throws LoginFailedException {
		//System.out.println(this.sMTPProps);
		if (sMTPProps.getCREDENTIALS_LOGIN().equals(username) && sMTPProps.getCREDENTIALS_PASSWORD().equals(password)) {
			logger.info("Authenticated successfully:: "+username);
		} else {
			logger.error("Invalid authentication ! --> "+username + " with password <<<enable debug to see password>> ");
			logger.debug("'"+password+"'");
			throw new LoginFailedException();
		}

	}

}
