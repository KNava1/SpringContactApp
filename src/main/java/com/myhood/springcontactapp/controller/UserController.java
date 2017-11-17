/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.controller;

import com.myhood.springcontactapp.command.LoginCommand;
import com.myhood.springcontactapp.command.UserCommand;
import com.myhood.springcontactapp.domain.Users;
import com.myhood.springcontactapp.exception.UserBlockedException;
import com.myhood.springcontactapp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author keerthi
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value={"/","/index"})
    public String index(Model m){
        m.addAttribute("command", new LoginCommand());
        return "index";
    }
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command")LoginCommand cmd,Model m,HttpSession session){
        try {
         
            Users loggedInUser = userService.login(cmd.getLoginName(),cmd.getPassword());
          if(loggedInUser==null){
              m.addAttribute("err","Login failed" );
            return "index"; 
          }
          else{
              if(loggedInUser.getROLE().equals(UserService.ROLE_ADMIN)){
                  addUserInSession(loggedInUser, session);
                  return "redirect:admin/dashboard";
              }
              else if(loggedInUser.getROLE().equals(UserService.ROLE_USER)){
                  addUserInSession(loggedInUser, session);
                  return "redirect:user/dashboard";
                  
              }
              else{
                   m.addAttribute("err", "invalid user");
                    return "index";
              }
          }
        } catch (UserBlockedException ex) {
            m.addAttribute("err", ex.getMessage());
            return "index";
           
        }
    }
    
    
     @RequestMapping(value="/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index?act=lo";
    }
    
    
    
    @RequestMapping(value="/user/dashboard")
    public String userDashboard(){
        return "dashboard_user";
    }
    
    @RequestMapping(value="/admin/dashboard")
    public String adminDashboard(){
        return "dashboard_admin";
    }
    
    @RequestMapping(value="/admin/users")
    public String getUserList(Model m){
        m.addAttribute("userList", userService.getUserList());
        return "users";
    }
    
    @RequestMapping(value="/reg_form")
    public String registrationForm(Model m){
        UserCommand cmd = new UserCommand();
        m.addAttribute("command", cmd);
        return "reg_form";
        
    }
    
      @RequestMapping(value="/admin/change_status")
      @ResponseBody
    public String changeLoginStatus(@RequestParam String userId,@RequestParam Integer loginStatus){
          try {
              userService.changeLoginStatus(userId, loginStatus);
              return "SUCCESS: Status Changed";
          } catch (Exception e) {
              e.printStackTrace();
              return "ERROR:Unable to change status";
          }
        
    }
    
      @RequestMapping(value="/check_avail")
      @ResponseBody
    public String checkAvailability(@RequestParam String username){
         if(userService.isUserNameExist(username)){
             return "User Name is already taken";
         }
         else{
             return "It is correct";
         }
        
    }
    
    
    
    
    @RequestMapping(value="/register")
    public String registerUser(@ModelAttribute("command")UserCommand cmd,Model m){
           try {
               Users users = cmd.getUsers();
               users.setROLE(UserService.ROLE_USER);
               users.setLOGIN_STATUS(UserService.LOGIN_STATUS_ACTIVE);
               userService.register(users);
               return "redirect:index?act=reg";
           } catch (DuplicateKeyException e) {
               e.printStackTrace();
               m.addAttribute("err","Username is already registered.Please select another username");
               return "reg_form";

           }
        
    }
    
    private void addUserInSession(Users u, HttpSession session){
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUSERID());
        session.setAttribute("role", u.getROLE());
    }
}
