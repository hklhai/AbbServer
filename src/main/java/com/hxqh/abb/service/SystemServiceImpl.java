package com.hxqh.abb.service;

import com.hxqh.abb.common.util.BeanUtilEx;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.*;
import com.hxqh.abb.model.assist.AssetDto;
import com.hxqh.abb.model.assist.WfassignmentDto;
import com.hxqh.abb.model.assist.WorkorderDto;
import com.hxqh.abb.model.dto.IndexDto;
import com.hxqh.abb.model.dto.LoginDto;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    public IndexDto getSystemMessage() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", BigDecimal.ZERO);
        List<Workorder> calendarList = workorderDao.findAll(0, 5, null, params, " order by workorderid desc");
        List<Asset> assetList = assetDao.findAll(0, 5, null, params, " order by assetuid desc");
        List<Wfassignment> wfassignmentList = wfassignmentDao.findAll(0, 5, "startdate is not null and duedate is not null", params, " order by wfassignmentid desc");
        List<WorkorderDto> workorderDtoList = new ArrayList<>();
        List<WfassignmentDto> wfassignmentDtoList = new ArrayList<>();
        List<AssetDto> assetDtoList = new ArrayList<>();
        //拷贝至Dto
        Cpoy2CalendarDto(calendarList, workorderDtoList);
        Cpoy2WfassignmentDto(wfassignmentList, wfassignmentDtoList);
        Cpoy2AssetDto(assetList, assetDtoList);

        IndexDto indexDto = new IndexDto(workorderDtoList, assetDtoList, wfassignmentDtoList);
        return indexDto;
    }


    private void Cpoy2AssetDto(List<Asset> assetList, List<AssetDto> assetDtoList) throws Exception  {
        for (int i = 0; i < assetList.size(); i++) {
            AssetDto assetDto = new AssetDto();
            BeanUtilEx.copyProperties(assetDto, assetList.get(i));
            assetDtoList.add(assetDto);
        }
    }

    private void Cpoy2WfassignmentDto(List<Wfassignment> wfassignmentList, List<WfassignmentDto> wfassignmentDtoList) throws Exception {
        for (int i = 0; i < wfassignmentList.size(); i++) {
            WfassignmentDto wfassignmentDto = new WfassignmentDto();
            BeanUtilEx.copyProperties(wfassignmentDto, wfassignmentList.get(i));
            wfassignmentDtoList.add(wfassignmentDto);
        }
    }

    private void Cpoy2CalendarDto(List calendarList, List workorderDtoList) throws Exception {
        for (int i = 0; i < calendarList.size(); i++) {
            WorkorderDto workorderDto = new WorkorderDto();
            BeanUtilEx.copyProperties(workorderDto, calendarList.get(i));
            workorderDtoList.add(workorderDto);
        }
    }


}
