package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the METER database table.
 * 
 */
@Entity
@Table(name="Meter")
public class Meter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="METER_METERID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="METER_METERID_GENERATOR")
	private long meterid;

	private String description;

	private String domainid;

	private Integer hasld;

	private String langcode;

	private String measureunitid;

	private String metername;

	private String metertype;

	private String readingtype;

	private long rowstamp;

	public Meter() {
	}

	public long getMeterid() {
		return this.meterid;
	}

	public void setMeterid(long meterid) {
		this.meterid = meterid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomainid() {
		return this.domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getMeasureunitid() {
		return this.measureunitid;
	}

	public void setMeasureunitid(String measureunitid) {
		this.measureunitid = measureunitid;
	}

	public String getMetername() {
		return this.metername;
	}

	public void setMetername(String metername) {
		this.metername = metername;
	}

	public String getMetertype() {
		return this.metertype;
	}

	public void setMetertype(String metertype) {
		this.metertype = metertype;
	}

	public String getReadingtype() {
		return this.readingtype;
	}

	public void setReadingtype(String readingtype) {
		this.readingtype = readingtype;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

}