package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the V_INVUSELINEALLOCATE database table.
 */
@Entity
@Table(name = "V_INVUSELINEALLOCATE")
public class VInvuselineallocate implements Serializable {
    private static final long serialVersionUID = 1L;

    private Timestamp actualdate;

    private String description;

    private String enterby;

    private String frombin;

    private String issueto;

    private String itemnum;

    private BigDecimal quantity;

    private String remark;

    private String tobin;

    private String tositeid;

    private String tostoreloc;

    private String udmodel;

    @Id
    private Long invuselineid;


    public VInvuselineallocate() {
    }

    public Long getInvuselineid() {
        return invuselineid;
    }

    public void setInvuselineid(Long invuselineid) {
        this.invuselineid = invuselineid;
    }

    public Timestamp getActualdate() {
        return this.actualdate;
    }

    public void setActualdate(Timestamp actualdate) {
        this.actualdate = actualdate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnterby() {
        return this.enterby;
    }

    public void setEnterby(String enterby) {
        this.enterby = enterby;
    }

    public String getFrombin() {
        return this.frombin;
    }

    public void setFrombin(String frombin) {
        this.frombin = frombin;
    }

    public String getIssueto() {
        return this.issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getItemnum() {
        return this.itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTobin() {
        return this.tobin;
    }

    public void setTobin(String tobin) {
        this.tobin = tobin;
    }

    public String getTositeid() {
        return this.tositeid;
    }

    public void setTositeid(String tositeid) {
        this.tositeid = tositeid;
    }

    public String getTostoreloc() {
        return this.tostoreloc;
    }

    public void setTostoreloc(String tostoreloc) {
        this.tostoreloc = tostoreloc;
    }

    public String getUdmodel() {
        return this.udmodel;
    }

    public void setUdmodel(String udmodel) {
        this.udmodel = udmodel;
    }

}