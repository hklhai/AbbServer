package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the UDTOOL database table.
 * 
 */
@Entity
@Table(name="Udtool")
public class Udtool implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UDTOOL_UDTOOLID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDTOOL_UDTOOLID_GENERATOR")
	private long udtoolid;

	private String area;

	private String changeby;

	private Timestamp changedate;

	private String checkby;

	private int chkfrequency;

	private String chkfrequnit;

	@Temporal(TemporalType.DATE)
	private Date chknextdate;

	private String department;

	private String description;

	private String enterby;

	private Timestamp enterdate;

	private String finnum;

	private int hasld;

	private int islend;

	private String keeper;

	@Temporal(TemporalType.DATE)
	private Date lastchkdate;

	private String lastchkresult;

	private String manufacturer;

	private String meaarea;

	private String model;

	private String orgid;

	@Column(name="\"PRECISION\"")
	private String precision;

	private String remark;

	private long rowstamp;

	private String serial;

	private String site;

	@Column(name="\"STATUS\"")
	private String status;

	private String toolnum;

	private String tooltype;

	private String ueslife;

	private String usefor;

	public Udtool() {
	}

	public long getUdtoolid() {
		return this.udtoolid;
	}

	public void setUdtoolid(long udtoolid) {
		this.udtoolid = udtoolid;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getChangeby() {
		return this.changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Timestamp getChangedate() {
		return this.changedate;
	}

	public void setChangedate(Timestamp changedate) {
		this.changedate = changedate;
	}

	public String getCheckby() {
		return this.checkby;
	}

	public void setCheckby(String checkby) {
		this.checkby = checkby;
	}

	public int getChkfrequency() {
		return this.chkfrequency;
	}

	public void setChkfrequency(int chkfrequency) {
		this.chkfrequency = chkfrequency;
	}

	public String getChkfrequnit() {
		return this.chkfrequnit;
	}

	public void setChkfrequnit(String chkfrequnit) {
		this.chkfrequnit = chkfrequnit;
	}

	public Date getChknextdate() {
		return this.chknextdate;
	}

	public void setChknextdate(Date chknextdate) {
		this.chknextdate = chknextdate;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public Timestamp getEnterdate() {
		return this.enterdate;
	}

	public void setEnterdate(Timestamp enterdate) {
		this.enterdate = enterdate;
	}

	public String getFinnum() {
		return this.finnum;
	}

	public void setFinnum(String finnum) {
		this.finnum = finnum;
	}

	public int getHasld() {
		return this.hasld;
	}

	public void setHasld(int hasld) {
		this.hasld = hasld;
	}

	public int getIslend() {
		return this.islend;
	}

	public void setIslend(int islend) {
		this.islend = islend;
	}

	public String getKeeper() {
		return this.keeper;
	}

	public void setKeeper(String keeper) {
		this.keeper = keeper;
	}

	public Date getLastchkdate() {
		return this.lastchkdate;
	}

	public void setLastchkdate(Date lastchkdate) {
		this.lastchkdate = lastchkdate;
	}

	public String getLastchkresult() {
		return this.lastchkresult;
	}

	public void setLastchkresult(String lastchkresult) {
		this.lastchkresult = lastchkresult;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMeaarea() {
		return this.meaarea;
	}

	public void setMeaarea(String meaarea) {
		this.meaarea = meaarea;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getPrecision() {
		return this.precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToolnum() {
		return this.toolnum;
	}

	public void setToolnum(String toolnum) {
		this.toolnum = toolnum;
	}

	public String getTooltype() {
		return this.tooltype;
	}

	public void setTooltype(String tooltype) {
		this.tooltype = tooltype;
	}

	public String getUeslife() {
		return this.ueslife;
	}

	public void setUeslife(String ueslife) {
		this.ueslife = ueslife;
	}

	public String getUsefor() {
		return this.usefor;
	}

	public void setUsefor(String usefor) {
		this.usefor = usefor;
	}

}