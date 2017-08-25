package com.hxqh.abb.service;

import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.User;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface UserService {

    List<User> getUserList();

    ListDto vehicleListData(Page page, String apptname, String fields, String searchs) throws Exception;

    List<TbApp> getAppInfo(String apptname);

}
