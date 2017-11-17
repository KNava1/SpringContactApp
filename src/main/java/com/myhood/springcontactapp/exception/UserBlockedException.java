/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhood.springcontactapp.exception;

/**
 *
 * @author keerthi
 */
public class UserBlockedException extends Exception{
    
    public UserBlockedException(){
        
    }
      public UserBlockedException(String errdesc){
          super(errdesc);
          
          
      }
    
    
}
