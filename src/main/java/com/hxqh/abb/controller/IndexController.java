package com.hxqh.abb.controller;

import com.hxqh.abb.model.Location;
import com.hxqh.abb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAuthorDetail() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Location> locationList = systemService.getLocationList();
        result.put("locationList", locationList);
        return "/success";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String systemMessage() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Location> locationList = systemService.getLocationList();
        result.put("locationList", locationList);
        return "/success";
    }


}
