package com.hxqh.abb.test;

import com.alibaba.fastjson.JSON;
import com.hxqh.abb.model.User;
import com.hxqh.abb.model.assist.InterfaceMessage;
import com.hxqh.abb.service.UserService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */

//@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
    @Resource
    private UserService userService;

    @Test
    public void json() {
        String j = "{\"massage\":\"您不是当前流程任务分配人，无权限操作\"} ";
        InterfaceMessage message= JSON.parseObject(j, InterfaceMessage.class);
        System.out.println(message.getMassage());
    }


    //@Test
    public void testGetTestBook() {
        List<User> userList = userService.getUserList();
        Assert.assertEquals(3, userList.size());
    }

    //@Test
    public void lower() {
        String str = "ABc";
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        str = sb.toString();

        System.out.println(str);
    }

    //@Test
    public void convert() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            //方法一
            tsStr = sdf.format(ts);
            System.out.println(tsStr);
//            //方法二
//            tsStr = ts.toString();
//            System.out.println(tsStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
