package com.hxqh.abb.model.view;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the ABB_ASSET database table.
 * 
 */
@Entity
@Table(name="ABB_LOCATION")
public class AbbLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	private String location;

	@Id
	private long locationsid;

	private String description;

	@Column(name="\"PARENT\"")
	private String parent;

	private String type;

	private String status;

	public AbbLocation() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getLocationsid() {
		return locationsid;
	}

	public void setLocationsid(long locationsid) {
		this.locationsid = locationsid;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
}