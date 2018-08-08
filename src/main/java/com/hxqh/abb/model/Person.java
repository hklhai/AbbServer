package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@Table(name="Person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_PERSONUID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_PERSONUID_GENERATOR")
	private long personuid;

	private Integer acceptingwfmail;

	private String addressline1;

	private String addressline2;

	private String addressline3;

	private String billtoaddress;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String caltype;

	private String city;

	private String country;

	private String county;

	private String delegate;

	@Temporal(TemporalType.DATE)
	private Date delegatefromdate;

	@Temporal(TemporalType.DATE)
	private Date delegatetodate;

	private String department;

	private Integer deviceclass;

	private String dfltapp;

	private String displayname;

	private String droppoint;

	private String employeetype;

	private String externalrefid;

	private String firstname;

	private Integer hasld;

	@Temporal(TemporalType.DATE)
	private Date hiredate;

	@Column(name="IM_ID")
	private String imId;

	private String jobcode;

	private String langcode;

	@Column(name="\"LANGUAGE\"")
	private String language;

	@Temporal(TemporalType.DATE)
	private Date lastevaldate;

	private String lastname;

	@Column(name="\"LOCALE\"")
	private String locale;

	@Column(name="\"LOCATION\"")
	private String location;

	private String locationorg;

	private String locationsite;

	private Integer loctoservreq;

	@Temporal(TemporalType.DATE)
	private Date nextevaldate;

	private String ownergroup;

	private String ownersysid;

	private String pcardexpdate;

	private String pcardnum;

	private String pcardtype;

	private String pcardverification;

	private String personid;

	private String postalcode;

	private String primarysms;

	private String regiondistrict;

	private long rowstamp;

	private String sendersysid;

	private String shiptoaddress;

	private String sourcesysid;

	private String stateprovince;

	@Column(name="\"STATUS\"")
	private String status;

	private Timestamp statusdate;

	private String supervisor;

	@Temporal(TemporalType.DATE)
	private Date terminationdate;

	@Column(name="\"TIMEZONE\"")
	private String timezone;

	private String title;

	private String transemailelection;

	private String udccio;

	private Integer udispmanager;

	private Integer vip;

	private String wfmailelection;

	private Integer wopriority;

	private String favorites;

	private String servicesite;

	private String suoxie;

	private String ccio;

	public Person() {
	}

	public String getServicesite() {
		return servicesite;
	}

	public void setServicesite(String servicesite) {
		this.servicesite = servicesite;
	}

	public String getSuoxie() {
		return suoxie;
	}

	public void setSuoxie(String suoxie) {
		this.suoxie = suoxie;
	}

	public String getCcio() {
		return ccio;
	}

	public void setCcio(String ccio) {
		this.ccio = ccio;
	}

	public long getPersonuid() {
		return this.personuid;
	}

	public void setPersonuid(long personuid) {
		this.personuid = personuid;
	}

	public Integer getAcceptingwfmail() {
		return this.acceptingwfmail;
	}

	public void setAcceptingwfmail(Integer acceptingwfmail) {
		this.acceptingwfmail = acceptingwfmail;
	}

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getAddressline3() {
		return this.addressline3;
	}

	public void setAddressline3(String addressline3) {
		this.addressline3 = addressline3;
	}

	public String getBilltoaddress() {
		return this.billtoaddress;
	}

	public void setBilltoaddress(String billtoaddress) {
		this.billtoaddress = billtoaddress;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCaltype() {
		return this.caltype;
	}

	public void setCaltype(String caltype) {
		this.caltype = caltype;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDelegate() {
		return this.delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}

	public Date getDelegatefromdate() {
		return this.delegatefromdate;
	}

	public void setDelegatefromdate(Date delegatefromdate) {
		this.delegatefromdate = delegatefromdate;
	}

	public Date getDelegatetodate() {
		return this.delegatetodate;
	}

	public void setDelegatetodate(Date delegatetodate) {
		this.delegatetodate = delegatetodate;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getDeviceclass() {
		return this.deviceclass;
	}

	public void setDeviceclass(Integer deviceclass) {
		this.deviceclass = deviceclass;
	}

	public String getDfltapp() {
		return this.dfltapp;
	}

	public void setDfltapp(String dfltapp) {
		this.dfltapp = dfltapp;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getDroppoint() {
		return this.droppoint;
	}

	public void setDroppoint(String droppoint) {
		this.droppoint = droppoint;
	}

	public String getEmployeetype() {
		return this.employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getImId() {
		return this.imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public String getJobcode() {
		return this.jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLastevaldate() {
		return this.lastevaldate;
	}

	public void setLastevaldate(Date lastevaldate) {
		this.lastevaldate = lastevaldate;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationorg() {
		return this.locationorg;
	}

	public void setLocationorg(String locationorg) {
		this.locationorg = locationorg;
	}

	public String getLocationsite() {
		return this.locationsite;
	}

	public void setLocationsite(String locationsite) {
		this.locationsite = locationsite;
	}

	public Integer getLoctoservreq() {
		return this.loctoservreq;
	}

	public void setLoctoservreq(Integer loctoservreq) {
		this.loctoservreq = loctoservreq;
	}

	public Date getNextevaldate() {
		return this.nextevaldate;
	}

	public void setNextevaldate(Date nextevaldate) {
		this.nextevaldate = nextevaldate;
	}

	public String getOwnergroup() {
		return this.ownergroup;
	}

	public void setOwnergroup(String ownergroup) {
		this.ownergroup = ownergroup;
	}

	public String getOwnersysid() {
		return this.ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public String getPcardexpdate() {
		return this.pcardexpdate;
	}

	public void setPcardexpdate(String pcardexpdate) {
		this.pcardexpdate = pcardexpdate;
	}

	public String getPcardnum() {
		return this.pcardnum;
	}

	public void setPcardnum(String pcardnum) {
		this.pcardnum = pcardnum;
	}

	public String getPcardtype() {
		return this.pcardtype;
	}

	public void setPcardtype(String pcardtype) {
		this.pcardtype = pcardtype;
	}

	public String getPcardverification() {
		return this.pcardverification;
	}

	public void setPcardverification(String pcardverification) {
		this.pcardverification = pcardverification;
	}

	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPrimarysms() {
		return this.primarysms;
	}

	public void setPrimarysms(String primarysms) {
		this.primarysms = primarysms;
	}

	public String getRegiondistrict() {
		return this.regiondistrict;
	}

	public void setRegiondistrict(String regiondistrict) {
		this.regiondistrict = regiondistrict;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSendersysid() {
		return this.sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getShiptoaddress() {
		return this.shiptoaddress;
	}

	public void setShiptoaddress(String shiptoaddress) {
		this.shiptoaddress = shiptoaddress;
	}

	public String getSourcesysid() {
		return this.sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public String getStateprovince() {
		return this.stateprovince;
	}

	public void setStateprovince(String stateprovince) {
		this.stateprovince = stateprovince;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Timestamp statusdate) {
		this.statusdate = statusdate;
	}

	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public Date getTerminationdate() {
		return this.terminationdate;
	}

	public void setTerminationdate(Date terminationdate) {
		this.terminationdate = terminationdate;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTransemailelection() {
		return this.transemailelection;
	}

	public void setTransemailelection(String transemailelection) {
		this.transemailelection = transemailelection;
	}

	public String getUdccio() {
		return this.udccio;
	}

	public void setUdccio(String udccio) {
		this.udccio = udccio;
	}

	public Integer getUdispmanager() {
		return this.udispmanager;
	}

	public void setUdispmanager(Integer udispmanager) {
		this.udispmanager = udispmanager;
	}

	public Integer getVip() {
		return this.vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public String getWfmailelection() {
		return this.wfmailelection;
	}

	public void setWfmailelection(String wfmailelection) {
		this.wfmailelection = wfmailelection;
	}

	public Integer getWopriority() {
		return this.wopriority;
	}

	public void setWopriority(Integer wopriority) {
		this.wopriority = wopriority;
	}

	public String getFavorites() {
		return favorites;
	}

	public void setFavorites(String favorites) {
		this.favorites = favorites;
	}
}