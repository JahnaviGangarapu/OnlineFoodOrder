package com.onlinefoodorder.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.onlinefoodorder.pojo.*;

import jakarta.validation.constraints.Min;

@Component
@Entity
@Table(name = "MenuTable")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;
	private String menuName;

	private int menuPrice;
	private String menuDescription;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId", referencedColumnName = "userId")
	private User user;
	
//	@ManyToOne()
//	@JoinColumn(name="orderId")
//	private Order orders;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuDescription="
				+ menuDescription + ", user=" + user + "]";
	}
	
	
	

	
	
}
