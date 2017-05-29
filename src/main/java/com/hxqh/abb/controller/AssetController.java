package com.hxqh.abb.controller;

import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.view.AbbAsset;
import com.hxqh.abb.model.view.AbbLocation;
import com.hxqh.abb.service.LocationService;
import com.hxqh.abb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lh on 2017/5/11.
 */

@Controller
@RequestMapping("/asset")
@SessionAttributes(value = "sessionInfo")
public class AssetController {

    @Autowired
    private SystemService systemService;
    @Resource
    private LocationService locationService;
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
        AbbLocation abbLocation = locationService.getParentLocation(location);
        assetData.setAbbLocation(abbLocation);
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
    /**
     * 资设详细详细获取
     * 2017-5-27
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public AbbAsset details(@RequestParam("assetuid") String assetuid) {
        AbbAsset abbAsset= systemService.getAssetById(Long.valueOf(assetuid));
        return abbAsset;
    }



}
