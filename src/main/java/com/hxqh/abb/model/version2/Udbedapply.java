package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the UDBEDAPPLY database table.
 * 
 */
@Entity
@Table(name="Udbedapply")
public class Udbedapply implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UDBEDAPPLY_UDBEDAPPLYID_GENERATOR", sequenceName="UDBEDAPPLYSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDBEDAPPLY_UDBEDAPPLYID_GENERATOR")
	private Long udbedapplyid;

	private String applicant;

	private String applynum;

	private Date applytime;

	private String bednum;

	private String changeby;

	private Date changedate;

	private String createdby;

	private Date createddate;

	private String description;

	private Date endtime;

	private Integer hasld;

	private String memo;

	private String orgid;

	private String reason;

	private Long rowstamp;

	private String siteid;

	private Date starttime;

	private String stationhead;

	@Column(name="\"STATUS\"")
	private String status;

	private Date statusdate;

	public Udbedapply() {
	}

	public Long getUdbedapplyid() {
		return this.udbedapplyid;
	}

	public void setUdbedapplyid(Long udbedapplyid) {
		this.udbedapplyid = udbedapplyid;
	}

	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getApplynum() {
		return this.applynum;
	}

	public void setApplynum(String applynum) {
		this.applynum = applynum;
	}

	public Date getApplytime() {
		return this.applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public String getBednum() {
		return this.bednum;
	}

	public void setBednum(String bednum) {
		this.bednum = bednum;
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

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
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

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getStationhead() {
		return this.stationhead;
	}

	public void setStationhead(String stationhead) {
		this.stationhead = stationhead;
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

}