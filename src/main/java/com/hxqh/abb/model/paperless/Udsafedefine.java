package com.hxqh.abb.model.paperless;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDSAFEDEFINE")
public class Udsafedefine implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDSAFEDEFINE_UDSAFEDEFINEID_GENERATOR", allocationSize = 1 , sequenceName="UDSAFEDEFINEIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDSAFEDEFINE_UDSAFEDEFINEID_GENERATOR")
  private Long udsafedefineid;
  private String description;
  private String orgid;
  private Long hasld;
  private String sdnum;
  private String checkdetail;
  private String content;
  private String sferisk;
  private String response;
  private String riskdegree;
  private String riskprobability;
  private String risklevel;
  private Long level;
  private Long rowstamp;
  private String checkcontent;
  private String checktype;
  private String scnum;

  public Long getUdsafedefineid() {
    return udsafedefineid;
  }

  public void setUdsafedefineid(Long udsafedefineid) {
    this.udsafedefineid = udsafedefineid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public String getSdnum() {
    return sdnum;
  }

  public void setSdnum(String sdnum) {
    this.sdnum = sdnum;
  }

  public String getCheckdetail() {
    return checkdetail;
  }

  public void setCheckdetail(String checkdetail) {
    this.checkdetail = checkdetail;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSferisk() {
    return sferisk;
  }

  public void setSferisk(String sferisk) {
    this.sferisk = sferisk;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getRiskdegree() {
    return riskdegree;
  }

  public void setRiskdegree(String riskdegree) {
    this.riskdegree = riskdegree;
  }

  public String getRiskprobability() {
    return riskprobability;
  }

  public void setRiskprobability(String riskprobability) {
    this.riskprobability = riskprobability;
  }

  public String getRisklevel() {
    return risklevel;
  }

  public void setRisklevel(String risklevel) {
    this.risklevel = risklevel;
  }

  public Long getLevel() {
    return level;
  }

  public void setLevel(Long level) {
    this.level = level;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getCheckcontent() {
    return checkcontent;
  }

  public void setCheckcontent(String checkcontent) {
    this.checkcontent = checkcontent;
  }

  public String getChecktype() {
    return checktype;
  }

  public void setChecktype(String checktype) {
    this.checktype = checktype;
  }

  public String getScnum() {
    return scnum;
  }

  public void setScnum(String scnum) {
    this.scnum = scnum;
  }
}
