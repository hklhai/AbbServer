package com.hxqh.abb.controller;

import com.alibaba.fastjson.JSON;
import com.hxqh.abb.axis2.APPAUTHStub;
import com.hxqh.abb.axis2.WFSERVICEStub;
import com.hxqh.abb.axis2.WFSERVICEStub.WfservicewfGoOn;
import com.hxqh.abb.axis2.WFSERVICEStub.WfservicewfGoOnType;
import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.common.util.MXCipherXUtils;
import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Menu;
import com.hxqh.abb.model.Relation;
import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.assist.InterfaceMessage;
import com.hxqh.abb.model.assist.MaximoMessage;
import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.AppDto;
import com.hxqh.abb.model.dto.action.CityDto;
import com.hxqh.abb.model.dto.action.IndexDto;
import com.hxqh.abb.model.dto.action.LoginDto;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.view.AbbLocation;
import com.hxqh.abb.model.view.AbbLogin;
import com.hxqh.abb.model.view.VPerson;
import com.hxqh.abb.service.CommonService;
import com.hxqh.abb.service.LocationService;
import com.hxqh.abb.service.StationService;
import com.hxqh.abb.service.SystemService;
import org.apache.axis2.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.ArrayList;
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

    private static Map<String, String> workFlowMap = new HashMap<>();

    private static final String FAIL_MESSAGE = "您不是当前流程任务分配人，无权限操作";

    private static final String SERVER_ENGINEER = "服务工程师";

    @Autowired
    private SystemService systemService;
    @Resource
    private LocationService locationService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private StationService stationService;


    @PostConstruct
    public Map<String, String> initUrlMap() {
        workFlowMap.put("WXUSER", "UDWXUSER");                  //微信用户申请
        workFlowMap.put("WOTRACK", "UDWORKORDE");    //工单管理
        workFlowMap.put("UDWM", "UDWM");                //废料回收
        workFlowMap.put("UDVC", "UDVEHAPPLY");         //车辆申请信息主键
        workFlowMap.put("UDTOOLLEND", "UDTOOLLEND");               //工具借还
        workFlowMap.put("UDTOOLAPPL", "UDTOOLAPPL");              //工具修丢废
        workFlowMap.put("UDPO", "UDPO");                 //采购清单
        workFlowMap.put("UDOM", "UDOM");                  //旧料回收
        workFlowMap.put("UDRETURN", "UDRETURN");          //物资退库
        workFlowMap.put("UDISSUE", "UDISSUE");            //物资发放
        workFlowMap.put("UDINVCHECK", "UDINVCHECK");           //库存盘点
        workFlowMap.put("UDTRANSFER", "UDINVUSE");        //备件调拨
        workFlowMap.put("UDBEDAPPLY", "UDBEDAPPLY");               //住宿申请列表主键

        workFlowMap.put("UDPROJECT", "UDPRO");               //项目管理
        workFlowMap.put("UDSC", "UDSAFECHEC");               //现场服务安全检查
        workFlowMap.put("UDPM", "UDPROBLEM");               //现场问题整改通知书
        workFlowMap.put("UDWP", "UDWP");               //工作报告

        return workFlowMap;
    }

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
    public Message login(LoginDto loginDto, Map<String, Object> workFlowMap) {
        List<AbbLogin> loginUserList = systemService.getLoginUserList(loginDto);
        return doLogin(loginUserList, loginDto, workFlowMap);
    }

    private Message doLogin(List<AbbLogin> loginUserList, LoginDto loginDto, Map<String, Object> workFlowMap) {
        Message message = new Message(0, "", false);
        Message success = new Message(1, "LoginSuccess", true);

        if (loginUserList.size() > 0) {
            String password = null;
            try {
                password = MXCipherXUtils.encodePwd(loginDto.getPassword());
                if (loginUserList.get(0).getPassword().toUpperCase().equals(password)) {
                    //加入Session中
                    AbbLogin login = loginUserList.get(0);
                    //2017-9-7 10:25:20  梁经理确认ORGID统一使用ABB
                    SessionInfo sessionInfo = new SessionInfo(login.getLoginid(), login.getSiteid(), "ABB", login.getDisplayname());
                    sessionInfo.setLongitude(login.getLongitude());
                    sessionInfo.setDimension(login.getDimension());
                    //加入location
                    sessionInfo.setLocation(login.getLocation());
                    //changeby  changeby
                    sessionInfo.setOrg("ABB");
                    sessionInfo.setCreate(login.getPersonid());
                    //个别存在locationsite值为null
                    sessionInfo.setSite(login.getLocationsite());
                    sessionInfo.setCountry(login.getCountry());
                    String title = login.getTitle();
                    if (title != null)
                        sessionInfo.setTitle(title);
                    else
                        sessionInfo.setTitle(SERVER_ENGINEER);

                    workFlowMap.put("sessionInfo", sessionInfo);
                    return success;
                } else {
                    message.setMessage("密码不正确");
                    message.setSuccess(true);
                }
            } catch (Exception e) {
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
    public ModelAndView goToIndex(@ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Map<String, Object> result = new HashMap<>();
        result.put("loginId", sessionInfo.getDisplayname());
        result.put("siteId", sessionInfo.getSite());
        result.put("title", sessionInfo.getTitle());
        result.put("personid", sessionInfo.getCreate());
        result.put("country", sessionInfo.getCountry());
        // 查询权限

        List<AppDto> appList = new ArrayList<>();
        APPAUTHStub appauthStub = null;
        try {
            appauthStub = new APPAUTHStub();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        //设置Param
        APPAUTHStub.AppauthgetUserApp appauthgetUserApp = new APPAUTHStub.AppauthgetUserApp();
        APPAUTHStub.AppauthgetUserAppType appuserParam = new APPAUTHStub.AppauthgetUserAppType();

        /*****************************设置参数********************************/
        appuserParam.setUsername(sessionInfo.getLoginId());
        /*****************************设置参数********************************/
        appauthgetUserApp.setAppauthgetUserApp(appuserParam);

        try {
            String response = appauthStub.getUserApp(appauthgetUserApp).getAppauthgetUserAppResponse().get_return();

            appList = JSON.parseArray(response, AppDto.class);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Map<String, List<Menu>> menuMap = stationService.getMenuMap(appList);
        result.put("privilege", menuMap);

        return new ModelAndView("index/nav", result);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index/index";
    }

    /**
     * first 登录页面
     */
    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first() {
        return "login";
    }

    /**
     * loginWebChat  微信后台开发
     */
    @RequestMapping(value = "/loginWebChat", method = RequestMethod.GET)
    public String loginWebChat(LoginDto loginDto, Map<String, Object> workFlowMap) {
        List<AbbLogin> loginUserList = systemService.getLoginUserList(loginDto);
        return webChatLogin(loginUserList, loginDto, workFlowMap);
    }

    private String webChatLogin(List<AbbLogin> loginUserList, LoginDto loginDto, Map<String, Object> workFlowMap) {
        Map<String, Object> result = new HashMap<>();
        if (loginUserList.size() > 0) {
            String password = null;
            try {
                password = MXCipherXUtils.encodePwd(loginDto.getPassword());
                if (loginUserList.get(0).getPassword().toUpperCase().equals(password)) {
                    //加入Session中
                    AbbLogin login = loginUserList.get(0);
                    SessionInfo sessionInfo = new SessionInfo(login.getLoginid(), login.getSiteid(), " ", login.getDisplayname());
                    //增加经纬度信息
                    sessionInfo.setLongitude(login.getLongitude());
                    sessionInfo.setDimension(login.getDimension());
                    //加入location
                    sessionInfo.setLocation(login.getLocation());
                    workFlowMap.put("sessionInfo", sessionInfo);
                    return "weixin/asset";
                } else {
                    result.put("message", "密码不正确");
                    return "weixin/fail";
                }
            } catch (Exception e) {
                result.put("message", "异常，请联系管理员！");
                e.printStackTrace();
                return "weixin/fail";
            }
        } else {
            result.put("message", "用户名不存在");
            return "weixin/fail";
        }
    }


    /**
     * test  微信后台开发测试
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(LoginDto loginDto, Map<String, Object> workFlowMap) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "哈哈haha");
        return new ModelAndView("weixin/asset", result);
    }

    /**
     * webChat  微信登录后首页跳转
     */
    @RequestMapping(value = "/webChat", method = RequestMethod.GET)
    public String webChat() {
        return "weixin/asset";
    }


    /**
     * webChatData  微信登录后首页数据接口
     */
    @ResponseBody
    @RequestMapping(value = "/webChatData", method = RequestMethod.GET)
    public List<AbbLocation> webChatData(LoginDto loginDto, Map<String, Object> workFlowMap) {
        List<AbbLocation> abbLocationList = locationService.getRootList();
        return abbLocationList;
    }

    /**
     * cityList  cityList页跳转
     */
    @RequestMapping(value = "/cityList", method = RequestMethod.GET)
    public String cityList() {
        return "weixin/cityList";
    }

    /**
     * cityList  cityList页数据接口
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


    // TODO: 2017/10/31   pkid        主表主键值待确认

    /**
     * 审批
     *
     * @param pkid        主表主键值
     * @param auditDes    审核意见
     * @param sessionInfo
     * @param apptname    APP名称
     * @param isPass      审批结果，1通过，0不通过
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public Message audit(@RequestParam("pkid") String pkid,
                         @RequestParam(name = "auditDes", required = false) String auditDes,
                         @ModelAttribute("sessionInfo") SessionInfo sessionInfo,
                         @RequestParam(name = "apptname", required = false) String apptname,
                         @RequestParam(name = "isPass", required = false) Integer isPass) {

        // TODO: 2017/10/27 判断下一审批人与当前登录人是都一致
        Message message = new Message(IConstants.SUCCESS, IConstants.AUDITSUCCESS);
        WFSERVICEStub wfService = null;
        try {
            wfService = new WFSERVICEStub();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }

        //获取appname
        TbApp appName = commonService.getAppName(apptname);

        /*****************************设置参数********************************/
        //设置Param
        WFSERVICEStub.WfservicewfGoOn goOnService = new WfservicewfGoOn();
        WfservicewfGoOnType wfParam = new WfservicewfGoOnType();
        wfParam.setProcessname(workFlowMap.get(apptname));  //processname：流程名称
        wfParam.setMboName(appName.getApptable());           //mboName：当前记录所属的表名
        wfParam.setKeyValue(pkid);                           //主键值
        wfParam.setKey(appName.getAppfield());               //主键属性名
        wfParam.setZx(isPass == null ? 1 : isPass);          //审批结果，1通过，0不通过
        wfParam.setDesc(auditDes == null ? "同意调拨申请" : auditDes);//desc：审批意见
        wfParam.setLoginid(sessionInfo.getLoginId());       //当前登录人的ID
        /*****************************设置参数********************************/


        goOnService.setWfservicewfGoOn(wfParam);
        String response = null;
        try {
            response = wfService.wfGoOn(goOnService).getWfservicewfGoOnResponse().get_return();
//            System.out.println(response);
            // 将返回消息反序列化
            MaximoMessage maximoMessage = JSON.parseObject(response, MaximoMessage.class);
            message.setMessage(getMessage(maximoMessage));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (!JSON.parseObject(response, InterfaceMessage.class).getMassage().equals(FAIL_MESSAGE)) {
            message.setCode(IConstants.FAIL);
            message.setMessage(IConstants.AUDITFAIL);
            return message;
        }
        return message;
    }


    /**
     * 启动工作流
     *
     * @param pkid        主键值
     * @param apptname    应用名称
     * @param sessionInfo Session信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/startWF", method = RequestMethod.POST)
    public Message startWF(@RequestParam("pkid") String pkid,
                           @RequestParam("apptname") String apptname,
                           @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = new Message(IConstants.SUCCESS, IConstants.STARTWFSUCCESS);
        WFSERVICEStub wfService = null;
        try {
            wfService = new WFSERVICEStub();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        //设置Param
        WFSERVICEStub.WfservicestartWF2 wfservicestartWF2 = new WFSERVICEStub.WfservicestartWF2();
        WFSERVICEStub.WfservicestartWF2Type wfParam = new WFSERVICEStub.WfservicestartWF2Type();

        //获取appname
        TbApp appName = commonService.getAppName(apptname);
        String appTable = appName.getApptable();
        if (appTable != null && appTable.contains("PAPERLESS_")) {
            appTable = appTable.replace("PAPERLESS_", "");
        }
        /*****************************设置参数********************************/
        wfParam.setProcessname(workFlowMap.get(apptname));//processname：流程名称
        wfParam.setMbo(appTable);
        wfParam.setKeyValue(pkid);              //主键值
        wfParam.setKey(appName.getAppfield());  //唯一主键名称
        wfParam.setLoginid(sessionInfo.getLoginId());  //当前登录人的ID

        /*****************************设置参数********************************/

        wfservicestartWF2.setWfservicestartWF2(wfParam);
        String response = new String();
        try {
            response = wfService.startWF2(wfservicestartWF2).getWfservicestartWF2Response().get_return();
            System.out.println(response);
            // 将返回消息反序列化
            MaximoMessage maximoMessage = JSON.parseObject(response, MaximoMessage.class);
            message.setMessage(getMessage(maximoMessage));
        } catch (Exception e) {
            e.printStackTrace();
            message.setCode(IConstants.FAIL);
            message.setMessage(IConstants.STARTWFFAIL);
            return message;
        }
        return message;
    }

    private String getMessage(MaximoMessage maximoMessage) {
        String m = new String();
        if (maximoMessage.getMsg() != null) {
            m = maximoMessage.getMsg();
        } else if (maximoMessage.getMassage() != null) {
            m = maximoMessage.getMassage();
        } else if (maximoMessage.getErrorMsg() != null) {
            m = maximoMessage.getErrorMsg();
        } else if (maximoMessage.getStatus() != null) {
            m = maximoMessage.getStatus();
        }
        return m;
    }


    /**
     * 交互逻辑：返回状态1，启动发送工作流
     * 返回状态0，启动审批工作流
     *
     * @param pkid     主键
     * @param apptname 应用名
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/isStartWF", method = RequestMethod.POST)
    public Message isStartWF(@RequestParam("pkid") String pkid,
                             @RequestParam("apptname") String apptname) {
        Message message = new Message(IConstants.SUCCESS, IConstants.ISSTARTWF);

        List<Relation> relationList = commonService.getRelativeMap(apptname);
        List<Relation> childList = new ArrayList<>();
        Relation audit = commonService.nextAuditor(relationList, childList);
        //审批记录
        try {
            List aList = commonService.auditRecord(pkid, audit);
            if (aList.size() < 1) {
                return message;
            } else {
                message.setCode(IConstants.FAIL);
                message.setMessage(IConstants.ISNOTSTARTWF);
                return message;
            }
        } catch (Exception e) {
            message.setCode(IConstants.FAIL);
            message.setMessage(IConstants.STARTWFERROR);
        }
        return message;
    }


    /**
     * 用户中心数接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/personData", method = RequestMethod.GET)
    public VPerson personData(@RequestParam("personid") String personid) {
        VPerson vPerson = systemService.personData(personid);
        return vPerson;
    }


    /**
     * 编辑用户中心
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editPersonData", method = RequestMethod.POST)
    public Message editPersonData(VPerson vPerson, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            systemService.editPersonData(vPerson, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * @param files       上传文件
     * @param sessionInfo 用户信息，服务端提供
     * @param personuid   用户唯一主键
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public Message uploadfileUpload(@RequestParam("files") MultipartFile files,
                                    @ModelAttribute("sessionInfo") SessionInfo sessionInfo,
                                    @RequestParam("personuid") Long personuid) {
        Message message = null;
        try {
            systemService.saveFile(files, sessionInfo, personuid);
            message = new Message(IConstants.SUCCESS, IConstants.UPLOADSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.UPLOADFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


}