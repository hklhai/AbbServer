package com.hxqh.abb.model.assist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class InventoryDto {

    private String siteid;//	SITEID	服务站点

    @Column(name = "\"LOCATION\"")//	LOCATION	库房
    private String location;

    private String itemnum;//	ITEMNUM	物资编码

//	ITEM.DESCRIPTION	描述	ITEM	ITEM	itemnum = :itemnum and itemsetid = :itemsetid
//	ITEM.UDSAPNUM	SAP编码	ITEM	ITEM	itemnum = :itemnum and itemsetid = :itemsetid
//	INVBALANCES.CURBAL	当前余量	INVBALANCES	INVBALANCES	itemnum = :itemnum and location = :location and siteid = :siteid and itemsetid = :itemsetid


    public InventoryDto() {
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InventoryDto{");
        sb.append("siteid='").append(siteid).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", itemnum='").append(itemnum).append('\'');
        sb.append('}');
        return sb.toString();
    }
}