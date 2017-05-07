package com.hxqh.abb.model.dto;

import java.math.BigDecimal;

/**
 * Created by Ocean Lin on 2017/5/7.
 */
public class LoginDto {

    private String loginid;
    private String userid;

    public LoginDto() {
    }

    public LoginDto(String loginid, String userid) {
        this.loginid = loginid;
        this.userid = userid;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
