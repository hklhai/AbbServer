package com.hxqh.abb.service;

import com.hxqh.abb.model.TbReport;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.paperless.*;
import com.hxqh.abb.model.searchdto.Page;
/**
 * Created by fuyg.
 */
public interface ReportService {

    TbReport reportData(String apptname, SessionInfo sessionInfo) throws Exception;

    ListDto statsReportListData(Page page, String apptname, String searchs, SessionInfo sessionInfo) throws Exception;
}
