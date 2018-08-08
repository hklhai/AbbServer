package com.hxqh.abb.model.paperless;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fuyg on 2017-10-20.
 */
@Entity
@Table(name="UDOUTBOXCHECK")
@DynamicUpdate
public class Udoutboxcheck implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDOUTBOXCHECK_UDOUTBOXCHECKID_GENERATOR", allocationSize = 1 , sequenceName="UDOUTBOXCHECKIDSEQ")
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UDOUTBOXCHECK_UDOUTBOXCHECKID_GENERATOR")
  private Long udoutboxcheckid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String number;
  private String manager;
  private String creator;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date createdate;
  private String changeby;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date changedate;
  private String status;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date statusdate;
  private String project;
  private String result;
  private String errordescription;
  private String certificate;
  private String suggestion;
  private Long plant1;
  private Long plant2;
  private Long plant3;
  private Long plant4;
  private Long plant5;
  private Long plant6;
  private String projectname;
  private String transformername;
  private String customercompany;
  private String contractnum;
  private String productnum;
  private String contacts;
  private Long linenum;
  private Long productquantity;
  private String telephone;
  private Long perfect01;
  private Long perfect02;
  private Long perfect03;
  private Long perfect04;
  private Long perfect05;
  private Long error01;
  private Long error02;
  private Long error03;
  private Long error04;
  private Long error05;
  private String errordescription01;
  private String errordescription02;
  private String errordescription03;
  private String errordescription04;
  private String errordescription05;
  private String gongf;
  private String xufang;
  private String xuname;
  private String gongname;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  private Date xudate;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  private Date gongdate;
  private String pronum;
  private Long rowstamp;
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

  public String getMaintab() {
    return maintab;
  }

  public void setMaintab(String maintab) {
    this.maintab = maintab;
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

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public Long getUdoutboxcheckid() {
    return udoutboxcheckid;
  }

  public void setUdoutboxcheckid(Long udoutboxcheckid) {
    this.udoutboxcheckid = udoutboxcheckid;
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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
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

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getErrordescription() {
    return errordescription;
  }

  public void setErrordescription(String errordescription) {
    this.errordescription = errordescription;
  }

  public String getCertificate() {
    return certificate;
  }

  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }

  public String getSuggestion() {
    return suggestion;
  }

  public void setSuggestion(String suggestion) {
    this.suggestion = suggestion;
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

  public String getProjectname() {
    return projectname;
  }

  public void setProjectname(String projectname) {
    this.projectname = projectname;
  }

  public String getTransformername() {
    return transformername;
  }

  public void setTransformername(String transformername) {
    this.transformername = transformername;
  }

  public String getCustomercompany() {
    return customercompany;
  }

  public void setCustomercompany(String customercompany) {
    this.customercompany = customercompany;
  }

  public String getContractnum() {
    return contractnum;
  }

  public void setContractnum(String contractnum) {
    this.contractnum = contractnum;
  }

  public String getProductnum() {
    return productnum;
  }

  public void setProductnum(String productnum) {
    this.productnum = productnum;
  }

  public String getContacts() {
    return contacts;
  }

  public void setContacts(String contacts) {
    this.contacts = contacts;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
  }

  public Long getProductquantity() {
    return productquantity;
  }

  public void setProductquantity(Long productquantity) {
    this.productquantity = productquantity;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Long getPerfect01() {
    return perfect01;
  }

  public void setPerfect01(Long perfect01) {
    this.perfect01 = perfect01;
  }

  public Long getPerfect02() {
    return perfect02;
  }

  public void setPerfect02(Long perfect02) {
    this.perfect02 = perfect02;
  }

  public Long getPerfect03() {
    return perfect03;
  }

  public void setPerfect03(Long perfect03) {
    this.perfect03 = perfect03;
  }

  public Long getPerfect04() {
    return perfect04;
  }

  public void setPerfect04(Long perfect04) {
    this.perfect04 = perfect04;
  }

  public Long getPerfect05() {
    return perfect05;
  }

  public void setPerfect05(Long perfect05) {
    this.perfect05 = perfect05;
  }

  public Long getError01() {
    return error01;
  }

  public void setError01(Long error01) {
    this.error01 = error01;
  }

  public Long getError02() {
    return error02;
  }

  public void setError02(Long error02) {
    this.error02 = error02;
  }

  public Long getError03() {
    return error03;
  }

  public void setError03(Long error03) {
    this.error03 = error03;
  }

  public Long getError04() {
    return error04;
  }

  public void setError04(Long error04) {
    this.error04 = error04;
  }

  public Long getError05() {
    return error05;
  }

  public void setError05(Long error05) {
    this.error05 = error05;
  }

  public String getErrordescription01() {
    return errordescription01;
  }

  public void setErrordescription01(String errordescription01) {
    this.errordescription01 = errordescription01;
  }

  public String getErrordescription02() {
    return errordescription02;
  }

  public void setErrordescription02(String errordescription02) {
    this.errordescription02 = errordescription02;
  }

  public String getErrordescription03() {
    return errordescription03;
  }

  public void setErrordescription03(String errordescription03) {
    this.errordescription03 = errordescription03;
  }

  public String getErrordescription04() {
    return errordescription04;
  }

  public void setErrordescription04(String errordescription04) {
    this.errordescription04 = errordescription04;
  }

  public String getErrordescription05() {
    return errordescription05;
  }

  public void setErrordescription05(String errordescription05) {
    this.errordescription05 = errordescription05;
  }

  public String getGongf() {
    return gongf;
  }

  public void setGongf(String gongf) {
    this.gongf = gongf;
  }

  public String getXufang() {
    return xufang;
  }

  public void setXufang(String xufang) {
    this.xufang = xufang;
  }

  public String getXuname() {
    return xuname;
  }

  public void setXuname(String xuname) {
    this.xuname = xuname;
  }

  public String getGongname() {
    return gongname;
  }

  public void setGongname(String gongname) {
    this.gongname = gongname;
  }

  public Date getXudate() {
    return xudate;
  }

  public void setXudate(Date xudate) {
    this.xudate = xudate;
  }

  public Date getGongdate() {
    return gongdate;
  }

  public void setGongdate(Date gongdate) {
    this.gongdate = gongdate;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getPromanager() {
    return promanager;
  }

  public void setPromanager(String promanager) {
    this.promanager = promanager;
  }
}
