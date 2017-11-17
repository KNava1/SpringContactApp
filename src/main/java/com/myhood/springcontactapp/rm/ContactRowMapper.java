/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.rm;

import com.myhood.springcontactapp.domain.Contacts;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author keerthi
 */
public class ContactRowMapper implements RowMapper<Contacts> {

    @Override
    public Contacts mapRow(ResultSet rs, int i) throws SQLException {
       Contacts c =new Contacts();
       c.setCONTACTID(rs.getString("CONTACTID"));
       c.setUSERID(rs.getString("USERID"));
       c.setNAME(rs.getString("NAME"));
       c.setEMAIL(rs.getString("EMAIL"));
       c.setADDRESS(rs.getString("ADDRESS"));
       c.setPHONE(rs.getString("PHONE"));
       c.setREMARK(rs.getString("REMARK"));
       return c;
       
    }
    
}
