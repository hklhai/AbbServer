package com.hxqh.abb.service;

import com.hxqh.abb.dao.AssetDao;
import com.hxqh.abb.dao.LocationDao;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("locationService")
public class LocationServiceImpl extends BaseServiceImpl<Object> implements LocationService{



}
