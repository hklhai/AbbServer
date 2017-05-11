package com.hxqh.abb.controller;

import com.hxqh.abb.model.assist.UdtoolDto;
import com.hxqh.abb.service.ToolService;
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


}
