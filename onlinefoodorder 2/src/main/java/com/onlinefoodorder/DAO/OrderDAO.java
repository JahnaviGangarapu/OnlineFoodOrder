package com.onlinefoodorder.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.onlinefoodorder.pojo.Menu;
import com.onlinefoodorder.pojo.Order;

@Component
public class OrderDAO extends DAO {
	
	public void addorder(Order order) {
		try {
			begin();
//			getSession().clear();
			System.out.println("OrderDAO");
			getSession().save(order);
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
	}
	
	
	public List<String> displayorder(int orderId) {

		List<String> orderList = null;
		try {
			begin();
//			Query query = getSession().createQuery("Select Menu from MenuItems where orderId =:orderId");
			Query query = getSession().createSQLQuery("SELECT Menu FROM MenuItems where orderId =:orderId");
			query.setParameter("orderId", orderId);
			orderList = query.list();
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
		return orderList;
	}
	

}
