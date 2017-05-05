package com.hxqh.abb.service;

import com.hxqh.abb.model.Location;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */
public interface SystemService extends BaseService {


    public abstract List<Location> getLocationList();

    public abstract long getAssetCount();


}
