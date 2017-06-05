package com.hxqh.abb.service;

import com.hxqh.abb.dao.UserDao;
import com.hxqh.abb.model.User;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<Object> implements UserService{
    @Autowired
    private UserDao userDao;

    public List<User> getUserList(){
        return userDao.findAll();
    }


    /**
     *
     */
    public void springResendCallbackMsg()
    {
        //TODO
        //定时任务

    }

}
