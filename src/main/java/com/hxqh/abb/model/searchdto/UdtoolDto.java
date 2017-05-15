package com.hxqh.abb.model.searchdto;

import javax.persistence.Column;


public class UdtoolDto {

    private String toolnum; //    TOOLNUM	工具编号
    private String description;//    DESCRIPTION	描述

    @Column(name = "\"STATUS\"")
    private String status;//    STATUS	状态
    private String displayname; //保管人
    private String locationsite; //保管人


    public UdtoolDto() {
    }

    public UdtoolDto(String toolnum, String description, String status, String displayname, String locationsite) {
        this.toolnum = toolnum;
        this.description = description;
        this.status = status;
        this.displayname = displayname;
        this.locationsite = locationsite;
    }

    public String getToolnum() {
        return toolnum;
    }

    public void setToolnum(String toolnum) {
        this.toolnum = toolnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getLocationsite() {
        return locationsite;
    }

    public void setLocationsite(String locationsite) {
        this.locationsite = locationsite;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UdtoolDto{");
        sb.append("toolnum='").append(toolnum).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", displayname='").append(displayname).append('\'');
        sb.append(", locationsite='").append(locationsite).append('\'');
        sb.append('}');
        return sb.toString();
    }
}