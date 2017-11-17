/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.service;

import com.myhood.springcontactapp.dao.BaseDAO;
import com.myhood.springcontactapp.dao.ContactsDAO;
import com.myhood.springcontactapp.domain.Contacts;
import com.myhood.springcontactapp.rm.ContactRowMapper;
import com.myhood.springcontactapp.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author keerthi
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
    @Autowired
    private ContactsDAO contactDAO;
    

    @Override
    public void save(Contacts c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contacts c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(String contactId) {
     contactDAO.delete(contactId);
    }

    @Override
    public void delete(String[] contactids) {
    String ids= StringUtils.toCSString(contactids);
    String query="DELETE FROM CONTACTS WHERE CONTACTID IN(" +ids +")";
    getJdbcTemplate().update(query);
    }

    @Override
    public List<Contacts> findUserContact(String userId) {
       return contactDAO.findByProperty("USERID", userId);
    }

    @Override
    public List<Contacts> findUserContact(String userId, String txt) {
      String query="SELECT CONTACTID,USERID,NAME,PHONE,EMAIL,ADDRESS,REMARK"
            +" FROM CONTACTS WHERE USERID =? AND (NAME LIKE '%"+txt+"%' OR PHONE LIKE '%"+txt+"%' OR EMAIL LIKE '%"+txt+"%' OR ADDRESS LIKE '%"+txt+"%' OR REMARK LIKE '%"+txt+"%')";
    return getJdbcTemplate().query(query,new ContactRowMapper(),userId);
    }

    @Override
    public Contacts findById(String contactId) {
        return contactDAO.findById(contactId);
    }
    
}
