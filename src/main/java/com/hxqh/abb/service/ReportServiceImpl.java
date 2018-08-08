package com.hxqh.abb.service;

import com.hxqh.abb.dao.TbReportDao;
import com.hxqh.abb.model.TbReport;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by fuyg.
 */

@Transactional
@Service("reportService")
public class ReportServiceImpl implements ReportService{

    @Autowired
    private TbReportDao tbReportDao;

    @Override
    public TbReport reportData(String apptname, SessionInfo sessionInfo) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("appname", apptname);
        params.put("isparameters", (long)0);
        String where = "appname=:appname and isparameters=:isparameters";
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("ordernum", "asc");
        List<TbReport> list = tbReportDao.findAll(where, params, orderby);
        if(list==null||list.size()<=0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public ListDto statsReportListData(Page page, String apptname, String searchs, SessionInfo sessionInfo) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("appname", apptname);
        params.put("isparameters", (long)1);
        String where = "appname=:appname and isparameters=:isparameters";
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("ordernum", "asc");
        List<TbReport> list = tbReportDao.findAll(where, params, orderby);
        return new ListDto(list, page);
    }
}
