package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_ASSET_LOCATION database table.
 * 
 */
@Entity
@Table(name="ABB_ASSET_LOCATION")
public class AbbAssetLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	private String adddesc;

	private String description;

	private String dimension;

	@Column(name="\"LOCATION\"")
	private String location;

	@Id
	private long locationsid;

	private String longitude;

	private String orgid;

	private String udcontact;

	private String udphone;

	public AbbAssetLocation() {
	}

	public String getAdddesc() {
		return this.adddesc;
	}

	public void setAdddesc(String adddesc) {
		this.adddesc = adddesc;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDimension() {
		return this.dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getLocationsid() {
		return this.locationsid;
	}

	public void setLocationsid(long locationsid) {
		this.locationsid = locationsid;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getUdcontact() {
		return this.udcontact;
	}

	public void setUdcontact(String udcontact) {
		this.udcontact = udcontact;
	}

	public String getUdphone() {
		return this.udphone;
	}

	public void setUdphone(String udphone) {
		this.udphone = udphone;
	}

}