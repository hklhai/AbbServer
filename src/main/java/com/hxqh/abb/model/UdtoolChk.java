package com.hxqh.abb.model;

import com.hxqh.abb.model.version2.Udtoolchkline;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "UDTOOLCHK")
@DynamicUpdate
public class UdtoolChk implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDTOOLCHK_UDTOOLCHKID_GENERATOR", sequenceName = "UDTOOLCHKIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDTOOLCHK_UDTOOLCHKID_GENERATOR")
    private Long udtoolchkid;

    private String description;

    private String orgid;

    private String siteid;

    private Integer hasld;

    private String status;

    private String createby;

    private Date createdate;

    private String changeby;

    private Date changedate;

    private String tcnum;

    private String keeper;

    private String tooltype;

    private Long rowstamp;

    private String sendcompany;

    private Date statusdate;

    private String sendnum;

    @Transient
    private String persondisplayname;

    @Transient
    private String createdisplayname;

    @Transient
    private List<Udtoolchkline> udtoolchklineList;

    @Transient
    private String deletes;

    @Transient
    private String maintab;

    public List<Udtoolchkline> getUdtoolchklineList() {
        return udtoolchklineList;
    }

    public void setUdtoolchklineList(List<Udtoolchkline> udtoolchklineList) {
        this.udtoolchklineList = udtoolchklineList;
    }

    public String getMaintab() {
        return maintab;
    }

    public void setMaintab(String maintab) {
        this.maintab = maintab;
    }

    public String getPersondisplayname() {
        return persondisplayname;
    }

    public void setPersondisplayname(String persondisplayname) {
        this.persondisplayname = persondisplayname;
    }

    public String getCreatedisplayname() {
        return createdisplayname;
    }

    public void setCreatedisplayname(String createdisplayname) {
        this.createdisplayname = createdisplayname;
    }

    public String getDeletes() {
        return deletes;
    }

    public void setDeletes(String deletes) {
        this.deletes = deletes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUdtoolchkid() {
        return udtoolchkid;
    }

    public void setUdtoolchkid(Long udtoolchkid) {
        this.udtoolchkid = udtoolchkid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Integer getHasld() {
        return hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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

    public String getTcnum() {
        return tcnum;
    }

    public void setTcnum(String tcnum) {
        this.tcnum = tcnum;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public String getTooltype() {
        return tooltype;
    }

    public void setTooltype(String tooltype) {
        this.tooltype = tooltype;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSendcompany() {
        return sendcompany;
    }

    public void setSendcompany(String sendcompany) {
        this.sendcompany = sendcompany;
    }

    public Date getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public String getSendnum() {
        return sendnum;
    }

    public void setSendnum(String sendnum) {
        this.sendnum = sendnum;
    }

    public UdtoolChk() {

    }

    @Override
    public String toString() {
        return "UdtoolChk{" +
                "udtoolchkid=" + udtoolchkid +
                ", description='" + description + '\'' +
                ", orgid='" + orgid + '\'' +
                ", siteid='" + siteid + '\'' +
                ", hasld=" + hasld +
                ", status='" + status + '\'' +
                ", createby='" + createby + '\'' +
                ", createdate=" + createdate +
                ", changeby='" + changeby + '\'' +
                ", changedate=" + changedate +
                ", tcnum='" + tcnum + '\'' +
                ", keeper='" + keeper + '\'' +
                ", tooltype='" + tooltype + '\'' +
                ", rowstamp=" + rowstamp +
                ", sendcompany='" + sendcompany + '\'' +
                ", statusdate=" + statusdate +
                ", sendnum='" + sendnum + '\'' +
                '}';
    }
}
