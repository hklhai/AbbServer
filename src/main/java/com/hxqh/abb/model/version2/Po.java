package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PO database table.
 */
@Entity
@Table(name = "PO")
@DynamicUpdate
public class Po implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PO_POID_GENERATOR", allocationSize = 1, sequenceName = "POSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PO_POID_GENERATOR")
    private Long poid;

    private String billto;

    private String billtoattn;

    private Integer buyahead;

    private String buyercompany;

    private String changeby;

    private Date changedate;

    private String contact;

    private Long contractrefid;

    private String contractrefnum;

    private Integer contractrefrev;

    private Integer contreleaseseq;

    private String currencycode;

    private String customernum;

    private String description;

    private Date ecomstatusdate;

    @Temporal(TemporalType.DATE)
    private Date enddate;

    @Temporal(TemporalType.DATE)
    private Date exchangedate;

    private BigDecimal exchangerate;

    private BigDecimal exchangerate2;

    private String externalrefid;

    private String fob;

    @Temporal(TemporalType.DATE)
    private Date followupdate;

    private String freightterms;

    private Integer hasld;

    private Integer historyflag;

    private Integer ignorecntrev;

    private Integer inclusive1;

    private Integer inclusive2;

    private Integer inclusive3;

    private Integer inclusive4;

    private Integer inclusive5;

    private Integer inspectionrequired;

    private Integer internal;

    private Integer internalchange;

    private String langcode;

    private String mnetsent;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderdate;

    private String orgid;

    private String originalponum;

    private String ownersysid;

    private String paymentterms;

    private Integer payonreceipt;

    private String po1;

    private Integer po10;

    private String po2;

    private String po3;

    private String po4;

    private String po5;

    private BigDecimal po6;

    private Date po7;

    private BigDecimal po8;

    private Integer po9;

    private String ponum;

    private String potype;

    @Column(name = "\"PRIORITY\"")
    private Integer priority;

    private String purchaseagent;

    private String receipts;

    private Date requireddate;

    private String revcomments;

    private Integer revisionnum;

    private Long rowstamp;

    private String sendersysid;

    private String shipto;

    private String shiptoattn;

    private String shipvia;

    private String siteid;

    private String sourcesysid;

    @Temporal(TemporalType.DATE)
    private Date startdate;

    @Column(name = "\"STATUS\"")
    private String status;

    private Date statusdate;

    private String storeloc;

    private String storelocsiteid;

    private BigDecimal totalcost;

    private BigDecimal totaltax1;

    private BigDecimal totaltax2;

    private BigDecimal totaltax3;

    private BigDecimal totaltax4;

    private BigDecimal totaltax5;

    private String udapptype;

    private String udapptypedname;

    private String udpronum;

    @Temporal(TemporalType.DATE)
    private Date vendeliverydate;

    private String vendor;

    @Transient
    private String apptname;

    @Transient
    private String deletes;

    @Transient
    private String maintab;

    @Transient
    private List<Poline> polineList;

    @Transient
    private List<Matrectran> matrectranList;


    @Transient
    private String enterdate;


    public Po() {
    }

    public String getApptname() {
        return apptname;
    }

    public void setApptname(String apptname) {
        this.apptname = apptname;
    }

    public String getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(String enterdate) {
        this.enterdate = enterdate;
    }



    public List<Matrectran> getMatrectranList() {
        return matrectranList;
    }

    public void setMatrectranList(List<Matrectran> matrectranList) {
        this.matrectranList = matrectranList;
    }

    public List<Poline> getPolineList() {
        return polineList;
    }

    public void setPolineList(List<Poline> polineList) {
        this.polineList = polineList;
    }

    public String getDeletes() {
        return deletes;
    }

    public void setDeletes(String deletes) {
        this.deletes = deletes;
    }

    public String getMaintab() {
        return maintab;
    }

    public void setMaintab(String maintab) {
        this.maintab = maintab;
    }

    public Long getPoid() {
        return poid;
    }

    public void setPoid(Long poid) {
        this.poid = poid;
    }

    public String getBillto() {
        return billto;
    }

    public void setBillto(String billto) {
        this.billto = billto;
    }

    public String getBilltoattn() {
        return billtoattn;
    }

    public void setBilltoattn(String billtoattn) {
        this.billtoattn = billtoattn;
    }

    public Integer getBuyahead() {
        return buyahead;
    }

    public void setBuyahead(Integer buyahead) {
        this.buyahead = buyahead;
    }

    public String getBuyercompany() {
        return buyercompany;
    }

    public void setBuyercompany(String buyercompany) {
        this.buyercompany = buyercompany;
    }

    public String getChangeby() {
        return changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getContractrefid() {
        return contractrefid;
    }

    public void setContractrefid(Long contractrefid) {
        this.contractrefid = contractrefid;
    }

    public String getContractrefnum() {
        return contractrefnum;
    }

    public void setContractrefnum(String contractrefnum) {
        this.contractrefnum = contractrefnum;
    }

    public Integer getContractrefrev() {
        return contractrefrev;
    }

    public void setContractrefrev(Integer contractrefrev) {
        this.contractrefrev = contractrefrev;
    }

    public Integer getContreleaseseq() {
        return contreleaseseq;
    }

    public void setContreleaseseq(Integer contreleaseseq) {
        this.contreleaseseq = contreleaseseq;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getCustomernum() {
        return customernum;
    }

    public void setCustomernum(String customernum) {
        this.customernum = customernum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEcomstatusdate() {
        return ecomstatusdate;
    }

    public void setEcomstatusdate(Date ecomstatusdate) {
        this.ecomstatusdate = ecomstatusdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(Date exchangedate) {
        this.exchangedate = exchangedate;
    }

    public BigDecimal getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(BigDecimal exchangerate) {
        this.exchangerate = exchangerate;
    }

    public BigDecimal getExchangerate2() {
        return exchangerate2;
    }

    public void setExchangerate2(BigDecimal exchangerate2) {
        this.exchangerate2 = exchangerate2;
    }

    public String getExternalrefid() {
        return externalrefid;
    }

    public void setExternalrefid(String externalrefid) {
        this.externalrefid = externalrefid;
    }

    public String getFob() {
        return fob;
    }

    public void setFob(String fob) {
        this.fob = fob;
    }

    public Date getFollowupdate() {
        return followupdate;
    }

    public void setFollowupdate(Date followupdate) {
        this.followupdate = followupdate;
    }

    public String getFreightterms() {
        return freightterms;
    }

    public void setFreightterms(String freightterms) {
        this.freightterms = freightterms;
    }

    public Integer getHasld() {
        return hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public Integer getHistoryflag() {
        return historyflag;
    }

    public void setHistoryflag(Integer historyflag) {
        this.historyflag = historyflag;
    }

    public Integer getIgnorecntrev() {
        return ignorecntrev;
    }

    public void setIgnorecntrev(Integer ignorecntrev) {
        this.ignorecntrev = ignorecntrev;
    }

    public Integer getInclusive1() {
        return inclusive1;
    }

    public void setInclusive1(Integer inclusive1) {
        this.inclusive1 = inclusive1;
    }

    public Integer getInclusive2() {
        return inclusive2;
    }

    public void setInclusive2(Integer inclusive2) {
        this.inclusive2 = inclusive2;
    }

    public Integer getInclusive3() {
        return inclusive3;
    }

    public void setInclusive3(Integer inclusive3) {
        this.inclusive3 = inclusive3;
    }

    public Integer getInclusive4() {
        return inclusive4;
    }

    public void setInclusive4(Integer inclusive4) {
        this.inclusive4 = inclusive4;
    }

    public Integer getInclusive5() {
        return inclusive5;
    }

    public void setInclusive5(Integer inclusive5) {
        this.inclusive5 = inclusive5;
    }

    public Integer getInspectionrequired() {
        return inspectionrequired;
    }

    public void setInspectionrequired(Integer inspectionrequired) {
        this.inspectionrequired = inspectionrequired;
    }

    public Integer getInternal() {
        return internal;
    }

    public void setInternal(Integer internal) {
        this.internal = internal;
    }

    public Integer getInternalchange() {
        return internalchange;
    }

    public void setInternalchange(Integer internalchange) {
        this.internalchange = internalchange;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public String getMnetsent() {
        return mnetsent;
    }

    public void setMnetsent(String mnetsent) {
        this.mnetsent = mnetsent;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOriginalponum() {
        return originalponum;
    }

    public void setOriginalponum(String originalponum) {
        this.originalponum = originalponum;
    }

    public String getOwnersysid() {
        return ownersysid;
    }

    public void setOwnersysid(String ownersysid) {
        this.ownersysid = ownersysid;
    }

    public String getPaymentterms() {
        return paymentterms;
    }

    public void setPaymentterms(String paymentterms) {
        this.paymentterms = paymentterms;
    }

    public Integer getPayonreceipt() {
        return payonreceipt;
    }

    public void setPayonreceipt(Integer payonreceipt) {
        this.payonreceipt = payonreceipt;
    }

    public String getPo1() {
        return po1;
    }

    public void setPo1(String po1) {
        this.po1 = po1;
    }

    public Integer getPo10() {
        return po10;
    }

    public void setPo10(Integer po10) {
        this.po10 = po10;
    }

    public String getPo2() {
        return po2;
    }

    public void setPo2(String po2) {
        this.po2 = po2;
    }

    public String getPo3() {
        return po3;
    }

    public void setPo3(String po3) {
        this.po3 = po3;
    }

    public String getPo4() {
        return po4;
    }

    public void setPo4(String po4) {
        this.po4 = po4;
    }

    public String getPo5() {
        return po5;
    }

    public void setPo5(String po5) {
        this.po5 = po5;
    }

    public BigDecimal getPo6() {
        return po6;
    }

    public void setPo6(BigDecimal po6) {
        this.po6 = po6;
    }

    public Date getPo7() {
        return po7;
    }

    public void setPo7(Date po7) {
        this.po7 = po7;
    }

    public BigDecimal getPo8() {
        return po8;
    }

    public void setPo8(BigDecimal po8) {
        this.po8 = po8;
    }

    public Integer getPo9() {
        return po9;
    }

    public void setPo9(Integer po9) {
        this.po9 = po9;
    }

    public String getPonum() {
        return ponum;
    }

    public void setPonum(String ponum) {
        this.ponum = ponum;
    }

    public String getPotype() {
        return potype;
    }

    public void setPotype(String potype) {
        this.potype = potype;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPurchaseagent() {
        return purchaseagent;
    }

    public void setPurchaseagent(String purchaseagent) {
        this.purchaseagent = purchaseagent;
    }

    public String getReceipts() {
        return receipts;
    }

    public void setReceipts(String receipts) {
        this.receipts = receipts;
    }

    public Date getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }

    public String getRevcomments() {
        return revcomments;
    }

    public void setRevcomments(String revcomments) {
        this.revcomments = revcomments;
    }

    public Integer getRevisionnum() {
        return revisionnum;
    }

    public void setRevisionnum(Integer revisionnum) {
        this.revisionnum = revisionnum;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSendersysid() {
        return sendersysid;
    }

    public void setSendersysid(String sendersysid) {
        this.sendersysid = sendersysid;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public String getShiptoattn() {
        return shiptoattn;
    }

    public void setShiptoattn(String shiptoattn) {
        this.shiptoattn = shiptoattn;
    }

    public String getShipvia() {
        return shipvia;
    }

    public void setShipvia(String shipvia) {
        this.shipvia = shipvia;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSourcesysid() {
        return sourcesysid;
    }

    public void setSourcesysid(String sourcesysid) {
        this.sourcesysid = sourcesysid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public String getStoreloc() {
        return storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public String getStorelocsiteid() {
        return storelocsiteid;
    }

    public void setStorelocsiteid(String storelocsiteid) {
        this.storelocsiteid = storelocsiteid;
    }

    public BigDecimal getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(BigDecimal totalcost) {
        this.totalcost = totalcost;
    }

    public BigDecimal getTotaltax1() {
        return totaltax1;
    }

    public void setTotaltax1(BigDecimal totaltax1) {
        this.totaltax1 = totaltax1;
    }

    public BigDecimal getTotaltax2() {
        return totaltax2;
    }

    public void setTotaltax2(BigDecimal totaltax2) {
        this.totaltax2 = totaltax2;
    }

    public BigDecimal getTotaltax3() {
        return totaltax3;
    }

    public void setTotaltax3(BigDecimal totaltax3) {
        this.totaltax3 = totaltax3;
    }

    public BigDecimal getTotaltax4() {
        return totaltax4;
    }

    public void setTotaltax4(BigDecimal totaltax4) {
        this.totaltax4 = totaltax4;
    }

    public BigDecimal getTotaltax5() {
        return totaltax5;
    }

    public void setTotaltax5(BigDecimal totaltax5) {
        this.totaltax5 = totaltax5;
    }

    public String getUdapptype() {
        return udapptype;
    }

    public void setUdapptype(String udapptype) {
        this.udapptype = udapptype;
    }

    public String getUdapptypedname() {
        return udapptypedname;
    }

    public void setUdapptypedname(String udapptypedname) {
        this.udapptypedname = udapptypedname;
    }

    public String getUdpronum() {
        return udpronum;
    }

    public void setUdpronum(String udpronum) {
        this.udpronum = udpronum;
    }

    public Date getVendeliverydate() {
        return vendeliverydate;
    }

    public void setVendeliverydate(Date vendeliverydate) {
        this.vendeliverydate = vendeliverydate;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}