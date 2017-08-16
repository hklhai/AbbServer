package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.model.UdtoolApply;
import com.hxqh.abb.model.UdtoolChk;
import com.hxqh.abb.model.UdtoolLend;
import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.view.AbbUdtool;
import com.hxqh.abb.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 工具借还列表跳转
     * 2017-8-14
     * update by wkl
     * @return
     */
    @RequestMapping(value = "/lendlist", method = RequestMethod.GET)
    public String lendlist() {
        return "tool/lendlist";
    }

    /**
     * 工具借还页面数据项接口
     * 2017-8-14
     *update by wkl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lendlistdata", method = RequestMethod.GET)
    public List<UdtoolLend> lendlistdata() {
        return toolService.getUdtoolLendList();
    }


    /**
     * 工具借还页面跳转
     * 2017-8-14
     *update by wkl
     * @return
     */
    @RequestMapping(value = "/lenddetail", method = RequestMethod.GET)
    public String lenddetail() {
        return "tool/lenddetail";
    }


    /**
     * 工具借还页面数据接口
     * 2017-8-14
     *update by wkl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lenddetaildata", method = RequestMethod.GET)
    public UdtoolLend lenddetaildata(@RequestParam("udtoollendid") Long udtoollendid) {
        UdtoolLend udtoolLendList = toolService.getUdtoolLendId(udtoollendid);
        return udtoolLendList;
    }

    /**
     * 工具修丢废列表跳转
     * 2017-8-14
     *update by wkl
     * @return
     */
    @RequestMapping(value = "/applylist", method = RequestMethod.GET)
    public String applylist() {
        return "tool/applylist";
    }

    /**
     * 工修丢废列表数据项接口
     * 2017-8-14
     *update by wkl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/applylistdata", method = RequestMethod.GET)
    public List<UdtoolApply> applylistdata() {
        return toolService.getUdtoolApplyList();
    }


    /**
     * 工具修丢废页面跳转
     * 2017-8-14
     *update by wkl
     * @return
     */
    @RequestMapping(value = "/applydetail", method = RequestMethod.GET)
    public String applydetail() {
        return "tool/applydetail";
    }

    /**
     * 工具修丢废页面数据接口
     * 2017-8-14
     *update by wkl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/applydetaildata", method = RequestMethod.GET)
    public UdtoolApply applydetaildata(@RequestParam("udtoolapplyid") Long udtoolapplyid) {
        UdtoolApply udtoolApply = toolService.getUdtoolApplyId(Long.valueOf(udtoolapplyid));
        return udtoolApply;
    }

    /**
     * 工具台账列表数据接口
     * 2017-8-15
     *update by wkl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toollistdata", method = RequestMethod.GET)
    public List<AbbUdtool> toollistdata() {
        return toolService.getUdtoolList();
    }

    /**
     * 工具台账页面数据接口
     * 2017-8-15
     *update by wkl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/tooldetaildata", method = RequestMethod.GET)
    public AbbUdtool tooldetaildata(@RequestParam("udtoolid") Long udtoolid) {
        AbbUdtool abbUdtool = toolService.getAbbUdtoolId(Long.valueOf(udtoolid));
        return abbUdtool;
    }

    /**
     * 工具校准单列表数据接口
     * 2017-8-15
     *update by wkl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toolchklistdata", method = RequestMethod.GET)
    public List<UdtoolChk> toolchklistdata() {
        return toolService.getUdtoolChkList();
    }

    /**
     * 工具校准单页面数据接口
     * 2017-8-15
     *update by wkl
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/toolchkdetaildata", method = RequestMethod.GET)
    public UdtoolChk toolchkdetaildata(@RequestParam("udtoolchkid") Long udtoolchkid) {
        UdtoolChk udtoolChk =toolService.getUdtoolChkId(Long.valueOf(udtoolchkid));
        return udtoolChk;
    }
}
