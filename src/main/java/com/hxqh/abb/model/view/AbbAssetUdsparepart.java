package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_ASSET_UDSPAREPARTS database table.
 * 
 */
@Entity
@Table(name="ABB_ASSET_UDSPAREPARTS")
public class AbbAssetUdsparepart implements Serializable {
	private static final long serialVersionUID = 1L;

	private String classstructureid;

	private String description;

	private String itemnum;

	@Id
	private long udsparepartsid;

	public AbbAssetUdsparepart() {
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

	public String getItemnum() {
		return this.itemnum;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	public long getUdsparepartsid() {
		return this.udsparepartsid;
	}

	public void setUdsparepartsid(long udsparepartsid) {
		this.udsparepartsid = udsparepartsid;
	}

}