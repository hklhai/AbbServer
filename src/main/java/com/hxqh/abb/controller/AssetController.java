package com.hxqh.abb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lh on 2017/5/11.
 */

@Controller
@RequestMapping("/asset")
public class AssetController {

    /**
     * 资产页面跳转
     * 2017-5-12
     * @return
     */
    @RequestMapping(value = "/asset", method = RequestMethod.GET)
    public String asset() {
        return "asset/asset";
    }

    /**
     * 资产页面Location跳转
     * 2017-5-12
     * @return
     */
    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public String location() {
        return "asset/location";
    }



}
