package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SITE database table.
 * 
 */
@Entity
@Table(name="Site")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SITE_SITEUID_GENERATOR", sequenceName="SITE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SITE_SITEUID_GENERATOR")
	private long siteuid;

	@Column(name="\"ACTIVE\"")
	private Integer active;

	private String changeby;

	private Timestamp changedate;

	private String contact;

	private String contactgroup;

	private String description;

	private String enterby;

	private Timestamp enterdate;

	private Integer hasld;

	private String langcode;

	private String orgid;

	private long rowstamp;

	private String siteid;

	public Site() {
	}

	public long getSiteuid() {
		return this.siteuid;
	}

	public void setSiteuid(long siteuid) {
		this.siteuid = siteuid;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getChangeby() {
		return this.changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Timestamp getChangedate() {
		return this.changedate;
	}

	public void setChangedate(Timestamp changedate) {
		this.changedate = changedate;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactgroup() {
		return this.contactgroup;
	}

	public void setContactgroup(String contactgroup) {
		this.contactgroup = contactgroup;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnterby() {
		return this.enterby;
	}

	public void setEnterby(String enterby) {
		this.enterby = enterby;
	}

	public Timestamp getEnterdate() {
		return this.enterdate;
	}

	public void setEnterdate(Timestamp enterdate) {
		this.enterdate = enterdate;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
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

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

}