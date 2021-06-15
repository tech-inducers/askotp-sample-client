package com.techinducers.kuhak.kuhakAppeMailHandler.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techinducers.kuhak.kuhakAppeMailHandler.vo.SMSCProps;

@Service
public class SMSCService {

	private static final Logger logger = LoggerFactory.getLogger(SMSCService.class);

	@Autowired
	private SMSCProps sMSCProps;
	
	public String sendSms(String toNumber, String smsText) {
		try {
			// Construct data
			String apiKey = "apikey=" + sMSCProps.getSmscApiKey();
			String message = "&message=" + smsText;
			String sender = "&sender=" + sMSCProps.getSmscSender();
			String numbers = "&numbers=" + toNumber;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			//System.out.println("------->> "+data);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			logger.error("Error SMS "+e);
			return "Error "+e;
		}
	}
}
