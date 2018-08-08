package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UDWOLINE database table.
 */
@Entity
@Table(name = "Udwoline")
@DynamicUpdate
public class Udwoline implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDWOLINE_UDWOLINEID_GENERATOR", allocationSize = 1, sequenceName = "UDWOLINEIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDWOLINE_UDWOLINEID_GENERATOR")
    private Long udwolineid;

    private String assetnum;

    private String description;

    private Integer hasld;

    @Column(name = "\"LOCATION\"")
    private String location;

    private String orgid;

    private Long rowstamp;

    private String siteid;

    private String wonum;

    @Transient
    private String assetdescription;

    @Transient
    private String locationsdescription;

    @Transient
    private Long frontedid;

    @Transient
    private String assetudmodel;

    public Udwoline() {
    }

    public String getAssetudmodel() {
        return assetudmodel;
    }

    public void setAssetudmodel(String assetudmodel) {
        this.assetudmodel = assetudmodel;
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public String getAssetdescription() {
        return assetdescription;
    }

    public void setAssetdescription(String assetdescription) {
        this.assetdescription = assetdescription;
    }

    public String getLocationsdescription() {
        return locationsdescription;
    }

    public void setLocationsdescription(String locationsdescription) {
        this.locationsdescription = locationsdescription;
    }

    public Long getUdwolineid() {
        return this.udwolineid;
    }

    public void setUdwolineid(Long udwolineid) {
        this.udwolineid = udwolineid;
    }

    public String getAssetnum() {
        return this.assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
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

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
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