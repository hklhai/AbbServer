package com.hxqh.abb.service;

import com.hxqh.abb.model.User;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface UserService  {


    public abstract List<User> getUserList();

    public abstract void springResendCallbackMsg();
}
