package com.hxqh.abb.model.dto.action;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginDto{");
        sb.append("loginid='").append(loginid).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
