package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.model.Workorder;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.service.ExecutiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ocean lin on 2017/9/5.
 */
@Controller
@RequestMapping("/executive")
@SessionAttributes(value = "sessionInfo")
public class ExecutiveController {

    @Autowired
    private ExecutiveService executiveService;

    /**
     * addWorkOrder 业务接口
     * 执行管理 新建保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addWorkOrder", method = RequestMethod.POST)
    public Message addPoreceive(Workorder workorder, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = executiveService.addWorkOrder(workorder, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * editWorkOrder 业务接口
     * 执行管理 编辑保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editWorkOrder", method = RequestMethod.POST)
    public Message editWorkOrder(@RequestBody Workorder workorder, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = new Message(IConstants.FAIL, IConstants.EDITNOMATCHCREATE);
        try {
            Long aLong = executiveService.editWorkOrder(workorder, sessionInfo);
            if (aLong == -2L)
                return message;
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message.setMessage(IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


}
