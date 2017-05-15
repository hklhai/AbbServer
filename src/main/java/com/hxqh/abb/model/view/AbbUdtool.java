package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_UDTOOL database table.
 * 
 */
@Entity
@Table(name="ABB_UDTOOL")
public class AbbUdtool implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	private String displayname;

	private String locationsite;

	@Column(name="\"STATUS\"")
	private String status;

	private String toolnum;

	@Id
	private long udtoolid;

	public AbbUdtool() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getLocationsite() {
		return this.locationsite;
	}

	public void setLocationsite(String locationsite) {
		this.locationsite = locationsite;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToolnum() {
		return this.toolnum;
	}

	public void setToolnum(String toolnum) {
		this.toolnum = toolnum;
	}

	public long getUdtoolid() {
		return this.udtoolid;
	}

	public void setUdtoolid(long udtoolid) {
		this.udtoolid = udtoolid;
	}

}