package com.zyq.test;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "root";
        String password = "0314";

        // 1. 通过反射加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 连接数据库, 代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 编写SQL
        String sql = "insert into mybatis.users (id, `name`, `password`, email, birthday) values (?,?,?,?,?)";
        // 4. 预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 9);
        preparedStatement.setString(2, "赵六");
        preparedStatement.setString(3, "123456");
        preparedStatement.setString(4, "zl@qq.com");
        preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));
        // 5. 执行SQL
        int i = preparedStatement.executeUpdate();
        if (i > 0)
            System.out.println("插入成功");
        // 6. 关闭连接, 释放资源, 先开后关
        connection.close();
    }
}
