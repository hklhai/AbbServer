package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/9/8.
 */
@Entity
public class LabtransDto {

    private String laborcode;
    private String displayname;
    private String regularhrs;
    @Id
    private Long labtransid;

    private String copytaskid;

    public LabtransDto() {
    }

    public String getLaborcode() {
        return laborcode;
    }

    public void setLaborcode(String laborcode) {
        this.laborcode = laborcode;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getRegularhrs() {
        return regularhrs;
    }

    public void setRegularhrs(String regularhrs) {
        this.regularhrs = regularhrs;
    }

    public Long getLabtransid() {
        return labtransid;
    }

    public void setLabtransid(Long labtransid) {
        this.labtransid = labtransid;
    }

    public String getCopytaskid() {
        return copytaskid;
    }

    public void setCopytaskid(String copytaskid) {
        this.copytaskid = copytaskid;
    }
}
