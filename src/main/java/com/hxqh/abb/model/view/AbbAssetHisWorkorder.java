package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ABB_ASSET_HIS_WORKORDER database table.
 * 
 */
@Entity
@Table(name="ABB_ASSET_HIS_WORKORDER")
public class AbbAssetHisWorkorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long assetuid;

	private String classstructureid;

	private String description;

	private String locsdesc;

	private String siteid;

	@Column(name="\"STATUS\"")
	private String status;

	private Timestamp targstartdate;

	private String wonum;

	public AbbAssetHisWorkorder() {
	}

	public long getAssetuid() {
		return this.assetuid;
	}

	public void setAssetuid(long assetuid) {
		this.assetuid = assetuid;
	}

	public String getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocsdesc() {
		return this.locsdesc;
	}

	public void setLocsdesc(String locsdesc) {
		this.locsdesc = locsdesc;
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

	public Timestamp getTargstartdate() {
		return this.targstartdate;
	}

	public void setTargstartdate(Timestamp targstartdate) {
		this.targstartdate = targstartdate;
	}

	public String getWonum() {
		return this.wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

}