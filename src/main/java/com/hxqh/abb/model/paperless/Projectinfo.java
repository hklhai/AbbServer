package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "PROJECTINFO")
public class Projectinfo implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "PROJECTINFO_projectinfoid_GENERATOR", sequenceName = "PROJECTINFOIDSEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECTINFO_projectinfoid_GENERATOR")
  private Long projectinfoid;
  private String description;
  private String substationname;
  private String contractnum;
  private Long linenum;
  private String projectmanager;
  private Long hasld;
  private String telephone;
  private String email;
  private String fax;
  private String devicenumber;
  private String devicename;
  private String orgid;
  private String status;
  private String creator;
  private java.sql.Timestamp createdate;
  private String siteid;
  private String changeby;
  private java.sql.Timestamp changedate;
  private java.sql.Timestamp stautsdate;
  private String number;
  private String days;
  private String frequency;
  private Date installstartdate;
  private Date installenddate;
  private String installdays;
  private Date songstartdate;
  private String songdays;
  private Date songenddate;
  private Date debugenddate;
  private Date debugstartdate;
  private String receiver;
  private Date signdate;
  private String debugday;
  private String description2;
  @Column(name="fw_manager")
  private String fwmanager;
  @Column(name="fw_telephone")
  private String fwtelephone;
  @Column(name="fw_email")
  private String fwemail;
  @Column(name="fw_fox")
  private String fwfox;
  @Column(name="kh_company")
  private String khcompany;
  @Column(name="kh_contacts")
  private String khcontacts;
  @Column(name="kh_email")
  private String khemail;
  @Column(name="kh_telephone")
  private String khtelephone;
  @Column(name="kh_fax")
  private String khfax;
  @Column(name="ht_company")
  private String htcompany;
  @Column(name="ht_contacts")
  private String htcontacts;
  @Column(name="ht_telephone")
  private String httelephone;
  @Column(name="yz_company")
  private String yzcompany;
  @Column(name="yz_contacts")
  private String yzcontacts;
  @Column(name="yz_telephone")
  private String yztelephone;
  @Column(name="sg_company")
  private String sgcompany;
  @Column(name="sg_contacts")
  private String sgcontacts;
  @Column(name="sg_telephone")
  private String sgtelephone;
  @Column(name="jl_company")
  private String jlcompany;
  @Column(name="jl_contacts")
  private String jlcontacts;
  @Column(name="jl_telephone")
  private String jltelephone;
  private String pronum;
  private String promanager;
  private Long rowstamp;
  private String projectnum;

  @Transient
  private String pronumdesc;
  @Transient
  private String linenumdesc;
  @Transient
  private String servicedep;
  @Transient
  private String model;
  @Transient
  private String producer;
  @Transient
  private Long kv;
  @Transient
  private Double quantity;
  @Transient
  private String statusdesc;
  @Transient
  private String creatorname;
  @Transient
  private String orgiddesc;
  @Transient
  private String siteiddesc;
  @Transient
  private String changebyname;
  @Transient
  private String projectdesc;
  @Transient
  private String promanagername;
  @Transient
  private String receivername;
  @Transient
  private String deletes;
  @Transient
  private String maintab;

  public String getDeletes() {
    return deletes;
  }

  public String getOrgiddesc() {
    return orgiddesc;
  }

  public void setOrgiddesc(String orgiddesc) {
    this.orgiddesc = orgiddesc;
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

  public String getServicedep() {
    return servicedep;
  }

  public void setServicedep(String servicedep) {
    this.servicedep = servicedep;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public Long getKv() {
    return kv;
  }

  public void setKv(Long kv) {
    this.kv = kv;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public String getReceivername() {
    return receivername;
  }

  public void setReceivername(String receivername) {
    this.receivername = receivername;
  }

  public Long getProjectinfoid() {
    return projectinfoid;
  }

  public void setProjectinfoid(Long projectinfoid) {
    this.projectinfoid = projectinfoid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSubstationname() {
    return substationname;
  }

  public void setSubstationname(String substationname) {
    this.substationname = substationname;
  }

  public String getContractnum() {
    return contractnum;
  }

  public void setContractnum(String contractnum) {
    this.contractnum = contractnum;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
  }

  public String getProjectmanager() {
    return projectmanager;
  }

  public void setProjectmanager(String projectmanager) {
    this.projectmanager = projectmanager;
  }

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getDevicenumber() {
    return devicenumber;
  }

  public void setDevicenumber(String devicenumber) {
    this.devicenumber = devicenumber;
  }

  public String getDevicename() {
    return devicename;
  }

  public void setDevicename(String devicename) {
    this.devicename = devicename;
  }

  public String getOrgid() {
    return orgid;
  }

  public void setOrgid(String orgid) {
    this.orgid = orgid;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(Timestamp createdate) {
    this.createdate = createdate;
  }

  public String getSiteid() {
    return siteid;
  }

  public void setSiteid(String siteid) {
    this.siteid = siteid;
  }

  public String getChangeby() {
    return changeby;
  }

  public void setChangeby(String changeby) {
    this.changeby = changeby;
  }

  public Timestamp getChangedate() {
    return changedate;
  }

  public void setChangedate(Timestamp changedate) {
    this.changedate = changedate;
  }

  public Timestamp getStautsdate() {
    return stautsdate;
  }

  public void setStautsdate(Timestamp stautsdate) {
    this.stautsdate = stautsdate;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public Date getInstallstartdate() {
    return installstartdate;
  }

  public void setInstallstartdate(Date installstartdate) {
    this.installstartdate = installstartdate;
  }

  public void setInstallstartdate(String installstartdate) {
    if(installstartdate!=null&&!installstartdate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.installstartdate = sdf.parse(installstartdate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Date getInstallenddate() {
    return installenddate;
  }

  public void setInstallenddate(Date installenddate) {
    this.installenddate = installenddate;
  }

  public void setInstallenddate(String installenddate) {
    if(installenddate!=null&&!installenddate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.installenddate = sdf.parse(installenddate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getInstalldays() {
    return installdays;
  }

  public void setInstalldays(String installdays) {
    this.installdays = installdays;
  }

  public Date getSongstartdate() {
    return songstartdate;
  }

  public void setSongstartdate(Date songstartdate) {
    this.songstartdate = songstartdate;
  }

  public void setSongstartdate(String songstartdate) {
    if(songstartdate!=null&&!songstartdate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.songstartdate = sdf.parse(songstartdate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getSongdays() {
    return songdays;
  }

  public void setSongdays(String songdays) {
    this.songdays = songdays;
  }

  public Date getSongenddate() {
    return songenddate;
  }

  public void setSongenddate(Date songenddate) {
    this.songenddate = songenddate;
  }

  public void setSongenddate(String songenddate) {
    if(songenddate!=null&&!songenddate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.songenddate = sdf.parse(songenddate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Date getDebugenddate() {
    return debugenddate;
  }

  public void setDebugenddate(Date debugenddate) {
    this.debugenddate = debugenddate;
  }

  public void setDebugenddate(String debugenddate) {
    if(debugenddate!=null&&!debugenddate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.debugenddate = sdf.parse(debugenddate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Date getDebugstartdate() {
    return debugstartdate;
  }

  public void setDebugstartdate(Date debugstartdate) {
    this.debugstartdate = debugstartdate;
  }

  public void setDebugstartdate(String debugstartdate) {
    if(debugstartdate!=null&&!debugstartdate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.debugstartdate = sdf.parse(debugstartdate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public Date getSigndate() {
    return signdate;
  }

  public void setSigndate(Date signdate) {
    this.signdate = signdate;
  }

  public void setSigndate(String signdate) {
    if(signdate!=null&&!signdate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.signdate = sdf.parse(signdate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getDebugday() {
    return debugday;
  }

  public void setDebugday(String debugday) {
    this.debugday = debugday;
  }

  public String getDescription2() {
    return description2;
  }

  public void setDescription2(String description2) {
    this.description2 = description2;
  }

  public String getFwmanager() {
    return fwmanager;
  }

  public void setFwmanager(String fwmanager) {
    this.fwmanager = fwmanager;
  }

  public String getFwtelephone() {
    return fwtelephone;
  }

  public void setFwtelephone(String fwtelephone) {
    this.fwtelephone = fwtelephone;
  }

  public String getFwemail() {
    return fwemail;
  }

  public void setFwemail(String fwemail) {
    this.fwemail = fwemail;
  }

  public String getFwfox() {
    return fwfox;
  }

  public void setFwfox(String fwfox) {
    this.fwfox = fwfox;
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

  public String getKhemail() {
    return khemail;
  }

  public void setKhemail(String khemail) {
    this.khemail = khemail;
  }

  public String getKhtelephone() {
    return khtelephone;
  }

  public void setKhtelephone(String khtelephone) {
    this.khtelephone = khtelephone;
  }

  public String getKhfax() {
    return khfax;
  }

  public void setKhfax(String khfax) {
    this.khfax = khfax;
  }

  public String getHtcompany() {
    return htcompany;
  }

  public void setHtcompany(String htcompany) {
    this.htcompany = htcompany;
  }

  public String getHtcontacts() {
    return htcontacts;
  }

  public void setHtcontacts(String htcontacts) {
    this.htcontacts = htcontacts;
  }

  public String getHttelephone() {
    return httelephone;
  }

  public void setHttelephone(String httelephone) {
    this.httelephone = httelephone;
  }

  public String getYzcompany() {
    return yzcompany;
  }

  public void setYzcompany(String yzcompany) {
    this.yzcompany = yzcompany;
  }

  public String getYzcontacts() {
    return yzcontacts;
  }

  public void setYzcontacts(String yzcontacts) {
    this.yzcontacts = yzcontacts;
  }

  public String getYztelephone() {
    return yztelephone;
  }

  public void setYztelephone(String yztelephone) {
    this.yztelephone = yztelephone;
  }

  public String getSgcompany() {
    return sgcompany;
  }

  public void setSgcompany(String sgcompany) {
    this.sgcompany = sgcompany;
  }

  public String getSgcontacts() {
    return sgcontacts;
  }

  public void setSgcontacts(String sgcontacts) {
    this.sgcontacts = sgcontacts;
  }

  public String getSgtelephone() {
    return sgtelephone;
  }

  public void setSgtelephone(String sgtelephone) {
    this.sgtelephone = sgtelephone;
  }

  public String getJlcompany() {
    return jlcompany;
  }

  public void setJlcompany(String jlcompany) {
    this.jlcompany = jlcompany;
  }

  public String getJlcontacts() {
    return jlcontacts;
  }

  public void setJlcontacts(String jlcontacts) {
    this.jlcontacts = jlcontacts;
  }

  public String getJltelephone() {
    return jltelephone;
  }

  public void setJltelephone(String jltelephone) {
    this.jltelephone = jltelephone;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public String getPromanager() {
    return promanager;
  }

  public void setPromanager(String promanager) {
    this.promanager = promanager;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getProjectnum() {
    return projectnum;
  }

  public void setProjectnum(String projectnum) {
    this.projectnum = projectnum;
  }

  public String getStatusdesc() {
    return statusdesc;
  }

  public void setStatusdesc(String statusdesc) {
    this.statusdesc = statusdesc;
  }

  public String getCreatorname() {
    return creatorname;
  }

  public void setCreatorname(String creatorname) {
    this.creatorname = creatorname;
  }

  public String getSiteiddesc() {
    return siteiddesc;
  }

  public void setSiteiddesc(String siteiddesc) {
    this.siteiddesc = siteiddesc;
  }

  public String getChangebyname() {
    return changebyname;
  }

  public void setChangebyname(String changebyname) {
    this.changebyname = changebyname;
  }

  public String getProjectdesc() {
    return projectdesc;
  }

  public void setProjectdesc(String projectdesc) {
    this.projectdesc = projectdesc;
  }

  public String getPromanagername() {
    return promanagername;
  }

  public void setPromanagername(String promanagername) {
    this.promanagername = promanagername;
  }
}
