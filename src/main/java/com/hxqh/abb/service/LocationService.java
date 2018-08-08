package com.hxqh.abb.service;

import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.CityDto;
import com.hxqh.abb.model.dto.action.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.version2.*;
import com.hxqh.abb.model.view.AbbLocation;

import java.util.List;

/**
 * Created by lh on 2017/5/6.
 */
public interface LocationService {


    /*============================设备与位置开始=========================*/
    List<AbbLocation> getRootList(SessionInfo sessionInfo);

    List<AbbLocation> getChildLocation(String location);
    /*============================设备与位置结束 ========================*/


    /*============================库存管理开始===========================*/
    InventoryDto getInventoryData(InventorySearchDto inventorySearchDto, Page page);

    InventoryDto inventoryListData(Page page);

    AbbLocation getParentLocation(String location);




    /*============================库存管理结束 ==========================*/


    /*============================微信位置开始===========================*/
    CityDto getCityList(String location);


    /*============================微信位置结束 ==========================*/


    /*============================二期开始 ==========================*/
    Long addInvuse(Invuse invuse, SessionInfo sessionInfo) throws Exception;

    Long addUdinvcheck(Udinvcheck udinvcheck, SessionInfo sessionInfo) throws Exception;

    Long addPo(Po po, SessionInfo sessionInfo) throws Exception;

    Long addPoreceive(Po po, SessionInfo sessionInfo) throws Exception;

    void editInvuse(Invuse invuse, SessionInfo sessionInfo) throws Exception;

    void editPo(Po po, SessionInfo sessionInfo) throws Exception;

    void editUdinvcheck(Udinvcheck udinvcheck, SessionInfo sessionInfo) throws Exception;

    void editPoreceive(Po po, SessionInfo sessionInfo) throws Exception;

    List<AbbLocation> getRootList();


    /*============================二期开始 ==========================*/


}
