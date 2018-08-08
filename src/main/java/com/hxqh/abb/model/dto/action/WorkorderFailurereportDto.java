package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Ocean lin on 2017/9/11.
 */
@Entity
public class WorkorderFailurereportDto {


    private String wonum;
    private String description;
    private String siteid;
    private String status;
    private String failurecode;
    private String failurecodedescription;
    private Date faildate;
    @Id
    private Long workorderid;

    public WorkorderFailurereportDto() {
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

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailurecode() {
        return failurecode;
    }

    public void setFailurecode(String failurecode) {
        this.failurecode = failurecode;
    }

    public String getFailurecodedescription() {
        return failurecodedescription;
    }

    public void setFailurecodedescription(String failurecodedescription) {
        this.failurecodedescription = failurecodedescription;
    }

    public Date getFaildate() {
        return faildate;
    }

    public void setFaildate(Date faildate) {
        this.faildate = faildate;
    }

    public Long getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(Long workorderid) {
        this.workorderid = workorderid;
    }
}
