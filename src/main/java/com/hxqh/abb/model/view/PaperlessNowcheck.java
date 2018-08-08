package com.hxqh.abb.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PAPERLESS_UDNOWCHECK")
public class PaperlessNowcheck implements Serializable {
  private static final long serialVersionUID = 1L;

  private String number;
  private String description;
  private String pronum;
  private String pronumdesc;
  private Long linenum;
  private String linenumdesc;
  private String projectmanager;
  private String projectmanagername;
  private String creator;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date createdate;
  private String changeby;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date changedate;
  private String status;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date statusdate;
  private String siteid;
  private String orgid;
  private String transfername;
  private String model;
  private String khcontacts;
  private String khphone;
  private String dj01;
  private String dj02;
  private String dj03;
  private String jd;
  private String pg01;
  private String pg02;
  private String pg03;
  private String xt;
  private String mplj01;
  private String mplj02;
  private String mplj03;
  private String mplj04;
  private String pt01;
  private String jy01;
  private String jy02;
  private String pt02;
  private String xm01;
  private String xm02;
  private String qt;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date checkdate;
  private String engineer;
  private String kz01;
  private String xtcd;
  private String dt01;
  private String ny;
  private String dt02;
  private String tx;
  private String bh;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date checkdate2;
  private String engineer2;
  private String sdq01;
  private String sdq06;
  private String sdq02;
  private String sdq07;
  private String sdq03;
  private String sdq08;
  private String sdq04;
  private String sdq09;
  private String sdq05;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date checkdate3;
  private String engineer3;
  private String sdh01;
  private String sdh02;
  private String sdh03;
  private String sdh04;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date checkdate4;
  private String engineer4;
  private String remark;
  @Id
  private Long udnowcheckid;

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

  public String getTransfername() {
    return transfername;
  }

