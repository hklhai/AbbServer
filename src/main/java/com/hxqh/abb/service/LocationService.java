package com.hxqh.abb.service;

import com.hxqh.abb.model.dto.action.CityDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.dto.action.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.view.AbbInventory;
import com.hxqh.abb.model.view.AbbLocation;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lh on 2017/5/6.
 */
public interface LocationService extends BaseService {




    /*============================设备与位置开始=========================*/
    public abstract List<AbbLocation> getRootList();

    public abstract List<AbbLocation>  getChildLocation(String location);
    /*============================设备与位置结束 ========================*/


    /*============================库存管理开始===========================*/
    public abstract List<AbbInventory> getInventoryData(InventorySearchDto inventorySearchDto, Page page);

    public abstract InventoryDto inventoryListData(Page page);

    public abstract AbbLocation getParentLocation(String location);




    /*============================库存管理结束 ==========================*/





    /*============================微信位置开始===========================*/
    public abstract CityDto getCityList(String location);

    /*============================微信位置结束 ==========================*/

}
