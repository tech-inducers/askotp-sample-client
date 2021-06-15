package com.techinducers.kuhak.kuhakAppeMailHandler.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class OTPEmailTrimmerUtilService {

	private static String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

	public String getToMSISDN(String fromEmailAddr) throws Exception {

		String phoneNumber = StringUtils.split(fromEmailAddr, "@")[0];
		Pattern pattern = Pattern.compile(patterns);

		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return phoneNumber;
		} else {

			throw new Exception("Invalid phone number");
		}
	}

	public boolean validateMSISDN(String fromEmailAddr) {
		try {
			String phoneNumber = StringUtils.split(fromEmailAddr, "@")[0];
			Pattern pattern = Pattern.compile(patterns);

			Matcher matcher = pattern.matcher(phoneNumber);
			return matcher.matches();
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
}
