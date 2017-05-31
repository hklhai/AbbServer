package com.hxqh.abb.service;

import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.dto.action.Calendar;
import com.hxqh.abb.model.dto.action.IndexDto;
import com.hxqh.abb.model.dto.action.LoginDto;
import com.hxqh.abb.model.view.*;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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
        List<AbbIndexWorkorder> calendarList = abbindexworkorderDao.findAll(0, 5, "targstartdate is not null", null, " order by workorderid desc");
        List<AbbIndexAsset> assetList = abbindexassetDao.findAll(0, 4, " siteid=:siteid ", params, " order by assetuid desc");
        List<AbbIndexWfassignment> wfassignmentList = abbindexwfassignmentDao.findAll(0, 5, "startdate is not null and duedate is not null", params, " order by wfassignmentid desc");
        //增加对Calendar处理
        List<Calendar> calendar = process(calendarList);

        IndexDto indexDto = new IndexDto(calendarList, assetList, wfassignmentList, sessionInfo,calendar);
        return indexDto;
    }

    private  List<Calendar> process(List<AbbIndexWorkorder> calendarList) {
        //先放入Map中
        Map<Date, List<String>> map = new HashMap<>();
        Set<Map.Entry<Date, List<String>>> entries = map.entrySet();
        for (AbbIndexWorkorder cal : calendarList) {
            List<String> wList = new ArrayList<>();

            if (map.size() == 0&&cal.getTargstartdate()!=null) {
                wList.add(cal.getWonum());
                map.put(cal.getTargstartdate(), wList);
            } else {
                for (Map.Entry<Date, List<String>> entry : entries) {
                    if(DateUtils.isSameDay(cal.getTargstartdate(),entry.getKey()))
                    {
                        entry.getValue().add(cal.getWonum());
                    }else {
                        wList.add(cal.getWonum());
                        map.put(cal.getTargstartdate(), wList);
                    }
                }
            }
        }

        List<Calendar> calendar = new ArrayList<>();
        for (Map.Entry<Date, List<String>> entry : entries) {
            Calendar c = new Calendar(entry.getKey(),entry.getValue());
            calendar.add(c);
        }
        return calendar;
    }


    @Override
    public AssetDto getAssetData(String location) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("location", location);
        List<AbbAsset> abbAssetList = abbassetDao.findAll(0, 15, "location=:location", params, " order by assetuid desc");
        List<AbbAssetLocation> abbAssetLocationList = abbassetlocationDao.findAll(0, 15, "location=:location", params, " order by locationsid desc");
        AssetDto assetDto = new AssetDto(abbAssetList, abbAssetLocationList.get(0));
        return assetDto;
    }

    @Override
    public String getWebsitPath() {
        return websitepath;
    }

    @Override
    public AbbAsset getAssetById(long assetuid) {
        return abbassetDao.find(assetuid);
    }


}
