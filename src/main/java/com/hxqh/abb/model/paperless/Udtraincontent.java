package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDTRAINCONTENT")
public class Udtraincontent implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDTRAINCONTENT_UDTRAINCONTENTID_GENERATOR", allocationSize = 1 , sequenceName="UDTRAINCONTENTIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDTRAINCONTENT_UDTRAINCONTENTID_GENERATOR")
  private Long udtraincontentid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String scnum;
  private String content;
  private String dutyperson;
  private String time;
  private Long rowstamp;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdtraincontentid() {
    return udtraincontentid;
  }

  public void setUdtraincontentid(Long udtraincontentid) {
    this.udtraincontentid = udtraincontentid;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDutyperson() {
    return dutyperson;
  }

  public void setDutyperson(String dutyperson) {
    this.dutyperson = dutyperson;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
