package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
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
    private SessionInfo sessionInfo;
    private List<Calendar> calendar;
    private Time time;


    public IndexDto() {
    }

    public IndexDto(List<AbbIndexWorkorder> calendarList, List<AbbIndexAsset> assetList, List<AbbIndexWfassignment> systemList, SessionInfo sessionInfo, List<Calendar> calendar) {
        this.calendarList = calendarList;
        this.assetList = assetList;
        this.systemList = systemList;
        this.sessionInfo = sessionInfo;
        this.calendar = calendar;
    }


    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<Calendar> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<Calendar> calendar) {
        this.calendar = calendar;
    }

    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
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
