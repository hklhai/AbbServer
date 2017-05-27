package com.hxqh.abb.service;

import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Maxuser;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.dto.action.IndexDto;
import com.hxqh.abb.model.dto.action.LoginDto;
import com.hxqh.abb.model.view.*;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Resource
    private AbbAssetLocationDao abbassetlocationDao;
    @Resource
    private AbbAssetDao abbassetDao;
    @Resource
    private AbbLoginDao abbloginDao;


    @Value(value = "${com.hxqh.abb.websitepath}")
    private String websitepath;

    public List<Location> getLocationList() {
        return locationDao.findAll();
    }

    @Override
    public long getAssetCount() {
        return abbindexassetDao.getCount();
    }

    @Override
    public List<AbbLogin> getLoginUserList(LoginDto loginDto) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("loginid", loginDto.getLoginid());
        String where = "loginid=:loginid ";
        List<AbbLogin> maxuserList = abbloginDao.findAll(where, params, null);
        return maxuserList;
    }

    /**
     * 获取主页显示内容
     *
     * @return
     */
    @Override
    public IndexDto getSystemMessage(SessionInfo sessionInfo) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("siteid", sessionInfo.getSiteid());
        List<AbbIndexWorkorder> calendarList = abbindexworkorderDao.findAll(0, 5, " siteid=:siteid ", params, " order by workorderid desc");
        List<AbbIndexAsset> assetList = abbindexassetDao.findAll(0, 5, " siteid=:siteid ", params, " order by assetuid desc");
        List<AbbIndexWfassignment> wfassignmentList = abbindexwfassignmentDao.findAll(0, 5, "startdate is not null and duedate is not null", params, " order by wfassignmentid desc");
        IndexDto indexDto = new IndexDto(calendarList, assetList, wfassignmentList,sessionInfo);
        return indexDto;
    }

    @Override
    public AssetDto getAssetData(String location) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("location",location);
        List<AbbAsset> abbAssetList = abbassetDao.findAll(0, 15, "location=:location", params, " order by assetuid desc");
        List<AbbAssetLocation> abbAssetLocationList = abbassetlocationDao.findAll(0, 15, "location=:location", params, " order by locationsid desc");
        AssetDto assetDto =new AssetDto(abbAssetList,abbAssetLocationList.get(0));
        return assetDto;
    }

    @Override
    public String getWebsitPath()
    {
        return websitepath;
    }


}
