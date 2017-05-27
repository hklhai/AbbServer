package com.hxqh.abb.model.view;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the MAXUSER database table.
 */
@Entity
@Table(name = "ABB_LOGIN")
public class AbbLogin implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    private Long maxuserid;
    private String defsite;
    private String loginid;
    private String personid;
    private String displayname;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMaxuserid() {
        return maxuserid;
    }

    public void setMaxuserid(Long maxuserid) {
        this.maxuserid = maxuserid;
    }

    public String getDefsite() {
        return defsite;
    }

    public void setDefsite(String defsite) {
        this.defsite = defsite;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
}