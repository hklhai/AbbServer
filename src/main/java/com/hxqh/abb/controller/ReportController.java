package com.hxqh.abb.controller;

/**
 * Created by Administrator on 2017-11-16.
 */

import com.hxqh.abb.model.TbReport;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuyg on 2017-11-16.
 */
@Controller
@RequestMapping("/report")
@SessionAttributes(value = "sessionInfo")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 表单报表获取数据接口
     *
     * @param apptname
     * @param sessionInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reportData", method = RequestMethod.POST)
    public TbReport reportData(@RequestParam("apptname") String apptname,
                               @ModelAttribute("sessionInfo") SessionInfo sessionInfo){
        TbReport tbReport = null;
        try {
            tbReport = reportService.reportData(apptname, sessionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbReport;
    }

    /**
     * 统计报表获取数据接口
     *
     * @param page
     * @param apptname
     * @param searchs
     * @param sessionInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/statsReportData", method = RequestMethod.POST)
    public ListDto statsReportData(Page page,
                                  @RequestParam("apptname") String apptname,
                                  @RequestParam("searchs") String searchs,
                                  @ModelAttribute("sessionInfo") SessionInfo sessionInfo){
        ListDto listData = null;
        try {
            listData = reportService.statsReportListData(page,apptname,searchs,sessionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listData.setApptname(apptname);
        return listData;
    }

    @RequestMapping(value = "/reportParamPage", method = RequestMethod.GET)
    public ModelAndView Redirect2ParameterPage(@RequestParam("baseTableName") String baseTableName,
                                               @RequestParam("reportfolder") String reportfolder,
                                               @RequestParam("reportname") String reportname,
                                               @RequestParam("parametersPage") String parametersPage) {
        Map<String, Object> result = new HashMap<String, Object>();
        StringBuffer sbf = new StringBuffer();
        sbf.append("/frameset?__report=").append(reportfolder).append("/").append(reportname);
        result.put("reportaction",sbf.toString());
        return new ModelAndView("reportparam/"+parametersPage, result);
    }
}
