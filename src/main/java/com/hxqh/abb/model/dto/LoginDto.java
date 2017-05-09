package com.hxqh.abb.model.dto;

import java.math.BigDecimal;

/**
 * Created by Ocean Lin on 2017/5/7.
 */
public class LoginDto {

    private String loginid;
    
    private String password;

    public LoginDto() {
    }

    public LoginDto(String loginid, String password) {
        this.loginid = loginid;
        this.password = password;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
