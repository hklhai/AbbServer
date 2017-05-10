package com.hxqh.abb.service;

import com.hxqh.abb.common.util.BeanUtilEx;
import com.hxqh.abb.dao.AssetDao;
import com.hxqh.abb.dao.LocationDao;
import com.hxqh.abb.model.Asset;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.assist.AssetDto;
import com.hxqh.abb.model.assist.LocationDto;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("locationService")
public class LocationServiceImpl extends BaseServiceImpl<Object> implements LocationService{

    @Autowired
    private LocationDao locationDao;

    @Override
    public List<LocationDto> getMapData() throws Exception {
        List<Location> locationList = locationDao.findAll(0, 15, null, null, " order by locationsid desc");
        List<LocationDto> locationDtoList = new ArrayList<>();
        copy2LocationDto(locationList,locationDtoList);
        return locationDtoList;
    }


    private void copy2LocationDto(List<Location> locationList, List<LocationDto> locationDtoList) throws Exception  {
        for (int i = 0; i < locationList.size(); i++) {
            LocationDto locationDto = new LocationDto();
            BeanUtilEx.copyProperties(locationDto, locationList.get(i));
            locationDtoList.add(locationDto);
        }
    }
}
