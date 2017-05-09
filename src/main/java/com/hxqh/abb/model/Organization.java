package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ORGANIZATION database table.
 * 
 */
@Entity
@Table(name="Organization")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANIZATION_ORGANIZATIONID_GENERATOR", sequenceName="ORGANIZATION_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANIZATION_ORGANIZATIONID_GENERATOR")
	private long organizationid;

	@Column(name="\"ACTIVE\"")
	private Integer active;

	private String basecurrency1;

	private String basecurrency2;

	private String category;

	private String clearingacct;

	private String companysetid;

	private String description;

	private String dfltitemstatus;

	private String enterby;

	private Timestamp enterdate;

	private Integer hasld;

	private String itemsetid;

	private String langcode;

	private String orgid;

	private long rowstamp;

	public Organization() {
	}

	public long getOrganizationid() {
		return this.organizationid;
	}

	public void setOrganizationid(long organizationid) {
		this.organizationid = organizationid;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getBasecurrency1() {
		return this.basecurrency1;
	}

	public void setBasecurrency1(String basecurrency1) {
		this.basecurrency1 = basecurrency1;
	}

	public String getBasecurrency2() {
		return this.basecurrency2;
	}

	public void setBasecurrency2(String basecurrency2) {
		this.basecurrency2 = basecurrency2;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClearingacct() {
		return this.clearingacct;
	}

	public void setClearingacct(String clearingacct) {
		this.clearingacct = clearingacct;
	}

	public String getCompanysetid() {
		return this.companysetid;
	}

	public void setCompanysetid(String companysetid) {
		this.companysetid = companysetid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDfltitemstatus() {
		return this.dfltitemstatus;
	}

	public void setDfltitemstatus(String dfltitemstatus) {
		this.dfltitemstatus = dfltitemstatus;
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

	public String getItemsetid() {
		return this.itemsetid;
	}

	public void setItemsetid(String itemsetid) {
		this.itemsetid = itemsetid;
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

}