package com.hxqh.abb.controller;

import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.dto.action.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.view.AbbInventory;
import com.hxqh.abb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


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
     * 地图页面数据接口  获取数据与分类列表信息
     * 2017-5-10
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/inventoryData", method = RequestMethod.POST)
    public InventoryDto inventoryListData(Page page) {
        InventoryDto inventoryData = null;
        try {
            inventoryData = locationService.inventoryListData(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryData;
    }


    /**
     * 地图页面数据接口  获取数据包含分页
     * 2017-5-15
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public List<AbbInventory> data(InventorySearchDto inventorySearchDto, Page page) {
        List<AbbInventory> inventoryList = null;
        try {
            inventoryList = locationService.getInventoryData(inventorySearchDto,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

}
