package com.hxqh.abb.service;

import com.hxqh.abb.model.User;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */
public interface UserService extends BaseService {


    public abstract List<User> getUserList();
}
