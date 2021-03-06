package com.hxqh.abb.controller;

import com.hxqh.abb.dao.AbbMapDao;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.view.AbbLocation;
import com.hxqh.abb.model.view.AbbMap;
import com.hxqh.abb.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
@SessionAttributes(value = "sessionInfo")
public class LocationController {

    @Resource
    private AbbMapDao abbMapDao;
    @Resource
    private LocationService locationService;

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
     * 地图页面 查询子节点数据接口
     * 2017-5-27
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/child", method = RequestMethod.POST)
    public List<AbbLocation> child(@RequestParam("location") String location) {
        List<AbbLocation> childLocation = locationService.getChildLocation(location);
        return childLocation;
    }


    /**
     * location Tree 数据&页面接口
     *
     * @return
     */
    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public ModelAndView location(@ModelAttribute("sessionInfo") SessionInfo sessionInfo, @RequestParam("locationId") String locationId) {
        Map<String, Object> result = new HashMap<>();
        List<AbbMap> mapData = abbMapDao.findAll();
        List<AbbLocation> abbLocationList = locationService.getRootList(sessionInfo);
        //处理location
        for (AbbLocation location : abbLocationList) {
            location.setDescription(location.getDescription().substring(0, 2));
        }
        for (AbbMap abbMap : mapData) {
            if (abbMap.getParentdesc() != null)
                abbMap.setParentdesc(abbMap.getParentdesc().substring(0, 2));
        }

        result.put("abbLocationList", abbLocationList);
        result.put("mapData", mapData);
        result.put("sessionInfo", sessionInfo);
        result.put("locationId", locationId);
        return new ModelAndView("asset/asset", result);
    }


    /**
     * 二期增加，配合二期迁移
     * rootLocationList 返回顶级Location信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/rootLocationList", method = RequestMethod.GET)
    public List<AbbLocation> rootLocationList(@ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        List<AbbLocation> abbLocationList = locationService.getRootList(sessionInfo);
        //处理location
        for (AbbLocation location : abbLocationList) {
            location.setDescription(location.getDescription().substring(0, 2));
        }
        return abbLocationList;
    }

}
