package com.hxqh.abb.model.dto.action;

import java.util.List;

/**
 * Created by Ocean lin on 2017/8/29.
 */
public class DetailDto {

    private Object object;
    private List aList;

    public DetailDto() {
    }

    public DetailDto(Object object, List aList) {
        this.object = object;
        this.aList = aList;
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
}
