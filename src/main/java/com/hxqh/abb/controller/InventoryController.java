package com.hxqh.abb.controller;

import com.hxqh.abb.model.dto.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by lh on 2017/5/11.
 */
@Controller
@RequestMapping("/inventory")
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
     * 地图页面数据接口
     * 2017-5-10
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/inventoryData", method = RequestMethod.GET)
    public InventoryDto inventoryData(InventorySearchDto inventorySearchDto) {
        InventoryDto inventoryData = null;
        try {
            inventoryData = locationService.getInventoryData(inventorySearchDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryData;
    }


}
