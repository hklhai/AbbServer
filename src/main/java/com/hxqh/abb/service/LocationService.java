package com.hxqh.abb.service;

import com.hxqh.abb.common.Page;
import com.hxqh.abb.model.assist.LocationDto;
import com.hxqh.abb.model.dto.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.view.AbbInventory;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lh on 2017/5/6.
 */
public interface LocationService extends BaseService {




    /*============================设备与位置开始=========================*/
    public abstract List<LocationDto> getMapData() throws Exception;

    

    /*============================设备与位置结束 ========================*/




    /*============================库存管理开始===========================*/
    public abstract List<AbbInventory> getInventoryData(InventorySearchDto inventorySearchDto, Page page);

    public abstract InventoryDto inventoryListData();

    /*============================库存管理结束 ==========================*/






    /*============================工具管理开始===========================*/


    /*============================工具管理结束 ==========================*/

}
