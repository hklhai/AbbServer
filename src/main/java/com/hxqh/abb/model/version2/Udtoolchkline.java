package com.hxqh.abb.model.version2;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the UDTOOLCHKLINE database table.
 */
@Entity
@Table(name = "Udtoolchkline")
@DynamicUpdate
public class Udtoolchkline implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDTOOLCHKLINE_UDTOOLCHKLINEID_GENERATOR", allocationSize = 1, sequenceName = "UDTOOLCHKLINEIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDTOOLCHKLINE_UDTOOLCHKLINEID_GENERATOR")
    private Long udtoolchklineid;

    private String chkby;

    private Date chkdate;

    private String chkstatus;

    private String createby;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;

    private String description;

    private int hasld;

    private String orgid;

    private String remark;

    private long rowstamp;

    private String siteid;

    private String tcnum;

    private String toolnum;

    private String tooltype;

    @Transient
    private Long frontedid;

    @Transient
    private String udtooldescription;

    @Transient
    private String persondisplayname;

    @Transient
    private String personid;

    @Transient
    private Date enterdate;


    @Transient
    private Date actualdate;

    @Transient
    private String enterby;
    @Transient
    private String frombin;
    @Transient
    private String issueto;
    @Transient
    private String itemnum;
    @Transient
    private String quantity;
    @Transient
    private String tobin;
    @Transient
    private String tositeid;
    @Transient
    private String tostoreloc;
    @Transient
    private String udmodel;
    @Transient
    private String invuselineid;
    @Transient
    private String enterbydisplayname;
    @Transient
    private String invuselinenum;
    @Transient
    private String udcontact;
    @Transient
    private String udprojectnum;
    @Transient
    private String udreceipt;
    @Transient
    private String polinenum;
    @Transient
    private String itemdescription;
    @Transient
    private String itemudmodel;
    @Transient
    private String key;
    @Transient
    private String inventorycurbaltotal;
    @Transient
    private String invusenum;
    @Transient
    private String wonum;
    @Transient
    private String fromrin;
    @Transient
    private String linenum;
    @Transient
    private String displaylinecost;
    @Transient
    private String displayunitcost;
    @Transient
    private String invuseline;
    @Transient
    private String location;
    @Transient
    private String storeloc;
    @Transient
    private String taskid;
    @Transient
    private String usetype;
    @Transient
    private String issueunit;
    @Transient
    private String curbaltotal;
    @Transient
    private String receiptquantity;
    @Transient
    private String receivedunit;
    @Transient
    private String conversion;
    @Transient
    private String assetnum;
    @Transient
    private String orderqty;
    @Transient
    private String requestedby;
    @Transient
    private String shipto;
    @Transient
    private String udresource;
    @Transient
    private String linecost;
    @Transient
    private String unitcost;
    @Transient
    private String polineid;
    @Transient
    private String tableIndex;
    @Transient
    private String invbalancescurbal;







    public Udtoolchkline() {
    }


    public String getInvbalancescurbal() {
        return invbalancescurbal;
    }

    public void setInvbalancescurbal(String invbalancescurbal) {
        this.invbalancescurbal = invbalancescurbal;
    }

    public String getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(String tableIndex) {
        this.tableIndex = tableIndex;
    }

    public String getPolineid() {
        return polineid;
    }

    public void setPolineid(String polineid) {
        this.polineid = polineid;
    }

    public String getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(String unitcost) {
        this.unitcost = unitcost;
    }

    public String getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(String orderqty) {
        this.orderqty = orderqty;
    }

    public String getRequestedby() {
        return requestedby;
    }

    public void setRequestedby(String requestedby) {
        this.requestedby = requestedby;
    }

    public String getLinecost() {
        return linecost;
    }

    public void setLinecost(String linecost) {
        this.linecost = linecost;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public String getUdresource() {
        return udresource;
    }

    public void setUdresource(String udresource) {
        this.udresource = udresource;
    }

    public String getAssetnum() {
        return assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getReceiptquantity() {
        return receiptquantity;
    }

    public void setReceiptquantity(String receiptquantity) {
        this.receiptquantity = receiptquantity;
    }

    public String getReceivedunit() {
        return receivedunit;
    }

    public void setReceivedunit(String receivedunit) {
        this.receivedunit = receivedunit;
    }

    public String getCurbaltotal() {
        return curbaltotal;
    }

    public void setCurbaltotal(String curbaltotal) {
        this.curbaltotal = curbaltotal;
    }

    public String getIssueunit() {
        return issueunit;
    }

    public void setIssueunit(String issueunit) {
        this.issueunit = issueunit;
    }

    public String getStoreloc() {
        return storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype;
    }

    public String getDisplayunitcost() {
        return displayunitcost;
    }

    public void setDisplayunitcost(String displayunitcost) {
        this.displayunitcost = displayunitcost;
    }

    public String getDisplaylinecost() {
        return displaylinecost;
    }

    public void setDisplaylinecost(String displaylinecost) {
        this.displaylinecost = displaylinecost;
    }

    public String getInvuseline() {
        return invuseline;
    }

    public void setInvuseline(String invuseline) {
        this.invuseline = invuseline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLinenum() {
        return linenum;
    }

    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }

    public String getFromrin() {
        return fromrin;
    }

    public void setFromrin(String fromrin) {
        this.fromrin = fromrin;
    }

    public String getInvusenum() {
        return invusenum;
    }

    public void setInvusenum(String invusenum) {
        this.invusenum = invusenum;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public String getInventorycurbaltotal() {
        return inventorycurbaltotal;
    }

    public void setInventorycurbaltotal(String inventorycurbaltotal) {
        this.inventorycurbaltotal = inventorycurbaltotal;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItemudmodel() {
        return itemudmodel;
    }

    public void setItemudmodel(String itemudmodel) {
        this.itemudmodel = itemudmodel;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getPolinenum() {
        return polinenum;
    }

    public void setPolinenum(String polinenum) {
        this.polinenum = polinenum;
    }

    public String getUdreceipt() {
        return udreceipt;
    }

    public void setUdreceipt(String udreceipt) {
        this.udreceipt = udreceipt;
    }

    public String getUdprojectnum() {
        return udprojectnum;
    }

    public void setUdprojectnum(String udprojectnum) {
        this.udprojectnum = udprojectnum;
    }

    public String getUdcontact() {
        return udcontact;
    }

    public void setUdcontact(String udcontact) {
        this.udcontact = udcontact;
    }

    public String getInvuselinenum() {
        return invuselinenum;
    }

    public void setInvuselinenum(String invuselinenum) {
        this.invuselinenum = invuselinenum;
    }

    public String getEnterbydisplayname() {
        return enterbydisplayname;
    }

    public void setEnterbydisplayname(String enterbydisplayname) {
        this.enterbydisplayname = enterbydisplayname;
    }

    public String getInvuselineid() {
        return invuselineid;
    }

    public void setInvuselineid(String invuselineid) {
        this.invuselineid = invuselineid;
    }

    public String getUdmodel() {
        return udmodel;
    }

    public void setUdmodel(String udmodel) {
        this.udmodel = udmodel;
    }

    public String getTostoreloc() {
        return tostoreloc;
    }

    public void setTostoreloc(String tostoreloc) {
        this.tostoreloc = tostoreloc;
    }

    public String getTositeid() {
        return tositeid;
    }

    public void setTositeid(String tositeid) {
        this.tositeid = tositeid;
    }

    public String getTobin() {
        return tobin;
    }

    public void setTobin(String tobin) {
        this.tobin = tobin;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getFrombin() {
        return frombin;
    }

    public void setFrombin(String frombin) {
        this.frombin = frombin;
    }

    public String getEnterby() {
        return enterby;
    }

    public void setEnterby(String enterby) {
        this.enterby = enterby;
    }

    public Date getActualdate() {
        return actualdate;
    }

    public void setActualdate(Date actualdate) {
        this.actualdate = actualdate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
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

    public String getUdtooldescription() {
        return udtooldescription;
    }

    public void setUdtooldescription(String udtooldescription) {
        this.udtooldescription = udtooldescription;
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public Long getUdtoolchklineid() {
        return this.udtoolchklineid;
    }

    public void setUdtoolchklineid(Long udtoolchklineid) {
        this.udtoolchklineid = udtoolchklineid;
    }

    public String getChkby() {
        return this.chkby;
    }

    public void setChkby(String chkby) {
        this.chkby = chkby;
    }

    public Date getChkdate() {
        return this.chkdate;
    }

    public void setChkdate(Date chkdate) {
        this.chkdate = chkdate;
    }

    public String getChkstatus() {
        return this.chkstatus;
    }

    public void setChkstatus(String chkstatus) {
        this.chkstatus = chkstatus;
    }

    public String getCreateby() {
        return this.createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHasld() {
        return this.hasld;
    }

    public void setHasld(int hasld) {
        this.hasld = hasld;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getTcnum() {
        return this.tcnum;
    }

    public void setTcnum(String tcnum) {
        this.tcnum = tcnum;
    }

    public String getToolnum() {
        return this.toolnum;
    }

    public void setToolnum(String toolnum) {
        this.toolnum = toolnum;
    }

    public String getTooltype() {
        return this.tooltype;
    }

    public void setTooltype(String tooltype) {
        this.tooltype = tooltype;
    }

}