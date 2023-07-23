package com.onlinefoodorder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.onlinefoodorder.DAO.LoginDAO;
import com.onlinefoodorder.DAO.UserDAO;
import com.onlinefoodorder.pojo.Login;
import com.onlinefoodorder.pojo.User;
import com.onlinefoodorder.validators.LoginValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class Logincontroller {

	@Autowired
	LoginValidator loginValidator;
	
	

	@GetMapping("/login.htm")
	public ModelAndView UserLogin(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}
	
	@GetMapping("/aboutUs.htm")
	public ModelAndView aboutUs(HttpServletRequest request) {
		
		return new ModelAndView("aboutUs");
	}

	// Restaurant Page
	@PostMapping("/login.htm")
	public ModelAndView RestaurantPageRedirection(@ModelAttribute("login") Login login, BindingResult result,
			SessionStatus status, HttpServletRequest request, User user, UserDAO userDAO) throws Exception {
		HttpSession session = request.getSession();

		loginValidator.validate(login, result);

		if (result.hasErrors())
			return new ModelAndView("Login");

		status.setComplete();
		
	//used to check if the user already exists 

		User loggedInUserobj = userDAO.autheticatedUserObject(login);

		int userId = loggedInUserobj.getUserId();
		String userName = loggedInUserobj.getUserName();
		String loggedInUserRole = loggedInUserobj.getUserRoles();

		session.setAttribute("loggedInUserobj", loggedInUserobj);
		session.setAttribute("userRole", loggedInUserRole);
		session.setAttribute("userName", userName);
		session.setAttribute("userId", userId);
		//check if the same user goes to next page using session.
		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Customer")) {
				return new ModelAndView("Customer");
			}

			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {

				return new ModelAndView("Restaurant");
			}

		}
		if (session.getAttribute("loggedInUser") == null && session.getAttribute("loggedInUserRole") == null) {
			return new ModelAndView("Login");
		}

		return null;
	}

}
