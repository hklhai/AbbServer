package com.hxqh.abb.model.paperless;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017-10-09.
 */
@Entity
@Table(name="UDCUSTOMER")
@DynamicUpdate
public class Udcustomer  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="UDCUSTOMER_UDCUSTOMERID_GENERATOR", sequenceName="UDCUSTOMERIDSEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDCUSTOMER_UDCUSTOMERID_GENERATOR")
    private Long udcustomerid;
    private String description;
    private String orgid;
    private String siteid;
    private Long hasld;
    private String customerid;
    private String unit;
    private String phone;
    private String contact;
    private String customernature;
    private String position;
    private String mobilephone;
    private String zipcode;
    private String address;
    private String fax;
    private String email;
    private String pronum;
    private Long linenum;
    private Long rowstamp;
    private String cusnum;

    @Transient
    private String isdelete;

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public Long getUdcustomerid() {
        return udcustomerid;
    }

    public void setUdcustomerid(Long udcustomerid) {
        this.udcustomerid = udcustomerid;
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

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCustomernature() {
        return customernature;
    }

    public void setCustomernature(String customernature) {
        this.customernature = customernature;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getCusnum() {
        return cusnum;
    }

    public void setCusnum(String cusnum) {
        this.cusnum = cusnum;
    }
}
