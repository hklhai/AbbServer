package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.view.AbbInventory;
import com.hxqh.abb.model.view.AbbInventoryItem;
import com.hxqh.abb.model.view.AbbInventoryLocation;
import com.hxqh.abb.model.view.AbbInventorySite;

import java.util.List;

/**
 * Created by dell on 2017-05-12.
 */
public class InventoryDto {
    private List<AbbInventory> abbInventoryList;
    private List<AbbInventorySite> siteList;
    private List<AbbInventoryLocation>  locationList;
    private List<AbbInventoryItem> itemList;

    private Page page;

    private SessionInfo sessionInfo;
    private Time time;

    public InventoryDto() {
    }

    public InventoryDto(List<AbbInventory> abbInventoryList, Page page) {
        this.abbInventoryList = abbInventoryList;
        this.page = page;
    }

    public InventoryDto(List<AbbInventory> abbInventoryList, List<AbbInventorySite> siteList, List<AbbInventoryLocation> locationList, List<AbbInventoryItem> itemList, Page page) {
        this.abbInventoryList = abbInventoryList;
        this.siteList = siteList;
        this.locationList = locationList;
        this.itemList = itemList;
        this.page = page;
    }

    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<AbbInventory> getAbbInventoryList() {
        return abbInventoryList;
    }

    public void setAbbInventoryList(List<AbbInventory> abbInventoryList) {
        this.abbInventoryList = abbInventoryList;
    }

    public List<AbbInventorySite> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<AbbInventorySite> siteList) {
        this.siteList = siteList;
    }

    public List<AbbInventoryLocation> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<AbbInventoryLocation> locationList) {
        this.locationList = locationList;
    }

    public List<AbbInventoryItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<AbbInventoryItem> itemList) {
        this.itemList = itemList;
    }
}
