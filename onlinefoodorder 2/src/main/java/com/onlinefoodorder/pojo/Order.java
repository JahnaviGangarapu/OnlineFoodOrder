package com.onlinefoodorder.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

//	@OneToMany(mappedBy = "orders")
//	//@JoinColumn(name = "MenuId", referencedColumnName = "menuId")
//	List<Menu> menu;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "order_menu", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
//	List<Menu> menu;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "UserId", referencedColumnName = "userId")
	private User user;
	
	
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "MenuItems", joinColumns = @JoinColumn(name = "orderId"))
    @Column(name = "Menu")
	private List<String> MenuItems;
	
	private String restaurant;

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public List<String> getMenuItems() {
		return MenuItems;
	}

	public void setMenuItems(List<String> menuItems) {
		MenuItems = menuItems;
	}
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

//	public List<Menu> getMenu() {
//		return menu;
//	}
//
//	public void setMenu(List<Menu> menu) {
//		this.menu = menu;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", MenuItems=" + MenuItems + ", restaurant="
				+ restaurant + "]";
	}

	
}
