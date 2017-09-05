package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/9/5.
 */
@Entity
public class WpmaterialDto {

    private String itemnum;
    private String description;
    private Double itemqty;
    private Double unitcost;
    private Double linecost;
    private String location;
    private String storelocsite;
    private String issueto;
    private String requestby;
    @Id
    private Long wplaboruid;


    public WpmaterialDto() {
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getItemqty() {
        return itemqty;
    }

    public void setItemqty(Double itemqty) {
        this.itemqty = itemqty;
    }

    public Double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(Double unitcost) {
        this.unitcost = unitcost;
    }

    public Double getLinecost() {
        return linecost;
    }

    public void setLinecost(Double linecost) {
        this.linecost = linecost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStorelocsite() {
        return storelocsite;
    }

    public void setStorelocsite(String storelocsite) {
        this.storelocsite = storelocsite;
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getRequestby() {
        return requestby;
    }

    public void setRequestby(String requestby) {
        this.requestby = requestby;
    }

    public Long getWplaboruid() {
        return wplaboruid;
    }

    public void setWplaboruid(Long wplaboruid) {
        this.wplaboruid = wplaboruid;
    }
}
