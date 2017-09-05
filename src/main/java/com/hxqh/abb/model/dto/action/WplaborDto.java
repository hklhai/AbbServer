package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/9/5.
 */
@Entity
public class WplaborDto {

    @Id
    private Long wplaboruid;
    private String laborcode;
    private Double laborhrs;
    private String wonum;
    private String siteid;

    public WplaborDto() {
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Long getWplaboruid() {
        return wplaboruid;
    }

    public void setWplaboruid(Long wplaboruid) {
        this.wplaboruid = wplaboruid;
    }

    public String getLaborcode() {
        return laborcode;
    }

    public void setLaborcode(String laborcode) {
        this.laborcode = laborcode;
    }

    public Double getLaborhrs() {
        return laborhrs;
    }

    public void setLaborhrs(Double laborhrs) {
        this.laborhrs = laborhrs;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }
}
