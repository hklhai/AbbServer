package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WXUSER database table.
 * 
 */
@Entity
@Table(name="Wxuser")
public class Wxuser implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WXUSER_WXUSERID_GENERATOR", sequenceName="WXUSERSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WXUSER_WXUSERID_GENERATOR")
	private Long wxuserid;

	@Column(name="\"ADDRESS\"")
	private String address;

	private String company;

	private String description;

	private String displayname;

	private Integer hasld;

	@Column(name="\"LOCATION\"")
	private String location;

	private String mail;

	@Column(name="\"PASSWORD\"")
	private String password;

	private String phone;

	private Long rowstamp;

	private String siteid;

	@Column(name="\"STATUS\"")
	private String status;

	@Column(name="\"USERID\"")
	private String userid;

	private String usernum;

	public Wxuser() {
	}

	public Long getWxuserid() {
		return this.wxuserid;
	}

	public void setWxuserid(Long wxuserid) {
		this.wxuserid = wxuserid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsernum() {
		return this.usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}

}