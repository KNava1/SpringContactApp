/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.dao;

import com.myhood.springcontactapp.domain.Contacts;
import com.myhood.springcontactapp.rm.ContactRowMapper;
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
public class ContactDAOImpl extends BaseDAO implements ContactsDAO {

    @Override
    public void save(Contacts c) {
      String query="INSERT INTO CONTACTS(USERID,NAME,PHONE,EMAIL,ADDRESS,REMARK) VALUES(:USERID,:NAME,:PHONE,:EMAIL,:ADDRESS,:REMARK)";
        Map m = new HashMap();
            m.put("USERID",c.getUSERID());
            m.put("NAME",c.getNAME());
            m.put("PHONE",c.getPHONE());
            m.put("EMAIL",c.getEMAIL());
            m.put("ADDRESS",c.getADDRESS());
            m.put("REMARK",c.getREMARK());
                KeyHolder kh = new GeneratedKeyHolder();
            SqlParameterSource ps = new MapSqlParameterSource(m);
            super.getNamedParameterJdbcTemplate().update(query, ps, kh,new String[]{"CONTACTID"});
            String contactId =(String)kh.getKeys().get("CONTACTID");
            c.setCONTACTID(contactId);
      
    }

    @Override
    public void update(Contacts c) {
         String query="UPDATE CONTACTS SET NAME=:NAME,PHONE=:PHONE,EMAIL=:EMAIL,ADDRESS=:ADDRESS,REMARK=:REMARK WHERE CONTACTID=:CONTACTID";
        Map m = new HashMap();
            m.put("CONTACTID",c.getCONTACTID());
            m.put("NAME",c.getNAME());
            m.put("PHONE",c.getPHONE());
            m.put("EMAIL",c.getEMAIL());
            m.put("ADDRESS",c.getADDRESS());
            m.put("REMARK",c.getREMARK());
            
            getNamedParameterJdbcTemplate().update(query, m);
            
    }

    @Override
    public void delete(Contacts c) {
        this.delete(c.getCONTACTID());
    }

    @Override
    public void delete(String contactId) {
         String query ="DELETE FROM CONTACTS where CONTACTID=?";
        getJdbcTemplate().update(query, contactId);
    }

    @Override
    public Contacts findById(String contactId) {
          String query="SELECT CONTACTID,USERID,NAME,PHONE,EMAIL,ADDRESS,REMARK"
            +" FROM CONTACTS where CONTACTID=?";
    return getJdbcTemplate().queryForObject(query, new ContactRowMapper(),contactId);
    
    }

    @Override
    public List<Contacts> findAll() {
     String query="SELECT CONTACTID,NAME,PHONE,EMAIL,ADDRESS,REMARK"
            +" FROM CONTACTS ";    
      return getJdbcTemplate().query(query, new ContactRowMapper());
    }

    @Override
    public List<Contacts> findByProperty(String propName, Object propValue) {
         String query="SELECT CONTACTID,USERID,NAME,PHONE,EMAIL,ADDRESS,REMARK"
            +" FROM CONTACTS where " + propName + "=? ";
    return getJdbcTemplate().query(query, new ContactRowMapper(),propValue);
    }
    
}
