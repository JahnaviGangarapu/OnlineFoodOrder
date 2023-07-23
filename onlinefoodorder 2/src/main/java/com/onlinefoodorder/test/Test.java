package com.onlinefoodorder.test;

import com.onlinefoodorder.DAO.LoginDAO;
import com.onlinefoodorder.pojo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Login login = new Login();
		login.setUserName("Anitha");
		login.setPassword("ani");
		
		LoginDAO loginDAO = new LoginDAO();
		
		loginDAO.saveUser(login);
		
		

	}

}
