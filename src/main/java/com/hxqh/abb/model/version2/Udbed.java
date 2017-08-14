package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the UDBED database table.
 * 
 */
@Entity
@Table(name="Udbed")
public class Udbed implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UDBED_UDBEDID_GENERATOR", sequenceName="UDBEDSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDBED_UDBEDID_GENERATOR")
	private Long udbedid;

	private String bednum;

	private String building;

	private String changeby;

	private Date changedate;

	private String createdby;

	private Date createddate;

	private String description;

	private String floor;

	private Integer hasld;

	@Column(name="\"LOCATION\"")
	private String location;

	private String orgid;

	private String room;

	private Long rowstamp;

	private String siteid;

	@Column(name="\"STATUS\"")
	private String status;

	private Date statusdate;

	public Udbed() {
	}

	public Long getUdbedid() {
		return this.udbedid;
	}

	public void setUdbedid(Long udbedid) {
		this.udbedid = udbedid;
	}

	public String getBednum() {
		return this.bednum;
	}

	public void setBednum(String bednum) {
		this.bednum = bednum;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
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

	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
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