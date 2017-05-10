package com.hxqh.abb.model.assist;

import javax.persistence.Column;


public class AssetDto {


    @Column(name = "\"STATE\"")
    private String state;//	STATE	报警状态

    private String description;//	DESCRIPTION	设备名称

    @Column(name = "\"LOCATION\"")
    private String location;//	LOCATION	位置信息

    public AssetDto() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AssetDto{");
        sb.append("state='").append(state).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }
}