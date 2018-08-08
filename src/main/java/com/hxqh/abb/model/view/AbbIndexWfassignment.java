package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the ABB_INDEX_WFASSIGNMENT database table.
 */
@Entity
@Table(name = "ABB_INDEX_WFASSIGNMENT")
public class AbbIndexWfassignment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long wfassignmentid;

    private String description;

    private Date duedate;

    @Column(name = "\"PRIORITY\"")
    private Integer priority;

    private Date startdate;

    private String assigncode;

    private String processname;

    private Long ownerid;


    public AbbIndexWfassignment() {
    }

    public String getProcessname() {
        return processname;
    }

    public void setProcessname(String processname) {
        this.processname = processname;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public String getAssigncode() {
        return assigncode;
    }

    public void setAssigncode(String assigncode) {
        this.assigncode = assigncode;
    }

    public long getWfassignmentid() {
        return wfassignmentid;
    }

    public void setWfassignmentid(long wfassignmentid) {
        this.wfassignmentid = wfassignmentid;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDuedate() {
        return this.duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

}