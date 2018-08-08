package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDSAFEMEETING")
public class Udsafemeeting implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDSAFEMEETING_UDSAFEMEETINGID_GENERATOR", allocationSize = 1 , sequenceName="UDSAFEMEETINGIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDSAFEMEETING_UDSAFEMEETINGID_GENERATOR")
  private Long udsafemeetingid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String scnum;
  private String meeting;
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

  public Long getUdsafemeetingid() {
    return udsafemeetingid;
  }

  public void setUdsafemeetingid(Long udsafemeetingid) {
    this.udsafemeetingid = udsafemeetingid;
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

  public String getMeeting() {
    return meeting;
  }

  public void setMeeting(String meeting) {
    this.meeting = meeting;
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
