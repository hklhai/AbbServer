package com.hxqh.abb.model.version2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the WPLABOR database table.
 */
@Entity
@Table(name = "Wplabor")
public class Wplabor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "WPLABOR_WPLABORUID_GENERATOR", allocationSize = 1, sequenceName = "WPLABORSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WPLABOR_WPLABORUID_GENERATOR")
    private Long wplaboruid;

    private String amcrew;

    private String amcrewtype;

    private int apptrequired;

    private String contractnum;

    private int copytaskid;

    private String craft;

    private String crewworkgroup;

    private String laborcode;

    private double laborhrs;

    private String orgid;

    private int quantity;

    @Column(name = "\"RATE\"")
    private Double rate;

    private int ratehaschanged;

    private long rowstamp;

    private String siteid;

    private String skilllevel;

    private String vendor;

    private String wonum;

    private String wpl1;

    private Date wpl2;

    private String wpl3;

    private String wpl4;

    private String wpl5;

    private BigDecimal wpl6;

    private String wpl7;

    private String wpl8;

    private String wpl9;

    private String wplaborid;

    @Transient
    private Long frontedid;

    public Wplabor() {
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public Long getWplaboruid() {
        return this.wplaboruid;
    }

    public void setWplaboruid(Long wplaboruid) {
        this.wplaboruid = wplaboruid;
    }

    public String getAmcrew() {
        return this.amcrew;
    }

    public void setAmcrew(String amcrew) {
        this.amcrew = amcrew;
    }

    public String getAmcrewtype() {
        return this.amcrewtype;
    }

    public void setAmcrewtype(String amcrewtype) {
        this.amcrewtype = amcrewtype;
    }

    public int getApptrequired() {
        return this.apptrequired;
    }

    public void setApptrequired(int apptrequired) {
        this.apptrequired = apptrequired;
    }

    public String getContractnum() {
        return this.contractnum;
    }

    public void setContractnum(String contractnum) {
        this.contractnum = contractnum;
    }

    public int getCopytaskid() {
        return this.copytaskid;
    }

    public void setCopytaskid(int copytaskid) {
        this.copytaskid = copytaskid;
    }

    public String getCraft() {
        return this.craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getCrewworkgroup() {
        return this.crewworkgroup;
    }

    public void setCrewworkgroup(String crewworkgroup) {
        this.crewworkgroup = crewworkgroup;
    }

    public String getLaborcode() {
        return this.laborcode;
    }

    public void setLaborcode(String laborcode) {
        this.laborcode = laborcode;
    }

    public double getLaborhrs() {
        return this.laborhrs;
    }

    public void setLaborhrs(double laborhrs) {
        this.laborhrs = laborhrs;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getRatehaschanged() {
        return this.ratehaschanged;
    }

    public void setRatehaschanged(int ratehaschanged) {
        this.ratehaschanged = ratehaschanged;
    }

    public long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSkilllevel() {
        return this.skilllevel;
    }

    public void setSkilllevel(String skilllevel) {
        this.skilllevel = skilllevel;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getWonum() {
        return this.wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public String getWpl1() {
        return this.wpl1;
    }

    public void setWpl1(String wpl1) {
        this.wpl1 = wpl1;
    }

    public Date getWpl2() {
        return this.wpl2;
    }

    public void setWpl2(Date wpl2) {
        this.wpl2 = wpl2;
    }

    public String getWpl3() {
        return this.wpl3;
    }

    public void setWpl3(String wpl3) {
        this.wpl3 = wpl3;
    }

    public String getWpl4() {
        return this.wpl4;
    }

    public void setWpl4(String wpl4) {
        this.wpl4 = wpl4;
    }

    public String getWpl5() {
        return this.wpl5;
    }

    public void setWpl5(String wpl5) {
        this.wpl5 = wpl5;
    }

    public BigDecimal getWpl6() {
        return this.wpl6;
    }

    public void setWpl6(BigDecimal wpl6) {
        this.wpl6 = wpl6;
    }

    public String getWpl7() {
        return this.wpl7;
    }

    public void setWpl7(String wpl7) {
        this.wpl7 = wpl7;
    }

    public String getWpl8() {
        return this.wpl8;
    }

    public void setWpl8(String wpl8) {
        this.wpl8 = wpl8;
    }

    public String getWpl9() {
        return this.wpl9;
    }

    public void setWpl9(String wpl9) {
        this.wpl9 = wpl9;
    }

    public String getWplaborid() {
        return this.wplaborid;
    }

    public void setWplaborid(String wplaborid) {
        this.wplaborid = wplaborid;
    }

}