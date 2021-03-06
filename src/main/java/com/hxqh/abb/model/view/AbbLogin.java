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
    private String siteid;
    private String longitude;
    private String dimension;
    private String location;
    private String orgid;
    private String locationsite;
    private String title;
    private String country;

    public AbbLogin() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationsite() {
        return locationsite;
    }

    public void setLocationsite(String locationsite) {
        this.locationsite = locationsite;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

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

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }
}