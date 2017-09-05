package com.hxqh.abb.model.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the V_UDINVCHECKLINE database table.
 */
@Entity
@Table(name = "V_UDINVCHECKLINE")
public class VUdinvcheckline implements Serializable {
    private static final long serialVersionUID = 1L;

    private String binnum;

    private Double checkqty;

    private Double curbal;

    private Double diffqty;

    private String invchecknum;

    private String itemdescription;

    private String itemnum;

    private String itemudmodel;

    private String reason;

    private String siteid;

    private String storeloc;

    @Id
    private Long udinvchecklineid;

    public VUdinvcheckline() {
    }

    public String getBinnum() {
        return this.binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
    }

    public Double getCheckqty() {
        return this.checkqty;
    }

    public void setCheckqty(Double checkqty) {
        this.checkqty = checkqty;
    }

    public Double getCurbal() {
        return this.curbal;
    }

    public void setCurbal(Double curbal) {
        this.curbal = curbal;
    }

    public Double getDiffqty() {
        return this.diffqty;
    }

    public void setDiffqty(Double diffqty) {
        this.diffqty = diffqty;
    }

    public String getInvchecknum() {
        return this.invchecknum;
    }

    public void setInvchecknum(String invchecknum) {
        this.invchecknum = invchecknum;
    }

    public String getItemdescription() {
        return this.itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getItemnum() {
        return this.itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getItemudmodel() {
        return this.itemudmodel;
    }

    public void setItemudmodel(String itemudmodel) {
        this.itemudmodel = itemudmodel;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getStoreloc() {
        return this.storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public Long getUdinvchecklineid() {
        return this.udinvchecklineid;
    }

    public void setUdinvchecklineid(Long udinvchecklineid) {
        this.udinvchecklineid = udinvchecklineid;
    }

}