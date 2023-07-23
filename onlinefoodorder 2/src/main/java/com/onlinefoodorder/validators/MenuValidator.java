package com.onlinefoodorder.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlinefoodorder.pojo.Login;
import com.onlinefoodorder.pojo.Menu;

@Component
public class MenuValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Menu.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuName", "error-menuName", "*menuName cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuPrice", "error-menuPrice", "*menuPrice cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuDescription", "error-menuDescription", "*menuDescription cannot be empty");
        
        Menu menu = (Menu) target;
        
       int price = menu.getMenuPrice();
        

        if(price < 0) {
        	errors.rejectValue("menuPrice", "error-menuPrice", "*Price cannot be negative");
        }
		
	}

}
