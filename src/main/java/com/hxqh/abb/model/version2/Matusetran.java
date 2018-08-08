package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MATUSETRANS database table.
 */
@Entity
@Table(name = "MATUSETRANS")
@DynamicUpdate
public class Matusetran implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "MATUSETRANS_MATUSETRANSID_GENERATOR", allocationSize = 1, sequenceName = "MATUSETRANSSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATUSETRANS_MATUSETRANSID_GENERATOR")
    private Long matusetransid;

    private BigDecimal actualcost;

    private Date actualdate;

    private String assetnum;

    private String binnum;

    private String commodity;

    private String commoditygroup;

    private String conditioncode;

    private Integer condrate;

    private Integer consignment;

    private String consinvoicenum;

    private String consvendor;

    private BigDecimal conversion;

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

    private String glcreditacct;

    private String gldebitacct;

    private Integer hasld;

    private Long invuseid;

    private Long invuselineid;

    private Long issueid;

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

    @Column(name = "\"LOCATION\"")
    private String location;

    private String lotnum;

    private Long matrectransid;

    private String memo;

    private Integer mrlinenum;

    private String mrnum;

    private String orgid;

    private Integer outside;

    private String ownersysid;

    private String packingslipnum;

    private BigDecimal physcnt;

    private Integer polinenum;

    private String ponum;

    private Integer porevisionnum;

    private BigDecimal qtyrequested;

    private BigDecimal qtyreturned;

    private BigDecimal quantity;

    private String refwo;

    @Column(name = "\"ROLLUP\"")
    private Integer rollup;

    private String rotassetnum;

    private Long rowstamp;

    private String sendersysid;

    private String siteid;

    private String sourcesysid;

    private Integer sparepartadded;

    private String storeloc;

    private String tositeid;

    private Date transdate;

    private BigDecimal unitcost;

    @Transient
    private Long frontedid;

    public Matusetran() {
    }



    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public Long getMatusetransid() {
        return this.matusetransid;
    }

    public void setMatusetransid(Long matusetransid) {
        this.matusetransid = matusetransid;
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

    public String getBinnum() {
        return this.binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
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

    public Long getIssueid() {
        return this.issueid;
    }

    public void setIssueid(Long issueid) {
        this.issueid = issueid;
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

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLotnum() {
        return this.lotnum;
    }

    public void setLotnum(String lotnum) {
        this.lotnum = lotnum;
    }

    public Long getMatrectransid() {
        return this.matrectransid;
    }

    public void setMatrectransid(Long matrectransid) {
        this.matrectransid = matrectransid;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
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

    public BigDecimal getPhyscnt() {
        return this.physcnt;
    }

    public void setPhyscnt(BigDecimal physcnt) {
        this.physcnt = physcnt;
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

    public BigDecimal getQtyrequested() {
        return this.qtyrequested;
    }

    public void setQtyrequested(BigDecimal qtyrequested) {
        this.qtyrequested = qtyrequested;
    }

    public BigDecimal getQtyreturned() {
        return this.qtyreturned;
    }

    public void setQtyreturned(BigDecimal qtyreturned) {
        this.qtyreturned = qtyreturned;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRefwo() {
        return this.refwo;
    }

    public void setRefwo(String refwo) {
        this.refwo = refwo;
    }

    public Integer getRollup() {
        return this.rollup;
    }

    public void setRollup(Integer rollup) {
        this.rollup = rollup;
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

    public Integer getSparepartadded() {
        return this.sparepartadded;
    }

    public void setSparepartadded(Integer sparepartadded) {
        this.sparepartadded = sparepartadded;
    }

    public String getStoreloc() {
        return this.storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public String getTositeid() {
        return this.tositeid;
    }

    public void setTositeid(String tositeid) {
        this.tositeid = tositeid;
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