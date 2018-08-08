package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "UDSAFECHECK")
public class Udsafecheck implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDSAFECHECK_UDSAFECHECKID_GENERATOR", allocationSize = 1 , sequenceName="UDSAFECHECKIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDSAFECHECK_UDSAFECHECKID_GENERATOR")
  private Long udsafecheckid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String scnum;
  private String pronum;
  private String createdby;
  private Date createddate;
  private String changeby;
  private Date changedate;
  private String status;
  private Date statusdate;
  private Long rowstamp;
  private Long linenum;
  private String customerrequire;
  private Long safeagreement = Long.valueOf(0);
  private Date startdate;
  private Date enddate;
  private Long days;

  @Transient
  private String changebyname;
  @Transient
  private String createdbyname;
  @Transient
  private String pronumdesc;
  @Transient
  private String linenumdesc;
  @Transient
  private String projectmanager;
  @Transient
  private String projectmanagername;
  @Transient
  private String orgiddesc;
  @Transient
  private String siteiddesc;
  @Transient
  private String maintab;

  @Transient
  private List<Udqualification> udqualificationList;
  @Transient
  private List<Udchemicals> udchemicalsList;
  @Transient
  private List<Udprotective> udprotectiveList;
  @Transient
  private List<Udworkpermit> udworkpermitList;
  @Transient
  private List<Udtraincontent> udtraincontentList;
  @Transient
  private List<Udsafemeeting> udsafemeetingList;
  @Transient
  private List<Udemergency> udemergencyList;
  @Transient
  private List<Udassignmentrisk> udassignmentriskList;
  @Transient
  private List<Udsafeline> udsafelinecList;
  @Transient
  private List<Udsafeline> udsafelinetList;
  @Transient
  private List<Udsafeline> udsafelinevList;
  @Transient
  private String deletes;

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

  public String getDeletes() {
    return deletes;
  }

  public void setDeletes(String deletes) {
    this.deletes = deletes;
  }

  public List<Udqualification> getUdqualificationList() {
    return udqualificationList;
  }

  public void setUdqualificationList(List<Udqualification> udqualificationList) {
    this.udqualificationList = udqualificationList;
  }

  public List<Udchemicals> getUdchemicalsList() {
    return udchemicalsList;
  }

  public void setUdchemicalsList(List<Udchemicals> udchemicalsList) {
    this.udchemicalsList = udchemicalsList;
  }

  public List<Udprotective> getUdprotectiveList() {
    return udprotectiveList;
  }

  public void setUdprotectiveList(List<Udprotective> udprotectiveList) {
    this.udprotectiveList = udprotectiveList;
  }

  public List<Udworkpermit> getUdworkpermitList() {
    return udworkpermitList;
  }

  public void setUdworkpermitList(List<Udworkpermit> udworkpermitList) {
    this.udworkpermitList = udworkpermitList;
  }

  public List<Udtraincontent> getUdtraincontentList() {
    return udtraincontentList;
  }

  public void setUdtraincontentList(List<Udtraincontent> udtraincontentList) {
    this.udtraincontentList = udtraincontentList;
  }

  public List<Udsafemeeting> getUdsafemeetingList() {
    return udsafemeetingList;
  }

  public void setUdsafemeetingList(List<Udsafemeeting> udsafemeetingList) {
    this.udsafemeetingList = udsafemeetingList;
  }

  public List<Udemergency> getUdemergencyList() {
    return udemergencyList;
  }

  public void setUdemergencyList(List<Udemergency> udemergencyList) {
    this.udemergencyList = udemergencyList;
  }

  public List<Udassignmentrisk> getUdassignmentriskList() {
    return udassignmentriskList;
  }

  public void setUdassignmentriskList(List<Udassignmentrisk> udassignmentriskList) {
    this.udassignmentriskList = udassignmentriskList;
  }

  public List<Udsafeline> getUdsafelinecList() {
    return udsafelinecList;
  }

  public void setUdsafelinecList(List<Udsafeline> udsafelinecList) {
    this.udsafelinecList = udsafelinecList;
  }

  public List<Udsafeline> getUdsafelinetList() {
    return udsafelinetList;
  }

  public void setUdsafelinetList(List<Udsafeline> udsafelinetList) {
    this.udsafelinetList = udsafelinetList;
  }

  public List<Udsafeline> getUdsafelinevList() {
    return udsafelinevList;
  }

  public void setUdsafelinevList(List<Udsafeline> udsafelinevList) {
    this.udsafelinevList = udsafelinevList;
  }

  public String getProjectmanager() {
    return projectmanager;
  }

  public void setProjectmanager(String projectmanager) {
    this.projectmanager = projectmanager;
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

  public String getMaintab() {
    return maintab;
  }

  public void setMaintab(String maintab) {
    this.maintab = maintab;
  }

  public Long getUdsafecheckid() {
    return udsafecheckid;
  }

  public void setUdsafecheckid(Long udsafecheckid) {
    this.udsafecheckid = udsafecheckid;
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

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public String getScnum() {
    return scnum;
  }

  public void setScnum(String scnum) {
    this.scnum = scnum;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public String getCreatedby() {
    return createdby;
  }

  public void setCreatedby(String createdby) {
    this.createdby = createdby;
  }

  public Date getCreateddate() {
    return createddate;
  }

  public void setCreateddate(Date createddate) {
    this.createddate = createddate;
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

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
  }

  public String getCustomerrequire() {
    return customerrequire;
  }

  public void setCustomerrequire(String customerrequire) {
    this.customerrequire = customerrequire;
  }

  public Long getSafeagreement() {
    return safeagreement;
  }

  public void setSafeagreement(Long safeagreement) {
    this.safeagreement = safeagreement;
  }

  public void setStartdate(Date startdate) {
    this.startdate = startdate;
  }

  public void setEnddate(Date enddate) {
    this.enddate = enddate;
  }

  public Date getStartdate() {
    return startdate;
  }

  public void setStartdate(String startdate) {
    if(startdate!=null&&!startdate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.startdate = sdf.parse(startdate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Date getEnddate() {
    return enddate;
  }

  public void setEnddate(String enddate) {
    if(enddate!=null&&!enddate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.enddate = sdf.parse(enddate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Long getDays() {
    return days;
  }

  public void setDays(Long days) {
    this.days = days;
  }
}
