package com.hxqh.abb.controller;

import com.hxqh.abb.model.assist.LocationDto;
import com.hxqh.abb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    /**
     * 地图页面跳转
     * 2017-5-10
     * @return
     */
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String map() {
        return "stock/stock";
    }


    /**
     * 地图页面数据接口
     * 2017-5-10
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/mapdata", method = RequestMethod.GET)
    public List<LocationDto> mapData() {
        List<LocationDto> mapData = null;
        try {
            mapData= locationService.getMapData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapData;
    }

}
