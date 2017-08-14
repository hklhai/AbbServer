package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FAILUREREPORT database table.
 * 
 */
@Entity
@Table(name="Failurereport")
public class Failurereport implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAILUREREPORT_FAILUREREPORTID_GENERATOR", sequenceName="FAILUREREPORTSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAILUREREPORT_FAILUREREPORTID_GENERATOR")
	private Long failurereportid;

	private String assetnum;

	private String failurecode;

	private Long linenum;

	private String orgid;

	private Long rowstamp;

	private String siteid;

	private String ticketclass;

	private String ticketid;

	@Column(name="\"TYPE\"")
	private String type;

	private String wonum;

	public Failurereport() {
	}

	public Long getFailurereportid() {
		return this.failurereportid;
	}

	public void setFailurereportid(Long failurereportid) {
		this.failurereportid = failurereportid;
	}

	public String getAssetnum() {
		return this.assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getFailurecode() {
		return this.failurecode;
	}

	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}

	public Long getLinenum() {
		return this.linenum;
	}

	public void setLinenum(Long linenum) {
		this.linenum = linenum;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public Long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWonum() {
		return this.wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

}