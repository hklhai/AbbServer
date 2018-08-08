package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fuyg on 2017-10-27.
 */
@Entity
@Table(name="UDNORMALSERVICE")
@DynamicUpdate
public class Udnormalservice implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name="UDNORMALSERVICE_UDNORMALID_GENERATOR", allocationSize = 1 , sequenceName="UDNORMALIDSEQ")
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UDNORMALSERVICE_UDNORMALID_GENERATOR")
  private Long udnormalid;
  private String description;
  private String siteid;
  private String orgid;
  private String pronum;
  private String equnum;
  private Long linenum;
  private Long hasld;
  private String udworkreportid;
  private Long rowstamp;
  private Long col1 = Long.valueOf(0);
  private Long col2 = Long.valueOf(0);
  private Long col3 = Long.valueOf(0);
  private Long col4 = Long.valueOf(0);
  private Long col5 = Long.valueOf(0);
  private Long col6 = Long.valueOf(0);
  private Long col7 = Long.valueOf(0);
  private Long col8 = Long.valueOf(0);
  private Long col9 = Long.valueOf(0);
  private Long col10 = Long.valueOf(0);
  private Long col11 = Long.valueOf(0);
  private Long col12 = Long.valueOf(0);
  private Long col13 = Long.valueOf(0);
  private Long col14 = Long.valueOf(0);
  private Long col15 = Long.valueOf(0);
  private Long col16 = Long.valueOf(0);
  private Long col17 = Long.valueOf(0);
  private Long col18 = Long.valueOf(0);
  private Long col19 = Long.valueOf(0);
  private Long col20 = Long.valueOf(0);

  @Transient
  private String isdel;

  public String getIsdel() {
    return isdel;
  }

  public void setIsdel(String isdel) {
    this.isdel = isdel;
  }

  public Long getUdnormalid() {
    return udnormalid;
  }

  public void setUdnormalid(Long udnormalid) {
    this.udnormalid = udnormalid;
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

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public String getEqunum() {
    return equnum;
  }

  public void setEqunum(String equnum) {
    this.equnum = equnum;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
  }

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public String getUdworkreportid() {
    return udworkreportid;
  }

  public void setUdworkreportid(String udworkreportid) {
    this.udworkreportid = udworkreportid;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public Long getCol1() {
    return col1;
  }

  public void setCol1(Long col1) {
    this.col1 = col1;
  }

  public Long getCol2() {
    return col2;
  }

  public void setCol2(Long col2) {
    this.col2 = col2;
  }

  public Long getCol3() {
    return col3;
  }

  public void setCol3(Long col3) {
    this.col3 = col3;
  }

  public Long getCol4() {
    return col4;
  }

  public void setCol4(Long col4) {
    this.col4 = col4;
  }

  public Long getCol5() {
    return col5;
  }

  public void setCol5(Long col5) {
    this.col5 = col5;
  }

  public Long getCol6() {
    return col6;
  }

  public void setCol6(Long col6) {
    this.col6 = col6;
  }

  public Long getCol7() {
    return col7;
  }

  public void setCol7(Long col7) {
    this.col7 = col7;
  }

  public Long getCol8() {
    return col8;
  }

  public void setCol8(Long col8) {
    this.col8 = col8;
  }

  public Long getCol9() {
    return col9;
  }

  public void setCol9(Long col9) {
    this.col9 = col9;
  }

  public Long getCol10() {
    return col10;
  }

  public void setCol10(Long col10) {
    this.col10 = col10;
  }

  public Long getCol11() {
    return col11;
  }

  public void setCol11(Long col11) {
    this.col11 = col11;
  }

  public Long getCol12() {
    return col12;
  }

  public void setCol12(Long col12) {
    this.col12 = col12;
  }

  public Long getCol13() {
    return col13;
  }

  public void setCol13(Long col13) {
    this.col13 = col13;
  }

  public Long getCol14() {
    return col14;
  }

  public void setCol14(Long col14) {
    this.col14 = col14;
  }

  public Long getCol15() {
    return col15;
  }

  public void setCol15(Long col15) {
    this.col15 = col15;
  }

  public Long getCol16() {
    return col16;
  }

  public void setCol16(Long col16) {
    this.col16 = col16;
  }

  public Long getCol17() {
    return col17;
  }

  public void setCol17(Long col17) {
    this.col17 = col17;
  }

  public Long getCol18() {
    return col18;
  }

  public void setCol18(Long col18) {
    this.col18 = col18;
  }

  public Long getCol19() {
    return col19;
  }

  public void setCol19(Long col19) {
    this.col19 = col19;
  }

  public Long getCol20() {
    return col20;
  }

  public void setCol20(Long col20) {
    this.col20 = col20;
  }
}
