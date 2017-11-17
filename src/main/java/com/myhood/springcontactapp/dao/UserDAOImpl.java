/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.dao;

import com.myhood.springcontactapp.domain.Users;
import com.myhood.springcontactapp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author keerthi
 */
@Repository
public class UserDAOImpl extends BaseDAO implements UsersDAO {

    @Override
    public void save(Users u) {
        String query="INSERT INTO MY_USERS (MY_NAME, PHONE, EMAIL,ADDRESS,LOGIN_NAME,PWD,ROLE,LOGIN_STATUS)"
             +   "VALUES(:MY_NAME, :PHONE, :EMAIL,:ADDRESS,:LOGIN_NAME,:PWD,:ROLE,:LOGIN_STATUS)";
        Map m = new HashMap();
            m.put("MY_NAME",u.getMY_NAME());
            m.put("PHONE",u.getPHONE());
            m.put("EMAIL",u.getEMAIL());
            m.put("ADDRESS",u.getADDRESS());
            m.put("LOGIN_NAME",u.getLOGIN_NAME());
            m.put("PWD",u.getPwd());
            m.put("ROLE",u.getROLE());
            m.put("LOGIN_STATUS",u.getLOGIN_STATUS());
            
            KeyHolder kh = new GeneratedKeyHolder();
            SqlParameterSource ps = new MapSqlParameterSource(m);
            super.getNamedParameterJdbcTemplate().update(query, ps, kh,new String[]{"USERID"});
            String userId =(String)kh.getKeys().get("USERID");
            u.setUSERID(userId);
           
    }

    @Override
    public void update(Users u) {
    String query = "UPDATE MY_USERS SET MY_NAME=:MY_NAME, PHONE=:PHONE, EMAIL=:EMAIL, ADDRESS=:ADDRESS, "
            + " ROLE=:ROLE, LOGIN_STATUS=:LOGIN_STATUS "
            + " WHERE USERID=:USERID "; 
            Map m = new HashMap();
            m.put("MY_NAME",u.getMY_NAME());
            m.put("PHONE",u.getPHONE());
            m.put("EMAIL",u.getEMAIL());
            m.put("ADDRESS",u.getADDRESS());
            m.put("ROLE",u.getROLE());
            m.put("LOGIN_STATUS",u.getLOGIN_STATUS());
            m.put("USERID",u.getUSERID());
            getNamedParameterJdbcTemplate().update(query,m); 
            }

    @Override
    public void delete(Users u) {
       this.delete(u.getUSERID());
     }

    @Override
    public void delete(String userId) {
        String query ="DELETE FROM MY_USERS where USERID=?";
        getJdbcTemplate().update(query, userId);
    }

    @Override
    public Users findById(String userId) {
    String query="SELECT USERID,MY_NAME,PHONE,EMAIL,ADDRESS,LOGIN_NAME,ROLE,LOGIN_STATUS"
            +" FROM MY_USERS where USERID=?";
    Users u= getJdbcTemplate().queryForObject(query, new UserRowMapper(),userId);
    return u;
    }

    @Override
    public List<Users> findAll() {
          String query="SELECT USERID,MY_NAME,PHONE,EMAIL,ADDRESS,LOGIN_NAME,ROLE,LOGIN_STATUS"
                    +" FROM MY_USERS";
    
    return getJdbcTemplate().query(query, new UserRowMapper());
    }

    @Override
    public List<Users> findByProperty(String propName, Object propValue) {
        String query="SELECT USERID,MY_NAME,PHONE,EMAIL,ADDRESS,LOGIN_NAME,ROLE,LOGIN_STATUS"
                    +" FROM MY_USERS WHERE "+propName +"=?";
         return getJdbcTemplate().query(query, new UserRowMapper(),propValue);
    }
    
}
