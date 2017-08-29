package com.hxqh.abb.model.searchdto;

import java.math.BigDecimal;


/**
 * The persistent class for the ABB_INVENTORY database table.
 * 
 */
public class InventorySearchDto {
	private static final long serialVersionUID = 1L;

	private long inventoryid;

	private BigDecimal curbal;

	private String description;

	private String itemnum;

	private String location;

	private String siteid;

	private String udsapnum;

	public InventorySearchDto() {
	}

	public long getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(long inventoryid) {
		this.inventoryid = inventoryid;
	}

	public BigDecimal getCurbal() {
		return this.curbal;
	}

	public void setCurbal(BigDecimal curbal) {
		this.curbal = curbal;
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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getUdsapnum() {
		return this.udsapnum;
	}

	public void setUdsapnum(String udsapnum) {
		this.udsapnum = udsapnum;
	}

}