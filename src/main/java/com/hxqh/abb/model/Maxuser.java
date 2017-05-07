package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the MAXUSER database table.
 * 
 */
@Entity
@Table(name="Maxuser")
public class Maxuser implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAXUSER_MAXUSERID_GENERATOR", sequenceName="MAXUSER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAXUSER_MAXUSERID_GENERATOR")
	private Long maxuserid;

	private String databaseuserid;

	private String defaultrepfac;

	private String defaultrepfacsiteid;

	private String defsite;

	private String defstoreroom;

	private Integer failedlogins;

	private Integer forceexpiration;

	private Integer inactivesites;

	private Integer isconsultant;

	private String loginid;

	private String memo;

	@Column(name="\"PASSWORD\"")
	private byte[] password;

	private String personid;

	private Timestamp pwexpiration;

	//sprivate String pwhIntegeranswer;

	//private String pwhIntegerquestion;

	private Integer querywithsite;

	private Long rowstamp;

	private Integer screenreader;

	private Integer sidenav;

	@Column(name="\"STATUS\"")
	private String status;

	private String storeroomsite;

	private Integer sysuser;

	@Column(name="\"TYPE\"")
	private String type;

	@Column(name="\"USERID\"")
	private String userid;

	public Maxuser() {
	}

	public Long getMaxuserid() {
		return this.maxuserid;
	}

	public void setMaxuserid(Long maxuserid) {
		this.maxuserid = maxuserid;
	}

	public String getDatabaseuserid() {
		return this.databaseuserid;
	}

	public void setDatabaseuserid(String databaseuserid) {
		this.databaseuserid = databaseuserid;
	}

	public String getDefaultrepfac() {
		return this.defaultrepfac;
	}

	public void setDefaultrepfac(String defaultrepfac) {
		this.defaultrepfac = defaultrepfac;
	}

	public String getDefaultrepfacsiteid() {
		return this.defaultrepfacsiteid;
	}

	public void setDefaultrepfacsiteid(String defaultrepfacsiteid) {
		this.defaultrepfacsiteid = defaultrepfacsiteid;
	}

	public String getDefsite() {
		return this.defsite;
	}

	public void setDefsite(String defsite) {
		this.defsite = defsite;
	}

	public String getDefstoreroom() {
		return this.defstoreroom;
	}

	public void setDefstoreroom(String defstoreroom) {
		this.defstoreroom = defstoreroom;
	}

	public Integer getFailedlogins() {
		return this.failedlogins;
	}

	public void setFailedlogins(Integer failedlogins) {
		this.failedlogins = failedlogins;
	}

	public Integer getForceexpiration() {
		return this.forceexpiration;
	}

	public void setForceexpiration(Integer forceexpiration) {
		this.forceexpiration = forceexpiration;
	}

	public Integer getInactivesites() {
		return this.inactivesites;
	}

	public void setInactivesites(Integer inactivesites) {
		this.inactivesites = inactivesites;
	}

	public Integer getIsconsultant() {
		return this.isconsultant;
	}

	public void setIsconsultant(Integer isconsultant) {
		this.isconsultant = isconsultant;
	}

	public String getLoginid() {
		return this.loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public byte[] getPassword() {
		return this.password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public Timestamp getPwexpiration() {
		return this.pwexpiration;
	}

	public void setPwexpiration(Timestamp pwexpiration) {
		this.pwexpiration = pwexpiration;
	}

//	public String getPwhIntegeranswer() {
//		return this.pwhIntegeranswer;
//	}
//
//	public void setPwhIntegeranswer(String pwhIntegeranswer) {
//		this.pwhIntegeranswer = pwhIntegeranswer;
//	}

//	public String getPwhIntegerquestion() {
//		return this.pwhIntegerquestion;
//	}
//
//	public void setPwhIntegerquestion(String pwhIntegerquestion) {
//		this.pwhIntegerquestion = pwhIntegerquestion;
//	}

	public Integer getQuerywithsite() {
		return this.querywithsite;
	}

	public void setQuerywithsite(Integer querywithsite) {
		this.querywithsite = querywithsite;
	}

	public Long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public Integer getScreenreader() {
		return this.screenreader;
	}

	public void setScreenreader(Integer screenreader) {
		this.screenreader = screenreader;
	}

	public Integer getSidenav() {
		return this.sidenav;
	}

	public void setSidenav(Integer sidenav) {
		this.sidenav = sidenav;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStoreroomsite() {
		return this.storeroomsite;
	}

	public void setStoreroomsite(String storeroomsite) {
		this.storeroomsite = storeroomsite;
	}

	public Integer getSysuser() {
		return this.sysuser;
	}

	public void setSysuser(Integer sysuser) {
		this.sysuser = sysuser;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}