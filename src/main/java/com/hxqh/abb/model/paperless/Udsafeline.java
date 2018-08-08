package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UDSAFELINE")
public class Udsafeline implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDSAFELINE_UDSAFELINEID_GENERATOR", allocationSize = 1 , sequenceName="UDSAFELINEIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDSAFELINE_UDSAFELINEID_GENERATOR")
  private Long udsafelineid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String checkcontent;
  private String checkdetail;
  private String checktype;
  private String content;
  private Long level;
  private String response;
  private String riskdegree;
  private String risklevel;
  private String riskprobability;
  private String scnum;
  private String sdnum;
  private String sferisk;
  private String slnum;
  private Long rowstamp;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdsafelineid() {
    return udsafelineid;
  }

  public void setUdsafelineid(Long udsafelineid) {
    this.udsafelineid = udsafelineid;
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

  public String getCheckcontent() {
    return checkcontent;
  }

  public void setCheckcontent(String checkcontent) {
    this.checkcontent = checkcontent;
  }

  public String getCheckdetail() {
    return checkdetail;
  }

  public void setCheckdetail(String checkdetail) {
    this.checkdetail = checkdetail;
  }

  public String getChecktype() {
    return checktype;
  }

  public void setChecktype(String checktype) {
    this.checktype = checktype;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getLevel() {
    return level;
  }

  public void setLevel(Long level) {
    this.level = level;
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

  public String getRisklevel() {
    return risklevel;
  }

  public void setRisklevel(String risklevel) {
    this.risklevel = risklevel;
  }

  public String getRiskprobability() {
    return riskprobability;
  }

  public void setRiskprobability(String riskprobability) {
    this.riskprobability = riskprobability;
  }

  public String getScnum() {
    return scnum;
  }

  public void setScnum(String scnum) {
    this.scnum = scnum;
  }

  public String getSdnum() {
    return sdnum;
  }

  public void setSdnum(String sdnum) {
    this.sdnum = sdnum;
  }

  public String getSferisk() {
    return sferisk;
  }

  public void setSferisk(String sferisk) {
    this.sferisk = sferisk;
  }

  public String getSlnum() {
    return slnum;
  }

  public void setSlnum(String slnum) {
    this.slnum = slnum;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
