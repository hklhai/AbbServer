package com.hxqh.abb.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the UDTOOLAPPLY database table.
 */
@Entity
@Table(name = "UDTOOLAPPLY")
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

    private Timestamp applydate;

    private String applynum;

    private String reason;

    private String siteid;

    private String status;

    private Timestamp statusdate;

    private Integer hasld;

    private String changeby;

    private Timestamp changedate;

    private Timestamp createddate;

    private String orgid;

    private String createdby;

    private Long rowstamp;

    private Integer isperson;

    public UdtoolApply() {

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

    public Timestamp getApplydate() {
        return applydate;
    }

    public void setApplydate(Timestamp applydate) {
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

    public Timestamp getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(Timestamp statusdate) {
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

    public Timestamp getChangedate() {
        return changedate;
    }

    public void setChangedate(Timestamp changedate) {
        this.changedate = changedate;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
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
