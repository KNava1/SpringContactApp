/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.dao;

import com.myhood.springcontactapp.domain.Contacts;
import java.util.List;

/**
 *
 * @author keerthi
 */
public interface ContactsDAO {
    public void save(Contacts c);
    public void update(Contacts c);
    public void delete(Contacts c);
    public void delete(String contactId);
    public Contacts findById(String contactId);
    public List<Contacts> findAll();
    public List<Contacts> findByProperty(String propName,Object propValue);
    
}
