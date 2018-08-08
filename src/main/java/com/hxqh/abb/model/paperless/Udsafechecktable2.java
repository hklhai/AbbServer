package com.hxqh.abb.model.paperless;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "UDSAFECHECKTABLE2")
public class Udsafechecktable2 implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "UDSAFECHECKTABLE2_udsafechecktable2id_GENERATOR", sequenceName = "UDSAFECHECKTABLE2IDSEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDSAFECHECKTABLE2_udsafechecktable2id_GENERATOR")
  private Long udsafechecktable2id;
  private String description;
  private String number;
  private String title;
  private java.sql.Timestamp createdate;
  private Long hasld;
  private String companyname;
  private String siteid;
  private String companyname2;
  private String contacts;
  private String contractnumber;
  private String manager;
  private String siteandworkrange;
  private String firstaidcall;
  private String firecall;
  private String emergencycall;
  private String serialnumber;
  private String checkcontent;
  private Long checkresult;
  private String checkman;
  private Date checkdate;
  private String countermeasures;
  private String orgid;
  @Column(name="creator")
  private String createby;
  private String changeby;
  private java.sql.Timestamp changedate;
  private String status;
  private java.sql.Timestamp stausdate;
  @Column(name="p1_01")
  private Long p101;
  @Column(name="p1_02")
  private Long p102;
  @Column(name="p1_03")
  private Long p103;
  @Column(name="p1_04")
  private Long p104;
  @Column(name="p1_05")
  private Long p105;
  @Column(name="p1_06")
  private Long p106;
  @Column(name="p2_01")
  private Long p201;
  @Column(name="p2_02")
  private Long p202;
  @Column(name="p2_03")
  private Long p203;
  @Column(name="p2_04")
  private Long p204;
  @Column(name="p2_05")
  private Long p205;
  @Column(name="p2_06")
  private Long p206;
  @Column(name="p2_07")
  private Long p207;
  @Column(name="p2_08")
  private Long p208;
  @Column(name="p2_09")
  private Long p209;
  @Column(name="p2_10")
  private Long p210;
  @Column(name="p2_11")
  private Long p211;
  @Column(name="p2_12")
  private Long p212;
  @Column(name="p2_13")
  private Long p213;
  @Column(name="p2_14")
  private Long p214;
  @Column(name="p2_15")
  private Long p215;
  @Column(name="p2_16")
  private Long p216;
  @Column(name="p2_17")
  private Long p217;
  @Column(name="p2_18")
  private Long p218;
  @Column(name="p2_19")
  private Long p219;
  @Column(name="p2_20")
  private Long p220;
  @Column(name="p2_21")
  private Long p221;
  @Column(name="p2_22")
  private Long p222;
  @Column(name="p2_23")
  private Long p223;
  @Column(name="p2_24")
  private Long p224;
  @Column(name="p2_25")
  private Long p225;
  @Column(name="p3_01")
  private Long p301;
  @Column(name="p3_02")
  private Long p302;
  @Column(name="p3_03")
  private Long p303;
  @Column(name="p3_04")
  private Long p304;
  @Column(name="p3_05")
  private Long p305;
  @Column(name="p3_06")
  private Long p306;
  @Column(name="p3_07")
  private Long p307;
  @Column(name="p3_08")
  private Long p308;
  @Column(name="p3_09")
  private Long p309;
  @Column(name="p3_10")
  private Long p310;
  @Column(name="p3_11")
  private Long p311;
  @Column(name="p3_12")
  private Long p312;
  @Column(name="p3_13")
  private Long p313;
  @Column(name="p3_14")
  private Long p314;
  @Column(name="p4_01")
  private Long p401;
  @Column(name="p4_02")
  private Long p402;
  @Column(name="p4_03")
  private Long p403;
  @Column(name="p4_04")
  private Long p404;
  @Column(name="p4_05")
  private Long p405;
  @Column(name="p4_06")
  private Long p406;
  @Column(name="p5_01")
  private Long p501;
  @Column(name="p5_02")
  private Long p502;
  @Column(name="p5_03")
  private Long p503;
  @Column(name="p5_04")
  private Long p504;
  @Column(name="p5_05")
  private Long p505;
  @Column(name="p5_06")
  private Long p506;
  @Column(name="p5_07")
  private Long p507;
  @Column(name="p5_08")
  private Long p508;
  @Column(name="p5_09")
  private Long p509;
  @Column(name="p6_01")
  private Long p601;
  @Column(name="p6_02")
  private Long p602;
  @Column(name="p6_03")
  private Long p603;
  @Column(name="p6_04")
  private Long p604;
  @Column(name="p6_05")
  private Long p605;
  @Column(name="p6_06")
  private Long p606;
  @Column(name="p6_07")
  private Long p607;
  @Column(name="p7_01")
  private Long p701;
  @Column(name="p7_02")
  private Long p702;
  @Column(name="p7_03")
  private Long p703;
  @Column(name="p7_04")
  private Long p704;
  @Column(name="p7_05")
  private Long p705;
  @Column(name="p7_06")
  private Long p706;
  @Column(name="p7_07")
  private Long p707;
  private String checktype;
  private Long projectinfoid;
  private String projectmanager;
  private Long rowstamp;
  private String pronum;
  private Long linenum;
  private String promanager;
  private String location;
  private String nowman;
  private String scnum;
  private String remark;

  @Transient
  private String siteiddesc;
  @Transient
  private String orgiddesc;
  @Transient
  private String contactsname;
  @Transient
  private String managername;
  @Transient
  private String checkmanname;
  @Transient
  private String createbyname;
  @Transient
  private String changebyname;
  @Transient
  private String statusdesc;
  @Transient
  private String projectmanagername;
  @Transient
  private String khcompany;
  @Transient
  private String khcontacts;
  @Transient
  private String pronumdesc;
  @Transient
  private String linenumdesc;
  @Transient
  private String nowmanname;
  @Transient
  private String scnumdesc;
  @Transient
  private String deletes;
  @Transient
  private String maintab;

  public Date getCheckdate() {
    return checkdate;
  }

  public void setCheckdate(Date checkdate) {
    this.checkdate = checkdate;
  }

  public void setCheckdate(String checkdate) {
    if(checkdate!=null&&!checkdate.equals("")){
      try {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.checkdate = sdf.parse(checkdate);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String getOrgiddesc() {
    return orgiddesc;
  }

  public void setOrgiddesc(String orgiddesc) {
    this.orgiddesc = orgiddesc;
  }

  public String getMaintab() {
    return maintab;
  }

  public void setMaintab(String maintab) {
    this.maintab = maintab;
  }

  public String getDeletes() {
    return deletes;
  }

  public void setDeletes(String deletes) {
    this.deletes = deletes;
  }

  public String getScnumdesc() {
    return scnumdesc;
  }

  public void setScnumdesc(String scnumdesc) {
    this.scnumdesc = scnumdesc;
  }

  public String getSiteiddesc() {
    return siteiddesc;
  }

  public void setSiteiddesc(String siteiddesc) {
    this.siteiddesc = siteiddesc;
  }

  public String getContactsname() {
    return contactsname;
  }

  public void setContactsname(String contactsname) {
    this.contactsname = contactsname;
  }

  public String getManagername() {
    return managername;
  }

  public void setManagername(String managername) {
    this.managername = managername;
  }

  public String getCheckmanname() {
    return checkmanname;
  }

  public void setCheckmanname(String checkmanname) {
    this.checkmanname = checkmanname;
  }

  public String getCreatebyname() {
    return createbyname;
  }

  public void setCreatebyname(String createbyname) {
    this.createbyname = createbyname;
  }

  public String getChangebyname() {
    return changebyname;
  }

  public void setChangebyname(String changebyname) {
    this.changebyname = changebyname;
  }

  public String getStatusdesc() {
    return statusdesc;
  }

  public void setStatusdesc(String statusdesc) {
    this.statusdesc = statusdesc;
  }

  public String getProjectmanagername() {
    return projectmanagername;
  }

  public void setProjectmanagername(String projectmanagername) {
    this.projectmanagername = projectmanagername;
  }

  public String getKhcompany() {
    return khcompany;
  }

  public void setKhcompany(String khcompany) {
    this.khcompany = khcompany;
  }

  public String getKhcontacts() {
    return khcontacts;
  }

  public void setKhcontacts(String khcontacts) {
    this.khcontacts = khcontacts;
  }

  public String getPronumdesc() {
    return pronumdesc;
  }

  public void setPronumdesc(String pronumdesc) {
    this.pronumdesc = pronumdesc;
  }

  public String getLinenumdesc() {
    return linenumdesc;
  }

  public void setLinenumdesc(String linenumdesc) {
    this.linenumdesc = linenumdesc;
  }

  public String getNowmanname() {
    return nowmanname;
  }

  public void setNowmanname(String nowmanname) {
    this.nowmanname = nowmanname;
  }

  public Long getUdsafechecktable2id() {
    return udsafechecktable2id;
  }

  public void setUdsafechecktable2id(Long udsafechecktable2id) {
    this.udsafechecktable2id = udsafechecktable2id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(Timestamp createdate) {
    this.createdate = createdate;
  }

  public Long getHasld() {
    return hasld;
  }

  public void setHasld(Long hasld) {
    this.hasld = hasld;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public String getSiteid() {
    return siteid;
  }

  public void setSiteid(String siteid) {
    this.siteid = siteid;
  }

  public String getCompanyname2() {
    return companyname2;
  }

  public void setCompanyname2(String companyname2) {
    this.companyname2 = companyname2;
  }

  public String getContacts() {
    return contacts;
  }

  public void setContacts(String contacts) {
    this.contacts = contacts;
  }

  public String getContractnumber() {
    return contractnumber;
  }

  public void setContractnumber(String contractnumber) {
    this.contractnumber = contractnumber;
  }

  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }

  public String getSiteandworkrange() {
    return siteandworkrange;
  }

  public void setSiteandworkrange(String siteandworkrange) {
    this.siteandworkrange = siteandworkrange;
  }

  public String getFirstaidcall() {
    return firstaidcall;
  }

  public void setFirstaidcall(String firstaidcall) {
    this.firstaidcall = firstaidcall;
  }

  public String getFirecall() {
    return firecall;
  }

  public void setFirecall(String firecall) {
    this.firecall = firecall;
  }

  public String getEmergencycall() {
    return emergencycall;
  }

  public void setEmergencycall(String emergencycall) {
    this.emergencycall = emergencycall;
  }

  public String getSerialnumber() {
    return serialnumber;
  }

  public void setSerialnumber(String serialnumber) {
    this.serialnumber = serialnumber;
  }

  public String getCheckcontent() {
    return checkcontent;
  }

  public void setCheckcontent(String checkcontent) {
    this.checkcontent = checkcontent;
  }

  public Long getCheckresult() {
    return checkresult;
  }

  public void setCheckresult(Long checkresult) {
    this.checkresult = checkresult;
  }

  public String getCheckman() {
    return checkman;
  }

  public void setCheckman(String checkman) {
    this.checkman = checkman;
  }

  public String getCountermeasures() {
    return countermeasures;
  }

  public void setCountermeasures(String countermeasures) {
    this.countermeasures = countermeasures;
  }

  public String getOrgid() {
    return orgid;
  }

  public void setOrgid(String orgid) {
    this.orgid = orgid;
  }

  public String getCreateby() {
    return createby;
  }

  public void setCreateby(String createby) {
    this.createby = createby;
  }

  public String getChangeby() {
    return changeby;
  }

  public void setChangeby(String changeby) {
    this.changeby = changeby;
  }

  public Timestamp getChangedate() {
    return changedate;
  }

  public void setChangedate(Timestamp changedate) {
    this.changedate = changedate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Timestamp getStausdate() {
    return stausdate;
  }

  public void setStausdate(Timestamp stausdate) {
    this.stausdate = stausdate;
  }

  public Long getP101() {
    return p101;
  }

  public void setP101(Long p101) {
    this.p101 = p101;
  }

  public Long getP102() {
    return p102;
  }

  public void setP102(Long p102) {
    this.p102 = p102;
  }

  public Long getP103() {
    return p103;
  }

  public void setP103(Long p103) {
    this.p103 = p103;
  }

  public Long getP104() {
    return p104;
  }

  public void setP104(Long p104) {
    this.p104 = p104;
  }

  public Long getP105() {
    return p105;
  }

  public void setP105(Long p105) {
    this.p105 = p105;
  }

  public Long getP106() {
    return p106;
  }

  public void setP106(Long p106) {
    this.p106 = p106;
  }

  public Long getP201() {
    return p201;
  }

  public void setP201(Long p201) {
    this.p201 = p201;
  }

  public Long getP202() {
    return p202;
  }

  public void setP202(Long p202) {
    this.p202 = p202;
  }

  public Long getP203() {
    return p203;
  }

  public void setP203(Long p203) {
    this.p203 = p203;
  }

  public Long getP204() {
    return p204;
  }

  public void setP204(Long p204) {
    this.p204 = p204;
  }

  public Long getP205() {
    return p205;
  }

  public void setP205(Long p205) {
    this.p205 = p205;
  }

  public Long getP206() {
    return p206;
  }

  public void setP206(Long p206) {
    this.p206 = p206;
  }

  public Long getP207() {
    return p207;
  }

  public void setP207(Long p207) {
    this.p207 = p207;
  }

  public Long getP208() {
    return p208;
  }

  public void setP208(Long p208) {
    this.p208 = p208;
  }

  public Long getP209() {
    return p209;
  }

  public void setP209(Long p209) {
    this.p209 = p209;
  }

  public Long getP210() {
    return p210;
  }

  public void setP210(Long p210) {
    this.p210 = p210;
  }

  public Long getP211() {
    return p211;
  }

  public void setP211(Long p211) {
    this.p211 = p211;
  }

  public Long getP212() {
    return p212;
  }

  public void setP212(Long p212) {
    this.p212 = p212;
  }

  public Long getP213() {
    return p213;
  }

  public void setP213(Long p213) {
    this.p213 = p213;
  }

  public Long getP214() {
    return p214;
  }

  public void setP214(Long p214) {
    this.p214 = p214;
  }

  public Long getP215() {
    return p215;
  }

  public void setP215(Long p215) {
    this.p215 = p215;
  }

  public Long getP216() {
    return p216;
  }

  public void setP216(Long p216) {
    this.p216 = p216;
  }

  public Long getP217() {
    return p217;
  }

  public void setP217(Long p217) {
    this.p217 = p217;
  }

  public Long getP218() {
    return p218;
  }

  public void setP218(Long p218) {
    this.p218 = p218;
  }

  public Long getP219() {
    return p219;
  }

  public void setP219(Long p219) {
    this.p219 = p219;
  }

  public Long getP220() {
    return p220;
  }

  public void setP220(Long p220) {
    this.p220 = p220;
  }

  public Long getP221() {
    return p221;
  }

  public void setP221(Long p221) {
    this.p221 = p221;
  }

  public Long getP222() {
    return p222;
  }

  public void setP222(Long p222) {
    this.p222 = p222;
  }

  public Long getP223() {
    return p223;
  }

  public void setP223(Long p223) {
    this.p223 = p223;
  }

  public Long getP224() {
    return p224;
  }

  public void setP224(Long p224) {
    this.p224 = p224;
  }

  public Long getP225() {
    return p225;
  }

  public void setP225(Long p225) {
    this.p225 = p225;
  }

  public Long getP301() {
    return p301;
  }

  public void setP301(Long p301) {
    this.p301 = p301;
  }

  public Long getP302() {
    return p302;
  }

  public void setP302(Long p302) {
    this.p302 = p302;
  }

  public Long getP303() {
    return p303;
  }

  public void setP303(Long p303) {
    this.p303 = p303;
  }

  public Long getP304() {
    return p304;
  }

  public void setP304(Long p304) {
    this.p304 = p304;
  }

  public Long getP305() {
    return p305;
  }

  public void setP305(Long p305) {
    this.p305 = p305;
  }

  public Long getP306() {
    return p306;
  }

  public void setP306(Long p306) {
    this.p306 = p306;
  }

  public Long getP307() {
    return p307;
  }

  public void setP307(Long p307) {
    this.p307 = p307;
  }

  public Long getP308() {
    return p308;
  }

  public void setP308(Long p308) {
    this.p308 = p308;
  }

  public Long getP309() {
    return p309;
  }

  public void setP309(Long p309) {
    this.p309 = p309;
  }

  public Long getP310() {
    return p310;
  }

  public void setP310(Long p310) {
    this.p310 = p310;
  }

  public Long getP311() {
    return p311;
  }

  public void setP311(Long p311) {
    this.p311 = p311;
  }

  public Long getP312() {
    return p312;
  }

  public void setP312(Long p312) {
    this.p312 = p312;
  }

  public Long getP313() {
    return p313;
  }

  public void setP313(Long p313) {
    this.p313 = p313;
  }

  public Long getP314() {
    return p314;
  }

  public void setP314(Long p314) {
    this.p314 = p314;
  }

  public Long getP401() {
    return p401;
  }

  public void setP401(Long p401) {
    this.p401 = p401;
  }

  public Long getP402() {
    return p402;
  }

  public void setP402(Long p402) {
    this.p402 = p402;
  }

  public Long getP403() {
    return p403;
  }

  public void setP403(Long p403) {
    this.p403 = p403;
  }

  public Long getP404() {
    return p404;
  }

  public void setP404(Long p404) {
    this.p404 = p404;
  }

  public Long getP405() {
    return p405;
  }

  public void setP405(Long p405) {
    this.p405 = p405;
  }

  public Long getP406() {
    return p406;
  }

  public void setP406(Long p406) {
    this.p406 = p406;
  }

  public Long getP501() {
    return p501;
  }

  public void setP501(Long p501) {
    this.p501 = p501;
  }

  public Long getP502() {
    return p502;
  }

  public void setP502(Long p502) {
    this.p502 = p502;
  }

  public Long getP503() {
    return p503;
  }

  public void setP503(Long p503) {
    this.p503 = p503;
  }

  public Long getP504() {
    return p504;
  }

  public void setP504(Long p504) {
    this.p504 = p504;
  }

  public Long getP505() {
    return p505;
  }

  public void setP505(Long p505) {
    this.p505 = p505;
  }

  public Long getP506() {
    return p506;
  }

  public void setP506(Long p506) {
    this.p506 = p506;
  }

  public Long getP507() {
    return p507;
  }

  public void setP507(Long p507) {
    this.p507 = p507;
  }

  public Long getP508() {
    return p508;
  }

  public void setP508(Long p508) {
    this.p508 = p508;
  }

  public Long getP509() {
    return p509;
  }

  public void setP509(Long p509) {
    this.p509 = p509;
  }

  public Long getP601() {
    return p601;
  }

  public void setP601(Long p601) {
    this.p601 = p601;
  }

  public Long getP602() {
    return p602;
  }

  public void setP602(Long p602) {
    this.p602 = p602;
  }

  public Long getP603() {
    return p603;
  }

  public void setP603(Long p603) {
    this.p603 = p603;
  }

  public Long getP604() {
    return p604;
  }

  public void setP604(Long p604) {
    this.p604 = p604;
  }

  public Long getP605() {
    return p605;
  }

  public void setP605(Long p605) {
    this.p605 = p605;
  }

  public Long getP606() {
    return p606;
  }

  public void setP606(Long p606) {
    this.p606 = p606;
  }

  public Long getP607() {
    return p607;
  }

  public void setP607(Long p607) {
    this.p607 = p607;
  }

  public Long getP701() {
    return p701;
  }

  public void setP701(Long p701) {
    this.p701 = p701;
  }

  public Long getP702() {
    return p702;
  }

  public void setP702(Long p702) {
    this.p702 = p702;
  }

  public Long getP703() {
    return p703;
  }

  public void setP703(Long p703) {
    this.p703 = p703;
  }

  public Long getP704() {
    return p704;
  }

  public void setP704(Long p704) {
    this.p704 = p704;
  }

  public Long getP705() {
    return p705;
  }

  public void setP705(Long p705) {
    this.p705 = p705;
  }

  public Long getP706() {
    return p706;
  }

  public void setP706(Long p706) {
    this.p706 = p706;
  }

  public Long getP707() {
    return p707;
  }

  public void setP707(Long p707) {
    this.p707 = p707;
  }

  public String getChecktype() {
    return checktype;
  }

  public void setChecktype(String checktype) {
    this.checktype = checktype;
  }

  public Long getProjectinfoid() {
    return projectinfoid;
  }

  public void setProjectinfoid(Long projectinfoid) {
    this.projectinfoid = projectinfoid;
  }

  public String getProjectmanager() {
    return projectmanager;
  }

  public void setProjectmanager(String projectmanager) {
    this.projectmanager = projectmanager;
  }

  public Long getRowstamp() {
    return rowstamp;
  }

  public void setRowstamp(Long rowstamp) {
    this.rowstamp = rowstamp;
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

  public String getPromanager() {
    return promanager;
  }

  public void setPromanager(String promanager) {
    this.promanager = promanager;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getNowman() {
    return nowman;
  }

  public void setNowman(String nowman) {
    this.nowman = nowman;
  }

  public String getScnum() {
    return scnum;
  }

  public void setScnum(String scnum) {
    this.scnum = scnum;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
