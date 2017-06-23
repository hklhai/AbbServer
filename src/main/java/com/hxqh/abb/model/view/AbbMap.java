package com.hxqh.abb.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the ABB_MAP database table.
 */
@Entity
@Table(name = "ABB_MAP")
public class AbbMap implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer alertcount;

    private String description;

    private String dimension;

    @Column(name = "\"LOCATION\"")
    private String location;

    @Id
    private long locationsid;

    private Integer loccount;

    private String longitude;

    private String orgid;

    private String saddresscode;

    @Column(name = "\"STATUS\"")
    private String status;

    private String parent;

    private String parentdesc;

    private String voltage;

    private String avgasset;

    public AbbMap() {
    }

    public String getAvgasset() {
        return avgasset;
    }

    public void setAvgasset(String avgasset) {
        this.avgasset = avgasset;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParentdesc() {
        return parentdesc;
    }

    public void setParentdesc(String parentdesc) {
        this.parentdesc = parentdesc;
    }

    public Integer getAlertcount() {
        return this.alertcount;
    }

    public void setAlertcount(Integer alertcount) {
        this.alertcount = alertcount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return this.dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getLocationsid() {
        return this.locationsid;
    }

    public void setLocationsid(long locationsid) {
        this.locationsid = locationsid;
    }

    public Integer getLoccount() {
        return this.loccount;
    }

    public void setLoccount(Integer loccount) {
        this.loccount = loccount;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getSaddresscode() {
        return this.saddresscode;
    }

    public void setSaddresscode(String saddresscode) {
        this.saddresscode = saddresscode;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}