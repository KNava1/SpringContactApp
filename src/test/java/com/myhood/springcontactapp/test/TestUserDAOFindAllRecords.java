/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.test;

import com.myhood.springcontactapp.config.SpringRootConfig;
import com.myhood.springcontactapp.dao.UsersDAO;
import com.myhood.springcontactapp.domain.Users;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author keerthi
 */
public class TestUserDAOFindAllRecords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
     UsersDAO userDAO =ctx.getBean(UsersDAO.class);
     
      List<Users> users=userDAO.findAll();
      for(Users u:users ){
          System.out.println(u.getUSERID()+ " " + u.getMY_NAME()+ " " + u.getPHONE() + " " + u.getEMAIL() + " " + u.getADDRESS() + " " + u.getLOGIN_NAME() + " " + u.getLOGIN_STATUS() + " " + u.getROLE() );
      }
    
    }
    
}
