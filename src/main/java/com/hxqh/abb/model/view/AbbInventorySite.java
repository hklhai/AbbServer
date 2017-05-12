package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_INVENTORY_SITE database table.
 * 
 */
@Entity
@Table(name="ABB_INVENTORY_SITE")
public class AbbInventorySite implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	@Id
	private String siteid;

	public AbbInventorySite() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

}