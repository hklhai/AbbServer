package com.hxqh.abb.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxqh.abb.model.paperless.Udcustomer;
import com.hxqh.abb.model.paperless.Udequipment;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-09-30.
 */
@Entity
@Table(name = "PAPERLESS_UDPROJECTLINE")
public class PaperlessProjectline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long udprojectlineid;
    private String description;
    private String orgid;
    private String siteid;
    private Long hasld;
    private String edengineer;
    private String mdengineer;
    private String equipmentnum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date actualcompletedate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date actualcompletiondate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date actualdebugdate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date actualinstalldate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date actualsendpowerdate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date actualshipmentdate;
    private String childservicepro;
    private String mainservicepro;
    private String projectmanager;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date palncompletiondate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date palndebugdate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date palnsendpowerdate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date palnshipmentdate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date plancompletedate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date planinstalldate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Date qualitymaturitydate;
    private Double quantity;
    private String servicedep;
    private Double workinghours;
    private String industryattributes;
    private Long busbridge;
    private Long protectprogram;
    private String protecttype;
    private Double protectqty;
    private String provinces;
    private String city;
    private String address;
    private String salesengineer;
    private String pronum;
    private Long linenum;
    private String model;
    private Long rowstamp;
    private String ctrnum;
    private String areamanager;
    private String areamanagername;
    private String servicemanager;
    private String servicemanagername;
    private Long kv;
    private String producer;
    private String area1;

    @Transient
    private List<Udcustomer> udcustomerList;
    @Transient
    private List<PaperlessEquipment> udequipmentList;
    @Transient
    private String udcustomerdeletes;
    @Transient
    private String udequipmentdeletes;

    public List<Udcustomer> getUdcustomerList() {
        return udcustomerList;
    }

    public void setUdcustomerList(List<Udcustomer> udcustomerList) {
        this.udcustomerList = udcustomerList;
    }

    public List<PaperlessEquipment> getUdequipmentList() {
        return udequipmentList;
    }

    public void setUdequipmentList(List<PaperlessEquipment> udequipmentList) {
        this.udequipmentList = udequipmentList;
    }

    public String getUdcustomerdeletes() {
        return udcustomerdeletes;
    }

    public void setUdcustomerdeletes(String udcustomerdeletes) {
        this.udcustomerdeletes = udcustomerdeletes;
    }

    public String getUdequipmentdeletes() {
        return udequipmentdeletes;
    }

    public void setUdequipmentdeletes(String udequipmentdeletes) {
        this.udequipmentdeletes = udequipmentdeletes;
    }

    public Long getUdprojectlineid() {
        return udprojectlineid;
    }

    public void setUdprojectlineid(Long udprojectlineid) {
        this.udprojectlineid = udprojectlineid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Long getHasld() {
        return hasld;
    }

    public void setHasld(Long hasld) {
        this.hasld = hasld;
    }

    public String getEdengineer() {
        return edengineer;
    }

    public void setEdengineer(String edengineer) {
        this.edengineer = edengineer;
    }

    public String getMdengineer() {
        return mdengineer;
    }

    public void setMdengineer(String mdengineer) {
        this.mdengineer = mdengineer;
    }

    public String getEquipmentnum() {
        return equipmentnum;
    }

    public void setEquipmentnum(String equipmentnum) {
        this.equipmentnum = equipmentnum;
    }

    public java.sql.Date getActualcompletedate() {
        return actualcompletedate;
    }

    public void setActualcompletedate(java.sql.Date actualcompletedate) {
        this.actualcompletedate = actualcompletedate;
    }

    public java.sql.Date getActualcompletiondate() {
        return actualcompletiondate;
    }

    public void setActualcompletiondate(java.sql.Date actualcompletiondate) {
        this.actualcompletiondate = actualcompletiondate;
    }

    public java.sql.Date getActualdebugdate() {
        return actualdebugdate;
    }

    public void setActualdebugdate(java.sql.Date actualdebugdate) {
        this.actualdebugdate = actualdebugdate;
    }

    public java.sql.Date getActualinstalldate() {
        return actualinstalldate;
    }

    public void setActualinstalldate(java.sql.Date actualinstalldate) {
        this.actualinstalldate = actualinstalldate;
    }

    public java.sql.Date getActualsendpowerdate() {
        return actualsendpowerdate;
    }

    public void setActualsendpowerdate(java.sql.Date actualsendpowerdate) {
        this.actualsendpowerdate = actualsendpowerdate;
    }

    public java.sql.Date getActualshipmentdate() {
        return actualshipmentdate;
    }

    public void setActualshipmentdate(java.sql.Date actualshipmentdate) {
        this.actualshipmentdate = actualshipmentdate;
    }

    public String getChildservicepro() {
        return childservicepro;
    }

    public void setChildservicepro(String childservicepro) {
        this.childservicepro = childservicepro;
    }

    public String getMainservicepro() {
        return mainservicepro;
    }

    public void setMainservicepro(String mainservicepro) {
        this.mainservicepro = mainservicepro;
    }

    public String getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(String projectmanager) {
        this.projectmanager = projectmanager;
    }

    public java.sql.Date getPalncompletiondate() {
        return palncompletiondate;
    }

    public void setPalncompletiondate(java.sql.Date palncompletiondate) {
        this.palncompletiondate = palncompletiondate;
    }

    public java.sql.Date getPalndebugdate() {
        return palndebugdate;
    }

    public void setPalndebugdate(java.sql.Date palndebugdate) {
        this.palndebugdate = palndebugdate;
    }

    public java.sql.Date getPalnsendpowerdate() {
        return palnsendpowerdate;
    }

    public void setPalnsendpowerdate(java.sql.Date palnsendpowerdate) {
        this.palnsendpowerdate = palnsendpowerdate;
    }

    public java.sql.Date getPalnshipmentdate() {
        return palnshipmentdate;
    }

    public void setPalnshipmentdate(java.sql.Date palnshipmentdate) {
        this.palnshipmentdate = palnshipmentdate;
    }

    public java.sql.Date getPlancompletedate() {
        return plancompletedate;
    }

    public void setPlancompletedate(java.sql.Date plancompletedate) {
        this.plancompletedate = plancompletedate;
    }

    public java.sql.Date getPlaninstalldate() {
        return planinstalldate;
    }

    public void setPlaninstalldate(java.sql.Date planinstalldate) {
        this.planinstalldate = planinstalldate;
    }

    public java.sql.Date getQualitymaturitydate() {
        return qualitymaturitydate;
    }

    public void setQualitymaturitydate(java.sql.Date qualitymaturitydate) {
        this.qualitymaturitydate = qualitymaturitydate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getServicedep() {
        return servicedep;
    }

    public void setServicedep(String servicedep) {
        this.servicedep = servicedep;
    }

    public Double getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(Double workinghours) {
        this.workinghours = workinghours;
    }

    public String getIndustryattributes() {
        return industryattributes;
    }

    public void setIndustryattributes(String industryattributes) {
        this.industryattributes = industryattributes;
    }

    public Long getBusbridge() {
        return busbridge;
    }

    public void setBusbridge(Long busbridge) {
        this.busbridge = busbridge;
    }

    public Long getProtectprogram() {
        return protectprogram;
    }

    public void setProtectprogram(Long protectprogram) {
        this.protectprogram = protectprogram;
    }

    public String getProtecttype() {
        return protecttype;
    }

    public void setProtecttype(String protecttype) {
        this.protecttype = protecttype;
    }

    public Double getProtectqty() {
        return protectqty;
    }

    public void setProtectqty(Double protectqty) {
        this.protectqty = protectqty;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalesengineer() {
        return salesengineer;
    }

    public void setSalesengineer(String salesengineer) {
        this.salesengineer = salesengineer;
    }

    public String getPronum() {
        return pronum;
    }

    public void setPronum(String pronum) {
        this.pronum = pronum;
    }

    public Long getLinenum() {
        return linenum;
    }

    public void setLinenum(Long linenum) {
        this.linenum = linenum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getCtrnum() {
        return ctrnum;
    }

    public void setCtrnum(String ctrnum) {
        this.ctrnum = ctrnum;
    }

    public String getAreamanager() {
        return areamanager;
    }

    public void setAreamanager(String areamanager) {
        this.areamanager = areamanager;
    }

    public String getAreamanagername() {
        return areamanagername;
    }

    public void setAreamanagername(String areamanagername) {
        this.areamanagername = areamanagername;
    }

    public String getServicemanager() {
        return servicemanager;
    }

    public void setServicemanager(String servicemanager) {
        this.servicemanager = servicemanager;
    }

    public String getServicemanagername() {
        return servicemanagername;
    }

    public void setServicemanagername(String servicemanagername) {
        this.servicemanagername = servicemanagername;
    }

    public Long getKv() {
        return kv;
    }

    public void setKv(Long kv) {
        this.kv = kv;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }
}
