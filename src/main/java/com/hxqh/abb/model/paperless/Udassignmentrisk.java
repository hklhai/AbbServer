package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDASSIGNMENTRISK")
public class Udassignmentrisk implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDASSIGNMENTRISK_UDASSIGNMENTRISKID_GENERATOR", allocationSize = 1 , sequenceName="UDASSIGNMENTRISKIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDASSIGNMENTRISK_UDASSIGNMENTRISKID_GENERATOR")
  private Long udassignmentriskid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String assignmentrisk;
  private String risk;
  private String measures;
  private String degree;
  private String probability;
  private String level;
  private Long rowstamp;
  private String scnum;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdassignmentriskid() {
    return udassignmentriskid;
  }

  public void setUdassignmentriskid(Long udassignmentriskid) {
    this.udassignmentriskid = udassignmentriskid;
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

  public String getAssignmentrisk() {
    return assignmentrisk;
  }

  public void setAssignmentrisk(String assignmentrisk) {
    this.assignmentrisk = assignmentrisk;
  }

  public String getRisk() {
    return risk;
  }

  public void setRisk(String risk) {
    this.risk = risk;
  }

  public String getMeasures() {
    return measures;
  }

  public void setMeasures(String measures) {
    this.measures = measures;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getProbability() {
    return probability;
  }

  public void setProbability(String probability) {
    this.probability = probability;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getScnum() {
    return scnum;
  }

  public void setScnum(String scnum) {
    this.scnum = scnum;
  }
}
