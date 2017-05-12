package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_INVENTORY_LOCATION database table.
 * 
 */
@Entity
@Table(name="ABB_INVENTORY_LOCATION")
public class AbbInventoryLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	@Id
	@Column(name="\"LOCATION\"")
	private String location;

	public AbbInventoryLocation() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}