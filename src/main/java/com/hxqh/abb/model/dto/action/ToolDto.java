package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.view.AbbInventorySite;
import com.hxqh.abb.model.view.AbbUdtool;

import java.util.List;

/**
 * Created by dell on 2017-05-15.
 */
public class ToolDto {
    List<AbbUdtool> udtoolList;
    List<AbbInventorySite> siteList;
    List<String> statusList;

    public ToolDto() {
    }

    public ToolDto(List<AbbUdtool> udtoolList, List<AbbInventorySite> siteList, List<String> statusList) {
        this.udtoolList = udtoolList;
        this.siteList = siteList;
        this.statusList = statusList;
    }

    public List<AbbUdtool> getUdtoolList() {
        return udtoolList;
    }

    public void setUdtoolList(List<AbbUdtool> udtoolList) {
        this.udtoolList = udtoolList;
    }

    public List<AbbInventorySite> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<AbbInventorySite> siteList) {
        this.siteList = siteList;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }
}
