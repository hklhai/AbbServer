package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDCHEMICALS")
public class Udchemicals implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDCHEMICALS_UDCHEMICALSID_GENERATOR", allocationSize = 1 , sequenceName="UDCHEMICALSIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDCHEMICALS_UDCHEMICALSID_GENERATOR")
  private Long udchemicalsid;
  private String description;
  private String siteid;
  private String orgid;
  private String scnum;
  private String name;
  private Long quantity;
  private String risk;
  private String measures;
  private Long hasld;
  private Long rowstamp;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdchemicalsid() {
    return udchemicalsid;
  }

  public void setUdchemicalsid(Long udchemicalsid) {
    this.udchemicalsid = udchemicalsid;
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

  public String getScnum() {
    return scnum;
  }

  public void setScnum(String scnum) {
    this.scnum = scnum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
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

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
