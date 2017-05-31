package com.hxqh.abb.controller;

import com.alibaba.fastjson.JSON;
import com.hxqh.abb.axis2.WFSERVICEStub;
import com.hxqh.abb.axis2.WFSERVICEStub.WfservicewfGoOn;
import com.hxqh.abb.axis2.WFSERVICEStub.WfservicewfGoOnType;
import com.hxqh.abb.common.util.MXCipherXUtils;
import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.dao.WfassignmentDao;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Wfassignment;
import com.hxqh.abb.model.assist.InterfaceMessage;
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
import org.apache.axis2.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import psdi.util.MXException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/5/6.
 */

@Controller
@RequestMapping("/index")
@SessionAttributes(value = "sessionInfo")
public class IndexController {
    private static final String FAIL_MESSAGE = "您不是当前流程任务分配人，无权限操作";

    @Autowired
    private SystemService systemService;
    @Resource
    private LocationService locationService;
    @Resource
    private WfassignmentDao wfassignmentDao;

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
     * 注销，销毁Session 重定向至login
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("sessionInfo");
        session.invalidate();
        return "redirect:/login.jsp";
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
     * first 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first() {
        return "login";
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
                    //增加经纬度信息
                    sessionInfo.setLongitude(login.getLongitude());
                    sessionInfo.setDimension(login.getDimension());
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
    @Deprecated
    @ResponseBody
    @RequestMapping(value = "/cityData", method = RequestMethod.GET)
    public CityDto cityData(@RequestParam("location") String location) {
        CityDto cityDto = locationService.getCityList(location);
        List<AbbLocation> rootList = locationService.getRootList();
        for (AbbLocation loc : rootList) {
            loc.setDescription(loc.getDescription().substring(0, 2));
        }
        cityDto.setRootList(rootList);
        return cityDto;
    }


    /**
     * city页面加数据
     *
     * @return
     */
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ModelAndView city(@RequestParam("location") String location) {
        Map<String, Object> result = new HashMap<>();
        CityDto cityDto = locationService.getCityList(location);
        List<AbbLocation> rootList = locationService.getRootList();
        for (AbbLocation loc : rootList) {
            loc.setDescription(loc.getDescription().substring(0, 2));
        }
        cityDto.setRootList(rootList);

        result.put("cityDto", cityDto);
        return new ModelAndView("weixin/cityList", result);
    }

    /**
     * equip  equip页跳转
     *
     * @return
     */
    @RequestMapping(value = "/equip", method = RequestMethod.GET)
    public String equip() {
        return "weixin/equip";
    }

    /**
     * equip-detail  equip-detail页跳转
     *
     * @return
     */
    @RequestMapping(value = "/equipDetail", method = RequestMethod.GET)
    public String detail() {
        return "weixin/equipDetail";
    }

    /**
     * 审批接口数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public Message audit(@RequestParam("wfassignmentid") String wfassignmentid) {

        Wfassignment wfassignment = wfassignmentDao.find(Long.valueOf(wfassignmentid));
        WFSERVICEStub wfService = null;
        try {
            wfService = new WFSERVICEStub();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }

        //设置Param
        WFSERVICEStub.WfservicewfGoOn goOnService = new WfservicewfGoOn();
        WfservicewfGoOnType wfParam = new WfservicewfGoOnType();
        wfParam.setProcessname(wfassignment.getProcessname());//processname：流程名称
        wfParam.setMboName("WFASSIGNMENT");//mboName：当前记录所属的表名
        wfParam.setKeyValue(String.valueOf(wfassignment.getWfassignmentid()));// 当前表的唯一主键字段名，一般为表名+ID
        wfParam.setKey("WFASSIGNMENTID"); //唯一主键的值
        wfParam.setZx(1);//审批结果，1通过，0不通过
        wfParam.setDesc("同意调拨申请，lh测试使用");//desc：审批意见
        wfParam.setLoginid("MAXADMIN");  //当前登录人的ID

        goOnService.setWfservicewfGoOn(wfParam);
        String response = null;
        try {
            response = wfService.wfGoOn(goOnService).getWfservicewfGoOnResponse().get_return();
//            System.out.println("===================");
//            System.out.println(response);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (!JSON.parseObject(response, InterfaceMessage.class).getMassage().equals(FAIL_MESSAGE)) {

        }

        return null;
    }




}
