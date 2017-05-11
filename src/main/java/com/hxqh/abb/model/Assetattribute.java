package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ASSETATTRIBUTE database table.
 * 
 */
@Entity
@Table(name="Assetattribute")
public class Assetattribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSETATTRIBUTE_ASSETATTRIBUTEID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSETATTRIBUTE_ASSETATTRIBUTEID_GENERATOR")
	private long assetattributeid;

	private String assetattrid;

	private String attrdescprefix;

	private String datatype;

	private String description;

	private String domainid;

	private String measureunitid;

	private String orgid;

	private long rowstamp;

	private String siteid;

	public Assetattribute() {
	}

	public long getAssetattributeid() {
		return this.assetattributeid;
	}

	public void setAssetattributeid(long assetattributeid) {
		this.assetattributeid = assetattributeid;
	}

	public String getAssetattrid() {
		return this.assetattrid;
	}

	public void setAssetattrid(String assetattrid) {
		this.assetattrid = assetattrid;
	}

	public String getAttrdescprefix() {
		return this.attrdescprefix;
	}

	public void setAttrdescprefix(String attrdescprefix) {
		this.attrdescprefix = attrdescprefix;
	}

	public String getDatatype() {
		return this.datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomainid() {
		return this.domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

	public String getMeasureunitid() {
		return this.measureunitid;
	}

	public void setMeasureunitid(String measureunitid) {
		this.measureunitid = measureunitid;
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