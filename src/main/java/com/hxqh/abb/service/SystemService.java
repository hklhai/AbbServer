package com.hxqh.abb.service;

import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.dto.action.IndexDto;
import com.hxqh.abb.model.dto.action.LoginDto;
import com.hxqh.abb.model.view.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface SystemService {

    /*============================测试开始===========================*/
    List<Location> getLocationList();

    long getAssetCount();


    /*============================测试结束==========================*/

    List<AbbLogin> getLoginUserList(LoginDto loginDto);



    /*============================首页管理开始========================*/

    IndexDto getSystemMessage(SessionInfo sessionInfo) throws Exception;


    /*============================首页管理结束 =======================*/


    /*============================现场及设备地图开始===================*/

    AssetDto getAssetData(String location, SessionInfo sessionInfo);

    List<AbbAsset> getAssetByChild(String childname);

    List<AbbAssetSpec> getAssetSpec(String classstructureid);

    List<AbbAssetUdsparepart> getAssetUdspareparts(String classstructureid);

    List<AbbAssetHisMrecord> getAssetHistoryExecution(String classstructureid);

    List<AbbAssetHisWorkorder> getAssetHistoryWork(String classstructureid);

    List<AbbAssetHisAssetmeter> getAssetHistoryMonitor(String classstructureid);

    /*============================现场及设备地图结束 ==================*/


    /*============================微信 ==================*/

    String getWebsitPath();

    AbbAsset getAssetById(long assetuid);

    VPerson personData(String personid);

    void editPersonData(VPerson vPerson, SessionInfo sessionInfo);

    void saveFile(MultipartFile files, SessionInfo sessionInfo, Long personuid);

    /*============================微信==================*/

}
