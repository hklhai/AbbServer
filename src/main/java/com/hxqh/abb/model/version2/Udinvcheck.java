package com.hxqh.abb.model.version2;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the UDINVCHECK database table.
 */
@Entity
@Table(name = "Udinvcheck")
@DynamicUpdate
public class Udinvcheck implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDINVCHECK_UDINVCHECKID_GENERATOR", allocationSize = 1, sequenceName = "UDINVCHECKIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDINVCHECK_UDINVCHECKID_GENERATOR")
    private Long udinvcheckid;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date chkdate;

    private String description;

    private String enterby;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date enterdate;

    private Integer hasld;

    private String invchecknum;

    private String orgid;

    private String remark;

    private Long rowstamp;

    private String siteid;

    @Column(name = "\"STATUS\"")
    private String status;

    private Date statusdate;

    private String storeloc;

    @Transient
    private String maintab;

    @Transient
    private List<Udinvcheckline> udinvchecklineList;

    @Transient
    private String apptname;

    @Transient
    private String persondisplayname;

    @Transient
    private String deletes;


    public Udinvcheck() {
    }

    public String getApptname() {
        return apptname;
    }

    public void setApptname(String apptname) {
        this.apptname = apptname;
    }

    public String getPersondisplayname() {
        return persondisplayname;
    }

    public void setPersondisplayname(String persondisplayname) {
        this.persondisplayname = persondisplayname;
    }

    public String getMaintab() {
        return maintab;
    }

    public void setMaintab(String maintab) {
        this.maintab = maintab;
    }

    public List<Udinvcheckline> getUdinvchecklineList() {
        return udinvchecklineList;
    }

    public void setUdinvchecklineList(List<Udinvcheckline> udinvchecklineList) {
        this.udinvchecklineList = udinvchecklineList;
    }

    public String getDeletes() {
        return deletes;
    }

    public void setDeletes(String deletes) {
        this.deletes = deletes;
    }

    public Long getUdinvcheckid() {
        return this.udinvcheckid;
    }

    public void setUdinvcheckid(Long udinvcheckid) {
        this.udinvcheckid = udinvcheckid;
    }

    @JsonFormat(pattern = "YYYY-MM-DD HH:MM:SS", timezone = "GMT+8")
    public Date getChkdate() {
        return this.chkdate;
    }

    public void setChkdate(Date chkdate) {
        this.chkdate = chkdate;
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

    public Date getEnterdate() {
        return this.enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
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

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public String getStoreloc() {
        return this.storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

}