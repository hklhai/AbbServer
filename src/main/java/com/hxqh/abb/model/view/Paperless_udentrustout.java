package com.hxqh.abb.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Paperless_UdentrustoutDao")
public class Paperless_udentrustout  implements Serializable {
  @Id
  @SequenceGenerator(name = "UDENTRUSTOUT_udentrustoutid_GENERATOR", sequenceName = "UDENTRUSTOUTIDSEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDENTRUSTOUT_udentrustoutid_GENERATOR")
  private Long udentrustoutid;
  private String description;
  private String siteid;
  private String siteiddesc;
  private String orgid;
  private String number;
  private String projectmanager;
  private String projectmanagername;
  private Long hasld;
  private Long switchs;
  private Long attachment;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  private java.sql.Date effectivetime;
  private String approve;
  private String approvename;
  private String contacts;
  private String contactsname;
  private String telephone;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private java.sql.Timestamp createdate;
  private String createby;
  private String createbyname;
  private String changeby;
  private String changebyname;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private java.sql.Timestamp changedate;
  private String status;
  private String statusdesc;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private java.sql.Timestamp statusdate;
  private String nowmanager;
  private String nowmanagername;
  private Long rowstamp;
  private String pronum;
  private String pronumdesc;
  private String khcompany;
  private String khcontacts;
  private String khphone;
  private Long linenum;
  private String linenumdesc;
  private String promanager;
  private String promanagername;

  public String getPronumdesc() {
    return pronumdesc;
  }

  public void setPronumdesc(String pronumdesc) {
    this.pronumdesc = pronumdesc;
  }

  public String getLinenumdesc() {
    return linenumdesc;
  }

  public void setLinenumdesc(String linenumdesc) {
    this.linenumdesc = linenumdesc;
  }

  public Long getUdentrustoutid() {
    return udentrustoutid;
  }

  public void setUdentrustoutid(Long udentrustoutid) {
    this.udentrustoutid = udentrustoutid;
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

  public String getSiteiddesc() {
    return siteiddesc;
  }

  public void setSiteiddesc(String siteiddesc) {
    this.siteiddesc = siteiddesc;
  }

  public String getOrgid() {
    return orgid;
  }

  public void setOrgid(String orgid) {
    this.orgid = orgid;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
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

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public Long getSwitchs() {
    return switchs;
  }

  public void setSwitchs(Long switchs) {
    this.switchs = switchs;
  }

  public Long getAttachment() {
    return attachment;
  }

  public void setAttachment(Long attachment) {
    this.attachment = attachment;
  }

  public java.sql.Date getEffectivetime() {
    return effectivetime;
  }

  public void setEffectivetime(java.sql.Date effectivetime) {
    this.effectivetime = effectivetime;
  }

  public String getApprove() {
    return approve;
  }

  public void setApprove(String approve) {
    this.approve = approve;
  }

  public String getApprovename() {
    return approvename;
  }

  public void setApprovename(String approvename) {
    this.approvename = approvename;
  }

  public String getContacts() {
    return contacts;
  }

  public void setContacts(String contacts) {
    this.contacts = contacts;
  }

  public String getContactsname() {
    return contactsname;
  }

  public void setContactsname(String contactsname) {
    this.contactsname = contactsname;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public java.sql.Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(java.sql.Timestamp createdate) {
    this.createdate = createdate;
  }

  public String getCreateby() {
    return createby;
  }

  public void setCreateby(String createby) {
    this.createby = createby;
  }

  public String getCreatebyname() {
    return createbyname;
  }

  public void setCreatebyname(String createbyname) {
    this.createbyname = createbyname;
  }

  public String getChangeby() {
    return changeby;
  }

  public void setChangeby(String changeby) {
    this.changeby = changeby;
  }

  public String getChangebyname() {
    return changebyname;
  }

  public void setChangebyname(String changebyname) {
    this.changebyname = changebyname;
  }

  public java.sql.Timestamp getChangedate() {
    return changedate;
  }

  public void setChangedate(java.sql.Timestamp changedate) {
    this.changedate = changedate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatusdesc() {
    return statusdesc;
  }

  public void setStatusdesc(String statusdesc) {
    this.statusdesc = statusdesc;
  }

  public java.sql.Timestamp getStatusdate() {
    return statusdate;
  }

  public void setStatusdate(java.sql.Timestamp statusdate) {
    this.statusdate = statusdate;
  }

  public String getNowmanager() {
    return nowmanager;
  }

  public void setNowmanager(String nowmanager) {
    this.nowmanager = nowmanager;
  }

  public String getNowmanagername() {
    return nowmanagername;
  }

  public void setNowmanagername(String nowmanagername) {
    this.nowmanagername = nowmanagername;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public String getKhcompany() {
    return khcompany;
  }

  public void setKhcompany(String khcompany) {
    this.khcompany = khcompany;
  }

  public String getKhcontacts() {
    return khcontacts;
  }

  public void setKhcontacts(String khcontacts) {
    this.khcontacts = khcontacts;
  }

  public String getKhphone() {
    return khphone;
  }

  public void setKhphone(String khphone) {
    this.khphone = khphone;
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

  public String getPromanagername() {
    return promanagername;
  }

  public void setPromanagername(String promanagername) {
    this.promanagername = promanagername;
  }
}
