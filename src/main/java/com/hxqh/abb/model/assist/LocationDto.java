package com.hxqh.abb.model.assist;

import javax.persistence.Column;


public class LocationDto {


    private String longitude;//    LONGITUDE	经度
    private String dimension;//    DIMENSION	纬度
    @Column(name = "\"LOCATION\"")
    private String location;//    LOCATION	位置编码
    private String description;//    DESCRIPTION	位置描述
    @Column(name = "\"STATUS\"")//    STATUS	状态
    private String status;
    //TODO 字段不存在
    //    VOLTAGE	电压等级


    //    CLASSSTRUCTURE.HIERARCHYPATH	位置类型	CLASSSTRUCTURE	CLASSSTRUCTURE	classstructureid = :classstructureid
    //    SERVICEADDRESS.DESCRIPTION	地址	SERVICEADDRESS	SERVICEADDRESS	addresscode = :saddresscode and orgid = :orgid

    //    设备数量				通过SQL查询该位置下的设备数量，如：select (select count(assetnum) from asset where location=locations.location) from locations where location ='GDGS2'
    //    健康指标				该位置所有设备评分的平均值
    //    报警数量				通过SQL查询该位置下的报警设备数量，如：select (select count(assetnum) from asset where location=locations.location and state='报警') from locations where location ='GDGS2'


    public LocationDto() {
    }

    public LocationDto(String longitude, String dimension, String location, String description, String status) {
        this.longitude = longitude;
        this.dimension = dimension;
        this.location = location;
        this.description = description;
        this.status = status;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocationDto{");
        sb.append("longitude='").append(longitude).append('\'');
        sb.append(", dimension='").append(dimension).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}