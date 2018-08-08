package com.hxqh.abb.model.view;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Administrator on 2017-09-29.
 */
@Entity
@Table(name = "PAPERLESS_UDDELEGATE")
public class Paperless_uddelegate implements Serializable {
  @Id
  @SequenceGenerator(name = "UDDELEGATE_uddelegateid_GENERATOR", sequenceName = "UDDELEGATEIDEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDDELEGATE_uddelegateid_GENERATOR")
  private Long uddelegateid;

  private String dlgnum;

  private String description;

  private String appointperson;

  private String appointpersonname;

  private String recipient;

  private String recipientname;

  private String pronum;

  private String projectdesc;

  private Long linenum;

  private String status;

  private String statusdesc;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date statusdate;

  private String orgid;

  private String siteid;

  private String siteiddesc;

  private String areamanager;

  private String areamanagername;

  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  private Date arrivescenedate;

  private String changeby;

  private String changebyname;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date changedate;

  private String coding;

  private String createby;

  private String createdbyname;

  private Date createdate;

  private String delegate;

  @JsonFormat(pattern="yyyy/MM/dd HH:mm",timezone = "GMT+8")
  private Date delegatedate;

  private Long hasld;

  private String jobcontent;

  private String model;

  private Long number;

  private String promanager;

  private String promanagername;

  private Double quantity;

  private String reviewer;

  private Long rowstamp;

  private String servicedep;

  private String servicenature;

  private String serviceproperties;

  private String sitemanager;

  private String workhead;

  private String worknumber;

  public Long getUddelegateid() {
    return uddelegateid;
  }

  public void setUddelegateid(Long uddelegateid) {
    this.uddelegateid = uddelegateid;
  }

  public String getDlgnum() {
    return dlgnum;
  }

  public void setDlgnum(String dlgnum) {
    this.dlgnum = dlgnum;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAppointperson() {
    return appointperson;
  }

  public void setAppointperson(String appointperson) {
    this.appointperson = appointperson;
  }

  public String getAppointpersonname() {
    return appointpersonname;
  }

  public void setAppointpersonname(String appointpersonname) {
    this.appointpersonname = appointpersonname;
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getRecipientname() {
    return recipientname;
  }

  public void setRecipientname(String recipientname) {
    this.recipientname = recipientname;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public String getProjectdesc() {
    return projectdesc;
  }

  public void setProjectdesc(String projectdesc) {
    this.projectdesc = projectdesc;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
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

  public Date getStatusdate() {
    return statusdate;
  }

  public void setStatusdate(Date statusdate) {
    this.statusdate = statusdate;
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

  public String getSiteiddesc() {
    return siteiddesc;
  }

  public void setSiteiddesc(String siteiddesc) {
    this.siteiddesc = siteiddesc;
  }

  public String getAreamanager() {
    return areamanager;
  }

  public void setAreamanager(String areamanager) {
    this.areamanager = areamanager;
  }

  public String getAreamanagername() {
    return areamanagername;
  }

  public void setAreamanagername(String areamanagername) {
    this.areamanagername = areamanagername;
  }

  public Date getArrivescenedate() {
    return arrivescenedate;
  }

  public void setArrivescenedate(Date arrivescenedate) {
    this.arrivescenedate = arrivescenedate;
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

  public Date getChangedate() {
    return changedate;
  }

  public void setChangedate(Date changedate) {
    this.changedate = changedate;
  }

  public String getCoding() {
    return coding;
  }

  public void setCoding(String coding) {
    this.coding = coding;
  }

  public String getCreateby() {
    return createby;
  }

  public void setCreateby(String createby) {
    this.createby = createby;
  }

  public String getCreatedbyname() {
    return createdbyname;
  }

  public void setCreatedbyname(String createdbyname) {
    this.createdbyname = createdbyname;
  }

  public Date getCreatedate() {
    return createdate;
  }

  public void setCreatedate(Date createdate) {
    this.createdate = createdate;
  }

  public String getDelegate() {
    return delegate;
  }

  public void setDelegate(String delegate) {
    this.delegate = delegate;
  }

  public Date getDelegatedate() {
    return delegatedate;
  }

  public void setDelegatedate(Date delegatedate) {
    this.delegatedate = delegatedate;
  }

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public String getJobcontent() {
    return jobcontent;
  }

  public void setJobcontent(String jobcontent) {
    this.jobcontent = jobcontent;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
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

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public String getReviewer() {
    return reviewer;
  }

  public void setReviewer(String reviewer) {
    this.reviewer = reviewer;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getServicedep() {
    return servicedep;
  }

  public void setServicedep(String servicedep) {
    this.servicedep = servicedep;
  }

  public String getServicenature() {
    return servicenature;
  }

  public void setServicenature(String servicenature) {
    this.servicenature = servicenature;
  }

  public String getServiceproperties() {
    return serviceproperties;
  }

  public void setServiceproperties(String serviceproperties) {
    this.serviceproperties = serviceproperties;
  }

  public String getSitemanager() {
    return sitemanager;
  }

  public void setSitemanager(String sitemanager) {
    this.sitemanager = sitemanager;
  }

  public String getWorkhead() {
    return workhead;
  }

  public void setWorkhead(String workhead) {
    this.workhead = workhead;
  }

  public String getWorknumber() {
    return worknumber;
  }

  public void setWorknumber(String worknumber) {
    this.worknumber = worknumber;
  }
}
