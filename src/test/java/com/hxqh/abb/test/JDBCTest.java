package com.hxqh.abb.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ocean Lin on 2017/5/5.
 */
public class JDBCTest {

    private JDBCTest() {
    }

    static {
        try {
            String driver = "com.ibm.db2.jcc.DB2Driver";
            // 装载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        } catch (Exception ex) {
            throw new RuntimeException("database driver load error");
        }
    }

    /**
     * 获取数据库连接
     *
     * @param url      url
     * @param user     用户名
     * @param password 密码
     * @return 数据库连接
     * @throws SQLException
     */
    public static Connection getConnection(String url, String user, String password) throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }


    /**
     * 释放数据库相关对象
     *
     * @param rs   结果集
     * @param st   声明
     * @param conn 连接
     */
    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        if (!conn.isClosed()) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCTest.getConnection("jdbc:db2://ip/db", "name", "passwd");
            st = conn.createStatement();
            String sql = "select * from asset";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
            System.out.println("test for connection correct");
        } catch (SQLException e) {
            // 添加日志记录该异常
            e.printStackTrace();
            System.out.println("test for connection exception");
        } finally {
            JDBCTest.free(rs, st, conn);
        }

    }
}
