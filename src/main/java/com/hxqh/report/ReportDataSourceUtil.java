package com.hxqh.report;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2017-12-08.
 */
public class ReportDataSourceUtil {
    private static final Map dateSouce = new HashMap<String,Object>();

    static {
        try {
            Properties properties = new Properties();
            InputStream is = ReportDataSourceUtil.class.getResourceAsStream("/config.properties");
            properties.load(is);

            String host = properties.getProperty("jdbc.host");
            String port = properties.getProperty("jdbc.port");
            String database = properties.getProperty("jdbc.database");
            String user = properties.getProperty("jdbc.user");
            String password = properties.getProperty("jdbc.password");
            String driver = properties.getProperty("jdbc.driver");
            if(host!=null&&port!=null&&database!=null&&user!=null&&password!=null&&driver!=null){
                String url = "jdbc:db2://"+host+":"+port+"/"+database;
                dateSouce.put("url",url);
                dateSouce.put("driver",driver);
                dateSouce.put("username",user);
                dateSouce.put("password",password);
                dateSouce.put("schemaowner",user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(final String key) {
        final String ret = (String)dateSouce.get(key);
        return ret;
    }

    public static Map getDateSouceMap() {
        return dateSouce;
    }
}
