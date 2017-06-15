package com.hxqh.abb.model.base;

/**
 * Created by dell on 2017-05-24.
 */
public class SessionInfo {

    private String loginId;

    private String siteid;

    private String orgid;

    private String displayname;

    private String longitude;

    private String dimension;

    private String location;


    public SessionInfo() {
    }

    public SessionInfo(String loginId, String siteid, String orgid, String displayname) {
        this.loginId = loginId;
        this.siteid = siteid;
        this.orgid = orgid;
        this.displayname = displayname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }
}
