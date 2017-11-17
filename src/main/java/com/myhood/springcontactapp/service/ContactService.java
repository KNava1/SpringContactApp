/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.service;

import com.myhood.springcontactapp.domain.Contacts;
import java.util.List;

/**
 *
 * @author keerthi
 */
public interface ContactService {
    public void save(Contacts c);
    public void update(Contacts c);
    public void delete(String contactId);
    public void delete(String[] contactids);
    public Contacts findById(String contactId);
    public  List<Contacts>findUserContact(String userId);
    public  List<Contacts>findUserContact(String userId,String txt);
    
}
