package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


/**
 * The persistent class for the INVUSELINE database table.
 * 
 */
@Entity
@Table(name="Invuseline")
public class Invuseline implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVUSELINE_INVUSELINEID_GENERATOR", sequenceName="INVUSELINESEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVUSELINE_INVUSELINEID_GENERATOR")
	private Long invuselineid;

	private Date actualdate;

	private String assetnum;

	private String commodity;

	private String commoditygroup;

	private BigDecimal conversion;

	private String description;

	private String enterby;

	private Integer enteredastask;

	private String financialperiod;

	private String frombin;

	private String fromconditioncode;

	private String fromlot;

	private String fromstoreloc;

	private String glcreditacct;

	private String gldebitacct;

	private Integer hasld;

	private Integer inspectionrequired;

	private Integer invuselinenum;

	private String invusenum;

	private Long issueid;

	private String issueto;

	private String itemnum;

	private String itemsetid;

	private String langcode;

	private BigDecimal linecost;

	private String linenum;

	private String linetype;

	@Column(name="\"LOCATION\"")
	private String location;

	private Integer mrlinenum;

	private String mrnum;

	private String newassetnum;

	private String orgid;

	private BigDecimal physcnt;

	private Date physcntdate;

	private Integer polinenum;

	private String ponum;

	private Integer porevisionnum;

	private String positeid;

	private String prsiteid;

	private BigDecimal quantity;

	private Integer receiptscomplete;

	private BigDecimal receivedqty;

	private String refwo;

	private String remark;

	private String requestnum;

	private Integer returnagainstissue;

	private BigDecimal returnedqty;

	private String rotassetnum;

	private Long rowstamp;

	private String sendersysid;

	private String siteid;

	@Column(name="\"SPLIT\"")
	private Integer split;

	private String tobin;

	private String toconditioncode;

	private String tolot;

	private String toorgid;

	private String tositeid;

	private String tostoreloc;

	private String udcontact;

	private String udprojectnum;

	private String udreceipt;

	private String udrecipient;

	private String udsapnum;

	private String udwonum2;

	private BigDecimal unitcost;

	private String usetype;

	@Column(name="\"VALIDATED\"")
	private Integer validated;

	public Invuseline() {
	}

	public Long getInvuselineid() {
		return this.invuselineid;
	}

	public void setInvuselineid(Long invuselineid) {
		this.invuselineid = invuselineid;
	}

	public Date getActualdate() {
		return this.actualdate;
	}

	public void setActualdate(Date actualdate) {
		this.actualdate = actualdate;
	}

	public String getAssetnum() {
		return this.assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
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

	public BigDecimal getConversion() {
		return this.conversion;
	}

	public void setConversion(BigDecimal conversion) {
		this.conversion = conversion;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnterby() {
		return this.enterby;
	}

	public void setEnterby(String enterby) {
		this.enterby = enterby;
	}

	public Integer getEnteredastask() {
		return this.enteredastask;
	}

	public void setEnteredastask(Integer enteredastask) {
		this.enteredastask = enteredastask;
	}

	public String getFinancialperiod() {
		return this.financialperiod;
	}

	public void setFinancialperiod(String financialperiod) {
		this.financialperiod = financialperiod;
	}

	public String getFrombin() {
		return this.frombin;
	}

	public void setFrombin(String frombin) {
		this.frombin = frombin;
	}

	public String getFromconditioncode() {
		return this.fromconditioncode;
	}

	public void setFromconditioncode(String fromconditioncode) {
		this.fromconditioncode = fromconditioncode;
	}

	public String getFromlot() {
		return this.fromlot;
	}

	public void setFromlot(String fromlot) {
		this.fromlot = fromlot;
	}

	public String getFromstoreloc() {
		return this.fromstoreloc;
	}

	public void setFromstoreloc(String fromstoreloc) {
		this.fromstoreloc = fromstoreloc;
	}

	public String getGlcreditacct() {
		return this.glcreditacct;
	}

	public void setGlcreditacct(String glcreditacct) {
		this.glcreditacct = glcreditacct;
	}

	public String getGldebitacct() {
		return this.gldebitacct;
	}

	public void setGldebitacct(String gldebitacct) {
		this.gldebitacct = gldebitacct;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public Integer getInspectionrequired() {
		return this.inspectionrequired;
	}

	public void setInspectionrequired(Integer inspectionrequired) {
		this.inspectionrequired = inspectionrequired;
	}

	public Integer getInvuselinenum() {
		return this.invuselinenum;
	}

	public void setInvuselinenum(Integer invuselinenum) {
		this.invuselinenum = invuselinenum;
	}

	public String getInvusenum() {
		return this.invusenum;
	}

	public void setInvusenum(String invusenum) {
		this.invusenum = invusenum;
	}

	public Long getIssueid() {
		return this.issueid;
	}

	public void setIssueid(Long issueid) {
		this.issueid = issueid;
	}

	public String getIssueto() {
		return this.issueto;
	}

	public void setIssueto(String issueto) {
		this.issueto = issueto;
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

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public BigDecimal getLinecost() {
		return this.linecost;
	}

	public void setLinecost(BigDecimal linecost) {
		this.linecost = linecost;
	}

	public String getLinenum() {
		return this.linenum;
	}

	public void setLinenum(String linenum) {
		this.linenum = linenum;
	}

	public String getLinetype() {
		return this.linetype;
	}

	public void setLinetype(String linetype) {
		this.linetype = linetype;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getMrlinenum() {
		return this.mrlinenum;
	}

	public void setMrlinenum(Integer mrlinenum) {
		this.mrlinenum = mrlinenum;
	}

	public String getMrnum() {
		return this.mrnum;
	}

	public void setMrnum(String mrnum) {
		this.mrnum = mrnum;
	}

	public String getNewassetnum() {
		return this.newassetnum;
	}

	public void setNewassetnum(String newassetnum) {
		this.newassetnum = newassetnum;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public BigDecimal getPhyscnt() {
		return this.physcnt;
	}

	public void setPhyscnt(BigDecimal physcnt) {
		this.physcnt = physcnt;
	}

	public Date getPhyscntdate() {
		return this.physcntdate;
	}

	public void setPhyscntdate(Date physcntdate) {
		this.physcntdate = physcntdate;
	}

	public Integer getPolinenum() {
		return this.polinenum;
	}

	public void setPolinenum(Integer polinenum) {
		this.polinenum = polinenum;
	}

	public String getPonum() {
		return this.ponum;
	}

	public void setPonum(String ponum) {
		this.ponum = ponum;
	}

	public Integer getPorevisionnum() {
		return this.porevisionnum;
	}

	public void setPorevisionnum(Integer porevisionnum) {
		this.porevisionnum = porevisionnum;
	}

	public String getPositeid() {
		return this.positeid;
	}

	public void setPositeid(String positeid) {
		this.positeid = positeid;
	}

	public String getPrsiteid() {
		return this.prsiteid;
	}

	public void setPrsiteid(String prsiteid) {
		this.prsiteid = prsiteid;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Integer getReceiptscomplete() {
		return this.receiptscomplete;
	}

	public void setReceiptscomplete(Integer receiptscomplete) {
		this.receiptscomplete = receiptscomplete;
	}

	public BigDecimal getReceivedqty() {
		return this.receivedqty;
	}

	public void setReceivedqty(BigDecimal receivedqty) {
		this.receivedqty = receivedqty;
	}

	public String getRefwo() {
		return this.refwo;
	}

	public void setRefwo(String refwo) {
		this.refwo = refwo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRequestnum() {
		return this.requestnum;
	}

	public void setRequestnum(String requestnum) {
		this.requestnum = requestnum;
	}

	public Integer getReturnagainstissue() {
		return this.returnagainstissue;
	}

	public void setReturnagainstissue(Integer returnagainstissue) {
		this.returnagainstissue = returnagainstissue;
	}

	public BigDecimal getReturnedqty() {
		return this.returnedqty;
	}

	public void setReturnedqty(BigDecimal returnedqty) {
		this.returnedqty = returnedqty;
	}

	public String getRotassetnum() {
		return this.rotassetnum;
	}

	public void setRotassetnum(String rotassetnum) {
		this.rotassetnum = rotassetnum;
	}

	public Long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSendersysid() {
		return this.sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public Integer getSplit() {
		return this.split;
	}

	public void setSplit(Integer split) {
		this.split = split;
	}

	public String getTobin() {
		return this.tobin;
	}

	public void setTobin(String tobin) {
		this.tobin = tobin;
	}

	public String getToconditioncode() {
		return this.toconditioncode;
	}

	public void setToconditioncode(String toconditioncode) {
		this.toconditioncode = toconditioncode;
	}

	public String getTolot() {
		return this.tolot;
	}

	public void setTolot(String tolot) {
		this.tolot = tolot;
	}

	public String getToorgid() {
		return this.toorgid;
	}

	public void setToorgid(String toorgid) {
		this.toorgid = toorgid;
	}

	public String getTositeid() {
		return this.tositeid;
	}

	public void setTositeid(String tositeid) {
		this.tositeid = tositeid;
	}

	public String getTostoreloc() {
		return this.tostoreloc;
	}

	public void setTostoreloc(String tostoreloc) {
		this.tostoreloc = tostoreloc;
	}

	public String getUdcontact() {
		return this.udcontact;
	}

	public void setUdcontact(String udcontact) {
		this.udcontact = udcontact;
	}

	public String getUdprojectnum() {
		return this.udprojectnum;
	}

	public void setUdprojectnum(String udprojectnum) {
		this.udprojectnum = udprojectnum;
	}

	public String getUdreceipt() {
		return this.udreceipt;
	}

	public void setUdreceipt(String udreceipt) {
		this.udreceipt = udreceipt;
	}

	public String getUdrecipient() {
		return this.udrecipient;
	}

	public void setUdrecipient(String udrecipient) {
		this.udrecipient = udrecipient;
	}

	public String getUdsapnum() {
		return this.udsapnum;
	}

	public void setUdsapnum(String udsapnum) {
		this.udsapnum = udsapnum;
	}

	public String getUdwonum2() {
		return this.udwonum2;
	}

	public void setUdwonum2(String udwonum2) {
		this.udwonum2 = udwonum2;
	}

	public BigDecimal getUnitcost() {
		return this.unitcost;
	}

	public void setUnitcost(BigDecimal unitcost) {
		this.unitcost = unitcost;
	}

	public String getUsetype() {
		return this.usetype;
	}

	public void setUsetype(String usetype) {
		this.usetype = usetype;
	}

	public Integer getValidated() {
		return this.validated;
	}

	public void setValidated(Integer validated) {
		this.validated = validated;
	}

}