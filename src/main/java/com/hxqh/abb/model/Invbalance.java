package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the INVBALANCES database table.
 * 
 */
@Entity
@Table(name="INVBALANCES")
public class Invbalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVBALANCES_INVBALANCESID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVBALANCES_INVBALANCESID_GENERATOR")
	private long invbalancesid;

	private String binnum;

	private String conditioncode;

	private BigDecimal curbal;

	private String externalrefid;

	private String itemnum;

	private String itemsetid;

	@Column(name="\"LOCATION\"")
	private String location;

	private String lotnum;

	private String orgid;

	private String ownersysid;

	private BigDecimal physcnt;

	private Timestamp physcntdate;

	private Integer reconciled;

	private long rowstamp;

	private String sendersysid;

	private String siteid;

	private String sourcesysid;

	private BigDecimal stagedcurbal;

	private Integer stagingbin;

	public Invbalance() {
	}

	public long getInvbalancesid() {
		return this.invbalancesid;
	}

	public void setInvbalancesid(long invbalancesid) {
		this.invbalancesid = invbalancesid;
	}

	public String getBinnum() {
		return this.binnum;
	}

	public void setBinnum(String binnum) {
		this.binnum = binnum;
	}

	public String getConditioncode() {
		return this.conditioncode;
	}

	public void setConditioncode(String conditioncode) {
		this.conditioncode = conditioncode;
	}

	public BigDecimal getCurbal() {
		return this.curbal;
	}

	public void setCurbal(BigDecimal curbal) {
		this.curbal = curbal;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLotnum() {
		return this.lotnum;
	}

	public void setLotnum(String lotnum) {
		this.lotnum = lotnum;
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

	public BigDecimal getPhyscnt() {
		return this.physcnt;
	}

	public void setPhyscnt(BigDecimal physcnt) {
		this.physcnt = physcnt;
	}

	public Timestamp getPhyscntdate() {
		return this.physcntdate;
	}

	public void setPhyscntdate(Timestamp physcntdate) {
		this.physcntdate = physcntdate;
	}

	public Integer getReconciled() {
		return this.reconciled;
	}

	public void setReconciled(Integer reconciled) {
		this.reconciled = reconciled;
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

	public BigDecimal getStagedcurbal() {
		return this.stagedcurbal;
	}

	public void setStagedcurbal(BigDecimal stagedcurbal) {
		this.stagedcurbal = stagedcurbal;
	}

	public Integer getStagingbin() {
		return this.stagingbin;
	}

	public void setStagingbin(Integer stagingbin) {
		this.stagingbin = stagingbin;
	}

}