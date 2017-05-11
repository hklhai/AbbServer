package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@Table(name="Item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITEM_ITEMID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_ITEMID_GENERATOR")
	private long itemid;

	private Integer attachonissue;

	private Integer capitalized;

	private String classstructureid;

	private String commodity;

	private String commoditygroup;

	private Integer conditionenabled;

	private String description;

	private String externalrefid;

	private String groupname;

	private Integer hardresissue;

	private Integer hasld;

	private String in19;

	private String in20;

	private String in21;

	private Timestamp in22;

	private BigDecimal in23;

	private String in24;

	private String in25;

	private String in26;

	private String in27;

	private Integer inspectionrequired;

	private Integer iscrew;

	private Integer iskit;

	private String issueunit;

	private String itemnum;

	private String itemsetid;

	private String itemtype;

	private String langcode;

	private String lottype;

	private BigDecimal maxissue;

	private String metername;

	private String msdsnum;

	private String orderunit;

	private Integer outside;

	private String ownersysid;

	private Integer pluscisinhousecal;

	private Integer pluscismte;

	private String pluscismteclass;

	private Integer pluscsolution;

	private Integer prorate;

	private BigDecimal receipttolerance;

	private Integer rotating;

	private long rowstamp;

	private String sendersysid;

	private String sourcesysid;

	private Integer sparepartautoadd;

	@Column(name="\"STATUS\"")
	private String status;

	private Timestamp statusdate;

	private Integer taxexempt;

	private String udapptype;

	private String udmaterialsecond;

	private String udmaterialtype;

	private String udmeasureunit;

	private String udmodel;

	private String udsapnum;

	public Item() {
	}

	public long getItemid() {
		return this.itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public Integer getAttachonissue() {
		return this.attachonissue;
	}

	public void setAttachonissue(Integer attachonissue) {
		this.attachonissue = attachonissue;
	}

	public Integer getCapitalized() {
		return this.capitalized;
	}

	public void setCapitalized(Integer capitalized) {
		this.capitalized = capitalized;
	}

	public String getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getCommodity() {
		return this.commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getCommoditygroup() {
		return this.commoditygroup;
	}

	public void setCommoditygroup(String commoditygroup) {
		this.commoditygroup = commoditygroup;
	}

	public Integer getConditionenabled() {
		return this.conditionenabled;
	}

	public void setConditionenabled(Integer conditionenabled) {
		this.conditionenabled = conditionenabled;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Integer getHardresissue() {
		return this.hardresissue;
	}

	public void setHardresissue(Integer hardresissue) {
		this.hardresissue = hardresissue;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public String getIn19() {
		return this.in19;
	}

	public void setIn19(String in19) {
		this.in19 = in19;
	}

	public String getIn20() {
		return this.in20;
	}

	public void setIn20(String in20) {
		this.in20 = in20;
	}

	public String getIn21() {
		return this.in21;
	}

	public void setIn21(String in21) {
		this.in21 = in21;
	}

	public Timestamp getIn22() {
		return this.in22;
	}

	public void setIn22(Timestamp in22) {
		this.in22 = in22;
	}

	public BigDecimal getIn23() {
		return this.in23;
	}

	public void setIn23(BigDecimal in23) {
		this.in23 = in23;
	}

	public String getIn24() {
		return this.in24;
	}

	public void setIn24(String in24) {
		this.in24 = in24;
	}

	public String getIn25() {
		return this.in25;
	}

	public void setIn25(String in25) {
		this.in25 = in25;
	}

	public String getIn26() {
		return this.in26;
	}

	public void setIn26(String in26) {
		this.in26 = in26;
	}

	public String getIn27() {
		return this.in27;
	}

	public void setIn27(String in27) {
		this.in27 = in27;
	}

	public Integer getInspectionrequired() {
		return this.inspectionrequired;
	}

	public void setInspectionrequired(Integer inspectionrequired) {
		this.inspectionrequired = inspectionrequired;
	}

	public Integer getIscrew() {
		return this.iscrew;
	}

	public void setIscrew(Integer iscrew) {
		this.iscrew = iscrew;
	}

	public Integer getIskit() {
		return this.iskit;
	}

	public void setIskit(Integer iskit) {
		this.iskit = iskit;
	}

	public String getIssueunit() {
		return this.issueunit;
	}

	public void setIssueunit(String issueunit) {
		this.issueunit = issueunit;
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

	public String getLottype() {
		return this.lottype;
	}

	public void setLottype(String lottype) {
		this.lottype = lottype;
	}

	public BigDecimal getMaxissue() {
		return this.maxissue;
	}

	public void setMaxissue(BigDecimal maxissue) {
		this.maxissue = maxissue;
	}

	public String getMetername() {
		return this.metername;
	}

	public void setMetername(String metername) {
		this.metername = metername;
	}

	public String getMsdsnum() {
		return this.msdsnum;
	}

	public void setMsdsnum(String msdsnum) {
		this.msdsnum = msdsnum;
	}

	public String getOrderunit() {
		return this.orderunit;
	}

	public void setOrderunit(String orderunit) {
		this.orderunit = orderunit;
	}

	public Integer getOutside() {
		return this.outside;
	}

	public void setOutside(Integer outside) {
		this.outside = outside;
	}

	public String getOwnersysid() {
		return this.ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
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

	public Integer getPluscsolution() {
		return this.pluscsolution;
	}

	public void setPluscsolution(Integer pluscsolution) {
		this.pluscsolution = pluscsolution;
	}

	public Integer getProrate() {
		return this.prorate;
	}

	public void setProrate(Integer prorate) {
		this.prorate = prorate;
	}

	public BigDecimal getReceipttolerance() {
		return this.receipttolerance;
	}

	public void setReceipttolerance(BigDecimal receipttolerance) {
		this.receipttolerance = receipttolerance;
	}

	public Integer getRotating() {
		return this.rotating;
	}

	public void setRotating(Integer rotating) {
		this.rotating = rotating;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSendersysid() {
		return this.sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getSourcesysid() {
		return this.sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public Integer getSparepartautoadd() {
		return this.sparepartautoadd;
	}

	public void setSparepartautoadd(Integer sparepartautoadd) {
		this.sparepartautoadd = sparepartautoadd;
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

	public Integer getTaxexempt() {
		return this.taxexempt;
	}

	public void setTaxexempt(Integer taxexempt) {
		this.taxexempt = taxexempt;
	}

	public String getUdapptype() {
		return this.udapptype;
	}

	public void setUdapptype(String udapptype) {
		this.udapptype = udapptype;
	}

	public String getUdmaterialsecond() {
		return this.udmaterialsecond;
	}

	public void setUdmaterialsecond(String udmaterialsecond) {
		this.udmaterialsecond = udmaterialsecond;
	}

	public String getUdmaterialtype() {
		return this.udmaterialtype;
	}

	public void setUdmaterialtype(String udmaterialtype) {
		this.udmaterialtype = udmaterialtype;
	}

	public String getUdmeasureunit() {
		return this.udmeasureunit;
	}

	public void setUdmeasureunit(String udmeasureunit) {
		this.udmeasureunit = udmeasureunit;
	}

	public String getUdmodel() {
		return this.udmodel;
	}

	public void setUdmodel(String udmodel) {
		this.udmodel = udmodel;
	}

	public String getUdsapnum() {
		return this.udsapnum;
	}

	public void setUdsapnum(String udsapnum) {
		this.udsapnum = udsapnum;
	}

}