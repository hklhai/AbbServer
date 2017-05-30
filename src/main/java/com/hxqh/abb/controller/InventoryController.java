package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.dto.action.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.view.AbbInventory;
import com.hxqh.abb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by lh on 2017/5/11.
 */
@Controller
@RequestMapping("/inventory")
@SessionAttributes(value = "sessionInfo")
public class InventoryController {

    @Autowired
    private LocationService locationService;

    /**
     * 库存管理页面跳转
     * 2017-5-11
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "inventory/inventory";
    }

    /**
     * 地图页面数据接口  获取数据与分类列表信息
     * 2017-5-10
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/inventoryData", method = RequestMethod.POST)
    public InventoryDto inventoryListData(Page page,@ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        InventoryDto inventoryData = null;

        try {
            inventoryData = locationService.inventoryListData(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        inventoryData.setSessionInfo(sessionInfo);
        inventoryData.setTime(new Time(TimeUtil.getTime()));
        return inventoryData;
    }


    /**
     * 库存页面数据接口  获取数据包含分页
     * 2017-5-15
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public InventoryDto data(InventorySearchDto inventorySearchDto, Page page) {
        InventoryDto inventoryData = locationService.getInventoryData(inventorySearchDto, page);
        return inventoryData;
    }

}
