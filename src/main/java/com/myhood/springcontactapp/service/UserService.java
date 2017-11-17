/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.service;

import com.myhood.springcontactapp.domain.Users;
import com.myhood.springcontactapp.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author keerthi
 */
public interface UserService {
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;
    
    public void register(Users u);
    public Users login (String loginName,String password) throws UserBlockedException; 
    public List<Users> getUserList();
    public void changeLoginStatus(String userId,Integer LoginStatus);
    
    public Boolean isUserNameExist(String LoginName);
          
    
}
