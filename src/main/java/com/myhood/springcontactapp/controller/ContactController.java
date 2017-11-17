/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.controller;

import com.myhood.springcontactapp.domain.Contacts;
import com.myhood.springcontactapp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author keerthi
 */
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    
   @RequestMapping(value="/user/contact_form")
    public String contactForm(Model m){
        Contacts contact = new Contacts();
        m.addAttribute("command",contact);
        return "contact_form";
    }
    
      @RequestMapping(value="/user/edit_contact")
    public String prepareEditForm(Model m, HttpSession session,@RequestParam("cid") String contactId){
        session.setAttribute("aContactId", contactId);
        Contacts c= contactService.findById(contactId);
        m.addAttribute("command",c);
        return "contact_form";
    }
    
    @RequestMapping(value="/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command")Contacts c,Model m,HttpSession session){
     String contactId = (String) session.getAttribute("aContactId");
     if(contactId==null){
             try {
            String userId = (String) session.getAttribute("userId");
            c.setUSERID(userId);
            contactService.save(c);
            return "redirect:clist?act=sv";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Save contact");
            return "contact_form";
        }
     }
     else{
             try {
            c.setCONTACTID(contactId);
            contactService.update(c);
            return "redirect:clist?act=ed";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Edit contact");
            return "contact_form";
        }
         
     }
     
    }
    
      @RequestMapping(value="/user/clist")
    public String contactList(Model m, HttpSession session){
        String userId = (String) session.getAttribute("userId");
        m.addAttribute("contactList",contactService.findUserContact(userId));
        return "clist";
    }
    
    @RequestMapping(value="/user/del_contact")
    public String deleteContact(@RequestParam("cid") String contactId){
       contactService.delete(contactId);
        return "redirect:clist?act=del";
    }
    
    @RequestMapping(value="/user/contact_search")
    public String contactSearch(Model m, HttpSession session,@RequestParam("freeText")String freeText){
        String userId = (String) session.getAttribute("userId");
        m.addAttribute("contactList",contactService.findUserContact(userId,freeText));
        return "clist";
    }
    
    @RequestMapping(value="/user/bulk_cdelete")
    public String deleteBulkContact(@RequestParam("cid") String[] contactIds){
       contactService.delete(contactIds);
        return "redirect:clist?act=del";
    }
    
}
