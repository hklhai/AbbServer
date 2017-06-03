package com.hxqh.abb.common.util;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonTools {
    //此函数实现将对象以json的方式写到前台
    public static void writeJson(Object object, HttpServletResponse response) {
        try {
            String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
         * QuoteFieldNames———-输出key时是否使用双引号,默认为true
           WriteMapNullValue——–是否输出值为null的字段,默认为false
           WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
           WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
           WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
           WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
         */
    public static void writeJsonNullStringAsEmpty(Object object, HttpServletResponse response) {
        try {
            String json = JSONObject.toJSONString(object, SerializerFeature.WriteNullStringAsEmpty,
                    SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteMapNullValue, SerializerFeature.UseISO8601DateFormat);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJson(Object object) {
        String json = "Error";
        try {
            json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


}
