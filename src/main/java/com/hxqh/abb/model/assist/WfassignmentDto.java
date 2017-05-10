package com.hxqh.abb.model.assist;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;


public class WfassignmentDto {

    private String description;//	DESCRIPTION		描述
    private Date startdate;//	STARTDATE	开始日
    @Column(name = "\"PRIORITY\"")
    private Integer priority;//	PRIORITY	优先级
    private Date duedate;//DUEDATE 到期日

    public WfassignmentDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WfassignmentDto{");
        sb.append("description='").append(description).append('\'');
        sb.append(", startdate=").append(startdate);
        sb.append(", priority=").append(priority);
        sb.append(", duedate=").append(duedate);
        sb.append('}');
        return sb.toString();
    }
}