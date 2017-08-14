package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the UDWOQUALIFICATION database table.
 * 
 */
@Entity
@Table(name="Udwoqualification")
public class Udwoqualification implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UDWOQUALIFICATION_UDWOQUALIFICATIONID_GENERATOR", sequenceName="UDWOQUALIFICATIONSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDWOQUALIFICATION_UDWOQUALIFICATIONID_GENERATOR")
	private Long udwoqualificationid;

	private String createdby;

	private Date createddate;

	private String description;

	private Integer hasld;

	private String orgid;

	private String qualification;

	private Long rowstamp;

	private String siteid;

	private String wonum;

	public Udwoqualification() {
	}

	public Long getUdwoqualificationid() {
		return this.udwoqualificationid;
	}

	public void setUdwoqualificationid(Long udwoqualificationid) {
		this.udwoqualificationid = udwoqualificationid;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public String getWonum() {
		return this.wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

}