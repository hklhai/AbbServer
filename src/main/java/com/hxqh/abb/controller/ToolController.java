package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/tool")
@SessionAttributes(value = "sessionInfo")
public class ToolController {
    @Autowired
    private ToolService toolService;


    /**
     * 工具页面跳转
     * 2017-5-10
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "tool/tool";
    }


    /**
     * 工具页面数据与类别项接口
     * 2017-5-10
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listdata", method = RequestMethod.POST)
    public ToolDto listdata(Page page, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        ToolDto listData = null;
        try {
            listData = toolService.getListData(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listData.setSessionInfo(sessionInfo);
        listData.setTime(new Time(TimeUtil.getTime()));
        return listData;
    }

    /**
     * 工具页面数据与类别项接口
     * 2017-5-15
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public ToolDto data(UdtoolDto udtoolDto, Page page) {
        ToolDto listData = null;
        try {
            listData = toolService.getToolData(udtoolDto, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
}
