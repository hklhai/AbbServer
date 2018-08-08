package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_INVUSELINEREFUND database table.
 * 
 */
@Entity
@Table(name="V_INVUSELINEREFUND")
public class VInvuselinerefund implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	private String enterby;

	private String frombin;

	@Id
	private long invuselineid;

	private String issueunit;

	private String itemnum;

	private BigDecimal quantity;

	private String remark;

	private String udmodel;

	private String udrecipient;

	private String usetype;

	public VInvuselinerefund() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnterby() {
		return this.enterby;
	}

	public void setEnterby(String enterby) {
		this.enterby = enterby;
	}

	public String getFrombin() {
		return this.frombin;
	}

	public void setFrombin(String frombin) {
		this.frombin = frombin;
	}

	public long getInvuselineid() {
		return this.invuselineid;
	}

	public void setInvuselineid(long invuselineid) {
		this.invuselineid = invuselineid;
	}

	public String getIssueunit() {
		return this.issueunit;
	}

	public void setIssueunit(String issueunit) {
		this.issueunit = issueunit;
	}

	public String getItemnum() {
		return this.itemnum;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUdmodel() {
		return this.udmodel;
	}

	public void setUdmodel(String udmodel) {
		this.udmodel = udmodel;
	}

	public String getUdrecipient() {
		return this.udrecipient;
	}

	public void setUdrecipient(String udrecipient) {
		this.udrecipient = udrecipient;
	}

	public String getUsetype() {
		return this.usetype;
	}

	public void setUsetype(String usetype) {
		this.usetype = usetype;
	}

}