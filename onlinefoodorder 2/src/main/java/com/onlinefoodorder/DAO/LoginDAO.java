package com.onlinefoodorder.DAO;

import org.springframework.stereotype.Component;

import com.onlinefoodorder.pojo.Login;

//bean will be created
@Component
public class LoginDAO extends DAO {
    public void saveUser(Login login) {
        try {
        begin(); 
        getSession().save(login);
        commit();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    
}