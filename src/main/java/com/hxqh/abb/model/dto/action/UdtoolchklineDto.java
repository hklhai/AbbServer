package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.version2.Udtoolchkline;

import java.util.List;

/**
 * Created by Ocean lin on 2017/9/21.
 */
public class UdtoolchklineDto {

    public UdtoolchklineDto() {
    }

    private List<Udtoolchkline> udtoolchklineList;

    public List<Udtoolchkline> getUdtoolchklineList() {
        return udtoolchklineList;
    }

    public void setUdtoolchklineList(List<Udtoolchkline> udtoolchklineList) {
        this.udtoolchklineList = udtoolchklineList;
    }
}
