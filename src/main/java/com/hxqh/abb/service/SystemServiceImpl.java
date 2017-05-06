package com.hxqh.abb.service;

import com.hxqh.abb.dao.AssetDao;
import com.hxqh.abb.dao.LocationDao;
import com.hxqh.abb.dao.WfassignmentDao;
import com.hxqh.abb.dao.WorkorderDao;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Wfassignment;
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


    public List<Location> getLocationList() {
        return locationDao.findAll();
    }

    @Override
    public long getAssetCount() {
        return assetDao.getCount();
    }

    @Override
    public List<Wfassignment> getSystemMessage() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        orderby.put("duedate", "ASC");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", BigDecimal.ZERO);
        List<Wfassignment> wfassignmentList= wfassignmentDao.findAll(0,5,"description = :description", params, "duedate ASC");
        return wfassignmentList;
    }


}
