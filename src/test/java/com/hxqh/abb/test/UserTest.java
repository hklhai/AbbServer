package com.hxqh.abb.test;

import com.alibaba.fastjson.JSON;
import com.hxqh.abb.model.User;
import com.hxqh.abb.model.assist.InterfaceMessage;
import com.hxqh.abb.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
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
        InterfaceMessage message = JSON.parseObject(j, InterfaceMessage.class);
        //System.out.println(message.getMassage());
    }


    @Test
    public void conNull() {
    }


    /**
     * 把 VO 中所有属性为 null 的转为 ""
     *
     * @throws ApplicationException
     */
    public void nullConverNullString(Object obj) throws ApplicationException {
        if (obj != null) {

            Class classz = obj.getClass();
        // 获取所有该对象的属性值
            Field fields[] = classz.getDeclaredFields();

        // 遍历属性值，取得所有属性为 null 值的
            for (Field field : fields) {
                try {
                    Type t = field.getGenericType();
                    if (!t.toString().equals("boolean")) {
                        Method m = classz.getMethod("get"
                                + change(field.getName()));
                        Object name = m.invoke(obj);// 调用该字段的get方法
                        if (name == null) {
                            Method mtd = classz.getMethod("set"
                                            + change(field.getName()),
                                    new Class[]{String.class});// 取得所需类的方法对象
                            mtd.invoke(obj, new Object[]{""});// 执行相应赋值方法
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param src 源字符串
     * @return 字符串，将src的第一个字母转换为大写，src为空时返回null
     */
    public static String change(String src) {
        if (src != null) {
            StringBuffer sb = new StringBuffer(src);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return sb.toString();
        } else {
            return null;
        }
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
