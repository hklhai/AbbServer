package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the ABB_INDEX_WORKORDER database table.
 * 
 */
@Entity
@Table(name="ABB_INDEX_WORKORDER")
public class AbbIndexWorkorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long workorderid;

	private String description;

	private String displayname;

	@Column(name="LOCATIONS_DESCRIPTION")
	private String locationsDescription;

	private String reportedby;

	private String siteid;

	@Column(name="\"STATUS\"")
	private String status;

	private Date targstartdate;

	private String wonum;

	public AbbIndexWorkorder() {
	}

	public Long getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(Long workorderid) {
		this.workorderid = workorderid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getLocationsDescription() {
		return this.locationsDescription;
	}

	public void setLocationsDescription(String locationsDescription) {
		this.locationsDescription = locationsDescription;
	}

	public String getReportedby() {
		return this.reportedby;
	}

	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;
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

	public Date getTargstartdate() {
		return this.targstartdate;
	}

	public void setTargstartdate(Date targstartdate) {
		this.targstartdate = targstartdate;
	}

	public String getWonum() {
		return this.wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

}