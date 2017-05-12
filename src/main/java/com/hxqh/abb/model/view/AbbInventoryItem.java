package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_INVENTORY_ITEM database table.
 * 
 */
@Entity
@Table(name="ABB_INVENTORY_ITEM")
public class AbbInventoryItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	@Id
	private String itemnum;

	public AbbInventoryItem() {
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

}