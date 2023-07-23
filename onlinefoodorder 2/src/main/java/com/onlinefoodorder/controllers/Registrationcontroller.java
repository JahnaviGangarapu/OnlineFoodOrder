package com.onlinefoodorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.onlinefoodorder.DAO.UserDAO;
import com.onlinefoodorder.pojo.Login;
import com.onlinefoodorder.pojo.User;

import com.onlinefoodorder.validators.UserRegistrationValidator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Registrationcontroller {
	
	@Autowired
	UserRegistrationValidator userValidator;
	
	@GetMapping("/userRegistration.htm")
	public ModelAndView UserLogin(HttpServletRequest request) {
		request.setAttribute("user", new User());
		return new ModelAndView("Registration");
	}
	
	@PostMapping("/register.htm")
    public ModelAndView studentPageRedirection( @ModelAttribute("user")User user, BindingResult result, SessionStatus status, HttpServletRequest request, UserDAO userDAO) throws Exception {
       
        
		userValidator.validate(user, result);
   
        if(result.hasErrors())
        	return new ModelAndView("Registration");
        
        status.setComplete();
        
        userDAO.registerUser(user);
        
        request.setAttribute("login", new Login());
        
        return new ModelAndView("Login");          
    }


}
