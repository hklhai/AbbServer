package com.hxqh.abb.model.base;

/**
 * Created by dell on 2017-05-24.
 */
public class SessionInfo {

    private String loginId;

    private String siteid;

    private String orgid;

    public SessionInfo() {
    }

    public SessionInfo(String loginId, String siteid, String orgid) {
        this.loginId = loginId;
        this.siteid = siteid;
        this.orgid = orgid;
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
