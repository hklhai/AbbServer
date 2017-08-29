package com.hxqh.abb.controller;

import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.service.StationService;
import com.hxqh.abb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */

@Controller
@RequestMapping("/common")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showRegionMap", method = RequestMethod.GET)
    public String showRegionMap() {
        Map<String, Object> result = new HashMap<>();
        return "/login";
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
        List<TbApp> titles = userService.getAppInfo(apptname);
        String title = userService.getAppName(apptname).getAppchname().replaceAll("列表主键", "");
        result.put("titles", titles);
        result.put("title", title);
        result.put("apptname", apptname);
        result.put("urls", "/common/listData");
        return new ModelAndView("commons/listData", result);
    }

    /**
     * List公用数据接口
     *
     * @param apptname 传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
     * @param fields   字段名
     * @param searchs  查询列
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listData", method = RequestMethod.GET)
    public ListDto data(Page page,
                        @RequestParam("apptname") String apptname,
                        @RequestParam("fields") String fields,
                        @RequestParam("searchs") String searchs) {
        ListDto listData = null;
        try {
            listData = userService.vehicleListData(page, apptname, fields, searchs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listData.setApptname(apptname);
        return listData;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(@RequestParam("apptname") String apptname, @RequestParam("pkid") String pkid) {
        Map<String, Object> result = new HashMap<>();
        result.put("apptname", apptname);
        result.put("pkid", pkid);
        return new ModelAndView("tool/lenddetail", result);
    }


    /**
     * List公用数据接口
     *
     * @param apptname 传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
     * @param pkid 传入主键信息 etc.
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detailData", method = RequestMethod.GET)
    public Object detailData(@RequestParam("apptname") String apptname, @RequestParam("pkid") String pkid) {
        Object data = null;
        try {
            data = userService.detailData( apptname, pkid );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
