package com.hxqh.abb.model.view;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2017-09-27.
 */
@Entity
@Table(name = "PAPERLESS_UDPROJECT")
public class PaperlessProject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long udprojectid;
    private String description;
    private String orgid;
    private String siteid;
    private Long hasld;
    private String status;
    private String statusdesc;
    private java.sql.Timestamp statusdate;
    private String createdby;
    private String createdbyname;
    private java.sql.Timestamp createddate;
    private String changeby;
    private String changebyname;
    private java.sql.Timestamp changedate;
    private String appointperson;
    private String appointpersonname;
    private java.sql.Timestamp appointdate;
    private String equipmentnum;
    private Double quantity;
    private String servicedep;
    private Double workinghours;
    private String mainservicepro;
    private String childservicepro;
    private String projectmanager;
    private String projectmanagername;
    private String pronum;
    private String edengineer;
    private String edengineername;
    private String mdengineer;
    private String mdengineername;
    private String salesengineer;
    private String salesengineername;
    private java.sql.Date appointdate2;
    private String khcontacts;
    private String khphone;
    private String khemail;
    private String khcompany;
    private Long rowstamp;
    private String provinces;
    private String area1;
    private String personid;
    private String personid2;

    public Long getUdprojectid() {
        return udprojectid;
    }

    public void setUdprojectid(Long udprojectid) {
        this.udprojectid = udprojectid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusdesc() {
        return statusdesc;
    }

    public void setStatusdesc(String statusdesc) {
        this.statusdesc = statusdesc;
    }

    public java.sql.Timestamp getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(java.sql.Timestamp statusdate) {
        this.statusdate = statusdate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getCreatedbyname() {
        return createdbyname;
    }

    public void setCreatedbyname(String createdbyname) {
        this.createdbyname = createdbyname;
    }

    public java.sql.Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(java.sql.Timestamp createddate) {
        this.createddate = createddate;
    }

    public String getChangeby() {
        return changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    public String getChangebyname() {
        return changebyname;
    }

    public void setChangebyname(String changebyname) {
        this.changebyname = changebyname;
    }

    public java.sql.Timestamp getChangedate() {
        return changedate;
    }

    public void setChangedate(java.sql.Timestamp changedate) {
        this.changedate = changedate;
    }

    public String getAppointperson() {
        return appointperson;
    }

    public void setAppointperson(String appointperson) {
        this.appointperson = appointperson;
    }

    public String getAppointpersonname() {
        return appointpersonname;
    }

    public void setAppointpersonname(String appointpersonname) {
        this.appointpersonname = appointpersonname;
    }

    public java.sql.Timestamp getAppointdate() {
        return appointdate;
    }

    public void setAppointdate(java.sql.Timestamp appointdate) {
        this.appointdate = appointdate;
    }

    public String getEquipmentnum() {
        return equipmentnum;
    }

    public void setEquipmentnum(String equipmentnum) {
        this.equipmentnum = equipmentnum;
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

    public String getMainservicepro() {
        return mainservicepro;
    }

    public void setMainservicepro(String mainservicepro) {
        this.mainservicepro = mainservicepro;
    }

    public String getChildservicepro() {
        return childservicepro;
    }

    public void setChildservicepro(String childservicepro) {
        this.childservicepro = childservicepro;
    }

    public String getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(String projectmanager) {
        this.projectmanager = projectmanager;
    }

    public String getProjectmanagername() {
        return projectmanagername;
    }

    public void setProjectmanagername(String projectmanagername) {
        this.projectmanagername = projectmanagername;
    }

    public String getPronum() {
        return pronum;
    }

    public void setPronum(String pronum) {
        this.pronum = pronum;
    }

    public String getEdengineer() {
        return edengineer;
    }

    public void setEdengineer(String edengineer) {
        this.edengineer = edengineer;
    }

    public String getEdengineername() {
        return edengineername;
    }

    public void setEdengineername(String edengineername) {
        this.edengineername = edengineername;
    }

    public String getMdengineer() {
        return mdengineer;
    }

    public void setMdengineer(String mdengineer) {
        this.mdengineer = mdengineer;
    }

    public String getMdengineername() {
        return mdengineername;
    }

    public void setMdengineername(String mdengineername) {
        this.mdengineername = mdengineername;
    }

    public String getSalesengineer() {
        return salesengineer;
    }

    public void setSalesengineer(String salesengineer) {
        this.salesengineer = salesengineer;
    }

    public String getSalesengineername() {
        return salesengineername;
    }

    public void setSalesengineername(String salesengineername) {
        this.salesengineername = salesengineername;
    }

    public java.sql.Date getAppointdate2() {
        return appointdate2;
    }

    public void setAppointdate2(java.sql.Date appointdate2) {
        this.appointdate2 = appointdate2;
    }

    public String getKhcontacts() {
        return khcontacts;
    }

    public void setKhcontacts(String khcontacts) {
        this.khcontacts = khcontacts;
    }

    public String getKhphone() {
        return khphone;
    }

    public void setKhphone(String khphone) {
        this.khphone = khphone;
    }

    public String getKhemail() {
        return khemail;
    }

    public void setKhemail(String khemail) {
        this.khemail = khemail;
    }

    public String getKhcompany() {
        return khcompany;
    }

    public void setKhcompany(String khcompany) {
        this.khcompany = khcompany;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPersonid2() {
        return personid2;
    }

    public void setPersonid2(String personid2) {
        this.personid2 = personid2;
    }

}
