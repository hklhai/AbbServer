package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PO database table.
 * 
 */
@Entity
@Table(name="Po")
public class Po implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PO_POID_GENERATOR", sequenceName="POSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PO_POID_GENERATOR")
	private Long poid;

	private String billto;

	private String billtoattn;

	private Integer buyahead;

	private String buyercompany;

	private String changeby;

	private Date changedate;

	private String contact;

	private Long contractrefid;

	private String contractrefnum;

	private Integer contractrefrev;

	private Integer contreleaseseq;

	private String currencycode;

	private String customernum;

	private String description;

	private Date ecomstatusdate;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Temporal(TemporalType.DATE)
	private Date exchangedate;

	private BigDecimal exchangerate;

	private BigDecimal exchangerate2;

	private String externalrefid;

	private String fob;

	@Temporal(TemporalType.DATE)
	private Date followupdate;

	private String freightterms;

	private Integer hasld;

	private Integer historyflag;

	private Integer ignorecntrev;

	private Integer inclusive1;

	private Integer inclusive2;

	private Integer inclusive3;

	private Integer inclusive4;

	private Integer inclusive5;

	private Integer inspectionrequired;

	private Integer Integerernal;

	private Integer Integerernalchange;

	private String langcode;

	private String mnetsent;

	private Date orderdate;

	private String orgid;

	private String originalponum;

	private String ownersysid;

	private String paymentterms;

	private Integer payonreceipt;

	private String po1;

	private Integer po10;

	private String po2;

	private String po3;

	private String po4;

	private String po5;

	private BigDecimal po6;

	private Date po7;

	private BigDecimal po8;

	private Integer po9;

	private String ponum;

	private String potype;

	@Column(name="\"PRIORITY\"")
	private Integer priority;

	private String purchaseagent;

	private String receipts;

	private Date requireddate;

	private String revcomments;

	private Integer revisionnum;

	private Long rowstamp;

	private String sendersysid;

	private String shipto;

	private String shiptoattn;

	private String shipvia;

	private String siteid;

	private String sourcesysid;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	@Column(name="\"STATUS\"")
	private String status;

	private Date statusdate;

	private String storeloc;

	private String storelocsiteid;

	private BigDecimal totalcost;

	private BigDecimal totaltax1;

	private BigDecimal totaltax2;

	private BigDecimal totaltax3;

	private BigDecimal totaltax4;

	private BigDecimal totaltax5;

	private String udapptype;

	private String udapptypedname;

	private String udpronum;

	@Temporal(TemporalType.DATE)
	private Date vendeliverydate;

	private String vendor;

	public Po() {
	}

	public Long getPoid() {
		return this.poid;
	}

	public void setPoid(Long poid) {
		this.poid = poid;
	}

	public String getBillto() {
		return this.billto;
	}

	public void setBillto(String billto) {
		this.billto = billto;
	}

	public String getBilltoattn() {
		return this.billtoattn;
	}

	public void setBilltoattn(String billtoattn) {
		this.billtoattn = billtoattn;
	}

	public Integer getBuyahead() {
		return this.buyahead;
	}

	public void setBuyahead(Integer buyahead) {
		this.buyahead = buyahead;
	}

	public String getBuyercompany() {
		return this.buyercompany;
	}

	public void setBuyercompany(String buyercompany) {
		this.buyercompany = buyercompany;
	}

	public String getChangeby() {
		return this.changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Date getChangedate() {
		return this.changedate;
	}

	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getContractrefid() {
		return this.contractrefid;
	}

	public void setContractrefid(Long contractrefid) {
		this.contractrefid = contractrefid;
	}

	public String getContractrefnum() {
		return this.contractrefnum;
	}

	public void setContractrefnum(String contractrefnum) {
		this.contractrefnum = contractrefnum;
	}

	public Integer getContractrefrev() {
		return this.contractrefrev;
	}

	public void setContractrefrev(Integer contractrefrev) {
		this.contractrefrev = contractrefrev;
	}

	public Integer getContreleaseseq() {
		return this.contreleaseseq;
	}

	public void setContreleaseseq(Integer contreleaseseq) {
		this.contreleaseseq = contreleaseseq;
	}

	public String getCurrencycode() {
		return this.currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getCustomernum() {
		return this.customernum;
	}

	public void setCustomernum(String customernum) {
		this.customernum = customernum;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEcomstatusdate() {
		return this.ecomstatusdate;
	}

	public void setEcomstatusdate(Date ecomstatusdate) {
		this.ecomstatusdate = ecomstatusdate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getExchangedate() {
		return this.exchangedate;
	}

	public void setExchangedate(Date exchangedate) {
		this.exchangedate = exchangedate;
	}

	public BigDecimal getExchangerate() {
		return this.exchangerate;
	}

	public void setExchangerate(BigDecimal exchangerate) {
		this.exchangerate = exchangerate;
	}

	public BigDecimal getExchangerate2() {
		return this.exchangerate2;
	}

	public void setExchangerate2(BigDecimal exchangerate2) {
		this.exchangerate2 = exchangerate2;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getFob() {
		return this.fob;
	}

	public void setFob(String fob) {
		this.fob = fob;
	}

	public Date getFollowupdate() {
		return this.followupdate;
	}

	public void setFollowupdate(Date followupdate) {
		this.followupdate = followupdate;
	}

	public String getFreightterms() {
		return this.freightterms;
	}

	public void setFreightterms(String freightterms) {
		this.freightterms = freightterms;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public Integer getHistoryflag() {
		return this.historyflag;
	}

	public void setHistoryflag(Integer historyflag) {
		this.historyflag = historyflag;
	}

	public Integer getIgnorecntrev() {
		return this.ignorecntrev;
	}

	public void setIgnorecntrev(Integer ignorecntrev) {
		this.ignorecntrev = ignorecntrev;
	}

	public Integer getInclusive1() {
		return this.inclusive1;
	}

	public void setInclusive1(Integer inclusive1) {
		this.inclusive1 = inclusive1;
	}

	public Integer getInclusive2() {
		return this.inclusive2;
	}

	public void setInclusive2(Integer inclusive2) {
		this.inclusive2 = inclusive2;
	}

	public Integer getInclusive3() {
		return this.inclusive3;
	}

	public void setInclusive3(Integer inclusive3) {
		this.inclusive3 = inclusive3;
	}

	public Integer getInclusive4() {
		return this.inclusive4;
	}

	public void setInclusive4(Integer inclusive4) {
		this.inclusive4 = inclusive4;
	}

	public Integer getInclusive5() {
		return this.inclusive5;
	}

	public void setInclusive5(Integer inclusive5) {
		this.inclusive5 = inclusive5;
	}

	public Integer getInspectionrequired() {
		return this.inspectionrequired;
	}

	public void setInspectionrequired(Integer inspectionrequired) {
		this.inspectionrequired = inspectionrequired;
	}

	public Integer getIntegerernal() {
		return this.Integerernal;
	}

	public void setIntegerernal(Integer Integerernal) {
		this.Integerernal = Integerernal;
	}

	public Integer getIntegerernalchange() {
		return this.Integerernalchange;
	}

	public void setIntegerernalchange(Integer Integerernalchange) {
		this.Integerernalchange = Integerernalchange;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getMnetsent() {
		return this.mnetsent;
	}

	public void setMnetsent(String mnetsent) {
		this.mnetsent = mnetsent;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOriginalponum() {
		return this.originalponum;
	}

	public void setOriginalponum(String originalponum) {
		this.originalponum = originalponum;
	}

	public String getOwnersysid() {
		return this.ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public String getPaymentterms() {
		return this.paymentterms;
	}

	public void setPaymentterms(String paymentterms) {
		this.paymentterms = paymentterms;
	}

	public Integer getPayonreceipt() {
		return this.payonreceipt;
	}

	public void setPayonreceipt(Integer payonreceipt) {
		this.payonreceipt = payonreceipt;
	}

	public String getPo1() {
		return this.po1;
	}

	public void setPo1(String po1) {
		this.po1 = po1;
	}

	public Integer getPo10() {
		return this.po10;
	}

	public void setPo10(Integer po10) {
		this.po10 = po10;
	}

	public String getPo2() {
		return this.po2;
	}

	public void setPo2(String po2) {
		this.po2 = po2;
	}

	public String getPo3() {
		return this.po3;
	}

	public void setPo3(String po3) {
		this.po3 = po3;
	}

	public String getPo4() {
		return this.po4;
	}

	public void setPo4(String po4) {
		this.po4 = po4;
	}

	public String getPo5() {
		return this.po5;
	}

	public void setPo5(String po5) {
		this.po5 = po5;
	}

	public BigDecimal getPo6() {
		return this.po6;
	}

	public void setPo6(BigDecimal po6) {
		this.po6 = po6;
	}

	public Date getPo7() {
		return this.po7;
	}

	public void setPo7(Date po7) {
		this.po7 = po7;
	}

	public BigDecimal getPo8() {
		return this.po8;
	}

	public void setPo8(BigDecimal po8) {
		this.po8 = po8;
	}

	public Integer getPo9() {
		return this.po9;
	}

	public void setPo9(Integer po9) {
		this.po9 = po9;
	}

	public String getPonum() {
		return this.ponum;
	}

	public void setPonum(String ponum) {
		this.ponum = ponum;
	}

	public String getPotype() {
		return this.potype;
	}

	public void setPotype(String potype) {
		this.potype = potype;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getPurchaseagent() {
		return this.purchaseagent;
	}

	public void setPurchaseagent(String purchaseagent) {
		this.purchaseagent = purchaseagent;
	}

	public String getReceipts() {
		return this.receipts;
	}

	public void setReceipts(String receipts) {
		this.receipts = receipts;
	}

	public Date getRequireddate() {
		return this.requireddate;
	}

	public void setRequireddate(Date requireddate) {
		this.requireddate = requireddate;
	}

	public String getRevcomments() {
		return this.revcomments;
	}

	public void setRevcomments(String revcomments) {
		this.revcomments = revcomments;
	}

	public Integer getRevisionnum() {
		return this.revisionnum;
	}

	public void setRevisionnum(Integer revisionnum) {
		this.revisionnum = revisionnum;
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

	public String getShipto() {
		return this.shipto;
	}

	public void setShipto(String shipto) {
		this.shipto = shipto;
	}

	public String getShiptoattn() {
		return this.shiptoattn;
	}

	public void setShiptoattn(String shiptoattn) {
		this.shiptoattn = shiptoattn;
	}

	public String getShipvia() {
		return this.shipvia;
	}

	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
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

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getStoreloc() {
		return this.storeloc;
	}

	public void setStoreloc(String storeloc) {
		this.storeloc = storeloc;
	}

	public String getStorelocsiteid() {
		return this.storelocsiteid;
	}

	public void setStorelocsiteid(String storelocsiteid) {
		this.storelocsiteid = storelocsiteid;
	}

	public BigDecimal getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(BigDecimal totalcost) {
		this.totalcost = totalcost;
	}

	public BigDecimal getTotaltax1() {
		return this.totaltax1;
	}

	public void setTotaltax1(BigDecimal totaltax1) {
		this.totaltax1 = totaltax1;
	}

	public BigDecimal getTotaltax2() {
		return this.totaltax2;
	}

	public void setTotaltax2(BigDecimal totaltax2) {
		this.totaltax2 = totaltax2;
	}

	public BigDecimal getTotaltax3() {
		return this.totaltax3;
	}

	public void setTotaltax3(BigDecimal totaltax3) {
		this.totaltax3 = totaltax3;
	}

	public BigDecimal getTotaltax4() {
		return this.totaltax4;
	}

	public void setTotaltax4(BigDecimal totaltax4) {
		this.totaltax4 = totaltax4;
	}

	public BigDecimal getTotaltax5() {
		return this.totaltax5;
	}

	public void setTotaltax5(BigDecimal totaltax5) {
		this.totaltax5 = totaltax5;
	}

	public String getUdapptype() {
		return this.udapptype;
	}

	public void setUdapptype(String udapptype) {
		this.udapptype = udapptype;
	}

	public String getUdapptypedname() {
		return this.udapptypedname;
	}

	public void setUdapptypedname(String udapptypedname) {
		this.udapptypedname = udapptypedname;
	}

	public String getUdpronum() {
		return this.udpronum;
	}

	public void setUdpronum(String udpronum) {
		this.udpronum = udpronum;
	}

	public Date getVendeliverydate() {
		return this.vendeliverydate;
	}

	public void setVendeliverydate(Date vendeliverydate) {
		this.vendeliverydate = vendeliverydate;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}