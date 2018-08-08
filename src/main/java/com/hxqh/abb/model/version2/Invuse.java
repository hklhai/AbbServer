package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INVUSE database table.
 */
@Entity
@Table(name = "Invuse")
@DynamicUpdate
public class Invuse implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "INVUSE_INVUSEID_GENERATOR", allocationSize = 1, sequenceName = "INVUSESEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVUSE_INVUSEID_GENERATOR")
    private Long invuseid;

    private Integer ismaint;

    private Integer autocreated;

    private String changeby;

    private Date changedate;

    private String createdby;

    private String currencycode;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date exchangedate;

    private BigDecimal exchangerate;

    private BigDecimal exchangerate2;

    private String fromstoreloc;

    private Integer hasld;

    private String invowner;

    private String invusenum;

    private Integer issite;

    private String langcode;

    private String linenum;

    private String orgid;

    private String pronum;

    private String receipts;

    private String remark;

    private Long rowstamp;

    private String sapnumber;

    private String sendersysid;

    private Date shipmentdate;

    private String shiptoattn;

    private String siteid;

    @Column(name = "\"STATUS\"")
    private String status;

    private Date statusdate;

    private Integer statusiface;

    private String udapptype;

    private String udareaman;

    private String udcontact;

    private String udpmanager;

    private String udprojectnum;

    private String udreceipt;

    private BigDecimal udtotal;

    private String usetype;

    private Integer warranty;

    private Long workorderid;

    @Transient
    private String apptname;

    @Transient
    private String deletes;

    @Transient
    private String maintab;

    @Transient
    private String locationsdescription;

    @Transient
    private String personid;

    @Transient
    private String persondisplayname;

    @Transient
    private List<Invuseline> invuselineList;

    @Transient
    private String orderdate;


    @Transient
    private String location;

    public Invuse() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getApptname() {
        return apptname;
    }

    public void setApptname(String apptname) {
        this.apptname = apptname;
    }

    public Long getInvuseid() {
        return invuseid;
    }

    public void setInvuseid(Long invuseid) {
        this.invuseid = invuseid;
    }

    public Integer getAutocreated() {
        return autocreated;
    }

    public void setAutocreated(Integer autocreated) {
        this.autocreated = autocreated;
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

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFromstoreloc() {
        return fromstoreloc;
    }

    public void setFromstoreloc(String fromstoreloc) {
        this.fromstoreloc = fromstoreloc;
    }

    public Integer getHasld() {
        return hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public String getInvowner() {
        return invowner;
    }

    public void setInvowner(String invowner) {
        this.invowner = invowner;
    }

    public String getInvusenum() {
        return invusenum;
    }

    public void setInvusenum(String invusenum) {
        this.invusenum = invusenum;
    }

    public Integer getIssite() {
        return issite;
    }

    public void setIssite(Integer issite) {
        this.issite = issite;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public String getLinenum() {
        return linenum;
    }

    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getPronum() {
        return pronum;
    }

    public void setPronum(String pronum) {
        this.pronum = pronum;
    }

    public String getReceipts() {
        return receipts;
    }

    public void setReceipts(String receipts) {
        this.receipts = receipts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSapnumber() {
        return sapnumber;
    }

    public void setSapnumber(String sapnumber) {
        this.sapnumber = sapnumber;
    }

    public String getSendersysid() {
        return sendersysid;
    }

    public void setSendersysid(String sendersysid) {
        this.sendersysid = sendersysid;
    }

    public Date getShipmentdate() {
        return shipmentdate;
    }

    public void setShipmentdate(Date shipmentdate) {
        this.shipmentdate = shipmentdate;
    }

    public String getShiptoattn() {
        return shiptoattn;
    }

    public void setShiptoattn(String shiptoattn) {
        this.shiptoattn = shiptoattn;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
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

    public Integer getStatusiface() {
        return statusiface;
    }

    public void setStatusiface(Integer statusiface) {
        this.statusiface = statusiface;
    }

    public String getUdapptype() {
        return udapptype;
    }

    public void setUdapptype(String udapptype) {
        this.udapptype = udapptype;
    }

    public String getUdareaman() {
        return udareaman;
    }

    public void setUdareaman(String udareaman) {
        this.udareaman = udareaman;
    }

    public String getUdcontact() {
        return udcontact;
    }

    public void setUdcontact(String udcontact) {
        this.udcontact = udcontact;
    }

    public String getUdpmanager() {
        return udpmanager;
    }

    public void setUdpmanager(String udpmanager) {
        this.udpmanager = udpmanager;
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

    public BigDecimal getUdtotal() {
        return udtotal;
    }

    public void setUdtotal(BigDecimal udtotal) {
        this.udtotal = udtotal;
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public Long getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(Long workorderid) {
        this.workorderid = workorderid;
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

    public String getLocationsdescription() {
        return locationsdescription;
    }

    public void setLocationsdescription(String locationsdescription) {
        this.locationsdescription = locationsdescription;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPersondisplayname() {
        return persondisplayname;
    }

    public void setPersondisplayname(String persondisplayname) {
        this.persondisplayname = persondisplayname;
    }

    public List<Invuseline> getInvuselineList() {
        return invuselineList;
    }

    public void setInvuselineList(List<Invuseline> invuselineList) {
        this.invuselineList = invuselineList;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getIsmaint() {
        return ismaint;
    }

    public void setIsmaint(Integer ismaint) {
        this.ismaint = ismaint;
    }
}