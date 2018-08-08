package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


/**
 * The persistent class for the WPMATERIAL database table.
 * 
 */
@Entity
@Table(name="Wpmaterial")
public class Wpmaterial implements Serializable {
	private static final Long serialVersionUID = 1L;

	private String amcrew;

	private String amcrewtype;

	private String catalogcode;

	private String conditioncode;

	private String description;

	private Integer directreq;

	private Integer hasld;

	@Column(name="\"HOURS\"")
	private double hours;

	private String issueto;

	private String itemnum;

	private BigDecimal itemqty;

	private String itemsetid;

	private String langcode;

	private BigDecimal linecost;

	private String linetype;

	@Column(name="\"LOCATION\"")
	private String location;

	private String manufacturer;

	private Integer mktplcitem;

	private String modelnum;

	private String orderunit;

	private String orgid;

	private String pr;

	private Integer prlinenum;

	@Column(name="\"RATE\"")
	private BigDecimal rate;

	private Integer ratehaschanged;

	private String requestby;

	private String requestnum;

	private Date requiredate;

	private String restype;

	private Long rowstamp;

	private String siteid;

	private String storelocsite;

	private BigDecimal unitcost;

	private Integer unitcosthaschanged;

	private String vendor;

	private String vendorpackcode;

	private String vendorpackquantity;

	private BigDecimal vendorunitcost;

	private String vendorwarehouse;

	private String wonum;

	@Id
	private Long wpitemid;

	private Long wplaborref;

	private String wpm1;

	private String wpm2;

	private BigDecimal wpm3;

	private String wpm4;

	private BigDecimal wpm5;

	private String wpm6;

	public Wpmaterial() {
	}

	public String getAmcrew() {
		return this.amcrew;
	}

	public void setAmcrew(String amcrew) {
		this.amcrew = amcrew;
	}

	public String getAmcrewtype() {
		return this.amcrewtype;
	}

	public void setAmcrewtype(String amcrewtype) {
		this.amcrewtype = amcrewtype;
	}

	public String getCatalogcode() {
		return this.catalogcode;
	}

	public void setCatalogcode(String catalogcode) {
		this.catalogcode = catalogcode;
	}

	public String getConditioncode() {
		return this.conditioncode;
	}

	public void setConditioncode(String conditioncode) {
		this.conditioncode = conditioncode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDirectreq() {
		return this.directreq;
	}

	public void setDirectreq(Integer directreq) {
		this.directreq = directreq;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public double getHours() {
		return this.hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public String getIssueto() {
		return this.issueto;
	}

	public void setIssueto(String issueto) {
		this.issueto = issueto;
	}

	public String getItemnum() {
		return this.itemnum;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	public BigDecimal getItemqty() {
		return this.itemqty;
	}

	public void setItemqty(BigDecimal itemqty) {
		this.itemqty = itemqty;
	}

	public String getItemsetid() {
		return this.itemsetid;
	}

	public void setItemsetid(String itemsetid) {
		this.itemsetid = itemsetid;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public BigDecimal getLinecost() {
		return this.linecost;
	}

	public void setLinecost(BigDecimal linecost) {
		this.linecost = linecost;
	}

	public String getLinetype() {
		return this.linetype;
	}

	public void setLinetype(String linetype) {
		this.linetype = linetype;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getMktplcitem() {
		return this.mktplcitem;
	}

	public void setMktplcitem(Integer mktplcitem) {
		this.mktplcitem = mktplcitem;
	}

	public String getModelnum() {
		return this.modelnum;
	}

	public void setModelnum(String modelnum) {
		this.modelnum = modelnum;
	}

	public String getOrderunit() {
		return this.orderunit;
	}

	public void setOrderunit(String orderunit) {
		this.orderunit = orderunit;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getPr() {
		return this.pr;
	}

	public void setPr(String pr) {
		this.pr = pr;
	}

	public Integer getPrlinenum() {
		return this.prlinenum;
	}

	public void setPrlinenum(Integer prlinenum) {
		this.prlinenum = prlinenum;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Integer getRatehaschanged() {
		return this.ratehaschanged;
	}

	public void setRatehaschanged(Integer ratehaschanged) {
		this.ratehaschanged = ratehaschanged;
	}

	public String getRequestby() {
		return this.requestby;
	}

	public void setRequestby(String requestby) {
		this.requestby = requestby;
	}

	public String getRequestnum() {
		return this.requestnum;
	}

	public void setRequestnum(String requestnum) {
		this.requestnum = requestnum;
	}

	public Date getRequiredate() {
		return this.requiredate;
	}

	public void setRequiredate(Date requiredate) {
		this.requiredate = requiredate;
	}

	public String getRestype() {
		return this.restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
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

	public String getStorelocsite() {
		return this.storelocsite;
	}

	public void setStorelocsite(String storelocsite) {
		this.storelocsite = storelocsite;
	}

	public BigDecimal getUnitcost() {
		return this.unitcost;
	}

	public void setUnitcost(BigDecimal unitcost) {
		this.unitcost = unitcost;
	}

	public Integer getUnitcosthaschanged() {
		return this.unitcosthaschanged;
	}

	public void setUnitcosthaschanged(Integer unitcosthaschanged) {
		this.unitcosthaschanged = unitcosthaschanged;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendorpackcode() {
		return this.vendorpackcode;
	}

	public void setVendorpackcode(String vendorpackcode) {
		this.vendorpackcode = vendorpackcode;
	}

	public String getVendorpackquantity() {
		return this.vendorpackquantity;
	}

	public void setVendorpackquantity(String vendorpackquantity) {
		this.vendorpackquantity = vendorpackquantity;
	}

	public BigDecimal getVendorunitcost() {
		return this.vendorunitcost;
	}

	public void setVendorunitcost(BigDecimal vendorunitcost) {
		this.vendorunitcost = vendorunitcost;
	}

	public String getVendorwarehouse() {
		return this.vendorwarehouse;
	}

	public void setVendorwarehouse(String vendorwarehouse) {
		this.vendorwarehouse = vendorwarehouse;
	}

	public String getWonum() {
		return this.wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

	public Long getWpitemid() {
		return this.wpitemid;
	}

	public void setWpitemid(Long wpitemid) {
		this.wpitemid = wpitemid;
	}

	public Long getWplaborref() {
		return this.wplaborref;
	}

	public void setWplaborref(Long wplaborref) {
		this.wplaborref = wplaborref;
	}

	public String getWpm1() {
		return this.wpm1;
	}

	public void setWpm1(String wpm1) {
		this.wpm1 = wpm1;
	}

	public String getWpm2() {
		return this.wpm2;
	}

	public void setWpm2(String wpm2) {
		this.wpm2 = wpm2;
	}

	public BigDecimal getWpm3() {
		return this.wpm3;
	}

	public void setWpm3(BigDecimal wpm3) {
		this.wpm3 = wpm3;
	}

	public String getWpm4() {
		return this.wpm4;
	}

	public void setWpm4(String wpm4) {
		this.wpm4 = wpm4;
	}

	public BigDecimal getWpm5() {
		return this.wpm5;
	}

	public void setWpm5(BigDecimal wpm5) {
		this.wpm5 = wpm5;
	}

	public String getWpm6() {
		return this.wpm6;
	}

	public void setWpm6(String wpm6) {
		this.wpm6 = wpm6;
	}

}