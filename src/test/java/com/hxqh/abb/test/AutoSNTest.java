package com.hxqh.abb.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ocean lin on 2017/10/27.
 */
public class AutoSNTest {


    @Test
    public void testByte() {
        byte[] b = "Hello World".getBytes();
        System.out.println(b);
    }

    @Test
    public void test() {
//        List<Long> ids = Arrays.asList(1l, 50l, 700l, 9000l);
//
//        Assert.assertEquals(formatSN(ids.get(0)), "20171027001");
//        Assert.assertEquals(formatSN(ids.get(1)), "20171027050");
//        Assert.assertEquals(formatSN(ids.get(2)), "20171027700");
//        Assert.assertEquals(formatSN(ids.get(3)), "20171027900");
    }

    /**
     * 输出yyyyMMdd+"主键号" （如果主键号小于100，前补0）
     *
     * @param aLong 传入参数为主键
     * @return
     */
    private String formatSN(Long aLong) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMdd");
        if (String.valueOf(aLong).length() > 3) {
            return dateFormat.format(new Date()) + String.valueOf(aLong).substring(0, 3);
        } else {
            return dateFormat.format(new Date()) + String.format("%03d", aLong);
        }
    }

}
