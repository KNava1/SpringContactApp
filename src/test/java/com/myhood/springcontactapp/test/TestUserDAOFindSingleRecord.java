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
public class TestUserDAOFindSingleRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
     UsersDAO userDAO =ctx.getBean(UsersDAO.class);
     
      Users u=userDAO.findById("2");
      System.out.println("User Detail");
      System.out.println(u.getUSERID());
      System.out.println(u.getMY_NAME());
      System.out.println(u.getPHONE());
      System.out.println(u.getEMAIL());
      System.out.println(u.getADDRESS());
      System.out.println(u.getLOGIN_NAME());
      System.out.println(u.getLOGIN_STATUS());
      System.out.println(u.getROLE());
    }
    
}
