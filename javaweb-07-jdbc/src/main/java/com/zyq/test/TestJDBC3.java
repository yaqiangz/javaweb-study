package com.zyq.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC3 {
    @Test
    public void test() {
        String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "root";
        String password = "0314";

        // 1. 通过反射加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2. 连接数据库, 代表数据库
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            // 3. 通知数据库开启事务
            connection.setAutoCommit(false);
            String sql1 = "update account set money=money-100 where name='A'";
            connection.prepareStatement(sql1).executeUpdate();

            // 制造错误
//            int i = 1 / 0;

            String sql2 = "update account set money=money+100 where name='B'";
            connection.prepareStatement(sql2).executeUpdate();
            connection.commit();
            System.out.println("成功");
        } catch (SQLException e) {
            try {
                // 通知回滚事务
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
