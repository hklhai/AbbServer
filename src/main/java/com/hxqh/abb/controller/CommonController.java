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

    @Autowired
    private CommonService commonService;

    @PostConstruct
    public Map<String, String> initUrlMap() {
        map.put("WXAPPLY", "weixinApply/applyDetail");    //微信用户申请列表主键
        map.put("WORKORDERMANAGEMENT", "exec/workOrder");    //工单信息主键
        map.put("WASTERECOVERY", "inventory/wasteRecovery");    //废料回收列表主键
        map.put("VEHICLEACCOUNT", "site/carAccount");    //车辆台账列表主键
        map.put("VEHICLEACAPPLY", "site/carRequest");    //车辆申请信息主键
        map.put("TOOLlEND", "tool/borrowDetail");    //工具借还列表主键
        map.put("TOOLCHK", "tool/toolcheck");    //工具校准单列表主键
        map.put("TOOLAPPLY", "tool/toolthrow");    //工具修丢废列表主键
        map.put("TOOLACCOUNT", "一期系统");    //工具台账列表主键
        map.put("PURCHASEODER", "inventory/purchase");    //采购清单列表主键
        map.put("PORECEIVE", "inventory/accept");    //接收列表主键
        map.put("OLDRECOVERY", "inventory/oldRecovery");    //旧料回收列表主键
        map.put("INVENTORYREFUND", "inventory/refund");    //物资退库列表主键
        map.put("INVENTORYGRANT", "inventory/distribution");    //物资发放列表主键
        map.put("INVENTORYCHK", "inventory/stockTaking");    //库存盘点列表主键
        map.put("INVENTORYALLOCATE", "inventory/allocation");    //备件调拨列表主键
        map.put("BEDAPPLY", "site/bedRequest");    //住宿申请列表主键
        map.put("BEDACCOUNT", "site/bedAccount");    //住宿台账列表主键

        return map;
    }


    /**
     * List 公用
     *
     * @param apptname 传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam("apptname") String apptname) {
        Map<String, Object> result = new HashMap<>();
        List<TbApp> titles = commonService.getAppInfo(apptname);
        String title = commonService.getAppName(apptname).getAppchname().replaceAll("列表主键", "");
        result.put("titles", titles);
        result.put("title", title);
        result.put("apptname", apptname);
        result.put("urls", "/common/listData");
        return new ModelAndView("commons/listData", result);
    }

    /**
     * List公用数据接口
     *
     * @param apptname   传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
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
                        @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        ListDto listData = null;
        try {
            listData = commonService.vehicleListData(page, apptname, isFavorite, searchs, sessionInfo.getLoginId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        listData.setApptname(apptname);
        return listData;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(@RequestParam("apptname") String apptname, @RequestParam("pkid") String pkid) {
        Map<String, Object> result = new HashMap<>();
        Map<String, String> urlMap = initUrlMap();
        result.put("apptname", apptname);
        result.put("pkid", pkid);
        return new ModelAndView(urlMap.get(apptname), result);
    }


    /**
     * List公用数据接口
     *
     * @param apptname 传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
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
     * @param apptname    传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
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
