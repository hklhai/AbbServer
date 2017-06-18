package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_ASSET_HIS_ASSETMETER database table.
 * 
 */
@Entity
@Table(name="ABB_ASSET_HIS_ASSETMETER")
public class AbbAssetHisAssetmeter implements Serializable {
	private static final long serialVersionUID = 1L;

	private String assetnum;

	@Id
	private long assetuid;

	private String classstructureid;

	private String description;

	private String lastreading;

	private String metername;

	private String metertype;

	private String udmaxreading;

	public AbbAssetHisAssetmeter() {
	}

	public String getAssetnum() {
		return this.assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
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

	public String getLastreading() {
		return this.lastreading;
	}

	public void setLastreading(String lastreading) {
		this.lastreading = lastreading;
	}

	public String getMetername() {
		return this.metername;
	}

	public void setMetername(String metername) {
		this.metername = metername;
	}

	public String getMetertype() {
		return this.metertype;
	}

	public void setMetertype(String metertype) {
		this.metertype = metertype;
	}

	public String getUdmaxreading() {
		return this.udmaxreading;
	}

	public void setUdmaxreading(String udmaxreading) {
		this.udmaxreading = udmaxreading;
	}

}