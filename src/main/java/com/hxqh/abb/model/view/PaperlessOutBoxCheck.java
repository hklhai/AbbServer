package com.hxqh.abb.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PAPERLESS_UDOUTBOXCHECK")
public class PaperlessOutBoxCheck {
  private String number;
  private String description;
  private String pronum;
  private String pronumdesc;
  private Long linenum;
  private String linenumdesc;
  private String projectmanager;
  private String projectmanagername;
  private String servicedep;
  private String creator;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date createdate;
  private String changeby;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date changedate;
  private String status;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date statusdate;
  private String orgid;
  private String siteid;
  private String transformername;
  private String khcompany;
  private String model;
  private String khcontacts;
  private Double quantity;
  private String khphone;
  private Long perfect01;
  private Long error01;
  private String errordescription01;
  private Long perfect02;
  private Long error02;
  private String errordescription02;
  private Long perfect03;
  private Long error03;
  private String errordescription03;
  private Long perfect04;
  private Long error04;
  private String errordescription04;
  private Long perfect05;
  private Long error05;
  private String errordescription05;
  private String result;
  private String errordescription;
  private String suggestion;
  private String certificate;
  private String xufang;
  private String xuname;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date xudate;
  private String gongf;
  private String gongname;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date gongdate;
  @Id
  private Long udoutboxcheckid;

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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public String getPronumdesc() {
    return pronumdesc;
  }

  public void setPronumdesc(String pronumdesc) {
    this.pronumdesc = pronumdesc;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
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

  public String getTransformername() {
    return transformername;
  }

  public void setTransformername(String transformername) {
    this.transformername = transformername;
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

  public Long getPerfect01() {
    return perfect01;
  }

  public void setPerfect01(Long perfect01) {
    this.perfect01 = perfect01;
  }

  public Long getError01() {
    return error01;
  }

  public void setError01(Long error01) {
    this.error01 = error01;
  }

  public String getErrordescription01() {
    return errordescription01;
  }

  public void setErrordescription01(String errordescription01) {
    this.errordescription01 = errordescription01;
  }

  public Long getPerfect02() {
    return perfect02;
  }

  public void setPerfect02(Long perfect02) {
    this.perfect02 = perfect02;
  }

  public Long getError02() {
    return error02;
  }

  public void setError02(Long error02) {
    this.error02 = error02;
  }

  public String getErrordescription02() {
    return errordescription02;
  }

  public void setErrordescription02(String errordescription02) {
    this.errordescription02 = errordescription02;
  }

  public Long getPerfect03() {
    return perfect03;
  }

  public void setPerfect03(Long perfect03) {
    this.perfect03 = perfect03;
  }

  public Long getError03() {
    return error03;
  }

  public void setError03(Long error03) {
    this.error03 = error03;
  }

  public String getErrordescription03() {
    return errordescription03;
  }

  public void setErrordescription03(String errordescription03) {
    this.errordescription03 = errordescription03;
  }

  public Long getPerfect04() {
    return perfect04;
  }

  public void setPerfect04(Long perfect04) {
    this.perfect04 = perfect04;
  }

  public Long getError04() {
    return error04;
  }

  public void setError04(Long error04) {
    this.error04 = error04;
  }

  public String getErrordescription04() {
    return errordescription04;
  }

  public void setErrordescription04(String errordescription04) {
    this.errordescription04 = errordescription04;
  }

  public Long getPerfect05() {
    return perfect05;
  }

  public void setPerfect05(Long perfect05) {
    this.perfect05 = perfect05;
  }

  public Long getError05() {
    return error05;
  }

  public void setError05(Long error05) {
    this.error05 = error05;
  }

  public String getErrordescription05() {
    return errordescription05;
  }

  public void setErrordescription05(String errordescription05) {
    this.errordescription05 = errordescription05;
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

  public String getSuggestion() {
    return suggestion;
  }

  public void setSuggestion(String suggestion) {
    this.suggestion = suggestion;
  }

  public String getCertificate() {
    return certificate;
  }

  public void setCertificate(String certificate) {
    this.certificate = certificate;
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

  public Date getXudate() {
    return xudate;
  }

  public void setXudate(Date xudate) {
    this.xudate = xudate;
  }

  public String getGongf() {
    return gongf;
  }

  public void setGongf(String gongf) {
    this.gongf = gongf;
  }

  public String getGongname() {
    return gongname;
  }

  public void setGongname(String gongname) {
    this.gongname = gongname;
  }

  public Date getGongdate() {
    return gongdate;
  }

  public void setGongdate(Date gongdate) {
    this.gongdate = gongdate;
  }

  public Long getUdoutboxcheckid() {
    return udoutboxcheckid;
  }

  public void setUdoutboxcheckid(Long udoutboxcheckid) {
    this.udoutboxcheckid = udoutboxcheckid;
  }
}
