package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SERVICEADDRESS database table.
 * 
 */
@Entity
@Table(name="Serviceaddress")
public class Serviceaddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SERVICEADDRESS_SERVICEADDRESSID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SERVICEADDRESS_SERVICEADDRESSID_GENERATOR")
	private long serviceaddressid;

	private String addresscode;

	private String addressline2;

	private String addressline3;

	private String city;

	private String country;

	private String county;

	private String description;

	private String directions;

	private String formattedaddress;

	private String geocode;

	private int hasld;

	private String langcode;

	private BigDecimal latitudey;

	private BigDecimal longitudex;

	private String objectname;

	private String orgid;

	@Column(name="\"PARENT\"")
	private String parent;

	private String postalcode;

	private String referencepoint;

	private String regiondistrict;

	private long rowstamp;

	private String siteid;

	private String staddrdirprfx;

	private String staddrdirsfx;

	private String staddrnumber;

	private String staddrstreet;

	private String staddrsttype;

	private String staddrunitnum;

	private String stateprovince;

	private String streetaddress;

	@Column(name="\"TIMEZONE\"")
	private String timezone;

	public Serviceaddress() {
	}

	public long getServiceaddressid() {
		return this.serviceaddressid;
	}

	public void setServiceaddressid(long serviceaddressid) {
		this.serviceaddressid = serviceaddressid;
	}

	public String getAddresscode() {
		return this.addresscode;
	}

	public void setAddresscode(String addresscode) {
		this.addresscode = addresscode;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return this.directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getFormattedaddress() {
		return this.formattedaddress;
	}

	public void setFormattedaddress(String formattedaddress) {
		this.formattedaddress = formattedaddress;
	}

	public String getGeocode() {
		return this.geocode;
	}

	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}

	public int getHasld() {
		return this.hasld;
	}

	public void setHasld(int hasld) {
		this.hasld = hasld;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public BigDecimal getLatitudey() {
		return this.latitudey;
	}

	public void setLatitudey(BigDecimal latitudey) {
		this.latitudey = latitudey;
	}

	public BigDecimal getLongitudex() {
		return this.longitudex;
	}

	public void setLongitudex(BigDecimal longitudex) {
		this.longitudex = longitudex;
	}

	public String getObjectname() {
		return this.objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getReferencepoint() {
		return this.referencepoint;
	}

	public void setReferencepoint(String referencepoint) {
		this.referencepoint = referencepoint;
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

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getStaddrdirprfx() {
		return this.staddrdirprfx;
	}

	public void setStaddrdirprfx(String staddrdirprfx) {
		this.staddrdirprfx = staddrdirprfx;
	}

	public String getStaddrdirsfx() {
		return this.staddrdirsfx;
	}

	public void setStaddrdirsfx(String staddrdirsfx) {
		this.staddrdirsfx = staddrdirsfx;
	}

	public String getStaddrnumber() {
		return this.staddrnumber;
	}

	public void setStaddrnumber(String staddrnumber) {
		this.staddrnumber = staddrnumber;
	}

	public String getStaddrstreet() {
		return this.staddrstreet;
	}

	public void setStaddrstreet(String staddrstreet) {
		this.staddrstreet = staddrstreet;
	}

	public String getStaddrsttype() {
		return this.staddrsttype;
	}

	public void setStaddrsttype(String staddrsttype) {
		this.staddrsttype = staddrsttype;
	}

	public String getStaddrunitnum() {
		return this.staddrunitnum;
	}

	public void setStaddrunitnum(String staddrunitnum) {
		this.staddrunitnum = staddrunitnum;
	}

	public String getStateprovince() {
		return this.stateprovince;
	}

	public void setStateprovince(String stateprovince) {
		this.stateprovince = stateprovince;
	}

	public String getStreetaddress() {
		return this.streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

}