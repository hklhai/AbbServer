package com.hxqh.abb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INVENTORY database table.
 * 
 */
@Entity
@Table(name="Inventory")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVENTORY_INVENTORYID_GENERATOR", sequenceName="INVENTORYSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVENTORY_INVENTORYID_GENERATOR")
	private long inventoryid;

	private String abctype;

	private String binnum;

	private String catalogcode;

	private String category;

	private Integer ccf;

	private Integer consignment;

	private String consvendor;

	private String controlacc;

	private String costtype;

	private Integer deliverytime;

	private String dfltstagebin;

	private String externalrefid;

	private Integer frequency;

	private String frequnit;

	private String glaccount;

	private Integer hardresissue;

	private Integer internal;

	private String invcostadjacc;

	private String invgentype;

	private BigDecimal issue1yrago;

	private BigDecimal issue2yrago;

	private BigDecimal issue3yrago;

	private String issueunit;

	private BigDecimal issueytd;

	private String itemnum;

	private String itemsetid;

	private Date lastissuedate;

	@Column(name="\"LOCATION\"")
	private String location;

	private String manufacturer;

	private BigDecimal maxlevel;

	private BigDecimal minlevel;

	private String modelnum;

	@Temporal(TemporalType.DATE)
	private Date nextinvoicedate;

	private BigDecimal orderqty;

	private String orderunit;

	private String orgid;

	private String ownersysid;

	private BigDecimal receipttolerance;

	private Integer reorder;

	private long rowstamp;

	private String sendersysid;

	private String shrinkageacc;

	private String siteid;

	private String sourcesysid;

	private BigDecimal sstock;

	@Column(name="\"STATUS\"")
	private String status;

	private Date statusdate;

	private String storeloc;

	private String storelocsiteid;

	private String uddescription;

	private String udsapnum;

	private String vendor;

	public Inventory() {
	}

	public long getInventoryid() {
		return this.inventoryid;
	}

	public void setInventoryid(long inventoryid) {
		this.inventoryid = inventoryid;
	}

	public String getAbctype() {
		return this.abctype;
	}

	public void setAbctype(String abctype) {
		this.abctype = abctype;
	}

	public String getBinnum() {
		return this.binnum;
	}

	public void setBinnum(String binnum) {
		this.binnum = binnum;
	}

	public String getCatalogcode() {
		return this.catalogcode;
	}

	public void setCatalogcode(String catalogcode) {
		this.catalogcode = catalogcode;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCcf() {
		return this.ccf;
	}

	public void setCcf(Integer ccf) {
		this.ccf = ccf;
	}

	public Integer getConsignment() {
		return this.consignment;
	}

	public void setConsignment(Integer consignment) {
		this.consignment = consignment;
	}

	public String getConsvendor() {
		return this.consvendor;
	}

	public void setConsvendor(String consvendor) {
		this.consvendor = consvendor;
	}

	public String getControlacc() {
		return this.controlacc;
	}

	public void setControlacc(String controlacc) {
		this.controlacc = controlacc;
	}

	public String getCosttype() {
		return this.costtype;
	}

	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}

	public Integer getDeliverytime() {
		return this.deliverytime;
	}

	public void setDeliverytime(Integer deliverytime) {
		this.deliverytime = deliverytime;
	}

	public String getDfltstagebin() {
		return this.dfltstagebin;
	}

	public void setDfltstagebin(String dfltstagebin) {
		this.dfltstagebin = dfltstagebin;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public Integer getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getFrequnit() {
		return this.frequnit;
	}

	public void setFrequnit(String frequnit) {
		this.frequnit = frequnit;
	}

	public String getGlaccount() {
		return this.glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public Integer getHardresissue() {
		return this.hardresissue;
	}

	public void setHardresissue(Integer hardresissue) {
		this.hardresissue = hardresissue;
	}

	public Integer getInternal() {
		return internal;
	}

	public void setInternal(Integer internal) {
		this.internal = internal;
	}

	public String getInvcostadjacc() {
		return this.invcostadjacc;
	}

	public void setInvcostadjacc(String invcostadjacc) {
		this.invcostadjacc = invcostadjacc;
	}

	public String getInvgentype() {
		return this.invgentype;
	}

	public void setInvgentype(String invgentype) {
		this.invgentype = invgentype;
	}

	public BigDecimal getIssue1yrago() {
		return this.issue1yrago;
	}

	public void setIssue1yrago(BigDecimal issue1yrago) {
		this.issue1yrago = issue1yrago;
	}

	public BigDecimal getIssue2yrago() {
		return this.issue2yrago;
	}

	public void setIssue2yrago(BigDecimal issue2yrago) {
		this.issue2yrago = issue2yrago;
	}

	public BigDecimal getIssue3yrago() {
		return this.issue3yrago;
	}

	public void setIssue3yrago(BigDecimal issue3yrago) {
		this.issue3yrago = issue3yrago;
	}

	public String getIssueunit() {
		return this.issueunit;
	}

	public void setIssueunit(String issueunit) {
		this.issueunit = issueunit;
	}

	public BigDecimal getIssueytd() {
		return this.issueytd;
	}

	public void setIssueytd(BigDecimal issueytd) {
		this.issueytd = issueytd;
	}

	public String getItemnum() {
		return this.itemnum;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	public String getItemsetid() {
		return this.itemsetid;
	}

	public void setItemsetid(String itemsetid) {
		this.itemsetid = itemsetid;
	}

	public Date getLastissuedate() {
		return this.lastissuedate;
	}

	public void setLastissuedate(Date lastissuedate) {
		this.lastissuedate = lastissuedate;
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

	public BigDecimal getMaxlevel() {
		return this.maxlevel;
	}

	public void setMaxlevel(BigDecimal maxlevel) {
		this.maxlevel = maxlevel;
	}

	public BigDecimal getMinlevel() {
		return this.minlevel;
	}

	public void setMinlevel(BigDecimal minlevel) {
		this.minlevel = minlevel;
	}

	public String getModelnum() {
		return this.modelnum;
	}

	public void setModelnum(String modelnum) {
		this.modelnum = modelnum;
	}

	public Date getNextinvoicedate() {
		return this.nextinvoicedate;
	}

	public void setNextinvoicedate(Date nextinvoicedate) {
		this.nextinvoicedate = nextinvoicedate;
	}

	public BigDecimal getOrderqty() {
		return this.orderqty;
	}

	public void setOrderqty(BigDecimal orderqty) {
		this.orderqty = orderqty;
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

	public String getOwnersysid() {
		return this.ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public BigDecimal getReceipttolerance() {
		return this.receipttolerance;
	}

	public void setReceipttolerance(BigDecimal receipttolerance) {
		this.receipttolerance = receipttolerance;
	}

	public Integer getReorder() {
		return this.reorder;
	}

	public void setReorder(Integer reorder) {
		this.reorder = reorder;
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

	public String getShrinkageacc() {
		return this.shrinkageacc;
	}

	public void setShrinkageacc(String shrinkageacc) {
		this.shrinkageacc = shrinkageacc;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getSourcesysid() {
		return this.sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public BigDecimal getSstock() {
		return this.sstock;
	}

	public void setSstock(BigDecimal sstock) {
		this.sstock = sstock;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getStoreloc() {
		return this.storeloc;
	}

	public void setStoreloc(String storeloc) {
		this.storeloc = storeloc;
	}

	public String getStorelocsiteid() {
		return this.storelocsiteid;
	}

	public void setStorelocsiteid(String storelocsiteid) {
		this.storelocsiteid = storelocsiteid;
	}

	public String getUddescription() {
		return this.uddescription;
	}

	public void setUddescription(String uddescription) {
		this.uddescription = uddescription;
	}

	public String getUdsapnum() {
		return this.udsapnum;
	}

	public void setUdsapnum(String udsapnum) {
		this.udsapnum = udsapnum;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}