  public void setTransfername(String transfername) {
    this.transfername = transfername;
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

  public String getKhphone() {
    return khphone;
  }

  public void setKhphone(String khphone) {
    this.khphone = khphone;
  }

  public String getDj01() {
    return dj01;
  }

  public void setDj01(String dj01) {
    this.dj01 = dj01;
  }

  public String getDj02() {
    return dj02;
  }

  public void setDj02(String dj02) {
    this.dj02 = dj02;
  }

  public String getDj03() {
    return dj03;
  }

  public void setDj03(String dj03) {
    this.dj03 = dj03;
  }

  public String getJd() {
    return jd;
  }

  public void setJd(String jd) {
    this.jd = jd;
  }

  public String getPg01() {
    return pg01;
  }

  public void setPg01(String pg01) {
    this.pg01 = pg01;
  }

  public String getPg02() {
    return pg02;
  }

  public void setPg02(String pg02) {
    this.pg02 = pg02;
  }

  public String getPg03() {
    return pg03;
  }

  public void setPg03(String pg03) {
    this.pg03 = pg03;
  }

  public String getXt() {
    return xt;
  }

  public void setXt(String xt) {
    this.xt = xt;
  }

  public String getMplj01() {
    return mplj01;
  }

  public void setMplj01(String mplj01) {
    this.mplj01 = mplj01;
  }

  public String getMplj02() {
    return mplj02;
  }

  public void setMplj02(String mplj02) {
    this.mplj02 = mplj02;
  }

  public String getMplj03() {
    return mplj03;
  }

  public void setMplj03(String mplj03) {
    this.mplj03 = mplj03;
  }

  public String getMplj04() {
    return mplj04;
  }

  public void setMplj04(String mplj04) {
    this.mplj04 = mplj04;
  }

  public String getPt01() {
    return pt01;
  }

  public void setPt01(String pt01) {
    this.pt01 = pt01;
  }

  public String getJy01() {
    return jy01;
  }

  public void setJy01(String jy01) {
    this.jy01 = jy01;
  }

  public String getJy02() {
    return jy02;
  }

  public void setJy02(String jy02) {
    this.jy02 = jy02;
  }

  public String getPt02() {
    return pt02;
  }

  public void setPt02(String pt02) {
    this.pt02 = pt02;
  }

  public String getXm01() {
    return xm01;
  }

  public void setXm01(String xm01) {
    this.xm01 = xm01;
  }

  public String getXm02() {
    return xm02;
  }

  public void setXm02(String xm02) {
    this.xm02 = xm02;
  }

  public String getQt() {
    return qt;
  }

  public void setQt(String qt) {
    this.qt = qt;
  }

  public Date getCheckdate() {
    return checkdate;
  }

  public void setCheckdate(Date checkdate) {
    this.checkdate = checkdate;
  }

  public String getEngineer() {
    return engineer;
  }

  public void setEngineer(String engineer) {
    this.engineer = engineer;
  }

  public String getKz01() {
    return kz01;
  }

  public void setKz01(String kz01) {
    this.kz01 = kz01;
  }

  public String getXtcd() {
    return xtcd;
  }

  public void setXtcd(String xtcd) {
    this.xtcd = xtcd;
  }

  public String getDt01() {
    return dt01;
  }

  public void setDt01(String dt01) {
    this.dt01 = dt01;
  }

  public String getNy() {
    return ny;
  }

  public void setNy(String ny) {
    this.ny = ny;
  }

  public String getDt02() {
    return dt02;
  }

  public void setDt02(String dt02) {
    this.dt02 = dt02;
  }

  public String getTx() {
    return tx;
  }

  public void setTx(String tx) {
    this.tx = tx;
  }

  public String getBh() {
    return bh;
  }

  public void setBh(String bh) {
    this.bh = bh;
  }

  public Date getCheckdate2() {
    return checkdate2;
  }

  public void setCheckdate2(Date checkdate2) {
    this.checkdate2 = checkdate2;
  }

  public String getEngineer2() {
    return engineer2;
  }

  public void setEngineer2(String engineer2) {
    this.engineer2 = engineer2;
  }

  public String getSdq01() {
    return sdq01;
  }

  public void setSdq01(String sdq01) {
    this.sdq01 = sdq01;
  }

  public String getSdq06() {
    return sdq06;
  }

  public void setSdq06(String sdq06) {
    this.sdq06 = sdq06;
  }

  public String getSdq02() {
    return sdq02;
  }

  public void setSdq02(String sdq02) {
    this.sdq02 = sdq02;
  }

  public String getSdq07() {
    return sdq07;
  }

  public void setSdq07(String sdq07) {
    this.sdq07 = sdq07;
  }

  public String getSdq03() {
    return sdq03;
  }

  public void setSdq03(String sdq03) {
    this.sdq03 = sdq03;
  }

  public String getSdq08() {
    return sdq08;
  }

  public void setSdq08(String sdq08) {
    this.sdq08 = sdq08;
  }

  public String getSdq04() {
    return sdq04;
  }

  public void setSdq04(String sdq04) {
    this.sdq04 = sdq04;
  }

  public String getSdq09() {
    return sdq09;
  }

  public void setSdq09(String sdq09) {
    this.sdq09 = sdq09;
  }

  public String getSdq05() {
    return sdq05;
  }

  public void setSdq05(String sdq05) {
    this.sdq05 = sdq05;
  }

  public Date getCheckdate3() {
    return checkdate3;
  }

  public void setCheckdate3(Date checkdate3) {
    this.checkdate3 = checkdate3;
  }

  public String getEngineer3() {
    return engineer3;
  }

  public void setEngineer3(String engineer3) {
    this.engineer3 = engineer3;
  }

  public String getSdh01() {
    return sdh01;
  }

  public void setSdh01(String sdh01) {
    this.sdh01 = sdh01;
  }

  public String getSdh02() {
    return sdh02;
  }

  public void setSdh02(String sdh02) {
    this.sdh02 = sdh02;
  }

  public String getSdh03() {
    return sdh03;
  }

  public void setSdh03(String sdh03) {
    this.sdh03 = sdh03;
  }

  public String getSdh04() {
    return sdh04;
  }

  public void setSdh04(String sdh04) {
    this.sdh04 = sdh04;
  }

  public Date getCheckdate4() {
    return checkdate4;
  }

  public void setCheckdate4(Date checkdate4) {
    this.checkdate4 = checkdate4;
  }

  public String getEngineer4() {
    return engineer4;
  }

  public void setEngineer4(String engineer4) {
    this.engineer4 = engineer4;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Long getUdnowcheckid() {
    return udnowcheckid;
  }

  public void setUdnowcheckid(Long udnowcheckid) {
    this.udnowcheckid = udnowcheckid;
  }
}
