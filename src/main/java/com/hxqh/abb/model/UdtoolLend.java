package com.hxqh.abb.model;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UDTOOLLEND")
@DynamicUpdate
public class UdtoolLend implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDTOOLLEND_UDTOOLLENDID_GENERATOR", sequenceName = "UDTOOLLENDIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDTOOLLEND_UDTOOLLENDID_GENERATOR")
    private Long udtoollendid;

    private String description;

    private String siteid;

    private String status;

    private Date statusdate;

    private Integer hasld;

    private String assetnum;

    private String enterby;

    private String lendby;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enterdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lenddate;

    private String lendnum;

    private String lendtype;

    private String remark;

    private String toolnum;

    private Long rowstamp;

    private Integer issiteout;

    private Integer isarea;

    private String udhandovwe;

    @Transient
    private String persondisplayname;
    @Transient
    private String udtooldescription;
    @Transient
    private String inputpersondisplayname;

    @Transient
    private String orgid;

    public UdtoolLend() {

    }

    public String getInputpersondisplayname() {
        return inputpersondisplayname;
    }

    public void setInputpersondisplayname(String inputpersondisplayname) {
        this.inputpersondisplayname = inputpersondisplayname;
    }

    public String getUdtooldescription() {
        return udtooldescription;
    }

    public void setUdtooldescription(String udtooldescription) {
        this.udtooldescription = udtooldescription;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getPersondisplayname() {
        return persondisplayname;
    }

    public void setPersondisplayname(String persondisplayname) {
        this.persondisplayname = persondisplayname;
    }

    public Long getUdtoollendid() {
        return udtoollendid;
    }

    public void setUdtoollendid(Long udtoollendid) {
        this.udtoollendid = udtoollendid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getAssetnum() {
        return assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public String getEnterby() {
        return enterby;
    }

    public void setEnterby(String enterby) {
        this.enterby = enterby;
    }

    public String getLendby() {
        return lendby;
    }

    public void setLendby(String lendby) {
        this.lendby = lendby;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Date getLenddate() {
        return lenddate;
    }

    public void setLenddate(Date lenddate) {
        this.lenddate = lenddate;
    }

    public String getLendnum() {
        return lendnum;
    }

    public void setLendnum(String lendnum) {
        this.lendnum = lendnum;
    }

    public String getLendtype() {
        return lendtype;
    }

    public void setLendtype(String lendtype) {
        this.lendtype = lendtype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getToolnum() {
        return toolnum;
    }

    public void setToolnum(String toolnum) {
        this.toolnum = toolnum;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public Integer getIssiteout() {
        return issiteout;
    }

    public void setIssiteout(Integer issiteout) {
        this.issiteout = issiteout;
    }

    public Integer getIsarea() {
        return isarea;
    }

    public void setIsarea(Integer isarea) {
        this.isarea = isarea;
    }

    public String getUdhandovwe() {
        return udhandovwe;
    }

    public void setUdhandovwe(String udhandovwe) {
        this.udhandovwe = udhandovwe;
    }
}
