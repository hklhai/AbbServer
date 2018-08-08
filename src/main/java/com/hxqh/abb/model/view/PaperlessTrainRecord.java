package com.hxqh.abb.model.view;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PAPERLESS_UDTRAINRECORD")
public class PaperlessTrainRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  private String number;
  private String description;
  private String pronum;
  private String pronumdesc;
  private Long linenum;
  private String linenumdesc;
  private String projectmanager;
  private String projectmanagername;
  private String servicedep;
  private String creator;
  private Date createdate;
  private String changeby;
  private Date changedate;
  private String status;
  private Date statusdate;
  private String siteid;
  private String orgid;
  private String transfername;
  private String khcompany;
  private String khcontacts;
  private String khphone;
  private String model;
  private Double quantity;
  private Long pxnr01;
  private Long pxnr02;
  private Long pxnr03;
  private Long pxnr04;
  private Long pxnr05;
  private Long pxnr06;
  private String other;
  private String location;
  private String trainsuggestion;
  private Long wu;
  private Long wxjx;
  private Long yxcz;
  private String remark;
  private String teacher;
  private Date traindate;
  @Id
  private Long udtrainrecordid;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public String getPronumdesc() {
    return pronumdesc;
  }

  public void setPronumdesc(String pronumdesc) {
    this.pronumdesc = pronumdesc;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
  }

  public String getLinenumdesc() {
    return linenumdesc;
  }

  public void setLinenumdesc(String linenumdesc) {
    this.linenumdesc = linenumdesc;
  }

  public String getProjectmanager() {
    return projectmanager;
  }

  public void setProjectmanager(String projectmanager) {
    this.projectmanager = projectmanager;
  }

  public String getProjectmanagername() {
    return projectmanagername;
  }

  public void setProjectmanagername(String projectmanagername) {
    this.projectmanagername = projectmanagername;
  }

  public String getServicedep() {
    return servicedep;
  }

  public void setServicedep(String servicedep) {
    this.servicedep = servicedep;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  public Date getChangedate() {
    return changedate;
  }

  public void setChangedate(Date changedate) {
    this.changedate = changedate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  public Date getStatusdate() {
    return statusdate;
  }

  public void setStatusdate(Date statusdate) {
    this.statusdate = statusdate;
  }

  public String getSiteid() {
    return siteid;
  }

  public void setSiteid(String siteid) {
    this.siteid = siteid;
  }

  public String getOrgid() {
    return orgid;
  }

  public void setOrgid(String orgid) {
    this.orgid = orgid;
  }

  public String getTransfername() {
    return transfername;
  }

  public void setTransfername(String transfername) {
    this.transfername = transfername;
  }

  public String getKhcompany() {
    return khcompany;
  }

  public void setKh_company(String khcompany) {
    this.khcompany = khcompany;
  }

  public String getKh_contacts() {
    return khcontacts;
  }

  public void setKh_contacts(String khcontacts) {
    this.khcontacts = khcontacts;
  }

  public String getKh_phone() {
    return khphone;
  }

  public void setKh_phone(String khphone) {
    this.khphone = khphone;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Long getPxnr01() {
    return pxnr01;
  }

  public void setPxnr01(Long pxnr01) {
    this.pxnr01 = pxnr01;
  }

  public Long getPxnr02() {
    return pxnr02;
  }

  public void setPxnr02(Long pxnr02) {
    this.pxnr02 = pxnr02;
  }

  public Long getPxnr03() {
    return pxnr03;
  }

  public void setPxnr03(Long pxnr03) {
    this.pxnr03 = pxnr03;
  }

  public Long getPxnr04() {
    return pxnr04;
  }

  public void setPxnr04(Long pxnr04) {
    this.pxnr04 = pxnr04;
  }

  public Long getPxnr05() {
    return pxnr05;
  }

  public void setPxnr05(Long pxnr05) {
    this.pxnr05 = pxnr05;
  }

  public Long getPxnr06() {
    return pxnr06;
  }

  public void setPxnr06(Long pxnr06) {
    this.pxnr06 = pxnr06;
  }

  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getTrainsuggestion() {
    return trainsuggestion;
  }

  public void setTrainsuggestion(String trainsuggestion) {
    this.trainsuggestion = trainsuggestion;
  }

  public Long getWu() {
    return wu;
  }

  public void setWu(Long wu) {
    this.wu = wu;
  }

  public Long getWxjx() {
    return wxjx;
  }

  public void setWxjx(Long wxjx) {
    this.wxjx = wxjx;
  }

  public Long getYxcz() {
    return yxcz;
  }

  public void setYxcz(Long yxcz) {
    this.yxcz = yxcz;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getTeacher() {
    return teacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  public Date getTraindate() {
    return traindate;
  }

  public void setTraindate(Date traindate) {
    this.traindate = traindate;
  }

  public Long getUdtrainrecordid() {
    return udtrainrecordid;
  }

  public void setUdtrainrecordid(Long udtrainrecordid) {
    this.udtrainrecordid = udtrainrecordid;
  }
}
