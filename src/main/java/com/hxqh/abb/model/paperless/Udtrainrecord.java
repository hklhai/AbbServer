package com.hxqh.abb.model.paperless;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="UDTRAINRECORD")
@DynamicUpdate
public class Udtrainrecord implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name="UDTRAINRECORD_UDTRAINRECORDID_GENERATOR", allocationSize = 1 , sequenceName="UDTRAINRECORDIDSEQ")
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UDTRAINRECORD_UDTRAINRECORDID_GENERATOR")
  private Long udtrainrecordid;
  private String description;
  private String siteid;
  private String orgid;
  private String number;
  private String status;
  private Date statusdate;
  private String creator;
  private Date createdate;
  private String changeby;
  private Date changedate;
  private Long hasld;
  private Long pxnr01;
  private Long pxnr02;
  private Long pxnr03;
  private Long pxnr04;
  private Long pxnr05;
  private Long pxnr06;
  private String other;
  private String trainsuggestion;
  private Long yxcz;
  private Long wxjx;
  private Long wu;
  private String remark;
  private String teacher;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  private java.sql.Date traindate;
  private String transfername;
  private Long rowstamp;
  private Long plant1;
  private Long plant2;
  private Long plant3;
  private Long plant4;
  private Long plant5;
  private Long plant6;
  private String pronum;
  private Long linenum;
  private String promanager;
  private String location;

  @Transient
  private String creatorname;
  @Transient
  private String changebyname;
  @Transient
  private String pronumdesc;
  @Transient
  private String linenumdesc;
  @Transient
  private String projectmanager;
  @Transient
  private String projectmanagername;
  @Transient
  private String servicedep;
  @Transient
  private String khcompany;
  @Transient
  private String model;
  @Transient
  private String khcontacts;
  @Transient
  private BigDecimal quantity;
  @Transient
  private String khphone;
  @Transient
  private String orgiddesc;
  @Transient
  private String siteiddesc;
  @Transient
  private String deletes;
  @Transient
  private String maintab;
  @Transient
  private List<Udtrainrecordline> udtrainrecordlineList;

  public String getCreatorname() {
    return creatorname;
  }

  public void setCreatorname(String creatorname) {
    this.creatorname = creatorname;
  }

  public String getChangebyname() {
    return changebyname;
  }

  public void setChangebyname(String changebyname) {
    this.changebyname = changebyname;
  }

  public String getOrgiddesc() {
    return orgiddesc;
  }

  public void setOrgiddesc(String orgiddesc) {
    this.orgiddesc = orgiddesc;
  }

  public String getSiteiddesc() {
    return siteiddesc;
  }

  public void setSiteiddesc(String siteiddesc) {
    this.siteiddesc = siteiddesc;
  }

  public List<Udtrainrecordline> getUdtrainrecordlineList() {
    return udtrainrecordlineList;
  }

  public void setUdtrainrecordlineList(List<Udtrainrecordline> udtrainrecordlineList) {
    this.udtrainrecordlineList = udtrainrecordlineList;
  }

  public String getMaintab() {

    return maintab;
  }

  public void setMaintab(String maintab) {
    this.maintab = maintab;
  }

  public String getDeletes() {

    return deletes;
  }

  public void setDeletes(String deletes) {
    this.deletes = deletes;
  }

  public String getKhphone() {
    return khphone;
  }

  public void setKhphone(String khphone) {
    this.khphone = khphone;
  }

  public BigDecimal getQuantity() {

    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public String getKhcontacts() {

    return khcontacts;
  }

  public void setKhcontacts(String khcontacts) {
    this.khcontacts = khcontacts;
  }

  public String getModel() {

    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getKhcompany() {

    return khcompany;
  }

  public void setKhcompany(String khcompany) {
    this.khcompany = khcompany;
  }

  public String getServicedep() {

    return servicedep;
  }

  public void setServicedep(String servicedep) {
    this.servicedep = servicedep;
  }

  public String getProjectmanagername() {

    return projectmanagername;
  }

  public void setProjectmanagername(String projectmanagername) {
    this.projectmanagername = projectmanagername;
  }

  public String getLinenumdesc() {

    return linenumdesc;
  }

  public void setLinenumdesc(String linenumdesc) {
    this.linenumdesc = linenumdesc;
  }

  public String getPronumdesc() {
    return pronumdesc;
  }

  public void setPronumdesc(String pronumdesc) {
    this.pronumdesc = pronumdesc;
  }

  public Long getUdtrainrecordid() {
    return udtrainrecordid;
  }

  public void setUdtrainrecordid(Long udtrainrecordid) {
    this.udtrainrecordid = udtrainrecordid;
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

  public String getOrgid() {
    return orgid;
  }

  public void setOrgid(String orgid) {
    this.orgid = orgid;
  }

  public String getProjectmanager() {
    return projectmanager;
  }

  public void setProjectmanager(String projectmanager) {
    this.projectmanager = projectmanager;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
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

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
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

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
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

  public String getTrainsuggestion() {
    return trainsuggestion;
  }

  public void setTrainsuggestion(String trainsuggestion) {
    this.trainsuggestion = trainsuggestion;
  }

  public Long getYxcz() {
    return yxcz;
  }

  public void setYxcz(Long yxcz) {
    this.yxcz = yxcz;
  }

  public Long getWxjx() {
    return wxjx;
  }

  public void setWxjx(Long wxjx) {
    this.wxjx = wxjx;
  }

  public Long getWu() {
    return wu;
  }

  public void setWu(Long wu) {
    this.wu = wu;
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

  public java.sql.Date getTraindate() {
    return traindate;
  }

  public void setTraindate(java.sql.Date traindate) {
    this.traindate = traindate;
  }

  public String getTransfername() {
    return transfername;
  }

  public void setTransfername(String transfername) {
    this.transfername = transfername;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public Long getPlant1() {
    return plant1;
  }

  public void setPlant1(Long plant1) {
    this.plant1 = plant1;
  }

  public Long getPlant2() {
    return plant2;
  }

  public void setPlant2(Long plant2) {
    this.plant2 = plant2;
  }

  public Long getPlant3() {
    return plant3;
  }

  public void setPlant3(Long plant3) {
    this.plant3 = plant3;
  }

  public Long getPlant4() {
    return plant4;
  }

  public void setPlant4(Long plant4) {
    this.plant4 = plant4;
  }

  public Long getPlant5() {
    return plant5;
  }

  public void setPlant5(Long plant5) {
    this.plant5 = plant5;
  }

  public Long getPlant6() {
    return plant6;
  }

  public void setPlant6(Long plant6) {
    this.plant6 = plant6;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
  }

  public String getPromanager() {
    return promanager;
  }

  public void setPromanager(String promanager) {
    this.promanager = promanager;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
