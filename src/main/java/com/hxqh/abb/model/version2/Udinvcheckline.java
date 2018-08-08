package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the UDINVCHECKLINE database table.
 */
@Entity
@Table(name = "Udinvcheckline")
@DynamicUpdate
public class Udinvcheckline implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDINVCHECKLINE_UDINVCHECKLINEID_GENERATOR", allocationSize = 1, sequenceName = "UDINVCHECKLINEIDSEQ")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "UDINVCHECKLINE_UDINVCHECKLINEID_GENERATOR")
    private Long udinvchecklineid;

    private String binnum;

    private BigDecimal checkqty;

    private BigDecimal curbal;

    private String description;

    private BigDecimal diffqty;

    private Integer hasld;

    private String invchecknum;

    private String itemnum;

    private String orgid;

    private String reason;

    private String remark;

    private Long rowstamp;

    private String siteid;

    private String storeloc;

    @Transient
    private Long frontedid;
    @Transient
    private String itemdescription;
    @Transient
    private String itemudmodel;

    public Udinvcheckline() {
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getItemudmodel() {
        return itemudmodel;
    }

    public void setItemudmodel(String itemudmodel) {
        this.itemudmodel = itemudmodel;
    }

    public Long getUdinvchecklineid() {
        return this.udinvchecklineid;
    }

    public void setUdinvchecklineid(Long udinvchecklineid) {
        this.udinvchecklineid = udinvchecklineid;
    }

    public String getBinnum() {
        return this.binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
    }

    public BigDecimal getCheckqty() {
        return this.checkqty;
    }

    public void setCheckqty(BigDecimal checkqty) {
        this.checkqty = checkqty;
    }

    public BigDecimal getCurbal() {
        return this.curbal;
    }

    public void setCurbal(BigDecimal curbal) {
        this.curbal = curbal;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiffqty() {
        return this.diffqty;
    }

    public void setDiffqty(BigDecimal diffqty) {
        this.diffqty = diffqty;
    }

    public Integer getHasld() {
        return this.hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public String getInvchecknum() {
        return this.invchecknum;
    }

    public void setInvchecknum(String invchecknum) {
        this.invchecknum = invchecknum;
    }

    public String getItemnum() {
        return this.itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getStoreloc() {
        return this.storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

}