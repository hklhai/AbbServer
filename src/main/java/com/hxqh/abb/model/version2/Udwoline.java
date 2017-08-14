package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UDWOLINE database table.
 * 
 */
@Entity
@Table(name="Udwoline")
public class Udwoline implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UDWOLINE_UDWOLINEID_GENERATOR", sequenceName="UDWOLINESEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDWOLINE_UDWOLINEID_GENERATOR")
	private Long udwolineid;

	private String assetnum;

	private String description;

	private Integer hasld;

	@Column(name="\"LOCATION\"")
	private String location;

	private String orgid;

	private Long rowstamp;

	private String siteid;

	private String wonum;

	public Udwoline() {
	}

	public Long getUdwolineid() {
		return this.udwolineid;
	}

	public void setUdwolineid(Long udwolineid) {
		this.udwolineid = udwolineid;
	}

	public String getAssetnum() {
		return this.assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
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