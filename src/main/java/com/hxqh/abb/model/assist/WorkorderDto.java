package com.hxqh.abb.model.assist;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;


public class WorkorderDto  {

    private Date targstartdate;//计划开始时间
    private String reportedby;//工作负责人
    private String wonum;//工单流水号
    private String description;//工单描述
    @Column(name = "\"STATUS\"")
    private String status;//状态
    private String siteid;// 所属服务站

//    LOCATIONS.DESCRIPTION	位置描述
//    REPORTEDBY.DESCRIPTION	工作负责人


    public Date getTargstartdate() {
        return targstartdate;
    }

    public void setTargstartdate(Date targstartdate) {
        this.targstartdate = targstartdate;
    }

    public String getReportedby() {
        return reportedby;
    }

    public void setReportedby(String reportedby) {
        this.reportedby = reportedby;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkorderDto{");
        sb.append("targstartdate=").append(targstartdate);
        sb.append(", reportedby='").append(reportedby).append('\'');
        sb.append(", wonum='").append(wonum).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", siteid='").append(siteid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}