package com.hxqh.abb.model.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the V_UDTOOLCHKLINE database table.
 */
@Entity
@Table(name = "V_UDTOOLCHKLINE")
public class VUdtoolchkline implements Serializable {
    private static final long serialVersionUID = 1L;

    private String chkby;

    private Date chkdate;

    private String chkstatus;

    private String remark;

    private String tcnum;

    private String toolnum;

    @Id
    private Long udtoolchklineid;

    private String udtooldescription;

    private String personid;

    public VUdtoolchkline() {
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getChkby() {
        return this.chkby;
    }

    public void setChkby(String chkby) {
        this.chkby = chkby;
    }


    public Date getChkdate() {
        return chkdate;
    }

    public void setChkdate(Date chkdate) {
        this.chkdate = chkdate;
    }

    public String getChkstatus() {
        return this.chkstatus;
    }

    public void setChkstatus(String chkstatus) {
        this.chkstatus = chkstatus;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTcnum() {
        return this.tcnum;
    }

    public void setTcnum(String tcnum) {
        this.tcnum = tcnum;
    }

    public String getToolnum() {
        return this.toolnum;
    }

    public void setToolnum(String toolnum) {
        this.toolnum = toolnum;
    }

    public Long getUdtoolchklineid() {
        return udtoolchklineid;
    }

    public void setUdtoolchklineid(Long udtoolchklineid) {
        this.udtoolchklineid = udtoolchklineid;
    }

    public String getUdtooldescription() {
        return this.udtooldescription;
    }

    public void setUdtooldescription(String udtooldescription) {
        this.udtooldescription = udtooldescription;
    }

}