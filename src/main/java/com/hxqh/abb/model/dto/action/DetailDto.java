package com.hxqh.abb.model.dto.action;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/8/29.
 */
public class DetailDto {

    private Object object;
    private List aList;
    private List nAuditList;
    private Map<String, List> map;

    public DetailDto() {
    }

    public DetailDto(Object object, List aList, List nAuditList, Map<String, List> map) {
        this.object = object;
        this.aList = aList;
        this.nAuditList = nAuditList;
        this.map = map;
    }

    public List getaList() {
        return aList;
    }

    public void setaList(List aList) {
        this.aList = aList;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List getnAuditList() {
        return nAuditList;
    }

    public void setnAuditList(List nAuditList) {
        this.nAuditList = nAuditList;
    }

    public Map<String, List> getMap() {
        return map;
    }

    public void setMap(Map<String, List> map) {
        this.map = map;
    }
}
