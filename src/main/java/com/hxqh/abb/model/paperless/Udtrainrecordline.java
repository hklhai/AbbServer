package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="UDTRAINRECORDLINE")
@DynamicUpdate
public class Udtrainrecordline implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name="UDTRAINRECORDLINE_UDTRAINRECORDLINEID_GENERATOR", allocationSize = 1 , sequenceName="UDTRAINRECORDLINEIDSEQ")
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UDTRAINRECORDLINE_UDTRAINRECORDLINEID_GENERATOR")
  private Long udtrainrecordlineid;
  private String description;
  private String siteid;
  private String orgid;
  private String personid;
  private String name;
  private String telephone;
  private String department;
  private String email;
  private Long hasld;
  private Long rowstamp;
  private Long udtrainrecordid;
  private String number;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdtrainrecordlineid() {
    return udtrainrecordlineid;
  }

  public void setUdtrainrecordlineid(Long udtrainrecordlineid) {
    this.udtrainrecordlineid = udtrainrecordlineid;
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

  public String getPersonid() {
    return personid;
  }

  public void setPersonid(String personid) {
    this.personid = personid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Long getUdtrainrecordid() {
    return udtrainrecordid;
  }

  public void setUdtrainrecordid(Long udtrainrecordid) {
    this.udtrainrecordid = udtrainrecordid;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
