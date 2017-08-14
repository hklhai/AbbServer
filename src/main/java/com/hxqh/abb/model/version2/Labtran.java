package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the LABTRANS database table.
 * 
 */
@Entity
@Table(name="LABTRANS")
public class Labtran implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LABTRANS_LABTRANSID_GENERATOR", sequenceName="LABTRANSSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LABTRANS_LABTRANSID_GENERATOR")
	private Long labtransid;

	private String amcrew;

	private String amcrewtype;

	private String assetnum;

	private String contractnum;

	private String craft;

	private String crewworkgroup;

	private String enterby;

	private Date enterdate;

	private Integer enteredastask;

	private BigDecimal exchangerate2;

	private String externalrefid;

	private String financialperiod;

	private String fincntrlid;

	@Temporal(TemporalType.DATE)
	private Date finishdate;

	private Date finishdatetime;

	private Time finishtime;

	private Integer genapprservreceipt;

	private String glcreditacct;

	private String gldebitacct;

	private Integer invoicelinenum;

	private String invoicenum;

	private String laborcode;

	private BigDecimal linecost;

	private BigDecimal linecost2;

	@Column(name="\"LOCATION\"")
	private String location;

	private String memo;

	private String orgid;

	private Integer outside;

	private String ownersysid;

	private Date paymenttransdate;

	private BigDecimal payrate;

	private Integer polinenum;

	private String ponum;

	private Integer porevisionnum;

	@Column(name="\"POSITION\"")
	private String position;

	private String premiumpaycode;

	private double premiumpayhours;

	private BigDecimal premiumpayrate;

	private String premiumpayratetype;

	private String refwo;

	private double regularhrs;

	private Integer revisionnum;

	@Column(name="\"ROLLUP\"")
	private Integer rollup;

	private Long rowstamp;

	private String sendersysid;

	private Long servrectransid;

	private String siteid;

	private String skilllevel;

	private String sourcesysid;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private Date startdatetime;

	private Time starttime;

	private String ticketclass;

	private String ticketid;

	private String timerstatus;

	private Date transdate;

	private String transtype;

	private String vendor;

	public Labtran() {
	}

	public Long getLabtransid() {
		return this.labtransid;
	}

	public void setLabtransid(Long labtransid) {
		this.labtransid = labtransid;
	}

	public String getAmcrew() {
		return this.amcrew;
	}

	public void setAmcrew(String amcrew) {
		this.amcrew = amcrew;
	}

	public String getAmcrewtype() {
		return this.amcrewtype;
	}

	public void setAmcrewtype(String amcrewtype) {
		this.amcrewtype = amcrewtype;
	}

	public String getAssetnum() {
		return this.assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getContractnum() {
		return this.contractnum;
	}

	public void setContractnum(String contractnum) {
		this.contractnum = contractnum;
	}

	public String getCraft() {
		return this.craft;
	}

	public void setCraft(String craft) {
		this.craft = craft;
	}

	public String getCrewworkgroup() {
		return this.crewworkgroup;
	}

	public void setCrewworkgroup(String crewworkgroup) {
		this.crewworkgroup = crewworkgroup;
	}

	public String getEnterby() {
		return this.enterby;
	}

	public void setEnterby(String enterby) {
		this.enterby = enterby;
	}

	public Date getEnterdate() {
		return this.enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	public Integer getEnteredastask() {
		return this.enteredastask;
	}

	public void setEnteredastask(Integer enteredastask) {
		this.enteredastask = enteredastask;
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

	public String getFinancialperiod() {
		return this.financialperiod;
	}

	public void setFinancialperiod(String financialperiod) {
		this.financialperiod = financialperiod;
	}

	public String getFincntrlid() {
		return this.fincntrlid;
	}

	public void setFincntrlid(String fincntrlid) {
		this.fincntrlid = fincntrlid;
	}

	public Date getFinishdate() {
		return this.finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public Date getFinishdatetime() {
		return this.finishdatetime;
	}

	public void setFinishdatetime(Date finishdatetime) {
		this.finishdatetime = finishdatetime;
	}

	public Time getFinishtime() {
		return this.finishtime;
	}

	public void setFinishtime(Time finishtime) {
		this.finishtime = finishtime;
	}

	public Integer getGenapprservreceipt() {
		return this.genapprservreceipt;
	}

	public void setGenapprservreceipt(Integer genapprservreceipt) {
		this.genapprservreceipt = genapprservreceipt;
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

	public Integer getInvoicelinenum() {
		return this.invoicelinenum;
	}

	public void setInvoicelinenum(Integer invoicelinenum) {
		this.invoicelinenum = invoicelinenum;
	}

	public String getInvoicenum() {
		return this.invoicenum;
	}

	public void setInvoicenum(String invoicenum) {
		this.invoicenum = invoicenum;
	}

	public String getLaborcode() {
		return this.laborcode;
	}

	public void setLaborcode(String laborcode) {
		this.laborcode = laborcode;
	}

	public BigDecimal getLinecost() {
		return this.linecost;
	}

	public void setLinecost(BigDecimal linecost) {
		this.linecost = linecost;
	}

	public BigDecimal getLinecost2() {
		return this.linecost2;
	}

	public void setLinecost2(BigDecimal linecost2) {
		this.linecost2 = linecost2;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
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

	public Date getPaymenttransdate() {
		return this.paymenttransdate;
	}

	public void setPaymenttransdate(Date paymenttransdate) {
		this.paymenttransdate = paymenttransdate;
	}

	public BigDecimal getPayrate() {
		return this.payrate;
	}

	public void setPayrate(BigDecimal payrate) {
		this.payrate = payrate;
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

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPremiumpaycode() {
		return this.premiumpaycode;
	}

	public void setPremiumpaycode(String premiumpaycode) {
		this.premiumpaycode = premiumpaycode;
	}

	public double getPremiumpayhours() {
		return this.premiumpayhours;
	}

	public void setPremiumpayhours(double premiumpayhours) {
		this.premiumpayhours = premiumpayhours;
	}

	public BigDecimal getPremiumpayrate() {
		return this.premiumpayrate;
	}

	public void setPremiumpayrate(BigDecimal premiumpayrate) {
		this.premiumpayrate = premiumpayrate;
	}

	public String getPremiumpayratetype() {
		return this.premiumpayratetype;
	}

	public void setPremiumpayratetype(String premiumpayratetype) {
		this.premiumpayratetype = premiumpayratetype;
	}

	public String getRefwo() {
		return this.refwo;
	}

	public void setRefwo(String refwo) {
		this.refwo = refwo;
	}

	public double getRegularhrs() {
		return this.regularhrs;
	}

	public void setRegularhrs(double regularhrs) {
		this.regularhrs = regularhrs;
	}

	public Integer getRevisionnum() {
		return this.revisionnum;
	}

	public void setRevisionnum(Integer revisionnum) {
		this.revisionnum = revisionnum;
	}

	public Integer getRollup() {
		return this.rollup;
	}

	public void setRollup(Integer rollup) {
		this.rollup = rollup;
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

	public Long getServrectransid() {
		return this.servrectransid;
	}

	public void setServrectransid(Long servrectransid) {
		this.servrectransid = servrectransid;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getSkilllevel() {
		return this.skilllevel;
	}

	public void setSkilllevel(String skilllevel) {
		this.skilllevel = skilllevel;
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

	public Date getStartdatetime() {
		return this.startdatetime;
	}

	public void setStartdatetime(Date startdatetime) {
		this.startdatetime = startdatetime;
	}

	public Time getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public String getTicketclass() {
		return this.ticketclass;
	}

	public void setTicketclass(String ticketclass) {
		this.ticketclass = ticketclass;
	}

	public String getTicketid() {
		return this.ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	public String getTimerstatus() {
		return this.timerstatus;
	}

	public void setTimerstatus(String timerstatus) {
		this.timerstatus = timerstatus;
	}

	public Date getTransdate() {
		return this.transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public String getTranstype() {
		return this.transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}