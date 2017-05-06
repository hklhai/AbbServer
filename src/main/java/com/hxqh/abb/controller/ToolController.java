package com.hxqh.abb.controller;

import com.hxqh.abb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/tool")
public class ToolController {
    @Autowired
    private LocationService locationService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String getAuthorDetail() {
//        Map<String, Object> result = new HashMap<String, Object>();
//        List<Location> locationList = systemService.getLocationList();
//        result.put("locationList", locationList);
//        return "/success";
//    }



}
