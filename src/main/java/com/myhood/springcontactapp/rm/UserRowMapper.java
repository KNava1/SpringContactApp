/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.rm;

import com.myhood.springcontactapp.domain.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author keerthi
 */
public class UserRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int i) throws SQLException {
       Users u =new Users();
       u.setUSERID(rs.getString("USERID"));
       u.setMY_NAME(rs.getString("MY_NAME"));
       u.setEMAIL(rs.getString("EMAIL"));
       u.setADDRESS(rs.getString("ADDRESS"));
       u.setLOGIN_NAME(rs.getString("LOGIN_NAME"));
       u.setROLE(rs.getInt("ROLE"));
       u.setLOGIN_STATUS(rs.getInt("LOGIN_STATUS"));
       return u;
       
    }
    
}
