package com.hxqh.abb.model.assist;

import java.util.Date;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class UserInfoAdd {

    private String siteid;

    private String orgid;

    private String createby;

    private String changeby;

    private Date createdate;

    private Date changedate;

    private String status;

    private Date statusdate;

    private Integer hasld;

    private Long rowstamp;

    // 增加字段 呵呵 挖坑快乐填坑苦！  2017-10-18 14:18:13
    private String createdby;

    private Date createddate;

    // 增加字段 无语的拼写！！！
    private Date chengdate;


    public UserInfoAdd() {
    }

    public Date getChengdate() {
        return chengdate;
    }

    public void setChengdate(Date chengdate) {
        this.chengdate = chengdate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
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

    public String getChangeby() {
        return changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public Integer getHasld() {
        return hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
