package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * The persistent class for the UDWOQUALIFICATION database table.
 */
@Entity
@Table(name = "Udwoqualification")
@DynamicUpdate
public class Udwoqualification implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDWOQUALIFICATION_UDWOQUALIFICATIONID_GENERATOR", allocationSize = 1, sequenceName = "UDWOQUALIFICATIONIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDWOQUALIFICATION_UDWOQUALIFICATIONID_GENERATOR")
    private Long udwoqualificationid;

    private String createdby;

    private Date createddate;

    private String description;

    private Integer hasld;

    private String orgid;

    private String qualification;

    private Long rowstamp;

    private String siteid;

    private String wonum;

    @Transient
    private Long frontedid;
    @Transient
    private String udwqualification;
    @Transient
    private String udwoqualificationdescription;


    public Udwoqualification() {
    }

    public String getUdwoqualificationdescription() {
        return udwoqualificationdescription;
    }

    public void setUdwoqualificationdescription(String udwoqualificationdescription) {
        this.udwoqualificationdescription = udwoqualificationdescription;
    }

    public String getUdwqualification() {
        return udwqualification;
    }

    public void setUdwqualification(String udwqualification) {
        this.udwqualification = udwqualification;
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public Long getUdwoqualificationid() {
        return this.udwoqualificationid;
    }

    public void setUdwoqualificationid(Long udwoqualificationid) {
        this.udwoqualificationid = udwoqualificationid;
    }

    public String getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return this.createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHasld() {
        return this.hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getQualification() {
        return this.qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getWonum() {
        return this.wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

}