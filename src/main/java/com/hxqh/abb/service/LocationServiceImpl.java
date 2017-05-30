package com.hxqh.abb.service;

import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.dto.action.CityDto;
import com.hxqh.abb.model.dto.action.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.view.*;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("locationService")
public class LocationServiceImpl extends BaseServiceImpl<Object> implements LocationService {

    @Autowired
    private AbbInventoryDao abbinventoryDao;
    @Autowired
    private AbbInventorySiteDao siteDao;
    @Autowired
    private AbbInventoryItemDao itemDao;
    @Autowired
    private AbbInventoryLocationDao abbInventoryLocationDao;
    @Autowired
    private AbbLocationDao abbLocationDao;

    @Override
    public List<AbbLocation> getRootList() {
        List<AbbLocation> abbLocations = abbLocationDao.findAll("parent is null", null, null);
        return abbLocations;
    }

    @Override
    public List<AbbLocation> getChildLocation(String location) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("location", location);
        String where = "parent=:location";
        List<AbbLocation> childList = abbLocationDao.findAll(where, params, null);
        return childList;
    }


    @Override
    public InventoryDto getInventoryData(InventorySearchDto searchInventoryDto, Page page) {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuilder wherebuilder = new StringBuilder();
        wherebuilder.append("1=1 ");
        if (searchInventoryDto.getSiteid() != null && !"".equals(searchInventoryDto.getSiteid())) {
            wherebuilder.append(" and SITEID =").append(":SITEID");
            params.put("SITEID", searchInventoryDto.getSiteid());
        }
        if (searchInventoryDto.getDescription() != null && !"".equals(searchInventoryDto.getDescription())) {
            wherebuilder.append(" and (DESCRIPTION Like '%'||").append(":DESCRIPTION").append("||'%' )");
            params.put("DESCRIPTION", searchInventoryDto.getDescription());
        }
        if (searchInventoryDto.getLocation() != null && !"".equals(searchInventoryDto.getLocation())) {
            wherebuilder.append(" and LOCATION =").append(":LOCATION");
            params.put("LOCATION", searchInventoryDto.getLocation());
        }
        if (searchInventoryDto.getUdsapnum() != null && !"".equals(searchInventoryDto.getUdsapnum())) {
            wherebuilder.append(" and UDSAPNUM =").append(":UDSAPNUM");
            params.put("UDSAPNUM", searchInventoryDto.getUdsapnum());
        }
        if (searchInventoryDto.getCurbal() != null && !"".equals(searchInventoryDto.getCurbal())) {
            wherebuilder.append(" and CURBAL =").append(":CURBAL");
            params.put("CURBAL", searchInventoryDto.getCurbal());
        }
        List<AbbInventory> inventoryList = abbinventoryDao.findAll(page.getThisPageFirstElementNumber() - 1, page.getPageSize(), wherebuilder.toString(), params, " order by inventoryid desc");
        page.setTotalPageNum((int) abbinventoryDao.getCount(wherebuilder.toString(), params));
        InventoryDto inventoryDto = new InventoryDto(inventoryList,page);
        return inventoryDto;
    }

    @Override
    public InventoryDto inventoryListData(Page page) {
        List<AbbInventory> inventoryList = abbinventoryDao.findAll(0, 15, null, null, " order by inventoryid desc");
        List<AbbInventoryLocation> locationList = abbInventoryLocationDao.findAll();
        List<AbbInventorySite> siteList = siteDao.findAll();
        List<AbbInventoryItem> itemList = itemDao.findAll();
        page.setTotalPageNum((int) abbinventoryDao.getCount());
        InventoryDto inventoryDto = new InventoryDto(inventoryList, siteList, locationList, itemList, page);
        return inventoryDto;
    }

    @Override
    public AbbLocation getParentLocation(String location) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("location", location);
        String where = "location=:location";
        List<AbbLocation> childList = abbLocationDao.findAll(where, params, null);
        params.put("location", childList.get(0).getParent());
        List<AbbLocation> parent = abbLocationDao.findAll(where, params, null);
        return parent.get(0);
    }

    @Override
    public CityDto getCityList(String location) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("location", location);
        String where = "location=:location";
        List<AbbLocation> abbLocations = abbLocationDao.findAll(where, params, null);

        String whereChild = "parent=:location";
        List<AbbLocation> childList = abbLocationDao.findAll(whereChild, params, null);
        CityDto cityDto = new CityDto(childList,abbLocations.get(0));
        return cityDto;
    }


}
