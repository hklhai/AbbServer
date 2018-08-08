package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fuyg on 2017-09-26.
 */
@Entity
@Table(name="AREAANDSERVICE")
@DynamicUpdate
public class Areaandservice implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="AREAANDSERVICE_AREAANDSERVICEID_GENERATOR", allocationSize = 1 , sequenceName="AREAANDSERVICEIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREAANDSERVICE_AREAANDSERVICEID_GENERATOR")
  private Long areaandserviceid;
  private String description;
  private String personid;
  private Long hasld;
  private String area;
  private String province;
  private Long areamanager;
  private Long servicemanager;
  private String area1;
  private Long rowstamp;

  @Transient
  private Long number;
  @Transient
  private String deletes;
  @Transient
  private String maintab;

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public String getDeletes() {
    return deletes;
  }

  public void setDeletes(String deletes) {
    this.deletes = deletes;
  }

  public String getMaintab() {
    return maintab;
  }

  public void setMaintab(String maintab) {
    this.maintab = maintab;
  }

  public Long getAreaandserviceid() {
    return areaandserviceid;
  }

  public void setAreaandserviceid(Long areaandserviceid) {
    this.areaandserviceid = areaandserviceid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPersonid() {
    return personid;
  }

  public void setPersonid(String personid) {
    this.personid = personid;
  }

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Long getAreamanager() {
    return areamanager;
  }

  public void setAreamanager(Long areamanager) {
    this.areamanager = areamanager;
  }

  public Long getServicemanager() {
    return servicemanager;
  }

  public void setServicemanager(Long servicemanager) {
    this.servicemanager = servicemanager;
  }

  public String getArea1() {
    return area1;
  }

  public void setArea1(String area1) {
    this.area1 = area1;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
