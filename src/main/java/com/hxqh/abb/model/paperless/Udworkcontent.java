package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fuyg on 2017-10-27.
 */
@Entity
@Table(name="UDWORKCONTENT")
@DynamicUpdate
public class Udworkcontent implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDWORKCONTENT_UDWORKCONTENTID_GENERATOR", allocationSize = 1 , sequenceName="UDWORKCONTENTIDSEQ")
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UDWORKCONTENT_UDWORKCONTENTID_GENERATOR")
  private Long udworkcontentid;
  private String description;
  private Long hasld;
  private String siteid;
  private String orgid;
  private String service1;
  private String service2;
  private String service3;
  private String phase;
  private Date workdate;
  private Long worktime;
  private String materiel;
  private String xuhao;
  private String ordernum;
  private String xian;
  private String ptw;
  private String edn;
  private String delegatenum;
  private String delegatedetail;
  private String nature;
  private String delegateman;
  private String company;
  private String udworkreportid;
  private Long rowstamp;
  private String udworkreportnum;

  @Transient
  private String isdel;

  public String getIsdel() {
    return isdel;
  }

  public void setIsdel(String isdel) {
    this.isdel = isdel;
  }

  public String getUdworkreportnum() {
    return udworkreportnum;
  }

  public void setUdworkreportnum(String udworkreportnum) {
    this.udworkreportnum = udworkreportnum;
  }

  public Long getUdworkcontentid() {
    return udworkcontentid;
  }

  public void setUdworkcontentid(Long udworkcontentid) {
    this.udworkcontentid = udworkcontentid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
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

  public String getPhase() {
    return phase;
  }

  public void setPhase(String phase) {
    this.phase = phase;
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

  public String getMateriel() {
    return materiel;
  }

  public void setMateriel(String materiel) {
    this.materiel = materiel;
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

  public String getPtw() {
    return ptw;
  }

  public void setPtw(String ptw) {
    this.ptw = ptw;
  }

  public String getEdn() {
    return edn;
  }

  public void setEdn(String edn) {
    this.edn = edn;
  }

  public String getDelegatenum() {
    return delegatenum;
  }

  public void setDelegatenum(String delegatenum) {
    this.delegatenum = delegatenum;
  }

  public String getDelegatedetail() {
    return delegatedetail;
  }

  public void setDelegatedetail(String delegatedetail) {
    this.delegatedetail = delegatedetail;
  }

  public String getNature() {
    return nature;
  }

  public void setNature(String nature) {
    this.nature = nature;
  }

  public String getDelegateman() {
    return delegateman;
  }

  public void setDelegateman(String delegateman) {
    this.delegateman = delegateman;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getUdworkreportid() {
    return udworkreportid;
  }

  public void setUdworkreportid(String udworkreportid) {
    this.udworkreportid = udworkreportid;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
