package com.onlinefoodorder.DAO;

import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.onlinefoodorder.pojo.Login;
import com.onlinefoodorder.pojo.User;

@Component
public class UserDAO extends DAO {

	public void registerUser(User user) {
		try {
			begin();
			getSession().save(user);
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
	}

	public boolean checkIfUserAlreadyRegistered(String userName) {
		try {
			begin();
			Query q = getSession().createQuery("From User where userName=:username");
			q.setParameter("username", userName);
			List list = q.list();
			commit();
			if (list.size() == 0) {
				return false;
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		} finally {
			close();
		}
		return true;
	}

	public boolean checkUserIsValid(String uName, String password) {
		try {

			Query query = getSession().createQuery("From User where userName=:username and password=:password");
			query.setParameter("username", uName);
			query.setParameter("password", password);
			User result = (User) query.uniqueResult();

			if (result == null) {
				return false; // the userName and password is not present in the DB and not valid
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		} finally {
			close();
		}

		return true; // if the userName and password is valid

	}
	
	
	
	 public User autheticatedUserObject(Login login) {
	        
		 User user = null;

	        String uName = login.getUserName();
	        String pass = login.getPassword();
	        try {

	            Query query = getSession().createQuery(
	                    "From User where userName=:username and password=:password");
	            query.setParameter("username", uName);
	            query.setParameter("password", pass);
	            user = (User) query.uniqueResult();

	        } catch (Exception e) {

	            System.out.println(e.getMessage());
	        } finally {
	            close();
	        }

	        return user; // if the userName and password is valid

	    }
	

	public List<User> displayAllRestaurantsToCustomer() {

		List<User> displayAllRestaurantsToCustomer = null;
		try {
			begin();
			System.out.println("in DAO");
			Query query = getSession().createQuery("From User where userRoles =:role");
			query.setParameter("role", "Restaurant");

			displayAllRestaurantsToCustomer = query.list();
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
		return displayAllRestaurantsToCustomer;
	}
	
	
	
	public List<User> displayAllRestaurantsToAdmin() {

		List<User> displayAllRestaurantsToCustomer = null;
		try {
			begin();
			System.out.println("in DAO");
			Query query = getSession().createQuery("From User where userRoles =:role");
			query.setParameter("role", "Customer");

			displayAllRestaurantsToCustomer = query.list();
			commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			close();
		}
		return displayAllRestaurantsToCustomer;
	}
	
	
//	public User getUser(int userId) {
//        
//		 User user = null;
//
//	        try {
//
//	            Query query = getSession().createQuery(
//	                    "From User where userId=:userId");
//	            query.setParameter("userId", userId);
//	            user = (User) query.uniqueResult();
//
//	        } catch (Exception e) {
//
//	            System.out.println(e.getMessage());
//	        } finally {
//	            close();
//	        }
//
//	        return user;
//
//	    }
	

}
