package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.FastJsonTools;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Maxuser;
import com.hxqh.abb.model.Wfassignment;
import com.hxqh.abb.model.dto.LoginDto;
import com.hxqh.abb.model.dto.Message;
import com.hxqh.abb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAuthorDetail() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Location> locationList = systemService.getLocationList();
        result.put("locationList", locationList);
        result.put("size",locationList.size());
        return new ModelAndView("/success",result);
    }

    /**
     * 获取系统通知
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ModelAndView systemMessage() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Wfassignment> systemMessageList = systemService.getSystemMessage();
        String json = FastJsonTools.getJson(systemMessageList);
        result.put("message",json);
        return new ModelAndView("/success",result);
    }


    /**
     * login  使用maxuser object
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> result = new HashMap<String, Object>();
        String loginid = httpServletRequest.getParameter("loginid");
        String userid = httpServletRequest.getParameter("userid");
        LoginDto loginDto = new LoginDto(loginid,userid);

        List<Maxuser> loginUserList = systemService.getLoginUserList(loginDto);
        Message message=doLogin(loginUserList);
        FastJsonTools.writeJson(message,httpServletResponse);
        return new ModelAndView("/success",result);

    }

    private Message doLogin(List<Maxuser> loginUserList) {
        Message message = new Message(0,"");
        if(loginUserList.size()>0)
        {
            message.setCode(1);
        }else {
            message.setMessage("用户名或密码错误");
        }
        return  message;
    }


}
