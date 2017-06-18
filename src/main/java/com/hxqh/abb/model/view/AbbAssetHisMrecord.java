package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ABB_ASSET_HIS_MRECORD database table.
 * 
 */
@Entity
@Table(name="ABB_ASSET_HIS_MRECORD")
public class AbbAssetHisMrecord implements Serializable {
	private static final long serialVersionUID = 1L;

	private String classstructureid;

	private String contractno;

	private String customercontact;

	private String description;

	private String serviceengineer;

	@Id
	private long udmrecordid;

	private String udmrecordnum;

	private Timestamp workdate;

	public AbbAssetHisMrecord() {
	}

	public String getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getContractno() {
		return this.contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	public String getCustomercontact() {
		return this.customercontact;
	}

	public void setCustomercontact(String customercontact) {
		this.customercontact = customercontact;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceengineer() {
		return this.serviceengineer;
	}

	public void setServiceengineer(String serviceengineer) {
		this.serviceengineer = serviceengineer;
	}

	public long getUdmrecordid() {
		return this.udmrecordid;
	}

	public void setUdmrecordid(long udmrecordid) {
		this.udmrecordid = udmrecordid;
	}

	public String getUdmrecordnum() {
		return this.udmrecordnum;
	}

	public void setUdmrecordnum(String udmrecordnum) {
		this.udmrecordnum = udmrecordnum;
	}

	public Timestamp getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(Timestamp workdate) {
		this.workdate = workdate;
	}

}