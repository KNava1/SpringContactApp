/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.test;

import com.myhood.springcontactapp.config.SpringRootConfig;
import com.myhood.springcontactapp.domain.Users;
import com.myhood.springcontactapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author keerthi
 */
public class TestUserServiceRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
     UserService userService =ctx.getBean(UserService.class);
     Users u = new Users();
      u.setMY_NAME("Bravis");
      u.setPHONE("456-654-4345");
      u.setEMAIL("kapsf@gmail.com");
      u.setADDRESS("123 maple street");
      u.setLOGIN_NAME("brn");
      u.setPwd("byy");
      u.setROLE(UserService.ROLE_ADMIN);
      u.setLOGIN_STATUS(UserService.LOGIN_STATUS_ACTIVE);
      userService.register(u);
      String s =u.getUSERID();
      System.out.println("Registered successfully");
    }
    
}
