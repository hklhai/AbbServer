package com.hxqh.abb.model.dto;

import com.hxqh.abb.model.Asset;
import com.hxqh.abb.model.Wfassignment;
import com.hxqh.abb.model.assist.AssetDto;
import com.hxqh.abb.model.assist.WfassignmentDto;
import com.hxqh.abb.model.assist.WorkorderDto;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/5/9.
 */
public class IndexDto {
    private List<WorkorderDto> calendarList;
    private List<AssetDto> assetList;
    private List<WfassignmentDto> systemList;


    public IndexDto() {
    }

    public IndexDto(List<WorkorderDto> calendarList, List<AssetDto> assetList, List<WfassignmentDto> systemList) {
        this.calendarList = calendarList;
        this.assetList = assetList;
        this.systemList = systemList;
    }

    public List<WorkorderDto> getCalendarList() {
        return calendarList;
    }

    public void setCalendarList(List<WorkorderDto> calendarList) {
        this.calendarList = calendarList;
    }

    public List<AssetDto> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<AssetDto> assetList) {
        this.assetList = assetList;
    }

    public List<WfassignmentDto> getSystemList() {
        return systemList;
    }

    public void setSystemList(List<WfassignmentDto> systemList) {
        this.systemList = systemList;
    }
}
