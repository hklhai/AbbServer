package com.hxqh.abb.service;

import com.hxqh.abb.common.Page;
import com.hxqh.abb.dao.AbbInventorySiteDao;
import com.hxqh.abb.dao.AbbUdtoolDao;
import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.view.AbbInventorySite;
import com.hxqh.abb.model.view.AbbUdtool;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/5/10.
 */
@Transactional
@Service("toolService")
public class ToolServiceImpl extends BaseServiceImpl<Object> implements ToolService {
    @Autowired
    private AbbUdtoolDao udtoolDao;
    @Autowired
    private AbbInventorySiteDao siteDao;

    @Override
    public ToolDto getListData(Page page) throws Exception {
        List<AbbUdtool> udtoolList = udtoolDao.findAll(0, 15, null, null, " order by udtoolid desc");
        List<AbbInventorySite> siteList = siteDao.findAll();
        List<String> statusList = Arrays.asList(new String[]{"完好","维修"});
        page.setTotalPageNum((int) udtoolDao.getCount());
        ToolDto toolDto = new ToolDto(udtoolList,siteList,statusList,page);
        return toolDto;
    }

    @Override
    public List<AbbUdtool> getToolData(UdtoolDto udtoolDto, Page page) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuilder wherebuilder = new StringBuilder();
        wherebuilder.append("1=1 ");
        if (udtoolDto.getToolnum() != null && !"".equals(udtoolDto.getToolnum())) {
            wherebuilder.append("and TOOLNUM =").append(":TOOLNUM");
            params.put("TOOLNUM", udtoolDto.getToolnum());
        }
        if (udtoolDto.getDescription() != null && !"".equals(udtoolDto.getDescription())) {
            wherebuilder.append("and (DESCRIPTION Like '%'||").append(":DESCRIPTION").append("||'%' )");
            params.put("DESCRIPTION", udtoolDto.getDescription());
        }
        if (udtoolDto.getStatus() != null && !"".equals(udtoolDto.getStatus())) {
            wherebuilder.append("and STATUS =").append(":STATUS");
            params.put("STATUS", udtoolDto.getStatus());
        }
        if (udtoolDto.getDisplayname() != null && !"".equals(udtoolDto.getDisplayname())) {
            wherebuilder.append("and DISPLAYNAME =").append(":DISPLAYNAME");
            params.put("DISPLAYNAME", udtoolDto.getDisplayname());
        }
        if (udtoolDto.getLocationsite() != null && !"".equals(udtoolDto.getLocationsite())) {
            wherebuilder.append("and LOCATIONSITE =").append(":LOCATIONSITE");
            params.put("LOCATIONSITE", udtoolDto.getLocationsite());
        }
        List<AbbUdtool> udtoolList = udtoolDao.findAll(page.getThisPageFirstElementNumber(), page.getPageSize(), wherebuilder.toString(), params, " order by udtoolid desc");
        return udtoolList;
    }

}
