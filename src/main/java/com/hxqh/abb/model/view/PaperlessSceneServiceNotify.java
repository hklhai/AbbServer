package com.hxqh.abb.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PAPERLESS_UDSCENESERVICENOTIFY")
public class PaperlessSceneServiceNotify implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private Long udid;
  private String number;
  private String description;
  private Long hasld;
  private String pronum;
  private String pronumdesc;
  private Long linenum;
  private String linenumdesc;
  private String projectmanager;
  private String projectmanagername;
  private String creator;
  private String creatorname;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date createdate;
  private String changeby;
  private String changebyname;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date changedate;
  private String stauts;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date stautsdate;
  private String siteid;
  private String orgid;
  private Long azjc01;
  private Long azjc02;
  private Long azjc03;
  private Long azjc04;
  private Long azjc05;
  private Long azjc06;
  private Long azjc07;
  private Long azjc08;
  private Long azjc09;
  private Long azjc10;
  private Long azjc11;
  private Long tsjc01;
  private Long tsjc02;
  private Long tsjc03;
  private Long tsjc04;
  private Long tsjc05;
  private Long tsjc06;
  private Long tyjc01;
  private Long xcaq01;
  private Long xcaq02;
  private Long xcaq03;
  private Long xcaq04;
  private Long xcaq05;
  private Long xcaq06;
  private Long xcaq07;
  private Long xcaq08;
  private Long xcaq09;
  private Long xcaq10;
  private Long xcaq11;
  private Long xcaq12;
  private Long xcaq13;
  private Long xcaq14;
  private Long xcaq15;
  private Long xcaq16;
  private Long xcaq17;
  private Long xcaq18;
  private Long xcaq19;
  private Long xcaq20;
  private Long xcaq21;
  private Long xcaq22;
  private Long rowstamp;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date installdate;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date debugdate;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date putdate;
  private String sitesupervisor;
  private String telephone;
  private String address;

  public String getProjectmanagername() {
    return projectmanagername;
  }

  public void setProjectmanagername(String projectmanagername) {
    this.projectmanagername = projectmanagername;
  }

  public String getChangebyname() {
    return changebyname;
  }

  public void setChangebyname(String changebyname) {
    this.changebyname = changebyname;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public Long getUdid() {
    return udid;
  }

  public void setUdid(Long udid) {
    this.udid = udid;
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

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getCreatorname() {
    return creatorname;
  }

  public void setCreatorname(String creatorname) {
    this.creatorname = creatorname;
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

  public String getStauts() {
    return stauts;
  }

  public void setStauts(String stauts) {
    this.stauts = stauts;
  }

  public Date getStautsdate() {
    return stautsdate;
  }

  public void setStautsdate(Date stautsdate) {
    this.stautsdate = stautsdate;
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

  public Long getAzjc01() {
    return azjc01;
  }

  public void setAzjc01(Long azjc01) {
    this.azjc01 = azjc01;
  }

  public Long getAzjc02() {
    return azjc02;
  }

  public void setAzjc02(Long azjc02) {
    this.azjc02 = azjc02;
  }

  public Long getAzjc03() {
    return azjc03;
  }

  public void setAzjc03(Long azjc03) {
    this.azjc03 = azjc03;
  }

  public Long getAzjc04() {
    return azjc04;
  }

  public void setAzjc04(Long azjc04) {
    this.azjc04 = azjc04;
  }

  public Long getAzjc05() {
    return azjc05;
  }

  public void setAzjc05(Long azjc05) {
    this.azjc05 = azjc05;
  }

  public Long getAzjc06() {
    return azjc06;
  }

  public void setAzjc06(Long azjc06) {
    this.azjc06 = azjc06;
  }

  public Long getAzjc07() {
    return azjc07;
  }

  public void setAzjc07(Long azjc07) {
    this.azjc07 = azjc07;
  }

  public Long getAzjc08() {
    return azjc08;
  }

  public void setAzjc08(Long azjc08) {
    this.azjc08 = azjc08;
  }

  public Long getAzjc09() {
    return azjc09;
  }

  public void setAzjc09(Long azjc09) {
    this.azjc09 = azjc09;
  }

  public Long getAzjc10() {
    return azjc10;
  }

  public void setAzjc10(Long azjc10) {
    this.azjc10 = azjc10;
  }

  public Long getAzjc11() {
    return azjc11;
  }

  public void setAzjc11(Long azjc11) {
    this.azjc11 = azjc11;
  }

  public Long getTsjc01() {
    return tsjc01;
  }

  public void setTsjc01(Long tsjc01) {
    this.tsjc01 = tsjc01;
  }

  public Long getTsjc02() {
    return tsjc02;
  }

  public void setTsjc02(Long tsjc02) {
    this.tsjc02 = tsjc02;
  }

  public Long getTsjc03() {
    return tsjc03;
  }

  public void setTsjc03(Long tsjc03) {
    this.tsjc03 = tsjc03;
  }

  public Long getTsjc04() {
    return tsjc04;
  }

  public void setTsjc04(Long tsjc04) {
    this.tsjc04 = tsjc04;
  }

  public Long getTsjc05() {
    return tsjc05;
  }

  public void setTsjc05(Long tsjc05) {
    this.tsjc05 = tsjc05;
  }

  public Long getTsjc06() {
    return tsjc06;
  }

  public void setTsjc06(Long tsjc06) {
    this.tsjc06 = tsjc06;
  }

  public Long getTyjc01() {
    return tyjc01;
  }

  public void setTyjc01(Long tyjc01) {
    this.tyjc01 = tyjc01;
  }

  public Long getXcaq01() {
    return xcaq01;
  }

  public void setXcaq01(Long xcaq01) {
    this.xcaq01 = xcaq01;
  }

  public Long getXcaq02() {
    return xcaq02;
  }

  public void setXcaq02(Long xcaq02) {
    this.xcaq02 = xcaq02;
  }

  public Long getXcaq03() {
    return xcaq03;
  }

  public void setXcaq03(Long xcaq03) {
    this.xcaq03 = xcaq03;
  }

  public Long getXcaq04() {
    return xcaq04;
  }

  public void setXcaq04(Long xcaq04) {
    this.xcaq04 = xcaq04;
  }

  public Long getXcaq05() {
    return xcaq05;
  }

  public void setXcaq05(Long xcaq05) {
    this.xcaq05 = xcaq05;
  }

  public Long getXcaq06() {
    return xcaq06;
  }

  public void setXcaq06(Long xcaq06) {
    this.xcaq06 = xcaq06;
  }

  public Long getXcaq07() {
    return xcaq07;
  }

  public void setXcaq07(Long xcaq07) {
    this.xcaq07 = xcaq07;
  }

  public Long getXcaq08() {
    return xcaq08;
  }

  public void setXcaq08(Long xcaq08) {
    this.xcaq08 = xcaq08;
  }

  public Long getXcaq09() {
    return xcaq09;
  }

  public void setXcaq09(Long xcaq09) {
    this.xcaq09 = xcaq09;
  }

  public Long getXcaq10() {
    return xcaq10;
  }

  public void setXcaq10(Long xcaq10) {
    this.xcaq10 = xcaq10;
  }

  public Long getXcaq11() {
    return xcaq11;
  }

  public void setXcaq11(Long xcaq11) {
    this.xcaq11 = xcaq11;
  }

  public Long getXcaq12() {
    return xcaq12;
  }

  public void setXcaq12(Long xcaq12) {
    this.xcaq12 = xcaq12;
  }

  public Long getXcaq13() {
    return xcaq13;
  }

  public void setXcaq13(Long xcaq13) {
    this.xcaq13 = xcaq13;
  }

  public Long getXcaq14() {
    return xcaq14;
  }

  public void setXcaq14(Long xcaq14) {
    this.xcaq14 = xcaq14;
  }

  public Long getXcaq15() {
    return xcaq15;
  }

  public void setXcaq15(Long xcaq15) {
    this.xcaq15 = xcaq15;
  }

  public Long getXcaq16() {
    return xcaq16;
  }

  public void setXcaq16(Long xcaq16) {
    this.xcaq16 = xcaq16;
  }

  public Long getXcaq17() {
    return xcaq17;
  }

  public void setXcaq17(Long xcaq17) {
    this.xcaq17 = xcaq17;
  }

  public Long getXcaq18() {
    return xcaq18;
  }

  public void setXcaq18(Long xcaq18) {
    this.xcaq18 = xcaq18;
  }

  public Long getXcaq19() {
    return xcaq19;
  }

  public void setXcaq19(Long xcaq19) {
    this.xcaq19 = xcaq19;
  }

  public Long getXcaq20() {
    return xcaq20;
  }

  public void setXcaq20(Long xcaq20) {
    this.xcaq20 = xcaq20;
  }

  public Long getXcaq21() {
    return xcaq21;
  }

  public void setXcaq21(Long xcaq21) {
    this.xcaq21 = xcaq21;
  }

  public Long getXcaq22() {
    return xcaq22;
  }

  public void setXcaq22(Long xcaq22) {
    this.xcaq22 = xcaq22;
  }

  public Date getInstalldate() {
    return installdate;
  }

  public void setInstalldate(Date installdate) {
    this.installdate = installdate;
  }

  public Date getDebugdate() {
    return debugdate;
  }

  public void setDebugdate(Date debugdate) {
    this.debugdate = debugdate;
  }

  public Date getPutdate() {
    return putdate;
  }

  public void setPutdate(Date putdate) {
    this.putdate = putdate;
  }

  public String getSitesupervisor() {
    return sitesupervisor;
  }

  public void setSitesupervisor(String sitesupervisor) {
    this.sitesupervisor = sitesupervisor;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
