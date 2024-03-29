package com.onlinefoodorder.pojo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class EmailCheckers {
	
	 private Pattern pattern;
	    private Matcher matcher;

	    public Pattern getPattern() {
	        return pattern;
	    }

	    public void setPattern(Pattern pattern) {
	        this.pattern = pattern;
	    }

	    public Matcher getMatcher() {
	        return matcher;
	    }

	    public void setMatcher(Matcher matcher) {
	        this.matcher = matcher;
	    }
	    
	    

	    public static final String EMAIL_PATTERN
	            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    public EmailCheckers() {
	        pattern = Pattern.compile(EMAIL_PATTERN);
	    }

	    /**
	     * Validate hex with regular expression
	     *
	     * @param hex hex for validation
	     * @return true valid hex, false invalid hex
	     */
	    public boolean validate(final String hex) {

	        matcher = pattern.matcher(hex);
	        return matcher.matches();

	    }

}
