package com.onlinefoodorder.onlinefoodorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.onlinefoodorder.controllers", "com.onlinefoodorder.pojo", "com.onlinefoodorder.validators", "com.onlinefoodorder.DAO", "com.onlinefoodorder.util"})
public class OnlinefoodorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinefoodorderApplication.class, args);
	}

}
