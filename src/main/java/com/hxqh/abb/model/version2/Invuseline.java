package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INVUSELINE database table.
 */
@Entity
@Table(name = "Invuseline")
@DynamicUpdate
public class Invuseline implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "INVUSELINE_INVUSELINEID_GENERATOR", allocationSize = 1, sequenceName = "INVUSELINESEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVUSELINE_INVUSELINEID_GENERATOR")
    private Long invuselineid;


    private Date actualdate;

    private String assetnum;

    private String commodity;

    private String commoditygroup;

    private BigDecimal conversion;

    private String description;

    private String enterby;

    private Integer enteredastask;

    private String financialperiod;

    private String frombin;

    private String fromconditioncode;

    private String fromlot;

    private String fromstoreloc;

    private String glcreditacct;

    private String gldebitacct;

    private Integer hasld;

    private Integer inspectionrequired;

    private Integer invuselinenum;

    private String invusenum;

    private Long issueid;

    private String issueto;

    private String itemnum;

    private String itemsetid;

    private String langcode;

    private BigDecimal linecost;

    private String linenum;

    private String linetype;

    @Column(name = "\"LOCATION\"")
    private String location;

    private Integer mrlinenum;

    private String mrnum;

    private String newassetnum;

    private String orgid;

    private BigDecimal physcnt;

    private Date physcntdate;

    private Integer polinenum;

    private String ponum;

    private Integer porevisionnum;

    private String positeid;

    private String prsiteid;

    private BigDecimal quantity;

    private Integer receiptscomplete;

    private BigDecimal receivedqty;

    private String refwo;

    private String remark;

    private String requestnum;

    private Integer returnagainstissue;

    private BigDecimal returnedqty;

    private String rotassetnum;

    private Long rowstamp;

    private String sendersysid;

    private String siteid;

    @Column(name = "\"SPLIT\"")
    private Integer split;

    private String tobin;

    private String toconditioncode;

    private String tolot;

    private String toorgid;

    private String tositeid;

    private String tostoreloc;

    private String udcontact;

    private String udprojectnum;

    private String udreceipt;

    private String udrecipient;

    private String udsapnum;

    private String udwonum2;

    private BigDecimal unitcost;

    private String usetype;

    @Column(name = "\"VALIDATED\"")
    private Integer validated;

    @Transient
    private Long frontedid;

    @Transient
    private String itemdescription;

    @Transient
    private String itemudmodel;

    @Transient
    private String invbalancescurbal;

    @Transient
    private String persondisplayname;

    @Transient
    private String invuseline;

    @Transient
    private String udmodel;
    // TODO: 2017/11/13  添加的可忽略的字段
    @Transient
    private String wonum;
    @Transient
    private String taskid;

    @Transient
    private BigDecimal curbal;
    @Transient
    private String locationsdescription;
    @Transient
    private String formbin;


    public Invuseline() {
    }

    public String getFormbin() {
        return formbin;
    }

    public void setFormbin(String formbin) {
        this.formbin = formbin;
    }

    public String getLocationsdescription() {
        return locationsdescription;
    }

    public void setLocationsdescription(String locationsdescription) {
        this.locationsdescription = locationsdescription;
    }

    public BigDecimal getCurbal() {
        return curbal;
    }

    public void setCurbal(BigDecimal curbal) {
        this.curbal = curbal;
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

    public String getPersondisplayname() {
        return persondisplayname;
    }

    public void setPersondisplayname(String persondisplayname) {
        this.persondisplayname = persondisplayname;
    }

    public String getInvbalancescurbal() {
        return invbalancescurbal;
    }

    public void setInvbalancescurbal(String invbalancescurbal) {
        this.invbalancescurbal = invbalancescurbal;
    }

    public String getUdmodel() {
        return udmodel;
    }

    public void setUdmodel(String udmodel) {
        this.udmodel = udmodel;
    }

    public String getInvuseline() {
        return invuseline;
    }

    public void setInvuseline(String invuseline) {
        this.invuseline = invuseline;
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

    public Long getInvuselineid() {
        return invuselineid;
    }

    public void setInvuselineid(Long invuselineid) {
        this.invuselineid = invuselineid;
    }

    public Date getActualdate() {
        return actualdate;
    }

    public void setActualdate(Date actualdate) {
        this.actualdate = actualdate;
    }

    public String getAssetnum() {
        return assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCommoditygroup() {
        return commoditygroup;
    }

    public void setCommoditygroup(String commoditygroup) {
        this.commoditygroup = commoditygroup;
    }

    public BigDecimal getConversion() {
        return conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnterby() {
        return enterby;
    }

    public void setEnterby(String enterby) {
        this.enterby = enterby;
    }

    public Integer getEnteredastask() {
        return enteredastask;
    }

    public void setEnteredastask(Integer enteredastask) {
        this.enteredastask = enteredastask;
    }

    public String getFinancialperiod() {
        return financialperiod;
    }

    public void setFinancialperiod(String financialperiod) {
        this.financialperiod = financialperiod;
    }

    public String getFrombin() {
        return frombin;
    }

    public void setFrombin(String frombin) {
        this.frombin = frombin;
    }

    public String getFromconditioncode() {
        return fromconditioncode;
    }

    public void setFromconditioncode(String fromconditioncode) {
        this.fromconditioncode = fromconditioncode;
    }

    public String getFromlot() {
        return fromlot;
    }

    public void setFromlot(String fromlot) {
        this.fromlot = fromlot;
    }

    public String getFromstoreloc() {
        return fromstoreloc;
    }

    public void setFromstoreloc(String fromstoreloc) {
        this.fromstoreloc = fromstoreloc;
    }

    public String getGlcreditacct() {
        return glcreditacct;
    }

    public void setGlcreditacct(String glcreditacct) {
        this.glcreditacct = glcreditacct;
    }

    public String getGldebitacct() {
        return gldebitacct;
    }

    public void setGldebitacct(String gldebitacct) {
        this.gldebitacct = gldebitacct;
    }

    public Integer getHasld() {
        return hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public Integer getInspectionrequired() {
        return inspectionrequired;
    }

    public void setInspectionrequired(Integer inspectionrequired) {
        this.inspectionrequired = inspectionrequired;
    }

    public Integer getInvuselinenum() {
        return invuselinenum;
    }

    public void setInvuselinenum(Integer invuselinenum) {
        this.invuselinenum = invuselinenum;
    }

    public String getInvusenum() {
        return invusenum;
    }

    public void setInvusenum(String invusenum) {
        this.invusenum = invusenum;
    }

    public Long getIssueid() {
        return issueid;
    }

    public void setIssueid(Long issueid) {
        this.issueid = issueid;
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getItemsetid() {
        return itemsetid;
    }

    public void setItemsetid(String itemsetid) {
        this.itemsetid = itemsetid;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public BigDecimal getLinecost() {
        return linecost;
    }

    public void setLinecost(BigDecimal linecost) {
        this.linecost = linecost;
    }

    public String getLinenum() {
        return linenum;
    }

    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }

    public String getLinetype() {
        return linetype;
    }

    public void setLinetype(String linetype) {
        this.linetype = linetype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMrlinenum() {
        return mrlinenum;
    }

    public void setMrlinenum(Integer mrlinenum) {
        this.mrlinenum = mrlinenum;
    }

    public String getMrnum() {
        return mrnum;
    }

    public void setMrnum(String mrnum) {
        this.mrnum = mrnum;
    }

    public String getNewassetnum() {
        return newassetnum;
    }

    public void setNewassetnum(String newassetnum) {
        this.newassetnum = newassetnum;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public BigDecimal getPhyscnt() {
        return physcnt;
    }

    public void setPhyscnt(BigDecimal physcnt) {
        this.physcnt = physcnt;
    }

    public Date getPhyscntdate() {
        return physcntdate;
    }

    public void setPhyscntdate(Date physcntdate) {
        this.physcntdate = physcntdate;
    }

    public Integer getPolinenum() {
        return polinenum;
    }

    public void setPolinenum(Integer polinenum) {
        this.polinenum = polinenum;
    }

    public String getPonum() {
        return ponum;
    }

    public void setPonum(String ponum) {
        this.ponum = ponum;
    }

    public Integer getPorevisionnum() {
        return porevisionnum;
    }

    public void setPorevisionnum(Integer porevisionnum) {
        this.porevisionnum = porevisionnum;
    }

    public String getPositeid() {
        return positeid;
    }

    public void setPositeid(String positeid) {
        this.positeid = positeid;
    }

    public String getPrsiteid() {
        return prsiteid;
    }

    public void setPrsiteid(String prsiteid) {
        this.prsiteid = prsiteid;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Integer getReceiptscomplete() {
        return receiptscomplete;
    }

    public void setReceiptscomplete(Integer receiptscomplete) {
        this.receiptscomplete = receiptscomplete;
    }

    public BigDecimal getReceivedqty() {
        return receivedqty;
    }

    public void setReceivedqty(BigDecimal receivedqty) {
        this.receivedqty = receivedqty;
    }

    public String getRefwo() {
        return refwo;
    }

    public void setRefwo(String refwo) {
        this.refwo = refwo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequestnum() {
        return requestnum;
    }

    public void setRequestnum(String requestnum) {
        this.requestnum = requestnum;
    }

    public Integer getReturnagainstissue() {
        return returnagainstissue;
    }

    public void setReturnagainstissue(Integer returnagainstissue) {
        this.returnagainstissue = returnagainstissue;
    }

    public BigDecimal getReturnedqty() {
        return returnedqty;
    }

    public void setReturnedqty(BigDecimal returnedqty) {
        this.returnedqty = returnedqty;
    }

    public String getRotassetnum() {
        return rotassetnum;
    }

    public void setRotassetnum(String rotassetnum) {
        this.rotassetnum = rotassetnum;
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

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Integer getSplit() {
        return split;
    }

    public void setSplit(Integer split) {
        this.split = split;
    }

    public String getTobin() {
        return tobin;
    }

    public void setTobin(String tobin) {
        this.tobin = tobin;
    }

    public String getToconditioncode() {
        return toconditioncode;
    }

    public void setToconditioncode(String toconditioncode) {
        this.toconditioncode = toconditioncode;
    }

    public String getTolot() {
        return tolot;
    }

    public void setTolot(String tolot) {
        this.tolot = tolot;
    }

    public String getToorgid() {
        return toorgid;
    }

    public void setToorgid(String toorgid) {
        this.toorgid = toorgid;
    }

    public String getTositeid() {
        return tositeid;
    }

    public void setTositeid(String tositeid) {
        this.tositeid = tositeid;
    }

    public String getTostoreloc() {
        return tostoreloc;
    }

    public void setTostoreloc(String tostoreloc) {
        this.tostoreloc = tostoreloc;
    }

    public String getUdcontact() {
        return udcontact;
    }

    public void setUdcontact(String udcontact) {
        this.udcontact = udcontact;
    }

    public String getUdprojectnum() {
        return udprojectnum;
    }

    public void setUdprojectnum(String udprojectnum) {
        this.udprojectnum = udprojectnum;
    }

    public String getUdreceipt() {
        return udreceipt;
    }

    public void setUdreceipt(String udreceipt) {
        this.udreceipt = udreceipt;
    }

    public String getUdrecipient() {
        return udrecipient;
    }

    public void setUdrecipient(String udrecipient) {
        this.udrecipient = udrecipient;
    }

    public String getUdsapnum() {
        return udsapnum;
    }

    public void setUdsapnum(String udsapnum) {
        this.udsapnum = udsapnum;
    }

    public String getUdwonum2() {
        return udwonum2;
    }

    public void setUdwonum2(String udwonum2) {
        this.udwonum2 = udwonum2;
    }

    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype;
    }

    public Integer getValidated() {
        return validated;
    }

    public void setValidated(Integer validated) {
        this.validated = validated;
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }
}