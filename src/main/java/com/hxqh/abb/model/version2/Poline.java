package com.hxqh.abb.model.version2;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the POLINE database table.
 */
@Entity
@Table(name = "Poline")
public class Poline implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "POLINE_POLINEID_GENERATOR", sequenceName = "POLINESEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLINE_POLINEID_GENERATOR")
    private Long polineid;

    private String assetnum;

    private String catalogcode;

    private String category;

    private Integer chargestore;

    private String classstructureid;

    private String commodity;

    private String commoditygroup;

    private String conditioncode;

    private Integer consignment;

    private Long contractrefid;

    private String contractrefnum;

    private Integer contractrefrev;

    private Long contreflineid;

    private BigDecimal conversion;

    private String description;

    private String enterby;

    private Date enterdate;

    private Integer enteredastask;

    private String fincntrlid;

    private String glcreditacct;

    private String gldebitacct;

    private Integer hasld;

    private Integer inspectionrequired;

    private Integer isdistributed;

    private Integer issue;

    private String itemnum;

    private String itemsetid;

    private String langcode;

    private BigDecimal linecost;

    private BigDecimal linecost2;

    private String linetype;

    private BigDecimal loadedcost;

    @Column(name = "\"LOCATION\"")
    private String location;

    private String manufacturer;

    private Integer mktplcitem;

    private String modelnum;

    private Integer mrlinenum;

    private String mrnum;

    private BigDecimal orderqty;

    private String orderunit;

    private String orgid;

    private String pcardexpdate;

    private String pcardnum;

    private String pcardtype;

    private String pcardverification;

    private String pl1;

    private String pl10;

    private String pl2;

    private String pl3;

    private BigDecimal pl4;

    private String pl5;

    private String pl6;

    private String pl7;

    private String pl8;

    private String pl9;

    private String plin1;

    private String plin2;

    private String plin3;

    private Date plin4;

    private BigDecimal plin5;

    private String plin6;

    private String plin7;

    private String plin8;

    private String plin9;

    private String polaln1;

    private String polaln2;

    private String polaln3;

    private String polaln4;

    private String polaln5;

    private Integer polinenum;

    private String ponum;

    private BigDecimal proratecost;

    private Integer prorateservice;

    private Integer receiptreqd;

    private Integer receiptscomplete;

    private double receipttolamt;

    private BigDecimal receipttolerance;

    private double receipttolqty;

    private BigDecimal receivedqty;

    private BigDecimal receivedtotalcost;

    private BigDecimal receivedunitcost;

    private String refwo;

    private BigDecimal rejectedqty;

    private String remark;

    @Temporal(TemporalType.DATE)
    private Date reqdeliverydate;

    private String requestedby;

    private String restype;

    private Integer revisionnum;

    private String revstatus;

    private Long rowstamp;

    private Long scheduleid;

    private String shipto;

    private String shiptoattn;

    private String siteid;

    private String storeloc;

    private String supervisor;

    private BigDecimal tax1;

    private String tax1code;

    private BigDecimal tax2;

    private String tax2code;

    private BigDecimal tax3;

    private String tax3code;

    private BigDecimal tax4;

    private String tax4code;

    private BigDecimal tax5;

    private String tax5code;

    private Integer taxed;

    private Integer taxexempt;

    private String tositeid;

    private String udlocation;

    private String udresource;

    private BigDecimal unitcost;

    @Temporal(TemporalType.DATE)
    private Date vendeliverydate;

    private String vendorpackcode;

    private String vendorpackquantity;

    private String vendorwarehouse;

    public Poline() {
    }

    public Long getPolineid() {
        return this.polineid;
    }

    public void setPolineid(Long polineid) {
        this.polineid = polineid;
    }

    public String getAssetnum() {
        return this.assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
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

    public Integer getChargestore() {
        return this.chargestore;
    }

    public void setChargestore(Integer chargestore) {
        this.chargestore = chargestore;
    }

    public String getClassstructureid() {
        return this.classstructureid;
    }

    public void setClassstructureid(String classstructureid) {
        this.classstructureid = classstructureid;
    }

    public String getCommodity() {
        return this.commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCommoditygroup() {
        return this.commoditygroup;
    }

    public void setCommoditygroup(String commoditygroup) {
        this.commoditygroup = commoditygroup;
    }

    public String getConditioncode() {
        return this.conditioncode;
    }

    public void setConditioncode(String conditioncode) {
        this.conditioncode = conditioncode;
    }

    public Integer getConsignment() {
        return this.consignment;
    }

    public void setConsignment(Integer consignment) {
        this.consignment = consignment;
    }

    public Long getContractrefid() {
        return this.contractrefid;
    }

    public void setContractrefid(Long contractrefid) {
        this.contractrefid = contractrefid;
    }

    public String getContractrefnum() {
        return this.contractrefnum;
    }

    public void setContractrefnum(String contractrefnum) {
        this.contractrefnum = contractrefnum;
    }

    public Integer getContractrefrev() {
        return this.contractrefrev;
    }

    public void setContractrefrev(Integer contractrefrev) {
        this.contractrefrev = contractrefrev;
    }

    public Long getContreflineid() {
        return this.contreflineid;
    }

    public void setContreflineid(Long contreflineid) {
        this.contreflineid = contreflineid;
    }

    public BigDecimal getConversion() {
        return this.conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
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

    public Date getEnterdate() {
        return this.enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Integer getEnteredastask() {
        return this.enteredastask;
    }

    public void setEnteredastask(Integer enteredastask) {
        this.enteredastask = enteredastask;
    }

    public String getFincntrlid() {
        return this.fincntrlid;
    }

    public void setFincntrlid(String fincntrlid) {
        this.fincntrlid = fincntrlid;
    }

    public String getGlcreditacct() {
        return this.glcreditacct;
    }

    public void setGlcreditacct(String glcreditacct) {
        this.glcreditacct = glcreditacct;
    }

    public String getGldebitacct() {
        return this.gldebitacct;
    }

    public void setGldebitacct(String gldebitacct) {
        this.gldebitacct = gldebitacct;
    }

    public Integer getHasld() {
        return this.hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public Integer getInspectionrequired() {
        return this.inspectionrequired;
    }

    public void setInspectionrequired(Integer inspectionrequired) {
        this.inspectionrequired = inspectionrequired;
    }

    public Integer getIsdistributed() {
        return this.isdistributed;
    }

    public void setIsdistributed(Integer isdistributed) {
        this.isdistributed = isdistributed;
    }

    public Integer getIssue() {
        return this.issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
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

    public BigDecimal getLinecost2() {
        return this.linecost2;
    }

    public void setLinecost2(BigDecimal linecost2) {
        this.linecost2 = linecost2;
    }

    public String getLinetype() {
        return this.linetype;
    }

    public void setLinetype(String linetype) {
        this.linetype = linetype;
    }

    public BigDecimal getLoadedcost() {
        return this.loadedcost;
    }

    public void setLoadedcost(BigDecimal loadedcost) {
        this.loadedcost = loadedcost;
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

    public Integer getMrlinenum() {
        return this.mrlinenum;
    }

    public void setMrlinenum(Integer mrlinenum) {
        this.mrlinenum = mrlinenum;
    }

    public String getMrnum() {
        return this.mrnum;
    }

    public void setMrnum(String mrnum) {
        this.mrnum = mrnum;
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

    public String getPl1() {
        return this.pl1;
    }

    public void setPl1(String pl1) {
        this.pl1 = pl1;
    }

    public String getPl10() {
        return this.pl10;
    }

    public void setPl10(String pl10) {
        this.pl10 = pl10;
    }

    public String getPl2() {
        return this.pl2;
    }

    public void setPl2(String pl2) {
        this.pl2 = pl2;
    }

    public String getPl3() {
        return this.pl3;
    }

    public void setPl3(String pl3) {
        this.pl3 = pl3;
    }

    public BigDecimal getPl4() {
        return this.pl4;
    }

    public void setPl4(BigDecimal pl4) {
        this.pl4 = pl4;
    }

    public String getPl5() {
        return this.pl5;
    }

    public void setPl5(String pl5) {
        this.pl5 = pl5;
    }

    public String getPl6() {
        return this.pl6;
    }

    public void setPl6(String pl6) {
        this.pl6 = pl6;
    }

    public String getPl7() {
        return this.pl7;
    }

    public void setPl7(String pl7) {
        this.pl7 = pl7;
    }

    public String getPl8() {
        return this.pl8;
    }

    public void setPl8(String pl8) {
        this.pl8 = pl8;
    }

    public String getPl9() {
        return this.pl9;
    }

    public void setPl9(String pl9) {
        this.pl9 = pl9;
    }

    public String getPlin1() {
        return this.plin1;
    }

    public void setPlin1(String plin1) {
        this.plin1 = plin1;
    }

    public String getPlin2() {
        return this.plin2;
    }

    public void setPlin2(String plin2) {
        this.plin2 = plin2;
    }

    public String getPlin3() {
        return this.plin3;
    }

    public void setPlin3(String plin3) {
        this.plin3 = plin3;
    }

    public Date getPlin4() {
        return this.plin4;
    }

    public void setPlin4(Date plin4) {
        this.plin4 = plin4;
    }

    public BigDecimal getPlin5() {
        return this.plin5;
    }

    public void setPlin5(BigDecimal plin5) {
        this.plin5 = plin5;
    }

    public String getPlin6() {
        return this.plin6;
    }

    public void setPlin6(String plin6) {
        this.plin6 = plin6;
    }

    public String getPlin7() {
        return this.plin7;
    }

    public void setPlin7(String plin7) {
        this.plin7 = plin7;
    }

    public String getPlin8() {
        return this.plin8;
    }

    public void setPlin8(String plin8) {
        this.plin8 = plin8;
    }

    public String getPlin9() {
        return this.plin9;
    }

    public void setPlin9(String plin9) {
        this.plin9 = plin9;
    }

    public String getPolaln1() {
        return this.polaln1;
    }

    public void setPolaln1(String polaln1) {
        this.polaln1 = polaln1;
    }

    public String getPolaln2() {
        return this.polaln2;
    }

    public void setPolaln2(String polaln2) {
        this.polaln2 = polaln2;
    }

    public String getPolaln3() {
        return this.polaln3;
    }

    public void setPolaln3(String polaln3) {
        this.polaln3 = polaln3;
    }

    public String getPolaln4() {
        return this.polaln4;
    }

    public void setPolaln4(String polaln4) {
        this.polaln4 = polaln4;
    }

    public String getPolaln5() {
        return this.polaln5;
    }

    public void setPolaln5(String polaln5) {
        this.polaln5 = polaln5;
    }

    public Integer getPolinenum() {
        return this.polinenum;
    }

    public void setPolinenum(Integer polinenum) {
        this.polinenum = polinenum;
    }

    public String getPonum() {
        return this.ponum;
    }

    public void setPonum(String ponum) {
        this.ponum = ponum;
    }

    public BigDecimal getProratecost() {
        return this.proratecost;
    }

    public void setProratecost(BigDecimal proratecost) {
        this.proratecost = proratecost;
    }

    public Integer getProrateservice() {
        return this.prorateservice;
    }

    public void setProrateservice(Integer prorateservice) {
        this.prorateservice = prorateservice;
    }

    public Integer getReceiptreqd() {
        return this.receiptreqd;
    }

    public void setReceiptreqd(Integer receiptreqd) {
        this.receiptreqd = receiptreqd;
    }

    public Integer getReceiptscomplete() {
        return this.receiptscomplete;
    }

    public void setReceiptscomplete(Integer receiptscomplete) {
        this.receiptscomplete = receiptscomplete;
    }

    public double getReceipttolamt() {
        return this.receipttolamt;
    }

    public void setReceipttolamt(double receipttolamt) {
        this.receipttolamt = receipttolamt;
    }

    public BigDecimal getReceipttolerance() {
        return this.receipttolerance;
    }

    public void setReceipttolerance(BigDecimal receipttolerance) {
        this.receipttolerance = receipttolerance;
    }

    public double getReceipttolqty() {
        return this.receipttolqty;
    }

    public void setReceipttolqty(double receipttolqty) {
        this.receipttolqty = receipttolqty;
    }

    public BigDecimal getReceivedqty() {
        return this.receivedqty;
    }

    public void setReceivedqty(BigDecimal receivedqty) {
        this.receivedqty = receivedqty;
    }

    public BigDecimal getReceivedtotalcost() {
        return this.receivedtotalcost;
    }

    public void setReceivedtotalcost(BigDecimal receivedtotalcost) {
        this.receivedtotalcost = receivedtotalcost;
    }

    public BigDecimal getReceivedunitcost() {
        return this.receivedunitcost;
    }

    public void setReceivedunitcost(BigDecimal receivedunitcost) {
        this.receivedunitcost = receivedunitcost;
    }

    public String getRefwo() {
        return this.refwo;
    }

    public void setRefwo(String refwo) {
        this.refwo = refwo;
    }

    public BigDecimal getRejectedqty() {
        return this.rejectedqty;
    }

    public void setRejectedqty(BigDecimal rejectedqty) {
        this.rejectedqty = rejectedqty;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getReqdeliverydate() {
        return this.reqdeliverydate;
    }

    public void setReqdeliverydate(Date reqdeliverydate) {
        this.reqdeliverydate = reqdeliverydate;
    }

    public String getRequestedby() {
        return this.requestedby;
    }

    public void setRequestedby(String requestedby) {
        this.requestedby = requestedby;
    }

    public String getRestype() {
        return this.restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public Integer getRevisionnum() {
        return this.revisionnum;
    }

    public void setRevisionnum(Integer revisionnum) {
        this.revisionnum = revisionnum;
    }

    public String getRevstatus() {
        return this.revstatus;
    }

    public void setRevstatus(String revstatus) {
        this.revstatus = revstatus;
    }

    public Long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public Long getScheduleid() {
        return this.scheduleid;
    }

    public void setScheduleid(Long scheduleid) {
        this.scheduleid = scheduleid;
    }

    public String getShipto() {
        return this.shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public String getShiptoattn() {
        return this.shiptoattn;
    }

    public void setShiptoattn(String shiptoattn) {
        this.shiptoattn = shiptoattn;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getStoreloc() {
        return this.storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public String getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public BigDecimal getTax1() {
        return this.tax1;
    }

    public void setTax1(BigDecimal tax1) {
        this.tax1 = tax1;
    }

    public String getTax1code() {
        return this.tax1code;
    }

    public void setTax1code(String tax1code) {
        this.tax1code = tax1code;
    }

    public BigDecimal getTax2() {
        return this.tax2;
    }

    public void setTax2(BigDecimal tax2) {
        this.tax2 = tax2;
    }

    public String getTax2code() {
        return this.tax2code;
    }

    public void setTax2code(String tax2code) {
        this.tax2code = tax2code;
    }

    public BigDecimal getTax3() {
        return this.tax3;
    }

    public void setTax3(BigDecimal tax3) {
        this.tax3 = tax3;
    }

    public String getTax3code() {
        return this.tax3code;
    }

    public void setTax3code(String tax3code) {
        this.tax3code = tax3code;
    }

    public BigDecimal getTax4() {
        return this.tax4;
    }

    public void setTax4(BigDecimal tax4) {
        this.tax4 = tax4;
    }

    public String getTax4code() {
        return this.tax4code;
    }

    public void setTax4code(String tax4code) {
        this.tax4code = tax4code;
    }

    public BigDecimal getTax5() {
        return this.tax5;
    }

    public void setTax5(BigDecimal tax5) {
        this.tax5 = tax5;
    }

    public String getTax5code() {
        return this.tax5code;
    }

    public void setTax5code(String tax5code) {
        this.tax5code = tax5code;
    }

    public Integer getTaxed() {
        return this.taxed;
    }

    public void setTaxed(Integer taxed) {
        this.taxed = taxed;
    }

    public Integer getTaxexempt() {
        return this.taxexempt;
    }

    public void setTaxexempt(Integer taxexempt) {
        this.taxexempt = taxexempt;
    }

    public String getTositeid() {
        return this.tositeid;
    }

    public void setTositeid(String tositeid) {
        this.tositeid = tositeid;
    }

    public String getUdlocation() {
        return this.udlocation;
    }

    public void setUdlocation(String udlocation) {
        this.udlocation = udlocation;
    }

    public String getUdresource() {
        return this.udresource;
    }

    public void setUdresource(String udresource) {
        this.udresource = udresource;
    }

    public BigDecimal getUnitcost() {
        return this.unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    public Date getVendeliverydate() {
        return this.vendeliverydate;
    }

    public void setVendeliverydate(Date vendeliverydate) {
        this.vendeliverydate = vendeliverydate;
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

    public String getVendorwarehouse() {
        return this.vendorwarehouse;
    }

    public void setVendorwarehouse(String vendorwarehouse) {
        this.vendorwarehouse = vendorwarehouse;
    }

}