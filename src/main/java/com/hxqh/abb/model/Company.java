package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the COMPANIES database table.
 * 
 */
@Entity
@Table(name="COMPANIES")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANIES_COMPANIESID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANIES_COMPANIESID_GENERATOR")
	private long companiesid;

	private String address1;

	private String address2;

	private String address3;

	private String address4;

	private String address5;

	private String apcontrolacc;

	private String apsuspenseacc;

	private Integer autoapproveinv;

	private Integer autoreceiveonasn;

	private Integer autosendpocancel;

	private String bankaccount;

	private String banknum;

	private String catalogname;

	private String cellphone;

	private String changeby;

	private Timestamp changedate;

	private String company;

	private String consacct;

	private String contact;

	private String currencycode;

	private String customernum;

	private String defaultwarehouse;

	private Integer disabled;

	private String dunsnum;

	private String ecominterface;

	private Integer ecommerceenabled;

	private String externalrefid;

	private String fax;

	private String fob;

	private String freightterms;

	private Integer hasld;

	private String homepage;

	private Integer inclusive1;

	private Integer inclusive2;

	private Integer inclusive3;

	private Integer inclusive4;

	private Integer inclusive5;

	private Integer inspectionrequired;

	@Temporal(TemporalType.DATE)
	private Date insurexpdate;

	private String langcode;

	@Column(name="\"LOCATION\"")
	private String location;

	private String mnetcompanyid;

	@Column(name="\"NAME\"")
	private String name;

	private String orgid;

	private String ownersysid;

	private String parentcompany;

	private String paymentterms;

	private Integer payonreceipt;

	private String payvendor;

	private String phone;

	private Integer punchoutenabled;

	private String rbniacc;

	private String registration1;

	private String registration2;

	private String registration3;

	private String registration4;

	private String registration5;

	private String remitaddress1;

	private String remitaddress2;

	private String remitaddress3;

	private String remitaddress4;

	private String remitaddress5;

	private String remitcontact;

	private long rowstamp;

	private String sendersysid;

	private String shipvia;

	private String sourcesysid;

	private String tax1code;

	private String tax2code;

	private String tax3code;

	private String tax4code;

	private String tax5code;

	private String taxexemptcode;

	private String taxexemptnum;

	private String toolcontrolaccount;

	@Column(name="\"TYPE\"")
	private String type;

	private Integer useparentremitto;

	private Integer vendorsendsasn;

	private Integer vendorsendsinv;

	private Integer vendorsendsstatus;

	public Company() {
	}

	public long getCompaniesid() {
		return this.companiesid;
	}

	public void setCompaniesid(long companiesid) {
		this.companiesid = companiesid;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return this.address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return this.address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getApcontrolacc() {
		return this.apcontrolacc;
	}

	public void setApcontrolacc(String apcontrolacc) {
		this.apcontrolacc = apcontrolacc;
	}

	public String getApsuspenseacc() {
		return this.apsuspenseacc;
	}

	public void setApsuspenseacc(String apsuspenseacc) {
		this.apsuspenseacc = apsuspenseacc;
	}

	public Integer getAutoapproveinv() {
		return this.autoapproveinv;
	}

	public void setAutoapproveinv(Integer autoapproveinv) {
		this.autoapproveinv = autoapproveinv;
	}

	public Integer getAutoreceiveonasn() {
		return this.autoreceiveonasn;
	}

	public void setAutoreceiveonasn(Integer autoreceiveonasn) {
		this.autoreceiveonasn = autoreceiveonasn;
	}

	public Integer getAutosendpocancel() {
		return this.autosendpocancel;
	}

	public void setAutosendpocancel(Integer autosendpocancel) {
		this.autosendpocancel = autosendpocancel;
	}

	public String getBankaccount() {
		return this.bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getBanknum() {
		return this.banknum;
	}

	public void setBanknum(String banknum) {
		this.banknum = banknum;
	}

	public String getCatalogname() {
		return this.catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
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

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getConsacct() {
		return this.consacct;
	}

	public void setConsacct(String consacct) {
		this.consacct = consacct;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCurrencycode() {
		return this.currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getCustomernum() {
		return this.customernum;
	}

	public void setCustomernum(String customernum) {
		this.customernum = customernum;
	}

	public String getDefaultwarehouse() {
		return this.defaultwarehouse;
	}

	public void setDefaultwarehouse(String defaultwarehouse) {
		this.defaultwarehouse = defaultwarehouse;
	}

	public Integer getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public String getDunsnum() {
		return this.dunsnum;
	}

	public void setDunsnum(String dunsnum) {
		this.dunsnum = dunsnum;
	}

	public String getEcominterface() {
		return ecominterface;
	}

	public void setEcominterface(String ecominterface) {
		this.ecominterface = ecominterface;
	}

	public Integer getEcommerceenabled() {
		return this.ecommerceenabled;
	}

	public void setEcommerceenabled(Integer ecommerceenabled) {
		this.ecommerceenabled = ecommerceenabled;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFob() {
		return this.fob;
	}

	public void setFob(String fob) {
		this.fob = fob;
	}

	public String getFreightterms() {
		return this.freightterms;
	}

	public void setFreightterms(String freightterms) {
		this.freightterms = freightterms;
	}

	public Integer getHasld() {
		return this.hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Integer getInclusive1() {
		return this.inclusive1;
	}

	public void setInclusive1(Integer inclusive1) {
		this.inclusive1 = inclusive1;
	}

	public Integer getInclusive2() {
		return this.inclusive2;
	}

	public void setInclusive2(Integer inclusive2) {
		this.inclusive2 = inclusive2;
	}

	public Integer getInclusive3() {
		return this.inclusive3;
	}

	public void setInclusive3(Integer inclusive3) {
		this.inclusive3 = inclusive3;
	}

	public Integer getInclusive4() {
		return this.inclusive4;
	}

	public void setInclusive4(Integer inclusive4) {
		this.inclusive4 = inclusive4;
	}

	public Integer getInclusive5() {
		return this.inclusive5;
	}

	public void setInclusive5(Integer inclusive5) {
		this.inclusive5 = inclusive5;
	}

	public Integer getInspectionrequired() {
		return this.inspectionrequired;
	}

	public void setInspectionrequired(Integer inspectionrequired) {
		this.inspectionrequired = inspectionrequired;
	}

	public Date getInsurexpdate() {
		return this.insurexpdate;
	}

	public void setInsurexpdate(Date insurexpdate) {
		this.insurexpdate = insurexpdate;
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

	public String getMnetcompanyid() {
		return this.mnetcompanyid;
	}

	public void setMnetcompanyid(String mnetcompanyid) {
		this.mnetcompanyid = mnetcompanyid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getParentcompany() {
		return this.parentcompany;
	}

	public void setParentcompany(String parentcompany) {
		this.parentcompany = parentcompany;
	}

	public String getPaymentterms() {
		return this.paymentterms;
	}

	public void setPaymentterms(String paymentterms) {
		this.paymentterms = paymentterms;
	}

	public Integer getPayonreceipt() {
		return this.payonreceipt;
	}

	public void setPayonreceipt(Integer payonreceipt) {
		this.payonreceipt = payonreceipt;
	}

	public String getPayvendor() {
		return this.payvendor;
	}

	public void setPayvendor(String payvendor) {
		this.payvendor = payvendor;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPunchoutenabled() {
		return this.punchoutenabled;
	}

	public void setPunchoutenabled(Integer punchoutenabled) {
		this.punchoutenabled = punchoutenabled;
	}

	public String getRbniacc() {
		return this.rbniacc;
	}

	public void setRbniacc(String rbniacc) {
		this.rbniacc = rbniacc;
	}

	public String getRegistration1() {
		return this.registration1;
	}

	public void setRegistration1(String registration1) {
		this.registration1 = registration1;
	}

	public String getRegistration2() {
		return this.registration2;
	}

	public void setRegistration2(String registration2) {
		this.registration2 = registration2;
	}

	public String getRegistration3() {
		return this.registration3;
	}

	public void setRegistration3(String registration3) {
		this.registration3 = registration3;
	}

	public String getRegistration4() {
		return this.registration4;
	}

	public void setRegistration4(String registration4) {
		this.registration4 = registration4;
	}

	public String getRegistration5() {
		return this.registration5;
	}

	public void setRegistration5(String registration5) {
		this.registration5 = registration5;
	}

	public String getRemitaddress1() {
		return this.remitaddress1;
	}

	public void setRemitaddress1(String remitaddress1) {
		this.remitaddress1 = remitaddress1;
	}

	public String getRemitaddress2() {
		return this.remitaddress2;
	}

	public void setRemitaddress2(String remitaddress2) {
		this.remitaddress2 = remitaddress2;
	}

	public String getRemitaddress3() {
		return this.remitaddress3;
	}

	public void setRemitaddress3(String remitaddress3) {
		this.remitaddress3 = remitaddress3;
	}

	public String getRemitaddress4() {
		return this.remitaddress4;
	}

	public void setRemitaddress4(String remitaddress4) {
		this.remitaddress4 = remitaddress4;
	}

	public String getRemitaddress5() {
		return this.remitaddress5;
	}

	public void setRemitaddress5(String remitaddress5) {
		this.remitaddress5 = remitaddress5;
	}

	public String getRemitcontact() {
		return this.remitcontact;
	}

	public void setRemitcontact(String remitcontact) {
		this.remitcontact = remitcontact;
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

	public String getShipvia() {
		return this.shipvia;
	}

	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}

	public String getSourcesysid() {
		return this.sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public String getTax1code() {
		return this.tax1code;
	}

	public void setTax1code(String tax1code) {
		this.tax1code = tax1code;
	}

	public String getTax2code() {
		return this.tax2code;
	}

	public void setTax2code(String tax2code) {
		this.tax2code = tax2code;
	}

	public String getTax3code() {
		return this.tax3code;
	}

	public void setTax3code(String tax3code) {
		this.tax3code = tax3code;
	}

	public String getTax4code() {
		return this.tax4code;
	}

	public void setTax4code(String tax4code) {
		this.tax4code = tax4code;
	}

	public String getTax5code() {
		return this.tax5code;
	}

	public void setTax5code(String tax5code) {
		this.tax5code = tax5code;
	}

	public String getTaxexemptcode() {
		return this.taxexemptcode;
	}

	public void setTaxexemptcode(String taxexemptcode) {
		this.taxexemptcode = taxexemptcode;
	}

	public String getTaxexemptnum() {
		return this.taxexemptnum;
	}

	public void setTaxexemptnum(String taxexemptnum) {
		this.taxexemptnum = taxexemptnum;
	}

	public String getToolcontrolaccount() {
		return this.toolcontrolaccount;
	}

	public void setToolcontrolaccount(String toolcontrolaccount) {
		this.toolcontrolaccount = toolcontrolaccount;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUseparentremitto() {
		return this.useparentremitto;
	}

	public void setUseparentremitto(Integer useparentremitto) {
		this.useparentremitto = useparentremitto;
	}

	public Integer getVendorsendsasn() {
		return this.vendorsendsasn;
	}

	public void setVendorsendsasn(Integer vendorsendsasn) {
		this.vendorsendsasn = vendorsendsasn;
	}

	public Integer getVendorsendsinv() {
		return this.vendorsendsinv;
	}

	public void setVendorsendsinv(Integer vendorsendsinv) {
		this.vendorsendsinv = vendorsendsinv;
	}

	public Integer getVendorsendsstatus() {
		return this.vendorsendsstatus;
	}

	public void setVendorsendsstatus(Integer vendorsendsstatus) {
		this.vendorsendsstatus = vendorsendsstatus;
	}

}