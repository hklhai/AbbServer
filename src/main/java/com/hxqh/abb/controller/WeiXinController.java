package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.dao.WxuserDao;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.version2.Wxuser;
import com.hxqh.abb.service.WeiXinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ocean lin on 2017/9/5.
 */

@Controller
@RequestMapping("/weixin")
@SessionAttributes(value = "sessionInfo")
public class WeiXinController {

    @Autowired
    private WeiXinService weiXinService;
    @Autowired
    private WxuserDao wxuserDao;


    /**
     * addWeixinUser 业务接口
     * 工具台账
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addWeixinUser", method = RequestMethod.POST)
    public Message addWeixinUser(@RequestBody Wxuser wxuser, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = weiXinService.addWeixinUser(wxuser, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * editWxuser 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editWeixinUser", method = RequestMethod.POST)
    public Message editWxuser(@RequestBody Wxuser wxuser, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            weiXinService.editWxuser(wxuser, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

}
