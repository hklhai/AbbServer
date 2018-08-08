package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDQUALIFICATION")
public class Udqualification implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDQUALIFICATION_UDQUALIFICATIONID_GENERATOR", allocationSize = 1 , sequenceName="UDQUALIFICATIONIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDQUALIFICATION_UDQUALIFICATIONID_GENERATOR")
  private Long udqualificationid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String scnum;
  private String position;
  private String qualification;
  private String conform;
  private Long rowstamp;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdqualificationid() {
    return udqualificationid;
  }

  public void setUdqualificationid(Long udqualificationid) {
    this.udqualificationid = udqualificationid;
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

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public String getConform() {
    return conform;
  }

  public void setConform(String conform) {
    this.conform = conform;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
