package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-09-29.
 */
@Entity
@Table(name = "UDDELEGATE")
public class Uddelegate implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "UDDELEGATE_uddelegateid_GENERATOR", sequenceName = "UDDELEGATEIDSEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDDELEGATE_uddelegateid_GENERATOR")
  private Long uddelegateid;
  private String description;
  private String orgid;
  private String siteid;
  private Long hasld;

  @Column(name="createdby")
  private String createby;

  @Column(name="createddate")
  private Date createdate;

  private String changeby;
  private Date changedate;
  private String status;
  private Date statusdate;
  private String servicenature;

  private Date delegatedate;
  private String recipient;
  private String worknumber;
  private String reviewer;
  private String serviceproperties;
  private String pronum;
  private Long linenum;
  private String projectdesc;
  private String model;
  private Double quantity;
  private String servicedep;
  private Date arrivescenedate;
  private String jobcontent;
  private String appointperson;
  private Long rowstamp;
  private String dlgnum;
  private Long number;
  private String delegate;
  private String coding;
  private String promanager;
  private String sitemanager;
  private String areamanager;
  private String workhead;

  @Transient
  private String changebyname;
  @Transient
  private String createdbyname;
  @Transient
  private String orgiddesc;
  @Transient
  private String siteiddesc;
  @Transient
  private String areamanagername;
  @Transient
  private String promanagername;
  @Transient
  private String appointpersonname;
  @Transient
  private String recipientname;
  @Transient
  private String statusdesc;
  @Transient
  private String deletes;
  @Transient
  private String maintab;

  public String getOrgiddesc() {
    return orgiddesc;
  }

  public void setOrgiddesc(String orgiddesc) {
    this.orgiddesc = orgiddesc;
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

  public String getSiteiddesc() {
    return siteiddesc;
  }

  public void setSiteiddesc(String siteiddesc) {
    this.siteiddesc = siteiddesc;
  }

  public String getAreamanagername() {
    return areamanagername;
  }

  public void setAreamanagername(String areamanagername) {
    this.areamanagername = areamanagername;
  }

  public String getPromanagername() {
    return promanagername;
  }

  public void setPromanagername(String promanagername) {
    this.promanagername = promanagername;
  }

  public String getChangebyname() {
    return changebyname;
  }

  public void setChangebyname(String changebyname) {
    this.changebyname = changebyname;
  }

  public String getCreatedbyname() {
    return createdbyname;
  }

  public void setCreatedbyname(String createdbyname) {
    this.createdbyname = createdbyname;
  }

  public String getAppointpersonname() {
    return appointpersonname;
  }

  public void setAppointpersonname(String appointpersonname) {
    this.appointpersonname = appointpersonname;
  }

  public String getRecipientname() {
    return recipientname;
  }

  public void setRecipientname(String recipientname) {
    this.recipientname = recipientname;
  }

  public String getStatusdesc() {
    return statusdesc;
  }

  public void setStatusdesc(String statusdesc) {
    this.statusdesc = statusdesc;
  }

  public Long getUddelegateid() {
    return uddelegateid;
  }

  public void setUddelegateid(Long uddelegateid) {
    this.uddelegateid = uddelegateid;
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

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
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

  public String getServicenature() {
    return servicenature;
  }

  public void setServicenature(String servicenature) {
    this.servicenature = servicenature;
  }

  public Date getDelegatedate() {
    return delegatedate;
  }

  public void setDelegatedate(Date delegatedate) {
    this.delegatedate = delegatedate;
  }

  public void setDelegatedate(String delegatedate) {
    if(delegatedate!=null&&!delegatedate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.delegatedate = sdf.parse(delegatedate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getWorknumber() {
    return worknumber;
  }

  public void setWorknumber(String worknumber) {
    this.worknumber = worknumber;
  }

  public String getReviewer() {
    return reviewer;
  }

  public void setReviewer(String reviewer) {
    this.reviewer = reviewer;
  }

  public String getServiceproperties() {
    return serviceproperties;
  }

  public void setServiceproperties(String serviceproperties) {
    this.serviceproperties = serviceproperties;
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

  public String getProjectdesc() {
    return projectdesc;
  }

  public void setProjectdesc(String projectdesc) {
    this.projectdesc = projectdesc;
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

  public String getServicedep() {
    return servicedep;
  }

  public void setServicedep(String servicedep) {
    this.servicedep = servicedep;
  }

  public Date getArrivescenedate() {
    return arrivescenedate;
  }

  public void setArrivescenedate(Date arrivescenedate) {
    this.arrivescenedate = arrivescenedate;
  }

  public void setArrivescenedate(String arrivescenedate) {
    if(arrivescenedate!=null&&!arrivescenedate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.arrivescenedate = sdf.parse(arrivescenedate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getJobcontent() {
    return jobcontent;
  }

  public void setJobcontent(String jobcontent) {
    this.jobcontent = jobcontent;
  }

  public String getAppointperson() {
    return appointperson;
  }

  public void setAppointperson(String appointperson) {
    this.appointperson = appointperson;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getDlgnum() {
    return dlgnum;
  }

  public void setDlgnum(String dlgnum) {
    this.dlgnum = dlgnum;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public String getDelegate() {
    return delegate;
  }

  public void setDelegate(String delegate) {
    this.delegate = delegate;
  }

  public String getCoding() {
    return coding;
  }

  public void setCoding(String coding) {
    this.coding = coding;
  }

  public String getPromanager() {
    return promanager;
  }

  public void setPromanager(String promanager) {
    this.promanager = promanager;
  }

  public String getSitemanager() {
    return sitemanager;
  }

  public void setSitemanager(String sitemanager) {
    this.sitemanager = sitemanager;
  }

  public String getAreamanager() {
    return areamanager;
  }

  public void setAreamanager(String areamanager) {
    this.areamanager = areamanager;
  }

  public String getWorkhead() {
    return workhead;
  }

  public void setWorkhead(String workhead) {
    this.workhead = workhead;
  }
}
