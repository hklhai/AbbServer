package com.hxqh.abb.model;


import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the UDTOOLAPPLY database table.
 */
@Entity
@Table(name = "UDTOOLAPPLY")
@DynamicUpdate
public class UdtoolApply implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDTOOLAPPLY_UDTOOLAPPLYID_GENERATOR", sequenceName = "UDTOOLAPPLYIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDTOOLAPPLY_UDTOOLAPPLYID_GENERATOR")
    private Long udtoolapplyid;

    private String description;

    private String toolnum;

    private String applytype;

    private String applicant;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applydate;

    private String applynum;

    private String reason;

    private String siteid;

    private String status;

    private Date statusdate;

    private Integer hasld;

    private String changeby;

    private Date changedate;

    private Date createddate;

    private String orgid;

    private String createdby;

    private Long rowstamp;

    private Integer isperson;
    @Transient
    private String persondisplayname;
    @Transient
    private String udtooldescription;
    @Transient
    private String inputpersondisplayname;


    public UdtoolApply() {

    }

    public String getPersondisplayname() {
        return persondisplayname;
    }

    public void setPersondisplayname(String persondisplayname) {
        this.persondisplayname = persondisplayname;
    }

    public String getUdtooldescription() {
        return udtooldescription;
    }

    public void setUdtooldescription(String udtooldescription) {
        this.udtooldescription = udtooldescription;
    }

    public String getInputpersondisplayname() {
        return inputpersondisplayname;
    }

    public void setInputpersondisplayname(String inputpersondisplayname) {
        this.inputpersondisplayname = inputpersondisplayname;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Long getUdtoolapplyid() {
        return udtoolapplyid;
    }

    public void setUdtoolapplyid(Long udtoolapplyid) {
        this.udtoolapplyid = udtoolapplyid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToolnum() {
        return toolnum;
    }

    public void setToolnum(String toolnum) {
        this.toolnum = toolnum;
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getApplynum() {
        return applynum;
    }

    public void setApplynum(String applynum) {
        this.applynum = applynum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public Integer getHasld() {
        return hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public String getChangeby() {
        return changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public Integer getIsperson() {
        return isperson;
    }

    public void setIsperson(Integer isperson) {
        this.isperson = isperson;
    }

    @Override
    public String toString() {
        return "UdtoolApply{" +
                "udtoolapplyid=" + udtoolapplyid +
                ", description='" + description + '\'' +
                ", toolnum='" + toolnum + '\'' +
                ", applytype='" + applytype + '\'' +
                ", applicant='" + applicant + '\'' +
                ", applydate=" + applydate +
                ", applynum='" + applynum + '\'' +
                ", reason='" + reason + '\'' +
                ", siteid='" + siteid + '\'' +
                ", status='" + status + '\'' +
                ", statusdate=" + statusdate +
                ", hasld=" + hasld +
                ", changeby='" + changeby + '\'' +
                ", changeddate=" + changedate +
                ", createdate=" + createddate +
                ", orgid='" + orgid + '\'' +
                ", createdby='" + createdby + '\'' +
                ", rowstamp=" + rowstamp +
                ", isperson=" + isperson +
                '}';
    }


}
