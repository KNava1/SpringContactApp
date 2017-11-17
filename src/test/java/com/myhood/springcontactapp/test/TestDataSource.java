/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.test;

import com.myhood.springcontactapp.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author keerthi
 */
public class TestDataSource {
    
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds= ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql="INSERT INTO MY_USERS (MY_NAME, PHONE, EMAIL,ADDRESS,LOGIN_NAME,PWD) values(?,?,?,?,?,?) ";
        Object[] parameters= new Object[]{"Keerthi","5622835999","navakeert@gmail.com","123 abhg ave","knava1","vkn"};
        jt.update(sql,parameters);
        System.out.println("SQL executed");
        
    }
    
}
