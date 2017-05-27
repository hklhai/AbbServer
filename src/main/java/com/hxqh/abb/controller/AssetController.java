package com.hxqh.abb.controller;

import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.view.AbbAsset;
import com.hxqh.abb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lh on 2017/5/11.
 */

@Controller
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private SystemService systemService;

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



    /**
     * 资设备与位置数据接口
     * 2017-5-18
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/assetData", method = RequestMethod.POST)
    public AssetDto assetData(@RequestParam("location") String location) {
        AssetDto assetData = systemService.getAssetData(location);
        return assetData;
    }

    /**
     * 资设详细详细获取
     * 2017-5-27
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public AbbAsset detail(@RequestParam("assetuid") String assetuid) {
        AbbAsset abbAsset= systemService.getAssetById(Long.valueOf(assetuid));
        return abbAsset;
    }


}
