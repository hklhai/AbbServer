package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by fuyg on 2017-09-26.
 */
@Entity
@Table(name="UDPROBLEMMODIFY")
@DynamicUpdate
public class Udproblemmodify implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDPROBLEMMODIFY_UDPROBLEMMODIFYID_GENERATOR", allocationSize = 1 , sequenceName="UDPROBLEMMODIFYIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDPROBLEMMODIFY_UDPROBLEMMODIFYID_GENERATOR")
  private Long udproblemmodifyid;
  private String description;
  private String orgid;
  private String siteid;
  private Long hasld;
  private String projectmanager;
  private String status;
  private java.sql.Timestamp statusdate;
  private String creator;
  private java.sql.Timestamp createdate;
  private String changeby;
  private java.sql.Timestamp changedate;
  private String transfername;
  private String number;
  private String remark;
  private Long rowstamp;
  private String pronum;
  private Long linenum;
  private String promanager;

  @Transient
  private String creatorname;
  @Transient
  private String changebyname;
  @Transient
  private String pronumdesc;
  @Transient
  private String linenumdesc;
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
  private Double quantity;
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
  private List<Udpmline> udpmlineList;

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

  public String getKhcompany() {
    return khcompany;
  }

  public void setKhcompany(String khcompany) {
    this.khcompany = khcompany;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getKhcontacts() {
    return khcontacts;
  }

  public void setKhcontacts(String khcontacts) {
    this.khcontacts = khcontacts;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public String getKhphone() {
    return khphone;
  }

  public void setKhphone(String khphone) {
    this.khphone = khphone;
  }

  public String getDeletes() {
    return deletes;
  }

  public void setDeletes(String deletes) {
    this.deletes = deletes;
  }

  public String getMaintab() {
    return maintab;
  }

  public void setMaintab(String maintab) {
    this.maintab = maintab;
  }

  public List<Udpmline> getUdpmlineList() {
    return udpmlineList;
  }

  public void setUdpmlineList(List<Udpmline> udpmlineList) {
    this.udpmlineList = udpmlineList;
  }

  public Long getUdproblemmodifyid() {
    return udproblemmodifyid;
  }

  public void setUdproblemmodifyid(Long udproblemmodifyid) {
    this.udproblemmodifyid = udproblemmodifyid;
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

  public String getProjectmanager() {
    return projectmanager;
  }

  public void setProjectmanager(String projectmanager) {
    this.projectmanager = projectmanager;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public java.sql.Timestamp getStatusdate() {
    return statusdate;
  }

  public void setStatusdate(java.sql.Timestamp statusdate) {
    this.statusdate = statusdate;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public java.sql.Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(java.sql.Timestamp createdate) {
    this.createdate = createdate;
  }

  public String getChangeby() {
    return changeby;
  }

  public void setChangeby(String changeby) {
    this.changeby = changeby;
  }

  public java.sql.Timestamp getChangedate() {
    return changedate;
  }

  public void setChangedate(java.sql.Timestamp changedate) {
    this.changedate = changedate;
  }

  public String getTransfername() {
    return transfername;
  }

  public void setTransfername(String transfername) {
    this.transfername = transfername;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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
}
