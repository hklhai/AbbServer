package com.hxqh.abb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_REPORT")
public class TbReport implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "TB_REPORT_REPORTID_GENERATOR", allocationSize = 1, sequenceName = "TB_REPORTSEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_REPORT_REPORTID_GENERATOR")
  private Long reportid;
  private String appname;
  private Long reportnum;
  private String basetablename;
  private String description;
  private String reportfolder;
  private String reportname;
  private Long isparameters;
  private String parameterspage;
  private Long ordernum;
  private String remark;

  public Long getReportid() {
    return reportid;
  }

  public void setReportid(Long reportid) {
    this.reportid = reportid;
  }

  public String getAppname() {
    return appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }

  public Long getReportnum() {
    return reportnum;
  }

  public void setReportnum(Long reportnum) {
    this.reportnum = reportnum;
  }

  public String getBasetablename() {
    return basetablename;
  }

  public void setBasetablename(String basetablename) {
    this.basetablename = basetablename;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getReportfolder() {
    return reportfolder;
  }

  public void setReportfolder(String reportfolder) {
    this.reportfolder = reportfolder;
  }

  public String getReportname() {
    return reportname;
  }

  public void setReportname(String reportname) {
    this.reportname = reportname;
  }

  public Long getIsparameters() {
    return isparameters;
  }

  public void setIsparameters(Long isparameters) {
    this.isparameters = isparameters;
  }

  public String getParameterspage() {
    return parameterspage;
  }

  public void setParameterspage(String parameterspage) {
    this.parameterspage = parameterspage;
  }

  public Long getOrdernum() {
    return ordernum;
  }

  public void setOrdernum(Long ordernum) {
    this.ordernum = ordernum;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
