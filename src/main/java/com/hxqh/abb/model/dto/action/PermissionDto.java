package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by fuyg on 2017-11-23.
 */
@Entity
public class PermissionDto {

    @Id
    private Long udpermissionid;
    private String coding;
    private String pronum;
    private Long linenum;
    private String sctnumber;
    private String status;
    private String projectmanagername;
    private String createdby;
    private Date createddate;

    public PermissionDto() {
    }

    public Long getUdpermissionid() {

        return udpermissionid;
    }

    public void setUdpermissionid(Long udpermissionid) {
        this.udpermissionid = udpermissionid;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getPronum() {
        return pronum;
    }

    public void setPronum(String pronum) {
        this.pronum = pronum;
    }

    public Long getLinenum() {
        return linenum;
    }

    public void setLinenum(Long linenum) {
        this.linenum = linenum;
    }

    public String getSctnumber() {
        return sctnumber;
    }

    public void setSctnumber(String sctnumber) {
        this.sctnumber = sctnumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectmanagername() {
        return projectmanagername;
    }

    public void setProjectmanagername(String projectmanagername) {
        this.projectmanagername = projectmanagername;
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
}
