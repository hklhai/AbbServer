package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by fuyg on 2017-11-23.
 */
@Entity
public class SafecheckDto {
    @Id
    private Long udsafecheckid;
    private String scnum;
    private String pronum;
    private Long linenum;
    private String projectmanagername;
    private String createdby;
    private Date createddate;

    public SafecheckDto() {
    }

    public Long getUdsafecheckid() {

        return udsafecheckid;
    }

    public void setUdsafecheckid(Long udsafecheckid) {
        this.udsafecheckid = udsafecheckid;
    }

    public String getScnum() {
        return scnum;
    }

    public void setScnum(String scnum) {
        this.scnum = scnum;
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
