package com.onlinefoodorder.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onlinefoodorder.DAO.MenuDAO;
import com.onlinefoodorder.DAO.OrderDAO;
import com.onlinefoodorder.DAO.UserDAO;
import com.onlinefoodorder.pojo.Login;
import com.onlinefoodorder.pojo.Menu;
import com.onlinefoodorder.pojo.Order;
import com.onlinefoodorder.pojo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class Customercontroller {

	ArrayList<String> itemInCartInString = new ArrayList();
	ArrayList<Menu> itemInCart = new ArrayList<Menu>();

	@GetMapping(value = "/customerViewRestaurant.htm")
	public ModelAndView customerViewRestaurantS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/customerViewRestaurant.htm")
	public ModelAndView customerViewRestaurant(HttpServletRequest request, UserDAO userDAO) {

		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Customer")) {

				request.setAttribute("user", new User());

				if (session.getAttribute("itemInCart") == null) {
					itemInCart.clear();
//					session.setAttribute("itemInCart", itemInCart);
				} else {

					session.removeAttribute("itemInCart");
				}

				List<User> displayAllRestaurantsToCustomer = userDAO.displayAllRestaurantsToCustomer();
				request.setAttribute("displayAllRestaurantsToCustomer", displayAllRestaurantsToCustomer);

				return new ModelAndView("customerViewRestaurant");
			}
		}
		return null;
	}

	@GetMapping("/customerViewRestaurantMenu.htm")
	public ModelAndView customerViewRestaurantMenuS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/customerViewRestaurantMenu.htm")
	public ModelAndView customerViewRestaurantMenu(HttpServletRequest request, MenuDAO menuDAO, UserDAO userDAO) {
		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Customer")) {

				int userId = Integer.parseInt(request.getParameter("userId"));

				String selectedResName = request.getParameter("userName");

				session.setAttribute("userId", userId);
				session.setAttribute("selectedResName", selectedResName);

				List<Menu> displayRestaurantMenu = menuDAO.displayAllMenuByRestaurantId(userId);
				request.setAttribute("displayRestaurantMenu", displayRestaurantMenu);

//				ArrayList<Menu> itemInCart = null;
//				if (session.getAttribute("itemInCart") == null) {
//					itemInCart = new ArrayList<Menu>();
//					session.setAttribute("itemInCart", itemInCart);
//				}

				return new ModelAndView("customerViewRestaurantMenu");
			}
		}
		return null;
	}

	@GetMapping("/addToCart.htm")
	public ModelAndView addToCart(HttpServletRequest request, MenuDAO menuDAO, Order order) {
		HttpSession session = request.getSession();

		request.setAttribute("user", new User());

		int menuId = Integer.parseInt(request.getParameter("menuId"));

		Menu orderMenuObj = menuDAO.getMenuObjById(menuId);

		System.out.println("Menu==name==in==menu==obje" + orderMenuObj.getMenuName());

		ArrayList<Menu> itemInCart = (ArrayList<Menu>) session.getAttribute("itemInCart");

		if (session.getAttribute("itemInCart") == null) {
			itemInCart = new ArrayList<Menu>();
			session.setAttribute("itemInCart", itemInCart);
			itemInCart.add(orderMenuObj);
		} else {
			itemInCart.add(orderMenuObj);
		}

		session.setAttribute("itemInCart", itemInCart);

//		======== setting as  string=======
		String menuName = orderMenuObj.getMenuName();

		if (session.getAttribute("itemInCartInString") == null) {
			itemInCartInString.clear();
			itemInCartInString.add(menuName);
		} else {
			itemInCartInString = (ArrayList<String>) session.getAttribute("itemInCartInString");
			itemInCartInString.add(menuName);
		}

		// itemInCartInString.add(menuName);
		System.out.println(itemInCartInString);
		session.setAttribute("itemInCartInString", itemInCartInString);

//		======== setting as string=======

		int RestaurantuserId = (int) session.getAttribute("userId");
		List<Menu> displayRestaurantMenu = menuDAO.displayAllMenuByRestaurantId(RestaurantuserId);

		request.setAttribute("displayRestaurantMenu", displayRestaurantMenu);

		return new ModelAndView("customerViewRestaurantMenu");
	}

	@GetMapping("/viewItemsToOrder.htm")
	public ModelAndView viewItemsToOrderS(HttpServletRequest request, OrderDAO orderDAO, Order order, Model model) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/viewItemsToOrder.htm")
	public ModelAndView customerViewOrders(HttpServletRequest request, OrderDAO orderDAO, Order order, Model model) {

		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Customer")) {

				ArrayList<Menu> itemInCart = (ArrayList<Menu>) session.getAttribute("itemInCart");

//				Iterator<Menu> iterator = itemInCart.iterator();
//				while (iterator.hasNext()) {
//					Menu m = iterator.next();
//					System.out.println(m.getMenuId() + "\\" + m.getMenuName());
//				}

				session.setAttribute("itemInCart", itemInCart);

				return new ModelAndView("customerViewOrders");
			}
		}
		return null;
	}

	@GetMapping("/deletOrder.htm")
	public ModelAndView deletOrder(HttpServletRequest request, MenuDAO menuDAO, Order order) {

		HttpSession session = request.getSession();

		request.setAttribute("user", new User());

		int menuId = Integer.parseInt(request.getParameter("menuId"));

		Menu removeMenuObjFromSession = menuDAO.getMenuObjById(menuId);
//
//		System.out.println("Menu==name==in==menu==obje" + removeMenuObjFromSession.getMenuId());
//		System.out.println("Menu==name==in==menu==obje" + removeMenuObjFromSession.getMenuName());

		ArrayList<Menu> itemInCart = (ArrayList<Menu>) session.getAttribute("itemInCart");

		for (Menu menu : itemInCart) {
			System.out.println("Menu==name==in==menu==obje" + menu.getMenuId());
			System.out.println("Menu==name==in==menu==obje" + menu.getMenuName());
		}

//		if (itemInCart != null) {
//			for (Menu menu : itemInCart)
//				if (itemInCart.contains(removeMenuObjFromSession)) {
//					itemInCart.remove(removeMenuObjFromSession);
//					session.setAttribute("itemInCart", itemInCart);
//					return new ModelAndView("customerViewOrders");
//
//				} else {
//					
//				return new ModelAndView("Customer");
//				}
		if (itemInCart != null) {

			for (Menu menu : itemInCart) {
				if (menu.getMenuId() == menuId) {
					itemInCart.remove(menu);
//					String itemName = menu.getMenuName();
//					order.getMenuItems().add(itemName);
//					session.setAttribute("order", order);
					session.setAttribute("itemInCart", itemInCart);
					return new ModelAndView("customerViewOrders");

				}
			}

		}
		return null;
	}

	@GetMapping("/placeOrder.htm")
	public ModelAndView placeOrderS(HttpServletRequest request, OrderDAO orderDAO, Order order, Model model) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/placeOrder.htm")
	public ModelAndView placeOrder(HttpServletRequest request, OrderDAO orderDAO, Model model) {

		HttpSession session = request.getSession();

		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Customer")) {
				User user = (User) session.getAttribute("loggedInUserobj");

				// =====many to many logic=====
//				ArrayList<Menu> itemInCart = (ArrayList<Menu>) session.getAttribute("itemInCart");
//				
//				
//				Order order = new Order();
//				order.setUser(user);
//
//				List<Menu> menuItems = new ArrayList<>();
//
//				for (Menu menu : itemInCart) {
//
//					System.out.println("%%%%%%orderItems%%%%%%" + menu.getMenuName());
//
//					menuItems.add(menu);
//
//				}
//				order.setMenu(menuItems);
//				
//				System.out.println(menuItems);
//				
//				System.out.println(order.getMenu());
//
//				orderDAO.addorder(order);
//				========many to many logic======

//				========= Save as String logic=========

//				

				ArrayList<String> itemInCartInString = (ArrayList<String>) session.getAttribute("itemInCartInString");

				String selectedResName = (String) session.getAttribute("selectedResName");

				System.out.println(session.getAttribute("itemInCartInString"));
				System.out.println(itemInCartInString.size());

//				Order order = (Order) session.getAttribute("order");
				Order order = new Order();
				for (String cartItems : itemInCartInString) {
					System.out.println("%%%%%%cartItems%%%%%%" + cartItems);
				}

				order.setUser(user);
				order.setRestaurant(selectedResName);
				order.setMenuItems(itemInCartInString);
				orderDAO.addorder(order);

				session.setAttribute("order", order);

				session.removeAttribute("itemInCart");
				session.removeAttribute("itemInCartInString");

				return new ModelAndView("ViewOrders");
			}
		}
		return null;
	}

	@PostMapping("/listOrderItems.htm")
	public ModelAndView listOrderItems(HttpServletRequest request, OrderDAO orderDAO) {
		HttpSession session = request.getSession();

		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Customer")) {

				request.setAttribute("menu", new Menu());

				Order order = (Order) session.getAttribute("order");

				int orderId = order.getOrderId();

				List<String> orderList = orderDAO.displayorder(orderId);

				request.setAttribute("orderList", orderList);
				session.setAttribute("orderList", orderList);

				return new ModelAndView("ListOrderItems");
			}
		}
		return null;
	}
	
	
	
	@PostMapping(value = "/pdf.htm")
	public View report(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		List <String> orderList =  (List<String>) session.getAttribute("orderList");
		
		View view = new Invoice(orderList);

		return view;

	}
	
	
	
	

	@GetMapping("/returnToCustomerMainPage.htm")
	public ModelAndView returnToCustomerMainPageS(HttpServletRequest request) {
		request.setAttribute("login", new Login());
		return new ModelAndView("Login");
	}

	@PostMapping("/returnToCustomerMainPage.htm")
	public ModelAndView returnToCustomerMainPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loggedInUserRole = (String) session.getAttribute("userRole");

		if (session.getAttribute("userName") != null && session.getAttribute("userRole") != null) {
			if (loggedInUserRole.equalsIgnoreCase("Customer")) {

				request.setAttribute("menu", new Menu());
				return new ModelAndView("Customer");
			}
		}
		return null;
	}

}
