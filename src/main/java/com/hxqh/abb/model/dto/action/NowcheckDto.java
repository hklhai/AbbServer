package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by fuyg on 2017-11-23.
 */
@Entity
public class NowcheckDto {

    @Id
    private Long udnowcheckid;
    private String number;
    private String pronum;
    private Long linenum;
    private String projectmanagername;
    private String creator;
    private Date createdate;
    private String engineer;
    private Date checkdate;

    public NowcheckDto() {
    }

    public Long getUdnowcheckid() {

        return udnowcheckid;
    }

    public void setUdnowcheckid(Long udnowcheckid) {
        this.udnowcheckid = udnowcheckid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }
}
