package com.hxqh.abb.model.paperless;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "UDPERMISSION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Udpermission implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "UDPERMISSION_udpermissionid_GENERATOR", sequenceName = "UDPERMISSIONIDSEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDPERMISSION_udpermissionid_GENERATOR")
  private Long udpermissionid;
  private String description;
  private String pmsnum;
  private String siteid;
  private String orgid;
  private Long hasld;
  private Long rowstamp;
  @Column(name="createdby")
  private String createby;
  @Column(name="createddate")
  private java.sql.Timestamp createdate;
  private String changeby;
  private java.sql.Timestamp changedate;
  private String status;
  private java.sql.Timestamp statusdate;
  private String dlgnum;
  private String pronum;
  private Long linenum;
  private String fwcp;
  private String jndj;
  private String xmjl;
  private String xkfs;
  private String xkbz;
  private String xkzt;
  private String gznr;
  private Long gznr1;
  private Long gznr2;
  private Long gznr3;
  private Long gznr4;
  private Long gznr5;
  private Long gznr6;
  private Long gznr7;
  private Long aqyq1;
  private Long aqyq2;
  private Long aqyq3;
  private Long aqyq4;
  private Long aqyq5;
  private Long aqyq6;
  private Long aqyq7;
  private Long fx01;
  private String yq01;
  private Long cs021;
  private Long cs022;
  private Long fx02;
  private String yq02;
  private Long fx03;
  private Long cs031;
  private Long cs032;
  private String yq03;
  private Long fx04;
  private Long cs041;
  private Long cs042;
  private String yq04;
  private Long fx05;
  private Long cs051;
  private Long cs052;
  private Long cs053;
  private Long cs054;
  private String yq05;
  private Long fx06;
  private Long cs061;
  private Long cs062;
  private Long cs063;
  private Long cs064;
  private String yq06;
  private Long fx07;
  private Long cs071;
  private Long cs072;
  private Long cs073;
  private Long cs074;
  private String yq07;
  private Long fx08;
  private Long cs081;
  private Long cs082;
  private String yq08;
  private Long fx09;
  private Long cs091;
  private Long cs092;
  private Long cs093;
  private String yq09;
  @JsonProperty(value = "fx6a")
  private Long fx6a;
  @JsonProperty(value = "cs6a1")
  private Long cs6a1;
  @JsonProperty(value = "cs6a2")
  private Long cs6a2;
  @JsonProperty(value = "cs6a3")
  private Long cs6a3;
  @JsonProperty(value = "cs6a4")
  private Long cs6a4;
  @JsonProperty(value = "yq6a")
  private String yq6a;
  private Long fx11;
  private Long cs111;
  private Long cs112;
  private String yq11;
  private Long fx12;
  private Long cs121;
  private Long cs122;
  private String yq12;
  private Long fx13;
  private Long cs131;
  private Long cs132;
  private String yq13;
  private Long fx14;
  private Long cs141;
  private String yq14;
  private Long fx15;
  private Long cs151;
  private Long cs152;
  private String yq15;
  private Long fx16;
  private Long cs161;
  private Long cs162;
  private String yq16;
  private Long fx17;
  private Long cs171;
  private Long cs172;
  private String yq17;
  private Long fx18;
  private Long cs181;
  private Long cs182;
  private Long cs183;
  private String yq18;
  private Long fx19;
  private Long cs191;
  private Long cs192;
  private String yq19;
  private Long fx20;
  private Long cs201;
  private Long cs202;
  private String yq20;
  private Long fx21;
  private Long cs211;
  private String yq21;
  private Long fx22;
  private String fwry;
  private String gys;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private java.sql.Timestamp starttime;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private java.sql.Timestamp endtime;
  private String qrr;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private java.sql.Timestamp qrsj;
  private Long gzxk1;
  private Long gzxk2;
  private Long gzxk3;
  private Long gzxk4;
  private String coding;
  private String dlgcoding;
  private String sctnum;
  @JsonProperty(value = "udsafechecktable2id")
  private Long udsafechecktable2id;
  private String projectnum;
  private String projectmanager;
  private String sctnumber;

  private Long type;
  private String guardian;

  @Transient
  private String changebyname;
  @Transient
  private String createbyname;
  @Transient
  private Long number;
  @Transient
  private String linenumdesc;
  @Transient
  private String projectmanagername;
  @Transient
  private String pronumdesc;
  @Transient
  private String qrrname;
  @Transient
  private String sctnumberdesc;
  @Transient
  private String siteiddesc;
  @Transient
  private String orgiddesc;
  @Transient
  private String statusdesc;
  @Transient
  private String deletes;
  @Transient
  private String maintab;

  public Udpermission() {
  }

  public String getOrgiddesc() {
    return orgiddesc;
  }

  public void setOrgiddesc(String orgiddesc) {
    this.orgiddesc = orgiddesc;
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

  public String getChangebyname() {
    return changebyname;
  }

  public void setChangebyname(String changebyname) {
    this.changebyname = changebyname;
  }

  public String getCreatebyname() {
    return createbyname;
  }

  public void setCreatebyname(String createbyname) {
    this.createbyname = createbyname;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public String getLinenumdesc() {
    return linenumdesc;
  }

  public void setLinenumdesc(String linenumdesc) {
    this.linenumdesc = linenumdesc;
  }

  public String getProjectmanagername() {
    return projectmanagername;
  }

  public void setProjectmanagername(String projectmanagername) {
    this.projectmanagername = projectmanagername;
  }

  public String getPronumdesc() {
    return pronumdesc;
  }

  public void setPronumdesc(String pronumdesc) {
    this.pronumdesc = pronumdesc;
  }

  public String getQrrname() {
    return qrrname;
  }

  public void setQrrname(String qrrname) {
    this.qrrname = qrrname;
  }

  public String getSctnumberdesc() {
    return sctnumberdesc;
  }

  public void setSctnumberdesc(String sctnumberdesc) {
    this.sctnumberdesc = sctnumberdesc;
  }

  public String getSiteiddesc() {
    return siteiddesc;
  }

  public void setSiteiddesc(String siteiddesc) {
    this.siteiddesc = siteiddesc;
  }

  public String getStatusdesc() {
    return statusdesc;
  }

  public void setStatusdesc(String statusdesc) {
    this.statusdesc = statusdesc;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public String getGuardian() {
    return guardian;
  }

  public void setGuardian(String guardian) {
    this.guardian = guardian;
  }

  public Long getUdpermissionid() {
    return udpermissionid;
  }

  public void setUdpermissionid(Long udpermissionid) {
    this.udpermissionid = udpermissionid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPmsnum() {
    return pmsnum;
  }

  public void setPmsnum(String pmsnum) {
    this.pmsnum = pmsnum;
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

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
  }

  public String getCreateby() {
    return createby;
  }

  public void setCreateby(String createby) {
    this.createby = createby;
  }

  public java.sql.Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(java.sql.Timestamp createdate) {
    this.createdate = createdate;
  }

  public String getChangeby() {
    return changeby;
  }

  public void setChangeby(String changeby) {
    this.changeby = changeby;
  }

  public java.sql.Timestamp getChangedate() {
    return changedate;
  }

  public void setChangedate(java.sql.Timestamp changedate) {
    this.changedate = changedate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public java.sql.Timestamp getStatusdate() {
    return statusdate;
  }

  public void setStatusdate(java.sql.Timestamp statusdate) {
    this.statusdate = statusdate;
  }

  public String getDlgnum() {
    return dlgnum;
  }

  public void setDlgnum(String dlgnum) {
    this.dlgnum = dlgnum;
  }

  public String getPronum() {
    return pronum;
  }

  public void setPronum(String pronum) {
    this.pronum = pronum;
  }

  public Long getLinenum() {
    return linenum;
  }

  public void setLinenum(Long linenum) {
    this.linenum = linenum;
  }

  public String getFwcp() {
    return fwcp;
  }

  public void setFwcp(String fwcp) {
    this.fwcp = fwcp;
  }

  public String getJndj() {
    return jndj;
  }

  public void setJndj(String jndj) {
    this.jndj = jndj;
  }

  public String getXmjl() {
    return xmjl;
  }

  public void setXmjl(String xmjl) {
    this.xmjl = xmjl;
  }

  public String getXkfs() {
    return xkfs;
  }

  public void setXkfs(String xkfs) {
    this.xkfs = xkfs;
  }

  public String getXkbz() {
    return xkbz;
  }

  public void setXkbz(String xkbz) {
    this.xkbz = xkbz;
  }

  public String getXkzt() {
    return xkzt;
  }

  public void setXkzt(String xkzt) {
    this.xkzt = xkzt;
  }

  public String getGznr() {
    return gznr;
  }

  public void setGznr(String gznr) {
    this.gznr = gznr;
  }

  public Long getGznr1() {
    return gznr1;
  }

  public void setGznr1(Long gznr1) {
    this.gznr1 = gznr1;
  }

  public Long getGznr2() {
    return gznr2;
  }

  public void setGznr2(Long gznr2) {
    this.gznr2 = gznr2;
  }

  public Long getGznr3() {
    return gznr3;
  }

  public void setGznr3(Long gznr3) {
    this.gznr3 = gznr3;
  }

  public Long getGznr4() {
    return gznr4;
  }

  public void setGznr4(Long gznr4) {
    this.gznr4 = gznr4;
  }

  public Long getGznr5() {
    return gznr5;
  }

  public void setGznr5(Long gznr5) {
    this.gznr5 = gznr5;
  }

  public Long getGznr6() {
    return gznr6;
  }

  public void setGznr6(Long gznr6) {
    this.gznr6 = gznr6;
  }

  public Long getGznr7() {
    return gznr7;
  }

  public void setGznr7(Long gznr7) {
    this.gznr7 = gznr7;
  }

  public Long getAqyq1() {
    return aqyq1;
  }

  public void setAqyq1(Long aqyq1) {
    this.aqyq1 = aqyq1;
  }

  public Long getAqyq2() {
    return aqyq2;
  }

  public void setAqyq2(Long aqyq2) {
    this.aqyq2 = aqyq2;
  }

  public Long getAqyq3() {
    return aqyq3;
  }

  public void setAqyq3(Long aqyq3) {
    this.aqyq3 = aqyq3;
  }

  public Long getAqyq4() {
    return aqyq4;
  }

  public void setAqyq4(Long aqyq4) {
    this.aqyq4 = aqyq4;
  }

  public Long getAqyq5() {
    return aqyq5;
  }

  public void setAqyq5(Long aqyq5) {
    this.aqyq5 = aqyq5;
  }

  public Long getAqyq6() {
    return aqyq6;
  }

  public void setAqyq6(Long aqyq6) {
    this.aqyq6 = aqyq6;
  }

  public Long getAqyq7() {
    return aqyq7;
  }

  public void setAqyq7(Long aqyq7) {
    this.aqyq7 = aqyq7;
  }

  public Long getFx01() {
    return fx01;
  }

  public void setFx01(Long fx01) {
    this.fx01 = fx01;
  }

  public String getYq01() {
    return yq01;
  }

  public void setYq01(String yq01) {
    this.yq01 = yq01;
  }

  public Long getCs021() {
    return cs021;
  }

  public void setCs021(Long cs021) {
    this.cs021 = cs021;
  }

  public Long getCs022() {
    return cs022;
  }

  public void setCs022(Long cs022) {
    this.cs022 = cs022;
  }

  public Long getFx02() {
    return fx02;
  }

  public void setFx02(Long fx02) {
    this.fx02 = fx02;
  }

  public String getYq02() {
    return yq02;
  }

  public void setYq02(String yq02) {
    this.yq02 = yq02;
  }

  public Long getFx03() {
    return fx03;
  }

  public void setFx03(Long fx03) {
    this.fx03 = fx03;
  }

  public Long getCs031() {
    return cs031;
  }

  public void setCs031(Long cs031) {
    this.cs031 = cs031;
  }

  public Long getCs032() {
    return cs032;
  }

  public void setCs032(Long cs032) {
    this.cs032 = cs032;
  }

  public String getYq03() {
    return yq03;
  }

  public void setYq03(String yq03) {
    this.yq03 = yq03;
  }

  public Long getFx04() {
    return fx04;
  }

  public void setFx04(Long fx04) {
    this.fx04 = fx04;
  }

  public Long getCs041() {
    return cs041;
  }

  public void setCs041(Long cs041) {
    this.cs041 = cs041;
  }

  public Long getCs042() {
    return cs042;
  }

  public void setCs042(Long cs042) {
    this.cs042 = cs042;
  }

  public String getYq04() {
    return yq04;
  }

  public void setYq04(String yq04) {
    this.yq04 = yq04;
  }

  public Long getFx05() {
    return fx05;
  }

  public void setFx05(Long fx05) {
    this.fx05 = fx05;
  }

  public Long getCs051() {
    return cs051;
  }

  public void setCs051(Long cs051) {
    this.cs051 = cs051;
  }

  public Long getCs052() {
    return cs052;
  }

  public void setCs052(Long cs052) {
    this.cs052 = cs052;
  }

  public Long getCs053() {
    return cs053;
  }

  public void setCs053(Long cs053) {
    this.cs053 = cs053;
  }

  public Long getCs054() {
    return cs054;
  }

  public void setCs054(Long cs054) {
    this.cs054 = cs054;
  }

  public String getYq05() {
    return yq05;
  }

  public void setYq05(String yq05) {
    this.yq05 = yq05;
  }

  public Long getFx06() {
    return fx06;
  }

  public void setFx06(Long fx06) {
    this.fx06 = fx06;
  }

  public Long getCs061() {
    return cs061;
  }

  public void setCs061(Long cs061) {
    this.cs061 = cs061;
  }

  public Long getCs062() {
    return cs062;
  }

  public void setCs062(Long cs062) {
    this.cs062 = cs062;
  }

  public Long getCs063() {
    return cs063;
  }

  public void setCs063(Long cs063) {
    this.cs063 = cs063;
  }

  public Long getCs064() {
    return cs064;
  }

  public void setCs064(Long cs064) {
    this.cs064 = cs064;
  }

  public String getYq06() {
    return yq06;
  }

  public void setYq06(String yq06) {
    this.yq06 = yq06;
  }

  public Long getFx07() {
    return fx07;
  }

  public void setFx07(Long fx07) {
    this.fx07 = fx07;
  }

  public Long getCs071() {
    return cs071;
  }

  public void setCs071(Long cs071) {
    this.cs071 = cs071;
  }

  public Long getCs072() {
    return cs072;
  }

  public void setCs072(Long cs072) {
    this.cs072 = cs072;
  }

  public Long getCs073() {
    return cs073;
  }

  public void setCs073(Long cs073) {
    this.cs073 = cs073;
  }

  public Long getCs074() {
    return cs074;
  }

  public void setCs074(Long cs074) {
    this.cs074 = cs074;
  }

  public String getYq07() {
    return yq07;
  }

  public void setYq07(String yq07) {
    this.yq07 = yq07;
  }

  public Long getFx08() {
    return fx08;
  }

  public void setFx08(Long fx08) {
    this.fx08 = fx08;
  }

  public Long getCs081() {
    return cs081;
  }

  public void setCs081(Long cs081) {
    this.cs081 = cs081;
  }

  public Long getCs082() {
    return cs082;
  }

  public void setCs082(Long cs082) {
    this.cs082 = cs082;
  }

  public String getYq08() {
    return yq08;
  }

  public void setYq08(String yq08) {
    this.yq08 = yq08;
  }

  public Long getFx09() {
    return fx09;
  }

  public void setFx09(Long fx09) {
    this.fx09 = fx09;
  }

  public Long getCs091() {
    return cs091;
  }

  public void setCs091(Long cs091) {
    this.cs091 = cs091;
  }

  public Long getCs092() {
    return cs092;
  }

  public void setCs092(Long cs092) {
    this.cs092 = cs092;
  }

  public Long getCs093() {
    return cs093;
  }

  public void setCs093(Long cs093) {
    this.cs093 = cs093;
  }

  public String getYq09() {
    return yq09;
  }

  public void setYq09(String yq09) {
    this.yq09 = yq09;
  }

  public Long getFx6a() {
    return fx6a;
  }

  public void setFx6a(Long fx6a) {
    this.fx6a = fx6a;
  }

  public Long getCs6a1() {
    return cs6a1;
  }

  public void setCs6a1(Long cs6a1) {
    this.cs6a1 = cs6a1;
  }

  public Long getCs6a2() {
    return cs6a2;
  }

  public void setCs6a2(Long cs6a2) {
    this.cs6a2 = cs6a2;
  }

  public Long getCs6a3() {
    return cs6a3;
  }

  public void setCs6a3(Long cs6a3) {
    this.cs6a3 = cs6a3;
  }

  public Long getCs6a4() {
    return cs6a4;
  }

  public void setCs6a4(Long cs6a4) {
    this.cs6a4 = cs6a4;
  }

  public String getYq6a() {
    return yq6a;
  }

  public void setYq6a(String yq6a) {
    this.yq6a = yq6a;
  }

  public Long getFx11() {
    return fx11;
  }

  public void setFx11(Long fx11) {
    this.fx11 = fx11;
  }

  public Long getCs111() {
    return cs111;
  }

  public void setCs111(Long cs111) {
    this.cs111 = cs111;
  }

  public Long getCs112() {
    return cs112;
  }

  public void setCs112(Long cs112) {
    this.cs112 = cs112;
  }

  public String getYq11() {
    return yq11;
  }

  public void setYq11(String yq11) {
    this.yq11 = yq11;
  }

  public Long getFx12() {
    return fx12;
  }

  public void setFx12(Long fx12) {
    this.fx12 = fx12;
  }

  public Long getCs121() {
    return cs121;
  }

  public void setCs121(Long cs121) {
    this.cs121 = cs121;
  }

  public Long getCs122() {
    return cs122;
  }

  public void setCs122(Long cs122) {
    this.cs122 = cs122;
  }

  public String getYq12() {
    return yq12;
  }

  public void setYq12(String yq12) {
    this.yq12 = yq12;
  }

  public Long getFx13() {
    return fx13;
  }

  public void setFx13(Long fx13) {
    this.fx13 = fx13;
  }

  public Long getCs131() {
    return cs131;
  }

  public void setCs131(Long cs131) {
    this.cs131 = cs131;
  }

  public Long getCs132() {
    return cs132;
  }

  public void setCs132(Long cs132) {
    this.cs132 = cs132;
  }

  public String getYq13() {
    return yq13;
  }

  public void setYq13(String yq13) {
    this.yq13 = yq13;
  }

  public Long getFx14() {
    return fx14;
  }

  public void setFx14(Long fx14) {
    this.fx14 = fx14;
  }

  public Long getCs141() {
    return cs141;
  }

  public void setCs141(Long cs141) {
    this.cs141 = cs141;
  }

  public String getYq14() {
    return yq14;
  }

  public void setYq14(String yq14) {
    this.yq14 = yq14;
  }

  public Long getFx15() {
    return fx15;
  }

  public void setFx15(Long fx15) {
    this.fx15 = fx15;
  }

  public Long getCs151() {
    return cs151;
  }

  public void setCs151(Long cs151) {
    this.cs151 = cs151;
  }

  public Long getCs152() {
    return cs152;
  }

  public void setCs152(Long cs152) {
    this.cs152 = cs152;
  }

  public String getYq15() {
    return yq15;
  }

  public void setYq15(String yq15) {
    this.yq15 = yq15;
  }

  public Long getFx16() {
    return fx16;
  }

  public void setFx16(Long fx16) {
    this.fx16 = fx16;
  }

  public Long getCs161() {
    return cs161;
  }

  public void setCs161(Long cs161) {
    this.cs161 = cs161;
  }

  public Long getCs162() {
    return cs162;
  }

  public void setCs162(Long cs162) {
    this.cs162 = cs162;
  }

  public String getYq16() {
    return yq16;
  }

  public void setYq16(String yq16) {
    this.yq16 = yq16;
  }

  public Long getFx17() {
    return fx17;
  }

  public void setFx17(Long fx17) {
    this.fx17 = fx17;
  }

  public Long getCs171() {
    return cs171;
  }

  public void setCs171(Long cs171) {
    this.cs171 = cs171;
  }

  public Long getCs172() {
    return cs172;
  }

  public void setCs172(Long cs172) {
    this.cs172 = cs172;
  }

  public String getYq17() {
    return yq17;
  }

  public void setYq17(String yq17) {
    this.yq17 = yq17;
  }

  public Long getFx18() {
    return fx18;
  }

  public void setFx18(Long fx18) {
    this.fx18 = fx18;
  }

  public Long getCs181() {
    return cs181;
  }

  public void setCs181(Long cs181) {
    this.cs181 = cs181;
  }

  public Long getCs182() {
    return cs182;
  }

  public void setCs182(Long cs182) {
    this.cs182 = cs182;
  }

  public Long getCs183() {
    return cs183;
  }

  public void setCs183(Long cs183) {
    this.cs183 = cs183;
  }

  public String getYq18() {
    return yq18;
  }

  public void setYq18(String yq18) {
    this.yq18 = yq18;
  }

  public Long getFx19() {
    return fx19;
  }

  public void setFx19(Long fx19) {
    this.fx19 = fx19;
  }

  public Long getCs191() {
    return cs191;
  }

  public void setCs191(Long cs191) {
    this.cs191 = cs191;
  }

  public Long getCs192() {
    return cs192;
  }

  public void setCs192(Long cs192) {
    this.cs192 = cs192;
  }

  public String getYq19() {
    return yq19;
  }

  public void setYq19(String yq19) {
    this.yq19 = yq19;
  }

  public Long getFx20() {
    return fx20;
  }

  public void setFx20(Long fx20) {
    this.fx20 = fx20;
  }

  public Long getCs201() {
    return cs201;
  }

  public void setCs201(Long cs201) {
    this.cs201 = cs201;
  }

  public Long getCs202() {
    return cs202;
  }

  public void setCs202(Long cs202) {
    this.cs202 = cs202;
  }

  public String getYq20() {
    return yq20;
  }

  public void setYq20(String yq20) {
    this.yq20 = yq20;
  }

  public Long getFx21() {
    return fx21;
  }

  public void setFx21(Long fx21) {
    this.fx21 = fx21;
  }

  public Long getCs211() {
    return cs211;
  }

  public void setCs211(Long cs211) {
    this.cs211 = cs211;
  }

  public String getYq21() {
    return yq21;
  }

  public void setYq21(String yq21) {
    this.yq21 = yq21;
  }

  public Long getFx22() {
    return fx22;
  }

  public void setFx22(Long fx22) {
    this.fx22 = fx22;
  }

  public String getFwry() {
    return fwry;
  }

  public void setFwry(String fwry) {
    this.fwry = fwry;
  }

  public String getGys() {
    return gys;
  }

  public void setGys(String gys) {
    this.gys = gys;
  }

  public java.sql.Timestamp getStarttime() {
    return starttime;
  }

  public void setStarttime(Timestamp starttime) {
    this.starttime = starttime;
  }

  public void setEndtime(Timestamp endtime) {
    this.endtime = endtime;
  }

  public void setQrsj(Timestamp qrsj) {
    this.qrsj = qrsj;
  }

  public void setStarttime(String starttime) {
    if(starttime!=null&&!starttime.equals("")){
      try {
        this.starttime = Timestamp.valueOf(starttime);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public java.sql.Timestamp getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    if(endtime!=null&&!endtime.equals("")){
      try {
        this.endtime = Timestamp.valueOf(endtime);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getQrr() {
    return qrr;
  }

  public void setQrr(String qrr) {
    this.qrr = qrr;
  }

  public java.sql.Timestamp getQrsj() {
    return qrsj;
  }

  public void setQrsj(String qrsj) {
    if(qrsj!=null&&!qrsj.equals("")){
      try {
        this.qrsj = Timestamp.valueOf(qrsj);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Long getGzxk1() {
    return gzxk1;
  }

  public void setGzxk1(Long gzxk1) {
    this.gzxk1 = gzxk1;
  }

  public Long getGzxk2() {
    return gzxk2;
  }

  public void setGzxk2(Long gzxk2) {
    this.gzxk2 = gzxk2;
  }

  public Long getGzxk3() {
    return gzxk3;
  }

  public void setGzxk3(Long gzxk3) {
    this.gzxk3 = gzxk3;
  }

  public Long getGzxk4() {
    return gzxk4;
  }

  public void setGzxk4(Long gzxk4) {
    this.gzxk4 = gzxk4;
  }

  public String getCoding() {
    return coding;
  }

  public void setCoding(String coding) {
    this.coding = coding;
  }

  public String getDlgcoding() {
    return dlgcoding;
  }

  public void setDlgcoding(String dlgcoding) {
    this.dlgcoding = dlgcoding;
  }

  public String getSctnum() {
    return sctnum;
  }

  public void setSctnum(String sctnum) {
    this.sctnum = sctnum;
  }

  public Long getUdsafechecktable2id() {
    return udsafechecktable2id;
  }

  public void setUdsafechecktable2id(Long udsafechecktable2id) {
    this.udsafechecktable2id = udsafechecktable2id;
  }

  public String getProjectnum() {
    return projectnum;
  }

  public void setProjectnum(String projectnum) {
    this.projectnum = projectnum;
  }

  public String getProjectmanager() {
    return projectmanager;
  }

  public void setProjectmanager(String projectmanager) {
    this.projectmanager = projectmanager;
  }

  public String getSctnumber() {
    return sctnumber;
  }

  public void setSctnumber(String sctnumber) {
    this.sctnumber = sctnumber;
  }
}
