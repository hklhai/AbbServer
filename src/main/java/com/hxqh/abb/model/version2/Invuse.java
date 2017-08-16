package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INVUSE database table.
 * 
 */
@Entity
@Table(name="Invuse")
public class Invuse implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVUSE_INVUSEID_GENERATOR", sequenceName="INVUSESEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVUSE_INVUSEID_GENERATOR")
	private Long invuseid;

	private Integer autocreated;

	private String changeby;

	private Date changedate;

	private String createdby;

	private String currencycode;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date exchangedate;

	private BigDecimal exchangerate;

	private BigDecimal exchangerate2;

	private String fromstoreloc;

	private Integer hasld;

	private String invowner;

	private String invusenum;

	private Integer issite;

	private String langcode;

	private String orgid;

	private String receipts;

	private Long rowstamp;

	private String sendersysid;

	private Date shipmentdate;

	private String shiptoattn;

	private String siteid;

	@Column(name="\"STATUS\"")
	private String status;

	private Date statusdate;

	private Integer statusiface;

	private String udapptype;

	private String udareaman;

	private String udpmanager;

	private String udprojectnum;

	private BigDecimal udtotal;

	private String usetype;

	private Integer warranty;

	private Long workorderid;

	public Invuse() {
	}

	public Long getInvuseid() {
		return this.invuseid;
	}

	public void setInvuseid(Long invuseid) {
		this.invuseid = invuseid;
	}

	public Integer getAutocreated() {
		return this.autocreated;
	}

	public void setAutocreated(Integer autocreated) {
		this.autocreated = autocreated;
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

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCurrencycode() {
		return this.currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getFromstoreloc() {
		return this.fromstoreloc;
	}

	public void setFromstoreloc(String fromstoreloc) {
		this.fromstoreloc = fromstoreloc;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public String getInvowner() {
		return this.invowner;
	}

	public void setInvowner(String invowner) {
		this.invowner = invowner;
	}

	public String getInvusenum() {
		return this.invusenum;
	}

	public void setInvusenum(String invusenum) {
		this.invusenum = invusenum;
	}

	public Integer getIssite() {
		return this.issite;
	}

	public void setIssite(Integer issite) {
		this.issite = issite;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getReceipts() {
		return this.receipts;
	}

	public void setReceipts(String receipts) {
		this.receipts = receipts;
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

	public Date getShipmentdate() {
		return this.shipmentdate;
	}

	public void setShipmentdate(Date shipmentdate) {
		this.shipmentdate = shipmentdate;
	}

	public String getShiptoattn() {
		return this.shiptoattn;
	}

	public void setShiptoattn(String shiptoattn) {
		this.shiptoattn = shiptoattn;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
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

	public Integer getStatusiface() {
		return this.statusiface;
	}

	public void setStatusiface(Integer statusiface) {
		this.statusiface = statusiface;
	}

	public String getUdapptype() {
		return this.udapptype;
	}

	public void setUdapptype(String udapptype) {
		this.udapptype = udapptype;
	}

	public String getUdareaman() {
		return this.udareaman;
	}

	public void setUdareaman(String udareaman) {
		this.udareaman = udareaman;
	}

	public String getUdpmanager() {
		return this.udpmanager;
	}

	public void setUdpmanager(String udpmanager) {
		this.udpmanager = udpmanager;
	}

	public String getUdprojectnum() {
		return this.udprojectnum;
	}

	public void setUdprojectnum(String udprojectnum) {
		this.udprojectnum = udprojectnum;
	}

	public BigDecimal getUdtotal() {
		return this.udtotal;
	}

	public void setUdtotal(BigDecimal udtotal) {
		this.udtotal = udtotal;
	}

	public String getUsetype() {
		return this.usetype;
	}

	public void setUsetype(String usetype) {
		this.usetype = usetype;
	}

	public Integer getWarranty() {
		return this.warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public Long getWorkorderid() {
		return this.workorderid;
	}

	public void setWorkorderid(Long workorderid) {
		this.workorderid = workorderid;
	}

}