package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.FastJsonTools;
import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.view.AbbAsset;
import com.hxqh.abb.model.view.AbbLocation;
import com.hxqh.abb.service.LocationService;
import com.hxqh.abb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
     *
     * @return
     */
    @RequestMapping(value = "/asset", method = RequestMethod.GET)
    public String asset() {
        return "asset/asset";
    }

    /**
     * 资产页面Location跳转
     * 2017-5-12
     *
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
//    @ResponseBody
//    @RequestMapping(value = "/assetData", method = RequestMethod.POST)
//    public AssetDto assetData(@RequestParam("location") String location) {
//        AssetDto assetData = systemService.getAssetData(location);
//        AbbLocation abbLocation = locationService.getParentLocation(location);
//        assetData.setAbbLocation(abbLocation);
//        return assetData;
//    }

    //TODO 暂时处理Null
    @RequestMapping(value = "/assetData", method = RequestMethod.POST)
    public void assetData(@RequestParam("location") String location, HttpServletResponse response) {
        AssetDto assetData = systemService.getAssetData(location);
        AbbLocation abbLocation = locationService.getParentLocation(location);
        assetData.setAbbLocation(abbLocation);
        FastJsonTools.writeJsonNullStringAsEmpty(assetData, response);
    }


    /**
     * 资设详细详细获取
     * 2017-5-27
     *
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "/detail", method = RequestMethod.POST)
//    public AbbAsset detail(@RequestParam("assetuid") String assetuid) {
//        AbbAsset abbAsset = systemService.getAssetById(Long.valueOf(assetuid));
//        return abbAsset;
//    }
    //TODO 暂时处理Null
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public void detail(@RequestParam("assetuid") String assetuid, HttpServletResponse response) {
        AbbAsset abbAsset = systemService.getAssetById(Long.valueOf(assetuid));
        FastJsonTools.writeJsonNullStringAsEmpty(abbAsset, response);
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
        AbbAsset abbAsset = systemService.getAssetById(Long.valueOf(assetuid));
        return abbAsset;
    }

    /**
     * 通过childname获取子设备集合
     * 暂时未考虑分页
     * 22017-6-3 18:57:56
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/assetChild", method = RequestMethod.POST)
    public List<AbbAsset> assetChild(@RequestParam("childname") String childname) {
        List<AbbAsset> abbAssetList = systemService.getAssetByChild(childname);
        return abbAssetList;
    }


}
