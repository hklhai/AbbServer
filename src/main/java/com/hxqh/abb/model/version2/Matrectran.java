package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MATRECTRANS database table.
 */
@Entity
@Table(name = "Matrectrans")
@DynamicUpdate
public class Matrectran implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "MATRECTRANS_MATRECTRANSID_GENERATOR", allocationSize = 1, sequenceName = "MATRECTRANSSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATRECTRANS_MATRECTRANSID_GENERATOR")
    private Long matrectransid;

    private BigDecimal actualcost;

    private Date actualdate;

    private String assetnum;

    private Long beLongsto;

    private String commodity;

    private String commoditygroup;

    private String conditioncode;

    private Integer condrate;

    private Integer consignment;

    private String consinvoicenum;

    private String consvendor;

    private BigDecimal conversion;

    private Integer costinfo;

    private BigDecimal costoverreceived;

    private String courier;

    private BigDecimal curbal;

    private String currencycode;

    private BigDecimal currencylinecost;

    private BigDecimal currencyunitcost;

    private String description;

    private String enterby;

    private Integer enteredastask;

    private BigDecimal exchangerate;

    private BigDecimal exchangerate2;

    private String externalrefid;

    private String financialperiod;

    private String fincntrlid;

    private String frombin;

    private String fromconditioncode;

    private String fromlot;

    private String fromsiteid;

    private String fromstoreloc;

    private String glcreditacct;

    private String gldebitacct;

    private Integer hasld;

    private BigDecimal inspectedqty;

    private String invoicenum;

    private Long invuseid;

    private Long invuselineid;

    private Integer invuselinenum;

    private Long invuselinesplitid;

    private Integer issue;

    private String issueto;

    private String issuetype;

    private String it1;

    private String it10;

    private String it2;

    private String it3;

    private BigDecimal it4;

    private String it5;

    private String it6;

    private String it7;

    private String it8;

    private String it9;

    private String itemnum;

    private String itemsetid;

    private String itin1;

    private String itin2;

    private String itin3;

    private String itin4;

    private String itin5;

    private String itin6;

    private String itin7;

    private String langcode;

    private BigDecimal linecost;

    private BigDecimal linecost2;

    private String linetype;

    private BigDecimal loadedcost;

    @Column(name = "\"LOCATION\"")
    private String location;

    private String manufacturer;

    private Long matusetransid;

    private String modelnum;

    private Integer mrlinenum;

    private String mrnum;

    private BigDecimal oldavgcost;

    private String orgid;

    private String orgrcvexternalrefid;

    private Integer outside;

    private String ownersysid;

    private String packingslipnum;

    private Integer polinenum;

    private String ponum;

    private Integer porevisionnum;

    private String positeid;

    private BigDecimal proratecost;

    private Integer prorated;

    private BigDecimal qtyheld;

    private BigDecimal qtyoverreceived;

    private BigDecimal qtyrequested;

    private BigDecimal quantity;

    private Long receiptref;

    private String receivedunit;

    private String refwo;

    private String rejectcode;

    private BigDecimal rejectqty;

    private String remark;

    private String requestedby;

    private String rotassetnum;

    private Long rowstamp;

    private String sendersysid;

    private String shipmentlinenum;

    private String shipmentnum;

    private String siteid;

    private String sourcesysid;

    @Column(name = "\"STATUS\"")
    private String status;

    private String statuschangeby;

    private Date statusdate;

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

    private String tobin;

    private String tolot;

    private String tostoreloc;

    private BigDecimal totalcurbal;

    private Date transdate;

    private BigDecimal unitcost;


    @Transient
    private Integer frontedid;
    @Transient
    private String itemdescription;
    @Transient
    private String itemudmodel;
    @Transient
    private String receiptquantity;
    @Transient
    private String taskid;
    @Transient
    private String wonum;
    @Transient
    private String issueunit;


    public Matrectran() {
    }

    public String getIssueunit() {
        return issueunit;
    }

    public void setIssueunit(String issueunit) {
        this.issueunit = issueunit;
    }

    public Integer getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Integer frontedid) {
        this.frontedid = frontedid;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getItemudmodel() {
        return itemudmodel;
    }

    public void setItemudmodel(String itemudmodel) {
        this.itemudmodel = itemudmodel;
    }

    public String getReceiptquantity() {
        return receiptquantity;
    }

    public void setReceiptquantity(String receiptquantity) {
        this.receiptquantity = receiptquantity;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public Long getMatrectransid() {
        return this.matrectransid;
    }

    public void setMatrectransid(Long matrectransid) {
        this.matrectransid = matrectransid;
    }

    public BigDecimal getActualcost() {
        return this.actualcost;
    }

    public void setActualcost(BigDecimal actualcost) {
        this.actualcost = actualcost;
    }

    public Date getActualdate() {
        return this.actualdate;
    }

    public void setActualdate(Date actualdate) {
        this.actualdate = actualdate;
    }

    public String getAssetnum() {
        return this.assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public Long getBeLongsto() {
        return this.beLongsto;
    }

    public void setBeLongsto(Long beLongsto) {
        this.beLongsto = beLongsto;
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

    public Integer getCondrate() {
        return this.condrate;
    }

    public void setCondrate(Integer condrate) {
        this.condrate = condrate;
    }

    public Integer getConsignment() {
        return this.consignment;
    }

    public void setConsignment(Integer consignment) {
        this.consignment = consignment;
    }

    public String getConsinvoicenum() {
        return this.consinvoicenum;
    }

    public void setConsinvoicenum(String consinvoicenum) {
        this.consinvoicenum = consinvoicenum;
    }

    public String getConsvendor() {
        return this.consvendor;
    }

    public void setConsvendor(String consvendor) {
        this.consvendor = consvendor;
    }

    public BigDecimal getConversion() {
        return this.conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public Integer getCostinfo() {
        return this.costinfo;
    }

    public void setCostinfo(Integer costinfo) {
        this.costinfo = costinfo;
    }

    public BigDecimal getCostoverreceived() {
        return this.costoverreceived;
    }

    public void setCostoverreceived(BigDecimal costoverreceived) {
        this.costoverreceived = costoverreceived;
    }

    public String getCourier() {
        return this.courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public BigDecimal getCurbal() {
        return this.curbal;
    }

    public void setCurbal(BigDecimal curbal) {
        this.curbal = curbal;
    }

    public String getCurrencycode() {
        return this.currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public BigDecimal getCurrencylinecost() {
        return this.currencylinecost;
    }

    public void setCurrencylinecost(BigDecimal currencylinecost) {
        this.currencylinecost = currencylinecost;
    }

    public BigDecimal getCurrencyunitcost() {
        return this.currencyunitcost;
    }

    public void setCurrencyunitcost(BigDecimal currencyunitcost) {
        this.currencyunitcost = currencyunitcost;
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

    public Integer getEnteredastask() {
        return this.enteredastask;
    }

    public void setEnteredastask(Integer enteredastask) {
        this.enteredastask = enteredastask;
    }

    public BigDecimal getExchangerate() {
        return this.exchangerate;
    }

    public void setExchangerate(BigDecimal exchangerate) {
        this.exchangerate = exchangerate;
    }

    public BigDecimal getExchangerate2() {
        return this.exchangerate2;
    }

    public void setExchangerate2(BigDecimal exchangerate2) {
        this.exchangerate2 = exchangerate2;
    }

    public String getExternalrefid() {
        return this.externalrefid;
    }

    public void setExternalrefid(String externalrefid) {
        this.externalrefid = externalrefid;
    }

    public String getFinancialperiod() {
        return this.financialperiod;
    }

    public void setFinancialperiod(String financialperiod) {
        this.financialperiod = financialperiod;
    }

    public String getFincntrlid() {
        return this.fincntrlid;
    }

    public void setFincntrlid(String fincntrlid) {
        this.fincntrlid = fincntrlid;
    }

    public String getFrombin() {
        return this.frombin;
    }

    public void setFrombin(String frombin) {
        this.frombin = frombin;
    }

    public String getFromconditioncode() {
        return this.fromconditioncode;
    }

    public void setFromconditioncode(String fromconditioncode) {
        this.fromconditioncode = fromconditioncode;
    }

    public String getFromlot() {
        return this.fromlot;
    }

    public void setFromlot(String fromlot) {
        this.fromlot = fromlot;
    }

    public String getFromsiteid() {
        return this.fromsiteid;
    }

    public void setFromsiteid(String fromsiteid) {
        this.fromsiteid = fromsiteid;
    }

    public String getFromstoreloc() {
        return this.fromstoreloc;
    }

    public void setFromstoreloc(String fromstoreloc) {
        this.fromstoreloc = fromstoreloc;
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

    public BigDecimal getInspectedqty() {
        return this.inspectedqty;
    }

    public void setInspectedqty(BigDecimal inspectedqty) {
        this.inspectedqty = inspectedqty;
    }

    public String getInvoicenum() {
        return this.invoicenum;
    }

    public void setInvoicenum(String invoicenum) {
        this.invoicenum = invoicenum;
    }

    public Long getInvuseid() {
        return this.invuseid;
    }

    public void setInvuseid(Long invuseid) {
        this.invuseid = invuseid;
    }

    public Long getInvuselineid() {
        return this.invuselineid;
    }

    public void setInvuselineid(Long invuselineid) {
        this.invuselineid = invuselineid;
    }

    public Integer getInvuselinenum() {
        return this.invuselinenum;
    }

    public void setInvuselinenum(Integer invuselinenum) {
        this.invuselinenum = invuselinenum;
    }

    public Long getInvuselinesplitid() {
        return this.invuselinesplitid;
    }

    public void setInvuselinesplitid(Long invuselinesplitid) {
        this.invuselinesplitid = invuselinesplitid;
    }

    public Integer getIssue() {
        return this.issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    public String getIssueto() {
        return this.issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getIssuetype() {
        return this.issuetype;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    public String getIt1() {
        return this.it1;
    }

    public void setIt1(String it1) {
        this.it1 = it1;
    }

    public String getIt10() {
        return this.it10;
    }

    public void setIt10(String it10) {
        this.it10 = it10;
    }

    public String getIt2() {
        return this.it2;
    }

    public void setIt2(String it2) {
        this.it2 = it2;
    }

    public String getIt3() {
        return this.it3;
    }

    public void setIt3(String it3) {
        this.it3 = it3;
    }

    public BigDecimal getIt4() {
        return this.it4;
    }

    public void setIt4(BigDecimal it4) {
        this.it4 = it4;
    }

    public String getIt5() {
        return this.it5;
    }

    public void setIt5(String it5) {
        this.it5 = it5;
    }

    public String getIt6() {
        return this.it6;
    }

    public void setIt6(String it6) {
        this.it6 = it6;
    }

    public String getIt7() {
        return this.it7;
    }

    public void setIt7(String it7) {
        this.it7 = it7;
    }

    public String getIt8() {
        return this.it8;
    }

    public void setIt8(String it8) {
        this.it8 = it8;
    }

    public String getIt9() {
        return this.it9;
    }

    public void setIt9(String it9) {
        this.it9 = it9;
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

    public String getItin1() {
        return this.itin1;
    }

    public void setItin1(String itin1) {
        this.itin1 = itin1;
    }

    public String getItin2() {
        return this.itin2;
    }

    public void setItin2(String itin2) {
        this.itin2 = itin2;
    }

    public String getItin3() {
        return this.itin3;
    }

    public void setItin3(String itin3) {
        this.itin3 = itin3;
    }

    public String getItin4() {
        return this.itin4;
    }

    public void setItin4(String itin4) {
        this.itin4 = itin4;
    }

    public String getItin5() {
        return this.itin5;
    }

    public void setItin5(String itin5) {
        this.itin5 = itin5;
    }

    public String getItin6() {
        return this.itin6;
    }

    public void setItin6(String itin6) {
        this.itin6 = itin6;
    }

    public String getItin7() {
        return this.itin7;
    }

    public void setItin7(String itin7) {
        this.itin7 = itin7;
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

    public Long getMatusetransid() {
        return this.matusetransid;
    }

    public void setMatusetransid(Long matusetransid) {
        this.matusetransid = matusetransid;
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

    public BigDecimal getOldavgcost() {
        return this.oldavgcost;
    }

    public void setOldavgcost(BigDecimal oldavgcost) {
        this.oldavgcost = oldavgcost;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrgrcvexternalrefid() {
        return this.orgrcvexternalrefid;
    }

    public void setOrgrcvexternalrefid(String orgrcvexternalrefid) {
        this.orgrcvexternalrefid = orgrcvexternalrefid;
    }

    public Integer getOutside() {
        return this.outside;
    }

    public void setOutside(Integer outside) {
        this.outside = outside;
    }

    public String getOwnersysid() {
        return this.ownersysid;
    }

    public void setOwnersysid(String ownersysid) {
        this.ownersysid = ownersysid;
    }

    public String getPackingslipnum() {
        return this.packingslipnum;
    }

    public void setPackingslipnum(String packingslipnum) {
        this.packingslipnum = packingslipnum;
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

    public Integer getPorevisionnum() {
        return this.porevisionnum;
    }

    public void setPorevisionnum(Integer porevisionnum) {
        this.porevisionnum = porevisionnum;
    }

    public String getPositeid() {
        return this.positeid;
    }

    public void setPositeid(String positeid) {
        this.positeid = positeid;
    }

    public BigDecimal getProratecost() {
        return this.proratecost;
    }

    public void setProratecost(BigDecimal proratecost) {
        this.proratecost = proratecost;
    }

    public Integer getProrated() {
        return this.prorated;
    }

    public void setProrated(Integer prorated) {
        this.prorated = prorated;
    }

    public BigDecimal getQtyheld() {
        return this.qtyheld;
    }

    public void setQtyheld(BigDecimal qtyheld) {
        this.qtyheld = qtyheld;
    }

    public BigDecimal getQtyoverreceived() {
        return this.qtyoverreceived;
    }

    public void setQtyoverreceived(BigDecimal qtyoverreceived) {
        this.qtyoverreceived = qtyoverreceived;
    }

    public BigDecimal getQtyrequested() {
        return this.qtyrequested;
    }

    public void setQtyrequested(BigDecimal qtyrequested) {
        this.qtyrequested = qtyrequested;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Long getReceiptref() {
        return this.receiptref;
    }

    public void setReceiptref(Long receiptref) {
        this.receiptref = receiptref;
    }

    public String getReceivedunit() {
        return this.receivedunit;
    }

    public void setReceivedunit(String receivedunit) {
        this.receivedunit = receivedunit;
    }

    public String getRefwo() {
        return this.refwo;
    }

    public void setRefwo(String refwo) {
        this.refwo = refwo;
    }

    public String getRejectcode() {
        return this.rejectcode;
    }

    public void setRejectcode(String rejectcode) {
        this.rejectcode = rejectcode;
    }

    public BigDecimal getRejectqty() {
        return this.rejectqty;
    }

    public void setRejectqty(BigDecimal rejectqty) {
        this.rejectqty = rejectqty;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequestedby() {
        return this.requestedby;
    }

    public void setRequestedby(String requestedby) {
        this.requestedby = requestedby;
    }

    public String getRotassetnum() {
        return this.rotassetnum;
    }

    public void setRotassetnum(String rotassetnum) {
        this.rotassetnum = rotassetnum;
    }

    public Long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSendersysid() {
        return this.sendersysid;
    }

    public void setSendersysid(String sendersysid) {
        this.sendersysid = sendersysid;
    }

    public String getShipmentlinenum() {
        return this.shipmentlinenum;
    }

    public void setShipmentlinenum(String shipmentlinenum) {
        this.shipmentlinenum = shipmentlinenum;
    }

    public String getShipmentnum() {
        return this.shipmentnum;
    }

    public void setShipmentnum(String shipmentnum) {
        this.shipmentnum = shipmentnum;
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

    public String getStatuschangeby() {
        return this.statuschangeby;
    }

    public void setStatuschangeby(String statuschangeby) {
        this.statuschangeby = statuschangeby;
    }

    public Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
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

    public String getTobin() {
        return this.tobin;
    }

    public void setTobin(String tobin) {
        this.tobin = tobin;
    }

    public String getTolot() {
        return this.tolot;
    }

    public void setTolot(String tolot) {
        this.tolot = tolot;
    }

    public String getTostoreloc() {
        return this.tostoreloc;
    }

    public void setTostoreloc(String tostoreloc) {
        this.tostoreloc = tostoreloc;
    }

    public BigDecimal getTotalcurbal() {
        return this.totalcurbal;
    }

    public void setTotalcurbal(BigDecimal totalcurbal) {
        this.totalcurbal = totalcurbal;
    }

    public Date getTransdate() {
        return this.transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public BigDecimal getUnitcost() {
        return this.unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

}