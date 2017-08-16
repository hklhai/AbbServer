package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the UDVEHICLE database table.
 */
@Entity
@Table(name = "Udvehicle")
public class Udvehicle implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "UDVEHICLE_UDVEHICLEID_GENERATOR",allocationSize = 1, sequenceName = "UDVEHICLEIDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UDVEHICLE_UDVEHICLEID_GENERATOR")
    private Long udvehicleid;

    private String changeby;

    private Date changedate;

    private String color;

    private String createdby;

    private Date createddate;

    private String department;

    private String description;

    private BigDecimal displacement;

    private String factory;

    @Temporal(TemporalType.DATE)
    private Date factorydate;

    private String fueltype;

    private Integer hasld;

    private String license;

    private String model;

    private String orgid;

    @Temporal(TemporalType.DATE)
    private Date registerdate;

    private Long rowstamp;

    private Integer seats;

    private String siteid;

    @Column(name = "\"STATUS\"")
    private String status;

    private Date statusdate;

    private String vcnum;

    private BigDecimal weight;

    public Udvehicle() {
    }

    public Long getUdvehicleid() {
        return this.udvehicleid;
    }

    public void setUdvehicleid(Long udvehicleid) {
        this.udvehicleid = udvehicleid;
    }

    public String getChangeby() {
        return this.changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    public Date getChangedate() {
        return this.changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return this.createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(BigDecimal displacement) {
        this.displacement = displacement;
    }

    public String getFactory() {
        return this.factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Date getFactorydate() {
        return this.factorydate;
    }

    public void setFactorydate(Date factorydate) {
        this.factorydate = factorydate;
    }

    public String getFueltype() {
        return this.fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public Integer getHasld() {
        return this.hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Date getRegisterdate() {
        return this.registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public Long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public Integer getSeats() {
        return this.seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public String getVcnum() {
        return this.vcnum;
    }

    public void setVcnum(String vcnum) {
        this.vcnum = vcnum;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

}