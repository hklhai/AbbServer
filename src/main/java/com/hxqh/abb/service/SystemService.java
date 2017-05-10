package com.hxqh.abb.service;

import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Maxuser;
import com.hxqh.abb.model.dto.IndexDto;
import com.hxqh.abb.model.dto.LoginDto;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface SystemService extends BaseService {

    /*============================测试开始===========================*/
    public abstract List<Location> getLocationList();

    public abstract long getAssetCount();


    /*============================测试结束==========================*/

    public abstract List<Maxuser> getLoginUserList(LoginDto loginDto) ;



    /*============================首页管理开始========================*/

    public abstract IndexDto getSystemMessage() throws Exception;



    /*============================首页管理结束 =======================*/


    /*============================现场及设备地图开始===================*/



    /*============================现场及设备地图结束 ==================*/




}
