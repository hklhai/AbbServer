package com.hxqh.abb.service;

import com.hxqh.abb.common.util.MXCipherXUtils;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.*;
import com.hxqh.abb.model.dto.IndexDto;
import com.hxqh.abb.model.dto.LoginDto;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("systemService")
public class SystemServiceImpl extends BaseServiceImpl<Object> implements SystemService {
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private AssetDao assetDao;
    @Autowired
    private WfassignmentDao wfassignmentDao;
    @Autowired
    private WorkorderDao workorderDao;
    @Autowired
    private MaxuserDao maxuserDao;

    public List<Location> getLocationList() {
        return locationDao.findAll();
    }

    @Override
    public long getAssetCount() {
        return assetDao.getCount();
    }

    @Override
    public List<Maxuser> getLoginUserList(LoginDto loginDto) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("loginid", loginDto.getLoginid());
        String where = "loginid=:loginid ";
        List<Maxuser> maxuserList = maxuserDao.findAll(where, params, null);
        return maxuserList;
    }

    /**
     * 获取主页显示内容
     *
     * @return
     */
    @Override
    public IndexDto getSystemMessage() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", BigDecimal.ZERO);
        List<Workorder> calendarList = workorderDao.findAll(0, 5, null, params, "order by workorderid desc");

        List<Asset> assetList = assetDao.findAll(0, 5, null, params, "order by assetuid desc");

        List<Workorder> workTaskList = workorderDao.findAll(0, 5, null, params, "order by workorderid desc");

        List<Wfassignment> wfassignmentList = wfassignmentDao.findAll(0, 5, null, params, "order by wfassignmentid desc");
        IndexDto indexDto = new IndexDto(calendarList, assetList, workTaskList, wfassignmentList);
        return indexDto;
    }


}
