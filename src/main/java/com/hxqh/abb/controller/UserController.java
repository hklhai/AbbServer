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
        Map<String, Object> result = new HashMap<String, Object>();
        List<TbApp> titles = userService.getAppInfo(apptname);
        result.put("titles", titles);
        result.put("apptname", apptname);
        result.put("urls", "/common/listData");
        return new ModelAndView("commonFunc/commonlist", result);
    }

    /**
     * List公用数据接口
     *
     * @param page     分页参数
     * @param apptname 传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
     * @param apptable 表名
     * @param pkid     主键名
     * @param fields   字段名
     * @param searchs  查询列
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "/listData", method = RequestMethod.POST)
//    public ListDto data(Page page,
//                     @RequestParam("apptname") String apptname,
//                     @RequestParam("apptable") String apptable,
//                     @RequestParam("pkid") String pkid,
//                     @RequestParam("fields") String fields,
//                     @RequestParam("searchs") String searchs) {
//        ListDto listData = null;
//        try {
//            listData = userService.vehicleListData(page, apptname, apptable, pkid, fields, searchs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listData;
//    }

    /**
     * List公用数据接口
     *
     * @param apptname 传入VEHICLEACCOUNT,VEHICLEACAPPLY etc.
     * @param apptable 表名
     * @param pkid     主键名
     * @param fields   字段名
     * @param searchs  查询列
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listData", method = RequestMethod.GET)
    public ListDto data(
                        @RequestParam("apptname") String apptname,
                        @RequestParam("apptable") String apptable,
                        @RequestParam("pkid") String pkid,
                        @RequestParam("fields") String fields,
                        @RequestParam("searchs") String searchs) {
        ListDto listData = null;
        Page page = new Page();
        page.setPageNumber(1);
        page.setPageSize(15);
        try {
            listData = userService.vehicleListData(page, apptname, apptable, pkid, fields, searchs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }


}
