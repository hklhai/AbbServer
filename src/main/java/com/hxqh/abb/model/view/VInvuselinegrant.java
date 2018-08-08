package com.hxqh.abb.model.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_INVUSELINE database table.
 */
@Entity
@Table(name = "V_INVUSELINEGRANT")
public class VInvuselinegrant implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double curbal;

    private String description;

    private String fromstoreloc;


    @Id
    private Long invuselineid;

    private Integer invuselinenum;

    private String invusenum;

    private String issueto;

    private String itemnum;

    private String linenum;

    @Column(name = "\"LOCATION\"")
    private String location;

    private String locationsdescription;

    private BigDecimal quantity;

    private String remark;

    private String siteid;

    private String udcontact;

    private String udmodel;

    private String udprojectnum;

    private String udreceipt;


    public VInvuselinegrant() {
    }

    public Double getCurbal() {
        return curbal;
    }

    public void setCurbal(Double curbal) {
        this.curbal = curbal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromstoreloc() {
        return fromstoreloc;
    }

    public void setFromstoreloc(String fromstoreloc) {
        this.fromstoreloc = fromstoreloc;
    }

    public Long getInvuselineid() {
        return invuselineid;
    }

    public void setInvuselineid(Long invuselineid) {
        this.invuselineid = invuselineid;
    }

    public Integer getInvuselinenum() {
        return invuselinenum;
    }

    public void setInvuselinenum(Integer invuselinenum) {
        this.invuselinenum = invuselinenum;
    }

    public String getInvusenum() {
        return invusenum;
    }

    public void setInvusenum(String invusenum) {
        this.invusenum = invusenum;
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getLinenum() {
        return linenum;
    }

    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationsdescription() {
        return locationsdescription;
    }

    public void setLocationsdescription(String locationsdescription) {
        this.locationsdescription = locationsdescription;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getUdcontact() {
        return udcontact;
    }

    public void setUdcontact(String udcontact) {
        this.udcontact = udcontact;
    }

    public String getUdmodel() {
        return udmodel;
    }

    public void setUdmodel(String udmodel) {
        this.udmodel = udmodel;
    }

    public String getUdprojectnum() {
        return udprojectnum;
    }

    public void setUdprojectnum(String udprojectnum) {
        this.udprojectnum = udprojectnum;
    }

    public String getUdreceipt() {
        return udreceipt;
    }

    public void setUdreceipt(String udreceipt) {
        this.udreceipt = udreceipt;
    }
}