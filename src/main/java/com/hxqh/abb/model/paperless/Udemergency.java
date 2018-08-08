package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDEMERGENCY")
public class Udemergency implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDEMERGENCY_UDEMERGENCYID_GENERATOR", allocationSize = 1 , sequenceName="UDEMERGENCYIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDEMERGENCY_UDEMERGENCYID_GENERATOR")
  private Long udemergencyid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String scnum;
  private String materials;
  private Double quantity;
  private Long rowstamp;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdemergencyid() {
    return udemergencyid;
  }

  public void setUdemergencyid(Long udemergencyid) {
    this.udemergencyid = udemergencyid;
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

  public String getMaterials() {
    return materials;
  }

  public void setMaterials(String materials) {
    this.materials = materials;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
