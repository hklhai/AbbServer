package com.hxqh.abb.model.version2;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the UDVEHICLEAPPLY database table.
 * 
 */
@Entity
@Table(name="Udvehicleapply")
public class Udvehicleapply implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UDVEHICLEAPPLY_UDVEHICLEID_GENERATOR", sequenceName="UDVEHICLEAPPLYSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDVEHICLEAPPLY_UDVEHICLEID_GENERATOR")
	private Long udvehicleid;

	private String applicant;

	private String applynum;

	private Date applytime;

	private String changeby;

	private Date chengdate;

	private String createdby;

	private Date createddate;

	private String description;

	private String destination;

	private Date endtime;

	private Integer hasld;

	private String license;

	private String linenum;

	private String orgid;

	private String origin;

	private String project;

	private String pronum;

	private String reason;

	private Long rowstamp;

	private String siteid;

	private Date starttime;

	private String stationhead;

	@Column(name="\"STATUS\"")
	private String status;

	private Date statusdate;

	public Udvehicleapply() {
	}

	public Long getUdvehicleid() {
		return this.udvehicleid;
	}

	public void setUdvehicleid(Long udvehicleid) {
		this.udvehicleid = udvehicleid;
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

	public String getChangeby() {
		return this.changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Date getChengdate() {
		return this.chengdate;
	}

	public void setChengdate(Date chengdate) {
		this.chengdate = chengdate;
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

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLinenum() {
		return this.linenum;
	}

	public void setLinenum(String linenum) {
		this.linenum = linenum;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPronum() {
		return this.pronum;
	}

	public void setPronum(String pronum) {
		this.pronum = pronum;
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