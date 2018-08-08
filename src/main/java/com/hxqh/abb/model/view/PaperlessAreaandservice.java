package com.hxqh.abb.model.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2017-11-01.
 */
@Entity
@Table(name = "PAPERLESS_AREAANDSERVICE")
public class PaperlessAreaandservice implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long number;
  private String personid;
  private String description;
  private String area;
  private Long areamanager;
  private String area1;
  private String province;
  private Long servicemanager;
  @Id
  private Long areaandserviceid;

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public String getPersonid() {
    return personid;
  }

  public void setPersonid(String personid) {
    this.personid = personid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public Long getAreamanager() {
    return areamanager;
  }

  public void setAreamanager(Long areamanager) {
    this.areamanager = areamanager;
  }

  public String getArea1() {
    return area1;
  }

  public void setArea1(String area1) {
    this.area1 = area1;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Long getServicemanager() {
    return servicemanager;
  }

  public void setServicemanager(Long servicemanager) {
    this.servicemanager = servicemanager;
  }

  public Long getAreaandserviceid() {
    return areaandserviceid;
  }

  public void setAreaandserviceid(Long areaandserviceid) {
    this.areaandserviceid = areaandserviceid;
  }
}
