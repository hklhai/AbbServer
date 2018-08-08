package com.hxqh.abb.model.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the V_PERSON database table.
 * 
 */
@Entity
@Table(name="V_PERSON")
public class VPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	private String country;

	private String displayname;

	private String emailaddress;

	private String personid;

	@Id
	private Long personuid;

	private String phonenum;

	public VPerson() {
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public Long getPersonuid() {
		return this.personuid;
	}

	public void setPersonuid(Long personuid) {
		this.personuid = personuid;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

}