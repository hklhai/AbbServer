package com.hxqh.abb.model.paperless;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fuyg on 2017-09-26.
 */
@Entity
@Table(name="UDPROJECT")
@DynamicUpdate
public class Udproject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="UDPROJECT_UDPROJECTID_GENERATOR", allocationSize = 1 , sequenceName="UDPROJECTIDSEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDPROJECT_UDPROJECTID_GENERATOR")
    private Long udprojectid;
    private String description;
    private String orgid;
    private String siteid;
    private Long hasld;
    private String status;
    private java.sql.Timestamp statusdate;
    private String createdby;
    private java.sql.Timestamp createddate;
    private String changeby;
    private java.sql.Timestamp changedate;
    private String appointperson;
    private java.sql.Timestamp appointdate;
    private String equipmentnum;
    private Double quantity;
    private String servicedep;
    private Double workinghours;
    private String mainservicepro;
    private String childservicepro;
    private String projectmanager;
    private String pronum;
    private String edengineer;
    private String mdengineer;
    private String salesengineer;
    private java.util.Date appointdate2;
    @Column(name="kh_contacts")
    private String khcontacts;
    @Column(name="kh_phone")
    private String khphone;
    @Column(name="kh_email")
    private String khemail;
    @Column(name="kh_company")
    private String khcompany;
    private Long rowstamp;
    private String provinces;
    private String area1;
    private String personid;
    private String personid2;

    @Transient
    private String appointpersonname;
    @Transient
    private String statusdesc;
    @Transient
    private String createdbyname;
    @Transient
    private String changebyname;
    @Transient
    private String projectmanagername;
    @Transient
    private String edengineername;
    @Transient
    private String mdengineername;
    @Transient
    private String salesengineername;
    @Transient
    private String orgiddesc;
    @Transient
    private String siteiddesc;
    @Transient
    private String deletes;
    @Transient
    private String maintab;
    @Transient
    private List<Udprojectline> udprojectlineList;

    public Udproject() {
    }

    public String getOrgiddesc() {
        return orgiddesc;
    }

    public void setOrgiddesc(String orgiddesc) {
        this.orgiddesc = orgiddesc;
    }

    public String getSiteiddesc() {
        return siteiddesc;
    }

    public void setSiteiddesc(String siteiddesc) {
        this.siteiddesc = siteiddesc;
    }

    public String getAppointpersonname() {
        return appointpersonname;
    }

    public void setAppointpersonname(String appointpersonname) {
        this.appointpersonname = appointpersonname;
    }

    public String getStatusdesc() {
        return statusdesc;
    }

    public void setStatusdesc(String statusdesc) {
        this.statusdesc = statusdesc;
    }

    public String getCreatedbyname() {
        return createdbyname;
    }

    public void setCreatedbyname(String createdbyname) {
        this.createdbyname = createdbyname;
    }

    public String getChangebyname() {
        return changebyname;
    }

    public void setChangebyname(String changebyname) {
        this.changebyname = changebyname;
    }

    public String getProjectmanagername() {
        return projectmanagername;
    }

    public void setProjectmanagername(String projectmanagername) {
        this.projectmanagername = projectmanagername;
    }

    public String getEdengineername() {
        return edengineername;
    }

    public void setEdengineername(String edengineername) {
        this.edengineername = edengineername;
    }

    public String getMdengineername() {
        return mdengineername;
    }

    public void setMdengineername(String mdengineername) {
        this.mdengineername = mdengineername;
    }

    public String getSalesengineername() {
        return salesengineername;
    }

    public void setSalesengineername(String salesengineername) {
        this.salesengineername = salesengineername;
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

    public List<Udprojectline> getUdprojectlineList() {
        return udprojectlineList;
    }

    public void setUdprojectlineList(List<Udprojectline> udprojectlineList) {
        this.udprojectlineList = udprojectlineList;
    }

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

    public java.sql.Timestamp getAppointdate() {
        return appointdate;
    }

    public void setAppointdate(java.sql.Timestamp appointdate) {
        this.appointdate = appointdate;
    }

    public void setAppointdate(String appointdate) {
        if(appointdate!=null&&!appointdate.equals("")){
            try {
                this.appointdate = Timestamp.valueOf(appointdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    public String getMdengineer() {
        return mdengineer;
    }

    public void setMdengineer(String mdengineer) {
        this.mdengineer = mdengineer;
    }

    public String getSalesengineer() {
        return salesengineer;
    }

    public void setSalesengineer(String salesengineer) {
        this.salesengineer = salesengineer;
    }

    public java.util.Date getAppointdate2() {
        return appointdate2;
    }

    public void setAppointdate2(java.util.Date appointdate2) {
        this.appointdate2 = appointdate2;
    }

    public void setAppointdate2(String appointdate2) {
        if(appointdate2!=null&&!appointdate2.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.appointdate2 = sdf.parse(appointdate2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getKhcontacts() {
        return khcontacts;
    }

    public void setKhcontacts(String kh_contacts) {
        this.khcontacts = kh_contacts;
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
