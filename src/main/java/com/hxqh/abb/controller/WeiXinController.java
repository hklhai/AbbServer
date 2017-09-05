package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.version2.Wxuser;
import com.hxqh.abb.service.WeiXinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Ocean lin on 2017/9/5.
 */

@Controller
@RequestMapping("/weixin")
@SessionAttributes(value = "sessionInfo")
public class WeiXinController {

    @Autowired
    private WeiXinService weiXinService;

    /**
     * addWxuser 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addWxuser", method = RequestMethod.GET)
    public Message addWxuser(Wxuser wxuser) {
        Message message = null;
        try {
            weiXinService.addWxuser(wxuser);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * eidtWxuser 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/eidtWxuser", method = RequestMethod.GET)
    public Message eidtWxuser(Wxuser wxuser) {
        Message message = null;
        try {
            weiXinService.eidtWxuser(wxuser);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

}
