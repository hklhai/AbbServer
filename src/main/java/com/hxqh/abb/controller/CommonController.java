package com.hxqh.abb.controller;

import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.DetailDto;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */

@Controller
@RequestMapping("/common")
@SessionAttributes(value = "sessionInfo")
public class CommonController {

    private static Map<String, String> map = new HashMap<>();

    private final String title = "选择值";

    @Autowired
    private CommonService commonService;

    @PostConstruct
    public Map<String, String> initUrlMap() {

        map.put("WXUSER", "weixinApply/weixinDetail");    //微信用户申请列表主键
        map.put("WOTRACK", "exec/workOrder");    //工单信息主键
        map.put("UDWM", "inventory/wasteRecovery");    //废料回收列表主键
        map.put("UDVEHICEL", "site/carAccount");    //车辆台账列表主键
        map.put("UDVC", "site/carRequest");    //车辆申请信息主键
        map.put("UDTOOLLEND", "tool/borrowDetail");    //工具借还列表主键
        map.put("UDTOOLCHK", "tool/toolcheck");    //工具校准单列表主键
        map.put("UDTOOLAPPL", "tool/toolthrow");    //工具修丢废列表主键
        map.put("UDTOOL", "tool/toolDetail");    //工具台账列表主键
        map.put("UDPO", "inventory/purchase");    //采购清单列表主键
        map.put("RECEIPTS", "inventory/accept");    //接收列表主键
        map.put("UDOM", "inventory/oldRecovery");    //旧料回收列表主键
        map.put("UDRETURN", "inventory/refund");    //物资退库列表主键
        map.put("UDISSUE", "inventory/distribution");    //物资发放列表主键
        map.put("UDINVCHECK", "inventory/stockTaking");    //库存盘点列表主键
        map.put("UDTRANSFER", "inventory/allocation");    //备件调拨列表主键
        map.put("UDBEDAPPLY", "site/bedRequest");    //住宿申请列表主键
        map.put("UDBED", "site/bedAccount");    //住宿台账列表主键
        map.put("UDPROJECT", "project/projectDetail");    //无纸化项目 项目管理
        map.put("UDDELEGATE", "project/delegateDetail");    //无纸化项目 委派单
        map.put("UDSCENESER", "project/sceneServiceNotify");    //无纸化项目 现场服务通知
        map.put("UDPROINFO", "project/ServiceContact");    //无纸化项目 现场服务联络函
        map.put("UDPSM2", "project/WorkPermit");    //无纸化项目 项目现场服务安全工作许可单
        map.put("UDBOXCHECK", "project/outBoxCheck");    //无纸化项目 设备开箱检验
        map.put("UDTRAIN", "project/trainRecord");    //无纸化项目 现场培训记录
        map.put("UDSC", "project/SafeCheck");    //无纸化项目 现场服务安全检查
        map.put("UDENTRUST", "project/EntrustUnpacking");    //无纸化项目 现场设备委托开箱
        map.put("UDSAFE2", "project/safePlan");    //无纸化项目 项目安全计划(维保改造)
        map.put("UDNC", "project/nowCheck");    //无纸化项目 设备安装/调试/送电现场检查
        map.put("UDPM", "project/problemModify");    //无纸化项目 现场问题整改通知书
        map.put("UDAS", "project/areaAndService");    //无纸化项目 区域和服务中心经理管理
        map.put("UDWP", "project/workReport");    //无纸化项目 工作报告

        return map;
    }


    /**
     * List 公用
     *
     * @param apptname 传入VEHICLEACCOUNT,UDVC etc.
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam("apptname") String apptname) {
        Map<String, Object> result = new HashMap<>();
        List<TbApp> titles = commonService.getAppInfo(apptname);
        String title = commonService.getAppName(apptname).getAppchname().replaceAll("列表主键", "");
        if (title.equals("编号")) {
            title = "微信用户申请表";
        }
        result.put("titles", titles);
        result.put("title", title);
        result.put("apptname", apptname);
        result.put("urls", "/common/listData");
        return new ModelAndView("commons/listData", result);
    }


    /**
     * selection 公用
     *
     * @param apptname 传入VEHICLEACCOUNT,UDVC etc.
     * @return
     */
    @RequestMapping(value = "/selection", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selection(@RequestParam("apptname") String apptname) {
        Map<String, Object> result = new HashMap<>();
        List<TbApp> titles = commonService.getSelectionInfo(apptname);
//        String title = commonService.getAppName(apptname).getAppchname().replaceAll("列表主键", "");

        result.put("titles", titles);
        result.put("title", title);
        result.put("apptname", apptname);
        result.put("urls", "/common/listData");
        return result;
    }


    /**
     * List公用数据接口
     * 点击进入列表
     *
     * @param apptname   传入VEHICLEACCOUNT,UDVC etc.
     * @param isFavorite 字段名
     * @param searchs    查询列
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listData", method = RequestMethod.POST)
    public ListDto data(Page page,
                        @RequestParam("apptname") String apptname,
                        @RequestParam("isFavorite") String isFavorite,
                        @RequestParam("searchs") String searchs,
                        @ModelAttribute("sessionInfo") SessionInfo sessionInfo,
                        @RequestParam(name = "udapptype", required = false) String udapptype) {
        ListDto listData = null;
        try {
            listData = commonService.listData(page, apptname, isFavorite, searchs, sessionInfo, udapptype);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listData.setApptname(apptname);
        return listData;
    }

    /**
     * 点击列表行 进入详情
     *
     * @param apptname 传入VEHICLEACCOUNT,UDVC etc.
     * @param pkid     传入主键信息
     * @param operate  接受前端操作，并返回前端
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(@RequestParam("apptname") String apptname,
                               @RequestParam("pkid") String pkid,
                               @RequestParam("operate") String operate) {
        Map<String, Object> result = new HashMap<>();
        Map<String, String> urlMap = initUrlMap();
        result.put("apptname", apptname);
        result.put("pkid", pkid);
        result.put("operate", operate);
        return new ModelAndView(urlMap.get(apptname), result);
    }


    /**
     * detail公用数据接口 进入详情后 查询内容
     * 点击进入详情获取该条信息
     *
     * @param apptname 传入VEHICLEACCOUNT,UDVC etc.
     * @param pkid     传入主键信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detailData", method = RequestMethod.GET)
    public DetailDto detailData(@RequestParam("apptname") String apptname, @RequestParam("pkid") String pkid) {
        DetailDto data = null;
        try {
            data = commonService.detailData(apptname, pkid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * @param apptname    传入VEHICLEACCOUNT,UDVC etc.
     * @param favorites   传入将要搜藏或取消搜藏的主键
     * @param sessionInfo session信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/favorites", method = RequestMethod.POST)
    public Message favorites(@RequestParam("apptname") String apptname,
                             @RequestParam("favorites") String favorites,
                             @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = new Message(1, "Success", true);

        try {
            commonService.favorites(apptname, favorites, sessionInfo.getLoginId());
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(0, "Fail", false);
        }
        return message;
    }


}
