package com.hxqh.abb.model;

import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "UDTOOLLEND")
public class UdtoolLend implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDTOOLLEND_UDTOOLLENDID_GENERATOR", sequenceName = "UDTOOLLENDIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDTOOLLEND_UDTOOLLENDID_GENERATOR")
    private Long udtoollendid;

    private String description;

    private String siteid;

    private String status;

    private Timestamp statusdate;

    private Integer hasld;

    private String assetnum;

    private String enterby;

    private String lendby;

    private Timestamp enterdate;

    private Timestamp lenddate;

    private String lendnum;

    private String lendtype;

    private String remark;

    private String toolnum;

    private Long rowstamp;

    private Integer issiteout;

    private Integer isarea;

    private String udhandovwe;

    public UdtoolLend(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Timestamp getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Timestamp enterdate) {
        this.enterdate = enterdate;
    }

    public Timestamp getLenddate() {
        return lenddate;
    }

    public void setLenddate(Timestamp lenddate) {
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

    @Override
    public String toString() {
        return "UdtoolLend{" +
                "udtoollendid=" + udtoollendid +
                ", description='" + description + '\'' +
                ", siteid='" + siteid + '\'' +
                ", status='" + status + '\'' +
                ", statusdate=" + statusdate +
                ", hasld=" + hasld +
                ", assetnum='" + assetnum + '\'' +
                ", enterby='" + enterby + '\'' +
                ", lendby='" + lendby + '\'' +
                ", enterdate=" + enterdate +
                ", lenddate=" + lenddate +
                ", lendnum='" + lendnum + '\'' +
                ", lendtype='" + lendtype + '\'' +
                ", remark='" + remark + '\'' +
                ", toolnum='" + toolnum + '\'' +
                ", rowstamp=" + rowstamp +
                ", issiteout=" + issiteout +
                ", isarea=" + isarea +
                ", udhandovwe='" + udhandovwe + '\'' +
                '}';
    }

    public void setSessionInfo(SessionInfo sessionInfo) {
    }

    public void setTime(Time time) {
    }
}
