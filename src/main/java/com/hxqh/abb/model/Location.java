package com.hxqh.abb.model;

import com.thoughtworks.xstream.XStream;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
public class Location  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCATIONS_LOCATIONSID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATIONS_LOCATIONSID_GENERATOR")
	private long locationsid;

	private int autowogen;

	private String billtoaddresscode;

	private String billtolaborcode;

	private String changeby;

	private Timestamp changedate;

	private String classstructureid;

	private String controlacc;

	private String curvaracc;

	private String description;

	private String dimension;

	private int disabled;

	private String externalrefid;

	private String gisparam1;

	private String gisparam2;

	private String gisparam3;

	private String glaccount;

	private int hasld;

	private String intlabrec;

	private String invcostadjacc;

	private String invoicevaracc;

	private String invowner;

	private int isdefault;

	private int isrepairfacility;

	private String langcode;

	@Column(name="\"LOCATION\"")
	private String location;

	private String longitude;

	private String material;

	private String oldcontrolacc;

	private String oldinvcostadjacc;

	private String oldshrinkageacc;

	private String orgid;

	private String ownersysid;

	@Temporal(TemporalType.DATE)
	private Date pluscduedate;

	private int pluscloop;

	private int pluscpmextdate;

	private String purchvaracc;

	private String receiptvaracc;

	private long rowstamp;

	private String saddresscode;

	private String sendersysid;

	private String serviceaddresscode;

	private String shiptoaddresscode;

	private String shiptolaborcode;

	private String shrinkageacc;

	private String siteid;

	private String sourcesysid;

	@Column(name="\"STATUS\"")
	private String status;

	private Timestamp statusdate;

	private String toolcontrolacc;

	@Column(name="\"TYPE\"")
	private String type;

	//private int udchkfre;

	private String udcontact;

	private String udcontract;

	private String udctrdesc;

	private String udphone;

	private String udstoretype;

	private int useinpopr;

	public Location() {
	}

	public long getLocationsid() {
		return this.locationsid;
	}

	public void setLocationsid(long locationsid) {
		this.locationsid = locationsid;
	}

	public int getAutowogen() {
		return this.autowogen;
	}

	public void setAutowogen(int autowogen) {
		this.autowogen = autowogen;
	}

	public String getBilltoaddresscode() {
		return this.billtoaddresscode;
	}

	public void setBilltoaddresscode(String billtoaddresscode) {
		this.billtoaddresscode = billtoaddresscode;
	}

	public String getBilltolaborcode() {
		return this.billtolaborcode;
	}

	public void setBilltolaborcode(String billtolaborcode) {
		this.billtolaborcode = billtolaborcode;
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

	public String getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getControlacc() {
		return this.controlacc;
	}

	public void setControlacc(String controlacc) {
		this.controlacc = controlacc;
	}

	public String getCurvaracc() {
		return this.curvaracc;
	}

	public void setCurvaracc(String curvaracc) {
		this.curvaracc = curvaracc;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDimension() {
		return this.dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public int getDisabled() {
		return this.disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getGisparam1() {
		return this.gisparam1;
	}

	public void setGisparam1(String gisparam1) {
		this.gisparam1 = gisparam1;
	}

	public String getGisparam2() {
		return this.gisparam2;
	}

	public void setGisparam2(String gisparam2) {
		this.gisparam2 = gisparam2;
	}

	public String getGisparam3() {
		return this.gisparam3;
	}

	public void setGisparam3(String gisparam3) {
		this.gisparam3 = gisparam3;
	}

	public String getGlaccount() {
		return this.glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public int getHasld() {
		return this.hasld;
	}

	public void setHasld(int hasld) {
		this.hasld = hasld;
	}

	public String getIntlabrec() {
		return this.intlabrec;
	}

	public void setIntlabrec(String intlabrec) {
		this.intlabrec = intlabrec;
	}

	public String getInvcostadjacc() {
		return this.invcostadjacc;
	}

	public void setInvcostadjacc(String invcostadjacc) {
		this.invcostadjacc = invcostadjacc;
	}

	public String getInvoicevaracc() {
		return this.invoicevaracc;
	}

	public void setInvoicevaracc(String invoicevaracc) {
		this.invoicevaracc = invoicevaracc;
	}

	public String getInvowner() {
		return this.invowner;
	}

	public void setInvowner(String invowner) {
		this.invowner = invowner;
	}

	public int getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}

	public int getIsrepairfacility() {
		return this.isrepairfacility;
	}

	public void setIsrepairfacility(int isrepairfacility) {
		this.isrepairfacility = isrepairfacility;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getOldcontrolacc() {
		return this.oldcontrolacc;
	}

	public void setOldcontrolacc(String oldcontrolacc) {
		this.oldcontrolacc = oldcontrolacc;
	}

	public String getOldinvcostadjacc() {
		return this.oldinvcostadjacc;
	}

	public void setOldinvcostadjacc(String oldinvcostadjacc) {
		this.oldinvcostadjacc = oldinvcostadjacc;
	}

	public String getOldshrinkageacc() {
		return this.oldshrinkageacc;
	}

	public void setOldshrinkageacc(String oldshrinkageacc) {
		this.oldshrinkageacc = oldshrinkageacc;
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

	public Date getPluscduedate() {
		return this.pluscduedate;
	}

	public void setPluscduedate(Date pluscduedate) {
		this.pluscduedate = pluscduedate;
	}

	public int getPluscloop() {
		return this.pluscloop;
	}

	public void setPluscloop(int pluscloop) {
		this.pluscloop = pluscloop;
	}

	public int getPluscpmextdate() {
		return this.pluscpmextdate;
	}

	public void setPluscpmextdate(int pluscpmextdate) {
		this.pluscpmextdate = pluscpmextdate;
	}

	public String getPurchvaracc() {
		return this.purchvaracc;
	}

	public void setPurchvaracc(String purchvaracc) {
		this.purchvaracc = purchvaracc;
	}

	public String getReceiptvaracc() {
		return this.receiptvaracc;
	}

	public void setReceiptvaracc(String receiptvaracc) {
		this.receiptvaracc = receiptvaracc;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSaddresscode() {
		return this.saddresscode;
	}

	public void setSaddresscode(String saddresscode) {
		this.saddresscode = saddresscode;
	}

	public String getSendersysid() {
		return this.sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getServiceaddresscode() {
		return this.serviceaddresscode;
	}

	public void setServiceaddresscode(String serviceaddresscode) {
		this.serviceaddresscode = serviceaddresscode;
	}

	public String getShiptoaddresscode() {
		return this.shiptoaddresscode;
	}

	public void setShiptoaddresscode(String shiptoaddresscode) {
		this.shiptoaddresscode = shiptoaddresscode;
	}

	public String getShiptolaborcode() {
		return this.shiptolaborcode;
	}

	public void setShiptolaborcode(String shiptolaborcode) {
		this.shiptolaborcode = shiptolaborcode;
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

	public String getToolcontrolacc() {
		return this.toolcontrolacc;
	}

	public void setToolcontrolacc(String toolcontrolacc) {
		this.toolcontrolacc = toolcontrolacc;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public int getUdchkfre() {
//		return this.udchkfre;
//	}
//
//	public void setUdchkfre(int udchkfre) {
//		this.udchkfre = udchkfre;
//	}

	public String getUdcontact() {
		return this.udcontact;
	}

	public void setUdcontact(String udcontact) {
		this.udcontact = udcontact;
	}

	public String getUdcontract() {
		return this.udcontract;
	}

	public void setUdcontract(String udcontract) {
		this.udcontract = udcontract;
	}

	public String getUdctrdesc() {
		return this.udctrdesc;
	}

	public void setUdctrdesc(String udctrdesc) {
		this.udctrdesc = udctrdesc;
	}

	public String getUdphone() {
		return this.udphone;
	}

	public void setUdphone(String udphone) {
		this.udphone = udphone;
	}

	public String getUdstoretype() {
		return this.udstoretype;
	}

	public void setUdstoretype(String udstoretype) {
		this.udstoretype = udstoretype;
	}

	public int getUseinpopr() {
		return this.useinpopr;
	}

	public void setUseinpopr(int useinpopr) {
		this.useinpopr = useinpopr;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Location{");
		sb.append("locationsid=").append(locationsid);
		sb.append(", autowogen=").append(autowogen);
		sb.append(", billtoaddresscode='").append(billtoaddresscode).append('\'');
		sb.append(", billtolaborcode='").append(billtolaborcode).append('\'');
		sb.append(", changeby='").append(changeby).append('\'');
		sb.append(", changedate=").append(changedate);
		sb.append(", classstructureid='").append(classstructureid).append('\'');
		sb.append(", controlacc='").append(controlacc).append('\'');
		sb.append(", curvaracc='").append(curvaracc).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", dimension='").append(dimension).append('\'');
		sb.append(", disabled=").append(disabled);
		sb.append(", externalrefid='").append(externalrefid).append('\'');
		sb.append(", gisparam1='").append(gisparam1).append('\'');
		sb.append(", gisparam2='").append(gisparam2).append('\'');
		sb.append(", gisparam3='").append(gisparam3).append('\'');
		sb.append(", glaccount='").append(glaccount).append('\'');
		sb.append(", hasld=").append(hasld);
		sb.append(", intlabrec='").append(intlabrec).append('\'');
		sb.append(", invcostadjacc='").append(invcostadjacc).append('\'');
		sb.append(", invoicevaracc='").append(invoicevaracc).append('\'');
		sb.append(", invowner='").append(invowner).append('\'');
		sb.append(", isdefault=").append(isdefault);
		sb.append(", isrepairfacility=").append(isrepairfacility);
		sb.append(", langcode='").append(langcode).append('\'');
		sb.append(", location='").append(location).append('\'');
		sb.append(", longitude='").append(longitude).append('\'');
		sb.append(", material='").append(material).append('\'');
		sb.append(", oldcontrolacc='").append(oldcontrolacc).append('\'');
		sb.append(", oldinvcostadjacc='").append(oldinvcostadjacc).append('\'');
		sb.append(", oldshrinkageacc='").append(oldshrinkageacc).append('\'');
		sb.append(", orgid='").append(orgid).append('\'');
		sb.append(", ownersysid='").append(ownersysid).append('\'');
		sb.append(", pluscduedate=").append(pluscduedate);
		sb.append(", pluscloop=").append(pluscloop);
		sb.append(", pluscpmextdate=").append(pluscpmextdate);
		sb.append(", purchvaracc='").append(purchvaracc).append('\'');
		sb.append(", receiptvaracc='").append(receiptvaracc).append('\'');
		sb.append(", rowstamp=").append(rowstamp);
		sb.append(", saddresscode='").append(saddresscode).append('\'');
		sb.append(", sendersysid='").append(sendersysid).append('\'');
		sb.append(", serviceaddresscode='").append(serviceaddresscode).append('\'');
		sb.append(", shiptoaddresscode='").append(shiptoaddresscode).append('\'');
		sb.append(", shiptolaborcode='").append(shiptolaborcode).append('\'');
		sb.append(", shrinkageacc='").append(shrinkageacc).append('\'');
		sb.append(", siteid='").append(siteid).append('\'');
		sb.append(", sourcesysid='").append(sourcesysid).append('\'');
		sb.append(", status='").append(status).append('\'');
		sb.append(", statusdate=").append(statusdate);
		sb.append(", toolcontrolacc='").append(toolcontrolacc).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append(", udcontact='").append(udcontact).append('\'');
		sb.append(", udcontract='").append(udcontract).append('\'');
		sb.append(", udctrdesc='").append(udctrdesc).append('\'');
		sb.append(", udphone='").append(udphone).append('\'');
		sb.append(", udstoretype='").append(udstoretype).append('\'');
		sb.append(", useinpopr=").append(useinpopr);
		sb.append('}');
		return sb.toString();
	}
}