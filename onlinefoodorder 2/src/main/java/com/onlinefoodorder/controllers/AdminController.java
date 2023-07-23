package com.onlinefoodorder.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.onlinefoodorder.DAO.UserDAO;
import com.onlinefoodorder.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class AdminController {

	@PostMapping("/adminLogin.htm")
	public ModelAndView adminLogin(HttpServletRequest request) {

		return new ModelAndView("adminLogin");
	}

	@GetMapping("/returnAdminDashboard.htm")
	public ModelAndView returnAdminDashboardG(HttpServletRequest request) {

		return new ModelAndView("adminLogin");

	}

	@PostMapping("/returnAdminDashboard.htm")
	public ModelAndView returnAdminDashboard(HttpServletRequest request) {

		HttpSession session = request.getSession();

		String uName = (String) session.getAttribute("uName");

		if (uName.equalsIgnoreCase("admin")) {

			return new ModelAndView("AdminDashboard");

		}
		return null;
	}

	@GetMapping("/adminDashboard.htm")
	public ModelAndView adminDashboardG(HttpServletRequest request) {

		return new ModelAndView("adminLogin");

	}

	@PostMapping("/adminDashboard.htm")
	public ModelAndView adminDashboard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String uName = request.getParameter("fname");

		String password = request.getParameter("pass");

		if (uName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {

			session.setAttribute("uName", uName);

			return new ModelAndView("AdminDashboard");
		} else {
			return new ModelAndView("adminLogin");
		}

	}

	@GetMapping("/viewRestaurantsByAdmin.htm")
	public ModelAndView viewRestaurantsByAdminG(HttpServletRequest request) {

		return new ModelAndView("adminLogin");

	}

	@PostMapping("/viewRestaurantsByAdmin.htm")
	public ModelAndView viewRestaurantsByAdmin(HttpServletRequest request, UserDAO userDAO) {
		HttpSession session = request.getSession();

		String uName = (String) session.getAttribute("uName");

		if (uName.equalsIgnoreCase("admin")) {

			List<User> displayAllRestaurantsToCustomer = userDAO.displayAllRestaurantsToCustomer();

			request.setAttribute("displayAllRestaurantsToCustomer", displayAllRestaurantsToCustomer);

			return new ModelAndView("adminViewRestaurant");

		}
		return null;
	}

	@GetMapping("/viewCustomersByAdmin.htm")
	public ModelAndView viewCustomersByAdminG(HttpServletRequest request) {

		return new ModelAndView("adminLogin");

	}

	@PostMapping("/viewCustomersByAdmin.htm")
	public ModelAndView viewCustomersByAdmin(HttpServletRequest request, UserDAO userDAO) {
		HttpSession session = request.getSession();

		String uName = (String) session.getAttribute("uName");

		if (uName.equalsIgnoreCase("admin")) {

			List<User> displayAllRestaurantsToAdmin = userDAO.displayAllRestaurantsToAdmin();

			request.setAttribute("displayAllRestaurantsToAdmin", displayAllRestaurantsToAdmin);

			return new ModelAndView("adminViewCustomer");

		}
		return null;
	}
}
