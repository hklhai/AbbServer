package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.view.AbbInventorySite;
import com.hxqh.abb.model.view.AbbUdtool;

import java.util.List;

/**
 * Created by dell on 2017-05-15.
 */
public class ToolDto {
    private List<AbbUdtool> udtoolList;
    private List<AbbInventorySite> siteList;
    private List<String> statusList;
    private Page page;


    public ToolDto() {
    }

    public ToolDto(List<AbbUdtool> udtoolList, List<AbbInventorySite> siteList, List<String> statusList, Page page) {
        this.udtoolList = udtoolList;
        this.siteList = siteList;
        this.statusList = statusList;
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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
