package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.FastJsonTools;
import com.hxqh.abb.common.util.MXCipherXUtils;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Maxuser;
import com.hxqh.abb.model.dto.IndexDto;
import com.hxqh.abb.model.dto.LoginDto;
import com.hxqh.abb.model.dto.Message;
import com.hxqh.abb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import psdi.util.MXException;

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
     * 返回页面4部分显示List
     * @Author lh
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public IndexDto systemMessage() {
        IndexDto indexDto = systemService.getSystemMessage();
        return indexDto;
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
        String password = httpServletRequest.getParameter("password");
        LoginDto loginDto = new LoginDto(loginid,password);
        List<Maxuser> loginUserList =  systemService.getLoginUserList(loginDto);

        Message message=doLogin(loginUserList,loginDto);
        FastJsonTools.writeJson(message,httpServletResponse);
        return new ModelAndView("/success",result);
    }

    private Message doLogin(List<Maxuser> loginUserList,LoginDto loginDto) {
        Message message = new Message(0,"",false);
        Message success = new Message(1,"LoginSuccess",true);

        if(loginUserList.size()>0)
        {
            String password = null;
            try {
                password = MXCipherXUtils.encodePwd(loginDto.getPassword());
                if(loginUserList.get(0).getPassword().toUpperCase().equals(password))
                {
                    return success;
                }else
                {
                    message.setMessage("密码不正确");
                    message.setSuccess(true);
                }
            } catch (MXException e) {
                e.printStackTrace();
                Message messageException = new Message(1,"异常",false);
                return messageException;
            }
        }else {
            message.setMessage("用户名不存在");
            message.setSuccess(true);
        }
        return  message;
    }


    /**
     * 登录成功后跳转至index
     * @return
     */
    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String goToIndex() {
        return "index/index";
    }

}
