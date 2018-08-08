package com.hxqh.abb.model.dto;

/**
 * Created by Ocean lin on 2017/12/7.
 */
public class AppDto {

    private String appid;

    public AppDto(String appid) {
        this.appid = appid;
    }

    public AppDto() {
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
