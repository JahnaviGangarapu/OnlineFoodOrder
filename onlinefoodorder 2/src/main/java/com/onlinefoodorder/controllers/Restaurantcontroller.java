package com.onlinefoodorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.onlinefoodorder.DAO.MenuDAO;
import com.onlinefoodorder.DAO.UserDAO;
import com.onlinefoodorder.pojo.Login;
import com.onlinefoodorder.pojo.Menu;
import com.onlinefoodorder.pojo.User;
import com.onlinefoodorder.validators.MenuValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class Restaurantcontroller {

	@Autowired
	MenuValidator menuValidator;

	@GetMapping(value = "/addMenu.htm")
	public ModelAndView addMenuS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping(value = "/addMenu.htm")
	public ModelAndView addMenu(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {
				request.setAttribute("menu", new Menu());
				return new ModelAndView("AddMenu");
			}
		}
		return null;
	}

	@GetMapping("/addMenuSubmit.htm")
	public ModelAndView addMenuSubmitS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/addMenuSubmit.htm")
	public ModelAndView addMenuSubmit(@ModelAttribute("menu") Menu menu, BindingResult result, SessionStatus status,
			HttpServletRequest request, MenuDAO menuDAO) throws Exception {

		menuValidator.validate(menu, result);

		if (result.hasErrors())
			return new ModelAndView("AddMenu");

		status.setComplete();

		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {
				menu.setUser((User) session.getAttribute("loggedInUserobj"));
				menuDAO.addItem(menu);

				return new ModelAndView("Restaurant");
			}

		}
		return null;
	}

	@GetMapping("/viewMenu.htm")
	public ModelAndView viewMenuS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/viewMenu.htm")
	public ModelAndView viewMenu(HttpServletRequest request, MenuDAO menuDAO) {

		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {

				int userId = (int) session.getAttribute("userId");

				List<Menu> menuList = menuDAO.displayAllMenuByRestaurantId(userId);

				session.setAttribute("menuList", menuList);

				return new ModelAndView("ViewMenu");
			}
		}
		return null;
	}

	@GetMapping("/updateMenu.htm")
	public ModelAndView updateMenuS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/updateMenu.htm")
	public ModelAndView updateMenu(HttpServletRequest request, MenuDAO menuDAO, Model model) {
		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {

				int menuId = Integer.valueOf(request.getParameter("menuId"));

				Menu menuObjById = menuDAO.getMenuObjById(menuId);
				session.setAttribute("menu", menuObjById);
				model.addAttribute("menu", menuObjById);
				return new ModelAndView("UpdateMenu");
			}
		}
		return null;
	}

	@GetMapping("/updateMenuSubmit.htm")
	public ModelAndView updateMenuSubmitS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/updateMenuSubmit.htm")
	public ModelAndView updateMenuSubmit(@ModelAttribute("menu") Menu menu, BindingResult result, SessionStatus status,
			HttpServletRequest request, MenuDAO menuDAO) throws Exception {

		menuValidator.validate(menu, result);

		if (result.hasErrors())
			return new ModelAndView("AddMenu");

		status.setComplete();
		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {
				menu.setUser((User) session.getAttribute("loggedInUserobj"));
				menuDAO.updateMenuItem(menu);

				return new ModelAndView("Restaurant");
			}
		}
		return null;
	}

	@GetMapping("/deleteMenu.htm")
	public ModelAndView deleteMenuG(HttpServletRequest request, MenuDAO menuDAO, Model model) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/deleteMenu.htm")
	public ModelAndView deleteMenu(HttpServletRequest request, MenuDAO menuDAO, Model model) {
		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {
				int menuId = Integer.valueOf(request.getParameter("menuId"));

				menuDAO.deleteMenu(menuId);

				int userId = (int) session.getAttribute("userId");

				List<Menu> menuList = menuDAO.displayAllMenuByRestaurantId(userId);

				session.setAttribute("menuList", menuList);
//		request.setAttribute("menu", new Menu());
				return new ModelAndView("ViewMenu");
			}
		}
		return null;
	}



	@GetMapping("/returnToMainPage.htm")
	public ModelAndView returnToMainPage(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/returnToMainPage.htm")
	public ModelAndView returnToMainPageS(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Restaurant")) {

				request.setAttribute("menu", new Menu());
				return new ModelAndView("Restaurant");
			}
		}
		return null;
	}

	@GetMapping("/logout.htm")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response, Login login) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
	        session.invalidate();
	    }
//	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//	    response.setDateHeader("Expires", 0); // Proxies.
		return new ModelAndView("Login");
	}

}
