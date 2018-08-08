package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Udtool;
import com.hxqh.abb.model.UdtoolApply;
import com.hxqh.abb.model.UdtoolChk;
import com.hxqh.abb.model.UdtoolLend;
import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.Message;
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
    @Autowired
    private UdtoolDao udtoolDao;
    @Autowired
    private UdtoolLendDao udtoolLendDao;
    @Autowired
    private UdtoolApplyDao udtoolApplyDao;
    @Autowired
    private UdtoolChkDao udtoolChkDao;
    @Autowired
    private UdtoolchklineDao udtoolchklineDao;

    /*****************************************一期*****************************************/


    /**
     * 工具页面跳转
     * 2017-5-10
     *
     * @return
     */
    @Deprecated
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
    @Deprecated
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
    @Deprecated
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

    /*****************************************一期*****************************************/


    /**
     * addToolAccount 业务接口
     * 工具台账 新建保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addToolAccount", method = RequestMethod.POST)
    public Message addToolAccount(@RequestBody Udtool udtool, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = toolService.addToolAccount(udtool, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editToolAccount 业务接口
     * 工具台账 编辑保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editToolAccount", method = RequestMethod.POST)
    public Message editToolAccount(@RequestBody Udtool udtool, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            toolService.editToolAccount(udtool, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addToolLend 业务接口
     * 工具借还 新建接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addToolLend", method = RequestMethod.POST)
    public Message addToolLend(@RequestBody UdtoolLend udtoolLend, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = toolService.addToolLend(udtoolLend, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editToolLend 业务接口
     * 工具借还 编辑保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editToolLend", method = RequestMethod.POST)
    public Message editToolLend(@RequestBody UdtoolLend udtoolLend, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            toolService.editToolLend(udtoolLend, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addToolApply 业务接口
     * 工具修丢废 新建保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addToolApply", method = RequestMethod.POST)
    public Message addToolApply(@RequestBody UdtoolApply udtoolApply, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = toolService.addToolApply(udtoolApply, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editToolApply 业务接口
     * 工具修丢废 编辑保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editToolApply", method = RequestMethod.POST)
    public Message editToolApply(@RequestBody UdtoolApply udtoolApply, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            toolService.editToolApply(udtoolApply, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addToolCHK 业务接口
     * 工具校准 新增保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addToolCHK", method = RequestMethod.POST)
    public Message addToolCHK(@RequestBody UdtoolChk udtoolChk,
                              @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = toolService.addToolCHK(udtoolChk, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editToolCHK 业务接口
     * 工具校准 编辑保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editToolCHK", method = RequestMethod.POST)
    public Message editToolCHK(@RequestBody UdtoolChk udtoolChk, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            toolService.editToolCHK(udtoolChk, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


}
