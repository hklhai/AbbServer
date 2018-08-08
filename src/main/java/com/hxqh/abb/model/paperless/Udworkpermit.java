package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDWORKPERMIT")
public class Udworkpermit implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDWORKPERMIT_UDWORKPERMITID_GENERATOR", allocationSize = 1 , sequenceName="UDWORKPERMITIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDWORKPERMIT_UDWORKPERMITID_GENERATOR")
  private Long udworkpermitid;
  private String description;
  private String time;
  private String action;
  private String dutyperson;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String scnum;
  private Long rowstamp;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdworkpermitid() {
    return udworkpermitid;
  }

  public void setUdworkpermitid(Long udworkpermitid) {
    this.udworkpermitid = udworkpermitid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getDutyperson() {
    return dutyperson;
  }

  public void setDutyperson(String dutyperson) {
    this.dutyperson = dutyperson;
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

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
