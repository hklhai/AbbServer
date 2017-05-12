package com.hxqh.abb.model.dto;

import com.hxqh.abb.model.assist.AssetDto;
import com.hxqh.abb.model.assist.WfassignmentDto;
import com.hxqh.abb.model.assist.WorkorderDto;
import com.hxqh.abb.model.view.AbbIndexAsset;
import com.hxqh.abb.model.view.AbbIndexWfassignment;
import com.hxqh.abb.model.view.AbbIndexWorkorder;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/5/9.
 */
public class IndexDto {
    private List<AbbIndexWorkorder> calendarList;
    private List<AbbIndexAsset> assetList;
    private List<AbbIndexWfassignment> systemList;


    public IndexDto() {
    }


    public IndexDto(List<AbbIndexWorkorder> calendarList, List<AbbIndexAsset> assetList, List<AbbIndexWfassignment> systemList) {
        this.calendarList = calendarList;
        this.assetList = assetList;
        this.systemList = systemList;
    }

    public List<AbbIndexWorkorder> getCalendarList() {
        return calendarList;
    }

    public void setCalendarList(List<AbbIndexWorkorder> calendarList) {
        this.calendarList = calendarList;
    }

    public List<AbbIndexAsset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<AbbIndexAsset> assetList) {
        this.assetList = assetList;
    }

    public List<AbbIndexWfassignment> getSystemList() {
        return systemList;
    }

    public void setSystemList(List<AbbIndexWfassignment> systemList) {
        this.systemList = systemList;
    }
}
