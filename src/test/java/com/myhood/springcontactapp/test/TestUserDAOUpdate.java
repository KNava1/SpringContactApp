/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.test;

import com.myhood.springcontactapp.config.SpringRootConfig;
import com.myhood.springcontactapp.dao.UsersDAO;
import com.myhood.springcontactapp.domain.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author keerthi
 */
public class TestUserDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
     UsersDAO userDAO =ctx.getBean(UsersDAO.class);
     Users u = new Users();
      u.setUSERID("1");
      u.setMY_NAME("Keerthi Navaneethan");
      u.setPHONE("562-283-5999");
      u.setEMAIL("navakeert@gmail.com");
      u.setADDRESS("123 ralph street");
      u.setROLE(1);
      u.setLOGIN_STATUS(1);
 //    u.setUSERID();
      userDAO.update(u);
      System.out.println("Data Updated");
    }
    
}
