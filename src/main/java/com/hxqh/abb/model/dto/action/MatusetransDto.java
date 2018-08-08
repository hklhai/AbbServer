package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/9/8.
 */
@Entity
public class MatusetransDto {

    @Id
    private Long matusetransid;
    private String itemnum;
    private String description;
    private String storeloc;
    private String siteid;
    //    POSITIVEQUANTITY;
    //    UNITCOST;
    private double linecost;
    private String binnum;
    private String issueto;
    private String location;
    private String locationsdescription;
    private String assetnum;
    private String assetdescription;

    public MatusetransDto() {
    }

    public Long getMatusetransid() {
        return matusetransid;
    }

    public void setMatusetransid(Long matusetransid) {
        this.matusetransid = matusetransid;
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

    public String getStoreloc() {
        return storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public double getLinecost() {
        return linecost;
    }

    public void setLinecost(double linecost) {
        this.linecost = linecost;
    }

    public String getBinnum() {
        return binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationsdescription() {
        return locationsdescription;
    }

    public void setLocationsdescription(String locationsdescription) {
        this.locationsdescription = locationsdescription;
    }

    public String getAssetnum() {
        return assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public String getAssetdescription() {
        return assetdescription;
    }

    public void setAssetdescription(String assetdescription) {
        this.assetdescription = assetdescription;
    }
}
