package com.techinducers.kuhak.kuhakAppeMailHandler;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KuhakAppeMailHandlerApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void whenMatchesPhoneNumber_thenCorrect() {
	    String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

	    String[] validPhoneNumbers 
	      = {"2055550125","+912055550125", "(202) 555-0125", "+111 (202) 555-0125", 
	      "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};

	    Pattern pattern = Pattern.compile(patterns);
	    for(String phoneNumber : validPhoneNumbers) {
	        Matcher matcher = pattern.matcher(phoneNumber);
	        assertTrue(matcher.matches());
	    }
	}
}
