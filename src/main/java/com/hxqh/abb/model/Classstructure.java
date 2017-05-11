package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CLASSSTRUCTURE database table.
 * 
 */
@Entity
@Table(name="Classstructure")
public class Classstructure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLASSSTRUCTURE_CLASSSTRUCTUREUID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASSSTRUCTURE_CLASSSTRUCTUREUID_GENERATOR")
	private long classstructureuid;

	private String classificationid;

	private String classstructureid;

	private String description;

	private int genassetdesc;

	private int haschildren;

	private int hasld;

	private String langcode;

	private String orgid;

	@Column(name="\"PARENT\"")
	private String parent;

	private long rowstamp;

	private int showinassettopo;

	private String siteid;

	@Column(name="\"TYPE\"")
	private String type;

	private int useclassindesc;

	public Classstructure() {
	}

	public long getClassstructureuid() {
		return this.classstructureuid;
	}

	public void setClassstructureuid(long classstructureuid) {
		this.classstructureuid = classstructureuid;
	}

	public String getClassificationid() {
		return this.classificationid;
	}

	public void setClassificationid(String classificationid) {
		this.classificationid = classificationid;
	}

	public String getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGenassetdesc() {
		return this.genassetdesc;
	}

	public void setGenassetdesc(int genassetdesc) {
		this.genassetdesc = genassetdesc;
	}

	public int getHaschildren() {
		return this.haschildren;
	}

	public void setHaschildren(int haschildren) {
		this.haschildren = haschildren;
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

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public int getShowinassettopo() {
		return this.showinassettopo;
	}

	public void setShowinassettopo(int showinassettopo) {
		this.showinassettopo = showinassettopo;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUseclassindesc() {
		return this.useclassindesc;
	}

	public void setUseclassindesc(int useclassindesc) {
		this.useclassindesc = useclassindesc;
	}

}