package com.hxqh.abb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the ASSET database table.
 * 
 */
@Entity
@Table(name="Asset")
public class Asset  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSET_ASSETUID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSET_ASSETUID_GENERATOR")
	private long assetuid;

	private String ancestor;

	private long assetid;

	private String assetnum;

	private String assettag;

	private String assettype;

	private Integer autowogen;

	private String binnum;

	private BigDecimal budgetcost;

	private String calnum;

	private String changeby;

	private Timestamp changedate;

	private Integer children;

	private String classstructureid;

	private String conditioncode;

	private String defaultrepfac;

	private String defaultrepfacsiteid;

	private String description;

	private String direction;

	private Integer disabled;

	private String enddescription;

	private BigDecimal endmeasure;

	private String eq1;

	private String eq10;

	private String eq11;

	private BigDecimal eq12;

	private String eq2;

	private Timestamp eq23;

	private BigDecimal eq24;

	private String eq3;

	private String eq4;

	private BigDecimal eq5;

	private Timestamp eq6;

	private BigDecimal eq7;

	private String eq8;

	private String eq9;

	private String externalrefid;

	private String failurecode;

	private String glaccount;

	private String groupname;

	private Integer hasld;

	@Temporal(TemporalType.DATE)
	private Date installdate;

	private BigDecimal invcost;

	private Integer iscalibration;

	private Integer islinear;

	private Integer isrunning;

	private String itemnum;

	private String itemsetid;

	private String itemtype;

	private String langcode;

	@Column(name="\"LOCATION\"")
	private String location;

	private String lrm;

	//private Integer maIntegerhierchy;

	private String manufacturer;

	private Integer moved;

	private String orgid;

	private String ownersysid;

	@Column(name="\"PARENT\"")
	private String parent;

	private String pluscassetdept;

	private String pluscclass;

	private Timestamp pluscduedate;

	private String plusciscondesc;

	private Integer plusciscontam;

	private Integer pluscisinhousecal;

	private Integer pluscismte;

	private String pluscismteclass;

	private String pluscloopnum;

	private String plusclploc;

	private String pluscmodelnum;

	private String pluscoprgeeu;

	private String pluscoprgefrom;

	private String pluscoprgeto;

	private String pluscphyloc;

	private Integer pluscpmextdate;

	private Integer pluscsolution;

	private String pluscsumdir;

	private String pluscsumeu;

	private String pluscsumread;

	private String pluscsumspan;

	private String pluscsumurv;

	private String pluscvendor;

	@Column(name="\"PRIORITY\"")
	private Integer priority;

	private BigDecimal purchaseprice;

	private BigDecimal replacecost;

	private Integer returnedtovendor;

	private String rotsuspacct;

	private long rowstamp;

	private String saddresscode;

	private String sendersysid;

	private String serialnum;

	private String shiftnum;

	private String siteid;

	private String sourcesysid;

	private String startdescription;

	private BigDecimal startmeasure;

	@Column(name="\"STATE\"")
	private String state;

	@Column(name="\"STATUS\"")
	private String status;

	private Timestamp statusdate;

	private String templateid;

	private String tloamhash;

	private Integer tloampartition;

	private String toolcontrolaccount;

	private BigDecimal toolrate;

	private BigDecimal totalcost;

	private double totdowntime;

	private BigDecimal totunchargedcost;

	private String udbelong;

	private String udcontract;

	private String udmodel;

	private Integer udserialnumivd4;

	private BigDecimal unchargedcost;

	@Column(name="\"USAGE\"")
	private String usage;

	private String vendor;

	@Temporal(TemporalType.DATE)
	private Date warrantyexpdate;

	private BigDecimal ytdcost;

	public Asset() {
	}

	public long getAssetuid() {
		return this.assetuid;
	}

	public void setAssetuid(long assetuid) {
		this.assetuid = assetuid;
	}

	public String getAncestor() {
		return this.ancestor;
	}

	public void setAncestor(String ancestor) {
		this.ancestor = ancestor;
	}

	public long getAssetid() {
		return this.assetid;
	}

	public void setAssetid(long assetid) {
		this.assetid = assetid;
	}

	public String getAssetnum() {
		return this.assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getAssettag() {
		return this.assettag;
	}

	public void setAssettag(String assettag) {
		this.assettag = assettag;
	}

	public String getAssettype() {
		return this.assettype;
	}

	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}

	public Integer getAutowogen() {
		return this.autowogen;
	}

	public void setAutowogen(Integer autowogen) {
		this.autowogen = autowogen;
	}

	public String getBinnum() {
		return this.binnum;
	}

	public void setBinnum(String binnum) {
		this.binnum = binnum;
	}

	public BigDecimal getBudgetcost() {
		return this.budgetcost;
	}

	public void setBudgetcost(BigDecimal budgetcost) {
		this.budgetcost = budgetcost;
	}

	public String getCalnum() {
		return this.calnum;
	}

	public void setCalnum(String calnum) {
		this.calnum = calnum;
	}

	public String getChangeby() {
		return this.changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Timestamp getChangedate() {
		return this.changedate;
	}

	public void setChangedate(Timestamp changedate) {
		this.changedate = changedate;
	}

	public Integer getChildren() {
		return this.children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public String getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getConditioncode() {
		return this.conditioncode;
	}

	public void setConditioncode(String conditioncode) {
		this.conditioncode = conditioncode;
	}

	public String getDefaultrepfac() {
		return this.defaultrepfac;
	}

	public void setDefaultrepfac(String defaultrepfac) {
		this.defaultrepfac = defaultrepfac;
	}

	public String getDefaultrepfacsiteid() {
		return this.defaultrepfacsiteid;
	}

	public void setDefaultrepfacsiteid(String defaultrepfacsiteid) {
		this.defaultrepfacsiteid = defaultrepfacsiteid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public String getEnddescription() {
		return this.enddescription;
	}

	public void setEnddescription(String enddescription) {
		this.enddescription = enddescription;
	}

	public BigDecimal getEndmeasure() {
		return this.endmeasure;
	}

	public void setEndmeasure(BigDecimal endmeasure) {
		this.endmeasure = endmeasure;
	}

	public String getEq1() {
		return this.eq1;
	}

	public void setEq1(String eq1) {
		this.eq1 = eq1;
	}

	public String getEq10() {
		return this.eq10;
	}

	public void setEq10(String eq10) {
		this.eq10 = eq10;
	}

	public String getEq11() {
		return this.eq11;
	}

	public void setEq11(String eq11) {
		this.eq11 = eq11;
	}

	public BigDecimal getEq12() {
		return this.eq12;
	}

	public void setEq12(BigDecimal eq12) {
		this.eq12 = eq12;
	}

	public String getEq2() {
		return this.eq2;
	}

	public void setEq2(String eq2) {
		this.eq2 = eq2;
	}

	public Timestamp getEq23() {
		return this.eq23;
	}

	public void setEq23(Timestamp eq23) {
		this.eq23 = eq23;
	}

	public BigDecimal getEq24() {
		return this.eq24;
	}

	public void setEq24(BigDecimal eq24) {
		this.eq24 = eq24;
	}

	public String getEq3() {
		return this.eq3;
	}

	public void setEq3(String eq3) {
		this.eq3 = eq3;
	}

	public String getEq4() {
		return this.eq4;
	}

	public void setEq4(String eq4) {
		this.eq4 = eq4;
	}

	public BigDecimal getEq5() {
		return this.eq5;
	}

	public void setEq5(BigDecimal eq5) {
		this.eq5 = eq5;
	}

	public Timestamp getEq6() {
		return this.eq6;
	}

	public void setEq6(Timestamp eq6) {
		this.eq6 = eq6;
	}

	public BigDecimal getEq7() {
		return this.eq7;
	}

	public void setEq7(BigDecimal eq7) {
		this.eq7 = eq7;
	}

	public String getEq8() {
		return this.eq8;
	}

	public void setEq8(String eq8) {
		this.eq8 = eq8;
	}

	public String getEq9() {
		return this.eq9;
	}

	public void setEq9(String eq9) {
		this.eq9 = eq9;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getFailurecode() {
		return this.failurecode;
	}

	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}

	public String getGlaccount() {
		return this.glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public Date getInstalldate() {
		return this.installdate;
	}

	public void setInstalldate(Date installdate) {
		this.installdate = installdate;
	}

	public BigDecimal getInvcost() {
		return this.invcost;
	}

	public void setInvcost(BigDecimal invcost) {
		this.invcost = invcost;
	}

	public Integer getIscalibration() {
		return this.iscalibration;
	}

	public void setIscalibration(Integer iscalibration) {
		this.iscalibration = iscalibration;
	}

	public Integer getIslinear() {
		return this.islinear;
	}

	public void setIslinear(Integer islinear) {
		this.islinear = islinear;
	}

	public Integer getIsrunning() {
		return this.isrunning;
	}

	public void setIsrunning(Integer isrunning) {
		this.isrunning = isrunning;
	}

	public String getItemnum() {
		return this.itemnum;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	public String getItemsetid() {
		return this.itemsetid;
	}

	public void setItemsetid(String itemsetid) {
		this.itemsetid = itemsetid;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLrm() {
		return this.lrm;
	}

	public void setLrm(String lrm) {
		this.lrm = lrm;
	}

//	public Integer getMaIntegerhierchy() {
//		return this.maIntegerhierchy;
//	}
//
//	public void setMaIntegerhierchy(Integer maIntegerhierchy) {
//		this.maIntegerhierchy = maIntegerhierchy;
//	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getMoved() {
		return this.moved;
	}

	public void setMoved(Integer moved) {
		this.moved = moved;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOwnersysid() {
		return this.ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getPluscassetdept() {
		return this.pluscassetdept;
	}

	public void setPluscassetdept(String pluscassetdept) {
		this.pluscassetdept = pluscassetdept;
	}

	public String getPluscclass() {
		return this.pluscclass;
	}

	public void setPluscclass(String pluscclass) {
		this.pluscclass = pluscclass;
	}

	public Timestamp getPluscduedate() {
		return this.pluscduedate;
	}

	public void setPluscduedate(Timestamp pluscduedate) {
		this.pluscduedate = pluscduedate;
	}

	public String getPlusciscondesc() {
		return this.plusciscondesc;
	}

	public void setPlusciscondesc(String plusciscondesc) {
		this.plusciscondesc = plusciscondesc;
	}

	public Integer getPlusciscontam() {
		return this.plusciscontam;
	}

	public void setPlusciscontam(Integer plusciscontam) {
		this.plusciscontam = plusciscontam;
	}

	public Integer getPluscisinhousecal() {
		return this.pluscisinhousecal;
	}

	public void setPluscisinhousecal(Integer pluscisinhousecal) {
		this.pluscisinhousecal = pluscisinhousecal;
	}

	public Integer getPluscismte() {
		return this.pluscismte;
	}

	public void setPluscismte(Integer pluscismte) {
		this.pluscismte = pluscismte;
	}

	public String getPluscismteclass() {
		return this.pluscismteclass;
	}

	public void setPluscismteclass(String pluscismteclass) {
		this.pluscismteclass = pluscismteclass;
	}

	public String getPluscloopnum() {
		return this.pluscloopnum;
	}

	public void setPluscloopnum(String pluscloopnum) {
		this.pluscloopnum = pluscloopnum;
	}

	public String getPlusclploc() {
		return this.plusclploc;
	}

	public void setPlusclploc(String plusclploc) {
		this.plusclploc = plusclploc;
	}

	public String getPluscmodelnum() {
		return this.pluscmodelnum;
	}

	public void setPluscmodelnum(String pluscmodelnum) {
		this.pluscmodelnum = pluscmodelnum;
	}

	public String getPluscoprgeeu() {
		return this.pluscoprgeeu;
	}

	public void setPluscoprgeeu(String pluscoprgeeu) {
		this.pluscoprgeeu = pluscoprgeeu;
	}

	public String getPluscoprgefrom() {
		return this.pluscoprgefrom;
	}

	public void setPluscoprgefrom(String pluscoprgefrom) {
		this.pluscoprgefrom = pluscoprgefrom;
	}

	public String getPluscoprgeto() {
		return this.pluscoprgeto;
	}

	public void setPluscoprgeto(String pluscoprgeto) {
		this.pluscoprgeto = pluscoprgeto;
	}

	public String getPluscphyloc() {
		return this.pluscphyloc;
	}

	public void setPluscphyloc(String pluscphyloc) {
		this.pluscphyloc = pluscphyloc;
	}

	public Integer getPluscpmextdate() {
		return this.pluscpmextdate;
	}

	public void setPluscpmextdate(Integer pluscpmextdate) {
		this.pluscpmextdate = pluscpmextdate;
	}

	public Integer getPluscsolution() {
		return this.pluscsolution;
	}

	public void setPluscsolution(Integer pluscsolution) {
		this.pluscsolution = pluscsolution;
	}

	public String getPluscsumdir() {
		return this.pluscsumdir;
	}

	public void setPluscsumdir(String pluscsumdir) {
		this.pluscsumdir = pluscsumdir;
	}

	public String getPluscsumeu() {
		return this.pluscsumeu;
	}

	public void setPluscsumeu(String pluscsumeu) {
		this.pluscsumeu = pluscsumeu;
	}

	public String getPluscsumread() {
		return this.pluscsumread;
	}

	public void setPluscsumread(String pluscsumread) {
		this.pluscsumread = pluscsumread;
	}

	public String getPluscsumspan() {
		return this.pluscsumspan;
	}

	public void setPluscsumspan(String pluscsumspan) {
		this.pluscsumspan = pluscsumspan;
	}

	public String getPluscsumurv() {
		return this.pluscsumurv;
	}

	public void setPluscsumurv(String pluscsumurv) {
		this.pluscsumurv = pluscsumurv;
	}

	public String getPluscvendor() {
		return this.pluscvendor;
	}

	public void setPluscvendor(String pluscvendor) {
		this.pluscvendor = pluscvendor;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPurchaseprice() {
		return this.purchaseprice;
	}

	public void setPurchaseprice(BigDecimal purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public BigDecimal getReplacecost() {
		return this.replacecost;
	}

	public void setReplacecost(BigDecimal replacecost) {
		this.replacecost = replacecost;
	}

	public Integer getReturnedtovendor() {
		return this.returnedtovendor;
	}

	public void setReturnedtovendor(Integer returnedtovendor) {
		this.returnedtovendor = returnedtovendor;
	}

	public String getRotsuspacct() {
		return this.rotsuspacct;
	}

	public void setRotsuspacct(String rotsuspacct) {
		this.rotsuspacct = rotsuspacct;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSaddresscode() {
		return this.saddresscode;
	}

	public void setSaddresscode(String saddresscode) {
		this.saddresscode = saddresscode;
	}

	public String getSendersysid() {
		return this.sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getSerialnum() {
		return this.serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getShiftnum() {
		return this.shiftnum;
	}

	public void setShiftnum(String shiftnum) {
		this.shiftnum = shiftnum;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getSourcesysid() {
		return this.sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public String getStartdescription() {
		return this.startdescription;
	}

	public void setStartdescription(String startdescription) {
		this.startdescription = startdescription;
	}

	public BigDecimal getStartmeasure() {
		return this.startmeasure;
	}

	public void setStartmeasure(BigDecimal startmeasure) {
		this.startmeasure = startmeasure;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Timestamp statusdate) {
		this.statusdate = statusdate;
	}

	public String getTemplateid() {
		return this.templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getTloamhash() {
		return this.tloamhash;
	}

	public void setTloamhash(String tloamhash) {
		this.tloamhash = tloamhash;
	}

	public Integer getTloampartition() {
		return this.tloampartition;
	}

	public void setTloampartition(Integer tloampartition) {
		this.tloampartition = tloampartition;
	}

	public String getToolcontrolaccount() {
		return this.toolcontrolaccount;
	}

	public void setToolcontrolaccount(String toolcontrolaccount) {
		this.toolcontrolaccount = toolcontrolaccount;
	}

	public BigDecimal getToolrate() {
		return this.toolrate;
	}

	public void setToolrate(BigDecimal toolrate) {
		this.toolrate = toolrate;
	}

	public BigDecimal getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(BigDecimal totalcost) {
		this.totalcost = totalcost;
	}

	public double getTotdowntime() {
		return this.totdowntime;
	}

	public void setTotdowntime(double totdowntime) {
		this.totdowntime = totdowntime;
	}

	public BigDecimal getTotunchargedcost() {
		return this.totunchargedcost;
	}

	public void setTotunchargedcost(BigDecimal totunchargedcost) {
		this.totunchargedcost = totunchargedcost;
	}

	public String getUdbelong() {
		return this.udbelong;
	}

	public void setUdbelong(String udbelong) {
		this.udbelong = udbelong;
	}

	public String getUdcontract() {
		return this.udcontract;
	}

	public void setUdcontract(String udcontract) {
		this.udcontract = udcontract;
	}

	public String getUdmodel() {
		return this.udmodel;
	}

	public void setUdmodel(String udmodel) {
		this.udmodel = udmodel;
	}

	public Integer getUdserialnumivd4() {
		return this.udserialnumivd4;
	}

	public void setUdserialnumivd4(Integer udserialnumivd4) {
		this.udserialnumivd4 = udserialnumivd4;
	}

	public BigDecimal getUnchargedcost() {
		return this.unchargedcost;
	}

	public void setUnchargedcost(BigDecimal unchargedcost) {
		this.unchargedcost = unchargedcost;
	}

	public String getUsage() {
		return this.usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getWarrantyexpdate() {
		return this.warrantyexpdate;
	}

	public void setWarrantyexpdate(Date warrantyexpdate) {
		this.warrantyexpdate = warrantyexpdate;
	}

	public BigDecimal getYtdcost() {
		return this.ytdcost;
	}

	public void setYtdcost(BigDecimal ytdcost) {
		this.ytdcost = ytdcost;
	}

}