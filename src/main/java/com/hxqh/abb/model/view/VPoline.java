package com.hxqh.abb.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the V_POLINE database table.
 */
@Entity
@Table(name = "V_POLINE")
public class VPoline implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date enterdate;

    private String itemdescription;

    private String itemnum;

    private String itemudmodel;

    private BigDecimal orderqty;

    private String persondisplayname;

    @Id
    private Long polineid;

    private Integer polinenum;

    private String requestedby;

    private String shipto;

    private String storeloc;

    private String tositeid;

    private String udresource;

    public VPoline() {
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getItemudmodel() {
        return itemudmodel;
    }

    public void setItemudmodel(String itemudmodel) {
        this.itemudmodel = itemudmodel;
    }

    public BigDecimal getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(BigDecimal orderqty) {
        this.orderqty = orderqty;
    }

    public String getPersondisplayname() {
        return persondisplayname;
    }

    public void setPersondisplayname(String persondisplayname) {
        this.persondisplayname = persondisplayname;
    }

    public Long getPolineid() {
        return polineid;
    }

    public void setPolineid(Long polineid) {
        this.polineid = polineid;
    }

    public Integer getPolinenum() {
        return polinenum;
    }

    public void setPolinenum(Integer polinenum) {
        this.polinenum = polinenum;
    }

    public String getRequestedby() {
        return requestedby;
    }

    public void setRequestedby(String requestedby) {
        this.requestedby = requestedby;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public String getStoreloc() {
        return storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public String getTositeid() {
        return tositeid;
    }

    public void setTositeid(String tositeid) {
        this.tositeid = tositeid;
    }

    public String getUdresource() {
        return udresource;
    }

    public void setUdresource(String udresource) {
        this.udresource = udresource;
    }
}