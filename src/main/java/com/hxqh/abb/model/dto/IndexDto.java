package com.hxqh.abb.model.dto;

import com.hxqh.abb.model.Asset;
import com.hxqh.abb.model.Wfassignment;
import com.hxqh.abb.model.Workorder;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/5/9.
 */
public class IndexDto {
    private List<Workorder> calendarList;
    private List<Asset> assetList;
    private List<Workorder> workTaskList;
    private List<Wfassignment> systemList;


    public IndexDto() {
    }

    public IndexDto(List<Workorder> calendarList, List<Asset> assetList, List<Workorder> workTaskList, List<Wfassignment> systemList) {
        this.calendarList = calendarList;
        this.assetList = assetList;
        this.workTaskList = workTaskList;
        this.systemList = systemList;
    }

    public List<Workorder> getCalendarList() {
        return calendarList;
    }

    public void setCalendarList(List<Workorder> calendarList) {
        this.calendarList = calendarList;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public List<Workorder> getWorkTaskList() {
        return workTaskList;
    }

    public void setWorkTaskList(List<Workorder> workTaskList) {
        this.workTaskList = workTaskList;
    }

    public List<Wfassignment> getSystemList() {
        return systemList;
    }

    public void setSystemList(List<Wfassignment> systemList) {
        this.systemList = systemList;
    }
}
