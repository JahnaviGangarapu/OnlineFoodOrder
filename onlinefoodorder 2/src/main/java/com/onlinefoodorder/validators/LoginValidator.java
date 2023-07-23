package com.onlinefoodorder.validators;

import com.onlinefoodorder.DAO.UserDAO;
import com.onlinefoodorder.pojo.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error-userName", "*invalid userName address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error-password", "*Password cannot be empty");
		
		Login login = (Login) target;

		String userName = login.getUserName();
		String password = login.getPassword();

		UserDAO userDAO = new UserDAO();

		boolean authenticateUser = userDAO.checkUserIsValid(userName, password);

		if (!authenticateUser) {
			errors.rejectValue("userName", "error-userName", "*Invalid UserName");
			errors.rejectValue("password", "error-password", "*Invalid Password");

		}

	}

}
