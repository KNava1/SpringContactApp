/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.service;

import com.myhood.springcontactapp.dao.BaseDAO;
import com.myhood.springcontactapp.dao.UsersDAO;
import com.myhood.springcontactapp.domain.Users;
import com.myhood.springcontactapp.exception.UserBlockedException;
import com.myhood.springcontactapp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author keerthi
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {
    @Autowired
    private UsersDAO userDAO;

    @Override
    public void register(Users u) {
       userDAO.save(u);
    }

    @Override
    public Users login(String loginName, String password) throws UserBlockedException {
       String sql="SELECT userid,my_name,phone,email,address,role,login_status,login_name "
               + "from my_users where login_name=:ln and pwd=:pw";
       Map m= new HashMap();
       m.put("ln",loginName);
       m.put("pw",password);
        try {
            Users u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if(u.getLOGIN_STATUS().equals(UserService.LOGIN_STATUS_BLOCKED)){
                throw new UserBlockedException("Your account has been blocked.Contact to admin");
            }
            else{
            return u;
            }
            
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Users> getUserList() {
        return userDAO.findByProperty("role", UserService.ROLE_USER);

    }

    @Override
    public void changeLoginStatus(String userId, Integer loginStatus) {
     String query="UPDATE MY_USERS SET LOGIN_STATUS=:lst WHERE USERID=:uid";
      Map m= new HashMap();
       m.put("uid",userId);
       m.put("lst",loginStatus);
       getNamedParameterJdbcTemplate().update(query, m);
       
    }

    @Override
    public Boolean isUserNameExist(String LoginName) {
      String query="SELECT COUNT(LOGIN_NAME) FROM MY_USERS WHERE LOGIN_NAME=?";
      Integer count = getJdbcTemplate().queryForObject(query, new String[]{LoginName},Integer.class);
      if(count.equals(1)){
          return true;
      }
      else{
          return false;
      }
      
    }
    
}
