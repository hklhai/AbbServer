package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_LOCATION_MAP database table.
 * 
 */
@Entity
@Table(name="ABB_LOCATION_MAP")
public class AbbLocationMap implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	private String dimension;

	@Column(name="\"LOCATION\"")
	private String location;

	@Id
	private String locationsid;

	private String longitude;

	@Column(name="\"STATUS\"")
	private long status;

	public AbbLocationMap() {
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

	public String getLocationsid() {
		return this.locationsid;
	}

	public void setLocationsid(String locationsid) {
		this.locationsid = locationsid;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

}