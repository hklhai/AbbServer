package com.hxqh.abb.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Ocean Lin on 2017/5/28.
 */
public class TimeUtil {


    public static String getTime()
    {
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd ");
        stringBuilder.append(df.format(new Date()));
        //GregorianCalendar ca = new GregorianCalendar();
        //stringBuilder.append(0==ca.get(GregorianCalendar.AM_PM)?" am":" pm");
        return stringBuilder.toString();
    }

}
