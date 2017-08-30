package com.hxqh.abb.service;

import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.User;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.DetailDto;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface UserService {

    List<User> getUserList();

    ListDto vehicleListData(Page page, String apptname, String fields, String searchs, String loginId) throws Exception;

    List<TbApp> getAppInfo(String apptname);

    TbApp getAppName(String apptname);

    DetailDto detailData(String apptname, String pkid) throws Exception;

    void favorites(String apptname, String favorites, String loginId) throws Exception;

    ListDto favoritesData(Page page, String apptname, String loginId) throws Exception;
}
