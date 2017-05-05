package com.hxqh.abb.test;

import com.hxqh.abb.model.User;
import com.hxqh.abb.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */

//@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
    @Resource
    private UserService userService;

    //@Test
    public void testGetTestBook() {
        List<User> userList = userService.getUserList();
        Assert.assertEquals(3, userList.size());
    }

    @Test
    public void lower() {
        String str = "ABc";
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        str = sb.toString();

        System.out.println(str);

    }

}
