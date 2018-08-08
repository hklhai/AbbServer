package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fuyg on 2017-10-27.
 */
@Entity
@Table(name="UDWORKREPORT")
@DynamicUpdate
public class Udworkreport implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDWORKREPORT_UDWORKREPORTID_GENERATOR", allocationSize = 1 , sequenceName="UDWORKREPORTIDSEQ")
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UDWORKREPORT_UDWORKREPORTID_GENERATOR")
  private Long udworkreportid;
  private String description;
  private String orgid;
  private String siteid;
  private String pronum;
  private Long linenum;
  private String changeby;
  private java.sql.Timestamp changedate;
  private String creator;
  private java.sql.Timestamp createdate;
  private String status;
  private java.sql.Timestamp statusdate;
  private Long hasld;
  private Long rowstamp;
  private String number;
  private String service1;
  private String service2;
  private String service3;
  private java.util.Date workdate;
  private Long worktime;
  private String phase;
  private String materiel;
  private String promanager;
  private String equnum;
  private String details;
  private Long productnum;
  private String others;
  private String ptw;
  private String customer;
  private String delegatenum;
  private String delegateman;
  private String nature;
  private String company;
  private String delegatedetail;
  private String service4;
  private String service5;
  private String service6;
  private String type;
  private String edn;
  private String xuhao;
  private String ordernum;
  private String xian;
  private String maifang;
  private String zhixing;
  private String ccrp;
  private String worknum;
  private String workcontent;
  private String service7;
  private String service8;
  private String service9;
  private String yuanxuhao;
  private String other;
  private Long signedname = Long.valueOf(0);

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
  private String equnumdesc;
  @Transient
  private String unit;
  @Transient
  private String mobilephone;
  @Transient
  private String orgiddesc;
  @Transient
  private String siteiddesc;
  @Transient
  private String maintab;
  @Transient
  private String isdel;
  @Transient
  private String deletes;
  @Transient
  private List<Udworkcontent> udworkcontentList;
  @Transient
  private List<Udnormalservice> udnormalserviceList;

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

  public String getDeletes() {
    return deletes;
  }

  public void setDeletes(String deletes) {
    this.deletes = deletes;
  }

  public String getIsdel() {
    return isdel;
  }

  public void setIsdel(String isdel) {
    this.isdel = isdel;
  }

  public Long getSignedname() {
    return signedname;
  }

  public void setSignedname(Long signedname) {
    this.signedname = signedname;
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

  public String getEqunumdesc() {
    return equnumdesc;
  }

  public void setEqunumdesc(String equnumdesc) {
    this.equnumdesc = equnumdesc;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public void setMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
  }

  public String getMaintab() {
    return maintab;
  }

  public void setMaintab(String maintab) {
    this.maintab = maintab;
  }

  public List<Udworkcontent> getUdworkcontentList() {
    return udworkcontentList;
  }

  public void setUdworkcontentList(List<Udworkcontent> udworkcontentList) {
    this.udworkcontentList = udworkcontentList;
  }

  public List<Udnormalservice> getUdnormalserviceList() {
    return udnormalserviceList;
  }

  public void setUdnormalserviceList(List<Udnormalservice> udnormalserviceList) {
    this.udnormalserviceList = udnormalserviceList;
  }

  public Long getUdworkreportid() {
    return udworkreportid;
  }

  public void setUdworkreportid(Long udworkreportid) {
    this.udworkreportid = udworkreportid;
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

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getService1() {
    return service1;
  }

  public void setService1(String service1) {
    this.service1 = service1;
  }

  public String getService2() {
    return service2;
  }

  public void setService2(String service2) {
    this.service2 = service2;
  }

  public String getService3() {
    return service3;
  }

  public void setService3(String service3) {
    this.service3 = service3;
  }

  public Date getWorkdate() {
    return workdate;
  }

  public void setWorkdate(Date workdate) {
    this.workdate = workdate;
  }

  public void setWorkdate(String workdate) {
    if(workdate!=null&&!workdate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.workdate = sdf.parse(workdate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Long getWorktime() {
    return worktime;
  }

  public void setWorktime(Long worktime) {
    this.worktime = worktime;
  }

  public String getPhase() {
    return phase;
  }

  public void setPhase(String phase) {
    this.phase = phase;
  }

  public String getMateriel() {
    return materiel;
  }

  public void setMateriel(String materiel) {
    this.materiel = materiel;
  }

  public String getPromanager() {
    return promanager;
  }

  public void setPromanager(String promanager) {
    this.promanager = promanager;
  }

  public String getEqunum() {
    return equnum;
  }

  public void setEqunum(String equnum) {
    this.equnum = equnum;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public Long getProductnum() {
    return productnum;
  }

  public void setProductnum(Long productnum) {
    this.productnum = productnum;
  }

  public String getOthers() {
    return others;
  }

  public void setOthers(String others) {
    this.others = others;
  }

  public String getPtw() {
    return ptw;
  }

  public void setPtw(String ptw) {
    this.ptw = ptw;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getDelegatenum() {
    return delegatenum;
  }

  public void setDelegatenum(String delegatenum) {
    this.delegatenum = delegatenum;
  }

  public String getDelegateman() {
    return delegateman;
  }

  public void setDelegateman(String delegateman) {
    this.delegateman = delegateman;
  }

  public String getNature() {
    return nature;
  }

  public void setNature(String nature) {
    this.nature = nature;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getDelegatedetail() {
    return delegatedetail;
  }

  public void setDelegatedetail(String delegatedetail) {
    this.delegatedetail = delegatedetail;
  }

  public String getService4() {
    return service4;
  }

  public void setService4(String service4) {
    this.service4 = service4;
  }

  public String getService5() {
    return service5;
  }

  public void setService5(String service5) {
    this.service5 = service5;
  }

  public String getService6() {
    return service6;
  }

  public void setService6(String service6) {
    this.service6 = service6;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getEdn() {
    return edn;
  }

  public void setEdn(String edn) {
    this.edn = edn;
  }

  public String getXuhao() {
    return xuhao;
  }

  public void setXuhao(String xuhao) {
    this.xuhao = xuhao;
  }

  public String getOrdernum() {
    return ordernum;
  }

  public void setOrdernum(String ordernum) {
    this.ordernum = ordernum;
  }

  public String getXian() {
    return xian;
  }

  public void setXian(String xian) {
    this.xian = xian;
  }

  public String getMaifang() {
    return maifang;
  }

  public void setMaifang(String maifang) {
    this.maifang = maifang;
  }

  public String getZhixing() {
    return zhixing;
  }

  public void setZhixing(String zhixing) {
    this.zhixing = zhixing;
  }

  public String getCcrp() {
    return ccrp;
  }

  public void setCcrp(String ccrp) {
    this.ccrp = ccrp;
  }

  public String getWorknum() {
    return worknum;
  }

  public void setWorknum(String worknum) {
    this.worknum = worknum;
  }

  public String getWorkcontent() {
    return workcontent;
  }

  public void setWorkcontent(String workcontent) {
    this.workcontent = workcontent;
  }

  public String getService7() {
    return service7;
  }

  public void setService7(String service7) {
    this.service7 = service7;
  }

  public String getService8() {
    return service8;
  }

  public void setService8(String service8) {
    this.service8 = service8;
  }

  public String getService9() {
    return service9;
  }

  public void setService9(String service9) {
    this.service9 = service9;
  }

  public String getYuanxuhao() {
    return yuanxuhao;
  }

  public void setYuanxuhao(String yuanxuhao) {
    this.yuanxuhao = yuanxuhao;
  }

  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }
}
