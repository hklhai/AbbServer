package com.hxqh.abb.controller;

import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.view.AbbUdtool;
import com.hxqh.abb.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/tool")
public class ToolController {
    @Autowired
    private ToolService toolService;

    /**
     * 工具页面跳转
     * 2017-5-10
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "tool/tool";
    }


    /**
     * 工具页面数据接口
     * 2017-5-10
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    public List<AbbUdtool> listdata(UdtoolDto udtoolDto) {
        List<AbbUdtool> listData = null;
        try {
            listData= toolService.getListData(udtoolDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

}
