package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.MXCipherXUtils;
import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Maxuser;
import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.CityDto;
import com.hxqh.abb.model.dto.action.IndexDto;
import com.hxqh.abb.model.dto.action.LoginDto;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.view.AbbLocation;
import com.hxqh.abb.model.view.AbbLogin;
import com.hxqh.abb.service.LocationService;
import com.hxqh.abb.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import psdi.util.MXException;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/index")
@SessionAttributes(value = "sessionInfo")
public class IndexController {
    @Autowired
    private SystemService systemService;
    @Resource
    private LocationService locationService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAuthorDetail() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Location> locationList = systemService.getLocationList();
        result.put("locationList", locationList);
        result.put("size", locationList.size());
        return new ModelAndView("/success", result);
    }

    /**
     * 返回页面4部分显示List
     *
     * @return
     * @Author lh
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public IndexDto systemMessage(@ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        IndexDto indexDto = null;
        try {
            indexDto = systemService.getSystemMessage(sessionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        indexDto.setTime(new Time(TimeUtil.getTime()));
        return indexDto;
    }


    /**
     * login  使用maxuser object
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(LoginDto loginDto, Map<String, Object> map) {
        List<AbbLogin> loginUserList = systemService.getLoginUserList(loginDto);
        return doLogin(loginUserList, loginDto, map);
    }

    private Message doLogin(List<AbbLogin> loginUserList, LoginDto loginDto, Map<String, Object> map) {
        Message message = new Message(0, "", false);
        Message success = new Message(1, "LoginSuccess", true);

        if (loginUserList.size() > 0) {
            String password = null;
            try {
                password = MXCipherXUtils.encodePwd(loginDto.getPassword());
                if (loginUserList.get(0).getPassword().toUpperCase().equals(password)) {
                    //加入Session中
                    AbbLogin login = loginUserList.get(0);
                    SessionInfo sessionInfo = new SessionInfo(login.getLoginid(), login.getDefsite(), " ", login.getDisplayname());
                    map.put("sessionInfo", sessionInfo);
                    return success;
                } else {
                    message.setMessage("密码不正确");
                    message.setSuccess(true);
                }
            } catch (MXException e) {
                e.printStackTrace();
                Message messageException = new Message(1, "异常", false);
                return messageException;
            }
        } else {
            message.setMessage("用户名不存在");
            message.setSuccess(true);
        }
        return message;
    }


    /**
     * 登录成功后跳转至index
     *
     * @return
     */
    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String goToIndex() {
        return "index/index";
    }


    /**
     * loginWebChat  微信后台开发
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginWebChat", method = RequestMethod.POST)
    public ModelAndView loginWebChat(LoginDto loginDto, Map<String, Object> map) {
        List<AbbLogin> loginUserList = systemService.getLoginUserList(loginDto);
        return webChatLogin(loginUserList, loginDto, map);
    }

    private ModelAndView webChatLogin(List<AbbLogin> loginUserList, LoginDto loginDto, Map<String, Object> map) {
        Map<String, Object> result = new HashMap<>();
        if (loginUserList.size() > 0) {
            String password = null;
            try {
                password = MXCipherXUtils.encodePwd(loginDto.getPassword());
                if (loginUserList.get(0).getPassword().toUpperCase().equals(password)) {
                    //加入Session中
                    AbbLogin login = loginUserList.get(0);
                    SessionInfo sessionInfo = new SessionInfo(login.getLoginid(), login.getDefsite(), " ", login.getDisplayname());
                    map.put("sessionInfo", sessionInfo);
                    return new ModelAndView("index/index");
                } else {
                    result.put("message", "密码不正确");
                    return new ModelAndView("weixin/fail", result);
                }
            } catch (MXException e) {
                result.put("message", "异常，请联系管理员！");
                e.printStackTrace();
                return new ModelAndView("weixin/fail", result);
            }
        } else {
            result.put("message", "用户名不存在");
            return new ModelAndView("weixin/fail", result);
        }
    }


    /**
     * test  微信后台开发测试
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(LoginDto loginDto, Map<String, Object> map) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "哈哈haha");
        return new ModelAndView("weixin/asset", result);
    }

    /**
     * webChat  微信登录后首页跳转
     *
     * @return
     */
    @RequestMapping(value = "/webChat", method = RequestMethod.GET)
    public String webChat() {
        return "weixin/asset";
    }



    /**
     * webChatData  微信登录后首页数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/webChatData", method = RequestMethod.GET)
    public List<AbbLocation> webChatData(LoginDto loginDto, Map<String, Object> map) {
        List<AbbLocation> abbLocationList = locationService.getRootList();
        return abbLocationList;
    }

    /**
     * cityList  cityList页跳转
     *
     * @return
     */
    @RequestMapping(value = "/cityList", method = RequestMethod.GET)
    public String cityList() {
        return "weixin/cityList";
    }

    /**
     * cityList  cityList页数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cityData", method = RequestMethod.GET)
    public CityDto cityData(@RequestParam("location") String location) {
        CityDto cityDto = locationService.getCityList(location);
        return cityDto;
    }

}
