package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/9/11.
 */
@Entity
public class FailurereportDto {

    @Id
    private Long failurereportid;
    private String type;
    private String failurecodedescription;
    private String failurecode;
    private String orgid;

    public FailurereportDto() {
    }

    public Long getFailurereportid() {
        return failurereportid;
    }

    public void setFailurereportid(Long failurereportid) {
        this.failurereportid = failurereportid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFailurecodedescription() {
        return failurecodedescription;
    }

    public void setFailurecodedescription(String failurecodedescription) {
        this.failurecodedescription = failurecodedescription;
    }

    public String getFailurecode() {
        return failurecode;
    }

    public void setFailurecode(String failurecode) {
        this.failurecode = failurecode;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }
}
