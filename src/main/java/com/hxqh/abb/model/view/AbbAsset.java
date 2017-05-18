package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ABB_ASSET database table.
 * 
 */
@Entity
@Table(name="ABB_ASSET")
public class AbbAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	private String assetnum;

	@Id
	private long assetuid;

	private String child;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date installdate;

	private String locdesc;

	@Column(name="\"NAME\"")
	private String name;

	@Column(name="\"PARENT\"")
	private String parent;

	private String serialnum;

	@Column(name="\"STATE\"")
	private String state;

	@Column(name="\"STATUS\"")
	private String status;

	private String udbelong;

	private String udcontract;

	private String udmodel;

	public AbbAsset() {
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

	public String getChild() {
		return this.child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInstalldate() {
		return this.installdate;
	}

	public void setInstalldate(Date installdate) {
		this.installdate = installdate;
	}

	public String getLocdesc() {
		return this.locdesc;
	}

	public void setLocdesc(String locdesc) {
		this.locdesc = locdesc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getSerialnum() {
		return this.serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUdbelong() {
		return this.udbelong;
	}

	public void setUdbelong(String udbelong) {
		this.udbelong = udbelong;
	}

	public String getUdcontract() {
		return this.udcontract;
	}

	public void setUdcontract(String udcontract) {
		this.udcontract = udcontract;
	}

	public String getUdmodel() {
		return this.udmodel;
	}

	public void setUdmodel(String udmodel) {
		this.udmodel = udmodel;
	}

}