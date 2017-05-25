package com.hxqh.abb.controller;

import com.hxqh.abb.dao.AbbLocationDao;
import com.hxqh.abb.model.assist.LocationDto;
import com.hxqh.abb.model.view.AbbLocation;
import com.hxqh.abb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/5/6.
 */
@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Resource
    private AbbLocationDao abblocationDao;

    /**
     * 地图页面跳转
     * 2017-5-10
     *
     * @return
     */
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String map() {
        return "asset/asset";
    }


    /**
     * 地图页面数据接口
     * 2017-5-10
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/mapdata", method = RequestMethod.GET)
    public List<LocationDto> mapData() {
        List<LocationDto> mapData = null;
        try {
            mapData = locationService.getMapData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapData;
    }


    /**
     * location Tree 数据&页面接口
     *
     * @return
     */
    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public ModelAndView location() {
        Map<String, Object> result = new HashMap<>();
        List<AbbLocation> abbLocationList = abblocationDao.findAll();
        List<LocationDto> mapData = null;
        try {
            mapData = locationService.getMapData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.put("abbLocationList", abbLocationList);
        result.put("mapData", mapData);
        return new ModelAndView("asset/asset",result);
    }

}
