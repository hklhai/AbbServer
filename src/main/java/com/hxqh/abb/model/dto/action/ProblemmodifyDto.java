package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by fuyg on 2017-11-23.
 */
@Entity
public class ProblemmodifyDto {

    @Id
    private Long udproblemmodifyid;
    private String number;
    private String pronum;
    private Long linenum;
    private String projectmanagername;
    private String creator;
    private Date createdate;
    private String udpmlinedesc;
    private Date solutiondate;

    public ProblemmodifyDto() {
    }

    public Long getUdproblemmodifyid() {

        return udproblemmodifyid;
    }

    public void setUdproblemmodifyid(Long udproblemmodifyid) {
        this.udproblemmodifyid = udproblemmodifyid;
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

    public String getUdpmlinedesc() {
        return udpmlinedesc;
    }

    public void setUdpmlinedesc(String udpmlinedesc) {
        this.udpmlinedesc = udpmlinedesc;
    }

    public Date getSolutiondate() {
        return solutiondate;
    }

    public void setSolutiondate(Date solutiondate) {
        this.solutiondate = solutiondate;
    }
}
