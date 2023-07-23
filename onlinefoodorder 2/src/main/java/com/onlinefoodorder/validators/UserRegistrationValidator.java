package com.onlinefoodorder.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlinefoodorder.DAO.UserDAO;
import com.onlinefoodorder.pojo.EmailCheckers;
import com.onlinefoodorder.pojo.Login;
import com.onlinefoodorder.pojo.User;

@Component
public class UserRegistrationValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error-firstName", "*firstName cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error-lastName", "*lastName cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error-userName", "*userName cannot be empty");
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error-password", "*Password cannot be empty");
//    typecasting
        User userReg = (User) target;
        
        String userName = userReg.getUserName();
        String email = userReg.getEmail();
        
        UserDAO userDAO = new UserDAO();
        
        boolean result = userDAO.checkIfUserAlreadyRegistered(userName);
        
        if(result){
            errors.rejectValue("userName", "error-userName", "*username already exist");
        }
        
        EmailCheckers emailchecks = new EmailCheckers();

            boolean isValidEmail = emailchecks.validate(email);
            if (!isValidEmail) {
                
                errors.rejectValue("email", "error-email", "*invalid email address");
            }
        
        
        
		
	}

}
