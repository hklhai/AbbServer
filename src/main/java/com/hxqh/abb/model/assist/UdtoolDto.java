package com.hxqh.abb.model.assist;

import javax.persistence.Column;


public class UdtoolDto {

    private String toolnum; //    TOOLNUM	工具编号
    private String description;//    DESCRIPTION	描述

    @Column(name = "\"STATUS\"")
    private String status;//    STATUS	状态
//    PERSON.DISPLAYNAME	保管人	KEEPER	PERSON	personid=:KEEPER
//    PERSON.LOCATIONSITE	保管人	KEEPER	PERSON	personid=:KEEPER

    private String keeper;

    public UdtoolDto() {
    }

    public UdtoolDto(String toolnum, String description, String status, String keeper) {
        this.toolnum = toolnum;
        this.description = description;
        this.status = status;
        this.keeper = keeper;
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

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UdtoolDto{");
        sb.append("toolnum='").append(toolnum).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", keeper='").append(keeper).append('\'');
        sb.append('}');
        return sb.toString();
    }
}