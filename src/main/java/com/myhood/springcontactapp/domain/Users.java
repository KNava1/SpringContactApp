package com.myhood.springcontactapp.domain;

/**
 *
 * @author keerthi
 */
public class Users {
    private String USERID;
    private String MY_NAME;
    private String PHONE;
    private String EMAIL;
    private String ADDRESS;
    private String LOGIN_NAME;
    private Integer ROLE;
    private Integer LOGIN_STATUS;
    private String pwd;

    public Users() {
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getMY_NAME() {
        return MY_NAME;
    }

    public void setMY_NAME(String MY_NAME) {
        this.MY_NAME = MY_NAME;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getLOGIN_NAME() {
        return LOGIN_NAME;
    }

    public void setLOGIN_NAME(String LOGIN_NAME) {
        this.LOGIN_NAME = LOGIN_NAME;
    }

    public Integer getROLE() {
        return ROLE;
    }

    public void setROLE(Integer ROLE) {
        this.ROLE = ROLE;
    }

    public Integer getLOGIN_STATUS() {
        return LOGIN_STATUS;
    }

    public void setLOGIN_STATUS(Integer LOGIN_STATUS) {
        this.LOGIN_STATUS = LOGIN_STATUS;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
    
    
}
