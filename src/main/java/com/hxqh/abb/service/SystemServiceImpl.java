package com.hxqh.abb.service;

import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Maxuser;
import com.hxqh.abb.model.dto.IndexDto;
import com.hxqh.abb.model.dto.LoginDto;
import com.hxqh.abb.model.view.AbbIndexAsset;
import com.hxqh.abb.model.view.AbbIndexWfassignment;
import com.hxqh.abb.model.view.AbbIndexWorkorder;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
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
    private MaxuserDao maxuserDao;
    @Autowired
    private AbbIndexWfassignmentDao abbindexwfassignmentDao;
    @Autowired
    private AbbIndexWorkorderDao abbindexworkorderDao;
    @Autowired
    private AbbIndexAssetDao abbindexassetDao;


    public List<Location> getLocationList() {
        return locationDao.findAll();
    }

    @Override
    public long getAssetCount() {
        return abbindexassetDao.getCount();
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
    public IndexDto getSystemMessage() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", BigDecimal.ZERO);
        List<AbbIndexWorkorder> calendarList = abbindexworkorderDao.findAll(0, 5, null, params, " order by workorderid desc");
        List<AbbIndexAsset> assetList = abbindexassetDao.findAll(0, 5, null, params, " order by assetuid desc");
        List<AbbIndexWfassignment> wfassignmentList = abbindexwfassignmentDao.findAll(0, 5, "startdate is not null and duedate is not null", params, " order by wfassignmentid desc");
        IndexDto indexDto = new IndexDto(calendarList, assetList, wfassignmentList);
        return indexDto;
    }




}
