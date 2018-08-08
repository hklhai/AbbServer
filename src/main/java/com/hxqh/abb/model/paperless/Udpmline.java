package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fuyg on 2017-09-26.
 */
@Entity
@Table(name="UDPMLINE")
@DynamicUpdate
public class Udpmline implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDPMLINE_UDPMLINEID_GENERATOR", allocationSize = 1 , sequenceName="UDPMLINEIDSEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDPMLINE_UDPMLINEID_GENERATOR")
  private Long udpmlineid;
  private String description;
  private String siteid;
  private String orgid;
  private Long hasld;
  private String number;
  private Long adjust;
  private Long back;
  private Date solutiondate;
  private String responsible;
  private String solutionresult;
  private Long udproblemmodifyid;
  private Long rowstamp;

  @Transient
  private Long frontedid;

  public Long getFrontedid() {
    return frontedid;
  }

  public void setFrontedid(Long frontedid) {
    this.frontedid = frontedid;
  }

  public Long getUdpmlineid() {
    return udpmlineid;
  }

  public void setUdpmlineid(Long udpmlineid) {
    this.udpmlineid = udpmlineid;
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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Long getAdjust() {
    return adjust;
  }

  public void setAdjust(Long adjust) {
    this.adjust = adjust;
  }

  public Long getBack() {
    return back;
  }

  public void setBack(Long back) {
    this.back = back;
  }

  public Date getSolutiondate() {
    return solutiondate;
  }

  public void setSolutiondate(Date solutiondate) {
    this.solutiondate = solutiondate;
  }

  public void setSolutiondate(String solutiondate) {
    if(solutiondate!=null&&!solutiondate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.solutiondate = sdf.parse(solutiondate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getResponsible() {
    return responsible;
  }

  public void setResponsible(String responsible) {
    this.responsible = responsible;
  }

  public String getSolutionresult() {
    return solutionresult;
  }

  public void setSolutionresult(String solutionresult) {
    this.solutionresult = solutionresult;
  }

  public Long getUdproblemmodifyid() {
    return udproblemmodifyid;
  }

  public void setUdproblemmodifyid(Long udproblemmodifyid) {
    this.udproblemmodifyid = udproblemmodifyid;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }
}
